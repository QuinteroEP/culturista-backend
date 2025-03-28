package com.puj.repository;
import java.util.*;

import org.springframework.stereotype.Repository;

import com.puj.entity.Destiny;

@Repository
public class destinyRepository {
    private Map<Integer, Destiny> data = new HashMap<>();

    public destinyRepository(){
        data.put(1, new Destiny("Monserrate", "Un lugar turístico de Bogotá", "https://www.google.com", "Bogotá", "Turismo", "2021-10-10"));
        data.put(2, new Destiny("Catedral de Sal", "Un lugar turístico de Zipaquirá", "https://www.google.com", "Zipaquirá", "Turismo", "2021-10-10"));
    }

    public Destiny findById(int id){
        return data.get(id);
    }

    public Collection<Destiny> findAll(){
        return data.values();
    }
}
