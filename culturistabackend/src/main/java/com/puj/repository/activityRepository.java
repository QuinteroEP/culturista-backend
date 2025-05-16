package com.puj.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puj.entity.Activity;

@Repository
public interface activityRepository extends JpaRepository<Activity, Long> {
    
}
