package com.aerolineaAPI.taller_1.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pasajeros")
public class Pasajero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pasajero")
    private Long idPasajero;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String documento;
    @Column(nullable = false)
    private String email;

    public Pasajero(){

    }

    public Pasajero(Long idPasajero,String nombre,String apellido,String documento,String email){
        this.idPasajero = idPasajero;
        this.nombre = nombre;
        this.apellido = apellido;
        this.documento = documento;
        this.email = email;

    }


    public Long getIdPasajero() {
        return idPasajero;
    }

    public void setIdPasajero(Long idPasajero) {
        this.idPasajero = idPasajero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
