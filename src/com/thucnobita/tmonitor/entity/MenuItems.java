package com.thucnobita.tmonitor.entity;

import com.thucnobita.tmonitor.entity.order.ItemXML;

public class MenuItems
extends ItemXML {
    private long modiScheme;
    private long comboScheme;
    private int comboJoinMode;
    private String displayName;
    private double orderQuantity;
    private double inventoryQuantity;

    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public MenuItems() {
    }

    public MenuItems(String code) {
        this.setCode(code);
    }

    public MenuItems(String code, String name) {
        this.setCode(code);
        this.setName(name);
    }

    public long getModiScheme() {
        return this.modiScheme;
    }

    public void setModiScheme(long modiScheme) {
        this.modiScheme = modiScheme;
    }

    public long getComboScheme() {
        return this.comboScheme;
    }

    public void setComboScheme(long comboScheme) {
        this.comboScheme = comboScheme;
    }

    public int getComboJoinMode() {
        return this.comboJoinMode;
    }

    public void setComboJoinMode(int comboJoinMode) {
        this.comboJoinMode = comboJoinMode;
    }

    public double getOrderQuantity() {
        return this.orderQuantity;
    }

    public void setOrderQuantity(double orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public double getInventoryQuantity() {
        return this.inventoryQuantity;
    }

    public void setInventoryQuantity(double inventoryQuantity) {
        this.inventoryQuantity = inventoryQuantity;
    }
}