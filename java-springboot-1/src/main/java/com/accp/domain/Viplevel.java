package com.accp.domain;

public class Viplevel {
    private Integer id;

    private String levelname;

    private Double discount;

    private Double upgrade;

    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLevelname() {
        return levelname;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Double getUpgrade() {
        return upgrade;
    }

    public void setUpgrade(Double upgrade) {
        this.upgrade = upgrade;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}