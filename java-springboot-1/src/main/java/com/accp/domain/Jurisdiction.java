package com.accp.domain;

public class Jurisdiction {
    private Integer jsid;

    private Integer parentid;

    private String jsname;

    private Integer catalog;

    private String path;

    private String enname;

    public Integer getJsid() {
        return jsid;
    }

    public void setJsid(Integer jsid) {
        this.jsid = jsid;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public String getJsname() {
        return jsname;
    }

    public void setJsname(String jsname) {
        this.jsname = jsname;
    }

    public Integer getCatalog() {
        return catalog;
    }

    public void setCatalog(Integer catalog) {
        this.catalog = catalog;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
    }
}