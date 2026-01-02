package com.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    private Map<Integer, CartItem> items = new HashMap<>();

    public void addItem(CartItem item) {
        int id = item.getId();
        if (items.containsKey(id)) {
            items.get(id).setQuantity(
                items.get(id).getQuantity() + item.getQuantity()
            );
        } else {
            items.put(id, item);
        }
    }
    
    public void updateItem(int itemId, int quantity) {
    	if(items.containsKey(itemId)) {
    		if(quantity<=0) {
    			items.remove(itemId);
    		}else {
    			CartItem existingcartItems=items.get(itemId);
    			existingcartItems.setQuantity(quantity);
    		}
    	}
    }

    public void removeItem(int id) {
        items.remove(id);
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items.values()) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

