package com.puj.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.puj.entity.Destiny;

@Repository
public interface destinyRepository extends JpaRepository<Destiny, Long> {
    @Query("SELECT d FROM Destiny d WHERE d.tipo = ?1 AND d.ubicacion = ?2 AND d.fecha = ?3 AND d.precio <= ?4 AND d.capacidad >= ?5")
    public List<Destiny> filterList(String tipo, String ubicacion, String fecha, int precio, int capacidad);
}
