package com.puj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TIPO_ACTIVIDADES")
public class Activity {
    @Id
    @GeneratedValue
    private Long id;

    private String tipo;

    public Activity() {}

    public Activity(Long id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public Activity(String tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
