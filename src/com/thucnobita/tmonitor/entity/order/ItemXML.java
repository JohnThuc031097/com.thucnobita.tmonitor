package com.thucnobita.tmonitor.entity.order;

import java.awt.Color;

public class ItemXML {
	private long id;
    private long itemId;
    private String code;
    private String name;
    private String altName;
    private Integer status;
    private long parentId;
    private String shortName;
    private String saleObjectType;
    private String rightLvl;
    private String tradeObject;
    private String refCollName;
    private long objectSifr;
    private String guidString;
    private int flags;
    private String address;
    private String genGggrname;
    private String genGggtel;
    private String genGggadd;
    private String genGggweb;
    private String genGggrco;
    private String genSapcode;
    private String genGggbrand;
    private String genSapbankterminalid;
    private String sapCode;

    public String getSapCode() {
        return this.sapCode;
    }

    public void setSapCode(String sapCode) {
        this.sapCode = sapCode;
    }

    public String getGenGggrname() {
        return this.genGggrname;
    }

    public void setGenGggrname(String genGggrname) {
        this.genGggrname = genGggrname;
    }

    public String getGenGggtel() {
        return this.genGggtel;
    }

    public void setGenGggtel(String genGggtel) {
        this.genGggtel = genGggtel;
    }

    public String getGenGggadd() {
        return this.genGggadd;
    }

    public void setGenGggadd(String genGggadd) {
        this.genGggadd = genGggadd;
    }

    public String getGenGggweb() {
        return this.genGggweb;
    }

    public void setGenGggweb(String genGggweb) {
        this.genGggweb = genGggweb;
    }

    public String getGenGggrco() {
        return this.genGggrco;
    }

    public void setGenGggrco(String genGggrco) {
        this.genGggrco = genGggrco;
    }

    public String getGenSapcode() {
        return this.genSapcode;
    }

    public void setGenSapcode(String genSapcode) {
        this.genSapcode = genSapcode;
    }

    public String getGenGggbrand() {
        return this.genGggbrand;
    }

    public void setGenGggbrand(String genGggbrand) {
        this.genGggbrand = genGggbrand;
    }

    public String getGenSapbankterminalid() {
        return this.genSapbankterminalid;
    }

    public void setGenSapbankterminalid(String genSapbankterminalid) {
        this.genSapbankterminalid = genSapbankterminalid;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return this.itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
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

    public String getAltName() {
        return this.altName;
    }

    public void setAltName(String altName) {
        this.altName = altName;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getParentId() {
        return this.parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getShortName() {
        return this.shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getSaleObjectType() {
        return this.saleObjectType;
    }

    public void setSaleObjectType(String saleObjectType) {
        this.saleObjectType = saleObjectType;
    }

    public String getRightLvl() {
        return this.rightLvl;
    }

    public void setRightLvl(String rightLvl) {
        this.rightLvl = rightLvl;
    }

    public String getTradeObject() {
        return this.tradeObject;
    }

    public void setTradeObject(String tradeObject) {
        this.tradeObject = tradeObject;
    }

    public String getRefCollName() {
        return this.refCollName;
    }

    public void setRefCollName(String refCollName) {
        this.refCollName = refCollName;
    }

    public long getObjectSifr() {
        return this.objectSifr;
    }

    public void setObjectSifr(long objectSifr) {
        this.objectSifr = objectSifr;
    }

    public static void main(String[] args) {
        int dec = Math.toIntExact(0xFFFF00L);
        int red = dec % 256;
        int green = dec / 256 % 256;
        int blue = dec / 65536 % 256;
        Color color = null;
        color = new Color(red, green, blue);
        String hex = Integer.toHexString(color.getRGB() & 0xFFFFFF);
        while (hex.length() < 6) {
            hex = "0" + hex;
        }
        hex = "#" + hex;
    }

    public String getGuidString() {
        return this.guidString;
    }

    public void setGuidString(String guidString) {
        this.guidString = guidString;
    }

    public int getFlags() {
        return this.flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
}
