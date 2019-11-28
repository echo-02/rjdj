package com.accp.domain;

import java.util.List;

public class Position {
    private Integer positionid;

    private String positionname;
   
    public Integer getJsid() {
		return jsid;
	}

	public void setJsid(Integer jsid) {
		this.jsid = jsid;
	}

	private Integer jsid;

	

	public Integer getPositionid() {
        return positionid;
    }

    public void setPositionid(Integer positionid) {
        this.positionid = positionid;
    }

    public String getPositionname() {
        return positionname;
    }

    public void setPositionname(String positionname) {
        this.positionname = positionname;
    }
}