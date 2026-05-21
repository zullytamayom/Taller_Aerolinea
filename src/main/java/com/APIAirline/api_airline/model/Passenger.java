package com.APIAirline.api_airline.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajeros")
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pasajero")
    private Long idPassanger;
    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false)
    private String id_number;
    @Column(nullable = false)
    private String email;

    public Passenger(){

    }

    public Passenger(Long idPassanger, String firstName, String lastName, String id_number, String email){
        this.idPassanger = idPassanger;
        this.firstName = firstName;
        this.lastName = lastName;
        this.id_number = id_number;
        this.email = email;

    }


    public Long getIdPassanger() {
        return idPassanger;
    }

    public void setIdPassanger(Long idPassanger) {
        this.idPassanger = idPassanger;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
