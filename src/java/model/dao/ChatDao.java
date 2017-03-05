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
import model.Entidades.Chat;
import model.Entidades.Usuario;
import model.Entidades.UsuarioxChat;

/**
 *
 * @author User
 */
public class ChatDao {

    Connection conect = Conexion.obtener();

    public void IniciarChat(String id_user_Admin, ArrayList<Usuario> user, String img, String nombre) throws SQLException {

       // String consulta = "Insert into chat (nombre,fecha,numero_personas,imagen,estado) values (?,?,?,?,?)";
       // String crear_chat= "select id_chat from chat where fec_chat=? and nom_chat =? and n_per_chat =?
        PreparedStatement insert = conect.prepareCall("{ call USP_INICIAR_CHAT(?,?,?,?,?)}");
       
        insert.setString(1, nombre);
        
        long mili = System.currentTimeMillis();
        Date date = new Date(mili);
        insert.setDate(3, date);
           
        int cant_user = user.size() + 1;
        insert.setInt(2, cant_user);
        insert.setString(4, img);
        insert.setBoolean(5, false);

        insert.execute();
        
        PreparedStatement insert2 = conect.prepareCall("{ call USP_INICIAR_CHAT2(?,?)}");
        insert2.setString(1, nombre);
        insert2.setInt(2, cant_user);
        
       // insert2.execute();
        int id_chat = 0;
         ResultSet Resultado = insert2.executeQuery();
        while (Resultado.next()) {
            id_chat = Resultado.getInt(1);
        }
        
        this.insert_usuario_chat(id_chat,id_user_Admin, true);
        for (Usuario user_unico : user) {
            this.insert_usuario_chat(id_chat, user_unico.getId_usu(), false);
        }
    }

    private void insert_usuario_chat(int id_chat, String id_user, Boolean Admin) throws SQLException {
        //String consulta = "Insert into usuario x chat (id_chat,id_usu,fecha, estado, admin) values (?,?,?,?,?)";//insertas un uario en el chat
        PreparedStatement insert = conect.prepareCall("{call USP_INSERT_USUARIO_CHAT(?,?,?,?,?)} ");
        
        long mili = System.currentTimeMillis();
        Date date = new Date(mili);
        
        insert.setInt(1, id_chat);
        insert.setDate(3, date);
        insert.setString(2, id_user);
        insert.setBoolean(4, false);
        insert.setBoolean(5, Admin);
         insert.execute();
    }

    public void deletePersonChat(int id_chat, String user) throws SQLException {
        // Chat chat = getChat(id_chat);

        // String consulta = "delete usuario x chat where id_chat =? and id_usu= ?";// eleminias una persona del chat
        PreparedStatement insert = conect.prepareCall("{call USP_DELETE_PERSON_CHAT(?,?)} ");
        insert.setInt(1, id_chat);
        insert.setString(2, user);
        
        insert.executeUpdate();

    }

    public void deleteAdmin(int id_chat, String user) throws SQLException {

        //String consulta = "delete usuario x chat where id_chat =? and id_usu= ?";//eliminas el admin
        PreparedStatement insert = conect.prepareCall("{call USP_DELETE_ADMIN(?,?)}");
         insert.setInt(1, id_chat);
        insert.setString(2, user);

        insert.executeUpdate();
    }

    public Chat getChat(int idChat) throws SQLException {

        Chat objChat = new Chat();
        //String consulta = "Select id_chat,nombre,numero_personas,fecha,imagen from chat where id_chat=?";// llamas al chat
        PreparedStatement Consulta = conect.prepareCall("{call USP_GET_CHAT(?)}");
        Consulta.setInt(1, idChat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            objChat.setId_chat(Resultado.getInt(1));
            objChat.setNombre_chat(Resultado.getString(2));
            objChat.setCan_personas(Resultado.getInt(3));
            objChat.setFecha_crecion_chat(Resultado.getDate(4));
            objChat.setImagen_chat(Resultado.getString(5));
        }
        return objChat;
    }

   
    public void AnhadirAdmin(int id_chat, String id_user, ArrayList<Usuario> userlista) throws SQLException {

        for (Usuario user : userlista) {
            this.insert_usuario_chat(id_chat, id_user, true);
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
