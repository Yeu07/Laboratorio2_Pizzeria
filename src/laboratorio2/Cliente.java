/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

import java.util.LinkedList;
import java.util.Random;

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
    
    public LinkedList<Productos> pedirComida(Menu menu){
    	LinkedList<Productos> pedido= new LinkedList<Productos>();
    	Random random= new Random();
    	int tipoComida=random.nextInt(3);
    	
    	switch(tipoComida) {
    	case 0:
    		int posPizza=random.nextInt(menu.getPizzas().length);
    		menu.buscaPizza(posPizza);
    	case 1:
    		int posHamburugesa
    	}
    	
    	
    
    }
}
