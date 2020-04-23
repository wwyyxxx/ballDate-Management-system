package com.ruoyi.wx.service.impl;

import java.util.List;

import com.ruoyi.wx.domain.WxUser;
import com.ruoyi.wx.mapper.WxUserMapper;
import com.ruoyi.wx.service.IWxUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 小程序用户Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class WxUserServiceImpl implements IWxUserService
{
    @Autowired
    private WxUserMapper wxUserMapper;

    /**
     * 查询小程序用户
     * 
     * @param id 小程序用户ID
     * @return 小程序用户
     */
    @Override
    public WxUser selectWxUserById(Long id)
    {
        return wxUserMapper.selectWxUserById(id);
    }

    /**
     * 查询小程序用户列表
     * 
     * @param wxUser 小程序用户
     * @return 小程序用户
     */
    @Override
    public List<WxUser> selectWxUserList(WxUser wxUser)
    {
        return wxUserMapper.selectWxUserList(wxUser);
    }

    /**
     * 新增小程序用户
     * 
     * @param wxUser 小程序用户
     * @return 结果
     */
    @Override
    public int insertWxUser(WxUser wxUser)
    {
        return wxUserMapper.insertWxUser(wxUser);
    }

    /**
     * 修改小程序用户
     * 
     * @param wxUser 小程序用户
     * @return 结果
     */
    @Override
    public int updateWxUser(WxUser wxUser)
    {
        return wxUserMapper.updateWxUser(wxUser);
    }

    /**
     * 删除小程序用户对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxUserByIds(String ids)
    {
        return wxUserMapper.deleteWxUserByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除小程序用户信息
     * 
     * @param id 小程序用户ID
     * @return 结果
     */
    @Override
    public int deleteWxUserById(Long id)
    {
        return wxUserMapper.deleteWxUserById(id);
    }
}
