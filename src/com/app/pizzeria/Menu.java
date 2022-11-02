/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.pizzeria;

import com.app.alimentos.Alimento;
import com.app.alimentos.Batido;
import com.app.alimentos.BatidoDeHelado;
import com.app.alimentos.Cafe;
import com.app.alimentos.CafeConLeche;
import com.app.alimentos.CafeCortado;
import com.app.alimentos.Cerveza;
import com.app.alimentos.Gaseosa;
import com.app.alimentos.Hamburguesa;
import com.app.alimentos.Helado;
import com.app.alimentos.Jugo;
import com.app.alimentos.Nioquis;
import com.app.alimentos.PizzaBacon;
import com.app.alimentos.PizzaCarnePollo;
import com.app.alimentos.PizzaChampinion;
import com.app.alimentos.PizzaChorizo;
import com.app.alimentos.PizzaConPalmitos;
import com.app.alimentos.PizzaJamonMorrones;
import com.app.alimentos.PizzaMuzzarella;
import com.app.alimentos.Ravioles;
import com.app.alimentos.Sorrentinos;
import com.app.alimentos.Spaghetti;
import com.app.alimentos.Submarino;
import com.app.alimentos.Torta;
import com.app.alimentos.Vino;

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

    public void agregarPizza(Alimento pizza) {
    	Alimento[] nuevalista=new Alimento[(this.pizzas.length)+1];
    	for (int i=0;i<this.pizzas.length;i++) {
    		nuevalista[i]=this.pizzas[i];
    	}
    	nuevalista[nuevalista.length]=pizza;
    	this.pizzas=nuevalista;
    }
    
    public void agregarCafe(Alimento cafe) {
    	Alimento[] nuevalista2=new Alimento[(this.cafes.length)+1];
    	for (int i=0;i<this.cafes.length;i++) {
    		nuevalista2[i]=this.cafes[i];
    	}
    	nuevalista2[nuevalista2.length]=cafe;
    	this.cafes=nuevalista2;
    }
    
    public void agregarPasta(Alimento pasta) {
    	Alimento[] nuevalista3=new Alimento[(this.pastas.length)+1];
    	for (int i=0;i<this.pastas.length;i++) {
    		nuevalista3[i]=this.pastas[i];
    	}
    	nuevalista3[nuevalista3.length]=pasta;
    	this.pastas=nuevalista3;
    }
    
    public void agregarPostre(Alimento postre) {
    	Alimento[] nuevalista4=new Alimento[(this.postres.length)+1];
    	for (int i=0;i<this.postres.length;i++) {
    		nuevalista4[i]=this.postres[i];
    	}
    	nuevalista4[nuevalista4.length]=postre;
    	this.postres=nuevalista4;
    }
    
    public void agregarHamburguesa(Alimento hamburguesa) {
    	Alimento[] nuevalista5=new Alimento[(this.hamburguesas.length)+1];
    	for (int i=0;i<this.hamburguesas.length;i++) {
    		nuevalista5[i]=this.hamburguesas[i];
    	}
    	nuevalista5[nuevalista5.length]=hamburguesa;
    	this.hamburguesas=nuevalista5;
    }
    
    public void agregarBebida(Alimento bebida) {
    	Alimento[] nuevalista6=new Alimento[(this.bebidas.length)+1];
    	for (int i=0;i<this.bebidas.length;i++) {
    		nuevalista6[i]=this.bebidas[i];
    	}
    	nuevalista6[nuevalista6.length]=bebida;
    	this.bebidas=nuevalista6;
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
