/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.app.exe;

import java.util.Date;
import java.util.LinkedList;

import com.app.alimentos.Alimento;
import com.app.models.*;
import com.app.pizzeria.Mesa;
import com.app.pizzeria.Pizzeria;

import java.util.Random;


/**
 *
 * @author Estudiar
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
    	//Iniciamos Pizzeria
    	Pizzeria pizzeria=new Pizzeria();
    	//Abrimos a las 10 de la mañaña
    	pizzeria.setHoraActual(480);
    	//Contratar Cocinero
    	pizzeria.contratarEmpleado(new Cocinero("Jorge","Italiano",2000f,44905308,new Date(122/02/02)));
    	pizzeria.contratarEmpleado(new Cocinero("Pepito","Italiano",2000f,44905309,new Date(122/02/02)));
    	// Contratar Mesero
    	pizzeria.contratarEmpleado(new Mesero("Yeu","Italiano",10000f,44905311,new Date(122/02/02)));
        // Contratar AyudanteCocina
    	pizzeria.contratarEmpleado(new AyudanteCocina("Lucia","Italiano",1800f,44905312,new Date(122/02/02)));
    	//Contratar Cajero
    	pizzeria.contratarEmpleado(new Cajero("Messi","Italiano",1400f,44905315,new Date(122/02/02)));
    	//Creamos Lista Random con 30 Movimientos
		LinkedList<Cliente>[] movimientos=generar30Movimientos();
		//Agregar Mesas
		iniciarMesas(pizzeria.getMesaActual2(), Pizzeria.getTotalMesas2());
		iniciarMesas(pizzeria.getMesaActual4(),Pizzeria.getTotalMesas4());
		//Duplicado lista Ingredientes
		float[] duplicadoCantIngredientes=pizzeria.getCocina().getCantIngredientes();
		//Random para saber cada cuanto entra cliente
		Random random=new Random();
		//La Tana Abre pizzeria
		pizzeria.setAbierto(pizzeria.getGerente().abrirPizzeria());
		//int que cuente en que movimiento estamos
		int pos=0;
		
		//While donde se ejecuta todo
		while (pizzeria.getHoraActual()<1380) {
			System.out.println("Grupo que entro "+pos);
			//Recibimos grupo Clientes y lo agregamos en lista Espera
			if (pos<30) {
				pizzeria.getListaEspera().addLast(movimientos[pos]);
				pos+=1;
			}
			//Mesero toma el primer elemento de lista de espera, si entran en la pizzeria, los ubica y remueve esa primer pos
			//Si no, lo deja tal cual
			if(pizzeria.getMeseros().getFirst().recibirCliente(pizzeria.getListaEspera().getFirst(), pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual())==true) {
				pizzeria.getListaEspera().removeFirst();
			}
    		//Sumamos Tiempo preestablecido
    		pizzeria.sumarHora(5);
    		//Verificamos que ningun Cocinero haya terminado de cocinar
    		restarTiempoCocineros(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(),pizzeria.getHoraActual());
    		//verificamos que ningun grupo haya terminado de comer
    		restarTiempoMesas(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual());
    		LinkedList<Alimento> pedidoTotalMesa;
    		do {
    			//Hacemos que el Mesero verifique si hay pedidos para tomar, va a ir mesa por mesa
    			//Si hay mesas para tomar pedido, seguis buscando hasta que ya no queden
    			//Si no, salimos del while
    			pedidoTotalMesa=pizzeria.getMeseros().getFirst().recibirPedido(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(),pizzeria.getMenu() , pizzeria.getCocina().getCantIngredientes(),pizzeria.getHoraActual());
    			if(pedidoTotalMesa!=null) {
    				//Agregamos el pedido a la lista de pedidos de la cocina
    				pizzeria.getCocina().getListaPedidos().addLast(pedidoTotalMesa);
        			//Cobrar
    				//Funcion Cobrar
        			pizzeria.getCajeros().getFirst().cobrar(pizzeria.getCaja(), cobrar(pedidoTotalMesa));
    			}
    			//Por cada mesa, el meserose va a demorar 5 min y el cajero otros 5
    			pizzeria.sumarHora(5);
    		}while(pedidoTotalMesa!=null);
    		// Nos queda ver tema Cocineros y Ayudantes
    		//Consultamos si hay pedido y si lo hay , tratamos de buscar algun cocinero o ayudante libre que lo prepare
    		buscarSiHayCocinero(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(), pizzeria.getCocina().getListaPedidos(), pizzeria.getHoraActual());
    		//Cada vez que se conuslte, pasaran 5 minutos
    		pizzeria.sumarHora(5);
    		//Verificamos que ningun Cocinero haya terminado de cocinar
    		restarTiempoCocineros(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(),pizzeria.getHoraActual());
    		//verificamos que ningun grupo haya terminado de comer
    		restarTiempoMesas(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual());
    		//Usamos numero random para saber cuando vendran prox clientes
    		pizzeria.sumarHora(random.nextInt(15)+1);
    		//Verificamos que ningun Cocinero haya terminado de cocinar
    		restarTiempoCocineros(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(),pizzeria.getHoraActual());
    		//verificamos que ningun grupo haya terminado de comer
    		restarTiempoMesas(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual());
    		
    	}
    	
    	
    	
    	
    }
    
    private static Cocinero buscarCocineroLibre(LinkedList<Cocinero>listaCocineros) {
    	//Recorro lista de cocineros hasta encontrar alguno libre
    	for(Cocinero cocinero:listaCocineros) {
    		if(cocinero.isOcupado()==false) {
    			return cocinero;
    		}
    	}
    	return null;
    }
    
    
    private static AyudanteCocina buscarAyudanteCocinaLibre(LinkedList<AyudanteCocina>listaAyudantes) {
    	//Recorro lista de ayudantes hasta encontrar uno libre
    	for(AyudanteCocina ayudante:listaAyudantes) {
    		if(ayudante.isOcupado()==false) {
    			return ayudante;
    		}
    	}
    	return null;
    }
    
    private static void imprimirPedido(LinkedList<Alimento>listaPedido) {
    	for(Alimento alimento:listaPedido) {
    		System.out.print(alimento.getClass().getSimpleName()+" ");
    	}
    }
    
    private static void buscarSiHayCocinero(LinkedList<Cocinero>listaCocineros,LinkedList<AyudanteCocina>listaAyudantes,LinkedList<LinkedList<Alimento>> listaEsperaPedido,int horaActual) {
    	AyudanteCocina ayudante=null;
    	Cocinero cocinero=null;
    	//Mientras haya pedidos en espera y cocineros o ayudantes libre, los pondremos a trabajar
    	do {
    		if(listaEsperaPedido.size()>0) {
    			//Busco cocinero libre
        		cocinero=buscarCocineroLibre(listaCocineros);
        		if(cocinero!=null) {
        			//Si hay alguno libre, lo pongo a trabajar
        			cocinero.cocinar(listaEsperaPedido.getFirst(), horaActual);
        			System.out.println("El cocinero tomo el siguiente pedido: ");
        			imprimirPedido(listaEsperaPedido.getFirst());
        			listaEsperaPedido.removeFirst();
        		//Si no hay cocinero libre, trato de buscar un ayudante
        		}else {
        			ayudante=buscarAyudanteCocinaLibre(listaAyudantes);
        			//Si hay alguno libre lo pongo a laburar
            		if(ayudante!=null) {
            			ayudante.cocinar(listaEsperaPedido.getFirst(), horaActual);
            			System.out.println("El ayudante tomo el siguiente pedido: ");
            			imprimirPedido(listaEsperaPedido.getFirst());
            			listaEsperaPedido.removeFirst();
            		}
        		}
        	}
    		if(cocinero==null && ayudante==null) {
    			System.out.println("Hay Demoras");
    		}
    	}while((cocinero!=null || ayudante!=null) && listaEsperaPedido.size()>0);
    	
    	
    }
    
    private static float cobrar(LinkedList<Alimento> pedido) {
    	float suma=0;
    	//Recorremos toda la lista y sumamos el total de todo
    	for(Alimento alimento:pedido) {
    		suma+=alimento.getPrecio();
    	}
    	return suma;
    }
    
    private static void restarTiempoCocineros(LinkedList<Cocinero>listaCocineros,LinkedList<AyudanteCocina>listaAyudantes,int horaActual) {
    	
    	for(Cocinero cocinero:listaCocineros) {
    		//Le modifico el tiempo a cada cocinero
    		//Si ya no hay mas tiempo y estaba ocupado, el cocinero termino el pedido
    		if(cocinero.tiempoAgotado(horaActual) && cocinero.isOcupado()==true) {
    			System.out.println("Cocinero termino pedido");
    			cocinero.setTiempoOcupado(-1);
    			cocinero.setOcupado(false);
    			
    		}
    	}
    	for(AyudanteCocina ayudante:listaAyudantes) {
    		//Le modifico el tiempo a cada cocinero
    		//Si ya no hay mas tiempo y estaba ocupado, el ayudante termino el pedido
    		if(ayudante.tiempoAgotado(horaActual) && ayudante.isOcupado()==true) {
    			System.out.println("Ayudante termino pedido");
    			ayudante.setTiempoOcupado(-1);
    			ayudante.setOcupado(false);
    		}
    	}
    }
    
    private static void restarTiempoMesas(LinkedList<Mesa>mesas2, LinkedList<Mesa>mesas4,int horaActual) {
    	for(Mesa mesa:mesas2) {
    		//Actualizamos la hora
    		//Si se les acabo el tiempo y ya habian pedido, los echamos 
    		if(mesa.tiempoAgotado(horaActual) && mesa.isPedidoTomado()==true) {
    			System.out.println("Echamos Gente mesa de 2");
    			mesa.setGenteSentada(null);
    			mesa.setPedidoTomado(false);
    			mesa.setTiempoComer(-1);
    		}
    	}
    	for(Mesa mesa:mesas4) {
    		//Actualizamos la hora
    		//Si se les acabo el tiempo y ya habian pedido, los echamos
    		if(mesa.tiempoAgotado(horaActual) && mesa.isPedidoTomado()==true) {
    			System.out.println("Echamos gente de mesa 4");
    			mesa.setGenteSentada(null);
    			mesa.setPedidoTomado(false);
    			mesa.setTiempoComer(-1);
    		}
    	}
    }
    
    private static void iniciarMesas(LinkedList<Mesa> lista,int cant) {
    	for(int i=0;i<cant;i++) {
    		lista.add(new Mesa());
    	}
    }
    
    private static Cliente tipoRandom() {
    	//Crear Tipos Cliente
    	Random random = new Random();
    	int tipoCliente=random.nextInt(4);
    	switch(tipoCliente) {
    	case 0:
    		return new Ninio();
    	case 1:
    		return new Joven();
    	case 2:
    		return new Trabajador();
    	case 3:
    		return new Turista();
    	}
		return null;
    }
    
    private static LinkedList<Cliente> generarListas(){
    	//Crear cant random de clientes
    	LinkedList<Cliente> lista=new LinkedList<Cliente>();
    	Cliente cliente;
    	Random random=new Random();
    	int cantidad=random.nextInt(15);
    	for(int i=0;i<cantidad+1;i++) {
    		cliente=tipoRandom();
    		lista.add(cliente);
    	}
    	return lista;
    }
    
    private static LinkedList<Cliente>[] generar30Movimientos() {
    	@SuppressWarnings("unchecked")
		LinkedList<Cliente>[] mov = new LinkedList[30];
    	for (int i=0;i<30;i++) {
    		mov[i]=generarListas();
    	}
    	return mov;
    }
    
}

