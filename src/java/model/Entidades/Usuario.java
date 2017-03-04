package model.Entidades;


import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Usuario {

 private String id_usu;
    private String nombre_usu;
    private String alias;
    private String estado_usu;
    private String imagen_usu;
    private String email;
    private String password;
    private String fecha_registro;
    private int celular;

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

    /**
     * @return the nombre_usu
     */
    public String getNombre_usu() {
        return nombre_usu;
    }

    /**
     * @param nombre_usu the nombre_usu to set
     */
    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    /**
     * @return the alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     * @param alias the alias to set
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     * @return the estado_usu
     */
    public String getEstado_usu() {
        return estado_usu;
    }

    /**
     * @param estado_usu the estado_usu to set
     */
    public void setEstado_usu(String estado_usu) {
        this.estado_usu = estado_usu;
    }

    /**
     * @return the imagen_usu
     */
    public String getImagen_usu() {
        return imagen_usu;
    }

    /**
     * @param imagen_usu the imagen_usu to set
     */
    public void setImagen_usu(String imagen_usu) {
        this.imagen_usu = imagen_usu;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the fecha_registro
     */
    public String getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    /**
     * @return the celular
     */
    public int getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(int celular) {
        this.celular = celular;
    }

   
 
    
}
