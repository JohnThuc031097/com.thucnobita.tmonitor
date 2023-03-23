package com.thucnobita.tmonitor.entity.order;

public class Modifier
extends ItemXML {
    private long dish;
    private int maxOneDish;

    public Modifier() {
    }

    public Modifier(String code) {
        this.setCode(code);
    }

    public long getDish() {
        return this.dish;
    }

    public void setDish(long dish) {
        this.dish = dish;
    }

    public int getMaxOneDish() {
        return this.maxOneDish;
    }

    public void setMaxOneDish(int maxOneDish) {
        this.maxOneDish = maxOneDish;
    }
}
