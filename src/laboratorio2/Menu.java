/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

import java.util.LinkedList;

/**
 *
 * @author Estudiar
 */
public class Menu {
	
    private Productos[] pizzas= {new PizzaBacon(),new PizzaCarnePollo(),new PizzaChampinion(), new PizzaChorizo(), new PizzaConPalmitos(),new PizzaJamonMorrones(), new PizzaMuzzarella()};
    private Productos[] bebidas;
    private Productos[] postres;
    private Productos[] pastas;
    private Productos hamburugesa;
    
    
    
    public Productos getPizza(int pos) {
    	return pizzas[pos];
    }
    
    public Productos getBebida(int pos) {
    	return bebidas[pos];
    }
    
    public Productos getPostre(int pos) {
    	return postres[pos];
    }
    
    public Productos getPasta(int pos) {
    	return pastas[pos];
    }
    
    public Productos getHamburguesa() {
    	return this.hamburugesa;
    }
    
    public void agregarPizza(Productos pizza) {
    	Productos[] nuevalista=new Productos[(this.pizzas.length)+1];
    	for (int i=0;i<this.pizzas.length;i++) {
    		nuevalista[i]=this.pizzas[i];
    	}
    	nuevalista[nuevalista.length]=this.pizzas[this.pizzas.length];
    	this.pizzas=nuevalista;
    }
 
    
}
