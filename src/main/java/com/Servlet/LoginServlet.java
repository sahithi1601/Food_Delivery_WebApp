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
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // dummy validation (replace with DB check)
        if(email != null && password != null) {
        	response.sendRedirect("restaurants");

        } else {
            response.sendRedirect("login.jsp");
        }
    }
}

