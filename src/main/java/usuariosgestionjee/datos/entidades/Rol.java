/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.ufps.usuariosgestionjee.datos.entidades;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author freve
 */
@Entity
@Table(name="rol")
public class Rol implements Serializable{
    
    @Id
    @Column(name="name")
    @NotNull
    private Integer id;
    
    @Column(name="nombre")
    @NotNull
    private String nombre;
    
    @Column(name="descripcion")
    private String descripcion;
    
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private List<Rol> usuarios;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_rol", referencedColumnName = "id")
    private TipoRol tipoRol;

    public Rol() {
        id=0; 
        nombre="";
        descripcion="";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Rol> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<Rol> usuarios) {
        this.usuarios = usuarios;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rol other = (Rol) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Rol{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + '}';
    }
    
    
    
    
}
