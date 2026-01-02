package com.Servlet;

import com.DaoImpl.MenuDaoImpl;
import com.model.Menu;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addMenu")
public class AddMenuServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Prevent NullPointerException
        String restaurantIdStr = req.getParameter("restaurantId");
        String priceStr = req.getParameter("price");
        String ratingStr = req.getParameter("rating");
        String itemName = req.getParameter("itemName");
        String description = req.getParameter("description");
        String image = req.getParameter("image");

        if (restaurantIdStr == null || priceStr == null || itemName == null || image == null) {
            // Missing required fields
            resp.sendRedirect(req.getContextPath() + "/admin/addMenu.jsp?error=missing");
            return;
        }

        try {
            Menu m = new Menu();
            m.setRestaurantId(Integer.parseInt(restaurantIdStr));
            m.setName(itemName);
            m.setDescription(description != null ? description : "");
            m.setPrice(Double.parseDouble(priceStr));
            m.setRating(ratingStr != null && !ratingStr.isEmpty() ? Double.parseDouble(ratingStr) : 0.0);
            m.setImageUrl(image);

            MenuDaoImpl dao = new MenuDaoImpl();
            if (dao.addMenu(m)) {
                resp.sendRedirect(req.getContextPath() + "/admin/adminDashboard.jsp?menuAdded=1");
            } else {
                resp.sendRedirect(req.getContextPath() + "/admin/addMenu.jsp?error=1");
            }

        } catch (NumberFormatException e) {
            // Handle invalid number inputs
            e.printStackTrace();
            resp.sendRedirect(req.getContextPath() + "/admin/addMenu.jsp?error=invalidNumber");
        }
    }
}
