/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.helper.ProfesorBeanHelper;

@ManagedBean(name = "profesorBeanUI")
@RequestScoped
/**
 *
 * @author Usuario
 */
public class ProfesorBeanUI implements Serializable{
    
    private ProfesorBeanHelper profesorBeanHelper = new ProfesorBeanHelper();
    private List<Profesor> listaProfesores;
    
   @PostConstruct
    public void init() {
        obtenerTodosLosProfesores();  
    }

    public List<Profesor> getListaProfesores() {
        return listaProfesores;
    }
    
    public void obtenerTodosLosProfesores(){
        listaProfesores = profesorBeanHelper.getProfesores();
    }
    
}
