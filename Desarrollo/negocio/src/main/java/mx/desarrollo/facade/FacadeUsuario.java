/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.facade;

import mx.desarrollo.delegate.DelegateUsuario;
import mx.desarrollo.entidad.Usuario;

/**
 *
 * @author EduardoCardona <>
 */
public class FacadeUsuario {
    
    private final DelegateUsuario delegateUsuario;

    public FacadeUsuario() {
        this.delegateUsuario = new DelegateUsuario();
    }
    
     /**
     * Metodo para verificar si el usuario esta registrado en la bd
     * @param password 
     * @param correo
     * @return Regresa usuario si el correo y contrasena con correctos
     */
    public Usuario login(String password, String correo){
        return delegateUsuario.login(password, correo);
    }
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public void saveUsario(Usuario usuario){
        delegateUsuario.saveUsario(usuario);
    }
    
}
