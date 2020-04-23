package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxBallGame;

/**
 * 球局Mapper接口
 * 
 * @author xys
 * @date 2020-04-23
 */
public interface WxBallGameMapper 
{
    /**
     * 查询球局
     * 
     * @param id 球局ID
     * @return 球局
     */
    public WxBallGame selectWxBallGameById(Long id);

    /**
     * 查询球局列表
     * 
     * @param wxBallGame 球局
     * @return 球局集合
     */
    public List<WxBallGame> selectWxBallGameList(WxBallGame wxBallGame);

    /**
     * 新增球局
     * 
     * @param wxBallGame 球局
     * @return 结果
     */
    public int insertWxBallGame(WxBallGame wxBallGame);

    /**
     * 修改球局
     * 
     * @param wxBallGame 球局
     * @return 结果
     */
    public int updateWxBallGame(WxBallGame wxBallGame);

    /**
     * 删除球局
     * 
     * @param id 球局ID
     * @return 结果
     */
    public int deleteWxBallGameById(Long id);

    /**
     * 批量删除球局
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxBallGameByIds(String[] ids);
}
