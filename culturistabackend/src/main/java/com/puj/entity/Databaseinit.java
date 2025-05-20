package com.puj.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import com.puj.entity.users.Organizer;
import com.puj.entity.users.Traveler;
import com.puj.repository.activityRepository;
import com.puj.repository.destinyRepository;
import com.puj.repository.guideRepository;
import com.puj.repository.organizerRepository;
import com.puj.repository.rolRepository;
import com.puj.repository.travelerRepository;
import com.puj.repository.userRepository;

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

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    rolRepository rolRepository;

    @Autowired
    userRepository userRepository;

    @Autowired
    activityRepository activityRepository;

    @SuppressWarnings("deprecation")
    @Override
    public void run(ApplicationArguments args) throws Exception {

        rolRepository.save(new rol("VIAJERO"));
        rolRepository.save(new rol("ORGANIZADOR"));

        //Guias
        guideRepository.save(new Guide("Andres","https://www.google.com",31020088L,"andres@puj.co", null));
        guideRepository.save(new Guide("Javier","https://www.google.com",34466708L,"javi@puj.co", null));

        //Reseñas y puntajes
        List<Guide> guideList = guideRepository.findAll();
        List<String> review = new ArrayList<>();
        
        Random rand = new Random();
    
        review.add("El guia fue muy amable y conocedor de la historia del lugar.");
        review.add("La experiencia fue increíble, aprendí mucho sobre la cultura local.");
        review.add("El guia no estaba preparado y no pudo responder a mis preguntas.");

        for(int i = 0; i < guideList.size(); i++){
            Guide guide = guideList.get(i);
            guide.setComentarios(review);

            Double totalScore = 0.0;
            for(int j = 0; j < 3; j++){
                totalScore = totalScore + rand.nextDouble() * (10.0 - 5.0) + 5.0;
            }
            totalScore = totalScore / 3.0;
            totalScore = Math.round(totalScore * 10.0) / 10.0;
            guide.setPuntaje(totalScore);
        }

        userEntity userEntity;

        //Organizadores
        Organizer newOrganizer;

        newOrganizer = new Organizer("Andres","Quiroga", 310290000L,1112113L, "andres@puj.com",passwordEncoder.encode("quiroga24"));
        userEntity = saveUserOrg(newOrganizer);
        newOrganizer.setUser(userEntity);
        organizerRepository.save(newOrganizer);

        newOrganizer = new Organizer("Sebastian","Forero", 310253200L,1212663L, "forero@puj.com",passwordEncoder.encode("SForero"));
        userEntity = saveUserOrg(newOrganizer);
        newOrganizer.setUser(userEntity);
        organizerRepository.save(newOrganizer);

        //Viajeros
        Traveler newTraveler;

        newTraveler = new Traveler("Pablo","Quintero", "pquintero@javeriana.co", 310290000L, passwordEncoder.encode("moira24"));
        userEntity = saveUserTraveler(newTraveler);
        newTraveler.setUser(userEntity);
        travelerRepository.save(newTraveler);

        //Tipos de actividad
        activityRepository.save(new Activity("Cultural"));
        activityRepository.save(new Activity("Religioso"));
        activityRepository.save(new Activity("Deportivo"));
        activityRepository.save(new Activity("Gastronómica"));
        activityRepository.save(new Activity("Relajante"));
        activityRepository.save(new Activity("Aventura"));
        activityRepository.save(new Activity("Turismo"));
        activityRepository.save(new Activity("Otros"));

        //Destinos
        Destiny newDestiny;
        List<String> recom;
        Guide guide;

        newDestiny = new Destiny("Cerro de Monserrate", "Una capilla en la cima de un cerro de Bogotá", "https://www.google.com", "Bogotá", null, LocalDate.of(2025, 1, 10), 5000L, 10, null);
        newDestiny.setTipo(activityRepository.getById(3L));

        recom = new ArrayList<>();
        recom.add("Llevar ropa calida");
        recom.add("Llevar zapatos para caminar");
        recom.add("Llevar hidratacion");
        newDestiny.setRecomendaciones(recom);

        destinyRepository.save(newDestiny);
        guide = guideList.get(0);
        guide.setGuia_de(newDestiny);

        newDestiny = new Destiny("Nuestra señora de Lourdes", "Una basilica de arquitectura barroca", "https://www.google.com", "Bogotá", null, LocalDate.of(2025, 1, 5), 5000L, 3, null);
        newDestiny.setTipo(activityRepository.getById(2L));

        destinyRepository.save(newDestiny);

        newDestiny = new Destiny("Catedral de Sal", "Una mina de sal en Zipaquirá con una catedral adentro", "https://www.google.com", "Zipaquirá", null, LocalDate.of(2025, 1, 7), 15000L, 10, null);
        newDestiny.setTipo(activityRepository.getById(5L));

        recom = new ArrayList<>();
        recom.add("Llevar ropa comoda");
        recom.add("Tener dinero en efectivo");
        newDestiny.setRecomendaciones(recom);
        
        destinyRepository.save(newDestiny);

        newDestiny = new Destiny("Ciudad Amurallada", "Centro historico en Cartagena de Indias rodeado por un muro de piedra", "https://www.google.com", "Cartagena", null, LocalDate.of(2025, 1, 1), 0L, 10, null);
        newDestiny.setTipo(activityRepository.getById(1L));

        recom = new ArrayList<>();
        recom.add("Traer proteccion contra el sol");
        recom.add("Tener dinero en efectivo");
        newDestiny.setRecomendaciones(recom);
        
        destinyRepository.save(newDestiny);

        newDestiny = new Destiny("Castillo de San Felipe de Barajas", "Fuerte Español ubicado en el cerro de San Lázaro", "https://www.google.com", "Cartagena", null, LocalDate.of(2025, 1, 4), 0L, 10, null);
        newDestiny.setTipo(activityRepository.getById(1L));

        recom = new ArrayList<>();
        recom.add("Traer proteccion contra el sol");
        recom.add("Llevar zapatos comodos");
        recom.add("Llevar hidratacion");
        newDestiny.setRecomendaciones(recom);
        
        destinyRepository.save(newDestiny);
        guide = guideList.get(1);
        guide.setGuia_de(newDestiny);

        newDestiny = new Destiny("La puerta falsa", "Restaurante clasico de comida local", "https://www.google.com", "Bogotá", null, LocalDate.of(2025, 1, 1), 50000L, 10, null);
        newDestiny.setTipo(activityRepository.getById(4L));
        
        destinyRepository.save(newDestiny);
        
        newDestiny = new Destiny("El Tramonti", "Restaurante clasico de comida local", "https://www.google.com", "Bogotá", null, LocalDate.of(2025, 12, 31), 50000L, 10, null);
        newDestiny.setTipo(activityRepository.getById(4L));
        
        destinyRepository.save(newDestiny);

        //Asociar destinos con organizadores
        List<Organizer> organizerList = organizerRepository.findAll();
        List<Destiny> destinyList = destinyRepository.findAll();
        
        for(int i = 0; i < destinyList.size(); i++){
            Organizer organizer = organizerList.get(i % organizerList.size());
            Destiny destiny = destinyList.get(i);
            destiny.setOrganizer(organizer);
        }
    }
    
    private userEntity saveUserTraveler(Traveler traveler){
        userEntity user = new userEntity();

        user.setUsername(traveler.getCorreo());
        user.setPassword(traveler.getPassword());

        rol rol = rolRepository.findByTipo("VIAJERO").get();
        user.setRoles(List.of(rol));
        return userRepository.save(user);
    } 

    private userEntity saveUserOrg(Organizer organizer){
        userEntity user = new userEntity();

        user.setUsername(organizer.getCorreo());
        user.setPassword(organizer.getPassword());

        rol rol = rolRepository.findByTipo("ORGANIZADOR").get();
        user.setRoles(List.of(rol));
        return userRepository.save(user);
    }
    
}
