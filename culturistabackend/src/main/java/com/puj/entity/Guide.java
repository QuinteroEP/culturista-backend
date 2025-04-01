package com.puj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "GUIAS")   
public class Guide {
    private String nombre;
    private String imagen;
    private Long telefono;
    private String correo;

    @Id
    @GeneratedValue
    private Long id;

    public Guide(Long id ,String nombre, String imagen, Long telefono, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.imagen = imagen;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Guide(String nombre, String imagen, Long telefono, String correo) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.telefono = telefono;
        this.correo = correo;
    }

    public Guide() {
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
