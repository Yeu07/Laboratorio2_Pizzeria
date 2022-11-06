/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.pizzeria;

import com.app.alimentos.*;
import java.util.LinkedList;
/**
 *
 * @author Estudiar
 */
public class Cocina {
	
    private LinkedList<LinkedList<Alimento>> listaPedidos=new LinkedList<LinkedList<Alimento>>();
    private String[] ingredientes={"Queso","Salsa","Palmito","Bacón","Jamón","Jamón cocido","Jamón serrano","Carne de pollo","Chorizo","Atún","Tomate","Cebolla","Champiñón","Aceitunas verdes","Aceitunas negras","Pimiento morrón","Pimiento verde","Cerveza","Vino","Agua mineral","Gaseosa","Jugos","Chocolate","Batidos de helado","Cafe","Leche","Azucar","Helado","Torta","Ravioles","Ñoquis","Sorrentinos","Spaghetti","Frutas","Cheddar","Hamburguesa"};
    private float[] cantIngredientes={12800.0f/*1-queso*/,64.0f/*2-salsa*/,40.0f/*3-palmito*/,20.0f/*4-bacon*/,40.0f/*5-jamon*/,50.0f/*6-jamon cocido*/,20.0f/*7-jamon serrano*/,20.0f/*8-carne de póllo*/,20.0f/*9-chorizo*/,20.0f/*10-atun*/,20.0f/*11-tomate*/,20.0f/*12-cebolla*/,30.0f/*13-champiñon*/,480.0f/*14-aceitunas verdes*/,180.0f/*15-aceitunas negras*/,40.0f/*16-pimiento morron*/,40.0f/*17-pimiento verde*/,64.0f/*18-cerveza*/,64.0f/*19-vino*/,64.0f/*20-agua*/,64.0f/*21-gaseosa*/,64.0f/*22-jugos*/,20f/*23-Chocolate*/,64.0f/*24-batiso helados*/,720.0f/*25-cafe*/,16.0f/*26-leche*/,200.0f/*27-azucar*/,48.0f/*28-helado*/,40.0f/*29-torta*/,2000f/*30-ravioles*/,2000f/*31-nioquis*/,2000f/*32-sorrentinos*/,2000f/*33-spaghetti*/,40f/*34-frutas*/,40f/*35-Cheddar*/,40f/*36-hamburguesa*/};
    
    public String[] getIngredientes() {
		return this.ingredientes;
	}
	public float[] getCantIngredientes() {
		return this.cantIngredientes;
	}
	
	public LinkedList<LinkedList<Alimento>> getListaPedidos() {
		return listaPedidos;
	}
	
	public void agregarPedido(LinkedList<Alimento> pedido) {
		this.listaPedidos.addLast(pedido);
	}
	
	public LinkedList<Alimento> agarrarPedido(){
		 LinkedList<Alimento >pedido=this.listaPedidos.getFirst();
		 this.listaPedidos.removeFirst();
		 return pedido;
	}
	
	public void agregarIngrediente(String ingrediente,float cantidad) {
		String[] nuevosIngredientes=new String[this.ingredientes.length+1];
		float[] nuevasCant= new float[this.cantIngredientes.length+1];
		
		for (int i=0;i<this.cantIngredientes.length;i++) {
			nuevosIngredientes[i]=this.ingredientes[i];
			nuevasCant[i]=this.cantIngredientes[i];
		}
		
		nuevasCant[nuevasCant.length]=cantidad;
		nuevosIngredientes[nuevosIngredientes.length]=ingrediente;
		
		this.ingredientes=nuevosIngredientes;
		this.cantIngredientes=nuevasCant;
		
	}
	
	
}
