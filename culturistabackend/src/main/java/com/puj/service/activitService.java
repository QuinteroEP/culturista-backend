package com.puj.service;

import org.springframework.transaction.annotation.Transactional;

import com.puj.entity.Activity;

public interface activitService {
    @Transactional
    public Activity add(Activity activity);
    @Transactional
    public void update(Activity activity);
    @Transactional
    public void delete(Long id);
}
