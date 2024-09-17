package mx.desarrollo.ui;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.application.FacesMessage;
import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.helper.AsignacionBeanHelper;
import mx.desarrollo.helper.ProfesorBeanHelper;
import mx.desarrollo.helper.UnidadAprendizajeBeanHelper;

@ManagedBean(name = "agregarUnidadProfesorBeanUI")
@RequestScoped
public class AgregarUnidadProfesorBeanUI implements Serializable {

    private AsignacionBeanHelper asignacionBeanHelper = new AsignacionBeanHelper();
    private ProfesorBeanHelper profesorBeanHelper;
    private UnidadAprendizajeBeanHelper unidadAprendizajeBeanHelper;

    private int idProfesor;
    private int idUnidadAprendizaje;
    private List<Profesor> listaProfesores;
    private List<Unidadaprendizaje> listaUnidadesAprendizaje;

    // Constructor público por defecto
    public AgregarUnidadProfesorBeanUI() {
        // Inicialización de los helpers
        this.profesorBeanHelper = new ProfesorBeanHelper();
        this.unidadAprendizajeBeanHelper = new UnidadAprendizajeBeanHelper();
    }

    @PostConstruct
    public void init() {
        obtenerTodosLosProfesores();
        obtenerUnidadesDeAprendizaje();
    }

    // Métodos para Asignaciones
    public void registrarAsignacion() {
        try {
            Asignacion asignacion = asignacionBeanHelper.registrarAsignacion(idProfesor, idUnidadAprendizaje);
            asignacionBeanHelper.guardarAsignacion(asignacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación registrada", "La asignación fue registrada exitosamente."));
        } catch (IllegalArgumentException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error inesperado", "Ocurrió un error inesperado. Intente nuevamente."));
        }
    }

    // Métodos para Profesores
    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }

    public void obtenerTodosLosProfesores() {
        listaProfesores = profesorBeanHelper.getProfesores();
    }

    // Métodos para Unidades de Aprendizaje
    public List<Unidadaprendizaje> getListaUnidadesAprendizaje() {
        return listaUnidadesAprendizaje;
    }

    public void obtenerUnidadesDeAprendizaje() {
        listaUnidadesAprendizaje = unidadAprendizajeBeanHelper.getUnidadesAprendizaje();
    }

    // Getters y Setters
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public int getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(int idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }
}
