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
    private int id_chat;
    private String mensaje_contenido;
    private String fecha_de_envio;
    private String estado_mensaje;
    private String id_usu;

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
     * @return the id_chat
     */
    public int getId_chat() {
        return id_chat;
    }

    /**
     * @param id_chat the id_chat to set
     */
    public void setId_chat(int id_chat) {
        this.id_chat = id_chat;
    }

    /**
     * @return the mensaje_contenido
     */
    public String getMensaje_contenido() {
        return mensaje_contenido;
    }

    /**
     * @param mensaje_contenido the mensaje_contenido to set
     */
    public void setMensaje_contenido(String mensaje_contenido) {
        this.mensaje_contenido = mensaje_contenido;
    }

    /**
     * @return the fecha_de_envio
     */
    public String getFecha_de_envio() {
        return fecha_de_envio;
    }

    /**
     * @param fecha_de_envio the fecha_de_envio to set
     */
    public void setFecha_de_envio(String fecha_de_envio) {
        this.fecha_de_envio = fecha_de_envio;
    }

    /**
     * @return the estado_mensaje
     */
    public String getEstado_mensaje() {
        return estado_mensaje;
    }

    /**
     * @param estado_mensaje the estado_mensaje to set
     */
    public void setEstado_mensaje(String estado_mensaje) {
        this.estado_mensaje = estado_mensaje;
    }

    /**
     * @return the id_usu
     */
    public String getId_usu() {
        return id_usu;
    }

    /**
     * @param id_usu the id_usu to set
     */
    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
    }

}
