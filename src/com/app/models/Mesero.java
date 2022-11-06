/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import com.app.alimentos.Alimento;
import com.app.pizzeria.Menu;
import java.util.Date;
import java.util.LinkedList;
import com.app.pizzeria.Mesa;

/**
 *
 * @author Estudiar
 */
public class Mesero extends Empleado{
	
	public Mesero(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
	
	private Mesa buscarMesaSinAtender(LinkedList<Mesa>mesas) {
		for(Mesa mesa:mesas) {
			if(mesa.getTiempoComer()>-1 && mesa.isPedidoTomado()==false ) {
				return mesa;
			}
		}
		return null;
	}
	
        public LinkedList<Alimento> recibirPedido(LinkedList<Mesa> listaMesa2, LinkedList<Mesa> listaMesa4,Menu menu,float[] ingredientes,int hora){
            LinkedList<Alimento> pedidoTerminado=new LinkedList<Alimento>();
            LinkedList<Alimento> pedidoActual=new LinkedList<Alimento>();
            int tiempoTotal=0;
            Mesa mesaAtendida=buscarMesaSinAtender(listaMesa4);
            if(mesaAtendida!=null) {
            	mesaAtendida.setPedidoTomado(true);
            	for(Cliente cliente:mesaAtendida.getGenteSentada()) {
            		pedidoActual=cliente.pedirComida(menu);
            		tiempoTotal+=consultarIngredientes(pedidoActual, ingredientes,hora);
            		for(int j=0;j<pedidoActual.size();j++) {
            			pedidoTerminado.addLast(pedidoActual.get(j));
            		}
            	}
            	mesaAtendida.sumarTiempo(tiempoTotal);
                return pedidoTerminado;
            }
            mesaAtendida=buscarMesaSinAtender(listaMesa2);
            if(mesaAtendida!=null){
                mesaAtendida.setPedidoTomado(true);
                for (Cliente cliente:mesaAtendida.getGenteSentada()) {
                    pedidoActual=cliente.pedirComida (menu);
                    tiempoTotal+=consultarIngredientes(pedidoActual, ingredientes,hora);
                    for (int j = 0; j <pedidoActual.size(); j++) {
                        pedidoTerminado.addLast(pedidoActual.get(j));

                    }
                }
                mesaAtendida.sumarTiempo(tiempoTotal);
                return pedidoTerminado;
            }
            return null;
        }
        
        //Sirve para verificar el pedido de 1 cliente si se puede preparar o no
        private int consultarIngredientes(LinkedList<Alimento> listaPedido, float[] ingredientes,int hora){
            float pos;
            int tiempo=0;
            boolean imprimi=false;
            //realizo un for para ver los pedidos del cliente
            for (Alimento consulta:listaPedido) {
                //Si figura true, entonces se realiza un for para verificar si se encuentra la cantidad
                //necesaria de ingredientes para cada alimento
                for (int i = 0; i < consulta.getIngredientes().size()-1; i++) {
                    if (i%2!=0) {
                        pos=consulta.getIngredientes().get(i-1);
                        if (ingredientes[(int)pos-1] <= consulta.getIngredientes().get(i)){
                            consulta.setHayIngredientes(false);
                            if( imprimi==false) {
                            System.out.println("Nos quedamos sin ingredientes para"+consulta.getClass().getSimpleName()+"El tiempo es "+hora );
                            imprimi=true;
                            }
                            //En caso de que algun alimento necesite un ingrediente que no haya tal cantidad
                            // entonces se marca el alimento como "false" y se retorna falso
                        }
                    }
                }
            }
            for (Alimento consulta:listaPedido) {
            	tiempo+=consulta.getTiempoElaboracion();
                consulta.sumarCantPedida();
                for (int i = 0; i < consulta.getIngredientes().size(); i++) {
                    if (i%2!=0) {
                        pos=consulta.getIngredientes().get(i-1);
                        ingredientes[(int)pos-1]-=consulta.getIngredientes().get(i);
                        //verIngredientes.cantIngredientes[(int)pos-1]-=consulta.getIngredientes().get(i);
                    }
                }
            }
            return tiempo;
        }
                
	private int contarMesas(LinkedList<Mesa> listaMesas) {
		int suma=0;
		for(Mesa mesas:listaMesas) {
			if (mesas.getTiempoComer()<=-1 && mesas.isPedidoTomado()==false) {
				suma+=1;
			}
		}
		return suma;
	}
	
	private Mesa buscarMesaVacia(LinkedList<Mesa> listaMesas) {
		Mesa mesa=null;
		for (Mesa mesas:listaMesas) {
			if(mesas.getTiempoComer()<=-1 && mesas.isPedidoTomado()==false) {
				mesa=mesas;
			}
		}
		return mesa;
	}
	
	private void sentarGente(LinkedList<Cliente> clientes,Mesa mesa,int tamanioMesa) {
		LinkedList<Cliente> genteSentada=new LinkedList<Cliente>();
		//segun el tamanio que entre en la mesa, agrego esos clientes
		for (int i=0;i<tamanioMesa;i++) {
			if(clientes.size()>0) {
			genteSentada.add(clientes.getFirst());
			clientes.removeFirst();
			}
		}
		mesa.setGenteSentada(genteSentada);
	}
	
	
	private void acomodarClientes(int cantidadGrupo,LinkedList<Mesa> mesas2,LinkedList<Mesa> mesas4,LinkedList<Cliente> listaClientes,int horaActual) {
		while (cantidadGrupo>0) {
			//Si hay mas de 2, debo buscar si hay una mesa para 4 vacia
			if (cantidadGrupo>2) {
				//Busco si hay mesa de a 4, si hay los asigno
				Mesa mesaVacia4=buscarMesaVacia(mesas4);
				if(mesaVacia4!=null) {
					mesaVacia4.setTiempoComer(60+horaActual);
					cantidadGrupo-=4;
					sentarGente(listaClientes, mesaVacia4, 4);
				}else {
					//	Como ya verifique que el grupo entrara y no hay mesas de 4 , debo ubicarlos en mesa de 2 
					Mesa mesaVacia2=buscarMesaVacia(mesas2);
					mesaVacia2.setTiempoComer(60+horaActual);
					cantidadGrupo-=2;
					sentarGente(listaClientes, mesaVacia2, 2);
				}
			}else {
				//Si son 2 o - primero busco si hay mesa de 2 disponible, si hay los ubico 
				Mesa mesaVacia2=buscarMesaVacia(mesas2);
				if(mesaVacia2!=null) {
					mesaVacia2.setTiempoComer(60+horaActual);
					cantidadGrupo-=2;
					sentarGente(listaClientes, mesaVacia2, 2);
				}else {
					//Si no hay mesa de 2, debo ubicarlos en mesa de 4
					Mesa mesaVacia4=buscarMesaVacia(mesas4);
					mesaVacia4.setTiempoComer(60+horaActual);
					cantidadGrupo-=4;
					sentarGente(listaClientes, mesaVacia4, 4);
				}
				
			}
		}
	}
	
	public boolean recibirCliente(LinkedList<Cliente> clientes, LinkedList<Mesa> actual2, LinkedList<Mesa> actual4,int horaActual) {
		int cantidadGrupo=clientes.size();
		int cantLibre2=contarMesas(actual2);
		int cantlibre4=contarMesas(actual4);
		
		// Verifico que haya lugar suficiente para todo el grupo ( asi no acomodo sin sentido)
		
		if (cantidadGrupo<=(cantlibre4*4)+(cantLibre2*2)) {
			//Hay lugar para todos, ahora debo acomodarlos lo mas eficiente posible
				acomodarClientes(cantidadGrupo, actual2, actual4,clientes,horaActual);
                                return true;
			}else {
				System.out.println("Lo siento, no tenemos mesas disponibles");
                                return false;
			}
		
	}
	
}
