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
    protected int tiempoElaboracion=0;
    protected float precio;
    protected LinkedList<Float> ingredientes=new LinkedList<Float>();
    
    public LinkedList<Float> getIngredientes(){
        return this.ingredientes;
    }

	public int getTiempoElaboracion() {
		return tiempoElaboracion;
	}
	
	public float getPrecio() {
		return precio;
	}

	public void setTiempoElaboracion(int tiempoElaboracion) {
		this.tiempoElaboracion = tiempoElaboracion;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public void setIngredientes(LinkedList<Float> ingredientes) {
		this.ingredientes = ingredientes;
	}
    

}

