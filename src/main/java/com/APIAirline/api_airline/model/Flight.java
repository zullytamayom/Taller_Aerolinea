package com.APIAirline.api_airline.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name ="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_flight")
    private Long idFlight;

    @Column(name = "date_time")
    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status", nullable = false)
    private FlightStatus flightStatus;

    @Column(name = "origin", nullable = false)
    private String from;

    @Column(name = "destination", nullable = false)
    private String to;

    public Flight(){

    }
    public Flight(Long idFlight, String from, String to, LocalDateTime dateTime, FlightStatus flyStatus){
        this.idFlight = idFlight;
        this.from = from;
        this.to = to;
        this.dateTime = dateTime;
        this.flightStatus = flyStatus;

    }
    public  Long getIdFlight(){
        return idFlight;
    }
    public void setIdFlight(Long idFlight){
        this.idFlight = idFlight;
    }

    public String getFrom(){
        return from;
    }
    public void setFrom(String from){
        this.from = from;
    }
    public String getTo(){
        return to;
    }

    public void setTo(String to){
        this.to = to;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime){
        this.dateTime = dateTime;
    }

    public FlightStatus getFlyStatus(){
        return flightStatus;
    }

    public void setFlyStatus(FlightStatus flyStatus){
        this.flightStatus = flightStatus;
    }


}
