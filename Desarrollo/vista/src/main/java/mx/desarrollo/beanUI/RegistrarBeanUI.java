/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.beanUI;

import java.io.Serializable;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.helper.RegistrarHelper;

/**
 *
 * @author Be
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean(name = "RegistrarBeanUI")
@SessionScoped
public class RegistrarBeanUI implements Serializable {
    private Unidadaprendizaje unidadAprendizaje = new Unidadaprendizaje();
    private RegistrarHelper registrarHelper = new RegistrarHelper();

    public Unidadaprendizaje getUnidadAprendizaje() {
        return unidadAprendizaje;
    }

    public void setUnidadAprendizaje(Unidadaprendizaje unidadAprendizaje) {
        this.unidadAprendizaje = unidadAprendizaje;
    }

    public void registrarAprendizaje() {
        registrarHelper.registrarUnidadAprendizaje(unidadAprendizaje);
    }
}
