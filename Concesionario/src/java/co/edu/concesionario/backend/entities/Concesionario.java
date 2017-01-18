/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.concesionario.backend.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mario Camargo
 */
@Entity
@Table(name = "concesionarios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concesionario.findAll", query = "SELECT c FROM Concesionario c")
    , @NamedQuery(name = "Concesionario.findByIdConcesionario", query = "SELECT c FROM Concesionario c WHERE c.idConcesionario = :idConcesionario")
    , @NamedQuery(name = "Concesionario.findByNit", query = "SELECT c FROM Concesionario c WHERE c.nit = :nit")})
public class Concesionario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idConcesionario")
    private Integer idConcesionario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nit")
    private int nit;
    @JoinColumn(name = "idConcesionario", referencedColumnName = "idTipo", insertable = false, updatable = false)
    @OneToOne(optional = false, fetch = FetchType.LAZY)
    private TipoUsuario tipoUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "concesionario", fetch = FetchType.LAZY)
    private List<Vehiculo> vehiculoList;

    public Concesionario() {
    }

    public Concesionario(Integer idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public Concesionario(Integer idConcesionario, int nit) {
        this.idConcesionario = idConcesionario;
        this.nit = nit;
    }

    public Integer getIdConcesionario() {
        return idConcesionario;
    }

    public void setIdConcesionario(Integer idConcesionario) {
        this.idConcesionario = idConcesionario;
    }

    public int getNit() {
        return nit;
    }

    public void setNit(int nit) {
        this.nit = nit;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @XmlTransient
    public List<Vehiculo> getVehiculoList() {
        return vehiculoList;
    }

    public void setVehiculoList(List<Vehiculo> vehiculoList) {
        this.vehiculoList = vehiculoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idConcesionario != null ? idConcesionario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concesionario)) {
            return false;
        }
        Concesionario other = (Concesionario) object;
        if ((this.idConcesionario == null && other.idConcesionario != null) || (this.idConcesionario != null && !this.idConcesionario.equals(other.idConcesionario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.concesionario.backend.entities.Concesionario[ idConcesionario=" + idConcesionario + " ]";
    }
    
}
