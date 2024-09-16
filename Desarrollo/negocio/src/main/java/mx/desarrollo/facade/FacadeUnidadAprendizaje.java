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
 * @author Be
 */
public class FacadeUnidadAprendizaje {
    
    // Variables
    private UnidadAprendizaje unidadAprendizaje;
    
    private final DelegateUnidadAprendizaje delegateUnidadAprendizaje = new DelegateUnidadAprendizaje();
    
    public void registrarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
        delegateUnidadAprendizaje.registrarUnidadAprendizaje(unidadAprendizaje);
    }
}
