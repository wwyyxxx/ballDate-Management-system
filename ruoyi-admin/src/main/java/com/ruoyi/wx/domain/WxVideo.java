package com.ruoyi.wx.domain;

import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 视频对象 wx_video
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public class WxVideo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 视频Id */
    private Long id;

    /** 用户Id */
    @Excel(name = "用户Id")
    private Long uId;

    /** 标题 */
    @Excel(name = "标题")
    private String title;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 简介 */
    @Excel(name = "简介")
    private String summary;

    /** 链接 */
    @Excel(name = "链接")
    private String url;

    /** 状态0：审核中1：通过2.：未通过 */
    @Excel(name = "状态0：审核中1：通过2.：未通过")
    private Long status;

    /** 上传时间 */
    @Excel(name = "上传时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date creatTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setType(String type)
    {
        this.type = type;
    }

    public String getType()
    {
        return type;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }
    public void setUrl(String url) 
    {
        this.url = url;
    }

    public String getUrl() 
    {
        return url;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uId", getuId())
            .append("title", getTitle())
            .append("type", getType())
            .append("summary", getSummary())
            .append("url", getUrl())
            .append("status", getStatus())
            .append("creatTime", getCreatTime())
            .toString();
    }
}
