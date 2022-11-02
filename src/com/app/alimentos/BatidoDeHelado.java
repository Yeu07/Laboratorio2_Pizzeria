/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.alimentos;

/**
 *
 * @author Estudiar
 */
public class BatidoDeHelado extends Helado {
    public BatidoDeHelado(){
        super();
        this.ingredientes.add(26f);
        this.ingredientes.add(0.5f);//Litros
        this.ingredientes.add(27f);
        this.ingredientes.add(40f);//Gramos
        this.precio=500f;
        this.tiempoElaboracion=10;
    }
}
