package com.DaoImpl;

import com.Dao.CartDao;
import com.model.CartItem;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {

    @Override
    public List<CartItem> getAllCartItemsByUserId(int userId) {

        List<CartItem> list = new ArrayList<>();
        String sql = "SELECT * FROM cart WHERE user_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                CartItem c = new CartItem();
                c.setId(rs.getInt("cart_id"));
                c.setUserId(rs.getInt("user_id"));
                c.setRestaurantId(rs.getInt("restaurant_id"));
                c.setName(rs.getString("item_name"));   // ✅ FIX
                c.setPrice(rs.getDouble("price"));
                c.setQuantity(rs.getInt("quantity"));
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean addToCart(CartItem cart) {

        String sql = "INSERT INTO cart (user_id, restaurant_id, item_name, price, quantity) VALUES (?,?,?,?,?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cart.getUserId());
            ps.setInt(2, cart.getRestaurantId());
            ps.setString(3, cart.getName());   // ✅ FIX
            ps.setDouble(4, cart.getPrice());
            ps.setInt(5, cart.getQuantity());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean removeFromCart(int cartId) {

        String sql = "DELETE FROM cart WHERE cart_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, cartId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean clearCartByUserId(int userId) {

        String sql = "DELETE FROM cart WHERE user_id=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

