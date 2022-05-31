package interfaces;

import gestion.datos.dao.opcionMenu;
import gestion.datos.dao.rol;

import java.util.List;

public interface menuService {
    public List<opcionMenu> consultar();
    public int crear(opcionMenu opcionDTO);
    public int actualizar(opcionMenu opcionDTO);
    public int eliminar(opcionMenu opcionDTO);
}
