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
import model.UsuarioxChat;

/**
 *
 * @author giancarlorau
 */
public class UsuarioxChatDao {

    Connection conect = Conexion.obtener();

    public UsuarioxChat get_userxChat(int id_user_chat) throws SQLException {
        String consulta = "Select * from usuarioxchat where id=?";
        UsuarioxChat userxchat = new UsuarioxChat();
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, id_user_chat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {

            userxchat.setFecha("");
            userxchat.setId_chat(1);
            userxchat.setId_usuario("1");
            userxchat.setId_usuario_chat(1);
            userxchat.setIs_admin(true);

        }
        return userxchat;
    }

    public ArrayList<UsuarioxChat> getUsuarioxChat(int idChat) throws SQLException {
        ArrayList<UsuarioxChat> mlista = new ArrayList<>();
        String consulta = "Select * from usuarioxchat where id_chat=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, idChat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            UsuarioxChat userxchat = new UsuarioxChat();

            userxchat.setFecha("");
            userxchat.setId_chat(idChat);
            userxchat.setId_usuario("1");
            userxchat.setId_usuario_chat(1);
            userxchat.setIs_admin(true);
            mlista.add(userxchat);

        }
        return mlista;
    }

    public ArrayList<UsuarioxChat> getUsuarioxChat(String idUser, int idchat) throws SQLException {
        ArrayList<UsuarioxChat> mlista = new ArrayList<>();
        String consulta = "Select * from usuarioxchat where id_user=? and idchat = ?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        Consulta.setInt(1, idchat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            UsuarioxChat userxchat = new UsuarioxChat();

            userxchat.setFecha("");
            userxchat.setId_chat(1);
            userxchat.setId_usuario(idUser);
            userxchat.setId_usuario_chat(1);
            userxchat.setIs_admin(true);
            mlista.add(userxchat);

        }
        return mlista;
    }

    public ArrayList<UsuarioxChat> getUsuarioxChat(String idUser) throws SQLException {
        ArrayList<UsuarioxChat> mlista = new ArrayList<>();
        String consulta = "Select * from usuarioxchat where id_user=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setString(1, idUser);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            UsuarioxChat userxchat = new UsuarioxChat();

            userxchat.setFecha("");
            userxchat.setId_chat(1);
            userxchat.setId_usuario(idUser);
            userxchat.setId_usuario_chat(1);
            userxchat.setIs_admin(true);
            mlista.add(userxchat);

        }
        return mlista;
    }

}
