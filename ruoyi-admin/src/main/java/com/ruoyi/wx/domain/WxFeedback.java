package com.ruoyi.wx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户反馈对象 wx_feedback
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public class WxFeedback extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 反馈Id */
    private Long id;

    /** 用户名称 */
    @Excel(name = "用户名称")
    private String name;

    /** 角色 */
    @Excel(name = "角色")
    private String role;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String contact;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setRole(String role) 
    {
        this.role = role;
    }

    public String getRole() 
    {
        return role;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("role", getRole())
            .append("content", getContent())
            .append("contact", getContact())
            .append("createTime", getCreateTime())
            .toString();
    }
}
