package mx.desarrollo.ui;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.helper.AsignacionBeanHelper;

@ManagedBean(name = "asignacionBeanUI")
@RequestScoped
public class AsignacionBeanUI implements Serializable {

    private AsignacionBeanHelper asignacionBeanHelper = new AsignacionBeanHelper();
    private int idProfesor;
    private int idUnidadAprendizaje;

    public AsignacionBeanUI(int idProfesor, int idUnidadAprendizaje) {
        this.idProfesor = idProfesor;
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }
    
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

    // Método para registrar la asignación
    public void registrarAsignacion() {
        
         try {
            Asignacion asignacion  = asignacionBeanHelper.registrarAsignacion(idProfesor, idUnidadAprendizaje);
            asignacionBeanHelper.guardarAsignacion(asignacion);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Asignación registrada", "La asignación fue registrada exitosamente."));
        } catch (IllegalArgumentException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "hola"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error inesperado", "Ocurrió un error inesperado. Intente nuevamente."));
        }
    }
}
