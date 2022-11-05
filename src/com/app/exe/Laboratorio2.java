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
        System.out.println(cliente.pedirComida(menu));
        
        
        
        
        
    }

    
    
}

