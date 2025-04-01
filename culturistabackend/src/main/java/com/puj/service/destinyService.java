package com.puj.service;

import java.util.Collection;

import com.puj.entity.Destiny;

public interface destinyService {

    public Destiny findById(Long id);
    public Collection<Destiny> findAllDestinies();
}
