package com.puj.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.puj.repository.destinyRepository;
import com.puj.repository.guideRepository;
import com.puj.repository.organizerRepository;

import jakarta.transaction.Transactional;

@Controller
@Transactional
public class Databaseinit implements ApplicationRunner{

    @Autowired
    destinyRepository destinyRepository;

    @Autowired
    guideRepository guideRepository;

    @Autowired
    organizerRepository organizerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Destinos
        destinyRepository.save(new Destiny("Monserrate", "Un lugar turístico de Bogotá", "https://www.google.com", "Bogotá", "Turismo", "2021-10-10", "2021-10-20"));
        destinyRepository.save(new Destiny("Catedral de Sal", "Un lugar turístico de Zipaquirá", "https://www.google.com", "Zipaquirá", "Turismo", "2021-10-10", "2021-10-20"));

        //Guias
        guideRepository.save(new Guide("Andres","https://www.google.com",31020088L,"andres@puj.co"));

        //Organizadores
        organizerRepository.save(new Organizer("Pablo",310290000L,"pablo@kim.com"));
    }
    
}
