/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import model.Entidades.Usuario;

/**
 *
 * @author User
 */
public class contac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            String idUser="8";
            Usuario user = new Usuario();
             ContactoDao contdao= new ContactoDao();
             ArrayList<String> mlist = new ArrayList<>();
           mlist.add("awe");
           
           contdao.deleteContacto(idUser, mlist);
            
           
////           ContactoDao contdao= new ContactoDao();
//           contdao.getContactos("8");
//           ArrayList<Usuario> mlistaUsuarios = contdao.getUsercontactos(idUser);
//           
//           for(Usuario item:mlistaUsuarios){
//              
//                System.out.println("<tr> <td>"+item.getId_usu()+"</td>  <td>"+item.getNombre_usu()+"</td>  <td>"+item.getAlias()+"</td>  <td>"+item.getEmail()+"</td>  <td>"+item.getPassword()+"</td>  <td> "+item.getFecha_registro()+"</td> </tr>");
//              
//            }
//           
           
////            ArrayList<String> mlist = new ArrayList<>();
////           mlist.add("a");
////           
////           contdao.addContacto(idUser, mlist);

           
        } catch (SQLException ex) {
            System.err.println(""+ex.getMessage());
        }
    }
    
}
