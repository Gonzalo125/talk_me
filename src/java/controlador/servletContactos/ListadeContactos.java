/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servletContactos;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Entidades.Contactos;
import model.Entidades.Usuario;
import model.dao.ContactoDao;
import model.dao.UsuarioDao;

/**
 *
 * @author User
 */
@WebServlet(name = "llamarContacto", urlPatterns = {"/llamarContacto"})
public class ListadeContactos extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            ContactoDao contac_dao= new ContactoDao();
            String id_user = request.getParameter("id_user");
             contac_dao.getContactos("8");
           ArrayList<Usuario> mlistaUsuarios = contac_dao.getUsercontactos(id_user);
           
           for(Usuario item:mlistaUsuarios){
              
                System.out.println("<tr> <td>"+item.getId_usu()+"</td>  <td>"+item.getNombre_usu()+"</td>  <td>"+item.getAlias()+"</td>  <td>"+item.getEmail()+"</td>  <td>"+item.getPassword()+"</td>  <td> "+item.getFecha_registro()+"</td> </tr>");
              
            }
           
           
            
            
            
            
            
           
        } catch (SQLException ex) {
            Logger.getLogger(ListadeContactos.class.getName()).log(Level.SEVERE, null, ex);
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
