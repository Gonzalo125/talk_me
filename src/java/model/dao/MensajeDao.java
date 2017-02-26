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
            mensaje.setId_chat(id_chat);
            mensaje.setId_usu(Resultado.getString(2));
            mensaje.setMensaje_contenido(Resultado.getString(2));
            mensaje.setFecha_de_envio(Resultado.getString(2));
            mensaje.setEstado_mensaje(Resultado.getString(2));
            
            mlist.add(mensaje);
        }
        
        
        return mlist;
    }
    
    public void addMensaje(int idchat, String mensaje, String idUser) {
        
        
    }

    
}
