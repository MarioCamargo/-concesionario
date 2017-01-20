/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.backend.facades;

import co.edu.concesionario.backend.entities.TipoUsuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Mario Camargo
 */
@Stateless
public class TipoUsuarioFacade extends AbstractFacade<TipoUsuario> implements TipoUsuarioFacadeLocal {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoUsuarioFacade() {
        super(TipoUsuario.class);
    }
    
    @Override
    public TipoUsuario  iniciarSesion(TipoUsuario tu){
        TipoUsuario usuario = null;
        String consulta;
        try{
            consulta = "from tiposusuario u where u.nombre=?1 and u.contrasena=?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, tu.getNombre());
            query.setParameter(2, tu.getContrasena());
            List <TipoUsuario> lista = query.getResultList();
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
            
        }catch(Exception e){
            throw e;
        }
        return usuario;
    }
    
    @Override
    public TipoUsuario validarUsuarioRegistrado(TipoUsuario us) {
        TipoUsuario usuario = null;
        String consulta;
        try{
            consulta = "FROM tiposusuario  WHERE nombre =?1 and contrasena = ?2";
            Query query = em.createQuery(consulta);
            query.setParameter(1, us.getNombre());
            query.setParameter(2, us.getContrasena());
            
            List<TipoUsuario> lista = query.getResultList();
            
            if (!lista.isEmpty()) {
                usuario = lista.get(0);
            }
            System.out.println(usuario);
        }catch(Exception e){
            e.getMessage();
        }
        return usuario;
    }
}
