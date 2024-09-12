/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import mx.desarrollo.entidad.Asignacion;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.integracion.ServiceFacadeLocator;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        
        usuario = ServiceFacadeLocator.getInstanceFacadeUsuario().login("admin","1234");
        
        if(usuario.getIdUsuario() != null){
            System.out.println("Login exitoso con el usuario " + usuario.getNombreUsuario());
        }else{
            System.out.println("No se encontro registro");
        }
        
        Asignacion asignacion = new Asignacion();
        asignacion = ServiceFacadeLocator.getInstanceFacadeAsignacion().registrarAsignacion(1, 1);
    }
}
