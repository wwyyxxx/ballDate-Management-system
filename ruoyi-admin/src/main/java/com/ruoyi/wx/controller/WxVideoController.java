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
import com.ruoyi.wx.domain.WxVideo;
import com.ruoyi.wx.service.IWxVideoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 视频Controller
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/wx/video")
public class WxVideoController extends BaseController
{
    private String prefix = "wx/video";

    @Autowired
    private IWxVideoService wxVideoService;

    @RequiresPermissions("wx:video:view")
    @GetMapping()
    public String video()
    {
        return prefix + "/video";
    }

    /**
     * 查询视频列表
     */
    @RequiresPermissions("wx:video:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxVideo wxVideo)
    {
        startPage();
        List<WxVideo> list = wxVideoService.selectWxVideoList(wxVideo);
        return getDataTable(list);
    }

    /**
     * 导出视频列表
     */
    @RequiresPermissions("wx:video:export")
    @Log(title = "视频", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxVideo wxVideo)
    {
        List<WxVideo> list = wxVideoService.selectWxVideoList(wxVideo);
        ExcelUtil<WxVideo> util = new ExcelUtil<WxVideo>(WxVideo.class);
        return util.exportExcel(list, "video");
    }

    /**
     * 新增视频
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存视频
     */
    @RequiresPermissions("wx:video:add")
    @Log(title = "视频", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(WxVideo wxVideo)
    {
        return toAjax(wxVideoService.insertWxVideo(wxVideo));
    }

    /**
     * 修改视频
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxVideo wxVideo = wxVideoService.selectWxVideoById(id);
        mmap.put("wxVideo", wxVideo);
        return prefix + "/edit";
    }

    /**
     * 修改保存视频
     */
    @RequiresPermissions("wx:video:edit")
    @Log(title = "视频", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxVideo wxVideo)
    {
        return toAjax(wxVideoService.updateWxVideo(wxVideo));
    }

    /**
     * 删除视频
     */
    @RequiresPermissions("wx:video:remove")
    @Log(title = "视频", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxVideoService.deleteWxVideoByIds(ids));
    }
}
