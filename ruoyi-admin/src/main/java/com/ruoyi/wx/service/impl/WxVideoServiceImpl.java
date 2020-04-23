package com.ruoyi.wx.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxVideoMapper;
import com.ruoyi.wx.domain.WxVideo;
import com.ruoyi.wx.service.IWxVideoService;
import com.ruoyi.common.core.text.Convert;

/**
 * 视频Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class WxVideoServiceImpl implements IWxVideoService 
{
    @Autowired
    private WxVideoMapper wxVideoMapper;

    /**
     * 查询视频
     * 
     * @param id 视频ID
     * @return 视频
     */
    @Override
    public WxVideo selectWxVideoById(Long id)
    {
        return wxVideoMapper.selectWxVideoById(id);
    }

    /**
     * 查询视频列表
     * 
     * @param wxVideo 视频
     * @return 视频
     */
    @Override
    public List<WxVideo> selectWxVideoList(WxVideo wxVideo)
    {
        return wxVideoMapper.selectWxVideoList(wxVideo);
    }

    /**
     * 新增视频
     * 
     * @param wxVideo 视频
     * @return 结果
     */
    @Override
    public int insertWxVideo(WxVideo wxVideo)
    {
        return wxVideoMapper.insertWxVideo(wxVideo);
    }

    /**
     * 修改视频
     * 
     * @param wxVideo 视频
     * @return 结果
     */
    @Override
    public int updateWxVideo(WxVideo wxVideo)
    {
        return wxVideoMapper.updateWxVideo(wxVideo);
    }

    /**
     * 删除视频对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxVideoByIds(String ids)
    {
        return wxVideoMapper.deleteWxVideoByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除视频信息
     * 
     * @param id 视频ID
     * @return 结果
     */
    @Override
    public int deleteWxVideoById(Long id)
    {
        return wxVideoMapper.deleteWxVideoById(id);
    }
}
