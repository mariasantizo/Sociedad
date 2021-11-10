package gestorBD;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SelectData {

	 /**
     * Connect to the test.db database
     * @return the Connection object
     */
    private Connection connect()
    {
        // SQLite connection string
        String name = "BaseDeDatos.db";
        String url = "jdbc:sqlite:" + name;
        Connection conn = null;

        try
        {
            conn = DriverManager.getConnection(url);
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return conn;
    }


    /**
     * selecciona todas las lineas en la tabla SOCIO
     */
    public void selectAll()
    {
        String sql = "SELECT dni, nombre, apellido, telefono, direccion, numeroSocio, tipoCuota, cuota FROM SOCIO";

        try
                (
                        Connection conn = this.connect();
                        Statement stmt  = conn.createStatement();
                        ResultSet rs    = stmt.executeQuery(sql)
                )
        {

            // loop through the result set
            while (rs.next())
            {
                System.out.println
                        (
                        		rs.getString("dni") +  "\t" +
                                rs.getString("nombre") + "\t" +
                                rs.getString("apellido") + "\t" +
                                rs.getInt("telefono") + "\t" +
                                rs.getString("direccion") + "\t" +     
                        		rs.getInt("numeroSocio") +  "\t" +
                                rs.getString("tipoCuota") + "\t" +
                                rs.getInt("cuota")
                        );
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        SelectData app = new SelectData();
        app.selectAll();
    }
}
