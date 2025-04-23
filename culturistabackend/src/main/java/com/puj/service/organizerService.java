package com.puj.service;

import com.puj.entity.users.Organizer;

import jakarta.transaction.Transactional;

public interface organizerService {
    public Organizer findById(Long id);
    public Organizer findByEmail(String email);

    @Transactional
    public Organizer add(Organizer usuario);
    
}
