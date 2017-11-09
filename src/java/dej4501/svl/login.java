/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dej4501.svl;

import dej4501.model.LoginService;
import dej4501.srvs.Validate;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author durib
 */
@WebServlet(name = "login", urlPatterns = {"/login.do"})
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username = request.getParameter("Username");
        String pwd1 = request.getParameter("Password");
        
        if (Validate.validarNotEmpty(username) && Validate.validarNotEmpty(pwd1)) {
            LoginService loginHelper = new LoginService();
            if (loginHelper.validateUser(username, pwd1)) {
                HttpSession httpSession = request.getSession(true);
                httpSession.setAttribute("username", username);
                response.sendRedirect("getRegionesServlet.do");
            }else{
                List<String> listaMensajes = new ArrayList<>();
                listaMensajes.add("Nombre de usuario y contraseña");
                request.setAttribute("listaMensajes", listaMensajes);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }else{
            
                List<String> listaMensajes = new ArrayList<>();
                listaMensajes.add("Nombre de usuario y contraseña");
                request.setAttribute("listaMensajes", listaMensajes);
                request.getRequestDispatcher("login.jsp").forward(request, response);
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
