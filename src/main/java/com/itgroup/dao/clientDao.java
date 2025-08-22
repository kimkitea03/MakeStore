package com.itgroup.dao;

import com.itgroup.bean.client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clientDao extends superDao{

    public int checkLogin(String findId, String findpw) {
        String sql = "SELECT COUNT(*) AS cnt FROM clie WHERE cid = ? AND cpassword = ?";
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

    public client getMemberone(String findId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        client bean = null;

        String sql = "select * from clie where cid = ?";

        try {
            conn = super.getconnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,findId);
            rs = pstmt.executeQuery();

            if (rs.next()){
                bean = new client();
                bean.setCid(rs.getString("cid"));
                bean.setCname(rs.getString("cname"));
                bean.setCpassword(rs.getString("cpassword"));
                bean.setCby(rs.getString("cby"));
                bean.setTotal(rs.getInt("total"));
                bean.setMembership(rs.getString("membership"));
                bean.setBasket(rs.getString("basket"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rs != null){rs.close();}
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;

    }


    public client getTotal(String findId) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        client bean = null;

        String sql = "select total from clie where cid = ?";
        try {
            conn = super.getconnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,findId);
            rs = pstmt.executeQuery();

            if (rs.next()){
                bean = new client();
                bean.setTotal(rs.getInt("total"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rs != null){rs.close();}
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;

    }

    public client getbasket(String Id) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        client bean = null;

        String sql = "select basket from clie where cid = ?";

        try {
            conn = super.getconnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,Id);
            rs = pstmt.executeQuery();

            if (rs.next()){
                bean = new client();
                bean.setBasket(rs.getString("basket"));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                if(rs != null){rs.close();}
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return bean;

    }


    public int pushbasket(String post,String Id) {
        int cnt =-1;
        String sql = "update clie set basket = ? where cid = ?";
        Connection conn = null;
        PreparedStatement  pstmt = null;
        try {
            conn = super.getconnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1,post);
            pstmt.setString(2,Id);

            cnt=pstmt.executeUpdate();
            conn.commit();
        }catch (Exception e){
            e.printStackTrace();
            try {

            }catch (Exception e2){
                e2.printStackTrace();
            }
        }finally {
            try {

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cnt;
    }
}
