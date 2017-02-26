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
import model.Chat;
import model.Usuario;
import model.UsuarioxChat;

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

        int cant_user = user.size() + 1;

        insert.setString(7, "");
        insert.setInt(8, 2);
        insert.executeUpdate();

        //Conexion.Cerrar();
        int id_chat = 0;
        for (Usuario user_unico : user) {
            this.insert_usuario_chat(id_chat, id_user_Admin, user_unico.getId_usu());
        }
    }

    private void insert_usuario_chat(int id_chat, String id_user_Admin, String id_user) throws SQLException {
        String consulta = "Insert into usuarioxchat (n,tipo_chat,archivos, id_chat) values (?,?,?)";
        PreparedStatement insert = conect.prepareStatement(consulta);

        insert.setString(1, id_user_Admin);
        insert.setString(1, id_user);
        insert.setInt(1, id_chat);
        insert.setBoolean(1, false);
    }

    public void deletePersonChat(int id_chat, String user) throws SQLException {
        // Chat chat = getChat(id_chat);

        String consulta = "delete usuarioxchat where id_chat =? and idusuario= ?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, user);
        insert.setInt(2, id_chat);

        insert.executeUpdate();

    }

    public void deleteAdmin(int id_chat, String user) throws SQLException {

        String consulta = "delete usuarioxchat where id_chat =? and idusuario= ?";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setString(1, user);
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

            objChat.setFecha_crecion_chat(Resultado.getDate(4));

            objChat.setImagen_chat(Resultado.getString(6));
            objChat.setCan_personas(Resultado.getInt(7));
            objChat.setArchivo(Resultado.getString(8));
        }
        return objChat;
    }

   
    public void AnhadirAdmin(int id_chat, String id_user, ArrayList<Usuario> userlista) throws SQLException {

        for (Usuario user : userlista) {
            String consulta = "Insert into usuarioxchat (n,tipo_chat,archivos, id_chat) values (?,?,?)";
            PreparedStatement insert = conect.prepareStatement(consulta);

            insert.setString(1, user.getId_usu());
            insert.setString(1, id_user);
            insert.setInt(1, id_chat);
            insert.setBoolean(1, true);
        }
    }

    public ArrayList<Chat> getlistChat(String idUser) throws SQLException {
        ArrayList<Chat> mlist = new ArrayList<>();
         UsuarioxChatDao userxchatdao = new UsuarioxChatDao();
       
        ArrayList<UsuarioxChat> mlist_chats = userxchatdao.getUsuarioxChat(idUser);

        for (UsuarioxChat mlist_chat : mlist_chats) {
            Chat chat = this.getChat(mlist_chat.getId_chat());
            mlist.add(chat);
        }

        return mlist;
    }
}
