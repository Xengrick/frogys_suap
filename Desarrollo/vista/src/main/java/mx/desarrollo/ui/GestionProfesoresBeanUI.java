/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.helper.ProfesorBeanHelper;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "gestionProfesoresBeanUI")
@ViewScoped
public class GestionProfesoresBeanUI implements Serializable {

    private ProfesorBeanHelper profesorBeanHelper;

    private int idProfesor;
    private String nombre;
    private String apellido;
    private String rfc;

    public GestionProfesoresBeanUI() {
        this.profesorBeanHelper = new ProfesorBeanHelper();
    }

    public void registrarProfesor() {
        try {
            Profesor profesor = profesorBeanHelper.registrarProfesor(idProfesor, nombre, apellido, rfc);
            profesorBeanHelper.guardarProfesor(profesor);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Profesor registrado", "Profesor dado de alta exitosamente."));
            limpiarFormulario();
        } catch (IllegalArgumentException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error inesperado", "Ocurrió un error inesperado. Intente nuevamente."));
        }
    }

    public void limpiarFormulario() {
        this.idProfesor = 0;
        this.nombre = "";
        this.apellido = "";
        this.rfc = "";
    }

    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

}
