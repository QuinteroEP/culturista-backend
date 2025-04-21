package com.puj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puj.entity.users.Traveler;

@Repository
public interface travelerRepository extends JpaRepository<Traveler, Long>{
    @Query("SELECT t FROM Traveler t WHERE t.correo = ?1")
    public Traveler findByEmail(String email);
}
