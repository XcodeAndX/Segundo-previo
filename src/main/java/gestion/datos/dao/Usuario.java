package gestion.datos.dao;

import java.util.Objects;

public class Usuario {

    String tipoDocumento;
    String numeroDocumento;
    String nombre;
    String apellido;
    String email;
    String telefono;
    String password;

    public Usuario(String tipoDocumento, String numeroDocumento, String nombre, String apellido, String email, String telefono, String password) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.password = password;
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
    public String toString() {
        return "Usuario{" +
                "tipoDocumento='" + tipoDocumento + '\'' +
                ", numeroDocumento='" + numeroDocumento + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return getTipoDocumento().equals(usuario.getTipoDocumento()) && getNumeroDocumento().equals(usuario.getNumeroDocumento())
                && getNombre().equals(usuario.getNombre()) && getApellido().equals(usuario.getApellido()) &&
                getEmail().equals(usuario.getEmail()) && getTelefono().equals(usuario.getTelefono()) &&
                getPassword().equals(usuario.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoDocumento(), getNumeroDocumento(), getNombre(), getApellido(), getEmail(), getTelefono(),
                getPassword());
    }
}
