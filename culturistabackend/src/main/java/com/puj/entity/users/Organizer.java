package com.puj.entity.users;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORGANIZADOR")
public class Organizer {
    private String nombre;
    private String apellido;
    private Long telefono;
    private Long cedula;
    private String correo;
    private String password;

    @Id
    @GeneratedValue
    private Long id;

    public Organizer() {}

    public Organizer(String nombre, String apellido, Long telefono, Long cedula, String correo, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
        this.password = password;
    }

    public Organizer(Long id, String nombre, String apellido, Long telefono, Long cedula, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.cedula = cedula;
        this.correo = correo;
        this.password = password;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getTelefono() {
        return this.telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public Long getCedula() {
        return this.cedula;
    }

    public void setCedula(Long cedula) {
        this.cedula = cedula;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
