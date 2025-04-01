package com.puj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puj.entity.Organizer;

@Repository
public interface organizerRepository extends JpaRepository<Organizer, Long>{
    
}
