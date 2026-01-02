package com.DaoImpl;

import com.Dao.RestaurantDao;
import com.model.Restaurant;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDaoImpl implements RestaurantDao {

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> list = new ArrayList<>();
        String sql = "SELECT * FROM restaurants";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Restaurant r = new Restaurant();
                r.setId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setCuisine(rs.getString("cuisine"));
                r.setLocation(rs.getString("location"));
                r.setRating(rs.getDouble("rating"));
                r.setEta(rs.getInt("eta"));
                r.setImage(rs.getString("image"));
                list.add(r);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant r = null;
        String sql = "SELECT * FROM restaurants WHERE restaurant_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                r = new Restaurant();
                r.setId(rs.getInt("restaurant_id"));
                r.setName(rs.getString("name"));
                r.setCuisine(rs.getString("cuisine"));
                r.setLocation(rs.getString("location"));
                r.setRating(rs.getDouble("rating"));
                r.setEta(rs.getInt("eta"));
                r.setImage(rs.getString("image"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return r;
    }

    @Override
    public boolean addRestaurant(Restaurant r) {
        String sql = "INSERT INTO restaurants(name, cuisine, location, rating, eta, image) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, r.getName());
            ps.setString(2, r.getCuisine());
            ps.setString(3, r.getLocation());
            ps.setDouble(4, r.getRating());
            ps.setInt(5, r.getEta());
            ps.setString(6, r.getImage());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}


