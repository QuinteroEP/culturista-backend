package com.puj.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.puj.entity.Guide;

public interface guideService {
    public Guide findById(Long id);
    public List<Guide> findAllGuides();
    public Double getRating(Long id);
    public List<String> getReviews(Long id);

    @Transactional
    public Guide add(Guide guide);
    @Transactional
    public Guide update(Guide guide);
    @Transactional
    public void delete(Long id);
}
