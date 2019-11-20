package com.accp.domain;

import java.util.List;

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
    
    private String pic;
    
    private List<Goodsinstance> goodsinstances;
    
    private String cfname;

    public String getCfname() {
		return cfname;
	}

	public void setCfname(String cfname) {
		this.cfname = cfname;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

    public List<Goodsinstance> getGoodsinstances() {
		return goodsinstances;
	}

	public void setGoodsinstances(List<Goodsinstance> goodsinstances) {
		this.goodsinstances = goodsinstances;
	}

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