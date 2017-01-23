/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.frontend.controllers;

import co.edu.concesionario.backend.entities.Vehiculo;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

@ManagedBean
public class Exportar implements Serializable {

    /**
     * Creates a new instance of Exportar
     */
    public Exportar() {
    }
    
    private List<Vehiculo> vehiculo;
         
//    @ManagedProperty("#{vehiculoEx}")
//    private CarService service;
//     
//    @PostConstruct
//    public void init() {
//        cars = service.createCars(100);
//    }
// 
//    public List<Car> getCars() {
//        return cars;
//    }
// 
//    public void setService(CarService service) {
//        this.service = service;
//    }
}
