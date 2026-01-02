package com.Dao;

import java.util.List;
import com.model.Restaurant;

public interface RestaurantDao {
    List<Restaurant> getAllRestaurants();
    Restaurant getRestaurantById(int id);
    boolean addRestaurant(Restaurant r);
}
