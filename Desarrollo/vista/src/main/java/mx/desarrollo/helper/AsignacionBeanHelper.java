/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import mx.desarrollo.integracion.ServiceFacadeLocator;
import java.io.Serializable;
import mx.desarrollo.entidad.Asignacion;

/**
 *
 * @author Usuario
 */
public class AsignacionBeanHelper implements Serializable{
    
    public Asignacion registrarAsignacion(int idProfesor, int idUnidadAprendizaje){
        return ServiceFacadeLocator.getInstanceFacadeAsignacion().registrarAsignacion(idProfesor, idUnidadAprendizaje);
    }
    
    public void guardarAsignacion(Asignacion asignacion){
        ServiceFacadeLocator.getInstanceFacadeAsignacion().guardarAsignacion(asignacion);
    }

}
