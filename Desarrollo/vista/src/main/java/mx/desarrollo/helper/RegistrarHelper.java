/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.Serializable;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author Be
 */
public class RegistrarHelper implements Serializable{
    UnidadAprendizaje unidadAprendizaje;
    public void registrarUnidadAprendizaje(UnidadAprendizaje unidadAprendizaje){
        this.unidadAprendizaje = unidadAprendizaje;
        ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().registrarUnidadAprendizaje(unidadAprendizaje);
    }
}
