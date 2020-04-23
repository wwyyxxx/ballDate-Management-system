package com.ruoyi.wx.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wx.domain.WxFeedback;
import com.ruoyi.wx.service.IWxFeedbackService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户反馈Controller
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/wx/feedback")
public class WxFeedbackController extends BaseController
{
    private String prefix = "wx/feedback";

    @Autowired
    private IWxFeedbackService wxFeedbackService;

    @RequiresPermissions("wx:feedback:view")
    @GetMapping()
    public String feedback()
    {
        return prefix + "/feedback";
    }

    /**
     * 查询用户反馈列表
     */
    @RequiresPermissions("wx:feedback:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxFeedback wxFeedback)
    {
        startPage();
        List<WxFeedback> list = wxFeedbackService.selectWxFeedbackList(wxFeedback);
        return getDataTable(list);
    }

    /**
     * 导出用户反馈列表
     */
    @RequiresPermissions("wx:feedback:export")
    @Log(title = "用户反馈", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxFeedback wxFeedback)
    {
        List<WxFeedback> list = wxFeedbackService.selectWxFeedbackList(wxFeedback);
        ExcelUtil<WxFeedback> util = new ExcelUtil<WxFeedback>(WxFeedback.class);
        return util.exportExcel(list, "feedback");
    }

    /**
     * 新增用户反馈
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户反馈
     */
    @RequiresPermissions("wx:feedback:add")
    @Log(title = "用户反馈", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxFeedback wxFeedback)
    {
        return toAjax(wxFeedbackService.insertWxFeedback(wxFeedback));
    }

    /**
     * 修改用户反馈
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxFeedback wxFeedback = wxFeedbackService.selectWxFeedbackById(id);
        mmap.put("wxFeedback", wxFeedback);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户反馈
     */
    @RequiresPermissions("wx:feedback:edit")
    @Log(title = "用户反馈", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxFeedback wxFeedback)
    {
        return toAjax(wxFeedbackService.updateWxFeedback(wxFeedback));
    }

    /**
     * 删除用户反馈
     */
    @RequiresPermissions("wx:feedback:remove")
    @Log(title = "用户反馈", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxFeedbackService.deleteWxFeedbackByIds(ids));
    }
}
