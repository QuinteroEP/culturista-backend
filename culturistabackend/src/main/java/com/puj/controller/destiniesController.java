package com.puj.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.puj.entity.Destiny;
import com.puj.entity.users.Organizer;
import com.puj.service.destinyService;
import com.puj.service.organizerService;

@RestController
@RequestMapping("/destino")
@CrossOrigin(origins = "http://localhost:4200")
public class destiniesController {
    @Autowired
    destinyService destinyService;

    @Autowired
    organizerService organizerService;

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

    //http://localhost:8090/destino/resultados/?tipo=Deportivo&tipo=Religioso&ubicacion=Bogot%C3%A1&inicio=2025-01-05&fin=2025-01-10&precio=10000&capacidad=2
    @GetMapping("/resultados/")
    @ResponseBody
    public ResponseEntity<List<Destiny>> getDestinyResults(
            Model model,
            @RequestParam(name = "tipo") List<String> tipo,
            @RequestParam(name = "ubicacion") String ubicacion,
            @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate inicio,
            @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fin,
            @RequestParam(name = "precio") long precio,
            @RequestParam(name = "capacidad") int capacidad) {

        List<Destiny> lista = destinyService.filterList(tipo, ubicacion, inicio, fin, precio, capacidad);

        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    //Agregar
    //localhost:8090/destino/add/{id}
    @PostMapping("/add/{id}")
    @ResponseBody
    public ResponseEntity<Destiny> addDestiny(@RequestBody Destiny destino , @PathVariable("id") Long id) {
        Organizer org = organizerService.findById(id);
        
        destino.setOrganizer(org);
        destinyService.add(destino);
        return new ResponseEntity<>(destino, HttpStatus.CREATED);
    }

    //Actualizar
    //localhost:8090/destino/update/1
    @PostMapping("/update/{id}")
    @ResponseBody
    public ResponseEntity<Destiny> updateDestiny(@RequestBody Destiny destino , @PathVariable("id") Long id) {
        Destiny oldInfo = destinyService.findById(id);

        if (oldInfo == null) {
            return new ResponseEntity<>(destino, HttpStatus.NOT_FOUND);
        }

        oldInfo.setNombre(destino.getNombre());
        oldInfo.setDescripcion(destino.getDescripcion());
        oldInfo.setCapacidad(destino.getCapacidad());
        oldInfo.setFecha(destino.getFecha());
        oldInfo.setPrecio(destino.getPrecio());
        oldInfo.setUbicacion(destino.getUbicacion());
        oldInfo.setTipo(destino.getTipo());

        destinyService.update(oldInfo);
        return new ResponseEntity<>(oldInfo, HttpStatus.OK);
    }

    //Eliminar
    //localhost:8090/destino/delete/1
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteDestiny(@PathVariable("id") Long id) {
        destinyService.delete(id);
        return new ResponseEntity<String>("Destino con id " + id + " eliminado", HttpStatus.OK);
    }
}
