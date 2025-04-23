package com.puj.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.puj.entity.userEntity;

public interface userRepository extends JpaRepository<userEntity, Long> {
    Optional<userEntity> findByUsername(String username);
    Boolean existsByUsername(String username);
}
