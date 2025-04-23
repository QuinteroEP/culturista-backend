package com.puj.service;

import java.util.List;

import com.puj.entity.users.Traveler;

import jakarta.transaction.Transactional;

public interface travelerService {
    public Traveler findById(Long id);
    public Traveler findByEmail(String email);
    public List<Traveler> findAllTravelers();

    @Transactional
    public Traveler add(Traveler usuario);
}
