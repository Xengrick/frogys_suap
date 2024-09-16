/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author Usuario
 */
public class DelegateAsignacion {
    
    public Asignacion registrarAsignacion(int idProfesor, int idUnidadAprendizaje){
        
        Profesor profesor = ServiceLocator.getInstanceProfesorDAO().find(idProfesor);
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor con ID " + idProfesor + " no existe.");
        }
        
        Unidadaprendizaje unidadAprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().find(idUnidadAprendizaje);
        if (unidadAprendizaje == null) {
            throw new IllegalArgumentException("La unidad de aprendizaje con ID " + idUnidadAprendizaje + " no existe.");
        }
        
        Asignacion existeAsignacion = ServiceLocator.getInstanceAsignacionDAO().comprobarAsignacion(idProfesor, idUnidadAprendizaje);
        if (existeAsignacion != null) {
            throw new IllegalArgumentException("Ya existe una asignación para el profesor con ID " + idProfesor + " y la unidad de aprendizaje con ID " + idUnidadAprendizaje + ".");
        }
        
        Asignacion asignacion = new Asignacion();
        asignacion.setIdProfesor(profesor);  
        asignacion.setIdUnidadAprendizaje(unidadAprendizaje);  
        
        return asignacion;
    }
    
    public void guardarAsignacion(Asignacion asignacion){
        ServiceLocator.getInstanceAsignacionDAO().save(asignacion);
    }
}
