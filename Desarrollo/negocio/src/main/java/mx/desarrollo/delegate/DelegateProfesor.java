/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.delegate;

import mx.desarrollo.entidad.Profesor;
import mx.desarrollo.integracion.ServiceLocator;
/**
 *
 * @author Usuario
 */
public class DelegateProfesor {
    
    public Profesor registrarProfesor(String nombre, String apellido, String rfc) {
        Profesor profesor = new Profesor();

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        
        // Validación de apellido
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        
        // Validación de RFC
        if (rfc == null || rfc.length() != 13) {
            throw new IllegalArgumentException("El RFC debe tener exactamente 13 caracteres.");
        }
        
        // Validar formato del RFC (opcional, esto es solo un ejemplo básico)
        if (!rfc.matches("[A-ZÑ&]{4}[0-9]{6}[A-Z0-9]{3}")) {
            throw new IllegalArgumentException("El formato del RFC no es válido.");
        }
        
        if (!nombre.equals(profesor.getNombre()) && !apellido.equals(profesor.getApellido())){
            throw new IllegalArgumentException("El nombre y el apellido no pueden ser igual a no ya guardado");
        }
        
        if (!rfc.equals(profesor.getRfc())){
            throw new IllegalArgumentException("El RFC no puede ser igual a uno ya guardado");
        }
        
        //Profesor profesor = new Profesor();
        profesor.setNombre(nombre);
        profesor.setApellido(apellido);
        profesor.setRfc(rfc);
        
        return profesor;
    }
    
    /**
     * Metodo de ejemplo para guardar Profesor
     * @param profesor de tipo usuario con id 0 para que se cree un id nuevo
     */
    public void guardarProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }
    
}
