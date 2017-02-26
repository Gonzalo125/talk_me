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
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Contactos;
import model.Usuario;

/**
 *
 * @author User
 */
public class UsuarioDao {

    Usuario user;
    Connection conect = null;

    public Usuario getUser(String idUser) throws SQLException {

        Usuario user = null;
        String consulta = "Select * from Usuario where id_usu=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            user.setId_usu(Resultado.getString(1));
            user.setNombre_usu(Resultado.getString(2));
            user.setAlias(Resultado.getString(3));
            user.setEstado_usu(Resultado.getString(4));
            user.setImagen_usu(Resultado.getString(5));
            user.setFecha_registro(Resultado.getString(6));
            user.setCelular(Resultado.getInt(7));
            user.setEmail(Resultado.getString(8));
            user.setPassword(Resultado.getString(9));
        }

        //Conexion.Cerrar();
        return user;
    }

    public Usuario getUserbyphone(String telefono) throws SQLException {

        Usuario user = null;
        String consulta = "Select * from Usuario where celular=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, telefono);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            user.setId_usu(Resultado.getString(1));
            user.setNombre_usu(Resultado.getString(2));
            user.setAlias(Resultado.getString(3));
            user.setEstado_usu(Resultado.getString(4));
            user.setImagen_usu(Resultado.getString(5));
            user.setFecha_registro(Resultado.getString(6));
            user.setCelular(Resultado.getInt(7));
            user.setEmail(Resultado.getString(8));

        }

        //Conexion.Cerrar();
        return user;
    }
    
    public ArrayList<Contactos> getContactos (String idUser) throws SQLException{
        
        ArrayList<Contactos> mlist = new ArrayList<>();
         String consulta = "Select idContacto, idusuario from Contactos where id_usuario_p=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            Contactos  contact = new Contactos();
            
            contact.setId_usuario(idUser);
            contact.setId_contacto(Resultado.getInt(0));
            contact.setId_usuario(Resultado.getString(1));
            
            mlist.add(contact);
        }
        
        return mlist;
        
    }

    public void deleteContacto(String idUser, ArrayList<String> cusuarios) throws SQLException {
        //Usuario user = getUser(idUser);

        String consulta = "update Usuario set contactos = ? where id_usu =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(2, idUser);

        insert.executeUpdate();
    }
    private boolean isLista(ArrayList<String> cusuarios, String idUSer) {
        
        for (String cusuario : cusuarios) {
            if (cusuario.equalsIgnoreCase(idUSer)){
                return true;
            }
        }
        return false;
    }

    public void addContacto(String idUser, ArrayList<String> telefonos) throws SQLException {

        
        for (String telefono:telefonos){
            Usuario user = this.getUserbyphone(telefono);
           String consulta = "insert into  contatos(idusuario, idusuairo_p) values( ?,?)";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, user.getId_usu());
        insert.setString(2, idUser);

        insert.execute();
        }
        
    }

    public void updateUser(Usuario user) throws SQLException {
        String consulta = "update Usuario set alias = ?, estado_usu= ?, contraseña=?,celular=?, imagen_usu=? where id_usu =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, user.getAlias());
        insert.setString(2, user.getEstado_usu());
        insert.setString(3, user.getPassword());
        insert.setInt(4, user.getCelular());
        insert.setString(5, user.getImagen_usu());
        insert.setString(6, user.getId_usu());

        insert.executeUpdate();
    }

    public void reiniciarPassword(String new_password, String idUser) throws SQLException {
        Usuario user = getUser(idUser);
        user.setPassword(new_password);
        this.updateUser(user);
    }

    public void sendEmail(String email) {

    }

    public ArrayList<Usuario> getUsercontactos(String idUser) throws SQLException {
        conect = Conexion.obtener();
        ArrayList<Contactos> mlista= this.getContactos(idUser);
        ArrayList<Usuario> lista_contactos = new ArrayList<>();

        Usuario user = getUser(idUser);

        for (int i = 0; i < mlista.size(); i++) {
            lista_contactos.add(getUser(mlista.get(i).getId_usuario()));
        }
        Conexion.Cerrar();
        return lista_contactos;
    }
}
