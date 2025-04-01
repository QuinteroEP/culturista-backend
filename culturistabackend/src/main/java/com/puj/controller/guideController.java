package com.puj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puj.service.guideService;
import com.puj.entity.Guide;

@RestController
@RequestMapping("/guias")
@CrossOrigin(origins = "http://localhost:4200")
public class guideController {
    @Autowired
    guideService guiaService;

    //Todos los guias
    //localhost:8080/guias/all
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Guide>> getAllGuides(Model model) {
        List<Guide> lista = guiaService.findAllGuides();

        ResponseEntity<List<Guide>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    //Buscar un guia
    //localhost:8080/guias/informacion/1
    @GetMapping("/informacion/{id}")
    @ResponseBody
    public ResponseEntity<Guide> getGuia(Model model, @PathVariable("id") Long id) {
        Guide guia = guiaService.findById(id);

        return new ResponseEntity<>(guia, HttpStatus.OK);
    }
}
