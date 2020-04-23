package com.ruoyi.wx.service;

import java.util.List;
import com.ruoyi.wx.domain.WxVideo;

/**
 * 视频Service接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface IWxVideoService 
{
    /**
     * 查询视频
     * 
     * @param id 视频ID
     * @return 视频
     */
    public WxVideo selectWxVideoById(Long id);

    /**
     * 查询视频列表
     * 
     * @param wxVideo 视频
     * @return 视频集合
     */
    public List<WxVideo> selectWxVideoList(WxVideo wxVideo);

    /**
     * 新增视频
     * 
     * @param wxVideo 视频
     * @return 结果
     */
    public int insertWxVideo(WxVideo wxVideo);

    /**
     * 修改视频
     * 
     * @param wxVideo 视频
     * @return 结果
     */
    public int updateWxVideo(WxVideo wxVideo);

    /**
     * 批量删除视频
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxVideoByIds(String ids);

    /**
     * 删除视频信息
     * 
     * @param id 视频ID
     * @return 结果
     */
    public int deleteWxVideoById(Long id);
}
