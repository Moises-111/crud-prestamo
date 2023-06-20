package com.example.ejemplos.dto;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteDTO {

    private String fecha_actual;
    private String cliente;
    private BigDecimal tasa_interes;
    private Short dias_anos_comercial;
}