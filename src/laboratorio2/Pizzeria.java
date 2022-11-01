/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

import java.util.Date;

/**
 *
 * @author Estudiar
 */
public class Pizzeria {
    private String nombre,ubicacion;
    private int telefono, mesaActual, actualComensales;
    private static final int mesa2=8, mesa4=16, maxComensales=80;
    private boolean abierto;
    private Cajero cajero;
    private Mesero mesero;
    
    public void contratarCajero(String nombre, String nacionalidad, String ubicacionVivienda,int DNI, Date fechaNacimiento){
        cajero=new Cajero(nombre,nacionalidad,ubicacionVivienda,DNI,fechaNacimiento);
    }
    
    
}
