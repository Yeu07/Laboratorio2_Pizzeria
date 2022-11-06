/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.pizzeria;

import java.util.LinkedList;
import com.app.models.*;
/**
 *
 * @author Estudiar
 */
public class Pizzeria {
    private String nombre="La Tana";
    private String ubicacion="Italia";
    private int horaActual=0;
    private LinkedList<Mesa> mesaActual2=new LinkedList<Mesa>();
    private LinkedList<Mesa> mesaActual4= new LinkedList<Mesa>();
    private static int totalMesas2=8;
    private static int totalMesas4=16;
    private boolean abierto=false;
    private Cocina cocina=new Cocina();
    private Caja caja=new Caja();
    private LinkedList<Mesero> meseros= new LinkedList<Mesero>();
    private LinkedList<AyudanteCocina> ayudantesCocina= new LinkedList<AyudanteCocina>();
    private Menu menu = new Menu();
    private LinkedList<Cocinero> cocineros= new LinkedList<Cocinero>();
    private Gerente gerente = new Gerente("La Tana","Italiana",5000f,27271212, null);
    private int cantNinios=0,cantTuristas=0,cantTrabajadores=0,cantJovenes=0;
    private int cantTotalClientes=0;
    private LinkedList<LinkedList<Cliente>> listaEspera= new LinkedList<LinkedList<Cliente>>();
    private LinkedList<Cajero> cajeros = new LinkedList<Cajero>();
    
    public Pizzeria() {}
    
    public void sumarHora(int tiempo) {
    	this.horaActual+=tiempo;
    }
    
	public int getHoraActual() {
		return horaActual;
	}



	public void setHoraActual(int horaActual) {
		this.horaActual = horaActual;
	}



	public LinkedList<Cajero> getCajeros() {
		return cajeros;
	}



	public void setCajeros(LinkedList<Cajero> cajeros) {
		this.cajeros = cajeros;
	}



	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public LinkedList<Mesa> getMesaActual2() {
		return this.mesaActual2;
	}

	public void setMesaActual2(LinkedList<Mesa> mesaActual2) {
		this.mesaActual2 = mesaActual2;
	}

	public LinkedList<Mesa> getMesaActual4() {
		return this.mesaActual4;
	}

	public void setMesaActual4(LinkedList<Mesa> mesaActual4) {
		this.mesaActual4 = mesaActual4;
	}

	public static int getTotalMesas2() {
		return totalMesas2;
	}

	public static void setTotalMesas2(int totalMesas2) {
		Pizzeria.totalMesas2 = totalMesas2;
	}

	public static int getTotalMesas4() {
		return totalMesas4;
	}

	public static void setTotalMesas4(int totalMesas4) {
		Pizzeria.totalMesas4 = totalMesas4;
	}

	public boolean getAbierto() {
		return this.abierto;
	}

	public void setAbierto(boolean abierto) {
		this.abierto = abierto;
	}

	public Cocina getCocina() {
		return this.cocina;
	}

	public void setCocina(Cocina cocina) {
		this.cocina = cocina;
	}

	public Caja getCaja() {
		return this.caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public LinkedList<Mesero> getMeseros() {
		return this.meseros;
	}

	public void setMeseros(LinkedList<Mesero> meseros) {
		this.meseros = meseros;
	}

	public LinkedList<AyudanteCocina> getAyudantesCocina() {
		return this.ayudantesCocina;
	}

	public void setAyudantesCocina(LinkedList<AyudanteCocina> ayudantesCocina) {
		this.ayudantesCocina = ayudantesCocina;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public LinkedList<Cocinero> getCocineros() {
		return this.cocineros;
	}

	public void setCocineros(LinkedList<Cocinero> cocineros) {
		this.cocineros = cocineros;
	}

	public Gerente getGerente() {
		return this.gerente;
	}

	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}

	public int getCantNinios() {
		return this.cantNinios;
	}

	public void setCantNinios(int cantNinios) {
		this.cantNinios = cantNinios;
	}

	public int getCantTuristas() {
		return this.cantTuristas;
	}

	public void setCantTuristas(int cantTuristas) {
		this.cantTuristas = cantTuristas;
	}

	public int getCantTrabajadores() {
		return this.cantTrabajadores;
	}

	public void setCantTrabajadores(int cantTrabajadores) {
		this.cantTrabajadores = cantTrabajadores;
	}

	public int getCantJovenes() {
		return this.cantJovenes;
	}

	public void setCantJovenes(int cantJovenes) {
		this.cantJovenes = cantJovenes;
	}

	public int getCantTotalClientes() {
		return this.cantTotalClientes;
	}

	public void setCantTotalClientes(int cantTotalClientes) {
		this.cantTotalClientes = cantTotalClientes;
	}

	public LinkedList<LinkedList<Cliente>> getListaEspera() {
		return this.listaEspera;
	}

	public void setListaEspera(LinkedList<LinkedList<Cliente>> listaEspera) {
		this.listaEspera = listaEspera;
	}
    
    public void contratarEmpleado(Empleado empleado) {
    	switch(empleado.getClass().getSimpleName()) {
    	case "Cocinero":
    		this.cocineros.add((Cocinero) empleado);
    		break;
    	case "AyudanteCocina":
    		this.ayudantesCocina.add((AyudanteCocina) empleado);
    		break;
    	case "Cajero":
    		this.cajeros.add((Cajero) empleado);
    		break;
    	case "Mesero":
    		this.meseros.add((Mesero) empleado);
    		break;
    	}
    }
    
    
    public void despedirEmpleado(Empleado empleado) {
    	this.cocineros.remove(empleado);
    	this.cajeros.remove(empleado);
    	this.meseros.remove(empleado);
    	this.ayudantesCocina.remove(empleado);
    }
    
}
    
    
    
    
    
    
