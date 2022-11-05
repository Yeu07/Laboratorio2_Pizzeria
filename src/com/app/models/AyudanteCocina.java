/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.models;

import java.util.Date;

/**
 *
 * @author Estudiar
 */
public class AyudanteCocina extends Empleado{
    private int tiempoOcupado;
    public AyudanteCocina(String nombre, String nacionalidad,float sueldo,int dni, Date fechaNacimiento) {
	super(nombre,nacionalidad,sueldo,dni,fechaNacimiento);
    }
}
