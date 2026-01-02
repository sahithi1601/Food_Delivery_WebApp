package com.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.Dao.OrderItemDao;
import com.model.OrderItem;
import com.util.DBUtil;

public class OrderItemDaoImpl implements OrderItemDao {

    private static final String INSERT_ORDER_ITEM =
        "INSERT INTO order_items (order_id, menu_id, quantity, item_total) VALUES (?, ?, ?, ?)";

    @Override
    public void addOrderItem(OrderItem orderItem) throws Exception {

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(INSERT_ORDER_ITEM)) {

            ps.setInt(1, orderItem.getOrderId());
            ps.setInt(2, orderItem.getMenuId());
            ps.setInt(3, orderItem.getQuantity());
            ps.setDouble(4, orderItem.getItemTotal());

            ps.executeUpdate();
        }
    }
}
