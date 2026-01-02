
package com.Servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.annotation.WebServlet;
import javax.swing.JMenu;
import com.DaoImpl.MenuDaoImpl;
import java.io.IOException;
import java.util.List;
import com.model.Menu;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("restaurantId");

        if (idStr == null || idStr.isEmpty()) {
            response.getWriter().println("Error: restaurantId parameter is missing!");
            return;
        }

        int restaurantId = Integer.parseInt(idStr);

        MenuDaoImpl dao = new MenuDaoImpl();
        List<Menu> menuList = dao.getMenuByRestaurantId(restaurantId);

        request.setAttribute("menuList", menuList);
        RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
        rd.forward(request, response);
    }
}
