package com.itgroup.dao;

import com.itgroup.bean.marketer;

import java.sql.*;

public class marketerDao extends superDao {
    public marketerDao() {

    }

    public int checkLogin(String findId, String findpw) {
        String sql = "SELECT COUNT(*) AS cnt FROM marketer WHERE mid = ? AND mpassword = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int count = 0;

        try {
            conn = super.getconnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, findId);
            pstmt.setString(2, findpw);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                count = rs.getInt("cnt");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return count;
    }
}
