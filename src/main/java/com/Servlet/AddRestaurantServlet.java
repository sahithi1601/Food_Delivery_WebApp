package com.Servlet;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.model.Restaurant;
import java.io.IOException;
import com.DaoImpl.RestaurantDaoImpl;
import com.Dao.RestaurantDao;
	@WebServlet("/addRestaurant")
	public class AddRestaurantServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	            throws IOException {

	        Restaurant r = new Restaurant();
	        r.setName(req.getParameter("name"));
	        r.setCuisine(req.getParameter("cuisine"));
	        r.setLocation(req.getParameter("location"));
	        r.setRating(Double.parseDouble(req.getParameter("rating")));
	        r.setEta(Integer.parseInt(req.getParameter("eta")));
	        r.setImage(req.getParameter("image"));

	        RestaurantDao dao = new RestaurantDaoImpl();

	        if (dao.addRestaurant(r)) {
	            resp.sendRedirect("admin/adminDashboard.jsp?success=1");
	        }
	    }
	}