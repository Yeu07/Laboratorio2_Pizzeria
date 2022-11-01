/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

/**
 *
 * @author Estudiar
 */
public class Caja {
    private float dineroCaja=0;
    
    public void setDineroCaja(float pago){
        this.dineroCaja+=pago;
    }
    
    public float getDineroCaja() {
    	return this.dineroCaja;
    }
}
