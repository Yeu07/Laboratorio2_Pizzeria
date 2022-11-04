/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.pizzeria;

import com.app.alimentos.*;

/**
 *
 * @author Estudiar
 */
public class Menu {
    private Alimento[] pizzas= {new PizzaBacon(),new PizzaCarnePollo(),new PizzaChampinion(), new PizzaChorizo(), new PizzaConPalmitos(),new PizzaJamonMorrones(), new PizzaMuzzarella()};
    private Alimento[] bebidas= {new Gaseosa(),new Vino(),new Jugo(),new Batido(),new Cerveza()};
    private Alimento[] postres= {new Helado(),new BatidoDeHelado(),new Torta()};
    private Alimento[] pastas= {new Ravioles(),new Nioquis(),new Sorrentinos(),new Spaghetti()};
    private Alimento[] hamburguesas= {new Hamburguesa()};
    private Alimento[] cafes= {new Cafe(),new CafeConLeche(),new CafeCortado(),new Submarino()};
    
    
    public Alimento[] getCafes() {
		return cafes;
	}


    public Alimento[] getPizzas() {
		return pizzas;
	}
    
    public Alimento[] getBebidas() {
		return bebidas;
	}
    
    public Alimento[] getPostres() {
		return postres;
	}
    
    public Alimento[] getPastas() {
		return pastas;
	}
    
    public Alimento[] getHamburguesas() {
		return hamburguesas;
	}

    public void setPizzas(Alimento[] pizzas) {
		this.pizzas = pizzas;
	}
	
    public void setBebidas(Alimento[] bebidas) {
		this.bebidas = bebidas;
	}

	
    public void setPostres(Alimento[] postres) {
		this.postres = postres;
	}

	
    public void setPastas(Alimento[] pastas) {
		this.pastas = pastas;
	}

	
    public void setHamburguesas(Alimento[] hamburguesas) {
		this.hamburguesas = hamburguesas;
	}

    private Alimento[] agregarNuevaOpcion(Alimento[] lista, Alimento nuevaOpcion) {
    	Alimento[] nuevaLista=new Alimento[lista.length+1];
    	for (int i=0;i<lista.length;i++) {
    		nuevaLista[i]=lista[i];
    	}
    	nuevaLista[nuevaLista.length]=nuevaOpcion;
    	return nuevaLista;
    }
    
    public void agregarPizza(Alimento pizza) {
    	this.pizzas=agregarNuevaOpcion(this.pizzas,pizza);
    }
    
    public void agregarCafe(Alimento cafe) {
    	this.cafes=agregarNuevaOpcion(this.cafes,cafe);
    }
    
    public void agregarPasta(Alimento pasta) {
    	this.pastas=agregarNuevaOpcion(this.pastas, pasta);
    }
    
    public void agregarPostre(Alimento postre) {
    	this.postres=agregarNuevaOpcion(this.postres, postre);
    }
    
    public void agregarHamburguesa(Alimento hamburguesa) {
    	this.hamburguesas=agregarNuevaOpcion(this.hamburguesas, hamburguesa);
    }
    
    public void agregarBebida(Alimento bebida) {
    	this.bebidas=agregarNuevaOpcion(this.bebidas, bebida);
    }
    
    public Alimento buscaPizza(int pos) {
    	return this.pizzas[pos];
    }
    
    public Alimento buscaBebida(int pos) {
    	return this.bebidas[pos];
    }
    
    public Alimento buscaPostre(int pos) {
    	return this.postres[pos];
    }
    
    public Alimento buscaPasta(int pos) {
    	return this.pastas[pos];
    }
    
    public Alimento buscaHamburguesa(int pos) {
    	return this.hamburguesas[pos];
    }
    
    public Alimento buscaCafe(int pos) {
    	return this.cafes[pos];
    }
 
    
}
