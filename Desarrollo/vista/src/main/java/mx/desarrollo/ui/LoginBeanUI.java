/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.ui;

import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.desarrollo.entidad.Usuario;
import mx.desarrollo.helper.LoginHelper;

/**
 *
 * @author Kevin
 */
@ManagedBean(name = "loginUI")
@SessionScoped
public class LoginBeanUI implements Serializable {

    private LoginHelper loginHelper;
    private Usuario usuario;

    public LoginBeanUI() {
        loginHelper = new LoginHelper();
    }

    /**
     * Método postconstructor, todo lo que esté dentro de este método será lo
     * primero que haga cuando cargue la página.
     */
    @PostConstruct
    public void init() {
        usuario = new Usuario();
    }

    public void login() throws IOException {
        String appURL = "index.xhtml";

        // Log para verificar los datos que está recibiendo
        System.out.println("Usuario a buscar: " + usuario.getNombreUsuario());
        System.out.println("Usuario a buscar: " + usuario.getClave());
        // Validación de usuario con el helper
        Usuario us = loginHelper.Login(usuario.getNombreUsuario(), usuario.getClave());

        // Si se encuentra el usuario, redirige a la página principal
        if (us != null && us.getIdUsuario() != null) {
            System.out.println("Usuario recuperado: " + us.getNombreUsuario());
            usuario = us; // Asigna el usuario recuperado
            FacesContext.getCurrentInstance().getExternalContext().redirect(appURL);
        } else {
            // Si no se encuentra, muestra el mensaje de error
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuario o contraseña incorrecta:", "Intente de nuevo"));
        }
    }

    /* Getters y setters */
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
