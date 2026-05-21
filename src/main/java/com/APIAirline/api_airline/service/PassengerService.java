package com.APIAirline.api_airline.service;

import com.APIAirline.api_airline.model.Passenger;
import com.APIAirline.api_airline.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerService {

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<Passenger> findAll(){

        return passengerRepository.findAll();
    }

    public Passenger save(Passenger passenger){

        return passengerRepository.save(passenger);
    }

    public void deletePassenger(Long id){
        passengerRepository.deleteById(id);
    }

    public Optional<Passenger> updatePassengerById(Long id){
        return passengerRepository.findById(id);
    }


    public Passenger updatePassanger(Long id, Passenger passenger){
        Passenger passenger1 = passengerRepository.findById(id).orElse(null);
        passenger1.setFirstName(passenger.getFirstName());
        passenger1.setLastName(passenger.getLastName());
        passenger1.setId_number(passenger.getId_number());
        passenger1.setEmail(passenger.getEmail());
        return passengerRepository.save(passenger1);
    }




}
