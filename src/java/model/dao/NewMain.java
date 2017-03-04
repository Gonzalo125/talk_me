/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entidades.Usuario;
import model.dao.UsuarioDao;

/**
 *
 * @author User
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        UsuarioDao user = new UsuarioDao();
        
        try {
            Usuario user1 = new Usuario();
////////            String user45="awe";
////////           user =user58.getUser(user45); 
////////           
////////            System.out.println("resultado:"+user.getId_usu()+"  "+user.getNombre_usu());
////////           
           // System.out.println(""+user.getId_usu()+"\n");
//                     user1.getPassword()+"\n"+
//            user1.getAlias()+"\n"+
//            user1.getEstado_usu()+"\n"+
//            user1.getImagen_usu()+"\n"+
//            user1.getFecha_registro()+"\n"+
//            user1.getEmail()+"\n"+
//            user1.getCelular()+"\n");
//           
           
//            user1.setEmail("emaillll");
//            user1.setAlias("aliassss");
//            user1.setCelular(123123456);
//            user1.setEstado_usu("estadosss");
//            user1.setFecha_registro("12/12/2017");
//            user1.setId_usu("8");
//            user1.setImagen_usu("imgsss");
//            user1.setNombre_usu("nombress");
//            user1.setPassword("Pasword");
   
           Boolean a = user.verificar_usuario("123","123");
//            
           System.err.println( a);
//            
//            a = user.verificar_usuario("1asd2","asdads");
//            
//            System.err.println( a);

         //  user.updateUser(user1);
           
        } catch (SQLException ex) {
            System.err.println(""+ex.getMessage());
        }
    }
    
}
