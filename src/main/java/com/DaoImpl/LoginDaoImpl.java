package com.DaoImpl;

import com.Dao.LoginDao;




	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;

	import com.Dao.UserDao;

	public class LoginDaoImpl implements LoginDao {

	    private Connection con;

	    public LoginDaoImpl(Connection con) {
	        this.con = con;
	    }

	    @Override
	    public boolean isEmailExists(String email) {
	        try {
	            String sql = "SELECT 1 FROM user WHERE email=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean validateLogin(String email, String password) {
	        try {
	            String sql = "SELECT 1 FROM user WHERE email=? AND password=?";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, email);
	            ps.setString(2, password);
	            ResultSet rs = ps.executeQuery();
	            return rs.next();
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

	    @Override
	    public boolean registerUser(String username, String email, String password) {
	        try {
	            String sql = "INSERT INTO user(username,email,password) VALUES(?,?,?)";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setString(1, username);
	            ps.setString(2, email);
	            ps.setString(3, password);
	            return ps.executeUpdate() > 0;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	}

	
	