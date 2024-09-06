/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import java.util.List;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.integracion.ServiceLocator;

/**
 *
 * @author EduardoCardona <>
 */
public class DelegateUsuario {
    
    /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
     * @return un tipo usuario si no encuntra el usuario sera null
     */
    public Usuario login(String password, String correo){
        Usuario usuario = new Usuario();
        List<Usuario> usuarios = ServiceLocator.getInstanceUsuarioDAO().findAll();
        
        for(Usuario us:usuarios){
            if(us.getContrasena().equalsIgnoreCase(password) && us.getCorreo().equalsIgnoreCase(correo)){
                usuario = us;
            }
        }
        return usuario;
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Usuario usuario){
        ServiceLocator.getInstanceUsuarioDAO().save(usuario);
    }
    
}
