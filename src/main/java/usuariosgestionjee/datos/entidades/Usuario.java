
package co.edu.ufps.usuariosgestionjee.datos.entidades;

import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;  
import javax.validation.constraints.NotNull;

/**
 *
 * @author Fredy Vera
 */

@Entity
@Table(name = "usuario")
public class Usuario {
    
    @EmbeddedId
    private UsuarioID usuarioID;
    
    @Column(name = "nombre")
    @NotNull
    private String nombre;
    
    @Column(name = "apellido")
    @NotNull
    private String apellido;
    
    @Column(name = "email")
    @NotNull
    private String email;
    
    @Column(name = "telefono")
    private String telefono;
    
    @Column(name = "pasword")
    @NotNull
    private String password;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="usuario_rol",
            joinColumns = {@JoinColumn(name="tipo_documento"), @JoinColumn(name="numero_documento")},
            inverseJoinColumns = @JoinColumn(name="id_rol")            
    )
    private List<Rol> roles;
    

    public Usuario() {
        super();
        usuarioID= new UsuarioID();
        nombre="";
        apellido="";
        email = "";
        telefono = "";
        password="";
    }

    public UsuarioID getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(UsuarioID usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.usuarioID);
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
        final Usuario other = (Usuario) obj;
        return Objects.equals(this.usuarioID, other.usuarioID);
    }

    @Override
    public String toString() {
        return "Usuario{" + "usuarioID=" + usuarioID + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }
        
}
