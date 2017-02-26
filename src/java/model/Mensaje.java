/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author giancarlorau
 */
public class Mensaje {
    
    private int id_mensaje;
    private int id_usuario_chat;
    private int id_tipo_mensaje;
    private String mensaje;
    private String fecha;
    
    /**
     * @return the id_mensaje
     */
    public int getId_mensaje() {
        return id_mensaje;
    }

    /**
     * @param id_mensaje the id_mensaje to set
     */
    public void setId_mensaje(int id_mensaje) {
        this.id_mensaje = id_mensaje;
    }

    /**
     * @return the id_usuario_chat
     */
    public int getId_usuario_chat() {
        return id_usuario_chat;
    }

    /**
     * @param id_usuario_chat the id_usuario_chat to set
     */
    public void setId_usuario_chat(int id_usuario_chat) {
        this.id_usuario_chat = id_usuario_chat;
    }

    /**
     * @return the id_tipo_mensaje
     */
    public int getId_tipo_mensaje() {
        return id_tipo_mensaje;
    }

    /**
     * @param id_tipo_mensaje the id_tipo_mensaje to set
     */
    public void setId_tipo_mensaje(int id_tipo_mensaje) {
        this.id_tipo_mensaje = id_tipo_mensaje;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
