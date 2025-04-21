package com.puj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.users.Traveler;
import com.puj.repository.travelerRepository;

import jakarta.transaction.Transactional;

@Service
public class travelerServiceImpl implements travelerService {
    @Autowired
    travelerRepository repo;

    @Override
    public Traveler findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Traveler findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<Traveler> findAllTravelers() {
        return repo.findAll();
    }

    @Override
    @Transactional
    public void add(Traveler usuario) {
        repo.save(usuario);
    }
    
}
