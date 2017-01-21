/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.backend.facades;

import co.edu.concesionario.backend.entities.TipoUsuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Mario Camargo
 */
@Local
public interface TipoUsuarioFacadeLocal {

    void create(TipoUsuario tipoUsuario);

    void edit(TipoUsuario tipoUsuario);

    void remove(TipoUsuario tipoUsuario);

    TipoUsuario find(Object id);

    List<TipoUsuario> findAll();

    List<TipoUsuario> findRange(int[] range);
    
    List<TipoUsuario> listarUsuarios(TipoUsuario tu);
    
    TipoUsuario validarUsuarioRegistrado(TipoUsuario us);

    int count();
    
}
