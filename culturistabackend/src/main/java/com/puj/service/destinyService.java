package com.puj.service;

import java.util.*;

import com.puj.entity.Destiny;

public interface destinyService {

    public Destiny findById(int id);
    public Collection<Destiny> findAll();
}
