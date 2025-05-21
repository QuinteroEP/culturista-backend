package com.puj.entity;

import java.time.LocalDate;
import java.util.List;

import com.puj.entity.users.Organizer;

import jakarta.persistence.CascadeType;
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
    private LocalDate fecha;
    private Long precio;
    private int capacidad;
    private List<String> recomendaciones;

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Organizer organizer;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Activity tipo;

    public Destiny(Long id ,String nombre, String descripcion, String imagen, String ubicacion, Activity tipo, LocalDate fecha, Long precio, int capacidad, List<String> recomendaciones) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.precio = precio;
        this.capacidad = capacidad;
        this.recomendaciones = recomendaciones;
    }

    public Destiny(String nombre, String descripcion, String imagen, String ubicacion, Activity tipo, LocalDate fecha, Long precio, int capacidad, List<String> recomendaciones) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.ubicacion = ubicacion;
        this.tipo = tipo;
        this.fecha = fecha;
        this.precio = precio;
        this.capacidad = capacidad;
        this.recomendaciones = recomendaciones;
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

    public Activity getTipo() {
        return tipo;
    }

    public void setTipo(Activity tipo) {
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

    public List<String> getRecomendaciones() {
        return this.recomendaciones;
    }

    public void setRecomendaciones(List<String> recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

}
