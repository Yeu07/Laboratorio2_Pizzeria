/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.Date;

import com.app.pizzeria.Caja;



/**
 *
 * @author Estudiar
 */
public class Cajero extends Empleado {
    
	public Cajero(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
    
	public void cobrar(Caja caja, float dinero) {
		caja.setDineroCaja(dinero);
	}
	
}
