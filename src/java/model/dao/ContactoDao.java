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
 * @author giancarlorau
 */
public class ContactoDao {
      Connection conect = Conexion.obtener();
    public ArrayList<Contactos> getContactos(String idUser) throws SQLException {

        ArrayList<Contactos> mlist = new ArrayList<>();
        String consulta = "Select idContacto, idusuario from Contactos where id_usuario_p=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            Contactos contact = new Contactos();

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
            if (cusuario.equalsIgnoreCase(idUSer)) {
                return true;
            }
        }
        return false;
    }

    public void addContacto(String idUser, ArrayList<String> telefonos) throws SQLException {
        
        UsuarioDao userDao = new UsuarioDao();
        for (String telefono : telefonos) {
            Usuario user = userDao.getUserbyphone(telefono);
            String consulta = "insert into  contatos(idusuario, idusuairo_p) values( ?,?)";
            PreparedStatement insert = conect.prepareStatement(consulta);
            insert.setString(1, user.getId_usu());
            insert.setString(2, idUser);

            insert.execute();
        }

    }

     public ArrayList<Usuario> getUsercontactos(String idUser) throws SQLException {
        conect = Conexion.obtener();
        ArrayList<Contactos> mlista = this.getContactos(idUser);
        ArrayList<Usuario> lista_contactos = new ArrayList<>();
         UsuarioDao userDao = new UsuarioDao();
        Usuario user = userDao.getUser(idUser);

        for (int i = 0; i < mlista.size(); i++) {
            lista_contactos.add(userDao.getUser(mlista.get(i).getId_usuario()));
        }
        Conexion.Cerrar();
        return lista_contactos;
    }
}
