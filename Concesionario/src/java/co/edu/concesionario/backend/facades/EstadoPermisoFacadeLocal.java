/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.backend.facades;

import co.edu.concesionario.backend.entities.EstadoPermiso;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mario Camargo
 */
@Local
public interface EstadoPermisoFacadeLocal {

    void create(EstadoPermiso estadoPermiso);

    void edit(EstadoPermiso estadoPermiso);

    void remove(EstadoPermiso estadoPermiso);

    EstadoPermiso find(Object id);

    List<EstadoPermiso> findAll();

    List<EstadoPermiso> findRange(int[] range);

    int count();
    
}
