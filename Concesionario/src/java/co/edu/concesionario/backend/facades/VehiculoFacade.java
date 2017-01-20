/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.backend.facades;

import co.edu.concesionario.backend.entities.Vehiculo;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

/**
 *
 * @author Mario Camargo
 */
@Stateless
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "ConcesionarioPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    @Override
    public void listarCarros(int valor) {
        List<Vehiculo> vehiculo = null;
        String consulta;
        try {
            StoredProcedureQuery procedimiento = em.createStoredProcedureQuery("mostrarPrecios");
            procedimiento.registerStoredProcedureParameter("var", Integer.class, ParameterMode.IN);
            procedimiento.setParameter("var", valor);
            procedimiento.execute();
//            consulta = "from vehiculos v join concesionarios c on v.concesionario=c.idConcesionario "
//                    + "join marcas m on v.marca=m.idMarca "
//                    + "join tipos t on v.tipo=t.idTipo "
//                    + "join tiposusuario tu on tu.idTipo=c.idConcesionario "
//                    + "where v.precio>=80000000 "
//                    + "order by v.precio";
//            TypedQuery<Vehiculo> query = (TypedQuery<Vehiculo>) em.createNativeQuery(consulta, Vehiculo.class);
//
//            if (query.getResultList().size()>0) {
//                return query.getResultList();
//            } else  {
//                return null;
//            }
        } catch (Exception e) {
            
        }
        
    }

}
