/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

import mx.desarrollo.DAO.AsignacionDAO;
import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.DAO.UnidadAprendizajeDAO;
import mx.desarrollo.DAO.UsuarioDAO;

/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static AsignacionDAO asignacionDAO;
    private static ProfesorDAO profesorDAO;
    private static UnidadAprendizajeDAO unidadaprendizajeDAO;
    private static UsuarioDAO usuarioDAO;
    
    /**
     * se crea la instancia de profesorDAO si esta no existe
     * @return 
     */
    public static ProfesorDAO getInstanceProfesorDAO() {
        if (profesorDAO == null) {
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else {
            return profesorDAO;
        }
    }
    
    /**
     * se crea la instancia para asignacion DAO si esta no existe
     */
    
    public static AsignacionDAO getInstanceAsignacionDAO(){
        if(asignacionDAO == null){
            asignacionDAO = new AsignacionDAO();
            return asignacionDAO;
        } else{
            return asignacionDAO;
        }
    }
    
    /**
     * se crea la instancia para unidad aprendizaje DAO si esta no existe
     */
    
    public static UnidadAprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        if(unidadaprendizajeDAO == null){
            unidadaprendizajeDAO = new UnidadAprendizajeDAO();
            return unidadaprendizajeDAO;
        } else{
            return unidadaprendizajeDAO;
        }
    }
        
    /**
     * se crea la instancia de usuarioDAO si esta no existe
     * @return 
     */
    public static UsuarioDAO getInstanceUsuarioDAO(){
        if(usuarioDAO == null){
            usuarioDAO = new UsuarioDAO();
            return usuarioDAO;
        } else{
            return usuarioDAO;
        }
    }
    
}
