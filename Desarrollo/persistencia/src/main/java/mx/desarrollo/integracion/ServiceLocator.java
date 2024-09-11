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
    
    private static ProfesorDAO profesorDAO;
    private static UnidadAprendizajeDAO unidadAprendizajeDAO;
    private static AsignacionDAO AsignacionDAO;
    private static UsuarioDAO usuarioDAO;
    /**
     * se crea la instancia para profesor DAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    
    /**
     * se crea la instancia para asignacion DAO si esta no existe
     */
    
    public static AsignacionDAO getInstanceAsignacionDAO(){
        if(AsignacionDAO == null){
            AsignacionDAO = new AsignacionDAO();
            return AsignacionDAO;
        } else{
            return AsignacionDAO;
        }
    }
    
    /**
     * se crea la instancia para unidad aprendizaje DAO si esta no existe
     */
    
    public static UnidadAprendizajeDAO getInstanceUnidadAprendizajeDAO(){
        if(unidadAprendizajeDAO == null){
            unidadAprendizajeDAO = new UnidadAprendizajeDAO();
            return unidadAprendizajeDAO;
        } else{
            return unidadAprendizajeDAO;
        }
    }
    
    /**
     * se crea la instancia de usuarioDAO si esta no existe
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
