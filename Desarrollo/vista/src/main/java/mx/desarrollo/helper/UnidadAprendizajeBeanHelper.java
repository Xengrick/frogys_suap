/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.util.List;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.integracion.ServiceFacadeLocator;
/**
 *
 * @author Usuario
 */
public class UnidadAprendizajeBeanHelper {
    
    public List<Unidadaprendizaje> getUnidadesAprendizaje(){
        return ServiceFacadeLocator.getInstanceFacadeUnidadAprendizaje().mostrarUnidadesDeAprendizaje();
    }
}
