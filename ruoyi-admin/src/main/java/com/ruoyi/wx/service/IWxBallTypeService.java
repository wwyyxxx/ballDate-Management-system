package com.ruoyi.wx.service;

import java.util.List;
import com.ruoyi.wx.domain.WxBallType;

/**
 * 球类Service接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface IWxBallTypeService 
{
    /**
     * 查询球类
     * 
     * @param id 球类ID
     * @return 球类
     */
    public WxBallType selectWxBallTypeById(Long id);

    /**
     * 查询球类列表
     * 
     * @param wxBallType 球类
     * @return 球类集合
     */
    public List<WxBallType> selectWxBallTypeList(WxBallType wxBallType);

    /**
     * 新增球类
     * 
     * @param wxBallType 球类
     * @return 结果
     */
    public int insertWxBallType(WxBallType wxBallType);

    /**
     * 修改球类
     * 
     * @param wxBallType 球类
     * @return 结果
     */
    public int updateWxBallType(WxBallType wxBallType);

    /**
     * 批量删除球类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxBallTypeByIds(String ids);

    /**
     * 删除球类信息
     * 
     * @param id 球类ID
     * @return 结果
     */
    public int deleteWxBallTypeById(Long id);
}
