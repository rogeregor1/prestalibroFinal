/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author familiahurtado
 */
public class GeneraFecha {

    public Date parsearFecha(String fec) throws ParseException {
        Date fechaSQL = null;
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.util.Date fecha = f.parse(fec);
            fechaSQL = new Date(fecha.getTime());
            System.out.println(fechaSQL);
        } catch (ParseException pe) {
            System.out.println("error fechaSQL " + pe);
        }
        return fechaSQL;
    }

}
