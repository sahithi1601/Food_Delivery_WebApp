package com.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Dao.OrderDao;
import com.model.Order;
import com.util.DBUtil;

public class OrderDaoImpl implements OrderDao {

    private static final String INSERT_ORDER =
        "INSERT INTO orders (user_id, restaurant_id, order_date, total_amount, delivery_address, status, payment_method) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?)";

    @Override
    public int addOrder(Order order) throws Exception {

        int orderId = 0;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_ORDER, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, order.getUserId());
            ps.setInt(2, order.getRestaurantId());
            ps.setTimestamp(3, order.getOrderDate());
            ps.setDouble(4, order.getTotalAmount());
            ps.setString(5, order.getAddress());
            ps.setString(6, order.getStatus());
            ps.setString(7, order.getPaymentMethod());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                orderId = rs.getInt(1);
            }
        }

        return orderId;
    }
}
