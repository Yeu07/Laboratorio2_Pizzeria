/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

import java.util.LinkedList;

/**
 *
 * @author Estudiar
 */
public class Productos {
    protected int tiempoElaboracion;
    protected float precio;
    protected LinkedList<Float> ingredientes=new LinkedList<Float>();
    
    public LinkedList<Float> getIngredientes(){
        return this.ingredientes;
    }

}

