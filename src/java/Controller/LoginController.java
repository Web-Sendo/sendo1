/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.UserDAO;
import DTO.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
public class LoginController extends HttpServlet {

    private static final String USER = "MainController";
    private static final String ADMIN = "MainController?action=admin";
    private static final String ERROR = "error.jsp";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        String err = "";

        try {

            String userID = request.getParameter("txtUserID");
            String password = request.getParameter("txtPassword");
            UserDAO userDAO = new UserDAO();
            boolean checkUserID = userDAO.checkEmail(userID);
            HttpSession session = request.getSession();
            HttpSession errorSession = request.getSession();
            if (userID.isEmpty() || password.isEmpty()) {
                err = "UserID and Password must not empty";
                errorSession.setAttribute("ERROR_LOGIN", err);
            } else {
                if (checkUserID) {
                    User user = userDAO.checkLogin(userID, password);
                    if (user != null) {
                        String test = user.getRoleID();
                        if (user.getRoleID().equals("2")) {
                            if (user.getStatus().equalsIgnoreCase("Active")) {
                                url = USER;
                            }
                        } else if (user.getRoleID().equals("1")) {
                            if (user.getStatus().equalsIgnoreCase("Active")) {
                                url = ADMIN;
                            }
                        }
                        Cookie cookie = new Cookie(userID, password);
                        cookie.setMaxAge(60 * 60 * 24 * 7);
                        response.addCookie(cookie);
                        session.setAttribute("LOGIN_USER", user);
                    } else {
                        err = "Wrong password";
                        request.setAttribute("EMAIL", userID);
                        errorSession.setAttribute("ERROR_LOGIN", err);
                    }
                } else {
                    err = "Not found account";
                    errorSession.setAttribute("ERROR_LOGIN", err);
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
