/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.app.exe;

import java.util.Date;
import java.util.LinkedList;

import com.app.alimentos.Alimento;
import com.app.models.*;
import com.app.pizzeria.Menu;
import com.app.pizzeria.Mesa;
import com.app.pizzeria.Pizzeria;

import java.util.Random;


/**
 *
 * @author Estudiar
 */
public class Laboratorio2 {
	
	public static void main(String[] args) {
		//Iniciamos Pizzeria
    	Pizzeria pizzeria=new Pizzeria();
    	//Abrimos a las 10 de la mañaña
    	pizzeria.setHoraActual(360);
    	//Contratar Cocinero
    	pizzeria.contratarEmpleado(new Cocinero("Jorge","Italiano",2000f,44905308,new Date(122/02/02)));
    	pizzeria.contratarEmpleado(new Cocinero("Pepito","Italiano",2000f,44905309,new Date(122/02/02)));
    	pizzeria.contratarEmpleado(new Cocinero("Bruno","Italiano",2000f,44905310,new Date(122/02/02)));
    	// Contratar Mesero
    	pizzeria.contratarEmpleado(new Mesero("Yeu","Italiano",10000f,44905311,new Date(122/02/02)));
        // Contratar AyudanteCocina
    	pizzeria.contratarEmpleado(new AyudanteCocina("Lucia","Italiano",1800f,44905312,new Date(122/02/02)));
    	pizzeria.contratarEmpleado(new AyudanteCocina("Yague","Italiano",1800f,44905313,new Date(122/02/02)));
    	pizzeria.contratarEmpleado(new AyudanteCocina("Juli","Italiano",1800f,44905314,new Date(122/02/02)));
    	//Contratar Cajero
    	pizzeria.contratarEmpleado(new Cajero("Messi","Italiano",1400f,44905315,new Date(122/02/02)));
    	//Random para saber cada cuanto entra cliente y cuantos movimientos vamos a hacer
    	//30 movimientos
    	Random random=new Random();
    	int cant=30;
		LinkedList<Cliente>[] movimientos=generarMovimientos(cant);
		int cantClientes=imprimirTotalClientes(movimientos);
		//Agregar Mesas
		iniciarMesas(pizzeria.getMesaActual2(), Pizzeria.getTotalMesas2());
		iniciarMesas(pizzeria.getMesaActual4(),Pizzeria.getTotalMesas4());
		boolean quedaGente=false;
		//Contar cantidad Demoras
		int[] demoras=new int[3];
		demoras[0]=0;
		demoras[1]=0;
		demoras[2]=0;
		System.out.println("Al principio teniamos estos ingredientes");
		imprimirEstadoIngredientes(pizzeria.getCocina().getIngredientes(), pizzeria.getCocina().getCantIngredientes());
		//La Tana Abre pizzeria
		pizzeria.setAbierto(pizzeria.getGerente().abrirPizzeria());
		//int que cuente en que movimiento estamos
		int pos=0;
	
		
		//While donde se ejecuta todo
		while (pizzeria.getHoraActual()<1380 || pos<cant || quedaGente==false) {
			//Vamos a tomar que puedan entrar entre 1 y 3 grupos al mismo tiempo,pero esto es modificable
			//Gneramos random con la cantidad que va a entrar
			if(pizzeria.getHoraActual()<1380) {
				int cantGrupo=random.nextInt(3)+1;
				for(int i=0;i<cantGrupo;i++) {
					//Recibimos grupo Clientes y lo agregamos en lista Espera
					if (pos<cant) {
						pizzeria.getListaEspera().addLast(movimientos[pos]);
						pos+=1;
					}
				}
			}
			if(  (pos>20 && pos<=23)||(pos>40 && pos<=43)  ) {
				pizzeria.getCocina().recargarIngredientes();
				setearDisponible(pizzeria.getMenu());
			}
			//Mesero toma el primer elemento de lista de espera, si entran en la pizzeria, los ubica y remueve esa primer pos
			//Si no, lo deja tal cual
			//Si entran varios grupos debo hacer esto mientras hayan lugares
			boolean flag;
			do {
				flag=false;
				if(pizzeria.getListaEspera().size()>0) {
					flag=pizzeria.getMeseros().getFirst().recibirCliente(pizzeria.getListaEspera().getFirst(), pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual(),demoras);
					if(flag==true) {
						pizzeria.getListaEspera().removeFirst();
					}
				}
				//Sumamos Tiempo preestablecido
	    		pizzeria.sumarHora(5);
			}while( flag==true && pizzeria.getListaEspera().size()>0);
			
    		//Verificamos que ningun Cocinero haya terminado de cocinar
    		restarTiempoCocineros(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(),pizzeria.getHoraActual());
    		//verificamos que ningun grupo haya terminado de comer
    		restarTiempoMesas(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual());
    		LinkedList<Alimento> pedidoTotalMesa;
    		do {
    			//Hacemos que el Mesero verifique si hay pedidos para tomar, va a ir mesa por mesa
    			//Si hay mesas para tomar pedido, seguis buscando hasta que ya no queden
    			//Si no, salimos del while
    			pedidoTotalMesa=pizzeria.getMeseros().getFirst().recibirPedido(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(),pizzeria.getMenu() , pizzeria.getCocina().getCantIngredientes());
    			if(pedidoTotalMesa!=null) {
    				//Agregamos el pedido a la lista de pedidos de la cocina
    				pizzeria.getCocina().getListaPedidos().addLast(pedidoTotalMesa);
        			//Cobrar
    				//Funcion Cobrar
        			pizzeria.getCajeros().getFirst().cobrar(pizzeria.getCaja(), cobrar(pedidoTotalMesa));
    			}
    			pizzeria.sumarHora(5);
    		}while(pedidoTotalMesa!=null);
    		//Cada vez que se conuslte, pasaran 5 minutos
    		pizzeria.sumarHora(5);
    		//Verificamos que ningun Cocinero haya terminado de cocinar
    		restarTiempoCocineros(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(),pizzeria.getHoraActual());
    		//verificamos que ningun grupo haya terminado de comer
    		restarTiempoMesas(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual());
    		// Nos queda ver tema Cocineros y Ayudantes
    		//Consultamos si hay pedido y si lo hay , tratamos de buscar algun cocinero o ayudante libre que lo prepare
    		if(pizzeria.getCocina().getListaPedidos().size()>0) {
    		buscarSiHayCocinero(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(), pizzeria.getCocina().getListaPedidos(), pizzeria.getHoraActual(),demoras);
    		}
    		//Usamos numero random para saber cuando vendran prox clientes
    		pizzeria.sumarHora(random.nextInt(15)+1);
    		//Verificamos que ningun Cocinero haya terminado de cocinar
    		restarTiempoCocineros(pizzeria.getCocineros(), pizzeria.getAyudantesCocina(),pizzeria.getHoraActual());
    		//verificamos que ningun grupo haya terminado de comer
    		restarTiempoMesas(pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getHoraActual());
    		//Si la pizzeria ya cerro, debo verificar que no quede nadie cocinando,comiendo,en espera o pedido en espera
    		if(pizzeria.getHoraActual()>1380) {
    			quedaGente=verificarQueNoQuedeNadie(pizzeria.getListaEspera(), pizzeria.getCocina().getListaPedidos(), pizzeria.getMesaActual2(), pizzeria.getMesaActual4(), pizzeria.getCocineros(), pizzeria.getAyudantesCocina());
    			
    		}
    	}
    	buscarComidaMayorConsumida(pizzeria.getMenu());
    	System.out.println(" ");
    	System.out.println("Las cantidad de demoras en mesas fueron "+ demoras[0]);
    	System.out.println(" ");
    	System.out.println("Las cantidad de demoras en cocina fueron "+ demoras[1]+" Y el promedio de espera fue de " + demoras[2]/demoras[1]+" minutos");
    	System.out.println(" ");
    	System.out.println("El gasto promedio fue "+ pizzeria.getCaja().getDineroCaja()/cantClientes+" Euros");
    	System.out.println(" ");
    	System.out.println("Al final tenemos estos ingredientes, hicimos reestock en el medio");
    	imprimirEstadoIngredientes(pizzeria.getCocina().getIngredientes(), pizzeria.getCocina().getCantIngredientes());
    }
	
    	
    	
    
    private static int imprimirTotalClientes(LinkedList<Cliente>[] movimientos) {
    	int ninios=0,turistas=0,jovenes=0,trabajadores=0;
    	for(LinkedList<Cliente> lista:movimientos) {
    		for(Cliente clientes:lista) {
    			switch(clientes.getClass().getSimpleName()) {
    			case "Ninio":
    				ninios+=1;
    				break;
    			case "Joven":
    				jovenes+=1;
    				break;
    			case "Trabajador":
    				trabajadores+=1;
    				break;
    			case "Turista":
    				turistas+=1;
    				break;
    			}
    		}
    	}
    	System.out.println("La cantidad de gente que entro en este dia fue " + (ninios+jovenes+trabajadores+turistas));
    	System.out.println(" ");
    	System.out.println("La cantidad de Ninios fue "+ ninios);
    	System.out.println(" ");
    	System.out.println("La cantidad de Jovenes fue "+ jovenes);
    	System.out.println(" ");
    	System.out.println("La cantidad de Trabajadores fue "+ trabajadores);
    	System.out.println(" ");
    	System.out.println("La cantidad de Turista fue "+ turistas);
    	return ninios+jovenes+trabajadores+turistas;
    }
    
    
    private static Alimento recorrerBuscandoMayorPedido(Alimento[] listaAlimentos,int max,Alimento mayor) {
    	for(Alimento alimento:listaAlimentos) {
    		if(alimento.getCantpedida()>max) {
    			max=alimento.getCantpedida();
    			mayor=alimento;
    		}
    	}
    	return mayor;
    }
    
