package com.accp.domain;

public class Employee {
    private Integer emid;

    private String jobnum;

    private String empwd;

    private String emname;

    private Integer positionid;

    private Integer shopid;

    private Integer status;

    public Integer getEmid() {
        return emid;
    }

    public void setEmid(Integer emid) {
        this.emid = emid;
    }

    public String getJobnum() {
        return jobnum;
    }

    public void setJobnum(String jobnum) {
        this.jobnum = jobnum;
    }

    public String getEmpwd() {
        return empwd;
    }

    public void setEmpwd(String empwd) {
        this.empwd = empwd;
    }

    public String getEmname() {
        return emname;
    }

    public void setEmname(String emname) {
        this.emname = emname;
    }

    public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public Integer getShopid() {
        return shopid;
    }

    public void setShopid(Integer shopid) {
        this.shopid = shopid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}