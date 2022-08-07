/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CategoryDAO;
import DAO.ProductDAO;
import DTO.Category;
import DTO.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 *
 * @author Quang Nguyen
 */
@WebServlet(name = "LoadFormUpdateController", urlPatterns = {"/LoadFormUpdateController"})
public class LoadFormUpdateController extends HttpServlet {

     private static final String SUCCESS = "update.jsp";
    private static final String ERROR = "MainController?action=admin";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        CategoryDAO categoryDAO = new CategoryDAO();
        String url = ERROR;
        ProductDAO productDAO = new ProductDAO();
        String productID = request.getParameter("productID");
        try {
            Product product = productDAO.getProductByID1(productID);
            String cateName = categoryDAO.getNameByID(product.getCategoryID());
            int price = (int) product.getPrice();
            if (product != null) {
                List<Category> listCategory = categoryDAO.getAllCategory();
                request.setAttribute("LIST_CATEGORY", listCategory);
                request.setAttribute("PRODUCT", product);
                request.setAttribute("cateName", cateName);

                request.setAttribute("PRICE", price);
                request.setAttribute("QUANTITY", product.getQuantity());
                url = SUCCESS;
            }
        } catch (Exception e) {
            log("Error :" + e.getMessage());
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