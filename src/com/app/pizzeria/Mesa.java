package com.app.pizzeria;

import java.util.LinkedList;
import com.app.models.*;
public class Mesa {
	
	int tiempoComer=-1;
	LinkedList<Cliente> genteSentada;
	boolean pedidoTomado=false;
	
	
	public LinkedList<Cliente> getGenteSentada() {
		return genteSentada;
	}

	public void setGenteSentada(LinkedList<Cliente> genteSentada) {
		this.genteSentada = genteSentada;
	}

	public boolean isPedidoTomado() {
		return pedidoTomado;
	}

	public void setPedidoTomado(boolean pedidoTomado) {
		this.pedidoTomado = pedidoTomado;
	}

	public int getTiempoComer() {
		return tiempoComer;
	}

	public void setTiempoComer(int tiempoComer) {
		this.tiempoComer = tiempoComer;
	}


	
	
}
