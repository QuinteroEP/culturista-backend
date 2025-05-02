package com.puj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.Destiny;
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

    @Override
    public Double getRating(Long id) {
        return repo.getRating(id);
    }

    @Override
    public List<String> getReviews(Long id) {
        return repo.getReviews(id);
    }

     @Override
    public Guide add(Guide guide) {
        return repo.save(guide);
    }

    @Override
    public Guide update(Guide guide) {
        return repo.save(guide);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}
