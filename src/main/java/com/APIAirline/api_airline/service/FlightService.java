package com.APIAirline.api_airline.service;

import com.APIAirline.api_airline.model.Flight;
import com.APIAirline.api_airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {

    @Autowired
    private final FlightRepository flyRepository;

    public FlightService(FlightRepository flyRepository) {
        this.flyRepository = flyRepository;
    }

    public List<Flight> findAll(){

        return flyRepository.findAll();
    }
    public Optional<Flight> findById(Long id){
        return flyRepository.findById(id);
    }

    public Flight save(Flight fly){

        return flyRepository.save(fly);
    }

    public void deleteVuelo(Long id){
        flyRepository.deleteById(id);
    }

    public Flight updateVuelo(Flight fly, Long id){
        Flight flyActualizado = flyRepository.findById(id).orElse(null);
        if(fly == null) return null;
        flyActualizado.setFlyStatus(flyActualizado.getFlyStatus());
        flyActualizado.setFrom(flyActualizado.getFrom());
        flyActualizado.setTo(flyActualizado.getTo());
        flyActualizado.setDateTime(flyActualizado.getDateTime());
        return flyRepository.save(flyActualizado);

    }
}
