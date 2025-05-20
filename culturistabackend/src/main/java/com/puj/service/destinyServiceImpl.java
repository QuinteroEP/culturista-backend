package com.puj.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.Activity;
import com.puj.entity.Destiny;
import com.puj.repository.destinyRepository;
import com.puj.repository.activityRepository;

import jakarta.transaction.Transactional;

@Service
public class destinyServiceImpl implements destinyService {
    @Autowired
    destinyRepository repo;

    @Autowired
    private activityRepository activityRepo;

    @Override
    public Destiny findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Destiny> findAllDestinies() {
        return repo.findAll();
    }

    @Override
    public List<Destiny> filterList(List<Long> tipoIds, String ubicacion, LocalDate fecha_inicio, LocalDate fecha_fin, long precio, int capacidad) {
    List<Activity> actividades = activityRepo.findAllById(tipoIds);
    return repo.filterList(actividades, ubicacion, fecha_inicio, fecha_fin, precio, capacidad);
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
