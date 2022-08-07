/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import DTO.DetailDTO;
import Utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Quang Nguyen
 */
public class DetailDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public int insertDetail(DetailDTO dto) throws SQLException, Exception {
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert into Details(price,quantity,OrderID,productID) values(?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setFloat(1, dto.getPrice());
                ps.setInt(2, dto.getQuantity());
                ps.setInt(3, dto.getOrderID());
                ps.setString(4, dto.getProduct().getProductID());
                return ps.executeUpdate();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }

        return -1;
    }
}
