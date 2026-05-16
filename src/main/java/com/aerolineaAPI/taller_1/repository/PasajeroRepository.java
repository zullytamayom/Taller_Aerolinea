package com.aerolineaAPI.taller_1.repository;


import com.aerolineaAPI.taller_1.model.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero ,Long> {
}

