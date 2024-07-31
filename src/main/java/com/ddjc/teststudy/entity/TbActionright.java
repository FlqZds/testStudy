package com.ddjc.teststudy.entity;

public class TbActionright {
    private Integer rightid;

    private String rightCode;

    private String righttext;

    private Byte righttype;

    private String righturl;

    private Integer parentid;

    public Integer getRightid() {
        return rightid;
    }

    public void setRightid(Integer rightid) {
        this.rightid = rightid;
    }

    public String getRightCode() {
        return rightCode;
    }

    public void setRightCode(String rightCode) {
        this.rightCode = rightCode == null ? null : rightCode.trim();
    }

    public String getRighttext() {
        return righttext;
    }

    public void setRighttext(String righttext) {
        this.righttext = righttext == null ? null : righttext.trim();
    }

    public Byte getRighttype() {
        return righttype;
    }

    public void setRighttype(Byte righttype) {
        this.righttype = righttype;
    }

    public String getRighturl() {
        return righturl;
    }

    public void setRighturl(String righturl) {
        this.righturl = righturl == null ? null : righturl.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }
}