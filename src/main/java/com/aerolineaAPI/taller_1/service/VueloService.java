package com.aerolineaAPI.taller_1.service;

import com.aerolineaAPI.taller_1.model.Vuelo;
import com.aerolineaAPI.taller_1.repository.VueloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {

    @Autowired
    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    public List<Vuelo> findAll(){
        return vueloRepository.findAll();
    }
    public Optional<Vuelo> findById(Long id){
        return vueloRepository.findById(id);
    }

    public Vuelo save(Vuelo vuelo){
        return vueloRepository.save(vuelo);
    }
}
