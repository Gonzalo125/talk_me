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
import model.Entidades.Usuario;
import model.dao.*;

/**
 *
 * @author User
 */
public class mainchat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ChatDao chato = new ChatDao();
        UsuarioDao userDao = new UsuarioDao();
       
        ArrayList<Usuario> user = new ArrayList<>();
        Usuario user1;
        try {
            user1 = userDao.getUser("12");
             user.add(user1);
            chato.IniciarChat("8", user, "", user1.getNombre_usu());
        } catch (Exception ex) {
            Logger.getLogger(mainchat.class.getName()).log(Level.SEVERE, null, ex);
            
            System.out.println(ex.getMessage());
        }
       
    }
    
}
