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
    	
    	switch(tipoComida) {
    	case 0:
    		int posPizza=random.nextInt(menu.getPizzas().length);
    		pedido.add(menu.buscaPizza(posPizza));
    		break;
    	case 1:
    		int posHamburugesa=random.nextInt(menu.getHamburguesas().length);
    		pedido.add(menu.buscaHamburguesa(posHamburugesa));
    	}
    	
    	
    
    }
}
