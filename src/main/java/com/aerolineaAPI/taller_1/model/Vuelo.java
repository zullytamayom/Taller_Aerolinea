package com.aerolineaAPI.taller_1.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="vuelos")
public class Vuelo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_vuelo")
    private Long idVuelo;
    @Column(nullable = false)
    private String origen;
    @Column(nullable = false)
    private String destino;
    @Column(name ="fecha_hora")
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false , name = "estado_vuelo")
    private EstadoVuelo estadoVuelo;

    public Vuelo(){

    }
    public Vuelo(Long idVuelo,String origen,String destino,LocalDateTime fechaHora,EstadoVuelo estadoVuelo){
        this.idVuelo = idVuelo;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.estadoVuelo = estadoVuelo;

    }
    public  Long getIdVuelo(){
        return idVuelo;
    }
    public void setIdVuelo(Long idVuelo){
        this.idVuelo = idVuelo;
    }

    public String getOrigen(){
        return origen;
    }
    public void setOrigen(String origen){
        this.origen = origen;
    }
    public String getDestino(){
        return destino;
    }

    public void setDestino(String destino){
        this.destino = destino;
    }

    public LocalDateTime getFechaHora(){
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora){
        this.fechaHora = fechaHora;
    }

    public EstadoVuelo getEstadoVuelo(){
        return estadoVuelo;
    }

    public void setEstadoVuelo(EstadoVuelo estadoVuelo){
        this.estadoVuelo = estadoVuelo;
    }


}
