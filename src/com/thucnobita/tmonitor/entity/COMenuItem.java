package com.thucnobita.tmonitor.entity;

import java.util.ArrayList;
import java.util.List;

public class COMenuItem extends COBaseItem {
	private long id = 0;
    private String srcImgThumbnail;
    private String srcImg;
    private String srcImg2xHorizontal;
    private String srcImg2xVertical;
    private String srcImgHalf;
    private String srcImgQuarter;
    private String srcImgTopping;
    private int positionNumber;
    private String srcImgGroup;
    private String srcImgGroupHidden;
    private String otherName;
    private List<COMenuItemDetail> coMenuItemDetails;
    private List<COModifier> modifiers;
    private List<String> relatedItems;
    private int maxDishOnSession;
    private int maxDishToKit;
    private List<MenuItemSpecialType> itemSpecialTypes;
    private boolean isCombo;
    private Long removeItemNoPrice;
    private long timeModify;
    private int imgSize;
    private List<String> lstNote;
    private int viewType;
    private List<COItemSize> lstItemSize;
    private List<COItemSize> lstTopping;
    private COItemSize extraItem;
    private String kaloGroupCode;
    private String sapCode;
    private int hiddenIconChooseItem;
    private int numberOfPeopleEat;
    private String srcImgSquare;
    private String note;
    private String noteQuantitative;

    public COMenuItem() {
    	this.srcImgThumbnail = "";
    	this.srcImg = "";
    	this.srcImg2xHorizontal = "";
    	this.srcImg2xVertical = "";
    	this.srcImgHalf = "";
    	this.srcImgQuarter = "";
    	this.srcImgTopping = "";
    	this.positionNumber = 0;
    	this.srcImgGroup = "";
    	this.srcImgGroupHidden = "";
    	this.otherName = "";
    	this.coMenuItemDetails = new ArrayList<COMenuItemDetail>();
    	this.modifiers = new ArrayList<COModifier>();
    	this.relatedItems = new ArrayList<String>();
    	this.maxDishOnSession = 1000;
    	this.maxDishToKit = 0;
    	this.itemSpecialTypes = new ArrayList<MenuItemSpecialType>();
    	this.isCombo = false;
    	this.lstNote = new ArrayList<String>();
    	this.lstItemSize = new ArrayList<COItemSize>();
    	this.lstTopping = new ArrayList<COItemSize>();
    	this.hiddenIconChooseItem = 0;
    	this.numberOfPeopleEat = 0;
    }
    
    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteQuantitative() {
        return this.noteQuantitative;
    }

    public void setNoteQuantitative(String noteQuantitative) {
        this.noteQuantitative = noteQuantitative;
    }

    public int getHiddenIconChooseItem() {
        return this.hiddenIconChooseItem;
    }

    public void setHiddenIconChooseItem(int hiddenIconChooseItem) {
        this.hiddenIconChooseItem = hiddenIconChooseItem;
    }

