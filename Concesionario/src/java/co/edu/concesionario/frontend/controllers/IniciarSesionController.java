/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.frontend.controllers;

import co.edu.concesionario.backend.entities.TipoUsuario;
import co.edu.concesionario.backend.facades.TipoUsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;

/**
 *
 * @author SENA
 */
@Named(value = "iniciarSesionControlador")
@ViewScoped
public class IniciarSesionController implements Serializable { //agregar serializable

    @EJB
    private TipoUsuarioFacadeLocal usuarioFacade;
    private TipoUsuario usuario;
    
    public IniciarSesionController() {
    }
     
    @PostConstruct          //AGREGAR UN POSTCONSTRUCT
    public void init() {
        usuario = new TipoUsuario();
    }

    public TipoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TipoUsuario usuario) {
        this.usuario = usuario;
    }

    public String iniciarSesion() {
//        Usuario usuarioR;
        TipoUsuario us;

        String redireccionar = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            us = usuarioFacade.validarUsuarioRegistrado(usuario);
            if (us != null) {
                //Almacenar en la sesión de JSF//                
                 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Bienvenido"));
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", us);
                 context.getExternalContext().redirect("consultarVehiculos.xhtml");
            } else {   
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario incorrecto"));
            }
        } catch (Exception e) {
           
              context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",""+e.getMessage()));
        }
        return redireccionar;
    }
}
