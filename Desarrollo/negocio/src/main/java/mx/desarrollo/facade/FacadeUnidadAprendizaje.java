/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.UnidadAprendizajeDelegate;
import mx.desarrollo.entidad.Unidadaprendizaje;

/**
 * Facade para manejar la lógica relacionada con las unidades de aprendizaje.
 *
 * @author Usuario
 */
public class FacadeUnidadAprendizaje {

    private UnidadAprendizajeDelegate delegateUnidadAprendizaje;

    /**
     * Crea una instancia de FacadeUnidadAprendizaje.
     */
    public FacadeUnidadAprendizaje() {
        this.delegateUnidadAprendizaje = new UnidadAprendizajeDelegate();
    }

    /**
     * Registra una nueva unidad de aprendizaje con los datos proporcionados.
     *
     * @param nombre El nombre de la unidad de aprendizaje.
     * @param horasClase Las horas de clase de la unidad de aprendizaje.
     * @param horasTaller Las horas de taller de la unidad de aprendizaje.
     * @param horasLaboratorio Las horas de laboratorio de la unidad de la unidad de aprendizaje
     */
    public void registrarUnidadAprendizaje(String nombre, int horasClase, int horasTaller, int horasLaboratorio) {
        delegateUnidadAprendizaje.altaUnidadAprendizaje(nombre, horasClase, horasTaller, horasLaboratorio);
    }

    /**
     * Guarda una unidad de aprendizaje en el sistema.
     *
     * @param unidadAprendizaje El objeto UnidadAprendizaje a guardar.
     */
    public void guardarUnidadAprendizaje(Unidadaprendizaje unidadAprendizaje) {
        delegateUnidadAprendizaje.guardarUnidadAprendizaje(unidadAprendizaje);
    }

    /**
     * Obtiene una lista de todas las unidades de aprendizaje registradas en el
     * sistema.
     *
     * @return List Una lista de objetos UnidadAprendizaje.
     */
    public List<Unidadaprendizaje> mostrarUnidadesDeAprendizaje() {
        return delegateUnidadAprendizaje.mostrarUnidadesDeAprendizaje();
    }
}