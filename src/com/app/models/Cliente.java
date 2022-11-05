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
    
    public LinkedList<Alimento> pedirComida(Menu menu){
    	LinkedList<Alimento> pedido= new LinkedList<Alimento>();
    	Random random= new Random();
    	int tipoComida=random.nextInt(3);
    	
    	// Pediran Comida, cafe o bebida y postre
    	
    	switch(tipoComida) {
    	case 0:
    		int posPizza=random.nextInt(menu.getPizzas().length);
    		pedido.add(menu.buscaPizza(posPizza));
    		break;
    	case 1:
    		int posHamburugesa=random.nextInt(menu.getHamburguesas().length);
    		pedido.add(menu.buscaHamburguesa(posHamburugesa));
    		break;
    	case 2:
    		int posPasta=random.nextInt(menu.getPastas().length);
    		pedido.add(menu.buscaPasta(posPasta));
    		break;
    	}
    	
    	
    	int tipoBebida=random.nextInt(2);
    	
    	switch(tipoBebida) {
    	case 0:
    		int posCafe=random.nextInt(menu.getCafes().length);
    		pedido.add(menu.buscaCafe(posCafe));
    		break;
    	case 1:
    		int posBebida=random.nextInt(menu.getBebidas().length);
    		pedido.add(menu.buscaBebida(posBebida));
    		break;
    	}
    	
    	int posPostre=random.nextInt(menu.getPostres().length);
    	pedido.add(menu.buscaPostre(posPostre));
    	
    	return pedido;
    	
    }
}
