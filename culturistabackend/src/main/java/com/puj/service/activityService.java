package com.puj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.puj.entity.Activity;

public interface activityService {
    public List<Activity> findAll();
    
    @Transactional
    public Activity add(Activity activity);
    @Transactional
    public void update(Activity activity);
    @Transactional
    public void delete(Long id);
}
