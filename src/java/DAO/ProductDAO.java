/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.Product;
import Utils.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoang.nqm
 */
public class ProductDAO {

    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    public List<Product> getAllProductUser() throws Exception {

        List<Product> result = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productID,productName,description,image,categoryID,status,price,quantity FROM Products where status='Active' and quantity>0";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String categoryID = rs.getString("categoryID");
                    String status = rs.getString("status");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    Product product = new Product(productID, productName, image, categoryID, status, description, quantity, price);
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }

    
    public List<Product> getAllProductAdmin() throws Exception {

        List<Product> result = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productID,productName,image,description,categoryID,status,price,quantity FROM Products ";

                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                          String description = rs.getString("description");
                    String categoryID = rs.getString("categoryID");
                    String status = rs.getString("status");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    CategoryDAO categoryDAO = new CategoryDAO();
                    Product product = new Product(productID, productName, image, categoryID, status, description, quantity, price);
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }
     public List<Product> pagingProduct(int index) throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT productID,productName,image,categoryID,description,status,price,quantity from Products \n"
                + "ORDER BY productID\n"
                + "OFFSET ? rows FETCH next 9 rows only";
        try {
            con = new DBHelper().getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, (index - 1) * 9);
            rs = ps.executeQuery();
            while (rs.next()) {
                String productID = rs.getString("productID");
                String productName = rs.getString("productName");
                String image = rs.getString("image");
                            String description = rs.getString("description");
                String categoryID = rs.getString("categoryID");
                String status = rs.getString("status");
                float price = rs.getFloat("price");
                int quantity = rs.getInt("quantity");
                CategoryDAO categoryDAO = new CategoryDAO();
                Product product = new Product(productID, productName, image,categoryDAO.getNameByID(categoryID), status, description, quantity, price);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return list;
    }
     
      public boolean deleteProduct(String productID) throws Exception {
        boolean check = false;
        try {
            con = new DBHelper().getConnection();
            if (con != null) {
                String sql = "update Products set status=? where productID=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, "Inactive");
                ps.setString(2, productID);
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return check;
    }
 public boolean checkProductID(String productID) throws Exception {
        boolean check = false;
        String sql = "select productName from Products where productID=?";
        try {
            con = DBHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, productID);
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

    public List<Product> getProductByCateID(String cateID) throws Exception {

        List<Product> result = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productID,productName,image,description,categoryID,status,price,quantity FROM Products WHERE categoryID=? and status='Active' and quantity>0";

                ps = con.prepareStatement(sql);
                ps.setString(1, cateID);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String categoryID = rs.getString("categoryID");
                    String status = rs.getString("status");
                    String description = rs.getString("description");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    Product product = new Product(productID, productName, image, categoryID, status, description, quantity, price);
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }

     public Product getProductByID(String productID) throws Exception {

        Product result = null;
        CategoryDAO cateDAO= new CategoryDAO();
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productID,productName,image,description,categoryID,status,price,quantity FROM Products WHERE productID=? ";

                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                rs = ps.executeQuery();
                while (rs.next()) {

                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String categoryID = rs.getString("categoryID");
                        String description = rs.getString("description");
                    String status = rs.getString("status");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    result = new Product(productID, productName, image,cateDAO.getNameByID(categoryID), status, description, quantity, price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }
     public Product getProductByID1(String productID) throws Exception {

        Product result = null;
        CategoryDAO cateDAO= new CategoryDAO();
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productID,productName,image,description,categoryID,status,price,quantity FROM Products WHERE productID=? ";

                ps = con.prepareStatement(sql);
                ps.setString(1, productID);
                rs = ps.executeQuery();
                while (rs.next()) {

                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String categoryID = rs.getString("categoryID");
                        String description = rs.getString("description");
                    String status = rs.getString("status");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    result = new Product(productID, productName, image,categoryID, status, description, quantity, price);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }
     public int getQuantityByID(String productID) throws Exception {
        int quantity = 0;
        String sql = "select quantity from Products where productID=?";
        try {
            con = DBHelper.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, productID);
            rs = ps.executeQuery();
            if (rs.next()) {
                quantity = rs.getInt("quantity");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return quantity;
    }
      public boolean updateQuantity(String productID, int quantity) throws Exception {
        boolean check = false;
        try {
            con = new DBHelper().getConnection();
            if (con != null) {
                String sql = "update Products set quantity=? where productID=?";
                ps = con.prepareStatement(sql);
                ps.setInt(1, quantity);
                ps.setString(2, productID);
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return check;
    }
public List<Product> getProductByName(String name) throws Exception {

        List<Product> result = null;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "SELECT productID,productName,image,description,categoryID,status,price,quantity FROM Products where productName like ?";

                ps = con.prepareStatement(sql);
                ps.setString(1, "%" + name + "%");
                rs = ps.executeQuery();
                while (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getString("productName");
                    String image = rs.getString("image");
                    String categoryID = rs.getString("categoryID");
                         String description = rs.getString("description");
                    String status = rs.getString("status");
                    float price = rs.getFloat("price");
                    int quantity = rs.getInt("quantity");
                    Product product = new Product(productID, productName, image, categoryID, status, description, quantity, price);
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return result;
    }
  public boolean addNewProduct(Product product) throws Exception {

        boolean check = false;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "insert into Products(productID,productName,image,description,categoryID,status,price,quantity) values(?,?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, product.getProductID());
                ps.setString(2, product.getProductName());
                ps.setString(3, product.getImage());
                    ps.setString(4, product.getDescription());
                ps.setString(5, product.getCategoryID());
                ps.setString(6, product.getStatus());
                ps.setFloat(7, product.getPrice());

                ps.setInt(8, product.getQuantity());

                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return check;
    }
public boolean updateProduct(Product product) throws Exception {
        boolean check = false;
        try {
            con = DBHelper.getConnection();
            if (con != null) {
                String sql = "update Products set productName=?,image=?,description=?,categoryID=?,status=?,price=?,quantity=? where productID=? ";
                ps = con.prepareStatement(sql);

                ps.setString(1, product.getProductName());
                ps.setString(2, product.getImage());
                         ps.setString(3, product.getDescription());
                ps.setString(4, product.getCategoryID());
                ps.setString(5, product.getStatus());
                ps.setFloat(6, product.getPrice());
                ps.setInt(7, product.getQuantity());
                ps.setString(8, product.getProductID());
                check = ps.executeUpdate() > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBHelper.closeConnection(rs, ps, con);
        }
        return check;
    }
}
