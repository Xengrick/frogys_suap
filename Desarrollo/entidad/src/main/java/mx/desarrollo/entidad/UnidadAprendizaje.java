/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.desarrollo.entidad;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Be
 */
@Entity
@Table(name = "unidadaprendizaje")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidadaprendizaje.findAll", query = "SELECT u FROM Unidadaprendizaje u")
    , @NamedQuery(name = "Unidadaprendizaje.findByIdUnidadAprendizaje", query = "SELECT u FROM Unidadaprendizaje u WHERE u.idUnidadAprendizaje = :idUnidadAprendizaje")
    , @NamedQuery(name = "Unidadaprendizaje.findByNombre", query = "SELECT u FROM Unidadaprendizaje u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasClase", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasTaller", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "Unidadaprendizaje.findByHorasLaboratorio", query = "SELECT u FROM Unidadaprendizaje u WHERE u.horasLaboratorio = :horasLaboratorio")})
public class Unidadaprendizaje implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidadAprendizaje")
    private Integer idUnidadAprendizaje;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "horasClase")
    private int horasClase;
    @Basic(optional = false)
    @Column(name = "horasTaller")
    private int horasTaller;
    @Basic(optional = false)
    @Column(name = "horasLaboratorio")
    private int horasLaboratorio;

    public Unidadaprendizaje() {
    }

    public Unidadaprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public Unidadaprendizaje(Integer idUnidadAprendizaje, String nombre, int horasClase, int horasTaller, int horasLaboratorio) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
        this.nombre = nombre;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLaboratorio = horasLaboratorio;
    }

    public Integer getIdUnidadAprendizaje() {
        return idUnidadAprendizaje;
    }

    public void setIdUnidadAprendizaje(Integer idUnidadAprendizaje) {
        this.idUnidadAprendizaje = idUnidadAprendizaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLaboratorio() {
        return horasLaboratorio;
    }

    public void setHorasLaboratorio(int horasLaboratorio) {
        this.horasLaboratorio = horasLaboratorio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidadAprendizaje != null ? idUnidadAprendizaje.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidadaprendizaje)) {
            return false;
        }
        Unidadaprendizaje other = (Unidadaprendizaje) object;
        if ((this.idUnidadAprendizaje == null && other.idUnidadAprendizaje != null) || (this.idUnidadAprendizaje != null && !this.idUnidadAprendizaje.equals(other.idUnidadAprendizaje))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mx.desarrollo.entidad.Unidadaprendizaje[ idUnidadAprendizaje=" + idUnidadAprendizaje + " ]";
    }
    
}
