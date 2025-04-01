package com.puj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puj.service.destinyService;

@Controller
@RequestMapping("/destino")
public class destiniesController {
    @Autowired
    destinyService destino;

    @GetMapping("/all")
    @ResponseBody
    public String getAllDestinos(Model model) {
        model.addAttribute("destinos", destino.findAllDestinies());
        return "Todos los destinos";
    }
    
    @GetMapping("/informacion/{id}")
    @ResponseBody
    public String getDestino(Model model, @PathVariable("id") Long id) {
        model.addAttribute("informacion", destino.findById(id));
        return "Información del destino";
    }
    
}
