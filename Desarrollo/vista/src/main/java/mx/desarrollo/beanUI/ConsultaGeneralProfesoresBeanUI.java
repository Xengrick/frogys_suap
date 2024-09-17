/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.BeanUI;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.helper.ProfesorBeanHelper;

/**
 *
 * @author Usuario
 */

@ManagedBean(name = "consultaGeneralProfesoresBeanUI")
@RequestScoped
public class ConsultaGeneralProfesoresBeanUI {
    
    private ProfesorBeanHelper profesorBeanHelper;
    
    private List<Profesor> listaProfesores;
    
    private int idProfesor;
    private String nombre;
    private String apellido;
    private String rfc;

    @PostConstruct
    public void init() {
        obtenerTodosLosProfesores();
    }
    
    public ConsultaGeneralProfesoresBeanUI() {
        this.profesorBeanHelper = new ProfesorBeanHelper();
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
