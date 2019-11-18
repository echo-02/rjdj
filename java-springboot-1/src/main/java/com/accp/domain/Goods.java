package com.accp.domain;

public class Goods {
    private Integer gid;

    private String artno;

    private String gname;

    private Integer counts;

    private Integer cfid;

    private String brand;

    private Double cost;

    private Double price;

    private Integer status;

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getArtno() {
        return artno;
    }

    public void setArtno(String artno) {
        this.artno = artno;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }

    public Integer getCfid() {
        return cfid;
    }

    public void setCfid(Integer cfid) {
        this.cfid = cfid;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}