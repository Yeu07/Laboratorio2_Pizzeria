/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.LinkedList;
import java.util.Random;

import com.app.alimentos.Alimento;
import com.app.pizzeria.Menu;

/**
 *
 * @author Estudiar
 */
public class Cliente {
    protected String nombre;
    
    public Cliente() {}
    
    public Cliente(String nombre) {
    	this.nombre=nombre;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }
    
    
    protected void generarAlimentoRandom(Alimento[] listaABuscar,LinkedList<Alimento> pedido) {
    	Random random =new Random();
    	int pos;
    	do {
    		pos=random.nextInt(listaABuscar.length);
    	}while (listaABuscar[pos].getHayIngredientes()==false);
    	pedido.add(listaABuscar[pos]);
    	
    	
    }
    
    public LinkedList<Alimento> pedirComida(Menu menu){
    	LinkedList<Alimento> pedido= new LinkedList<Alimento>();
    	Random random= new Random();
    	int tipoComida=random.nextInt(3);
    	
    	// Pediran Comida, cafe o bebida y postre
    	
    	switch(tipoComida) {
    	case 0:
    		generarAlimentoRandom(menu.getPizzas(), pedido);
    		break;
    	case 1:
    		generarAlimentoRandom(menu.getHamburguesas(), pedido);
    		break;
    	case 2:
    		generarAlimentoRandom(menu.getPastas(), pedido);
    		break;
    	}
    	
    	
    	int tipoBebida=random.nextInt(2);
    	
    	switch(tipoBebida) {
    	case 0:
    		generarAlimentoRandom(menu.getCafes(), pedido);
    		break;
    	case 1:
    		generarAlimentoRandom(menu.getBebidas(), pedido);
    		break;
    	}
    	
    	generarAlimentoRandom(menu.getPostres(), pedido);
    	
    	return pedido;
    	
    }
}
