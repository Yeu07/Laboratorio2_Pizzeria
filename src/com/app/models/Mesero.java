/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.Date;
import java.util.LinkedList;


/**
 *
 * @author Estudiar
 */
public class Mesero extends Empleado{
	
	public Mesero(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
	
	public void recibirCliente(LinkedList<Cliente> clientes) {
		
	}
	
	/*public LinkedList<Alimento> recibirPedido(LinkedList<Alimento> pedido) {
		
	}*/
}
