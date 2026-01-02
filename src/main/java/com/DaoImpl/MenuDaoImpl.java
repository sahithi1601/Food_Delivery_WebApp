package com.DaoImpl;

import com.Dao.MenuDao;
import com.model.Menu;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MenuDaoImpl implements MenuDao {

    @Override
    public List<Menu> getMenuByRestaurantId(int restaurantId) {
        List<Menu> list = new ArrayList<>();
        String sql = "SELECT * FROM menu WHERE restaurant_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Menu m = new Menu();
                m.setMenuId(rs.getInt("menu_id"));
                m.setRestaurantId(rs.getInt("restaurant_id"));
                m.setName(rs.getString("name"));
                m.setDescription(rs.getString("description"));
                m.setPrice(rs.getDouble("price"));
                m.setRating(rs.getDouble("rating"));
                m.setImageUrl(rs.getString("image_url"));
                list.add(m);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    public Menu getMenuById(int menuId) {

        Menu menu = null;
        String sql = "SELECT * FROM menu WHERE menu_id = ?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, menuId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                menu = new Menu();
                menu.setMenuId(rs.getInt("menu_id"));
                menu.setRestaurantId(rs.getInt("restaurant_id"));
                menu.setName(rs.getString("name"));
                menu.setDescription(rs.getString("description"));
                menu.setPrice(rs.getDouble("price"));
                menu.setRating(rs.getDouble("rating"));
                menu.setImageUrl(rs.getString("image_url"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return menu;
    }

    public boolean addMenu(Menu m) {
        // ✅ Corrected column names
        String sql = "INSERT INTO menu (restaurant_id, name, description, price, rating, image_url) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, m.getRestaurantId());
            ps.setString(2, m.getName());          // maps to 'name' column
            ps.setString(3, m.getDescription());
            ps.setDouble(4, m.getPrice());
            ps.setDouble(5, m.getRating());
            ps.setString(6, m.getImageUrl());       // maps to 'image_url' column

            int rows = ps.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }return false;
        

  }
}


