package com.Servlet;

import com.Dao.AdminDao;
import com.DaoImpl.AdminDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/admin/adminLogin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AdminDao dao = new AdminDaoImpl();
        if (dao.validate(username, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("admin", username);
            resp.sendRedirect(req.getContextPath() + "/admin/adminDashboard.jsp");
        } else {
            req.setAttribute("error", "Invalid credentials");
            req.getRequestDispatcher("/admin/adminLogin.jsp").forward(req, resp);
        }
    }
}

