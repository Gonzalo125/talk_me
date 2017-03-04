/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador.servletUsuario;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "datosUser", urlPatterns = {"/datosUser"})
public class datosUser extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
           //String idUser=request.getParameter("id_usuario");
           String idUser="awe";
          UsuarioDao user=new UsuarioDao();
          user.getUser(idUser);
                  
             Usuario us =new Usuario();
            System.out.println("nombre"+us.getId_usu());
            request.getRequestDispatcher("vista_datos.jsp?nombre"+us.getId_usu()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?id_usuar"+us.getAlias()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?alias"+us.getEstado_usu()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?estado"+us.getImagen_usu()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?imagen"+us.getFecha_registro()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?fecha_usu"+us.getEmail()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?email"+us.getCelular()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?telef"+us.getId_usu()).forward(request, response);
            request.getRequestDispatcher("vista_datos.jsp?password"+ us.getPassword()).forward(request, response);
            String redirectUrl="vista_datos.jsp";
          response.sendRedirect(redirectUrl);
           
    
             } catch (SQLException ex) {
            Logger.getLogger(Actualizar_user.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(datosUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(datosUser.class.getName()).log(Level.SEVERE, null, ex);
        }
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
