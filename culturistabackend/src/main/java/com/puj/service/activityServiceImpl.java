package com.puj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puj.entity.Activity;
import com.puj.repository.activityRepository;

import jakarta.transaction.Transactional;

@Service
public class activityServiceImpl implements activityService{
    @Autowired
    activityRepository repo;

    public List<Activity> findAll(){
        return repo.findAll();
    }

    @Override
    @Transactional
    public Activity add(Activity activity) {
        return repo.save(activity);
    }

    @Override
    @Transactional
    public void update(Activity activity) {
        repo.save(activity);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
