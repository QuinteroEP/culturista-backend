package com.puj.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puj.entity.users.Traveler;
import com.puj.service.travelerService;

@RestController
@RequestMapping("/usuario/viajero")
@CrossOrigin(origins = "http://localhost:4200")
public class travelerUserController {
    @Autowired
    private travelerService travelerService;

    //Crear cuenta
    //localhost:8090/usuario/viajero/signup
    @PostMapping("/signup")
    @ResponseBody
    public ResponseEntity<Traveler> travelerSignup(Model model) {
        Traveler user = new Traveler ();
        model.addAttribute("usuario", user);
        
        ResponseEntity<Traveler> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }

    //Iniciar sesion
    //localhost:8090/usuario/viajero/login
    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<List<Traveler>> travelerLogin(Map<String, String> requestMap) {
        
        ResponseEntity<List<Traveler>> response = new ResponseEntity<>(HttpStatus.OK);
        return response;
    }
}
