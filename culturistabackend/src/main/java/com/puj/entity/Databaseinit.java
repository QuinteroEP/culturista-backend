package com.puj.entity;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Controller;

import com.puj.entity.users.Organizer;
import com.puj.entity.users.Traveler;
import com.puj.repository.destinyRepository;
import com.puj.repository.guideRepository;
import com.puj.repository.organizerRepository;
import com.puj.repository.travelerRepository;

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

    @Autowired
    travelerRepository travelerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        //Destinos
        destinyRepository.save(new Destiny("Cerro de Monserrate", "Una capilla en la cima de un cerro de Bogotá", "https://www.google.com", "Bogotá", "Deportivo", LocalDate.of(2025, 1, 10), 5000L, 10));
        destinyRepository.save(new Destiny("Nuestra señora de Lourdes", "Una basilica de arquitectura barroca", "https://www.google.com", "Bogotá", "Religioso", LocalDate.of(2025, 1, 5), 5000L, 3));
        
        destinyRepository.save(new Destiny("Catedral de Sal", "Una mina de sal en Zipaquirá con una catedral adentro", "https://www.google.com", "Zipaquirá", "Turismo", LocalDate.of(2025, 1, 7), 15000L, 10));

        destinyRepository.save(new Destiny("Ciudad Amurallada", "Centro historico en Cartagena de Indias rodeado por un muro de piedra", "https://www.google.com", "Cartagena", "Cultural", LocalDate.of(2025, 1, 1), 0L, 10));
        destinyRepository.save(new Destiny("Castillo de San Felipe de Barajas", "Fuerte Español ubicado en el cerro de San Lázaro", "https://www.google.com", "Cartagena", "Cultural", LocalDate.of(2025, 1, 4), 0L, 10));

        destinyRepository.save(new Destiny("La puerta falsa", "Restaurante clasico de comida local", "https://www.google.com", "Bogotá", "Gastronómica", LocalDate.of(2025, 1, 1), 50000L, 10));
        destinyRepository.save(new Destiny("El Tramonti", "Restaurante clasico de comida local", "https://www.google.com", "Bogotá", "Gastronómica", LocalDate.of(2025, 12, 31), 50000L, 10));

        //Guias
        guideRepository.save(new Guide("Andres","https://www.google.com",31020088L,"andres@puj.co"));
        guideRepository.save(new Guide("Javier","https://www.google.com",34466708L,"javi@puj.co"));

        //Organizadores
        organizerRepository.save(new Organizer("Andres","Quiroga", 310290000L,1112113L, "andres@puj.com", "quiroga2024"));

        //Usuarios
        travelerRepository.save(new Traveler("Pablo","Quintero", "pquinter@javeriana.co", 310290000L,"moira24"));
    }
    
}
