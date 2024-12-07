/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.integracion.ServiceLocator;

/**
 * Clase responsable de la lógica para el registro de asignaciones entre
 * profesores y unidades de aprendizaje.
 *
 * @author Gustavo
 */
public class AsignacionDelegate {

    /**
     * Crea un objeto Asignacion para la alta de una nueva asignación de un
     * profesor con una unidad de aprendizaje.
     *
     * @param idProfesor El ID del profesor a asignar.
     * @param idUnidadAprendizaje El ID de la unidad de aprendizaje.
     * @return Asignacion El objeto Asignacion creado.
     */
    public Asignacion altaAsignacion(int idProfesor, int idUnidadAprendizaje) {
        Profesor profesor = obtenerProfesor(idProfesor);
        Unidadaprendizaje unidadAprendizaje = obtenerUnidadAprendizaje(idUnidadAprendizaje);
        verificarAsignacionExistente(idProfesor, idUnidadAprendizaje);

        Asignacion asignacion = new Asignacion();
        asignacion.setIdProfesor(profesor);
        asignacion.setIdUnidadAprendizaje(unidadAprendizaje);

        return asignacion;
    }

    /**
     * Obtiene un profesor a partir de su ID.
     *
     * @param idProfesor El ID del profesor.
     * @return Profesor El profesor encontrado.
     * @throws IllegalArgumentException Si no se encuentra el profesor con su
     * ID.
     */
    private Profesor obtenerProfesor(int idProfesor) {
        Profesor profesor = ServiceLocator.getInstanceProfesorDAO().find(idProfesor);
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor con ID " + idProfesor + " no existe.");
        }
        return profesor;
    }

    /**
     * Obtiene una unidad de aprendizaje a partir de su ID.
     *
     * @param idUnidadAprendizaje El ID de la unidad de aprendizaje.
     * @return UnidadAprendizaje La unidad de aprendizaje encontrada.
     * @throws IllegalArgumentException Si no se encuentra la unidad de
     * aprendizaje con su ID.
     */
    private Unidadaprendizaje obtenerUnidadAprendizaje(int idUnidadAprendizaje) {
        Unidadaprendizaje unidadAprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().find(idUnidadAprendizaje);
        if (unidadAprendizaje == null) {
            throw new IllegalArgumentException("La unidad de aprendizaje con ID " + idUnidadAprendizaje + " no existe.");
        }
        return unidadAprendizaje;
    }

    /**
     * Verifica si ya existe una asignación entre un profesor y una unidad de
     * aprendizaje.
     *
     * @param idProfesor El ID del profesor.
     * @param idUnidadAprendizaje El ID de la unidad de aprendizaje.
     * @throws IllegalArgumentException Si ya existe una asignación entre el
     * profesor y la unidad de aprendizaje.
     */
    private void verificarAsignacionExistente(int idProfesor, int idUnidadAprendizaje) {
        Asignacion existeAsignacion = ServiceLocator.getInstanceAsignacionDAO().comprobarAsignacion(idProfesor, idUnidadAprendizaje);
        if (existeAsignacion != null) {
            throw new IllegalArgumentException("Ya existe una asignación para el profesor con ID " + idProfesor + " y la unidad de aprendizaje con ID " + idUnidadAprendizaje + ".");
        }
    }

    /**
     * Guarda un objeto Asignacion en la base de datos.
     *
     * @param asignacion El contenido del objeto Asignación.
     */
    public void guardarAsignacion(Asignacion asignacion) {
        ServiceLocator.getInstanceAsignacionDAO().save(asignacion);
    }

    /*public Asignacion altaAsignacion(int idProfesor, int idUnidadAprendizaje){
        
        Profesor profesor = ServiceLocator.getInstanceProfesorDAO().find(idProfesor);
        if (profesor == null) {
            throw new IllegalArgumentException("El profesor con ID " + idProfesor + " no existe.");
        }
        
        UnidadAprendizaje unidadAprendizaje = ServiceLocator.getInstanceUnidadAprendizajeDAO().find(idUnidadAprendizaje);
        if (unidadAprendizaje == null) {
            throw new IllegalArgumentException("La unidad de aprendizaje con ID " + idUnidadAprendizaje + " no existe.");
        }
        
        Asignacion existeAsignacion = ServiceLocator.getInstanceAsignacionDAO().comprobarAsignacion(idProfesor, idUnidadAprendizaje);
        if (existeAsignacion != null) {
            throw new IllegalArgumentException("Ya existe una asignación para el profesor con ID " + idProfesor + " y la unidad de aprendizaje con ID " + idUnidadAprendizaje + ".");
        }
        
        Asignacion asignacion = new Asignacion();
        asignacion.setIdProfesor(profesor);  
        asignacion.setIdUnidadAprendizaje(unidadAprendizaje);  
        
        return asignacion;
    }*/
}
