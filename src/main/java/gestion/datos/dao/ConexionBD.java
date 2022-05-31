package gestion.datos.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;



public class ConexionBD {

    public static final String JDBC_URL = "";
    public static final String BD_USUARIO = "usuario";
    public static final String BD_CLAVE = "usuario";

    

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getDataSource().getConnection();
    }

    public static void close(Connection con) throws SQLException {
        con.close();

    }

    public static void close(ResultSet res) throws SQLException {
        res.close();
    }

    public static void close(Statement sen) throws SQLException {
        sen.close();
    }

    public static void close(PreparedStatement psen) throws SQLException {
        psen.close();
    }
}