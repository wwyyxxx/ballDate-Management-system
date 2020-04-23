package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxUserGameMapper;
import com.ruoyi.wx.domain.WxUserGame;
import com.ruoyi.wx.service.IWxUserGameService;
import com.ruoyi.common.core.text.Convert;

/**
 * 报名模块Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class WxUserGameServiceImpl implements IWxUserGameService 
{
    @Autowired
    private WxUserGameMapper wxUserGameMapper;

    /**
     * 查询报名模块
     * 
     * @param id 报名模块ID
     * @return 报名模块
     */
    @Override
    public WxUserGame selectWxUserGameById(Long id)
    {
        return wxUserGameMapper.selectWxUserGameById(id);
    }

    /**
     * 查询报名模块列表
     * 
     * @param wxUserGame 报名模块
     * @return 报名模块
     */
    @Override
    public List<WxUserGame> selectWxUserGameList(WxUserGame wxUserGame)
    {
        return wxUserGameMapper.selectWxUserGameList(wxUserGame);
    }

    /**
     * 新增报名模块
     * 
     * @param wxUserGame 报名模块
     * @return 结果
     */
    @Override
    public int insertWxUserGame(WxUserGame wxUserGame)
    {
        wxUserGame.setCreateTime(DateUtils.getNowDate());
        return wxUserGameMapper.insertWxUserGame(wxUserGame);
    }

    /**
     * 修改报名模块
     * 
     * @param wxUserGame 报名模块
     * @return 结果
     */
    @Override
    public int updateWxUserGame(WxUserGame wxUserGame)
    {
        return wxUserGameMapper.updateWxUserGame(wxUserGame);
    }

    /**
     * 删除报名模块对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxUserGameByIds(String ids)
    {
        return wxUserGameMapper.deleteWxUserGameByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除报名模块信息
     * 
     * @param id 报名模块ID
     * @return 结果
     */
    @Override
    public int deleteWxUserGameById(Long id)
    {
        return wxUserGameMapper.deleteWxUserGameById(id);
    }
}
