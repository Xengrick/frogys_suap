/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceFacadeLocator;
/**
 *
 * @author Usuario
 */
public class ProfesorBeanHelper implements Serializable {
    
    public Profesor registrarProfesor(int idProfesor, String nombre, String apellido, String rfc){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().registrarProfesor(nombre, apellido, rfc);
    }
    
    public void guardarProfesor(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(profesor);
    }
    
    public List<Profesor> getProfesores(){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().mostrarProfesores();
    }
}
