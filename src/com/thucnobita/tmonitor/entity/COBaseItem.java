package com.thucnobita.tmonitor.entity;

public abstract class COBaseItem {
	private String code;
    private String nameVn;
    private String nameEn;
    private String descVn;
    private String descEn;
    
    public COBaseItem() {
    	this.nameVn = "";
    	this.nameEn = "";
    	this.descVn = "";
    	this.descEn = "";
    }
    
    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNameVn() {
        return this.nameVn;
    }

    public void setNameVn(String nameVN) {
        this.nameVn = nameVN;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEN) {
        this.nameEn = nameEN;
    }

    public String getDescVn() {
        return this.descVn;
    }

    public void setDescVn(String descVN) {
        this.descVn = descVN;
    }

    public String getDescEn() {
        return this.descEn;
    }

    public void setDescEn(String descEN) {
        this.descEn = descEN;
    }
}
