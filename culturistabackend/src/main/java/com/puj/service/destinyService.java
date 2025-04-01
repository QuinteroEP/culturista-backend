package com.puj.service;

import java.util.List;

import com.puj.entity.Destiny;

public interface destinyService {

    public Destiny findById(Long id);
    public List<Destiny> findAllDestinies();
}
