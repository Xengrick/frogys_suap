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
     * Se crea la instancia de ProfesorDAO si esta no existe.
     * @return ProfesorDAO instancia de ProfesorDAO.
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
     * Se crea la instancia para AsignacionDAO si esta no existe.
     * @return AsignacionDAO instancia de AsignacionDAO.
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
     * Se crea la instancia para UnidadAprendizajeDAO si esta no existe
     * @return UnidadAprendizajeDAO instancia de UnidadAprendizajeDAO.
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
     * Se crea la instancia de UsuarioDAO si esta no existe
     * @return UsuarioDAO instancia de UsuarioDAO. 
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
