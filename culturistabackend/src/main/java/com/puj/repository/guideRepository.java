package com.puj.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puj.entity.Guide;

@Repository
public interface guideRepository extends JpaRepository<Guide, Long> {
    @Query("SELECT g.puntaje FROM Guide g WHERE g.id = ?1")
    public Double getRating(Long id);

    @Query("SELECT g.comentarios FROM Guide g WHERE g.id = ?1")
    public List<String> getReviews(Long id);
    
}
