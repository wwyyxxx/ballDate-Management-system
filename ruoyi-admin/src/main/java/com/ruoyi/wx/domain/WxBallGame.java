package com.ruoyi.wx.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 球局对象 wx_ball_game
 * 
 * @author xys
 * @date 2020-04-23
 */
public class WxBallGame extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** null */
    private Long id;

    /** 球局名称 */
    @Excel(name = "球局名称")
    private String title;

    /** 球局简介 */
    @Excel(name = "球局简介")
    private String summary;

    /** 比赛日期 */
    @Excel(name = "比赛日期", width = 30, dateFormat = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date playDate;

    /** 球局类型 */
    @Excel(name = "球局类型")
    private String type;

    /** 我方分数 */
    @Excel(name = "我方分数")
    private Long scoreMine;

    /** 对方分数 */
    @Excel(name = "对方分数")
    private Long scoreOther;

    /** 球局人数 */
    @Excel(name = "球局人数")
    private Long peopleNumner;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 0:免费1：收费 */
    @Excel(name = "0:免费1：收费")
    private Long status;

    /** 价格 */
    @Excel(name = "价格")
    private Double cost;

    /** 组局人联系方式 */
    @Excel(name = "组局人联系方式")
    private String contact;

    private List<WxUserGame> userGameList;

    private Long count;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setSummary(String summary) 
    {
        this.summary = summary;
    }

    public String getSummary() 
    {
        return summary;
    }
    public void setPlayDate(Date playDate) 
    {
        this.playDate = playDate;
    }

    public Date getPlayDate() 
    {
        return playDate;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setScoreMine(Long scoreMine) 
    {
        this.scoreMine = scoreMine;
    }

    public Long getScoreMine() 
    {
        return scoreMine;
    }
    public void setScoreOther(Long scoreOther) 
    {
        this.scoreOther = scoreOther;
    }

    public Long getScoreOther() 
    {
        return scoreOther;
    }
    public void setPeopleNumner(Long peopleNumner) 
    {
        this.peopleNumner = peopleNumner;
    }

    public Long getPeopleNumner() 
    {
        return peopleNumner;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setCost(Double cost) 
    {
        this.cost = cost;
    }

    public Double getCost() 
    {
        return cost;
    }
    public void setContact(String contact) 
    {
        this.contact = contact;
    }

    public String getContact() 
    {
        return contact;
    }

    public List<WxUserGame> getUserGameList() {
        return userGameList;
    }

    public void setUserGameList(List<WxUserGame> userGameList) {
        this.userGameList = userGameList;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("title", getTitle())
            .append("summary", getSummary())
            .append("playDate", getPlayDate())
            .append("type", getType())
            .append("scoreMine", getScoreMine())
            .append("scoreOther", getScoreOther())
            .append("peopleNumner", getPeopleNumner())
            .append("address", getAddress())
            .append("status", getStatus())
            .append("cost", getCost())
            .append("contact", getContact())
            .append("createTime", getCreateTime())
            .toString();
    }
}
