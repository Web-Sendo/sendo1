/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author Quang Nguyen
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String HOME = "HomeController";
    private static final String DETAIL = "GetProductByID";
    private static final String CATEGORY = "CategoryController";
    private static final String USER = "UserController";
    private static final String LOGIN = "LoginController";
    private static final String LOGOUT = "LogoutController";
    private static final String ADMIN = "AdminController";
    private static final String DELETE = "DeleteController";
    private static final String LOADFORMADD = "LoadFormAddController";
    private static final String LOADFORMUPDATE = "LoadFormUpdateController";
        private static final String PRODUCTBYCATEGORY = "GetProductByCategoryID";

    //CART
    private static final String ADDTOCART = "AddToCartController";
    private static final String DELETECART = "DeleteCartController";

    private static final String ADMIN_DIRECT = "admin.jsp";
    private static final String CART_DIRECT = "cart.jsp";
    private static final String HOME_DIRECT = "index.jsp";
    private static final String SHOP_DIRECT = "shop.jsp";
    private static final String LOGIN_DIRECT = "login.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String action = request.getParameter("action");
        try {
            if (action == null) {
                url = HOME;
            } else if ("home".equals(action)) {
                url = HOME;
            } else if ("homeDirect".equals(action)) {
                url = HOME_DIRECT;
            } else if ("detail".equals(action)) {
                url = DETAIL;
            } else if ("shopDirect".equals(action)) {
                url = SHOP_DIRECT;
            }  else if ("login".equals(action)) {
                url = LOGIN_DIRECT;
            } else if ("user".equals(action)) {
                url = USER;
            } else if ("Login".equals(action)) {
                url = LOGIN;
            } else if ("logout".equals(action)) {
                url = LOGOUT;
            } else if ("addToCart".equals(action)) {
                url = ADDTOCART;
            } else if ("deleteCart".equals(action)) {
                url = DELETECART;
            } else if ("cartDirect".equals(action)) {
                url = CART_DIRECT;
            } else if ("admin".equals(action)) {
                url = ADMIN;
            } else if ("viewAdmin".equals(action)) {
                url = ADMIN_DIRECT;
            }else if ("delete".equals(action)) {
                url = DELETE;
            }else if ("loadFormAdd".equals(action)) {
                url = LOADFORMADD;
            }else if ("loadFormUpdate".equals(action)) {
                url = LOADFORMUPDATE;
            }
            else if ("category".equals(action)) {
                url = PRODUCTBYCATEGORY;
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
