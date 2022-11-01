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
    
	public Cajero(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
    
	public void cobrar(Caja caja, float dinero) {
		System.out.println("El total es "+dinero);
		caja.setDineroCaja(dinero);
	}
	
}
