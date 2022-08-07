/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import DTO.AddProductError;
import DTO.Category;
import DTO.Product;
import DTO.User;
import jakarta.servlet.annotation.MultipartConfig;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ADMIN
 */
@MultipartConfig
public class AddProductController extends HttpServlet {

      private static final String ERROR = "create.jsp";
    private static final String SUCCESS = "MainController?action=admin";
    private static final String UPLOAD_DIR = "img/product";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        AddProductError err = new AddProductError();
        ProductDAO productDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();
        CategoryDAO categoryDAO = new CategoryDAO();
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("LOGIN_USER");
        try {
            if (user == null) {
                url = "LogoutController";
            } else {
                String userID = user.getUserID();
                String statusUser = userDAO.getStatus(userID);
                if (statusUser.equals("Active")) {
                    String productID = request.getParameter("productID");
                    String productName = request.getParameter("productName");
                    String price = request.getParameter("price");
                            String description = request.getParameter("description");
                    String quantity = request.getParameter("quantity");
                    String category = request.getParameter("category");
                    String fileName = request.getParameter("image");

                    boolean check = true;
                    if (productDAO.checkProductID(productID)) {
                        err.setProductIDError("ProductID already existed !");
                        check = false;
                    } else {
                        if (productID.isEmpty()) {
                            err.setProductIDError("ProductID not empty");
                            check = false;
                        }
                    }
                    if (productName.isEmpty()) {
                        err.setProductNameError("ProductName not empty");
                        check = false;
                    }
                    if (fileName.isEmpty()) {
                        err.setImageError("Image not empty");
                        check = false;
                    }
                        if (description.isEmpty()) {
                        err.setDescriptionError("Description not empty");
                        check = false;
                    }
                    if (price.isEmpty()) {
                        err.setPriceError("Price not empty");
                        check = false;
                    }
                    String regexNumber = "^[0-9]{0,}$";
                    Pattern pattern = Pattern.compile(regexNumber);
                    Matcher matcher = pattern.matcher(price);
                    if (!matcher.find()) {
                        err.setPriceError("Price must be number and positve");
                        check = false;
                    }

                    if (quantity.isEmpty()) {
                        err.setQuantityError("Quantity not empty ");
                        check = false;
                    }

                    Matcher matcherQuantity = pattern.matcher(quantity);
                    if (!matcherQuantity.find()) {
                        err.setQuantityError("Quantity must be number and positve");
                        check = false;
                    }

                    if (check) {
                        Product product = new Product(productID, productName, fileName, category, "Active",description, Integer.parseInt(quantity), Float.parseFloat(price));
                        productDAO.addNewProduct(product);
                        request.setAttribute("SUCCESS", "Insert successully");
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERROR_CREATE", err);
                        List<Category> listCategory = categoryDAO.getAllCategory();
                        request.setAttribute("LIST_CATEGORY", listCategory);
                        Product product= new Product(productID, productName,fileName,description);
                        request.setAttribute("PRICE", price);
                        request.setAttribute("QUANTITY", quantity);
                        request.setAttribute("PRODUCT", product);
                    }
                } else {
                    url = "LogoutController";
                }

            }

        } catch (Exception e) {
            log("Error: " + e.getMessage());
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
