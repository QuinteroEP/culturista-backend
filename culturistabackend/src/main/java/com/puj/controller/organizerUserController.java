package com.puj.controller;

import java.util.List;

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

import com.puj.entity.Destiny;
import com.puj.entity.userEntity;
import com.puj.entity.users.Organizer;
import com.puj.repository.userRepository;
import com.puj.security.customUserDetailsService;
import com.puj.service.destinyService;
import com.puj.service.organizerService;

@RestController
@RequestMapping("/usuario/organizador")
@CrossOrigin(origins = "http://localhost:4200")
public class organizerUserController {

    @Autowired
    private userRepository userRepository;
    
    @Autowired
    private organizerService organizerService;

    @Autowired
    private destinyService destinyService;

    @Autowired
    private customUserDetailsService customUserDetailsService;

    //Crear cuenta
    //localhost:8090/usuario/organizador/signup/add
    @PostMapping("/signup/add")
    @ResponseBody
    public ResponseEntity<Organizer> organizerSignup(@RequestBody Organizer organizer) {
        if(userRepository.existsByUsername(organizer.getCorreo())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        userEntity userEntity = customUserDetailsService.OrganizerToUser(organizer);
        organizer.setUser(userEntity);

        Organizer newOrganizer = organizerService.add(organizer);
        if(newOrganizer != null) {
            return new ResponseEntity<>(newOrganizer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //Obtener destinos de un organizador
    //localhost:8090/usuario/organizador/destinos/1
    @GetMapping("/destinos/{id}")
    @ResponseBody
    public ResponseEntity<List<Destiny>> getDestinies(Model model, @PathVariable("id") Long id){
        List<Destiny> destinies = destinyService.getOrganizerDestinies(id);

        return new ResponseEntity<>(destinies, HttpStatus.OK);
    }
}
