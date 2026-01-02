package com.Dao;

import com.model.User;

public interface UserDao {
    User login(String email, String password) throws Exception;
    User getUserById(int userId) throws Exception;
    void updateLastLogin(int userId) throws Exception;
}
