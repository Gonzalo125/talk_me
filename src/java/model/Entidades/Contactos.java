/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Entidades;


public class Contactos {
    private int id_contacto;
    private String id_usuario_prin;
    private String id_usuario;

    /**
     * @return the id_contacto
     */
    public int getId_contacto() {
        return id_contacto;
    }

    /**
     * @param id_contacto the id_contacto to set
     */
    public void setId_contacto(int id_contacto) {
        this.id_contacto = id_contacto;
    }

    /**
     * @return the id_usuario_prin
     */
    public String getId_usuario_prin() {
        return id_usuario_prin;
    }

    /**
     * @param id_usuario_prin the id_usuario_prin to set
     */
    public void setId_usuario_prin(String id_usuario_prin) {
        this.id_usuario_prin = id_usuario_prin;
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
    
}
