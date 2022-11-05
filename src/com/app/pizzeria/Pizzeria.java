/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.pizzeria;

import java.util.LinkedList;
import com.app.models.*;
/**
 *
 * @author Estudiar
 */
public class Pizzeria {
    private String nombre="La Tana";
    private int telefono;
    private LinkedList<Mesa> mesaActual2=new LinkedList<Mesa>();
    private LinkedList<Mesa> mesaActual4= new LinkedList<Mesa>();
    private static int totalMesas2=8;
    private static int totalMesas4=8;
    private boolean abierto;
    private Cocina cocina=new Cocina();
    private Caja caja=new Caja();
    private LinkedList<Mesero> meseros= new LinkedList<Mesero>();
    private LinkedList<AyudantesCocina> ayudantesCocina= new LinkedList<AyudantesCocina>();
    
    
    
}
