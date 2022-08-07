/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ProductDAO;
import DAO.UserDAO;
import DTO.DetailDTO;
import DTO.Product;
import DTO.User;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


/**
 *
 * @author Quang Nguyen
 */
@WebServlet(name = "AddToCartController1", urlPatterns = {"/AddToCartController1"})
public class AddToCartController1 extends HttpServlet {

    private static final String ERROR = "login.jsp";
    private static final String SUCCESS = "cart.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String url = ERROR;
        ProductDAO productDAO = new ProductDAO();
        UserDAO userDAO = new UserDAO();
        String productID = request.getParameter("productID");
        int quantity = 1;
        DetailDTO detailDTO = new DetailDTO();
        ArrayList<DetailDTO> list = null;
        boolean flag = true;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("LOGIN_USER");
        try {
            if (user == null) {
                url = ERROR;
            } else {
                String userID = user.getUserID();
                String statusUser = userDAO.getStatus(userID);
                if (statusUser.equals("Active")) {

                    Product product = productDAO.getProductByID(productID);
                    if (product.getStatus().equals("Active")) {
                        detailDTO = new DetailDTO(0, 0, product.getPrice(), quantity, product);

                        list = (ArrayList<DetailDTO>) session.getAttribute("CART");
                        if (list != null) {
                            for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getProduct().getProductID().equals(detailDTO.getProduct().getProductID())) {
                                    list.get(i).setQuantity(list.get(i).getQuantity() + quantity);
                                    flag = false;
                                }
                            }
                        } else if (list == null) {
                            list = new ArrayList<>();
                        }
                        if (flag) {

                            list.add(detailDTO);
                        }
                        request.setAttribute("OUT", "Add successfully!");
                        session.setAttribute("CART", list);
                        url = SUCCESS;
                    } else {
                        url = "MainController";
                        request.setAttribute("OUT", "Product not in stock!");
                    }
                } else {
                    url = ERROR;
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
