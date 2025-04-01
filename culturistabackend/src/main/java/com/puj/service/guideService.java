package com.puj.service;

import java.util.List;

import com.puj.entity.Guide;

public interface guideService {
    public Guide findById(Long id);
    public List<Guide> findAllGuides();

}
