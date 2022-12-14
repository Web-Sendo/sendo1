/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import DTO.Category;
import Utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Quang Nguyen
 */
public class CategoryDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Category> getAllCategory() throws Exception {

        List<Category> result = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT categoryID,categoryName FROM Categories ";
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String categoryID = rs.getString("categoryID");
                    String categoryName = rs.getString("categoryName");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new Category(categoryID, categoryName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }

    public String getNameByID(String categoryID) throws Exception {
        String cateName = "";
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT categoryName FROM Categories where categoryID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, categoryID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cateName = rs.getString("categoryName");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return cateName;
    }
    public String getIDByName(String categoryName) throws Exception {
        String cateName = "";
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT categoryID FROM Category where categoryName=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, categoryName);
                rs = ps.executeQuery();
                while (rs.next()) {
                    cateName = rs.getString("categoryID");

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return cateName;
    }
}
