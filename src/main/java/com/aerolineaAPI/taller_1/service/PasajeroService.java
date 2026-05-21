package com.aerolineaAPI.taller_1.service;

import com.aerolineaAPI.taller_1.model.Pasajero;
import com.aerolineaAPI.taller_1.repository.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    public List<Pasajero> findAll(){
        return pasajeroRepository.findAll();
    }

    public Pasajero save(Pasajero pasajero){
        return pasajeroRepository.save(pasajero);
    }




}
