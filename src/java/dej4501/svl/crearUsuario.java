/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dej4501.svl;

import dej4501.model.Usuarios;
import dej4501.model.UsuariosHelper;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author durib
 */
@WebServlet(name = "crearUsuario", urlPatterns = {"/crearUsuario.do"})
public class crearUsuario extends HttpServlet {

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

        String username = request.getParameter("user");
        String pwd1 = request.getParameter("password1");
        String pwd2 = request.getParameter("password2");
        String url = "crearUsuario.jsp";
        List<String> listaMensajes = new ArrayList<>();
        
        if (Validate.validarNotEmpty(username)) {
            if (Validate.validarNotEmpty(pwd1)&& Validate.validarNotEmpty(pwd2)
                    &&Validate.validarIguales(pwd1, pwd2)) {
                UsuariosHelper userService = new UsuariosHelper();
                BCryptPasswordEncoder passEncoder = new BCryptPasswordEncoder();
                String encryptedPass = passEncoder.encode(pwd1);
                
                Usuarios newUser = new Usuarios (username, encryptedPass, "user");
                boolean resultado = userService.crearUsuario(newUser);
                if (!resultado) {
                    listaMensajes.add("Usuario no pudo ser aghregado con éxito");
                }
                else{
                    url="login.jsp";
                    listaMensajes.add("Usuario fue agregado con éxito!");
                }
            }else{
                listaMensajes.add("Contraseñas deben ser iguales");
            }
        }else{
            listaMensajes.add("Nombre de usuario incorrecto!");
        }
        request.setAttribute("listaMensajes",listaMensajes);
        request.getRequestDispatcher(url).forward(request, response);
        
        
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
