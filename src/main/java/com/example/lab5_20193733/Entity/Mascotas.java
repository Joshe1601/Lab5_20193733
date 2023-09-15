package com.example.lab5_20193733.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "mascotas")
@Getter
@Setter
public class Mascotas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMascotas", nullable = false)
    private int idMascotas;

    @Column (name = "nombre_mascota")
    private String nombreMascota;

    @Column(name = "genero")
    private String genero;

    @Column(name = "edad")
    private int edad;

    @Column(name = "fecha_nacimiento")
    private Timestamp fechaNacimiento;

    @Column(name = "Vacunado")
    private String vacunado;

    @Column(name = "Desparasitado")
    private String desparasitado;

    @ManyToOne
    @JoinColumn(name = "Persona_idPersona")
    private Persona persona;

}
