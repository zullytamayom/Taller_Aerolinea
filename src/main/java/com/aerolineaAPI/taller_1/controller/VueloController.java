package com.aerolineaAPI.taller_1.controller;

import com.aerolineaAPI.taller_1.model.Vuelo;
import com.aerolineaAPI.taller_1.service.VueloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    @Autowired
    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    @GetMapping
    public ResponseEntity<List<Vuelo>> listarVuelos(){
        List<Vuelo> vuelo = vueloService.findAll();
        return new ResponseEntity<>(vuelo, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Vuelo>> obtenerUsuario(@PathVariable Long id) {
        Optional<Vuelo> vuelo = vueloService.findById(id);
        return ResponseEntity.ok(vuelo);
    }


    @PostMapping
    public ResponseEntity<Vuelo> crearVuelo(@RequestBody Vuelo vuelo){
        Vuelo vuelo1 = vueloService.save(vuelo);
        return new ResponseEntity<>(vuelo,HttpStatus.CREATED);

    }
}
