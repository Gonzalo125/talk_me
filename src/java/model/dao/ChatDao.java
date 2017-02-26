/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import Conexion.Conectbd.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.Chat;
import model.Usuario;
import model.Usuario;

/**
 *
 * @author User
 */
public class ChatDao {

    Connection conect = Conexion.obtener();

    public void IniciarChat(String id_user_Admin, ArrayList<Usuario> user, String img, String nombre) throws SQLException {

        String consulta = "Insert into chat (nom_chat,persona_chat,fec_crea_chat,admin_chat,img_chat,tipo_chat,archivos, id_chat) values (?,?,?,?,?,?,?,?)";
        PreparedStatement insert = conect.prepareStatement(consulta);

        insert.setString(1, nombre);

        ArrayList<String> data = new ArrayList<>();
        for (int i = 0; i < user.size(); i++) {
            data.add(user.get(i).getId_usu());
        }
        String lista_contactos = String.join(",", data);

        insert.setString(2, lista_contactos);
        long mili = System.currentTimeMillis();
        Date date = new Date(mili);
        insert.setDate(3, date);
        insert.setString(4, id_user_Admin);
        insert.setString(5, img);
        if (user.size() > 1) {
            insert.setInt(6, 1); // grupal
        } else {
            insert.setInt(6, 0); //individual
        }

        insert.setString(7, "");
        insert.setInt(8, 2);
        insert.executeUpdate();

        //Conexion.Cerrar();
    }

    public void deletePersonChat(int id, String user) throws SQLException {
        Chat chat = getChat(id);
        ArrayList<String> user_contac = new ArrayList<>();
        for (int i = 0; i < chat.getPersonas_chat().size(); i++) {
            if (!chat.getPersonas_chat().get(i).equalsIgnoreCase(user)) {
                user_contac.add(chat.getPersonas_chat().get(i));
            }
        }
        String lista_contact = String.join(",", user_contac);

        String consulta = "update chat set persona_chat = ? where id_chat =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, lista_contact);
        insert.setInt(2, id);

        insert.executeUpdate();

    }

    public void deleteAdmin(int id_chat, String user) throws SQLException {
        Chat chat = getChat(id_chat);
        ArrayList<String> admins = new ArrayList<>();
        //admins.addAll(chat.getAdmin_chat());
        for (int i = 0; i < chat.getAdmin_chat().size(); i++) {
            if (!chat.getAdmin_chat().get(i).equalsIgnoreCase(user)) {
                admins.add(chat.getAdmin_chat().get(i));
            }

        }
        String lista_contact = String.join(",", admins);

        String consulta = "update chat set admin_chat = ? where id_chat =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, lista_contact);
        insert.setInt(2, id_chat);

        insert.executeUpdate();
    }

    public Chat getChat(int idChat) throws SQLException {

        Chat objChat = new Chat();
        String consulta = "Select * from Chat where id_chat=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, idChat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            objChat.setId_chat(Resultado.getInt(1));
            objChat.setNombre_chat(Resultado.getString(2));

            String contactos = Resultado.getString(3);
            String[] contact = contactos.split(",");
            objChat.setPersonas_chat(Arrays.asList(contact));

            objChat.setFecha_crecion_chat(Resultado.getDate(4));
            String admin = Resultado.getString(5);
            String[] admins = admin.split(",");
            objChat.setAdmin_chat(Arrays.asList(admins));

            objChat.setImagen_chat(Resultado.getString(6));
            objChat.setTipo(Resultado.getInt(7));
            objChat.setArchivo(Resultado.getString(8));
        }
        return objChat;
    }

    public void AnhadirAdmin(int id_chat, ArrayList<Usuario> user) throws SQLException {

        Chat chat = getChat(id_chat);
        ArrayList<String> admins = new ArrayList<>();
        admins.addAll(chat.getAdmin_chat());
        for (int i = 0; i < user.size(); i++) {
            admins.add(user.get(i).getId_usu());
        }
        String lista_admins = String.join(",", admins);

        String consulta = "update chat set admin_chat = ? where id_chat =?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, lista_admins);
        insert.setInt(2, id_chat);

        insert.executeUpdate();
    }
}
