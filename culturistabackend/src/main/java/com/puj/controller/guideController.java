package com.puj.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
    //localhost:8090/guias/all
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Guide>> getAllGuides(Model model) {
        List<Guide> lista = guiaService.findAllGuides();

        ResponseEntity<List<Guide>> response = new ResponseEntity<>(lista, HttpStatus.OK);
        return response;
    }

    //Buscar un guia
    //localhost:8090/guias/informacion/1
    @GetMapping("/informacion/{id}")
    @ResponseBody
    public ResponseEntity<Guide> getGuia(Model model, @PathVariable("id") Long id) {
        Guide guia = guiaService.findById(id);

        return new ResponseEntity<>(guia, HttpStatus.OK);
    }

    //Obtener puntaje
    //localhost:8090/guias/informacion/puntaje/1
    @GetMapping("/informacion/puntaje/{id}")
    @ResponseBody
    public ResponseEntity<Double> getScore(Model model, @PathVariable("id") Long id) {
        Double puntaje = guiaService.getRating(id);

        return new ResponseEntity<>(puntaje, HttpStatus.OK);
    }

    //Obtener reseñas
    //localhost:8090/guias/informacion/reseñas/1
    @GetMapping("/informacion/reseñas/{id}")
    @ResponseBody
    public ResponseEntity<List<String>> getReviews(Model model, @PathVariable("id") Long id) {
        List<String> reseñas = guiaService.getReviews(id);

        return new ResponseEntity<>(reseñas, HttpStatus.OK);
    }

    //Eliminar
    //localhost:8090/guias/delete/1
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteDestiny(@PathVariable("id") Long id) {
        guiaService.delete(id);
        return new ResponseEntity<String>("Guia con id " + id + " eliminado", HttpStatus.OK);
    }
}
