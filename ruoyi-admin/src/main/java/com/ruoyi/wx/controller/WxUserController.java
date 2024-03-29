package com.ruoyi.wx.controller;

import java.util.List;

import com.github.binarywang.java.emoji.EmojiConverter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.ruoyi.common.config.Global;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.wx.domain.WxUser;
import com.ruoyi.wx.service.IWxUserService;
import jodd.http.HttpUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 小程序用户Controller
 *
 * @author ruoyi
 * @date 2020-04-23
 */
@Controller
@RequestMapping("/wx/user")
public class WxUserController extends BaseController {
    private String prefix = "wx/user";

    @Autowired
    private IWxUserService wxUserService;

    @RequiresPermissions("wx:user:view")
    @GetMapping()
    public String user() {
        return prefix + "/user";
    }

    /**
     * 查询小程序用户列表
     */
    @RequiresPermissions("wx:user:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(WxUser wxUser) {
        startPage();
        List<WxUser> list = wxUserService.selectWxUserList(wxUser);
        return getDataTable(list);
    }

    /**
     * 导出小程序用户列表
     */
    @RequiresPermissions("wx:user:export")
    @Log(title = "小程序用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(WxUser wxUser) {
        List<WxUser> list = wxUserService.selectWxUserList(wxUser);
        ExcelUtil<WxUser> util = new ExcelUtil<WxUser>(WxUser.class);
        return util.exportExcel(list, "user");
    }

    /**
     * 新增小程序用户
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存小程序用户
     */
//    @RequiresPermissions("wx:user:add")
    @Log(title = "小程序用户", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody WxUser wxUser) {
        AjaxResult ajaxResult = null;
        System.out.println("wxUserEntity:" + wxUser.toString());
        EmojiConverter emojiConverter = EmojiConverter.getInstance();
        String name = emojiConverter.toAlias(wxUser.getNickName());//将聊天内容进行转义
        wxUser.setNickName(name);//将聊天内容进行转义
        // 配置获取openId
        String url = Global.LOGIN_URL.replace("JSCODE", wxUser.getCode());
        if (wxUser.getCode() != null) {
            String test = HttpUtils.sendGet(url, "");
            JsonObject jsonObject = new Gson().fromJson(test, JsonObject.class);
            String openid = jsonObject.get("openid").getAsString();
            wxUser.setOpenid(openid);
            WxUser wxUserEntity1 = wxUserService.findByOpenId(openid);
            if (wxUserEntity1 == null) {
                int status = wxUserService.insertWxUser(wxUser);
                if (status > 0) {
                    ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS,"新建成功",wxUser);
                } else {
                    ajaxResult = new AjaxResult(AjaxResult.Type.ERROR,"新建失败",wxUser);
                }
            } else {
                int status = wxUserService.updateWxUser(wxUser);
                if (status>0) {
                    ajaxResult = new AjaxResult(AjaxResult.Type.SUCCESS,"更新成功",wxUserEntity1);
                } else {
                    ajaxResult = new AjaxResult(AjaxResult.Type.ERROR,"更新失败",wxUserEntity1);
                }
            }
        }
        return ajaxResult;
    }

    /**
     * 修改小程序用户
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap) {
        WxUser wxUser = wxUserService.selectWxUserById(id);
        mmap.put("wxUser", wxUser);
        return prefix + "/edit";
    }

    /**
     * 修改保存小程序用户
     */
    @RequiresPermissions("wx:user:edit")
    @Log(title = "小程序用户", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(WxUser wxUser) {
        return toAjax(wxUserService.updateWxUser(wxUser));
    }

    /**
     * 删除小程序用户
     */
    @RequiresPermissions("wx:user:remove")
    @Log(title = "小程序用户", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(wxUserService.deleteWxUserByIds(ids));
    }
}
