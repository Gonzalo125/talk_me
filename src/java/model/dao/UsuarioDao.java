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
import model.Contactos;
import model.Usuario;

/**
 *
 * @author User
 */
public class UsuarioDao {

    Usuario user;
    Connection conect = Conexion.obtener();

    public boolean verificar_usuario(String email, String password) throws SQLException {

        String consulta = "Select id_usu from usuario where id_usu=? and pass = ?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, email);
        Consulta.setString(1, password);
        ResultSet Resultado = Consulta.executeQuery();
        if (Resultado.next()) {

            return true;
        }
        return false;
    }

    public Usuario getUser(String idUser) throws SQLException {

        Usuario user = null;
        String consulta = "Select id_usu, nombre, alias, estado, imagen, fecha, telefono, email from usuario where id_usu=?";
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
            //user.setPassword(Resultado.getString(9));
        }

        //Conexion.Cerrar();
        return user;
    }

    public Usuario getUserbyphone(String telefono) throws SQLException {

        Usuario user = null;
        String consulta = "Select id_usu, nombre, alias, estado, imagen, fecha, telefono, email from usuario where telefono=?";
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

    public void updateUser(Usuario user) throws SQLException {
        String consulta = "update usuario set alias = ?, estado= ?, pass=?, telefono=?, imagen=? where id_usu =?";
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

    public void insertUser(Usuario user) throws SQLException {
        String consulta = "insert into  usuario(nombre, alias, estado, imagen, email, telefono, pass) values( ?,?,?,?,?,?,?)";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, user.getNombre_usu());
        insert.setString(2, user.getAlias());
        insert.setString(3, user.getEstado_usu());
        insert.setString(4, user.getImagen_usu());
        insert.setString(5, user.getEmail());
        insert.setInt(6, user.getCelular());
        insert.setString(7, user.getPassword());
    }

}
