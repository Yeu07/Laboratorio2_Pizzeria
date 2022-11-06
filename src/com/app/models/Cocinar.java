package com.app.models;

import java.util.LinkedList;

import com.app.alimentos.Alimento;

public interface Cocinar {
	
	public void cocinar(LinkedList<Alimento> pedido,int horaActual);
	
}
