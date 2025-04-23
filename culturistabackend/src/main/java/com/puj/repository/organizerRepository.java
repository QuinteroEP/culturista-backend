package com.puj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puj.entity.users.Organizer;

@Repository
public interface organizerRepository extends JpaRepository<Organizer, Long>{
    @Query("SELECT t FROM Organizer t WHERE t.correo = ?1")
    public Organizer findByEmail(String email);
}
