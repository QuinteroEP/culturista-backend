package com.puj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puj.entity.rol;

public interface rolRepository extends JpaRepository<rol, Long> {
    Optional<rol> findByTipo(String tipo);
    
}
