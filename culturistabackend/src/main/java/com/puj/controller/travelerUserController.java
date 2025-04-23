package com.puj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.puj.security.customUserDetailsService;
import com.puj.entity.userEntity;
import com.puj.entity.users.Traveler;
import com.puj.repository.userRepository;
import com.puj.service.travelerService;

@RestController
@RequestMapping("/usuario/viajero")
@CrossOrigin(origins = "http://localhost:4200")
public class travelerUserController {

    @Autowired
    private userRepository userRepository;
    
    @Autowired
    private travelerService travelerService;

    @Autowired
    private customUserDetailsService customUserDetailsService;

    //Crear cuenta
    //localhost:8090/usuario/viajero/signup/add
    @PostMapping("/signup/add")
    @ResponseBody
    public ResponseEntity<Traveler> travelerSignup(@RequestBody Traveler traveler) {
        System.out.println("Received traveler: " + traveler);
        if(userRepository.existsByUsername(traveler.getCorreo())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userEntity userEntity = customUserDetailsService.TravelerToUser(traveler);
        traveler.setUser(userEntity);

        Traveler newTraveler = travelerService.add(traveler);
        if(newTraveler != null) {
            return new ResponseEntity<>(newTraveler, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Iniciar sesion
    //localhost:8090/usuario/viajero/login
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<List<Traveler>> travelerLogin(Map<String, String> requestMap) {
        
        ResponseEntity<List<Traveler>> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }

    //Buscar un viajero
    //localhost:8090/usuario/viajero/1
    @GetMapping("informacion/{id}")
    @ResponseBody
    public ResponseEntity<Traveler> getTraveler(Model model, @PathVariable("id") Long id) {
        Traveler traveler = travelerService.findById(id);

        return new ResponseEntity<>(traveler, HttpStatus.OK);
    }
}
