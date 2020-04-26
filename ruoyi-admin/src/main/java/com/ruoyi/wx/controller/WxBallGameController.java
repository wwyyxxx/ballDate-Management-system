package com.ruoyi.wx.controller;

import java.util.List;

import com.ruoyi.wx.service.IWxUserGameService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.wx.domain.WxBallGame;
import com.ruoyi.wx.service.IWxBallGameService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 球局Controller
 * 
 * @author xys
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/wx/game")
public class WxBallGameController extends BaseController
{
    private String prefix = "wx/game";

    @Autowired
    private IWxBallGameService wxBallGameService;

    @RequiresPermissions("wx:game:view")
    @GetMapping()
    public String game()
    {
        return prefix + "/game";
    }

    /**
     * 查询球局列表
     */
//    @RequiresPermissions("wx:game:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody(required = false) WxBallGame wxBallGame)
    {
        startPage();
        List<WxBallGame> list = wxBallGameService.selectWxBallGameList(wxBallGame);
        return getDataTable(list);
    }

    /**
     * 导出球局列表
     */
    @RequiresPermissions("wx:game:export")
    @Log(title = "球局", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxBallGame wxBallGame)
    {
        List<WxBallGame> list = wxBallGameService.selectWxBallGameList(wxBallGame);
        ExcelUtil<WxBallGame> util = new ExcelUtil<WxBallGame>(WxBallGame.class);
        return util.exportExcel(list, "game");
    }

    /**
     * 新增球局
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存球局
     */
//    @RequiresPermissions("wx:game:add")
    @Log(title = "球局", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody WxBallGame wxBallGame)
    {
        return toAjax(wxBallGameService.insertWxBallGame(wxBallGame));
    }

    /**
     * 修改球局
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        WxBallGame wxBallGame = wxBallGameService.selectWxBallGameById(id);
        mmap.put("wxBallGame", wxBallGame);
        return prefix + "/edit";
    }

    /**
     * 修改保存球局
     */
//    @RequiresPermissions("wx:game:edit")
    @Log(title = "球局", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody WxBallGame wxBallGame)
    {
        return toAjax(wxBallGameService.updateWxBallGame(wxBallGame));
    }

    /**
     * 删除球局
     */
//    @RequiresPermissions("wx:game:remove")
    @Log(title = "球局", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(wxBallGameService.deleteWxBallGameByIds(ids));
    }
}
