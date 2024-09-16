/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.integracion.ServiceLocator;
/**
 *
 * @author Be
 */
public class DelegateUnidadAprendizaje {
    
    public void registrarUnidadAprendizaje(String nombre, int horasClase, int horasTaller, int horasLaboratorio){
        
        // Validación del nombre
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la unidad de aprendizaje no puede estar vacío.");
        }
        
        // Validación de horas de clase
        if (horasClase < 0) {
            throw new IllegalArgumentException("Las horas de clase no pueden ser negativas.");
        }
        
        // Validación de horas de taller
        if (horasTaller < 0) {
            throw new IllegalArgumentException("Las horas de taller no pueden ser negativas.");
        }
        
        // Validación de horas de laboratorio
        if (horasLaboratorio < 0) {
            throw new IllegalArgumentException("Las horas de laboratorio no pueden ser negativas.");
        }
        
        // Validación de que al menos una de las horas sea mayor que 0
        if (horasClase == 0 && horasTaller == 0 && horasLaboratorio == 0) {
            throw new IllegalArgumentException("Debe haber al menos una hora de clase, taller o laboratorio.");
        }
        
        Unidadaprendizaje UnidadAprendizaje = new Unidadaprendizaje();
        UnidadAprendizaje.setNombre(nombre);
        UnidadAprendizaje.setHorasClase(horasClase);
        UnidadAprendizaje.setHorasTaller(horasTaller);
        UnidadAprendizaje.setHorasLaboratorio(horasLaboratorio);
    }
    
    public void guardarUnidadAprendizaje(Unidadaprendizaje unidadAprendizaje){
        ServiceLocator.getInstanceUnidadAprendizajeDAO().save(unidadAprendizaje);
    }
}
