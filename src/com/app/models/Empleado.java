/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.Date;

/**
 *
 * @author Estudiar
 */
public class Empleado {
	protected String nombre,nacionalidad;
	protected float sueldo;
	protected final int dni;
	protected final Date fechaNacimiento;
	

	public Empleado(String nombre, String nacionalidad, float sueldo, int dni, Date fechaNacimiento) {
		this.nombre=nombre;
		this.sueldo=sueldo;
		this.nacionalidad=nacionalidad;
		this.dni = dni;
		this.fechaNacimiento = fechaNacimiento;
		
	}

	public String getNombre() {
		return nombre;
	}
	
	public float getSueldo() {
		return sueldo;
	}
	
	public String getNacionalidad() {
		return nacionalidad;
	}
	
	public int getDni() {
		return dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	} 
	
 
    
}
