/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.Serializable;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.helper.RegistrarHelper;

/**
 *
 * @author Be
 */
public class RegistrarBeanUI implements Serializable{
    private RegistrarHelper registrarHelper = new RegistrarHelper();
    private UnidadAprendizaje unidadAprendizaje;
    
    public void setUnidadAprendizaje(String nombre,int horasClase,int horasTaller,int horasLaboratorio){
        unidadAprendizaje.setNombre(nombre);
        unidadAprendizaje.setHorasClase(horasClase);
        unidadAprendizaje.setHorasTaller(horasTaller);
        unidadAprendizaje.setHorasLaboratorio(horasLaboratorio);
    }
    
    public void registrarAprendizaje(){
        registrarHelper.registrarUnidadAprendizaje(unidadAprendizaje);
    }
}
