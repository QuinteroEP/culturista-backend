package com.puj.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;

import com.puj.entity.Destiny;
import com.puj.repository.destinyRepository;

public class destinyServiceImpl implements destinyService {
    @Autowired
    destinyRepository repo;


    public Destiny findById(int id) {
        return repo.findById(id);
    }

    public Collection<Destiny> findAll() {
        return repo.findAll();
    }
    
}
