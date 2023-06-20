package com.example.ejemplos.repositories;

import com.example.ejemplos.entities.Cliente;
import com.example.ejemplos.entities.ClientePK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, ClientePK> {
    @Query(value = "SELECT c FROM Cliente c WHERE c.cliente =?1 AND c.estado = 'Pendiente'")
    Optional<List<Cliente>> findAllByCliente(String cliente);
}