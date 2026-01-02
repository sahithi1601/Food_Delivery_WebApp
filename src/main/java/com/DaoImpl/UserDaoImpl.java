package com.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Date;

import com.Dao.UserDao;
import com.model.User;
import com.util.DBUtil;

public class UserDaoImpl implements UserDao {

    private static final String LOGIN_SQL =
        "SELECT * FROM user WHERE email=? AND password=?";

    private static final String GET_BY_ID_SQL =
        "SELECT * FROM user WHERE user_id=?";

    private static final String UPDATE_LAST_LOGIN =
        "UPDATE user SET last_login=? WHERE user_id=?";

    @Override
    public User login(String email, String password) throws Exception {

        User user = null;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(LOGIN_SQL)) {

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setRole(rs.getString("role"));
                user.setLastLogin(rs.getDate("last_login"));
            }
        }

        // update last login after successful login
        if (user != null) {
            updateLastLogin(user.getUserId());
        }

        return user;
    }

    @Override
    public User getUserById(int userId) throws Exception {

        User user = null;

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(GET_BY_ID_SQL)) {

            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setPhoneNumber(rs.getString("phone_number"));
                user.setRole(rs.getString("role"));
                user.setLastLogin(rs.getDate("last_login"));
            }
        }
        return user;
    }

    @Override
    public void updateLastLogin(int userId) throws Exception {

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(UPDATE_LAST_LOGIN)) {

            ps.setDate(1, new Date(System.currentTimeMillis()));
            ps.setInt(2, userId);
            ps.executeUpdate();
        }
    }
}
