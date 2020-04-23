package com.ruoyi.wx.service;

import java.util.List;
import com.ruoyi.wx.domain.WxFeedback;

/**
 * 用户反馈Service接口
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public interface IWxFeedbackService 
{
    /**
     * 查询用户反馈
     * 
     * @param id 用户反馈ID
     * @return 用户反馈
     */
    public WxFeedback selectWxFeedbackById(Long id);

    /**
     * 查询用户反馈列表
     * 
     * @param wxFeedback 用户反馈
     * @return 用户反馈集合
     */
    public List<WxFeedback> selectWxFeedbackList(WxFeedback wxFeedback);

    /**
     * 新增用户反馈
     * 
     * @param wxFeedback 用户反馈
     * @return 结果
     */
    public int insertWxFeedback(WxFeedback wxFeedback);

    /**
     * 修改用户反馈
     * 
     * @param wxFeedback 用户反馈
     * @return 结果
     */
    public int updateWxFeedback(WxFeedback wxFeedback);

    /**
     * 批量删除用户反馈
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWxFeedbackByIds(String ids);

    /**
     * 删除用户反馈信息
     * 
     * @param id 用户反馈ID
     * @return 结果
     */
    public int deleteWxFeedbackById(Long id);
}
