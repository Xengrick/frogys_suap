/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.desarrollo.DAO.ProfesorDAO;
import mx.desarrollo.DAO.UsuarioDAO;
import mx.desarrollo.entidad.Usuario;
/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        ProfesorDAO profesorDAO = new ProfesorDAO();
        
        List<Usuario> listaUsuarios = new ArrayList();
        UsuarioDAO usuarioDao = new UsuarioDAO();
        listaUsuarios = usuarioDao.findAll();
        //Primer commit en Gustavo
        for(Usuario us : listaUsuarios){
            System.out.println("Correo: " + us.getNombreUsuario());
            System.out.println("Correo: " + us.getClave());
            System.out.println("Correo: " + us.getRol());
        }
    }
}
