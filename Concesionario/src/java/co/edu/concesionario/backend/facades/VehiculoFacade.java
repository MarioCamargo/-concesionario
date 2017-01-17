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
    public Vehiculo listarCarros(int valor) {
        
        Vehiculo vehiculo = null;
        String consulta;
        try{
        consulta = "select v.placa, m.marca, v.modelo, concat('$ ',format(v.precio,0)), c.nombre, v.cantidad, t.tipo, format(v.kilometraje,0)"
                + "from vehiculos v join concesionarios c on v.concesionario=c.idConcesionario"
                + "join marcas m on v.marca=m.idMarca"
                + "join tipos t on v.tipo=t.idTipo"
                + "where v.precio>=?1 order by 4 desc";
        Query query = em.createQuery(consulta);
        query.setParameter(1, valor);
        List<Vehiculo> lista = query.getResultList();
            
        if (!lista.isEmpty()) {
                vehiculo = lista.get(0);
            }
            System.out.println(vehiculo);
        }catch(Exception e){
            e.getMessage();
        }
        return vehiculo;
       
    }
}
