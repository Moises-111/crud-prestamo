package com.example.ejemplos.services.impl;

import static  com.example.ejemplos.Util.Utils.*;
import com.example.ejemplos.dto.PrestamosResponseDTO;
import com.example.ejemplos.entities.Prestamos;
import com.example.ejemplos.entities.Tasas;
import com.example.ejemplos.repositories.PrestamosRepository;
import com.example.ejemplos.repositories.TasasRepository;
import com.example.ejemplos.services.PrestamosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.*;

@Service
public class PrestamosServiceImpl implements PrestamosService {

    @Autowired
    private PrestamosRepository clienteRepository;

    @Autowired
    private TasasRepository tasasRepository;

    @Override
    public List<PrestamosResponseDTO> calcularMontoAPagar(String fecha_actual, String cliente, BigDecimal tasa_interes,
                                                          short dias_año_comercial) throws ParseException {
        List<PrestamosResponseDTO> response = new ArrayList<>();
        Optional<List<Prestamos>> pendientes = clienteRepository.findAllByCliente(cliente);

        if(pendientes.isPresent()){
            for(int i = 0; i<pendientes.get().size();i++){
                PrestamosResponseDTO prestamosResponseDTO = new PrestamosResponseDTO();

                int plazo = getDiasDiferencia(fecha_actual,pendientes.get().get(i).getFecha());
                prestamosResponseDTO.setPlazo((short) plazo);
                Tasas taza = tasasRepository.obtenerTasaInteres((short) plazo);

                Double tazaEntreDiasAnosComercial = taza.getTasa_interes().doubleValue()/dias_año_comercial;
                BigDecimal interes = pendientes.get().get(i).getMonto().multiply(BigDecimal.valueOf(plazo));
                interes = interes.multiply(BigDecimal.valueOf(tazaEntreDiasAnosComercial)).setScale(2,RoundingMode.CEILING);

                BigDecimal porcentajeIVA =tasa_interes.divide(BigDecimal.valueOf(100));
                BigDecimal iva= interes.multiply(porcentajeIVA).setScale(2,RoundingMode.CEILING);

                BigDecimal pago = pendientes.get().get(i).getMonto().add(interes).add(iva);

                prestamosResponseDTO.setCliente(String.valueOf(pendientes.get().get(i).getCliente()));
                prestamosResponseDTO.setMonto(pendientes.get().get(i).getMonto());
                prestamosResponseDTO.setInteres(interes);
                prestamosResponseDTO.setIva(iva);
                prestamosResponseDTO.setPago(pago);
                prestamosResponseDTO.setPlazo((short) plazo);
                prestamosResponseDTO.setTasa_interes(taza.getTasa_interes());

                response.add(prestamosResponseDTO);

            }
            Collections.sort(response,Collections.reverseOrder());
        }
        return response;

    }
}