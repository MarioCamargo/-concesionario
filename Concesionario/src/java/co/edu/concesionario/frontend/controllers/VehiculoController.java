/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.frontend.controllers;

import co.edu.concesionario.backend.entities.Vehiculo;
import co.edu.concesionario.backend.facades.VehiculoFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;

/**
 *
 * @author Mario Camargo
 */
@Named(value = "vehiculoController")
@SessionScoped
public class VehiculoController implements Serializable {

    @EJB
    private VehiculoFacadeLocal vehiculoFacade;
    private int valor;
    private List <Vehiculo> vehiculoList;
    private List <Vehiculo> vehiculoListar;
    
    public VehiculoController() {
    }

    public List<Vehiculo> getVehiculoListar() {
        vehiculoListar=vehiculoFacade.findAll();
        return vehiculoListar;
    }

    public void setVehiculoListar(List<Vehiculo> vehiculoListar) {
        this.vehiculoListar = vehiculoListar;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    

    public List<Vehiculo> getVehiculoList() {
        vehiculoList = (List<Vehiculo>) vehiculoFacade.listarCarros(getValor());
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    public String redirigir(){
        return "listarVehiculos.xhtml";
    }
}
