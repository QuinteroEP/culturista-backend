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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puj.entity.Destiny;
import com.puj.service.destinyService;

@RestController
@RequestMapping("/destino")
@CrossOrigin(origins = "http://localhost:4200")
public class destiniesController {
    @Autowired
    destinyService destinyService;

    //Todos los destinos
    //localhost:8090/destino/all
     @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Destiny>> getAllDestinies(Model model) {
        List<Destiny> lista = destinyService.findAllDestinies();

        ResponseEntity<List<Destiny>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    //Buscar un destino
    //localhost:8090/destino/informacion/1
    @GetMapping("/informacion/{id}")
    @ResponseBody
    public ResponseEntity<Destiny> getDestiny(Model model, @PathVariable("id") Long id) {
        Destiny destino = destinyService.findById(id);

        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    //
    @GetMapping("/resultados/")
    @ResponseBody
    public ResponseEntity<List<Destiny>> getDestinyResults(
            Model model,
            @RequestParam(name = "tipo") String tipo,
            @RequestParam(name = "ubicacion") String ubicacion,
            @RequestParam(name = "fecha") String fecha,
            @RequestParam(name = "precio") int precio,
            @RequestParam(name = "capacidad") int capacidad) {
        List<Destiny> lista = destinyService.filterList(tipo, ubicacion, fecha, precio, capacidad);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
}
