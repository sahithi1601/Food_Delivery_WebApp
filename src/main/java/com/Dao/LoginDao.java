package com.Dao;

public interface LoginDao {

	

	    boolean isEmailExists(String email);

	    boolean validateLogin(String email, String password);

	    boolean registerUser(String username, String email, String password);
	}
