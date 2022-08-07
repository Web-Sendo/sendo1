/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.DetailDAO;
import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.UserDAO;
import DTO.DetailDTO;
import DTO.OrderDTO;
import DTO.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
@WebServlet(name = "CheckOutController", urlPatterns = {"/CheckOutController"})
public class CheckOutController extends HttpServlet {

    private static final String ERROR = "cart.jsp";
    private static final String SUCCESS = "MainController";
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        boolean check = true;
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();
        UserDAO userDAO = new UserDAO();
        DetailDAO detailDAO = new DetailDAO();
        HttpSession session = request.getSession();
        ArrayList<DetailDTO> list = (ArrayList<DetailDTO>) session.getAttribute("CART");
        User user = (User) session.getAttribute("LOGIN_USER");
        try {
            if (user == null) {
                url = "LogoutController";
            } else {
                String userID1 = user.getUserID();
                String statusUser = userDAO.getStatus(userID1);
                if (statusUser.equals("Active")) {
                    if (list != null) {
                        float total = Float.parseFloat(request.getParameter("total"));
                        String userID = request.getParameter("userID");
                        String userName = request.getParameter("name");
                        String phone = request.getParameter("phone");
                        String address = request.getParameter("address");
            

                   
                        for (DetailDTO detailDTO1 : list) {
                            int checkQuantity = productDAO.getQuantityByID(detailDTO1.getProduct().getProductID());
                            if (detailDTO1.getProduct().getStatus().equals("Active")) {
                                if (detailDTO1.getQuantity() > checkQuantity) {
                                    request.setAttribute("ERR", "The number of " + detailDTO1.getProduct().getProductName() + " product is not enough");
                                    check = false;
                                    url = "cart.jsp";
                                }
                            } else {
                                request.setAttribute("ERR", detailDTO1.getProduct().getProductName() + " product is no longer active");
                                check = false;
                                url = "cart.jsp";
                            }
                        }
                        if (check) {

                            if (orderDAO.insertOrder(new OrderDTO(0, userID, userName, phone, address, new Date(), total)) != -1) {
                                for (DetailDTO detailDTO : list) {
                                    int orderID = orderDAO.getOrderID();
                                    detailDTO.setOrderID(orderID);
                                    if (detailDAO.insertDetail(detailDTO) != -1) {
                                        int CurQuantity = productDAO.getQuantityByID(detailDTO.getProduct().getProductID());
                                        String shoesID = detailDTO.getProduct().getProductID();
                                        int Quantity = CurQuantity - detailDTO.getQuantity();
                                        boolean result = productDAO.updateQuantity(shoesID, Quantity);
                                    }
                                }
                                session.setAttribute("CART", null);
                                request.setAttribute("CHECK_OUT", "Buy Successfully!");
                                url = SUCCESS;

                            }
                        } else {
                           
                        }

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
