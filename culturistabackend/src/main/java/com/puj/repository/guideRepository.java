package com.puj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puj.entity.Guide;

@Repository
public interface guideRepository extends JpaRepository<Guide, Long> {
    
}
