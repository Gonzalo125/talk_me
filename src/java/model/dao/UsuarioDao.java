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

            String contactos = Resultado.getString(10);
            String[] contact = contactos.split(",");
            user.setContactos(Arrays.asList(contact));
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

            String contactos = Resultado.getString(10);
            String[] contact = contactos.split(",");
            user.setContactos(Arrays.asList(contact));
        }

        //Conexion.Cerrar();
        return user;
    }

    public void deleteContacto(String idUser, ArrayList<String> cusuarios) throws SQLException {
        Usuario user = getUser(idUser);

        ArrayList<String> new_contactos = new ArrayList<>();
        for (int i = 0; i < user.getContactos().size(); i++) {
            if (! isLista(cusuarios, user.getContactos().get(i))){
                new_contactos.add(user.getContactos().get(i));
            }
        }
        String lista_contact = String.join(",", new_contactos);

        String consulta = "update Usuario set contactos = ? where id_usu =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, lista_contact);
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

        Usuario user = getUser(idUser);
        ArrayList<String> contactos = new ArrayList<>();
        contactos.addAll(user.getContactos());

        for (String telefono : telefonos) {
            Usuario useraux = getUserbyphone(telefono);
            if (useraux != null) {
                contactos.add(useraux.getId_usu());
            }
        }

        String list_contactos = String.join(",", contactos);

        String consulta = "update Usuario set contactos = ? where id_usu =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, list_contactos);
        insert.setString(2, idUser);

        insert.executeUpdate();
    }

    public void updateUser(Usuario user) throws SQLException {
        String consulta = "update Usuario set alias = ?, estado_usu= ?, contraseña=?,celular=?, imagen_usu=? where id_usu =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, user.getAlias());
        insert.setString(2, user.getEstado_usu());
        insert.setString(3, user.getContraseña());
        insert.setInt(4, user.getCelular());
        insert.setString(5, user.getImagen_usu());
        insert.setString(6, user.getId_usu());

        insert.executeUpdate();
    }

    public void reiniciarPassword(String new_password, String idUser) throws SQLException {
        Usuario user = getUser(idUser);
        user.setContraseña(new_password);
        this.updateUser(user);
    }

    public void sendEmail(String email) {

    }

    public ArrayList<Usuario> getcontactos(String idUser) throws SQLException {
        conect = Conexion.obtener();
        ArrayList<Usuario> lista_contactos = new ArrayList<>();

        Usuario user = getUser(idUser);

        for (int i = 0; i < user.contactos.size(); i++) {
            lista_contactos.add(getUser(user.contactos.get(i)));
        }
        Conexion.Cerrar();
        return lista_contactos;
    }
}
