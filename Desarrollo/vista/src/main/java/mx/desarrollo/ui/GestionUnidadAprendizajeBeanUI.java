/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.Serializable;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.helper.UnidadAprendizajeBeanHelper;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author Usuario
 */
@ManagedBean(name = "gestionUnidadAprendizajeBeanUI")
@SessionScoped
public class GestionUnidadAprendizajeBeanUI implements Serializable {

    private UnidadAprendizajeBeanHelper unidadAprendizajeBeanHelper;

    private int idUnidadAprendizaje;
    private String nombre;
    private int horasClase;
    private int horasTaller;
    private int horasLaboratorio;

    public GestionUnidadAprendizajeBeanUI() {
        unidadAprendizajeBeanHelper = new UnidadAprendizajeBeanHelper();
    }

    public void registrarAprendizaje() {
        Unidadaprendizaje unidadAprendizaje = unidadAprendizajeBeanHelper.registrarUnidadAprendizaje(idUnidadAprendizaje, nombre, nombre, nombre, nombre);
        unidadAprendizajeBeanHelper.guardarUnidadAprendizaje(unidadAprendizaje);
        limpiarFormulario();
    }
    
    public void limpiarFormulario() {
        this.idUnidadAprendizaje = 0;
        this.nombre = "";
        this.horasClase = 0;
        this.horasLaboratorio = 0;
        this.horasTaller = 0;
    }

    public int getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(int idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }
    
}
