/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.Date;
import java.util.LinkedList;

import com.app.alimentos.Alimento;

/**
 *
 * @author Estudiar
 */
public class AyudanteCocina extends Empleado implements Cocinar{
    private int tiempoOcupado=-1;
    private boolean ocupado=false;
    public AyudanteCocina(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
	super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
    }
    
   
    
    public boolean isOcupado() {
		return ocupado;
	}


	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}


	public int getTiempoOcupado() {
		return tiempoOcupado;
	}

	public void setTiempoOcupado(int tiempoOcupado) {
		this.tiempoOcupado = tiempoOcupado;
	}

	private int contarTiempoPedido(LinkedList<Alimento> pedido) {
		int tiempo=0;
		for(Alimento alimento:pedido) {
			tiempo+=alimento.getTiempoElaboracion();
		}
		return tiempo;
	}
    
	@Override
	public void cocinar(LinkedList<Alimento> pedido, int horaActual) {
		this.tiempoOcupado=contarTiempoPedido(pedido)+horaActual;
		this.ocupado=true;
		
	}
	
	public void restarTiempo(int tiempo) {
		this.tiempoOcupado=tiempo-this.tiempoOcupado;
	}
}
