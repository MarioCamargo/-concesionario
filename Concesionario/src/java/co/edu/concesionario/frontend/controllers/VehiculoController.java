
package co.edu.concesionario.frontend.controllers;

import co.edu.concesionario.backend.entities.Vehiculo;
import co.edu.concesionario.backend.facades.VehiculoFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Mario Camargo
 */
@ManagedBean
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

    @PostConstruct
    public void init(){
        this.getVehiculoList();
    }
    
    public String redirigir(){
        return "listarVehiculos.xhtml";
    }
}
