package com.example.lab5_20193733.Entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table(name = "lugares")
@Getter
@Setter
public class Lugares {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLugares", nullable = false)
    private int idLugares;

    @Column (name = "nombre_lugar")
    private String nombreLugar;

    @Column(name = "descrip_lugar")
    private String descripLugar;

    @Column(name = "fecha_lugar")
    private Timestamp fechaLugar;

}
