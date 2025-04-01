package com.puj.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.Destiny;
import com.puj.repository.destinyRepository;

@Service
public class destinyServiceImpl implements destinyService {
    @Autowired
    destinyRepository repo;

    @Override
    public Destiny findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Collection<Destiny> findAllDestinies() {
        return repo.findAll();
    }
    
}
