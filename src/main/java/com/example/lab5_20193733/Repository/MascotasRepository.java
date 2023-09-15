package com.example.lab5_20193733.Repository;

import com.example.lab5_20193733.Entity.Mascotas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotasRepository extends JpaRepository<Mascotas, Integer> {

}
