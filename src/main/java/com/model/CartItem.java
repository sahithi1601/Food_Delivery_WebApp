package com.model;

public class CartItem {

    private int id;
    private String name;
    private int quantity;
    private double price;
    private int userId;
    private int restaurantId;

    private int menuId;
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

public int getUserId() {
    return userId;
}

public void setUserId(int userId) {
    this.userId = userId;
}

public int getRestaurantId() {
    return restaurantId;
}

public void setRestaurantId(int restaurantId) {
    this.restaurantId = restaurantId;
}
public int getMenuId() {
    return menuId;
}

public void setMenuId(int menuId) {
    this.menuId = menuId;
}
}
