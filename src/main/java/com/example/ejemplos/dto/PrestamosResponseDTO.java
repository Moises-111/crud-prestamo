package com.example.ejemplos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PrestamosResponseDTO implements Comparable<PrestamosResponseDTO>{
    //	Cliente, Plazo, Tasa_Interés, Monto, Interés, IVA, Pago
    private String cliente;
    private Short plazo;
    private BigDecimal tasa_interes;
    private BigDecimal monto;
    private BigDecimal interes;
    private BigDecimal iva;
    private BigDecimal pago;

    @Override
    public int compareTo(PrestamosResponseDTO o) {
        return this.plazo.compareTo(o.getPlazo());
    }
}