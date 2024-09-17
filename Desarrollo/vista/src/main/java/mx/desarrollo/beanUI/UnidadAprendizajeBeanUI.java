/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.beanUI;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mx.desarrollo.entidad.Unidadaprendizaje;
import mx.desarrollo.helper.UnidadAprendizajeBeanHelper;

@ManagedBean(name = "unidadAprendizajeBeanUI")
@RequestScoped
/**
 *
 * @author Usuario
 */
public class UnidadAprendizajeBeanUI implements Serializable {
    
    private UnidadAprendizajeBeanHelper unidadAprendizajeBeanHelper = new UnidadAprendizajeBeanHelper();
    private List<Unidadaprendizaje> listaUnidadesAprendizaje;

    @PostConstruct
    public void init() {
        obtenerUnidadesDeAprendizaje();
    }

    public List<Unidadaprendizaje> getListaUnidadesAprendizaje() {
        return listaUnidadesAprendizaje;
    }
    
    public void obtenerUnidadesDeAprendizaje() {
        listaUnidadesAprendizaje = unidadAprendizajeBeanHelper.getUnidadesAprendizaje();
    }
}
