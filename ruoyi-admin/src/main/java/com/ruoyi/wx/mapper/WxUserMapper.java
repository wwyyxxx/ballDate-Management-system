package com.ruoyi.wx.mapper;


import com.ruoyi.wx.domain.WxUser;

import java.util.List;

/**
 * 小程序用户Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface WxUserMapper 
{
    /**
     * 查询小程序用户
     * 
     * @param id 小程序用户ID
     * @return 小程序用户
     */
    public WxUser selectWxUserById(Long id);

    /**
     * 查询小程序用户列表
     * 
     * @param wxUser 小程序用户
     * @return 小程序用户集合
     */
    public List<WxUser> selectWxUserList(WxUser wxUser);

    /**
     * 新增小程序用户
     * 
     * @param wxUser 小程序用户
     * @return 结果
     */
    public int insertWxUser(WxUser wxUser);

    /**
     * 修改小程序用户
     * 
     * @param wxUser 小程序用户
     * @return 结果
     */
    public int updateWxUser(WxUser wxUser);

    /**
     * 删除小程序用户
     * 
     * @param id 小程序用户ID
     * @return 结果
     */
    public int deleteWxUserById(Long id);

    /**
     * 批量删除小程序用户
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserByIds(String[] ids);
    WxUser findByOpenId(String openId);
}
