package com.ruoyi.wx.mapper;

import java.util.List;
import com.ruoyi.wx.domain.WxUserGame;

/**
 * 报名模块Mapper接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface WxUserGameMapper 
{
    /**
     * 查询报名模块
     * 
     * @param id 报名模块ID
     * @return 报名模块
     */
    public WxUserGame selectWxUserGameById(Long id);

    /**
     * 查询报名模块列表
     * 
     * @param wxUserGame 报名模块
     * @return 报名模块集合
     */
    public List<WxUserGame> selectWxUserGameList(WxUserGame wxUserGame);

    /**
     * 新增报名模块
     * 
     * @param wxUserGame 报名模块
     * @return 结果
     */
    public int insertWxUserGame(WxUserGame wxUserGame);

    /**
     * 修改报名模块
     * 
     * @param wxUserGame 报名模块
     * @return 结果
     */
    public int updateWxUserGame(WxUserGame wxUserGame);

    /**
     * 删除报名模块
     * 
     * @param id 报名模块ID
     * @return 结果
     */
    public int deleteWxUserGameById(Long id);

    /**
     * 批量删除报名模块
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxUserGameByIds(String[] ids);
}
