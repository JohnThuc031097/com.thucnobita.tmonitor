package com.thucnobita.tmonitor.entity;

public class COModifier extends COBaseItem {
	private double price;
    private double quantity;
    private int type;
    private int numberOfChili;

    public int getType() {
        return this.type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNumberOfChili() {
        return this.numberOfChili;
    }

    public void setNumberOfChili(int numberOfChili) {
        this.numberOfChili = numberOfChili;
    }

    public COModifier() {
    }

    public COModifier(String code) {
        this.setCode(code);
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getQuantity() {
        return this.quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }
}
