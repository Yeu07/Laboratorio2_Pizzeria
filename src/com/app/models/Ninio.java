package com.app.models;

import java.util.LinkedList;
import java.util.Random;

import com.app.alimentos.Alimento;
import com.app.pizzeria.Menu;

public class Ninio extends Cliente {
	
	public Ninio() {}	
	public Ninio(String nombre) {
		super(nombre);
	}
	
	
    	
    	
  

	// un Niño no puede pedir bebida alcholica
	@Override
	 public LinkedList<Alimento> pedirComida(Menu menu){
	    	LinkedList<Alimento> pedido= new LinkedList<Alimento>();
	    	Random random= new Random();
	    	int tipoComida=random.nextInt(3);
	    
	    	
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
	    		int posBebida=-1;
	    		do {
	    			posBebida=random.nextInt(menu.getBebidas().length);
	    		}while(posBebida==1 || posBebida==4);
	    		pedido.add(menu.buscaBebida(posBebida));
	    	}
	    	
			generarAlimentoRandom(menu.getPostres(), pedido);
	    	
	    	return pedido;
	    	
	    }
}
