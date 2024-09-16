/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.helper;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.UnidadAprendizaje;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author Kevin
 */
public class LoginHelper implements Serializable{
    
    
    /**
     * Metodo para hacer login llamara a la instancia de usuarioFacade
     * @param correo
     * @param password
     * @return 
     */
   public Usuario Login(String clave, String nombreUsuario){
        return ServiceFacadeLocator.getInstanceFacadeUsuario().login(clave, nombreUsuario);
    }
    
    
    
}
