package com.accp.domain;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Topup {
    private Integer id;

    private Integer vipid;

    private Double money;//充值金额
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date topdate;//日期
    
    private Date topdate2;//日期范围后

    private Integer presenter;//积分

    private String remark;
    
    private String weixin;//此充值记录 的vip 的微信
    
    private String phone;//此充值记录 的vip 的手机
    
    private String name; //此VIP的名称
    
    private Double total;//此vipid消费总金额
    
    private Double balance;//账户余额
    

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

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Date getTopdate2() {
		return topdate2;
	}

	public void setTopdate2(Date topdate2) {
		this.topdate2 = topdate2;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}
}