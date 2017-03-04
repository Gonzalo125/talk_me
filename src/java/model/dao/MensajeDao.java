package model.dao;

import Conexion.Conectbd.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import model.Entidades.Mensaje;
import model.Entidades.UsuarioxChat;

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

        String consulta = "Select a.id_mensaje, a.id_usu_chat, a.fecha, a.mensaje from mensaje a, usuario x chat b where a.id_usu_chat = b.id_usu_chat and  b.id_Chat=?";//aca combina dos tablas del mensaje y del usuaeio por chat
        PreparedStatement Consulta = conect.prepareStatement(consulta);
        Consulta.setInt(1, id_chat);
        ResultSet Resultado = Consulta.executeQuery();
        while (Resultado.next()) {
            Mensaje mensaje = new Mensaje();

            mensaje.setId_mensaje(Resultado.getInt(1));
            mensaje.setId_usuario_chat(Resultado.getInt(2));
            mensaje.setFecha(Resultado.getString(3));
            mensaje.setMensaje(Resultado.getString(4));

            mlist.add(mensaje);
        }

        return mlist;
    }

    public void addMensaje(int idchat, String mensaje, String idUser) throws SQLException {

        UsuarioxChatDao chatdao = new UsuarioxChatDao();
        ArrayList<UsuarioxChat> mlist = chatdao.getUsuarioxChat(idUser, idchat);

        int id_usuario_chat = mlist.get(0).getId_usuario_chat();

        //String consulta = "insert into mensaje (id_usu_chat, fecha, mensaje) values( ?,?, ?)";
        PreparedStatement insert = conect.prepareCall("call USP_ADD_MENSAJE(?,?,?)");
        insert.setInt(1, id_usuario_chat);
        long mili = System.currentTimeMillis();
        Date date = new Date(mili);
        insert.setDate(2, date);
        insert.setString(3, mensaje);

        insert.execute();
    }

}
