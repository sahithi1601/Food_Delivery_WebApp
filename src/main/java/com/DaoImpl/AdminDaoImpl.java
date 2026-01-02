package com.DaoImpl;

import com.Dao.AdminDao;
import com.util.DBUtil;
import java.sql.*;

public class AdminDaoImpl implements AdminDao {

    @Override
    public boolean validate(String username, String password) {
        // ✅ Change table name to the correct one
        String sql = "SELECT * FROM administarion WHERE username=? AND password=?";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login success for user: " + username);
                return true;
            } else {
                System.out.println("Login failed for user: " + username);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

