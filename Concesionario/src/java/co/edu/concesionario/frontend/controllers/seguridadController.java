/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.frontend.controllers;

import co.edu.concesionario.backend.entities.TipoUsuario;
import java.io.IOException;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Mario Camargo
 */
@Named(value = "seguridadController")
@ViewScoped
public class seguridadController implements Serializable {

    /**
     * Creates a new instance of seguridadController
     */
    public seguridadController() {
    }
    
    public void sesion(){
        
        try{
            FacesContext context = FacesContext.getCurrentInstance();
            TipoUsuario us = (TipoUsuario) context.getExternalContext().getSessionMap().get("Usuario");
            if (us==null) {
                context.getExternalContext().redirect("./../error.xhtml");
            }
        }catch(IOException e){
            e.getMessage();
        }
    }
}
