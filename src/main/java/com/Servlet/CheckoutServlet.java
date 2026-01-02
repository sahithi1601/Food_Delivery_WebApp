package com.Servlet;

import java.io.IOException;
import java.sql.Timestamp;

import com.DaoImpl.OrderDaoImpl;
import com.DaoImpl.OrderItemDaoImpl;
import com.model.Cart;
import com.model.CartItem;
import com.model.Order;
import com.model.OrderItem;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Cart cart = (Cart) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        Integer restaurantId = (Integer) session.getAttribute("oldRestaurantId");

        String address = request.getParameter("address");
        String paymentMethod = request.getParameter("paymentMethod");

        // If user not logged in
        if (user == null) {
            RequestDispatcher rd = request.getRequestDispatcher("login.html");
            rd.forward(request, response);
            return;
        }

        // If cart empty
        if (cart == null || cart.getItems().isEmpty()) {
            response.sendRedirect("Cart.jsp");
            return;
        }

        Order order = new Order();
        order.setUserId(user.getUserId());
        order.setRestaurantId(restaurantId);
        order.setOrderDate(new Timestamp(System.currentTimeMillis()));
        order.setAddress(address);
        order.setStatus("PENDING");
        order.setPaymentMethod(paymentMethod);

        double totalAmount = 0.0;
        for (CartItem item : cart.getItems().values()) {
            totalAmount += item.getQuantity() * item.getPrice();
        }
        order.setTotalAmount(totalAmount);

        try {
            OrderDaoImpl orderDao = new OrderDaoImpl();
            int orderId = orderDao.addOrder(order);

            OrderItemDaoImpl orderItemDao = new OrderItemDaoImpl();

            for (CartItem item : cart.getItems().values()) {
                OrderItem orderItem = new OrderItem();
                orderItem.setOrderId(orderId);
                orderItem.setMenuId(item.getMenuId());
                orderItem.setQuantity(item.getQuantity());
                orderItem.setItemTotal(item.getQuantity() * item.getPrice());

                orderItemDao.addOrderItem(orderItem);
            }


            session.removeAttribute("cart");
            session.removeAttribute("oldRestaurantId");

            response.sendRedirect("orderConfirmation.jsp");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Checkout.jsp");
        }
    }
}

