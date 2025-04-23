package com.puj.service;

import java.util.List;

import com.puj.entity.Guide;

public interface guideService {
    public Guide findById(Long id);
    public List<Guide> findAllGuides();
    public Double getRating(Long id);
    public List<String> getReviews(Long id);
}
