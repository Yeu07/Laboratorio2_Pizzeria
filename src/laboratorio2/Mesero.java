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
        public Mesero(String nombre, String nacionalidad, String ubicacionVivienda,int DNI, Date fechaNacimiento){
        super(nombre, nacionalidad, ubicacionVivienda,DNI, fechaNacimiento);
    }
    
    public void recibirPedido(LinkedList<Object> pedido){
        
    }
}
