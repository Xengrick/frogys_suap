/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.integracion.ServiceLocator;

/**
 * Clase responsable de la lógica relacionada con las unidades de aprendizaje.
 *
 * @author Gustavo
 */
public class UnidadAprendizajeDelegate {

    /**
     * Crea un objeto UnidadAprendizaje para la alta de una nueva unidad de
     * aprendizaje
     *
     * @param nombre El nombre de la unidad de aprendizaje.
     * @param horasClase Las horas de clase de la unidad de aprendizaje.
     * @param horasTaller Las horas de taller de la unidad de aprendizaje.
     * @param horasLaboratorio Las horas de laboratorio de la unidad de
     * aprendizaje.
     * @return UnidadAprendizaje El objeto UnidadAprendizaje creado.
     */
    public Unidadaprendizaje altaUnidadAprendizaje(String nombre, int horasClase, int horasTaller, int horasLaboratorio) {
        validarNombre(nombre);
        validarHorasNoNegativas(horasClase, horasTaller, horasLaboratorio);
        validarHorasMinimas(horasClase, horasTaller, horasLaboratorio);

        Unidadaprendizaje unidadAprendizaje = new Unidadaprendizaje();
        unidadAprendizaje.setNombre(nombre);
        unidadAprendizaje.setHorasClase(horasClase);
        unidadAprendizaje.setHorasTaller(horasTaller);
        unidadAprendizaje.setHorasLaboratorio(horasLaboratorio);

        return unidadAprendizaje;
    }

    /**
     * Guarda un objeto UnidadAprendizaje en la base de datos.
     *
     * @param unidadAprendizaje El contenido de la unidad de aprendizaje a
     * guardar.
     */
    public void guardarUnidadAprendizaje(Unidadaprendizaje unidadAprendizaje) {
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidadAprendizaje);
    }

    /**
     * Retorna una lista de todas las unidades de aprendizaje almacenadas en la
     * base de datos.
     *
     * @return List Lista de unidades de aprendizaje.
     */
    public List<Unidadaprendizaje> mostrarUnidadesDeAprendizaje() {
        return ServiceLocator.getInstanceUnidadAprendizajeDAO().findAll();
    }

    /**
     * Valida que el nombre de la unidad de aprendizaje no esté vacío.
     *
     * @param nombre El nombre a validar.
     * @throws IllegalArgumentException si el nombre está vacío o es nulo.
     */
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la unidad de aprendizaje no puede estar vacío.");
        }
    }

    /**
     * Valida que las horas de clase, taller y laboratorio no sean negativas.
     *
     * @param horasClase Las horas de clase a validar.
     * @param horasTaller Las horas de taller a validar.
     * @param horasLaboratorio Las horas de laboratorio a validar.
     * @throws IllegalArgumentException si alguna de las horas es negativa.
     */
    private void validarHorasNoNegativas(int horasClase, int horasTaller, int horasLaboratorio) {
        if (horasClase < 0) {
            throw new IllegalArgumentException("Las horas de clase no pueden ser negativas.");
        }

        if (horasTaller < 0) {
            throw new IllegalArgumentException("Las horas de taller no pueden ser negativas.");
        }

        if (horasLaboratorio < 0) {
            throw new IllegalArgumentException("Las horas de laboratorio no pueden ser negativas.");
        }
    }

    /**
     * Valida que por lo menos una de las horas (clase, taller o laboratorio) sea
     * mayor que 0.
     *
     * @param horasClase Las horas de clase a validar.
     * @param horasTaller Las horas de taller a validar.
     * @param horasLaboratorio Las horas de laboratorio a validar.
     * @throws IllegalArgumentException si todas las horas son cero.
     */
    private void validarHorasMinimas(int horasClase, int horasTaller, int horasLaboratorio) {
        if (horasClase == 0 && horasTaller == 0 && horasLaboratorio == 0) {
            throw new IllegalArgumentException("Debe haber al menos una hora de clase, taller o laboratorio.");
        }
    }
}
