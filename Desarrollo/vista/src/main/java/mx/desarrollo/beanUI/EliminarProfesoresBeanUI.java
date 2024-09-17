/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.beanUI;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.helper.ProfesorBeanHelper;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "eliminarProfesoresBeanUI")
@RequestScoped
public class EliminarProfesoresBeanUI implements Serializable {

    private ProfesorBeanHelper profesorBeanHelper;

    private int idProfesor;
    private List<Profesor> listaProfesores;
    private Profesor profesorSeleccionado;

    @PostConstruct
    public void init() {
        obtenerTodosLosProfesores();
    }

    public EliminarProfesoresBeanUI() {
        profesorBeanHelper = new ProfesorBeanHelper();
    }

    public void eliminarProfesor(int idProfesor) {
        try {
            profesorBeanHelper.eliminarProfesor(idProfesor);
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

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public Profesor getProfesorSeleccionado() {
        return profesorSeleccionado;
    }

    public void setProfesorSeleccionado(Profesor profesorSeleccionado) {
        this.profesorSeleccionado = profesorSeleccionado;
    }
}
