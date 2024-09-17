package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;

/**
 * Clase responsable de la lógica relacionada con los profesores.
 *
 * @author Gustavo
 */
public class ProfesorDelegate {

    /**
     * Crea un objeto Profesor para la alta de un nuevo profesor.
     *
     * @param nombre El nombre del profesor.
     * @param apellido El apellido del profesor.
     * @param rfc El RFC del profesor.
     * @return Profesor El objeto Profesor creado.
     */
    public Profesor altaProfesor(String nombre, String apellido, String rfc) {
        validarNombre(nombre);
        validarApellido(apellido);
        validarRfc(rfc);

        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setRfc(rfc);

        return profesor;
    }

    /**
     * Guarda un objeto Profesor en la base de datos.
     *
     * @param profesor El contenido del profesor a guardar.
     */
    public void guardarProfesor(Profesor profesor) {
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }

    /**
     * Retorna una lista de todos los profesores almacenados en la base de
     * datos.
     *
     * @return List Lista de profesores.
     */
    public List<Profesor> mostrarProfesores() {
        return ServiceLocator.getInstanceProfesorDAO().findAll();
    }
    
    /**
     * Elimina a un profesor de la base de datos
     * @param idProfesor
     */
    public void eliminarProfesor(int idProfesor) {
        ServiceLocator.getInstanceProfesorDAO().eliminarProfesorId(idProfesor);
    }

    /**
     * Valida que el nombre no esté vacío.
     *
     * @param nombre El nombre a validar.
     * @throws IllegalArgumentException si el nombre está vacío o es nulo.
     */
    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
    }

    /**
     * Valida que el apellido no esté vacío.
     *
     * @param apellido El apellido a validar.
     * @throws IllegalArgumentException si el apellido está vacío o es nulo.
     */
    private void validarApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
    }

    /**
     * Valida que el RFC tenga 13 caracteres y cumpla con el formato de persona
     * fisica.
     *
     * @param rfc El RFC a validar.
     * @throws IllegalArgumentException si el RFC no cumple con los requisitos.
     */
    private void validarRfc(String rfc) {
        if (rfc == null || rfc.length() != 13) {
            throw new IllegalArgumentException("El RFC debe tener exactamente 13 caracteres.");
        }

        if (!rfc.matches("[A-ZÑ&]{4}[0-9]{6}[A-Z0-9]{3}")) {
            throw new IllegalArgumentException("El formato del RFC no es válido.");
        }
    }
}