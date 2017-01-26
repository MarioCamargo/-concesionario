 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.frontend.controllers;


import co.edu.concesionario.backend.entities.Cliente;
import co.edu.concesionario.backend.entities.Concesionario;
import co.edu.concesionario.backend.entities.TipoUsuario;
import co.edu.concesionario.backend.facades.TipoUsuarioFacadeLocal;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author SENA
 */
@Named(value = "iniciarSesionController")
@RequestScoped
public class IniciarSesionController implements Serializable {

    @EJB
    private TipoUsuarioFacadeLocal usuarioFacade;
    private TipoUsuario usuario;
    private Cliente cliente;
    private Concesionario concesionario;
    private String seleccion;
    
    public IniciarSesionController() {
    }

    public String getSeleccion() {
        return seleccion;
    }

    public void setSeleccion(String seleccion) {
        this.seleccion = seleccion;
    }
    
    public TipoUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(TipoUsuario usuario) {
        this.usuario = usuario;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Concesionario getConcesionario() {
        return concesionario;
    }

    public void setConcesionario(Concesionario concesionario) {
        this.concesionario = concesionario;
    }
    
    @PostConstruct
    public void init() {
        usuario = new TipoUsuario();
        cliente = new Cliente();
        concesionario = new Concesionario();
    }
    
    public String iniciarSesion() {
        TipoUsuario us;

        String redireccionar = null;
        FacesContext context = FacesContext.getCurrentInstance();
        try {
            switch (seleccion) {
                case "Cl":
                    usuario.setCliente(cliente);
                    break;
                case "Co":
                    concesionario.setNit(cliente.getCedula());
                    usuario.setConcesionario(concesionario);
                    break;
            }
            us = usuarioFacade.validarUsuarioRegistrado(usuario,seleccion);
            if (us!=null) {                
                 context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Bienvenido"));
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("Usuario", us.getNombre());
                 redireccionar="consultarVehiculos.xhtml";
            } else {   
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Usuario incorrecto"));
            }
        } catch (Exception e) {
           
              context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error",""+e.getMessage()));
        }
        return redireccionar;
    }
    
    public List<TipoUsuario> listarUsuario(){
        List<TipoUsuario> lista = null;
        try{
            lista= usuarioFacade.listarUsuarios(usuario);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
