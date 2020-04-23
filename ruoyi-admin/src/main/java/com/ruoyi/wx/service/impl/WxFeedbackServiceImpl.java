package com.ruoyi.wx.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.wx.mapper.WxFeedbackMapper;
import com.ruoyi.wx.domain.WxFeedback;
import com.ruoyi.wx.service.IWxFeedbackService;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户反馈Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
@Service
public class WxFeedbackServiceImpl implements IWxFeedbackService 
{
    @Autowired
    private WxFeedbackMapper wxFeedbackMapper;

    /**
     * 查询用户反馈
     * 
     * @param id 用户反馈ID
     * @return 用户反馈
     */
    @Override
    public WxFeedback selectWxFeedbackById(Long id)
    {
        return wxFeedbackMapper.selectWxFeedbackById(id);
    }

    /**
     * 查询用户反馈列表
     * 
     * @param wxFeedback 用户反馈
     * @return 用户反馈
     */
    @Override
    public List<WxFeedback> selectWxFeedbackList(WxFeedback wxFeedback)
    {
        return wxFeedbackMapper.selectWxFeedbackList(wxFeedback);
    }

    /**
     * 新增用户反馈
     * 
     * @param wxFeedback 用户反馈
     * @return 结果
     */
    @Override
    public int insertWxFeedback(WxFeedback wxFeedback)
    {
        wxFeedback.setCreateTime(DateUtils.getNowDate());
        return wxFeedbackMapper.insertWxFeedback(wxFeedback);
    }

    /**
     * 修改用户反馈
     * 
     * @param wxFeedback 用户反馈
     * @return 结果
     */
    @Override
    public int updateWxFeedback(WxFeedback wxFeedback)
    {
        return wxFeedbackMapper.updateWxFeedback(wxFeedback);
    }

    /**
     * 删除用户反馈对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteWxFeedbackByIds(String ids)
    {
        return wxFeedbackMapper.deleteWxFeedbackByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户反馈信息
     * 
     * @param id 用户反馈ID
     * @return 结果
     */
    @Override
    public int deleteWxFeedbackById(Long id)
    {
        return wxFeedbackMapper.deleteWxFeedbackById(id);
    }
}
