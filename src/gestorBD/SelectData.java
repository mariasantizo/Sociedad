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
     * @author mariasantizo y malensanz
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
    public void selectAllSocio()
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
    
    public void selectAllMesa() {
    	String sql = "SELECT CODIGOMESA, CAPACIDAD FROM MESA";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGOMESA") + "\t"+
    			rs.getInt("CAPACIDAD")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllReserva() {
    	String sql = "SELECT CODIGO, DNISOCIO, CODIGOMESA, FECHA, HORARIO FROM RESERVA";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGO") + "\t"+
    			rs.getString("DNISOCIO") + "\t"+
    			rs.getInt("CODIGOMESA") + "\t"+
    			rs.getDate("FECHA") + "\t"+
    			rs.getString("HORARIO")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllAdministrador() {
    	String sql = "SELECT DNI, NOMBRE, APELLIDO, TELEFONO, DIRECCION FROM ADMINISTRADOR";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getString("DNI") + "\t"+
    			rs.getString("NOMBRE") + "\t"+
    			rs.getString("APELLIDO") + "\t"+
    			rs.getInt("TELEFONO") + "\t"+
    			rs.getString("DIRECCION")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllTipoProducto() {
    	String sql = "SELECT CODIGO, NOMBRE FROM TIPOPRODUCTO";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGO") + "\t"+
    			rs.getString("NOMBRE")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllProducto() {
    	String sql = "SELECT NOMBRE, CODIGO, PRECIO, CODIGOTIPOPRODUCTO FROM PRODUCTO";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getString("NOMBRE") + "\t"+
    			rs.getInt("CODIGO") + "\t"+
    			rs.getInt("PRECIO") + "\t"+
    			rs.getInt("CODIGOTIPOPRODUCTO")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllProductoAlmacen() {
    	String sql = "SELECT CODIGOALMACEN, CODIGOPRODUCTO FROM PRODUCTOALMACEN";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGOALMACEN") + "\t"+
    			rs.getInt("CODIGOPRODUCTO")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllAlmacen() {
    	String sql = "SELECT CODIGO, FECHA, VALOR FROM ALMACEN";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGO") + "\t"+
    			rs.getDate("FECHA") + "\t"+
    			rs.getInt("VALOR")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllCuentaResultados() {
    	String sql = "SELECT CODIGO, FECHA, INGRESOCUOTA, INGRESORESERVAS, GASTOCOMPRAS, OTROSGASTOS, RESULTADO FROM CUENTARESULTADOS";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGO") + "\t"+
    			rs.getDate("FECHA") + "\t"+
    			rs.getInt("INGRESOCUOTA") + "\t"+
    			rs.getInt("INGRESORESERVAS") + "\t"+
    			rs.getInt("GASTOCOMPRAS") + "\t"+
    			rs.getInt("OTROSGASTOS") + "\t"+
    			rs.getInt("RESULTADO")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }

    public void selectAllBalance() {
    	String sql = "SELECT CODIGO, FECHA, MOBILIARIO, EQUIPOS, CODIGOALMACEN, CLIENTES, CAJA, BANCOS, CAPITALSOCIAL, CCODIGOCUENTARESULTADOS, CREDITO, PROVEEDORES, VALORBALANCE FROM BALANCE";
    	try (Connection conn = this.connect();
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			System.out.println(
    			rs.getInt("CODIGO") + "\t"+
    			rs.getDate("FECHA") + "\t"+
    			rs.getInt("MOBILIARIO") + "\t"+
    			rs.getInt("EQUIPOS") + "\t"+
    			rs.getInt("CODIGOALMACEN") + "\t"+
    			rs.getInt("CLIENTES") + "\t"+
    			rs.getInt("CAJA") + "\t"+
    			rs.getInt("BANCOS") + "\t"+
    			rs.getInt("CAPITALSOCIAL") + "\t"+
    			rs.getInt("CCODIGOCUENTARESULTADOS") + "\t"+
    			rs.getInt("CREDITO") + "\t"+
    			rs.getInt("PROVEEDORES") + "\t"+
    			rs.getInt("VALORBALANCE")
    			);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public static void main(String[] args)
    {
        SelectData app = new SelectData();
        app.selectAllProducto();
    }
}
