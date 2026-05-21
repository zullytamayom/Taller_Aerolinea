package com.APIAirline.api_airline.controller;

import com.APIAirline.api_airline.model.Passenger;
import com.APIAirline.api_airline.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passengers")
public class PassengerController {

    @Autowired
    private final PassengerService passengerService;

    public PassengerController(PassengerService passengerService) {
        this.passengerService = passengerService;
    }

    @GetMapping
    public ResponseEntity<List<Passenger>> getAllPassengers() {
        List<Passenger> passengers = passengerService.findAll();
        return new ResponseEntity<>(passengers, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Passenger> createPassenger(@RequestBody Passenger passenger) {
        Passenger passengerSave = passengerService.save(passenger);
        return new ResponseEntity<>(passengerSave, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePassenger(@PathVariable Long id){
        passengerService.deletePassenger(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Passenger> updatePassenger(@PathVariable Long id, @RequestBody Passenger passenger) {
        Passenger updatePassenger = passengerService.updatePassanger(id, passenger);
        return new ResponseEntity<>(updatePassenger, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Passenger>> getPassengerById(@PathVariable Long id) {
        Optional<Passenger> passenger = passengerService.updatePassengerById(id);
        return new ResponseEntity<>(passenger,HttpStatus.OK);
    }

}
