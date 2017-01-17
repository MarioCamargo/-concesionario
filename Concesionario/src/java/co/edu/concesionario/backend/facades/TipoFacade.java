/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.backend.facades;

import co.edu.concesionario.backend.entities.Tipo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Mario Camargo
 */
@Stateless
public class TipoFacade extends AbstractFacade<Tipo> implements TipoFacadeLocal {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoFacade() {
        super(Tipo.class);
    }
    
}
