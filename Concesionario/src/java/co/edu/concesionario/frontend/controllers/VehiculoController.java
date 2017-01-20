
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
    private Vehiculo vehiculo;
    private List <Vehiculo> vehiculoList;
    private List <Vehiculo> vehiculoListar;
    
    public VehiculoController() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public List<Vehiculo> getVehiculoListar() {
        vehiculoListar = vehiculoFacade.findAll();
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

    @PostConstruct
    public void init(){
        vehiculo = new Vehiculo();
    }
    
    public String redirigir(){
        return "listarVehiculos.xhtml";
    }
    
    public List<Vehiculo> listarVehiculos(){
        List<Vehiculo> lista = null;
        try{
            vehiculoFacade.listarCarros(getValor());
            setValor(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
