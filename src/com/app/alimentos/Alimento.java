/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.alimentos;

import java.util.LinkedList;

/**
 *
 * @author Estudiar
 */
public class Alimento {
    protected int tiempoElaboracion=1;
    protected float precio;
    protected LinkedList<Float> ingredientes=new LinkedList<Float>();
    public boolean hayIngredientes=true;
    
    public LinkedList<Float> getIngredientes(){
        return this.ingredientes;
    }

	public int getTiempoElaboracion() {
		return tiempoElaboracion;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setTiempoElaboracion(int tiempoElaboracion) {
		this.tiempoElaboracion = tiempoElaboracion;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setIngredientes(LinkedList<Float> ingredientes) {
		this.ingredientes = ingredientes;
	}

    public boolean hayIngredientes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    

}

