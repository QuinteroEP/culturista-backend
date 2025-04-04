package com.puj.service;

import java.util.List;

import com.puj.entity.Destiny;

public interface destinyService {

    public Destiny findById(Long id);
    public List<Destiny> findAllDestinies();
    public List<Destiny> filterList(String tipo, String ubicacion, String fecha, int precio, int capacidad);
}
