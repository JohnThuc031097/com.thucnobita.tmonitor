package com.thucnobita.tmonitor.entity.order;

import java.util.ArrayList;
import java.util.List;

import com.thucnobita.tmonitor.entity.MenuItems;
import com.thucnobita.tmonitor.model.xml.VoidDish;

public class Dish {
    private long id;
    private long coDishId;
    private String lineGuid;
    private MenuItems menuItem;
    private long price;
    private double quantity;
    private double remainQuantity;
    private long uni;
    private String note;
    private List<VoidDish> voidDishes;
    private boolean delPrint;
    private boolean editable;
    private String comboName;
    private boolean isCombo;
    private boolean isComboRequire;
    private List<Discount> lstDiscountDish;
    private Long removeItemNoPrice;
    private String comboModi;
    private double quantityVoid;
    private ConfigCooking configCooking;
    private int statusKds;
    private int priority;
    private double finishQuantity;
    private double deliveryQuantity;
    private double cancelQuantity;
    private long amount;
    private boolean needCook;
    private double cookQuantity;
    private int status;
    private double delivered;
    private double deliveredSession;
    private Boolean isUpdateDelivered;
    private List<OrderModifier> lstModi;

    public boolean isNeedCook() {
        return this.needCook;
    }

    public void setNeedCook(boolean needCook) {
        this.needCook = needCook;
    }

    public double getCookQuantity() {
        return this.cookQuantity;
    }

    public void setCookQuantity(double cookQuantity) {
        this.cookQuantity = cookQuantity;
    }

    public long getAmount() {
        return this.amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public double getCancelQuantity() {
        return this.cancelQuantity;
    }

    public void setCancelQuantity(double cancelQuantity) {
        this.cancelQuantity = cancelQuantity;
    }

    public double getFinishQuantity() {
        return this.finishQuantity;
    }

    public void setFinishQuantity(double finishQuantity) {
        this.finishQuantity = finishQuantity;
    }

    public double getDeliveryQuantity() {
        return this.deliveryQuantity;
    }

    public void setDeliveryQuantity(double deliveryQuantity) {
        this.deliveryQuantity = deliveryQuantity;
    }

    public String getComboModi() {
        return this.comboModi;
    }

    public void setComboModi(String comboModi) {
        this.comboModi = comboModi;
    }

    public Long getRemoveItemNoPrice() {
        return this.removeItemNoPrice;
    }

    public void setRemoveItemNoPrice(Long removeItemNoPrice) {
        this.removeItemNoPrice = removeItemNoPrice;
    }

    public Boolean getIsUpdateDelivered() {
        return this.isUpdateDelivered;
    }

    public void setIsUpdateDelivered(Boolean isUpdateDelivered) {
        this.isUpdateDelivered = isUpdateDelivered;
    }

    public double getDeliveredSession() {
        return this.deliveredSession;
    }

    public void setDeliveredSession(double deliveredSession) {
        this.deliveredSession = deliveredSession;
    }

    public Dish() {
        this.editable = true;
        this.lstModi = new ArrayList<OrderModifier>();
        this.lstDiscountDish = new ArrayList<Discount>();
    }

    public Dish(String code, double quantity) {
        this.menuItem = new MenuItems(code);
        this.quantity = quantity;
        this.editable = true;
    }

    public Dish(String code, String name, double quantity) {
        this.menuItem = new MenuItems(code, name);
        this.quantity = quantity;
        this.editable = true;
    }

    public List<Discount> getLstDiscountDish() {
        return this.lstDiscountDish;
    }

    public void setLstDiscountDish(List<Discount> lstDiscountDish) {
        this.lstDiscountDish = lstDiscountDish;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MenuItems getMenuItem() {
        return this.menuItem;
    }

    public void setMenuItem(MenuItems menuItem) {
        this.menuItem = menuItem;
    }

    public long getPrice() {
        return this.price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getLineGuid() {
        return this.lineGuid;
    }

    public void setLineGuid(String lineGuid) {
        this.lineGuid = lineGuid;
    }

    public List<OrderModifier> getLstModi() {
        return this.lstModi;
    }

    public void setLstModi(List<OrderModifier> lstModi) {
        this.lstModi = lstModi;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public long getUni() {
        return this.uni;
    }

    public void setUni(long uni) {
        this.uni = uni;
    }

    public String getNote() {
        return this.note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean isDelPrint() {
        return this.delPrint;
    }

    public void setDelPrint(boolean delPrint) {
        this.delPrint = delPrint;
    }

    public List<VoidDish> getVoidDishes() {
        return this.voidDishes;
    }

    public void setVoidDishes(List<VoidDish> voidDishes) {
        this.voidDishes = voidDishes;
    }

    public String getComboName() {
        return this.comboName;
    }

    public void setComboName(String comboName) {
        this.comboName = comboName;
    }

    public double getDelivered() {
        return this.delivered;
    }

    public void setDelivered(double delivered) {
        this.delivered = delivered;
    }

    public long getCoDishId() {
        return this.coDishId;
    }

    public void setCoDishId(long coDishId) {
        this.coDishId = coDishId;
    }

    public boolean isEditable() {
        return this.editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public boolean isComboRequire() {
        return this.isComboRequire;
    }

    public void setComboRequire(boolean isComboRequire) {
        this.isComboRequire = isComboRequire;
    }

    public boolean isCombo() {
        return this.isCombo;
    }

    public void setCombo(boolean isCombo) {
        this.isCombo = isCombo;
    }

    public ConfigCooking getConfigCooking() {
        return this.configCooking;
    }

    public void setConfigCooking(ConfigCooking configCooking) {
        this.configCooking = configCooking;
    }

    public int getStatusKds() {
        return this.statusKds;
    }

    public void setStatusKds(int statusKds) {
        this.statusKds = statusKds;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public double getQuantityVoid() {
        return this.quantityVoid;
    }

    public void setQuantityVoid(double quantityVoid) {
        this.quantityVoid = quantityVoid;
    }

    public double getRemainQuantity() {
        return this.remainQuantity;
    }

    public void setRemainQuantity(double remainQuantity) {
        this.remainQuantity = remainQuantity;
    }
}
