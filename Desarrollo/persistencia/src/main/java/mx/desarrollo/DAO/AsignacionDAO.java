/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;

import java.util.List;
import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.persistencia.AbstractDAO;
/**
 *
 * @author Usuario
 */
public class AsignacionDAO extends AbstractDAO<Integer, Asignacion>{
    
    public Asignacion comprobarAsignacion(int idProfesor, int idUnidadAprendizaje) {
        List<Asignacion> asignaciones = findByOneParameterOrder(String.valueOf(idProfesor), "idProfesor", true);
        for (Asignacion asignacion : asignaciones) {
            if (asignacion.getIdUnidadAprendizaje().getIdUnidadAprendizaje() == idUnidadAprendizaje) {
                return asignacion;
            }
        }
        return null;
    }
}
