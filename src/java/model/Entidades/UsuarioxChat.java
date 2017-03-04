/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entidades;

public class UsuarioxChat {
    
    private int id_usuario_chat;
    private String id_usuario;
    private int id_chat;
    private String fecha;
    private Boolean estado;
    private Boolean is_admin;

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
     * @return the id_usuario
     */
    public String getId_usuario() {
        return id_usuario;
    }

    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
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

    /**
     * @return the estado
     */
    public Boolean getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    /**
     * @return the is_admin
     */
    public Boolean getIs_admin() {
        return is_admin;
    }

    /**
     * @param is_admin the is_admin to set
     */
    public void setIs_admin(Boolean is_admin) {
        this.is_admin = is_admin;
    }
}
