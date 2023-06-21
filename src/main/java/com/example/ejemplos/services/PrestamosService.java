package com.example.ejemplos.services;

import com.example.ejemplos.dto.PrestamosResponseDTO;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@Service
public interface PrestamosService {
    List<PrestamosResponseDTO> calcularMontoAPagar(String fecha_actual, String cliente, BigDecimal tasa_interes,
                                                   short dias_año_comercial) throws ParseException;
}