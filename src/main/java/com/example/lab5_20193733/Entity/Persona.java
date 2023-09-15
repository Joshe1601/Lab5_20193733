package com.example.lab5_20193733.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "persona")
@Getter
@Setter
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPersona", nullable = false)
    private int idPersona;

    @Column (name = "nombre")
    private String nombre;

    @Column(name = "dni")
    private String dni;

    @Column(name = "celular")
    private String celular;

    @Column(name = "tipo_persona")
    private String tipoPersona;

}