    private static void buscarComidaMayorConsumida(Menu menu) {
    	Alimento mayor;
    	mayor=recorrerBuscandoMayorPedido(menu.getBebidas(), 0, null);
    	System.out.println("La bebida mas pedida por los clientes fue: "+mayor.getClass().getSimpleName()+" con un total de "+ mayor.getCantpedida());
    	System.out.println(" ");
    	mayor=recorrerBuscandoMayorPedido(menu.getCafes(), 0, null);
    	System.out.println("El cafe mas pedido por los clientes fue: "+mayor.getClass().getSimpleName()+" con un total de "+ mayor.getCantpedida());
    	System.out.println(" ");
    	mayor=recorrerBuscandoMayorPedido(menu.getPostres(), 0, null);
    	System.out.println("El postre que mas pidieron los clientes fue: "+mayor.getClass().getSimpleName()+" con un total de "+ mayor.getCantpedida());
    	System.out.println(" ");
    	mayor=recorrerBuscandoMayorPedido(menu.getPastas(), 0, null);
    	System.out.println("La pasta mas pedida por los clientes fue: "+mayor.getClass().getSimpleName()+" con un total de "+ mayor.getCantpedida());
    	System.out.println(" ");
    	mayor=recorrerBuscandoMayorPedido(menu.getPizzas(),0, null);
    	System.out.println("La pizza mas pedida por los clientes fue: "+mayor.getClass().getSimpleName()+" con un total de "+ mayor.getCantpedida());
    	System.out.println(" ");
    	mayor=recorrerBuscandoMayorPedido(menu.getHamburguesas(),0, null);
    	System.out.println("Se pidieron un total de "+ mayor.getCantpedida()+" Hamrurguesas");
    	System.out.println(" ");
    	
    
    }
    
