package com.puj.entity;

import java.time.LocalDate;

import com.puj.entity.users.Organizer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ACTIVIDADES")
public class Destiny {
    private String nombre;
    private String descripcion;
    private String imagen;
    private String ubicacion;
    private String tipo;
    private LocalDate fecha;
    private Long precio;
    private int capacidad;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Organizer organizer;

    public Destiny(Long id ,String nombre, String descripcion, String imagen, String ubicacion, String tipo, LocalDate fecha, Long precio, int capacidad) {
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

    public Destiny(String nombre, String descripcion, String imagen, String ubicacion, String tipo, LocalDate fecha, Long precio, int capacidad) {
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
   
    public Long getPrecio() {
        return precio;
    }

    public void setPrecio(Long precio) {
        this.precio = precio;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}
