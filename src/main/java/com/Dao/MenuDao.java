package com.Dao;

import java.util.List;
import com.model.Menu;

public interface MenuDao {
    List<Menu> getMenuByRestaurantId(int restaurantId);

boolean addMenu(Menu m);
}
