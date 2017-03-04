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
 * @author 
 */
public class ContactoDao {

    Connection conect = Conexion.obtener();

    public ArrayList<Contactos> getContactos(String idUser) throws SQLException {

        ArrayList<Contactos> mlist = new ArrayList<>();
       // String consulta = "Select id_contacto, id_usu from contactos where id_usu_prin=?";
       
        PreparedStatement Consulta = conect.prepareCall("{call USP_GET_CONTACTOS (?)}");
        Consulta.setString(1, idUser);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            Contactos contact = new Contactos();

            contact.setId_usuario_prin(idUser);
            contact.setId_contacto(Resultado.getInt(1));
            contact.setId_usuario(Resultado.getString(2));

            mlist.add(contact);
        }

        return mlist;

    }

    public void deleteContacto(String idUser, ArrayList<String> cusuarios) throws SQLException {
        //Usuario user = getUser(idUser);
        for (String usuarios : cusuarios) {
           // String consulta = "delete contactos where id_usu_prin =? and id_usu=?";
            PreparedStatement insert = conect.prepareStatement("{call USP_DELETE_CONTACTO(?,?)}");
            insert.setString(1, idUser);
            insert.setString(2, usuarios);

            insert.executeUpdate();
        }
    }

    public void addContacto(String idUser, ArrayList<String> emails) throws SQLException {

        UsuarioDao userDao = new UsuarioDao();
        for (String email : emails) {
            Usuario user = userDao.getUserbyphone(email);
           // String consulta = "insert into  contactos(id_usu_prin, id_usu) values( ?,?)";
            PreparedStatement insert = conect.prepareCall("{ call USP_ADD_CONTACTO(?,?,?)}");
            insert.setString(1, idUser);
            insert.setString(2, user.getId_usu());
            insert.setString(3, "12/12/2007");  
            insert.execute();
        }

    }

    public ArrayList<Usuario> getUsercontactos(String idUser) throws SQLException {
        ArrayList<Contactos> mlista = this.getContactos(idUser);
        ArrayList<Usuario> lista_contactos = new ArrayList<>();
        UsuarioDao userDao = new UsuarioDao();
        //Usuario user = userDao.getUser(idUser);

        for (int i = 0; i < mlista.size(); i++) {
            lista_contactos.add(userDao.getUser(mlista.get(i).getId_usuario()));
        }
        //Conexion.Cerrar();
        return lista_contactos;
    }
}
