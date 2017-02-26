package model.dao;

import Conexion.Conectbd.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Mensaje;
import model.UsuarioxChat;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author User
 */
public class MensajeDao {

    Connection conect = Conexion.obtener();

    public ArrayList<Mensaje> ObtenerMensaje(int id_chat) throws SQLException {

        ArrayList<Mensaje> mlist = new ArrayList<>();

        String consulta = "Select * from Mensaje where id_Chat=?";
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, id_chat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            Mensaje mensaje = new Mensaje();

            mensaje.setId_mensaje(Resultado.getInt(1));
            mensaje.setId_usuario_chat(id_chat);
            mensaje.setMensaje(consulta);

            mlist.add(mensaje);
        }

        return mlist;
    }

    public void addMensaje(int idchat, String mensaje, String idUser) throws SQLException {

        UsuarioxChatDao chatdao = new UsuarioxChatDao();
        ArrayList<UsuarioxChat> mlist = chatdao.getUsuarioxChat(idUser, idchat);

        int id_usuario_chat = mlist.get(0).getId_usuario_chat();

        String consulta = "insert into  mensajes(idusuario, idusuairo_p) values( ?,?)";
        PreparedStatement insert = conect.prepareStatement(consulta);
        insert.setInt(1, id_usuario_chat);
        insert.setString(2, mensaje);

        insert.execute();
    }

}
