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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Mario Camargo
 */
@Entity
@Table(name = "estadopermisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EstadoPermiso.findAll", query = "SELECT e FROM EstadoPermiso e")
    , @NamedQuery(name = "EstadoPermiso.findByIdEstadoPermiso", query = "SELECT e FROM EstadoPermiso e WHERE e.idEstadoPermiso = :idEstadoPermiso")
    , @NamedQuery(name = "EstadoPermiso.findByEstado", query = "SELECT e FROM EstadoPermiso e WHERE e.estado = :estado")})
public class EstadoPermiso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEstadoPermiso")
    private Integer idEstadoPermiso;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado", fetch = FetchType.LAZY)
    private List<Permiso> permisoList;

    public EstadoPermiso() {
    }

    public EstadoPermiso(Integer idEstadoPermiso) {
        this.idEstadoPermiso = idEstadoPermiso;
    }

    public EstadoPermiso(Integer idEstadoPermiso, String estado) {
        this.idEstadoPermiso = idEstadoPermiso;
        this.estado = estado;
    }

    public Integer getIdEstadoPermiso() {
        return idEstadoPermiso;
    }

    public void setIdEstadoPermiso(Integer idEstadoPermiso) {
        this.idEstadoPermiso = idEstadoPermiso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Permiso> getPermisoList() {
        return permisoList;
    }

    public void setPermisoList(List<Permiso> permisoList) {
        this.permisoList = permisoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoPermiso != null ? idEstadoPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoPermiso)) {
            return false;
        }
        EstadoPermiso other = (EstadoPermiso) object;
        if ((this.idEstadoPermiso == null && other.idEstadoPermiso != null) || (this.idEstadoPermiso != null && !this.idEstadoPermiso.equals(other.idEstadoPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.concesionario.backend.entities.EstadoPermiso[ idEstadoPermiso=" + idEstadoPermiso + " ]";
    }
    
}
