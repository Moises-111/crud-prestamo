package com.example.ejemplos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.BigInteger;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClienteResponseDTO {
    //	Cliente, Plazo, Tasa_Interés, Monto, Interés, IVA, Pago
    private String cliente;
    private Short plazo;
    private BigDecimal tasa_interes;
    private BigDecimal monto;
    private BigDecimal interes;
    private BigDecimal iva;
    private BigDecimal pago;
}