
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
    
    public VehiculoController() {
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
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
    
    public String redireccionar(){
        return "listaVehiculos?faces-redirect=true";
    }
    
    public List<Vehiculo> listarVehiculos(){
        List<Vehiculo> lista = null;
        try{
            lista= vehiculoFacade.listarCarros(getValor());
            setValor(0);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return lista;
    }
}
