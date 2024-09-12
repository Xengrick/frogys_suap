/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.integracion;

//import mx.desarrollo.facade.FacadeAlumno;
import mx.desarrollo.facade.FacadeAsignacion;
import mx.desarrollo.facade.FacadeProfesor;
import mx.desarrollo.facade.FacadeUnidadAprendizaje;
import mx.desarrollo.facade.FacadeUsuario;


public class ServiceFacadeLocator {
    
    private static FacadeUsuario facadeUsuario;
    private static FacadeUnidadAprendizaje facadeUnidadAprendizaje;

    public static FacadeUnidadAprendizaje getInstanceFacadeUnidadAprendizaje() {
    if (facadeUnidadAprendizaje == null) {
        facadeUnidadAprendizaje = new FacadeUnidadAprendizaje();
    }
    return facadeUnidadAprendizaje;
}


    public static FacadeUsuario getInstanceFacadeUsuario() {
        if (facadeUsuario == null) {
            facadeUsuario = new FacadeUsuario();
            return facadeUsuario;
        } else {
            return facadeUsuario;
        }
    }
}
