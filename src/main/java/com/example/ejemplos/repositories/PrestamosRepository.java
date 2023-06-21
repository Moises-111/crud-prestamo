package com.example.ejemplos.repositories;

import com.example.ejemplos.entities.Prestamos;
import com.example.ejemplos.entities.PrestamosPK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamos, PrestamosPK> {
    @Query(value = "SELECT p FROM Prestamos p WHERE p.cliente =?1 AND p.estado = 'Pendiente'")
    Optional<List<Prestamos>> findAllByCliente(String cliente);
}