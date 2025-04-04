package com.puj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACTIVIDADES")
public class Destiny {
    private String nombre;
    private String descripcion;
    private String imagen;
    private String ubicacion;
    private String tipo;
    private String fecha;
    private int precio;
    private int capacidad;

    @Id
    @GeneratedValue
    private Long id;

    public Destiny(Long id ,String nombre, String descripcion, String imagen, String ubicacion, String tipo, String fecha, int precio, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    public Destiny(String nombre, String descripcion, String imagen, String ubicacion, String tipo, String fecha, int precio, int capacidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.precio = precio;
        this.capacidad = capacidad;
    }

    public Destiny() {
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
   
    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
