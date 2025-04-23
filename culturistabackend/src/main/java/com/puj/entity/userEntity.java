package com.puj.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class userEntity {
    @Id
    @GeneratedValue
    private Long id;

    private String username;
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    List<rol> roles = new ArrayList<>();

    public userEntity() {}

    public userEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public userEntity(String username, String password, List<rol> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public userEntity(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public userEntity(Long id, String username, String password, List<rol> roles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<rol> getRoles() {
        return this.roles;
    }

    public void setRoles(List<rol> roles) {
        this.roles = roles;
    }
}
