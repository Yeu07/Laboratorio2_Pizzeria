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
public class Cajero extends Empleados {
    private Caja caja= new Caja();
    public Cajero(String nombre, String nacionalidad, String ubicacionVivienda,int DNI, Date fechaNacimiento){
        super(nombre, nacionalidad, ubicacionVivienda,DNI, fechaNacimiento);
    }
    public void cobrar(float pago){
        caja.setDineroCaja(pago);
    }
    
}
