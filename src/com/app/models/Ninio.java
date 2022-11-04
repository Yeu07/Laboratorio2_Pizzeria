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
	    		int posBebida=-1;
	    		do {
	    			posBebida=random.nextInt(menu.getBebidas().length);
	    		}while(posBebida==1 || posBebida==4);
	    		pedido.add(menu.buscaBebida(posBebida));
	    	}
	    	
	    	int posPostre=random.nextInt(menu.getPostres().length);
	    	pedido.add(menu.buscaPostre(posPostre));
	    	
	    	return pedido;
	    	
	    	
	    
	    }
}
