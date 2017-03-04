/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servletUsuario;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entidades.Usuario;
import model.dao.UsuarioDao;
/**
 *
 * @author User
 */
@WebServlet(name = "RegistroUsuario", urlPatterns = {"/RegistroUsuario"})
public class RegistroUsuario extends HttpServlet {

   
      



    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nombre_usu=request.getParameter("nombre");
            String id_usua=request.getParameter("id_usuar");
            String contraseña=request.getParameter("password:");
            String alias= request.getParameter("alias");
            String estado_usu=request.getParameter("estado");
            String imagen_usu= "";//request.getParameter("imagen");
            String fecha_usu="12/12/2017";//request.getParameter("fecha_usu");
            String email=request.getParameter("email");
            int telefono=Integer.parseInt(request.getParameter("telef"));
            
            
            Usuario user= new Usuario();
            
            user.setNombre_usu(nombre_usu);
            user.setId_usu(id_usua);
            user.setAlias(alias);
            user.setEstado_usu(estado_usu);
            user.setImagen_usu(imagen_usu);
            user.setFecha_registro(fecha_usu);
            user.setEmail(email);
            user.setCelular(telefono);
            user.setPassword(contraseña);
            UsuarioDao user_dao=new UsuarioDao();
            user_dao.insertUser(user);
           
         
      	     
           
        } catch (SQLException ex) {
            Logger.getLogger(RegistroUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
