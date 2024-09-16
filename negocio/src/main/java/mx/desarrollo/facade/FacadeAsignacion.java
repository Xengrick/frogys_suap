/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateAsignacion;
import mx.desarrollo.entidad.Asignacion;

/**
 *
 * @author Usuario
 */
public class FacadeAsignacion {
    private final DelegateAsignacion delegateAsignacion;

    public FacadeAsignacion() {
        this.delegateAsignacion = new DelegateAsignacion();
    }

    public Asignacion registrarAsignacion(int idProfesor, int idUnidadAprendizaje) {
        return delegateAsignacion.registrarAsignacion(idProfesor, idUnidadAprendizaje);
    }
    
    public void guardarAsignacion(Asignacion asignacion) {
        delegateAsignacion.guardarAsignacion(asignacion);
    }
    
    
}
