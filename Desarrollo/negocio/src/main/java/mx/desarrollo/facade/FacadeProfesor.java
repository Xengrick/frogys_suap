/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import java.util.List;
import mx.desarrollo.delegate.ProfesorDelegate;
import mx.desarrollo.entidad.Profesor;

/**
 * Facade para manejar la lógica relacionada con los profesores.
 *
 * @author Gustavo
 */
public class FacadeProfesor {

    private ProfesorDelegate delegateProfesor;

    /**
     * Crea una instancia de FacadeProfesor
     */
    public FacadeProfesor() {
        this.delegateProfesor = new ProfesorDelegate();
    }

    /**
     * Registra un nuevo profesor.
     *
     * @param nombre El nombre del profesor.
     * @param apellido El apellido del profesor.
     * @param rfc El RFC del profesor.
     * @return Profesor Un objeto Profesor.
     */
    public Profesor registrarProfesor(String nombre, String apellido, String rfc) {
        return delegateProfesor.altaProfesor(nombre, apellido, rfc);
    }

    /**
     * Guarda un profesor en el sistema.
     *
     * @param profesor El objeto Profesor a guardar.
     */
    public void guardarProfesor(Profesor profesor) {
        delegateProfesor.guardarProfesor(profesor);
    }

    /**
     * Obtiene una lista de todos los profesores registrados en el sistema.
     *
     * @return List Una lista de objetos Profesor.
     */
    public List<Profesor> mostrarProfesores() {
        return delegateProfesor.mostrarProfesores();
    }
}
