package com.puj.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.Guide;
import com.puj.repository.guideRepository;

@Service
public class guideServiceImpl implements guideService{
    @Autowired
    guideRepository repo;

    @Override
    public Guide findById(Long id) {
        return repo.findById(id).get();
    }

    @Override
    public List<Guide> findAllGuides() {
        return repo.findAll();
    }
    
}
