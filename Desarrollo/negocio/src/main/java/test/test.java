/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.List;
import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        
       List<Profesor> profesores = ServiceFacadeLocator.getInstanceFacadeProfesor().mostrarProfesores();
       for(Profesor profesor : profesores){
           System.out.println(profesor.getIdProfesor() + profesor.getNombre() + profesor.getApellido() + profesor.getRfc());
       }
    }
}
