package com.ruoyi.wx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 报名模块对象 wx_user_game
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public class WxUserGame extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** null */
    @Excel(name = "null")
    private Long gId;

    /** null */
    @Excel(name = "null")
    private Long uId;

    private List<WxUser> wxUsers;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setgId(Long gId) 
    {
        this.gId = gId;
    }

    public Long getgId() 
    {
        return gId;
    }
    public void setuId(Long uId) 
    {
        this.uId = uId;
    }

    public Long getuId() 
    {
        return uId;
    }

    public List<WxUser> getWxUsers() {
        return wxUsers;
    }

    public void setWxUsers(List<WxUser> wxUsers) {
        this.wxUsers = wxUsers;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("gId", getgId())
            .append("uId", getuId())
            .append("createTime", getCreateTime())
            .toString();
    }
}