package com.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import com.DaoImpl.MenuDaoImpl;
import com.model.Cart;
import com.model.CartItem;
import com.model.Menu;

import java.io.IOException;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handle(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handle(request, response);
    }

    private void handle(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if ("add".equals(action)) {
            addItemToCart(request, cart);
        }
        else if ("update".equals(action)) {
            updateItemOfCart(request, cart);
        }
        else if ("delete".equals(action)) {
            int id = Integer.parseInt(request.getParameter("id"));
            cart.removeItem(id);
        }

        response.sendRedirect("Cart.jsp");
    }

    private void addItemToCart(HttpServletRequest request, Cart cart) {

        int itemId = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        MenuDaoImpl dao = new MenuDaoImpl();
        Menu menu = dao.getMenuById(itemId);

        CartItem item = new CartItem();
        item.setId(itemId);
        item.setName(menu.getName());
        item.setPrice(menu.getPrice());
        item.setQuantity(quantity);

        cart.addItem(item);
    }

    private void updateItemOfCart(HttpServletRequest request, Cart cart) {

        int id = Integer.parseInt(request.getParameter("id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (quantity <= 0) {
            cart.removeItem(id);
        } else {
            cart.getItems().get(id).setQuantity(quantity);
        }
    }
}

    	
