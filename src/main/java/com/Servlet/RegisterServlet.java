package com.Servlet;

import java.io.IOException;
import java.sql.Connection;

import com.Dao.LoginDao;
import com.DaoImpl.LoginDaoImpl;
import com.util.DBUtil;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection con = DBUtil.getConnection();
            LoginDao dao = new LoginDaoImpl(con);

            if (dao.registerUser(username, email, password)) {
                response.sendRedirect("login.html");
            } else {
                response.sendRedirect("register.html");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.html");
        }
    }
}