    public String getSapCode() {
        return this.sapCode;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public String getKaloGroupCode() {
        return this.kaloGroupCode;
    }

    public void setKaloGroupCode(String kaloGroupCode) {
        this.kaloGroupCode = kaloGroupCode;
    }

    public COItemSize getExtraItem() {
        return this.extraItem;
    }

    public void setExtraItem(COItemSize extraItem) {
        this.extraItem = extraItem;
    }

    public String getSrcImgQuarter() {
        return this.srcImgQuarter;
    }

    public void setSrcImgQuarter(String srcImgQuarter) {
        this.srcImgQuarter = srcImgQuarter;
    }

    public List<COItemSize> getLstTopping() {
        return this.lstTopping;
    }

    public void setLstTopping(List<COItemSize> lstTopping) {
        this.lstTopping = lstTopping;
    }

    public List<COItemSize> getLstItemSize() {
        return this.lstItemSize;
    }

    public void setLstItemSize(List<COItemSize> lstItemSize) {
        this.lstItemSize = lstItemSize;
    }

    public int getViewType() {
        return this.viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public String getSrcImg2xHorizontal() {
        return this.srcImg2xHorizontal;
    }

    public void setSrcImg2xHorizontal(String srcImg2xHorizontal) {
        this.srcImg2xHorizontal = srcImg2xHorizontal;
    }

    public String getSrcImg2xVertical() {
        return this.srcImg2xVertical;
    }

    public void setSrcImg2xVertical(String srcImg2xVertical) {
        this.srcImg2xVertical = srcImg2xVertical;
    }

    public int getImgSize() {
        return this.imgSize;
    }

    public void setImgSize(int imgSize) {
        this.imgSize = imgSize;
    }

    public List<String> getLstNote() {
        return this.lstNote;
    }

    public void setLstNote(List<String> lstNote) {
        this.lstNote = lstNote;
    }

    public Long getRemoveItemNoPrice() {
        return this.removeItemNoPrice;
    }

    public void setRemoveItemNoPrice(Long removeItemNoPrice) {
        this.removeItemNoPrice = removeItemNoPrice;
    }

    public String getOtherName() {
        return this.otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getSrcImgGroup() {
        return this.srcImgGroup;
    }

    public void setSrcImgGroup(String srcImgGroup) {
        this.srcImgGroup = srcImgGroup;
    }

    public String getSrcImgGroupHidden() {
        return this.srcImgGroupHidden;
    }

    public void setSrcImgGroupHidden(String srcImgGroupHidden) {
        this.srcImgGroupHidden = srcImgGroupHidden;
    }

    public String getSrcImgTopping() {
        return this.srcImgTopping;
    }

    public void setSrcImgTopping(String srcImgTopping) {
        this.srcImgTopping = srcImgTopping;
    }

    public int getPositionNumber() {
        return this.positionNumber;
    }

    public void setPositionNumber(int positionNumber) {
        this.positionNumber = positionNumber;
    }

    public String getSrcImgHalf() {
        return this.srcImgHalf;
    }

    public void setSrcImgHalf(String srcImgHalf) {
        this.srcImgHalf = srcImgHalf;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSrcImgThumbnail() {
        return this.srcImgThumbnail;
    }

    public void setSrcImgThumbnail(String srcImgThumbnail) {
        this.srcImgThumbnail = srcImgThumbnail;
    }

    public List<COMenuItemDetail> getCoMenuItemDetails() {
        return this.coMenuItemDetails;
    }

    public void setCoMenuItemDetails(List<COMenuItemDetail> coMenuItemDetails) {
        this.coMenuItemDetails = coMenuItemDetails;
    }

    public List<COModifier> getModifiers() {
        return this.modifiers;
    }

    public void setModifiers(List<COModifier> modifiers) {
        this.modifiers = modifiers;
    }

    public List<String> getRelatedItems() {
        return this.relatedItems;
    }

    public void setRelatedItems(List<String> relatedItems) {
        this.relatedItems = relatedItems;
    }

    public int getMaxDishOnSession() {
        return this.maxDishOnSession;
    }

    public void setMaxDishOnSession(int maxDishOnSession) {
        this.maxDishOnSession = maxDishOnSession;
    }

    public int getMaxDishToKit() {
        return this.maxDishToKit;
    }

    public void setMaxDishToKit(int maxDishToKit) {
        this.maxDishToKit = maxDishToKit;
    }

    public String getSrcImg() {
        return this.srcImg;
    }

    public void setSrcImg(String srcImg) {
        this.srcImg = srcImg;
    }

    public List<MenuItemSpecialType> getItemSpecialTypes() {
        return this.itemSpecialTypes;
    }

    public void setItemSpecialTypes(List<MenuItemSpecialType> itemSpecialTypes) {
        this.itemSpecialTypes = itemSpecialTypes;
    }

    public boolean isCombo() {
        return this.isCombo;
    }

    public void setCombo(boolean isCombo) {
        this.isCombo = isCombo;
    }

    public long getTimeModify() {
        return this.timeModify;
    }

    public void setTimeModify(long timeModify) {
        this.timeModify = timeModify;
    }

    public int getNumberOfPeopleEat() {
        return this.numberOfPeopleEat;
    }

    public void setNumberOfPeopleEat(int numberOfPeopleEat) {
        this.numberOfPeopleEat = numberOfPeopleEat;
    }

    public String getSrcImgSquare() {
        return this.srcImgSquare;
    }

    public void setSrcImgSquare(String srcImgSquare) {
        this.srcImgSquare = srcImgSquare;
    }
}
