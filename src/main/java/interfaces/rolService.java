package interfaces;

import gestion.datos.dao.rol;

import java.util.List;

public interface rolService {
    public List<rol> consultar();
    public int crear(rol rolDTO);
    public int actualizar(rol rolDTO);
    public int eliminar(rol rolDTO);
}
