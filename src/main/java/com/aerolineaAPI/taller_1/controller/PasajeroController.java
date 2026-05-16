package com.aerolineaAPI.taller_1.controller;

import com.aerolineaAPI.taller_1.model.Pasajero;
import com.aerolineaAPI.taller_1.service.PasajeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    @Autowired
    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService) {
        this.pasajeroService = pasajeroService;
    }

    @GetMapping
    public ResponseEntity<List<Pasajero>> listarPasajeros() {
        List<Pasajero> pasajeros = pasajeroService.findAll();
        return new ResponseEntity<>(pasajeros, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Pasajero> crearPasajeros(@RequestBody Pasajero pasajero) {
        Pasajero guardado = pasajeroService.save(pasajero);
        return new ResponseEntity<>(guardado, HttpStatus.CREATED);
    }
}
