/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.integracion.ServiceLocator;
/**
 *
 * @author Be
 */
public class DelegateUnidadAprendizaje {
    
    public DelegateUnidadAprendizaje() {
    }

    public void registrarUnidadAprendizaje(Unidadaprendizaje unidadAprendizaje) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidadAprendizaje);
    }
}
