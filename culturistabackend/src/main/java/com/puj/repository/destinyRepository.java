package com.puj.repository;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puj.entity.Destiny;

@Repository
public interface destinyRepository extends JpaRepository<Destiny, Long> {
    @Query("SELECT d FROM Destiny d WHERE d.tipo IN ?1 AND d.ubicacion = ?2 AND d.fecha BETWEEN ?3 AND ?4 AND d.precio <= ?5 AND d.capacidad >= ?6")
    public List<Destiny> filterList(List<String> tipo, String ubicacion, LocalDate fecha_inicio, LocalDate fecha_fin, long precio, int capacidad);
}
