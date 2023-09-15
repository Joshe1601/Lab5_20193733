package com.example.lab5_20193733.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "viajes")
@Getter
@Setter
public class Viajes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idViajes", nullable = false)
    private int idViajes;

    @Column(name = "punto_recojo")
    private String puntoRecojo;

    @Column(name = "cant_personas")
    private String cantPersonas;

    @Column(name = "cant_perros")
    private String cantPerros;

    @ManyToOne
    @JoinColumn(name = "Lugares_idLugares")
    private Lugares lugares;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

}
