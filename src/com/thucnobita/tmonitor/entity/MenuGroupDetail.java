package com.thucnobita.tmonitor.entity;

public class MenuGroupDetail {
	private String refCode;
	private MenuGroupDetailType type;
	private String name;
	private int orderNumberItem;
	private int viewType;

	public int getViewType() {
		return this.viewType;
	}

	public void setViewType(int viewType) {
		this.viewType = viewType;
	}

	public MenuGroupDetail(String refCode, MenuGroupDetailType type, String name) {
		this.refCode = refCode;
		this.type = type;
		this.name = name;
	}

	public MenuGroupDetail(String refCode, MenuGroupDetailType type, String name, int orderNumberItem) {
		this.refCode = refCode;
		this.type = type;
		this.name = name;
		this.orderNumberItem = orderNumberItem;
	}

	public int getOrderNumberItem() {
		return this.orderNumberItem;
	}

	public void setOrderNumberItem(int orderNumberItem) {
		this.orderNumberItem = orderNumberItem;
	}

	public MenuGroupDetailType getType() {
		return this.type;
	}

	public void setType(MenuGroupDetailType type) {
		this.type = type;
	}

	public String getRefCode() {
		return this.refCode;
	}

	public void setRefCode(String refCode) {
		this.refCode = refCode;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