    private static boolean verificarQueNoHayaNadieCocinando(LinkedList<Cocinero>listaCocineros,LinkedList<AyudanteCocina>listaAyudantes) {
    	int cant=0;
    	//Cuento cantidad de cocineros Libres
    	for(Cocinero cocinero:listaCocineros) {
    		if(cocinero.isOcupado()==false) {
    			cant+=1;
    		}
    	}
    	//Cuento cantidad de Ayudantes Libres
    	for(AyudanteCocina ayudante:listaAyudantes) {
    		if(ayudante.isOcupado()==false) {
    			cant+=1;
    		}
    	}
    	//Si todos los ayudantes y cocineros estan libres, devuelvo true
    	if(cant==listaAyudantes.size()+listaCocineros.size()) {
    		return true;
    	}
    	return false;
    }
    
    private static boolean verificarQueNoHayaNadieComiendo(LinkedList<Mesa>mesas2,LinkedList<Mesa>mesas4) {
    	int cant=0;
    	//cuento cantidad de mesas de 2 libres
    	for(Mesa mesa:mesas2) {
    		if(mesa.getTiempoComer()<=0 && mesa.isPedidoTomado()==false) {
    			cant+=1;
    		}
    	}
    	//cuento cantidad de mesas de 4 libres
    	for(Mesa mesa:mesas4) {
    		if(mesa.getTiempoComer()<=0 && mesa.isPedidoTomado()==false) {
    			cant+=1;
    		}
    	}
    	//Si todas las mesas de 2 y 4 estan libres, devuelvo true
    	if(cant==mesas2.size()+mesas4.size()) {
    		return true;
    	}
    	return false;
    }
    
