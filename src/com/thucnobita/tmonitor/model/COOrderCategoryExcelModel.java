package com.thucnobita.tmonitor.model;

import java.util.List;

public class COOrderCategoryExcelModel {
	private int typeMenu;
	private String code;
	private String nameVN;
	private String nameEN;
	private String pathFile;
	private String folder;
	private List<String> groupCodes;
	
	public String getPathFile() {
		return pathFile;
	}
	public void setPathFile(String pathImage) {
		this.pathFile = pathImage;
	}
	
	public String getFolder() {
		return folder;
	}
	public void setFolder(String folder) {
		this.folder = folder;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	private String fileName;
	
	public int getTypeMenu() {
		return typeMenu;
	}
	public void setTypeMenu(int typeMenu) {
		this.typeMenu = typeMenu;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getNameVN() {
		return nameVN;
	}
	public void setNameVN(String nameVN) {
		this.nameVN = nameVN;
	}
	public String getNameEN() {
		return nameEN;
	}
	public void setNameEN(String nameEN) {
		this.nameEN = nameEN;
	}
	public List<String> getGroupCodes() {
		return groupCodes;
	}
	public void setGroupCodes(List<String> groupCodes) {
		this.groupCodes = groupCodes;
	}
}
