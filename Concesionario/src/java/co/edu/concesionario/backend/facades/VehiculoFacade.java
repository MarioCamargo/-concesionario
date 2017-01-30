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
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public List<Vehiculo> listarCarros(int valor) {
        List<Vehiculo> vehiculo = null;
        String consulta;
        try {
            consulta = "select v.idVehiculo, v.placa, v.modelo, v.precio, v.cantidad, v.kilometraje, v.concesionario, v.marca, v.tipo "
                    + "from vehiculos v join concesionarios c on v.concesionario=c.idConcesionario "
                    + "join marcas m on v.marca=m.idMarca "
                    + "join tipos t on v.tipo=t.idTipo "
                    + "join tiposusuario tu on tu.idTipo=c.idConcesionario "
                    + "where v.precio>=? "
                    + "order by v.precio";
            Query query = em.createNativeQuery(consulta, Vehiculo.class);
            query.setParameter(1, valor);
            
            if (query.getResultList().size()>0) {
                vehiculo= query.getResultList();
            } else  {
                return null;
            }
        } catch (Exception e) {
            
        }
        return vehiculo;
    }
}
