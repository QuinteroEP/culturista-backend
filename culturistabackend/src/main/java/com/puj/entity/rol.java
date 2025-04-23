package com.puj.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class rol {
    @Id
    @GeneratedValue
    private Long id;

    private String tipo;

    public rol() {}

    public rol(String tipo) {
        this.tipo = tipo;
    }

    public rol(Long id, String tipo) {
        this.tipo = tipo;
        this.id = id;
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
