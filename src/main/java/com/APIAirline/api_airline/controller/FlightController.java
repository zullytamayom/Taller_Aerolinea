package com.APIAirline.api_airline.controller;

import com.APIAirline.api_airline.model.Flight;
import com.APIAirline.api_airline.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class FlightController {

    @Autowired
    private final FlightService flyService;

    public FlightController(FlightService flyService) {
        this.flyService = flyService;
    }

    @GetMapping
    public ResponseEntity<List<Flight>> listarVuelos(){
        List<Flight> fly = flyService.findAll();
        return new ResponseEntity<>(fly, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Flight>> obtenerUsuario(@PathVariable Long id) {
        Optional<Flight> vuelo = flyService.findById(id);
        return new ResponseEntity<>(vuelo,HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Flight> crearVuelo(@RequestBody Flight fly){
        Flight fly1 = flyService.save(fly);
        return new ResponseEntity<>(fly,HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable Long id){
        flyService.deleteVuelo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Flight> actualizarVuelo(@PathVariable Long id, @RequestBody Flight flyDetalles) {
        return flyService.findById(id)
                .map(flyExistente -> {
                    flyExistente.setFrom(flyDetalles.getFrom());
                    flyExistente.setTo(flyDetalles.getTo());
                    flyExistente.setDateTime(flyExistente.getDateTime());
                    Flight flyActualizado = flyService.save(flyExistente);
                    return new ResponseEntity<>(flyActualizado, HttpStatus.OK);
                })
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

}
