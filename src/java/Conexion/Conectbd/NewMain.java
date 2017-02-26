/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexion.Conectbd;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.dao.ChatDao;
import model.dao.UsuarioDao;
import model.Usuario;

/**
 *
 * @author User
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        UsuarioDao dao = new UsuarioDao();
        ChatDao daoChat = new ChatDao();
        
        ArrayList<Usuario> contactos= new ArrayList<>();
        try {
             contactos = dao.getcontactos("gonzalo123");
            
            for (int i = 0; i < contactos.size(); i++) {
                System.out.println(""+contactos.get(i).getNombre_usu());
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //daoChat.IniciarChat("gonzalo123", contactos, "", "GRupo Gonzalo");
        
        //daoChat.AnhadirAdmin(1, contactos);
        // daoChat.AnhadirContacto(2, contactos);
    }
    
}
