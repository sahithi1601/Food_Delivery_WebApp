package com.Dao;

import java.util.List;
import com.model.CartItem;

public interface CartDao {

    List<CartItem> getAllCartItemsByUserId(int userId);

    boolean addToCart(CartItem cart);

    boolean removeFromCart(int cartId);

    boolean clearCartByUserId(int userId);
}
