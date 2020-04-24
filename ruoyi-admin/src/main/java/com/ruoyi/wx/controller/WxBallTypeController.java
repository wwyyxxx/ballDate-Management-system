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
import com.ruoyi.wx.domain.WxBallType;
import com.ruoyi.wx.service.IWxBallTypeService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 球类Controller
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/wx/type")
public class WxBallTypeController extends BaseController
{
    private String prefix = "wx/type";

    @Autowired
    private IWxBallTypeService wxBallTypeService;

    @RequiresPermissions("wx:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/type";
    }

    /**
     * 查询球类列表
     */
//    @RequiresPermissions("wx:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxBallType wxBallType)
    {
        startPage();
        List<WxBallType> list = wxBallTypeService.selectWxBallTypeList(wxBallType);
        return getDataTable(list);
    }

    /**
     * 导出球类列表
     */
    @RequiresPermissions("wx:type:export")
    @Log(title = "球类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxBallType wxBallType)
    {
        List<WxBallType> list = wxBallTypeService.selectWxBallTypeList(wxBallType);
        ExcelUtil<WxBallType> util = new ExcelUtil<WxBallType>(WxBallType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增球类
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存球类
     */
    @RequiresPermissions("wx:type:add")
    @Log(title = "球类", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxBallType wxBallType)
    {
        return toAjax(wxBallTypeService.insertWxBallType(wxBallType));
    }

    /**
     * 修改球类
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxBallType wxBallType = wxBallTypeService.selectWxBallTypeById(id);
        mmap.put("wxBallType", wxBallType);
        return prefix + "/edit";
    }

    /**
     * 修改保存球类
     */
    @RequiresPermissions("wx:type:edit")
    @Log(title = "球类", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxBallType wxBallType)
    {
        return toAjax(wxBallTypeService.updateWxBallType(wxBallType));
    }

    /**
     * 删除球类
     */
    @RequiresPermissions("wx:type:remove")
    @Log(title = "球类", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxBallTypeService.deleteWxBallTypeByIds(ids));
    }
}
