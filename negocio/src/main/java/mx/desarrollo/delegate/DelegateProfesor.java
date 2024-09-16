
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;
/**
 *
 * @author FabianOMX
 */
public class DelegateProfesor {

    private ProfesorDAO profesorDAO;

    public DelegateProfesor() {
        profesorDAO = new ProfesorDAO();
    }

    /**
     * Método para validar que el RFC ingresado tenga el formato correcto.
     * @param rfc RFC del profesor.
     * @return true si el RFC es válido, false si no lo es.
     */
    private boolean validarRFC(String rfc) {
        // El formato correcto de RFC es de 13 caracteres: 4 letras, 6 dígitos y 3 alfanuméricos
        String regexRFC = "^[A-Z]{4}[0-9]{6}[A-Z0-9]{3}$";
        return rfc != null && rfc.matches(regexRFC);
    }

    /**
     * Registrar un Profesor si su RFC es válido.
     * @param profesor Objeto de tipo Profesor.
     * @throws IllegalArgumentException Si el RFC es inválido.
     */
    public Profesor registrarProfesor(String nombre, String apellido, String rfc) {
        Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setRfc(rfc);

        if (!validarRFC(profesor.getRFC())) {
            throw new IllegalArgumentException("El RFC ingresado no es válido.");
        }

        profesorDAO.save(profesor);

        return profesor;
    }

    /**
     * Actualizar un Profesor si su RFC es válido.
     * @param profesor Objeto de tipo Profesor.
     * @throws IllegalArgumentException Si el RFC es inválido.
     */
    public void actualizarProfesor(Profesor profesor) {
        if (!validarRFC(profesor.getRFC())) {
            throw new IllegalArgumentException("El RFC ingresado no es válido.");
        }
        profesorDAO.update(profesor);
    }

    /**
     * Eliminar un Profesor por su ID.
     * @param idProfesor ID del Profesor.
     */
    public void eliminarProfesorPorId(int idProfesor) {
        profesorDAO.eliminarProfesorId(idProfesor);
    }

    /**
     * Obtener un Profesor por su ID.
     * @param id ID del Profesor.
     * @return Objeto Profesor.
     */
    public Profesor obtenerProfesorPorId(Integer id) {
        return profesorDAO.find(id);
    }

    /**
     * Obtener todos los Profesores.
     * @return Lista de Profesores.
     */
    public List<Profesor> obtenerTodosLosProfesores() {
        return profesorDAO.findAll();
    }

    /**
     * Obtener la lista de Profesores y sus Asignaciones.
     * @return Lista de objetos con nombre del profesor y su asignación.
     */
    public List<Object[]> obtenerProfesoryAsignaciones() {
        return profesorDAO.obtenerProfesorAsignaciones();
    }

    /**
     * Buscar Profesores que imparten una Unidad de Aprendizaje.
     * @param nombreUnidad Nombre de la Unidad de Aprendizaje.
     * @return Lista de Profesores que imparten la unidad.
     */
    public List<Profesor> buscarProfesorPorUnidad(String nombreUnidad) {
        return profesorDAO.buscarProfesorUnidad(nombreUnidad);
    }

    /**
     * Modificar la Asignación de un Profesor a una nueva Unidad de Aprendizaje.
     * @param idProfesor ID del Profesor.
     * @param idUnidadNueva ID de la nueva Unidad de Aprendizaje.
     */
    public void modificarAsignacionProfesor(int idProfesor, int idUnidadNueva) {
        profesorDAO.modificarAsignacionProfesor(idProfesor, idUnidadNueva);
    }
}
