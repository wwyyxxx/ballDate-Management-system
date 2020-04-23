package com.ruoyi.wx.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxBallTypeMapper;
import com.ruoyi.wx.domain.WxBallType;
import com.ruoyi.wx.service.IWxBallTypeService;
import com.ruoyi.common.core.text.Convert;

/**
 * 球类Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class WxBallTypeServiceImpl implements IWxBallTypeService 
{
    @Autowired
    private WxBallTypeMapper wxBallTypeMapper;

    /**
     * 查询球类
     * 
     * @param id 球类ID
     * @return 球类
     */
    @Override
    public WxBallType selectWxBallTypeById(Long id)
    {
        return wxBallTypeMapper.selectWxBallTypeById(id);
    }

    /**
     * 查询球类列表
     * 
     * @param wxBallType 球类
     * @return 球类
     */
    @Override
    public List<WxBallType> selectWxBallTypeList(WxBallType wxBallType)
    {
        return wxBallTypeMapper.selectWxBallTypeList(wxBallType);
    }

    /**
     * 新增球类
     * 
     * @param wxBallType 球类
     * @return 结果
     */
    @Override
    public int insertWxBallType(WxBallType wxBallType)
    {
        return wxBallTypeMapper.insertWxBallType(wxBallType);
    }

    /**
     * 修改球类
     * 
     * @param wxBallType 球类
     * @return 结果
     */
    @Override
    public int updateWxBallType(WxBallType wxBallType)
    {
        return wxBallTypeMapper.updateWxBallType(wxBallType);
    }

    /**
     * 删除球类对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxBallTypeByIds(String ids)
    {
        return wxBallTypeMapper.deleteWxBallTypeByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除球类信息
     * 
     * @param id 球类ID
     * @return 结果
     */
    @Override
    public int deleteWxBallTypeById(Long id)
    {
        return wxBallTypeMapper.deleteWxBallTypeById(id);
    }
}
