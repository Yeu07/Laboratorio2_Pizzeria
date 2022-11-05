/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.app.exe;

import com.app.alimentos.Alimento;
import com.app.alimentos.PizzaMuzzarella;
import com.app.models.Cliente;
import com.app.models.Mesero;
import com.app.pizzeria.Cocina;
import com.app.pizzeria.Menu;
import java.util.Date;
import java.util.LinkedList;
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
    	Menu menu= new Menu();
        Cliente cliente= new Cliente("Pedro");
        
        /*Random random= new Random();
        int num=random.nextInt(4);
        System.out.println("random= "+num);*/
        
        /*Menu probar=new Menu();
        System.out.println(probar.buscaPizza(6).getIngredientes());*/
        
        Cocina verIngredientes = new Cocina();
        Mesero testeando=new Mesero("Pedro","Argentina",2f,1289123,new Date(122,02,02));
        Alimento consulta= new PizzaMuzzarella();
        System.out.println(consulta.hayIngredientes);
        /*System.out.println(consulta.getIngredientes().get(0));
        float pos=consulta.getIngredientes().get(0);
        System.out.println(verIngredientes.cantIngredientes[(int)pos-1]);
        System.out.println(consulta.getIngredientes().get(1));*/
        LinkedList<Alimento> probandoComida= new LinkedList<Alimento>();
        
        
        
        
        
    }

    
    
}

