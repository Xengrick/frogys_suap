/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import mx.desarrollo.delegate.AsignacionDelegate;
import mx.desarrollo.entidad.Asignacion;

/**
 * Facade para manejar la lógica de asignaciones
 *
 * @author Gustavo
 */
public class FacadeAsignacion {

    private AsignacionDelegate asignacionDelegate;

    /**
     * Crea una instancia de FacadeAsignacion
     */
    public FacadeAsignacion() {
        this.asignacionDelegate = new AsignacionDelegate();
    }

    /**
     * Registra una nueva asignación
     *
     * @param idProfesor El ID del profesor a asignar.
     * @param idUnidadAprendizaje El ID de la unidad de aprendizaje a asignar.
     * @return Asignacion La asignación creada.
     */
    public Asignacion registrarAsignacion(int idProfesor, int idUnidadAprendizaje) {
        return asignacionDelegate.altaAsignacion(idProfesor, idUnidadAprendizaje);
    }

    /**
     * Guarda una asignación en el sistema.
     *
     * @param asignacion La asignación a guardar.
     */
    public void guardarAsignacion(Asignacion asignacion) {
        asignacionDelegate.guardarAsignacion(asignacion);
    }
}