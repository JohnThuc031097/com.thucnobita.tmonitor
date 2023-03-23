package com.thucnobita.tmonitor.entity;

import java.util.ArrayList;
import java.util.List;

public class MenuGroup {
	private long id;
    private String code;
    private String name;
    private String nameEn;
    private int orderNo;
    private int level;
    private int groupType;
    private String srcImage;
    private List<MenuGroupDetail> details = new ArrayList<MenuGroupDetail>();
    
    public MenuGroup() {
    	this.level = -1;
    }
    
    public String getSrcImage() {
        return this.srcImage;
    }

    public void setSrcImage(String srcImage) {
        this.srcImage = srcImage;
    }

    public String getNameEn() {
        return this.nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn;
    }

    public int getGroupType() {
        return this.groupType;
    }

    public void setGroupType(int groupType) {
        this.groupType = groupType;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MenuGroupDetail> getDetails() {
        return this.details;
    }

    public void setDetails(List<MenuGroupDetail> details) {
        this.details = details;
    }

    public int getOrderNo() {
        return this.orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
