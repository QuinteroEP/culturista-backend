package com.puj.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.Destiny;
import com.puj.repository.destinyRepository;

import jakarta.transaction.Transactional;

@Service
public class destinyServiceImpl implements destinyService {
    @Autowired
    destinyRepository repo;

    @Override
    public Destiny findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Destiny> findAllDestinies() {
        return repo.findAll();
    }

    @Override
    public List<Destiny> filterList(List<String> tipo, String ubicacion, LocalDate fecha_inicio, LocalDate fecha_fin, long precio, int capacidad) {
        return repo.filterList(tipo, ubicacion, fecha_inicio, fecha_fin, precio, capacidad);
    }

    @Override
    public List<Destiny> getOrganizerDestinies(Long id) {
        return repo.getOrganizerDestinies(id);
    }

    @Override
    @Transactional
    public Destiny add(Destiny destiny) {
        return repo.save(destiny);
    }

    @Override
    @Transactional
    public void update(Destiny destiny) {
        repo.save(destiny);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
