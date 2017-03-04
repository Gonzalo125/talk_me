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
import model.Entidades.UsuarioxChat;

/**
 *
 * @author 
 */
public class UsuarioxChatDao {

    Connection conect = Conexion.obtener();

    public UsuarioxChat get_userxChat(int id_user_chat) throws SQLException {
        String consulta = "Select id_usu_chat,id_chat, id_usu,fecha,admin from usuario x chat where id_usu_chat=?";//S introduciendo el id_usuario y obtienes todos estos datoseleccionados y eso hace q el 
        UsuarioxChat userxchat = new UsuarioxChat();
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, id_user_chat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            userxchat.setId_usuario_chat(Resultado.getInt(1));
            userxchat.setId_chat(Resultado.getInt(2));
             userxchat.setId_usuario(Resultado.getString(3));
            userxchat.setFecha(Resultado.getString(4));
           
            userxchat.setIs_admin(Resultado.getBoolean(5));

        }
        return userxchat;
    }

    public ArrayList<UsuarioxChat> getUsuarioxChat(int idChat) throws SQLException {
        ArrayList<UsuarioxChat> mlista = new ArrayList<>();
        String consulta = "Select id_usu_chat,id_chat, id_usu,fecha,admin from usuario x chat where id_chat=?";// seleccionas introduciendo tu id chat
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, idChat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            UsuarioxChat userxchat = new UsuarioxChat();

            userxchat.setId_usuario_chat(Resultado.getInt(1));
            userxchat.setId_chat(Resultado.getInt(2));
             userxchat.setId_usuario(Resultado.getString(3));
            userxchat.setFecha(Resultado.getString(4));
           
            userxchat.setIs_admin(Resultado.getBoolean(5));
            mlista.add(userxchat);

        }
        return mlista;
    }

    public ArrayList<UsuarioxChat> getUsuarioxChat(String idUser, int idchat) throws SQLException {
        ArrayList<UsuarioxChat> mlista = new ArrayList<>();
        String consulta = "Select id_usu_chat,id_chat, id_usu,fecha,admin from usuario x chat where id_usu=? and idchat = ?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        Consulta.setInt(1, idchat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            UsuarioxChat userxchat = new UsuarioxChat();

            userxchat.setId_usuario_chat(Resultado.getInt(1));
            userxchat.setId_chat(Resultado.getInt(2));
             userxchat.setId_usuario(Resultado.getString(3));
            userxchat.setFecha(Resultado.getString(4));
           
            userxchat.setIs_admin(Resultado.getBoolean(5));
            mlista.add(userxchat);

        }
        return mlista;
    }

    public ArrayList<UsuarioxChat> getUsuarioxChat(String idUser) throws SQLException {
        ArrayList<UsuarioxChat> mlista = new ArrayList<>();
        String consulta = "Select id_usu_chat,id_chat, id_usu,fecha,admin from usuario x chat where id_usu=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            UsuarioxChat userxchat = new UsuarioxChat();

            userxchat.setId_usuario_chat(Resultado.getInt(1));
            userxchat.setId_chat(Resultado.getInt(2));
             userxchat.setId_usuario(Resultado.getString(3));
            userxchat.setFecha(Resultado.getString(4));
           
            userxchat.setIs_admin(Resultado.getBoolean(5));
            mlista.add(userxchat);

        }
        return mlista;
    }

}
