package com.puj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.users.Organizer;
import com.puj.repository.organizerRepository;

@Service
public class organizerServiceImpl implements organizerService {

    @Autowired
    organizerRepository repo;

    @Override
    public Organizer findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public Organizer findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public Organizer add(Organizer usuario) {
        return repo.save(usuario);
    }
    
}
