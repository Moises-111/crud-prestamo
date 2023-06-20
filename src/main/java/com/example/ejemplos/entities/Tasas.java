package com.example.ejemplos.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "Tasas")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Tasas {

    @Id
    @Column(name ="plazo_min")
    private short plazo_min;
    @Column(name ="plazo_max")
    private short plazo_max;
    @Column(name ="tasa_interes")
    private BigDecimal tasa_interes;
}