package com.example.ejemplos.controllers;

import com.example.ejemplos.dto.PrestamosResponseDTO;
import com.example.ejemplos.services.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;

@RestController
public class PrestamosController {
    @Autowired
    private PrestamosService clienteService;

    @GetMapping (value="/monto/{fecha_actual}/{cliente}/{tasa_interes}/{dias_anos_comercial}")
    public List<PrestamosResponseDTO> calcularMontoAPagar(@PathVariable("fecha_actual") String fecha_actual, @PathVariable("cliente") String cliente,
                                                          @PathVariable("tasa_interes") BigDecimal tasa_interes, @PathVariable("dias_anos_comercial") short dias_anos_comercial) throws ParseException {
        return  clienteService.calcularMontoAPagar(fecha_actual,cliente,tasa_interes,dias_anos_comercial);
    }

}
