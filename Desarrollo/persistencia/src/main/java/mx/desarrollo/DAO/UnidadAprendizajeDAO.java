/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.DAO;

import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.persistencia.AbstractDAO;


/**
 *
 * @author Be
 */
public class UnidadAprendizajeDAO extends AbstractDAO<Integer,Unidadaprendizaje>{
    public void registrarUnidadAprendizaje(Unidadaprendizaje unidadAprendizaje){
        String sql = "INSERT INTO unidadaprendizaje (idUnidadAprendizaje,nombre,horasClase,horasTaller,horasLaboratorio),VALUES (?, ?, ?)";
        
        
        
    }
}
