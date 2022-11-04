/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.Date;
import java.util.LinkedList;
import com.app.pizzeria.Mesa;

/**
 *
 * @author Estudiar
 */
public class Mesero extends Empleado{
	
	public Mesero(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
	
	private int contarMesas(LinkedList<Mesa> listaMesas) {
		int suma=0;
		for(Mesa mesas:listaMesas) {
			if (mesas.getTiempoComer()==-1) {
				suma+=1;
			}
		}
		return suma;
	}
	
	private Mesa buscarMesaVacia(LinkedList<Mesa> listaMesas) {
		Mesa mesa=null;
		for (Mesa mesas:listaMesas) {
			if(mesas.getTiempoComer()==-1) {
				mesa=mesas;
			}
		}
		return mesa;
	}
	
	private void sentarGente(LinkedList<Cliente> clientes,Mesa mesa,int tamanioMesa) {
		LinkedList<Cliente> genteSentada=new LinkedList<Cliente>();
		//segun el tamanio que entre en la mesa, agrego esos clientes
		for (int i=0;i<tamanioMesa-1;i++) {
			genteSentada.add(clientes.getFirst());
			clientes.removeFirst();
		}
		mesa.setGenteSentada(genteSentada);
	}
	
	
	private void acomodarClientes(int cantidadGrupo,LinkedList<Mesa> mesas2,LinkedList<Mesa> mesas4,LinkedList<Cliente> listaClientes) {
		while (cantidadGrupo>0) {
			//Si hay mas de 2, debo buscar si hay una mesa para 4 vacia
			if (cantidadGrupo>2) {
				//Busco si hay mesa de a 4, si hay los asigno
				Mesa mesaVacia4=buscarMesaVacia(mesas4);
				if(mesaVacia4!=null) {
					mesaVacia4.setTiempoComer(60);
					cantidadGrupo-=4;
					sentarGente(listaClientes, mesaVacia4, 4);
				}else {
					//	Como ya verifique que el grupo entrara y no hay mesas de 4 , debo ubicarlos en mesa de 2 
					Mesa mesaVacia2=buscarMesaVacia(mesas2);
					mesaVacia2.setTiempoComer(60);
					cantidadGrupo-=2;
					sentarGente(listaClientes, mesaVacia2, 2);
				}
			}else {
				//Si son 2 o - primero busco si hay mesa de 2 disponible, si hay los ubico 
				Mesa mesaVacia2=buscarMesaVacia(mesas2);
				if(mesaVacia2!=null) {
					mesaVacia2.setTiempoComer(60);
					cantidadGrupo-=2;
					sentarGente(listaClientes, mesaVacia2, 2);
				}else {
					//Si no hay mesa de 2, debo ubicarlos en mesa de 4
					Mesa mesaVacia4=buscarMesaVacia(mesas4);
					mesaVacia4.setTiempoComer(60);
					cantidadGrupo-=4;
					sentarGente(listaClientes, mesaVacia4, 4);
				}
				
			}
		}
	}
	
	public void recibirCliente(LinkedList<Cliente> clientes, LinkedList<Mesa> actual2, LinkedList<Mesa> actual4) {
		int cantidadGrupo=clientes.size();
		int cantLibre2=contarMesas(actual2);
		int cantlibre4=contarMesas(actual4);
		
		// Verifico que haya lugar suficiente para todo el grupo ( asi no acomodo sin sentido)
		
		if (cantidadGrupo<=(cantlibre4*4)+(cantLibre2*2)) {
			//Hay lugar para todos, ahora debo acomodarlos lo mas eficiente posible
				acomodarClientes(cantidadGrupo, actual2, actual4,clientes);
			}else {
				System.out.println("Lo siento, no tenemos mesas disponibles");
			}
		
	}
	
}
