package interfaces;

import gestion.datos.dao.Usuario;

import java.util.List;

public interface usuarioService {
    public List<Usuario> consultar();
    public int crear(Usuario UsuarioDTO);
    public int actualizar(Usuario UsuarioDTO);
    public int eliminar(Usuario UsuarioDTO);
}
