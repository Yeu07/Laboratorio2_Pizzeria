/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

import java.util.Date;
import java.util.LinkedList;


/**
 *
 * @author Estudiar
 */
public class Mesero extends Empleados{
	
	public Mesero(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
		super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
	}
	
	public void recibirCliente(LinkedLsit<Cliente> clientes) {
		
	}
	
	/*public LinkedList<Productos> recibirPedido(LinkedList<Productos> pedido) {
		
	}*/
}
