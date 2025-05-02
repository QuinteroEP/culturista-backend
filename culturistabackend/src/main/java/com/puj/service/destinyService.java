package com.puj.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.puj.entity.Destiny;

public interface destinyService {

    public Destiny findById(Long id);
    public List<Destiny> findAllDestinies();
    public List<Destiny> filterList(List<String> tipo, String ubicacion, LocalDate fecha_inicio, LocalDate fecha_fin, long precio, int capacidad);
    public List<Destiny> getOrganizerDestinies(Long id);

    @Transactional
    public Destiny add(Destiny destiny);
    @Transactional
    public void update(Destiny destiny);
    @Transactional
    public void delete(Long id);
}
