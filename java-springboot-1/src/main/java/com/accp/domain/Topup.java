package com.accp.domain;

import java.util.Date;

public class Topup {
    private Integer id;

    private Integer vipid;

    private Double money;

    private Date topdate;

    private Integer presenter;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVipid() {
        return vipid;
    }

    public void setVipid(Integer vipid) {
        this.vipid = vipid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Date getTopdate() {
        return topdate;
    }

    public void setTopdate(Date topdate) {
        this.topdate = topdate;
    }

    public Integer getPresenter() {
        return presenter;
    }

    public void setPresenter(Integer presenter) {
        this.presenter = presenter;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}