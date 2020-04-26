package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.wx.domain.WxUserGame;
import com.ruoyi.wx.mapper.WxUserGameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxBallGameMapper;
import com.ruoyi.wx.domain.WxBallGame;
import com.ruoyi.wx.service.IWxBallGameService;
import com.ruoyi.common.core.text.Convert;

/**
 * 球局Service业务层处理
 * 
 * @author xys
 * @date 2020-04-23
 */
@Service
public class WxBallGameServiceImpl implements IWxBallGameService 
{
    @Autowired
    private WxBallGameMapper wxBallGameMapper;

    @Autowired
    private WxUserGameMapper wxUserGameMapper;

    /**
     * 查询球局
     * 
     * @param id 球局ID
     * @return 球局
     */
    @Override
    public WxBallGame selectWxBallGameById(Long id)
    {
        return wxBallGameMapper.selectWxBallGameById(id);
    }

    /**
     * 查询球局列表
     * 
     * @param wxBallGame 球局
     * @return 球局
     */
    @Override
    public List<WxBallGame> selectWxBallGameList(WxBallGame wxBallGame)
    {
        WxUserGame wxUserGame = new WxUserGame();
        List<WxBallGame> ballGames = wxBallGameMapper.selectWxBallGameList(wxBallGame);
        for (WxBallGame ballGame: ballGames ) {
            wxUserGame.setgId(ballGame.getId());
            List<WxUserGame> list =  wxUserGameMapper.selectWxUserGameList(wxUserGame);
            ballGame.setUserGameList(list);
            ballGame.setCount((long) list.size());
        }
        return ballGames;
    }

    /**
     * 新增球局
     * 
     * @param wxBallGame 球局
     * @return 结果
     */
    @Override
    public int insertWxBallGame(WxBallGame wxBallGame)
    {
        wxBallGame.setCreateTime(DateUtils.getNowDate());
        return wxBallGameMapper.insertWxBallGame(wxBallGame);
    }

    /**
     * 修改球局
     * 
     * @param wxBallGame 球局
     * @return 结果
     */
    @Override
    public int updateWxBallGame(WxBallGame wxBallGame)
    {
        return wxBallGameMapper.updateWxBallGame(wxBallGame);
    }

    /**
     * 删除球局对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxBallGameByIds(String ids)
    {
        return wxBallGameMapper.deleteWxBallGameByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除球局信息
     * 
     * @param id 球局ID
     * @return 结果
     */
    @Override
    public int deleteWxBallGameById(Long id)
    {
        return wxBallGameMapper.deleteWxBallGameById(id);
    }
}
