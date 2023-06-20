package com.example.ejemplos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(ClientePK.class)
public class Cliente {
    @Id
    @Column(name ="num_cliente")
    private String cliente;

    @Id
    @Column(name ="id")
    private short id;

    @Column(name ="fecha")
    private String fecha;

    @Column(name ="monto")
    private BigDecimal monto;

    @Column(name ="estado")
    private String estado;
}