    private static boolean verificarQueNoQuedeNadie(LinkedList<LinkedList<Cliente>> listaEspera,LinkedList<LinkedList<Alimento>> pedidosEspera,LinkedList<Mesa>mesas2,LinkedList<Mesa>mesas4,LinkedList<Cocinero>listaCocineros,LinkedList<AyudanteCocina>listaAyudantes) {
    	if(verificarQueNoHayaNadieCocinando(listaCocineros, listaAyudantes) && listaEspera.size()<=0 && pedidosEspera.size()<=0 && verificarQueNoHayaNadieComiendo(mesas2, mesas4) ) {
    		return true;
    	}
    	return false;
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
    
    
    private static void buscarDemoraMinimaCocina(LinkedList<Cocinero>listaCocineros,LinkedList<AyudanteCocina>listaAyudantes,int[]demoras) {
    	int minimo=2147483647;
    	//Recorro lista de cocineros para buscar cual tiene menor tiempo
    	for(Cocinero cocinero:listaCocineros) {
    		if(cocinero.getTiempoOcupado()<minimo) {
    			minimo=cocinero.getTiempoOcupado();
    		}
    	}
    	//Guardo el menor y lo comparo con los ayudantes
    	
    	for(AyudanteCocina ayudante:listaAyudantes) {
    		if(ayudante.getTiempoOcupado()<minimo) {
    			minimo=ayudante.getTiempoOcupado();
    		}
    	}
    	
    	demoras[1]+=1;
    	demoras[2]+=minimo/60;
    }
    
    private static void buscarSiHayCocinero(LinkedList<Cocinero>listaCocineros,LinkedList<AyudanteCocina>listaAyudantes,LinkedList<LinkedList<Alimento>> listaEsperaPedido,int horaActual,int[]demoras) {
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
        			listaEsperaPedido.removeFirst();
        		//Si no hay cocinero libre, trato de buscar un ayudante
        		}else {
        			ayudante=buscarAyudanteCocinaLibre(listaAyudantes);
        			//Si hay alguno libre lo pongo a laburar
            		if(ayudante!=null) {
            			ayudante.cocinar(listaEsperaPedido.getFirst(), horaActual);
            			listaEsperaPedido.removeFirst();
            		}
        		}
        	}
    		if(cocinero==null && ayudante==null) {
    			//Busco entre cocineros y ayudantes cual es el que menor tiempo le queda para terminar comida
    			buscarDemoraMinimaCocina(listaCocineros, listaAyudantes,demoras);
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
    			cocinero.setTiempoOcupado(-1);
    			cocinero.setOcupado(false);
    			
    		}
    	}
    	for(AyudanteCocina ayudante:listaAyudantes) {
    		//Le modifico el tiempo a cada cocinero
    		//Si ya no hay mas tiempo y estaba ocupado, el ayudante termino el pedido
    		if(ayudante.tiempoAgotado(horaActual) && ayudante.isOcupado()==true) {
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
    			mesa.setGenteSentada(null);
    			mesa.setPedidoTomado(false);
    			mesa.setTiempoComer(-1);
    		}
    	}
    	for(Mesa mesa:mesas4) {
    		//Actualizamos la hora
    		//Si se les acabo el tiempo y ya habian pedido, los echamos
    		if(mesa.tiempoAgotado(horaActual) && mesa.isPedidoTomado()==true) {
    			mesa.setGenteSentada(null);
    			mesa.setPedidoTomado(false);
    			mesa.setTiempoComer(-1);
    		}
    	}
    }
    
    private static void iniciarMesas(LinkedList<Mesa> lista,int cant) {
    	//Creo todas las mesas 
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
    	//Crear cant random de clientes, en este caso pueden venir entre 1 y 10 pero se modifica si es necesario
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
    
    private static LinkedList<Cliente>[] generarMovimientos(int cant) {
    	@SuppressWarnings("unchecked")
    	//Crea las listas de clientes que vendran
		LinkedList<Cliente>[] mov = new LinkedList[cant];
    	for (int i=0;i<cant;i++) {
    		mov[i]=generarListas();
    	}
    	return mov;
    }
    
    private static void recorrerLista(Alimento[] lista) {
    	//Recorro toda la lista del menu, seteando que hay ingredientes disponible
    	for(int i=0;i<lista.length;i++) {
    		if(lista[i].getHayIngredientes()==false) {
    			lista[i].setHayIngredientes(true);
    		}
    	}
    }
    
    private static void setearDisponible(Menu menu) {
    	//Paso todas las listas del menu
    	recorrerLista(menu.getBebidas());
    	recorrerLista(menu.getCafes());
    	recorrerLista(menu.getHamburguesas());
    	recorrerLista(menu.getPastas());
    	recorrerLista(menu.getPizzas());
    	recorrerLista(menu.getPostres());
    	
    }
    
    private static void imprimirEstadoIngredientes(String[]ingredientes,float[]cantidades) {
    	for(int i=0;i<ingredientes.length;i++) {
    		System.out.println( ingredientes[i]+ ": " + cantidades[i] );
    	}
    }
    
}

