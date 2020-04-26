package com.ruoyi.web.controller.wx;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wx.domain.WxUserGame;
import com.ruoyi.wx.service.IWxUserGameService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 报名模块Controller
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/wx/participate")
public class WxUserGameController extends BaseController
{
    private String prefix = "wx/participate";

    @Autowired
    private IWxUserGameService wxUserGameService;

    @RequiresPermissions("wx:participate:view")
    @GetMapping()
    public String participate()
    {
        return prefix + "/participate";
    }

    /**
     * 查询报名模块列表
     */
    @RequiresPermissions("wx:participate:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxUserGame wxUserGame)
    {
        startPage();
        List<WxUserGame> list = wxUserGameService.selectWxUserGameList(wxUserGame);
        return getDataTable(list);
    }

    /**
     * 导出报名模块列表
     */
    @RequiresPermissions("wx:participate:export")
    @Log(title = "报名模块", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxUserGame wxUserGame)
    {
        List<WxUserGame> list = wxUserGameService.selectWxUserGameList(wxUserGame);
        ExcelUtil<WxUserGame> util = new ExcelUtil<WxUserGame>(WxUserGame.class);
        return util.exportExcel(list, "participate");
    }

    /**
     * 新增报名模块
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存报名模块
     */
//    @RequiresPermissions("wx:participate:add")
    @Log(title = "报名模块", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody WxUserGame wxUserGame)
    {
        return toAjax(wxUserGameService.insertWxUserGame(wxUserGame));
    }

    /**
     * 修改报名模块
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxUserGame wxUserGame = wxUserGameService.selectWxUserGameById(id);
        mmap.put("wxUserGame", wxUserGame);
        return prefix + "/edit";
    }

    /**
     * 修改保存报名模块
     */
//    @RequiresPermissions("wx:participate:edit")
    @Log(title = "报名模块", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody WxUserGame wxUserGame)
    {
        return toAjax(wxUserGameService.updateWxUserGame(wxUserGame));
    }

    /**
     * 删除报名模块
     */
//    @RequiresPermissions("wx:participate:remove")
    @Log(title = "报名模块", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxUserGameService.deleteWxUserGameByIds(ids));
    }
}
