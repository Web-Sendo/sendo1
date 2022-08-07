/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.User;
import Utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class UserDAO {
     private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
     public boolean checkEmail(String userID) throws Exception {
        boolean check = false;
        String sql = "select userName from Users where userID=?";
        try {
            con = DBHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return check;
    }

       public User checkLogin(String userID, String password) throws SQLException, Exception {
        User result = null;

        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT userID,userName,password,address,phone,roleID,status "
                        + "FROM Users "
                        + "WHERE userID = ? and password = ? ";
                ps = con.prepareStatement(sql);
                ps.setString(1, userID);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {

                    String name = rs.getString("userName");
                    String roleID = rs.getString("roleID");
                    String phone = rs.getString("phone");
                    String status = rs.getString("status");
                    String address = rs.getString("address");
                    result = new User(userID, name, password, address, phone, roleID, status);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }
        public String getStatus(String userID) throws Exception {
        String check = "";
        String sql = "select status from Users where userID=?";
        try {
            con = DBHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                check = rs.getString("status");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return check;
    }
}
