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
        destinyRepository.save(new Destiny("Cerro de Monserrate", "Una capilla en la cima de un cerro de Bogotá", "https://www.google.com", "Bogotá", "Deportivo", "2021-10-10", 5000, 10));
        
        destinyRepository.save(new Destiny("Catedral de Sal", "Una mina de sal en Zipaquirá con una catedral adentro", "https://www.google.com", "Zipaquirá", "Turismo", "2021-10-10", 15000, 10));

        destinyRepository.save(new Destiny("Ciudad Amurallada", "Centro historico en Cartagena de Indias rodeado por un muro de piedra", "https://www.google.com", "Cartagena", "Cultural", "2021-10-10", 0, 10));

        //Guias
        guideRepository.save(new Guide("Andres","https://www.google.com",31020088L,"andres@puj.co"));
        guideRepository.save(new Guide("Javier","https://www.google.com",34466708L,"javi@puj.co"));

        //Organizadores
        organizerRepository.save(new Organizer("Pablo",310290000L,"pablo@kim.com"));
    }
    
}
