/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateAlumno;
import mx.desarrollo.entidad.Alumno;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeAlumno {
    
    private final DelegateAlumno delegateAlumno;

    public FacadeAlumno() {
        this.delegateAlumno = new DelegateAlumno();
    }
    
    public void guardarAlumno(Alumno alumno){
        delegateAlumno.saveAlumno(alumno);
    }
    
}
