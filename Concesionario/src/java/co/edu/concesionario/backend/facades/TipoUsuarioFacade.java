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
    public TipoUsuario validarUsuarioRegistrado(TipoUsuario us) {
        TipoUsuario usuario = null;
        String consulta;
        try{
            consulta = "select * FROM tiposusuario WHERE nombre =? and contrasena =?";
            Query query = em.createNativeQuery(consulta, TipoUsuario.class);
            query.setParameter(1, us.getNombre());
            query.setParameter(2, us.getContrasena());
            List<TipoUsuario> lista = query.getResultList();
            if (lista.size()>0) {
                usuario= lista.get(0);
            } else  {
                return null;
            }
//            List<TipoUsuario> lista = query.getResultList();
//            
//            if (!lista.isEmpty()) {
//                usuario = lista.get(0);
//            } else {
//                System.out.println("no se encontraron datos");
//            }
//            System.out.println(usuario);
        }catch(Exception e){
            e.getMessage();
        }
        return usuario;
    }
    
    @Override
    public List<TipoUsuario> listarUsuarios(TipoUsuario tu) {
        List<TipoUsuario> usuario = null;
        String consulta;
        try {
            consulta = "select * FROM tiposusuario WHERE nombre =? and contrasena =?";
            Query query = em.createNativeQuery(consulta, TipoUsuario.class);
            query.setParameter(1, tu.getNombre());
            query.setParameter(2, tu.getContrasena());
            if (query.getResultList().size()>0) {
                usuario=query.getResultList();
            } else  {
                return null;
            }
        } catch (Exception e) {
            
        }
        return usuario;
    }
}
