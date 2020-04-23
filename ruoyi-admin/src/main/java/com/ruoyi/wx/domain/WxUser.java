package com.ruoyi.wx.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 小程序用户对象 wx_user
 * 
 * @author ruoyi
 * @date 2020-04-23
 */
public class WxUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    private Long id;

    /** 开放Id */
    @Excel(name = "开放Id")
    private String openid;

    /** 用户昵称 */
    @Excel(name = "用户昵称")
    private String nickName;

    /** 用户性别 */
    @Excel(name = "用户性别")
    private Long sex;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String avatar;

    /** 用户状态 */
    @Excel(name = "用户状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOpenid(String openid) 
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setNickName(String nickName) 
    {
        this.nickName = nickName;
    }

    public String getNickName() 
    {
        return nickName;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setAvatar(String avatar) 
    {
        this.avatar = avatar;
    }

    public String getAvatar() 
    {
        return avatar;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("openid", getOpenid())
            .append("nickName", getNickName())
            .append("sex", getSex())
            .append("avatar", getAvatar())
            .append("status", getStatus())
            .toString();
    }
}
