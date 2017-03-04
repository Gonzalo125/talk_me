/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Conexion.Conectbd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Entidades.Contactos;
import model.Entidades.Usuario;

/**
 *
 * @author User
 */
public class UsuarioDao {

    Usuario user;
    Connection conect = Conexion.obtener();

    public boolean verificar_usuario(String email, String password) throws SQLException {

        try {
       // String consulta = "Select id_usu from usuario where id_usu=? and pass = ?";//Obtienes el id del usuario  cuando tu usuario y contraeña son correctas esto es para ingresar a la pagina del chat
        PreparedStatement Consulta = conect.prepareCall("{call USP_VERIFICAR_USUARIO (?,?)}");
        Consulta.setString(1, email);
        Consulta.setString(2, password);
        ResultSet Resultado = Consulta.executeQuery();
        if (Resultado.next()) {

            return true;
        }
        return false;
        }catch ( Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public  Usuario getUser(String idUser) throws SQLException {

        Usuario user = new Usuario();
        //String consulta = "Select id_usu, nombre, alias, estado, imagen, fecha, telefono, email from usuario where id_usu=?";//cuando ingresas tu id usuario obtienes los datos del usuario
       
        PreparedStatement Consulta = conect.prepareCall("{call USP_GET_USER (?)}");
        Consulta.setString(1, idUser);
        
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
           
            user.setId_usu(Resultado.getString(1));
            user.setPassword(Resultado.getString(2));
            user.setNombre_usu(Resultado.getString(3));
            user.setAlias(Resultado.getString(4));
            user.setEstado_usu(Resultado.getString(5));
            user.setImagen_usu(Resultado.getString(6));
            user.setFecha_registro(Resultado.getString(7));
            user.setEmail(Resultado.getString(8));
            user.setCelular(Resultado.getInt(9));
            
            
        }

        //Conexion.Cerrar();
        
       
     
  
        return user;
    
}

    public Usuario getUserbyphone(String email) throws SQLException {
 
        Usuario user = new Usuario();
        //String consulta = "Select id_usu, nombre, alias, estado, imagen, fecha, telefono, email from usuario where telefono=?";
        try {
        PreparedStatement Consulta = conect.prepareCall("{call USP_GET_USER_BY_PHONE (?)} ");
        Consulta.setString(1, email);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            System.out.println(""+Resultado.getString(1));
            user.setId_usu(Resultado.getString(1));
            user.setNombre_usu(Resultado.getString(2));
            user.setAlias(Resultado.getString(3));
            user.setEstado_usu(Resultado.getString(4));
            user.setImagen_usu(Resultado.getString(5));
            //user.setFecha_registro(Resultado.getString(6));
            user.setEmail(Resultado.getString(6));
            //user.setCelular(Resultado.getInt(7));
            

        }
        }catch(Exception e){
            int a =0 ;
        } 

        //Conexion.Cerrar();
        return user;
  
    }

    public void updateUser(Usuario user1) throws SQLException {
       // String consulta = "update usuario set alias = ?, estado= ?, pass=?, telefono=?, imagen=? where id_usu =?";//actualizar tus datos cundo intriduces tu id_user
        
       PreparedStatement insert = conect.prepareCall("{call USP_UPDATE_USER (?,?,?,?,?,?,?)}");
        insert.setString(2, user1.getNombre_usu());
        insert.setString(3, user1.getAlias());
        insert.setString(4, user1.getAlias());
        insert.setString(5, user1.getAlias());
        insert.setInt(6, user1.getCelular());
        insert.setString(7, user1.getImagen_usu());
        insert.setString(1, user1.getId_usu());

        insert.executeUpdate();
    }

    public void reiniciarPassword(String new_password, String idUser) throws SQLException {
        Usuario user = getUser(idUser);
        user.setPassword(new_password);
        this.updateUser(user);
    }

    public void sendEmail(String email) {

    }

    public void insertUser(Usuario user) throws SQLException {
        //String consulta = "insert into  usuario(id_usu,nombre, alias, estado, imagen, email, telefono, pass) values( ?,?,?,?,?,?,?)";// esto es para resgistrarte es decir insertas en tus datos en la tabla usuario 
       try{
        PreparedStatement insert = conect.prepareCall("{call USP_INSERT_USER (?,?,?,?,?,?,?,?,?)}");
        insert.setString(1, user.getId_usu());
        insert.setString(2, user.getPassword());
        insert.setString(3, user.getNombre_usu());
        insert.setString(4, user.getAlias());
        insert.setString(5, user.getEstado_usu());
        insert.setString(6, user.getImagen_usu());
        insert.setString(7, user.getFecha_registro());
        insert.setString(8, user.getEmail());
        insert.setInt(9, user.getCelular());
        
        insert.execute();
    }catch(Exception e) {  
                   e.getMessage();  
      }  
    }

}
