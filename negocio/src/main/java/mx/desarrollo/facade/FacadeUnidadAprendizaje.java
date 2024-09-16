/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateUnidadAprendizaje;
import mx.desarrollo.entidad.UnidadAprendizaje;

/**
 *
 * @author be
 */
public class FacadeUnidadAprendizaje {
    
    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje;

    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    }

    public void registrarUnidadAprendizaje(String nombre, int horasClase, int horasTaller, int horasLaboratorio) {
        delegateUnidadAprendizaje.registrarUnidadAprendizaje(nombre, horasClase, horasTaller, horasLaboratorio);
    }
    
    public void guardarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        delegateUnidadAprendizaje.guardarUnidadAprendizaje(unidadAprendizaje);
    }
    
    
    
}
