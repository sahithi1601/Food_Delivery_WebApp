package com.Servlet;

import com.Dao.RestaurantDao;
import com.DaoImpl.RestaurantDaoImpl;
import com.model.Restaurant;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.util.List;

@WebServlet("/restaurants")
public class RestaurtantServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RestaurantDao dao = new RestaurantDaoImpl();
        List<Restaurant> restaurants = dao.getAllRestaurants();

        // 🔥 ATTRIBUTE NAME MATCHED
        request.setAttribute("restaurants", restaurants);

        RequestDispatcher rd = request.getRequestDispatcher("restaurant.jsp");
        rd.forward(request, response);
    }
}

