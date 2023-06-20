package com.example.ejemplos.services.impl;

import static  com.example.ejemplos.Util.Utils.*;
import com.example.ejemplos.dto.ClienteResponseDTO;
import com.example.ejemplos.entities.Cliente;
import com.example.ejemplos.entities.Tasas;
import com.example.ejemplos.repositories.ClienteRepository;
import com.example.ejemplos.repositories.TasasRepository;
import com.example.ejemplos.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.TimeUnit;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private TasasRepository tasasRepository;

    @Override
    public List<ClienteResponseDTO> calcularMontoAPagar(String fecha_actual, String cliente, BigDecimal tasa_interes,
                                                        short dias_año_comercial) throws ParseException {
        List<ClienteResponseDTO> response = new ArrayList<>();
        Optional<List<Cliente>> pendientes = clienteRepository.findAllByCliente(cliente);

        if(pendientes.isPresent()){
            for(int i = 0; i<pendientes.get().size();i++){
                ClienteResponseDTO clienteResponseDTO = new ClienteResponseDTO();

                int plazo = getDiasDiferencia(fecha_actual,pendientes.get().get(i).getFecha());
                clienteResponseDTO.setPlazo((short) plazo);
                Tasas taza = tasasRepository.obtenerTasaInteres((short) plazo);

                Double tazaEntreDiasAnosComercial = taza.getTasa_interes().doubleValue()/dias_año_comercial;
                BigDecimal interes = pendientes.get().get(i).getMonto().multiply(BigDecimal.valueOf(plazo));
                interes = interes.multiply(BigDecimal.valueOf(tazaEntreDiasAnosComercial)).setScale(2,RoundingMode.CEILING);

                BigDecimal porcentajeIVA =tasa_interes.divide(BigDecimal.valueOf(100));
                BigDecimal iva= interes.multiply(porcentajeIVA).setScale(2,RoundingMode.CEILING);

                BigDecimal pago = pendientes.get().get(i).getMonto().add(interes).add(iva);

                clienteResponseDTO.setCliente(String.valueOf(pendientes.get().get(i).getCliente()));
                clienteResponseDTO.setMonto(pendientes.get().get(i).getMonto());
                clienteResponseDTO.setInteres(interes);
                clienteResponseDTO.setIva(iva);
                clienteResponseDTO.setPago(pago);
                clienteResponseDTO.setPlazo((short) plazo);
                clienteResponseDTO.setTasa_interes(taza.getTasa_interes());

                response.add(clienteResponseDTO);

            }
        }
        return response;

    }
}