package com.example.ejemplos.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

@Entity
@Table(name = "Prestamos")
@AllArgsConstructor
@NoArgsConstructor
@Data
@IdClass(PrestamosPK.class)
public class Prestamos {
    @Id
    @Column(name ="num_cliente")
    @NonNull
    private String cliente;

    @Id
    @Column(name ="id")
    @NonNull
    private short id;

    @Column(name ="fecha")
    @NonNull
    private String fecha;

    @Column(name ="monto")
    @NonNull
    private BigDecimal monto;

    @Column(name ="estado")
    @NonNull
    private String estado;
}
