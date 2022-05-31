package gestion.datos.dao;

import java.util.Objects;

public class opcionMenu {

    int id;
    String nombre;
    String url;
    String icono;

    public opcionMenu(int id, String nombre, String url, String icono) {
        this.id = id;
        this.nombre = nombre;
        this.url = url;
        this.icono = icono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public String toString() {
        return "opcionMenu{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", url='" + url + '\'' +
                ", icono='" + icono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        opcionMenu that = (opcionMenu) o;
        return getId() == that.getId() && getNombre().equals(that.getNombre()) && getUrl().equals(that.getUrl()) &&
                getIcono().equals(that.getIcono());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNombre(), getUrl(), getIcono());
    }
}
