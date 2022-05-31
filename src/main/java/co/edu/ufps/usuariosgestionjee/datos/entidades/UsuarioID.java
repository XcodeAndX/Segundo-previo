package co.edu.ufps.usuariosgestionjee.datos.entidades;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Fredy Vera
 */
@Embeddable
public class UsuarioID {
    
    @Column(name="tipo_documento")
    private String tipoDocumento;
    
    @Column(name="numero_documento")
    private String numeroDocumento;

    public UsuarioID() {
        super();
        tipoDocumento="";
        numeroDocumento="";
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final UsuarioID other = (UsuarioID) obj;
        if (!Objects.equals(this.tipoDocumento, other.tipoDocumento)) {
            return false;
        }
        return Objects.equals(this.numeroDocumento, other.numeroDocumento);
    }

    @Override
    public String toString() {
        return "UsuarioID{" + "tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + '}';
    }
    
    
    
    
}
