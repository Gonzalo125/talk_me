package model;


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

 public String id_usu,nombre_usu,alias,estado_usu,imagen_usu,email,contraseña,fecha_registro;
 public int celular;
 public List<String> contactos;

    public Usuario(String id_usu, String nombre_usu, String alias, String estado_usu, String imagen_usu, String email, String contraseña, String fecha_registro, int celular, List<String> contactos) {
        this.id_usu = id_usu;
        this.nombre_usu = nombre_usu;
        this.alias = alias;
        this.estado_usu = estado_usu;
        this.imagen_usu = imagen_usu;
        this.email = email;
        this.contraseña = contraseña;
        this.fecha_registro = fecha_registro;
        this.celular = celular;
        this.contactos = contactos;
    }

    public Usuario() {
    }

    public String getId_usu() {
        return id_usu;
    }

    public void setId_usu(String id_usu) {
        this.id_usu = id_usu;
    }

    public String getNombre_usu() {
        return nombre_usu;
    }

    public void setNombre_usu(String nombre_usu) {
        this.nombre_usu = nombre_usu;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getEstado_usu() {
        return estado_usu;
    }

    public void setEstado_usu(String estado_usu) {
        this.estado_usu = estado_usu;
    }

    public String getImagen_usu() {
        return imagen_usu;
    }

    public void setImagen_usu(String imagen_usu) {
        this.imagen_usu = imagen_usu;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public List<String> getContactos() {
        return contactos;
    }

    public void setContactos(List<String> contactos) {
        this.contactos = contactos;
    }
    
}
