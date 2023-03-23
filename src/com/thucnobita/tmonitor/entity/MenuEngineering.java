package com.thucnobita.tmonitor.entity;

import java.util.ArrayList;
import java.util.List;

import com.thucnobita.tmonitor.entity.order.Dish;
import com.thucnobita.tmonitor.entity.order.OrderCategory;

public class MenuEngineering {
	private OrderCategory orderCategory;
    private String menuType;
    private Dish defaultDish;
    private Dish childDish;
    private List<MenuGroup> menuGroups = new ArrayList<MenuGroup>();

    public OrderCategory getOrderCategory() {
        return this.orderCategory;
    }

    public void setOrderCategory(OrderCategory orderCategory) {
        this.orderCategory = orderCategory;
    }

    public String getMenuType() {
        return this.menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType;
    }

    public Dish getDefaultDish() {
        return this.defaultDish;
    }

    public void setDefaultDish(Dish defaultDish) {
        this.defaultDish = defaultDish;
    }

    public Dish getChildDish() {
        return this.childDish;
    }

    public void setChildDish(Dish childDish) {
        this.childDish = childDish;
    }

    public List<MenuGroup> getMenuGroups() {
        return this.menuGroups;
    }

    public void setMenuGroups(List<MenuGroup> menuGroups) {
        this.menuGroups = menuGroups;
    }
}
