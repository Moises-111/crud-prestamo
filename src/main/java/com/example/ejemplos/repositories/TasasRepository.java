package com.example.ejemplos.repositories;

import com.example.ejemplos.entities.Tasas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TasasRepository extends JpaRepository<Tasas, Short> {

    @Query(value = "SELECT t FROM Tasas t WHERE t.plazo_min<=?1 AND t.plazo_max>=?1")
    Tasas obtenerTasaInteres(short plazo);
}
