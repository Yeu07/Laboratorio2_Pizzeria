/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package laboratorio2;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author Estudiar
 */
public class Laboratorio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cajero cajero=new Cajero("pepe","chaco","micasa",41097504,new Date("98/03/21"));
        
        /*LinkedList<Object> cars = new LinkedList<Object>();
        cars.add("Volvo");
        cars.add(2);
        cars.add(cajero);
        cars.add("Mazda");
        System.out.println(cars);*/
        PizzaMuzzarella hola=new PizzaMuzzarella();
        PizzaConPalmitos pizza=new PizzaConPalmitos();
        //System.out.println(pizza.ingredientes());
        System.out.println(hola.getIngredientes());
        System.out.println(pizza.getIngredientes());
        //System.out.println(pizza.cantIngredientes());
        //System.out.println(hola.getCantIngredientes());
  }
}

