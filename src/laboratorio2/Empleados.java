/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package laboratorio2;

import java.util.Date;

/**
 *
 * @author Estudiar
 */
public class Empleados {
    private String nombre, nacionalidad, ubicacionVivienda;
    private int DNI;
    private Date fechaNacimiento= new Date();
    
    public Empleados(String nombre, String nacionalidad, String ubicacionVivienda,int DNI, Date fechaNacimiento){
        this.nombre=nombre;
        this.nacionalidad=nacionalidad;
        this.ubicacionVivienda=ubicacionVivienda;
        this.DNI=DNI;
        this.fechaNacimiento=fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public String getUbicacionVivienda() {
        return ubicacionVivienda;
    }

    public int getDNI() {
        return DNI;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setUbicacionVivienda(String ubicacionVivienda) {
        this.ubicacionVivienda = ubicacionVivienda;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
}
