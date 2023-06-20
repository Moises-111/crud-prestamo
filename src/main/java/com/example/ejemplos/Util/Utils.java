package com.example.ejemplos.Util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import static java.time.temporal.ChronoUnit.DAYS;
public class Utils {

    public static int getDiasDiferencia(String fechaActual,String fecha){
        int numeroDias  = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //convert String to LocalDate
        LocalDate fechaA = LocalDate.parse(getFechaFormateada(fechaActual), formatter);
        LocalDate fechaB = LocalDate.parse(getFechaFormateada(fecha), formatter);

         numeroDias = (int) DAYS.between(fechaA,fechaB);

        return Math.abs(numeroDias);
    }

    public static String getFechaFormateada(String fecha){
        String dia="",mes="",año="";
        fecha = fecha.replace("-","/");
        int i= fecha.indexOf("/");
        dia = fecha.substring(0,fecha.indexOf("/"));
        mes = fecha.substring(fecha.indexOf("/")+1,fecha.lastIndexOf("/"));
        mes = getMes(mes);
        año = fecha.substring(fecha.lastIndexOf("/")+1);
        return  dia+"/"+mes+"/"+año;
    }

    private  static String getMes(String abr){
        HashMap<String,String> meses =  new HashMap<>();
        meses.put("ene","01");
        meses.put("feb","02");
        meses.put("mar","03");
        meses.put("abr","04");
        meses.put("may","05");
        meses.put("jun","06");
        meses.put("jul","07");
        meses.put("ago","08");
        meses.put("sep","09");
        meses.put("oct","10");
        meses.put("nov","11");
        meses.put("dic","12");
        return  meses.get(abr);
    }

}
