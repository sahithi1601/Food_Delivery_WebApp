package com.Servlet;



	import com.Dao.RestaurantDao;
	import com.DaoImpl.RestaurantDaoImpl;
	import com.model.Restaurant;

	import jakarta.servlet.*;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.*;

	import java.io.IOException;
	import java.util.List;

	@WebServlet("/admin/loadAddMenu")
	public class AdminAddMenuServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        RestaurantDao dao = new RestaurantDaoImpl();
	        List<Restaurant> restaurants = dao.getAllRestaurants();

	        request.setAttribute("restaurants", restaurants);
	        RequestDispatcher rd = request.getRequestDispatcher("/admin/addMenu.jsp");
	        rd.forward(request, response);
	    }
	}
