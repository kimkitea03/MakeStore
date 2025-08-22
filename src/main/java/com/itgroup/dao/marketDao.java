package com.itgroup.dao;


import com.itgroup.bean.client;
import com.itgroup.bean.market;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class marketDao extends superDao{
    public marketDao() {
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
}
