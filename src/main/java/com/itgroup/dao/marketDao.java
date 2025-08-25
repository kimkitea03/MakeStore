package com.itgroup.dao;


import com.itgroup.bean.market;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class marketDao extends superDao{
    public marketDao() {
    }

    public int setNomandProce(int findPrice, int findNo, String id) {
        int cnt=-1;
        String spl = " update market set price = ? where nom = ? and seller = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = super.getconnection();
            pstmt=conn.prepareStatement(spl);
            pstmt.setInt(1,findPrice);
            pstmt.setInt(2,findNo);
            pstmt.setString(3,id);
            cnt=pstmt.executeUpdate();
            conn.commit();
        }catch (Exception ex){
            try {
                conn.rollback();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }finally {
            try {
                if(conn != null){conn.close();}
                if(pstmt != null){pstmt.close();}

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    }


    public List<market> lookpost() {

        List<market> clie = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from market order by nom asc";
        Connection conn = null;
        try{
            conn = super.getconnection() ;
            pstmt= conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while ((rs.next())){
                market bean = new market();
                bean.setNom(rs.getInt("nom"));
                bean.setPost(rs.getString("post"));
                bean.setPrice(rs.getInt("price"));
                bean.setKind(rs.getString("kind"));
                bean.setSeller(rs.getString("seller"));
                bean.setOnoff(rs.getInt("onoff"));

                clie.add(bean);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if (rs != null) {rs.close();}
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return  clie;
    }

    public List<market> lookposte(String id) {
        List<market> clie = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from market where seller = ? order by nom asc ";
        Connection conn = null;
        try{
            conn = super.getconnection() ;
            pstmt= conn.prepareStatement(sql);

            pstmt.setString(1,id);
            rs = pstmt.executeQuery();

            while ((rs.next())){
                market bean = new market();
                bean.setNom(rs.getInt("nom"));
                bean.setPost(rs.getString("post"));
                bean.setPrice(rs.getInt("price"));
                bean.setKind(rs.getString("kind"));
                bean.setSeller(rs.getString("seller"));
                bean.setOnoff(rs.getInt("onoff"));

                clie.add(bean);
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if (rs != null) {rs.close();}
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return  clie;
    }

    public market lookpostet(String id) {

        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "select * from market order by nom asc";
        Connection conn = null;
        market bean = new market();
        try{
            conn = super.getconnection() ;
            pstmt= conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while ((rs.next())){
                bean.setNom(rs.getInt("nom"));
                bean.setPost(rs.getString("post"));
                bean.setPrice(rs.getInt("price"));
                bean.setKind(rs.getString("kind"));
                bean.setSeller(rs.getString("seller"));
                bean.setOnoff(rs.getInt("onoff"));
            }

        }catch (Exception ex){
            ex.printStackTrace();
        }finally {
            try{
                if (rs != null) {rs.close();}
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        return  bean;
    }

    public int plusmarketpost(market bean) {
        int cnt = -1;
        String sql = "insert into market(nom, post,price,kind,seller,onoff)";
        sql += " values(seqmarket.nextval,? ,? ,? ,?,? )";
        Connection conn = null;
        PreparedStatement  pstmt = null;
        try {
            conn = super.getconnection();
            pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, bean.getPost());
            pstmt.setInt(2,bean.getPrice());
            pstmt.setString(3, bean.getKind());
            pstmt.setString(4, bean.getSeller());
            pstmt.setInt(5,bean.getOnoff());
            cnt = pstmt.executeUpdate();
            conn.commit();
        }catch (Exception ex){
            try {

            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
        }finally {
            try {
                if(pstmt != null){pstmt.close();}
                if(conn != null){conn.close();}
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return cnt;
    }


    public int delmarketpost(int nom) {
        int cnt = -1;
        String sql = "delete from market where nom = ?";
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            conn=super.getconnection();
            pstmt =conn.prepareStatement(sql);
            pstmt.setInt(1,nom);

            cnt=pstmt.executeUpdate();

            conn.commit();

        }catch (Exception ex){
            try{
                conn.rollback();
            }catch (Exception ex2) {
                ex2.printStackTrace();
            }
            ex.printStackTrace();
        }finally {
            try{
                if(conn != null){conn.close();}
                if(pstmt != null){pstmt.close();}
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
        return cnt;

    }
}
