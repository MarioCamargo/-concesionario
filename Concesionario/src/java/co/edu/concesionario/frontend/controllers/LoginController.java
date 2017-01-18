/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.frontend.controllers;

import co.edu.concesionario.backend.entities.TipoUsuario;
import co.edu.concesionario.backend.facades.TipoUsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mario Camargo
 */
@Named(value = "loginController")
@SessionScoped
public class LoginController implements Serializable {

    private String tipoIden;
 
    @EJB
    private TipoUsuarioFacadeLocal usuarioFacade;
    private TipoUsuario usuario;
     
    public LoginController() {
    } 
    
    public String getTipoIden() {
        return tipoIden;
    }

    public void setTipoIden(String tipoIden) {
        this.tipoIden = tipoIden;
    }

    public TipoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TipoUsuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init() {
        usuario = new TipoUsuario();
    }
    
    public String iniciarSesion() {

        String redireccionar = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            usuarioFacade.iniciarSesion(usuario);
            
            redireccionar = "lista";
        } catch (Exception e) {
           
              context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",""+e.getMessage()));
        }
        return redireccionar;
    }
}
