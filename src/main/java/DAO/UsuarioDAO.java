package DAO;

import gestion.datos.dao.ConexionBD;
import interfaces.usuarioService;
import gestion.datos.dao.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Leonardo Andres Gayon Espinel
 * @version 1.0
 */

public class UsuarioDAO implements usuarioService {
    public static final String SQL_CONSULTA = "SELECT tipoDocumento, numeroDocumento, nombre, apellido, email, telefono, password";

    public static final String SQL_INSERTAR = "INSERT INTO usuario VALUES (?,?,?,?,?,?,?)";

    public static final String SQL_ACTUALIZAR = "UPDATE usuario SET tipoDocumento = ?, numeroDocumento = ?," +
            " nombre =?, apellido =?, email = ?, telefono = ?, password = ?";

    public static final String SQL_ELIMINAR = "DELETE FROM usuario WHERE numeroDocuemto = ?";

    public static final String SQL_CONSULTAR_BY_ID = "SELECT tipoDocumento, numeroDocumento, nombre, apellido, email, telefono, password FROM mascotas WHERE numeroDocumento = ?";


    // consulta basica con BD SQL
    @Override
    public List<Usuario> consultar() {

        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet res = null;
        Usuario user = null;
        List<Usuario> mascotas = new ArrayList<>();
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_CONSULTA);
            res = stmt.executeQuery();
            while (res.next()) {
                String tipoDocumento = res.getString("tipo_Documento");
                String numeroDocumento = res.getString("numero_documento");
                String nombre = res.getString("nombre");
                String apellido = res.getString("apellido");
                String email = res.getString("email");
                String telefono = res.getString("telefono");
                String password = res.getString("contraseña");
                Usuario us = new Usuario(tipoDocumento, numeroDocumento, nombre, apellido, email, telefono, password);
                mascotas.add(us);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return mascotas;
    }


    // crea usuario tomando los datos
    @Override
    public int crear(Usuario mascota) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_INSERTAR);
            stmt.setString(1, mascota.getNumeroDocumento());
            stmt.setString(2, mascota.getNombre());
            stmt.setString(3, mascota.getApellido());
            stmt.setString(4, mascota.getEmail());
            stmt.setString(5, mascota.getTelefono());
            stmt.setString(6, mascota.getPassword());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }


    //metodo para actualizar datos para cada usuario
    @Override
    public int actualizar(Usuario mascota) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ACTUALIZAR);
            stmt.setString(1, mascota.getNombre());
            stmt.setString(2, mascota.getApellido());
            stmt.setString(3, mascota.getEmail());
            stmt.setString(4, mascota.getNumeroDocumento());
            stmt.setString(5, mascota.getTelefono());
            stmt.setString(6, mascota.getPassword());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }

        return registros;
    }

    @Override
    public int eliminar(Usuario user) {
        Connection con = null;
        PreparedStatement stmt = null;
        int registros = 0;
        try {
            con = ConexionBD.getConnection();
            stmt = con.prepareStatement(SQL_ELIMINAR);
            stmt.setString(1, user.getNumeroDocumento());
            registros = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            try {
                ConexionBD.close(stmt);
                ConexionBD.close(con);
            } catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return registros;
    }

    public Usuario encontrar(Usuario m) {
        Connection con = null;
        PreparedStatement sen = null;
        ResultSet res = null;
        try {
            con = ConexionBD.getConnection();
            sen = con.prepareStatement(SQL_CONSULTAR_BY_ID, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            sen.setString(1, m.getNumeroDocumento());
            res = sen.executeQuery();
            res.absolute(1);//primer registro devuelto
            String nombre = res.getString("nombre");
            String apellido = res.getString("fechanacimiento");
            String telefono = res.getString("telefono");
            String password = res.getString("contraseña");
            String documentoPropietario = res.getString("propietario_numerodocumento");
            m.setNombre(nombre);
            m.setApellido(apellido);
            m.setTelefono(telefono);
            m.setPassword(password);
        }
        catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        finally {
            try {
                ConexionBD.close(res);
                ConexionBD.close(sen);
                ConexionBD.close(con);
            }
            catch (SQLException ex) {
                ex.printStackTrace(System.out);
            }
        }
        return m;
    }
}
