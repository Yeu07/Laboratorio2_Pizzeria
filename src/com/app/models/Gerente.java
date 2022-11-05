package com.app.models;

import java.util.Date;

public class Gerente extends Empleado {
	
	public Gerente(String nombre, String nacionalidad, float sueldo,int dni,Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
	
	public boolean cerrarPizzeria() {
		return false;
	}
	
	public boolean abrirPizzeria() {
		return true;
	}
	
	public void quejarseCocineros() {
		System.out.println("Esta muy lenta la cocina, mama mia");
	}
	
}
