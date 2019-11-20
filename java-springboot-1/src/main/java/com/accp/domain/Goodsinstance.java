package com.accp.domain;

public class Goodsinstance {
    private Integer giid;

    private Integer gid;

    private String barcode;

    private String sfdids;

    private Integer counts;
    
    private String spec;

    public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getGiid() {
        return giid;
    }

    public void setGiid(Integer giid) {
        this.giid = giid;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getSfdids() {
        return sfdids;
    }

    public void setSfdids(String sfdids) {
        this.sfdids = sfdids;
    }

    public Integer getCounts() {
        return counts;
    }

    public void setCounts(Integer counts) {
        this.counts = counts;
    }
}