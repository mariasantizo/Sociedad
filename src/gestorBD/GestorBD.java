package gestorBD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import datos.Administrador;
import datos.Mesa;
import datos.Producto;
import datos.Reserva;
import datos.Socio;
import datos.TipoProducto;

public class GestorBD {
	public static void createNewDatabase (String fileName) {
		String url = "jdbc:sqlite:"+fileName;
		try (Connection conn = DriverManager.getConnection(url)){
			if (conn != null) {
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("The driver name is "+meta.getDriverName());
				System.out.println("A new database has been created.");
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Pasándole una sentencia de creación de tablas de sql, crea esa tabla en la base de datos
	 * @author mariasantizo
	 * @param sql
	 */
	public static void createTable(String sql) {
		//Conectarse a la BD
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		//Hacer conexiones y crear tabla
		try (Connection conn = DriverManager.getConnection(url);
			Statement stmt = conn.createStatement()){
			stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
	}
	
	/**
	 * Inserta Socios en la BD
	 * @author mariasantizo
	 */
	public static void insertSocio(String dni, String nombre, String apellido, int telefono, String direccion, String contrasena, int numeroSocio, String tipoCuota, int cuota) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO SOCIO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, dni);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setInt(4, telefono);
			pstmt.setString(5, direccion);
			pstmt.setString(6, contrasena);
			pstmt.setInt(7, numeroSocio);
			pstmt.setString(8, tipoCuota);
			pstmt.setInt(9, cuota);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * inserta Administradores en la BD
	 * @author malensanz
	 */
	
	public static void insertAdministrador(String dni, String nombre, String apellido, int telefono, String direccion, String contrasena) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO ADMINISTRADOR VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, dni);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setInt(4, telefono);
			pstmt.setString(5, direccion);
			pstmt.setString(6, contrasena);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Inserta Tipos de producto en la BD
	 * @author malensanz
	 */
	public static void insertTipoProducto(String nombre, int codigo) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO TIPOPRODUCTO VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codigo);
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * Inserta productos en la base de datos
	 * @author malensanz
	 */
	public static void insertProducto(String nombre, int codigo, int codigoTipoProducto, double precio) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO PRODUCTO VALUES (?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codigo);
			pstmt.setInt(3, codigoTipoProducto);
			pstmt.setDouble(4, precio);
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertMesa(int codigoMesa, int capacidad) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO MESA VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, codigoMesa);
			pstmt.setInt(2, capacidad);
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void insertReserva(int codigo, int codigoSocio, int codigoMesa, String fecha, String horario) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO RESERVA VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, codigo);
			pstmt.setInt(2, codigoSocio);
			pstmt.setInt(3, codigoMesa);
			pstmt.setString(4, fecha);
			pstmt.setString(5, horario);
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertAlmacen(int codigo, String fecha, String productos, double valor) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO ALMACEN VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, codigo);
			pstmt.setString(2, fecha);
			pstmt.setString(3, productos);
			pstmt.setDouble(4, valor);
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertProductoAlmacen(int codigoAlmacen, int codigoProducto) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO PRODUCTOALMACEN VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, codigoAlmacen);
			pstmt.setDouble(2, codigoProducto);
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void insertCuentaResultados(int codigo, String fecha, double ingresoCuota, double ingresoReservas, double gastoCompras, double otrosGastos, double resultado) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO CUENTARESULTADOS VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, codigo);
			pstmt.setString(2, fecha);
			pstmt.setDouble(3, ingresoCuota);
			pstmt.setDouble(4, ingresoReservas);
			pstmt.setDouble(5, gastoCompras);
			pstmt.setDouble(6, otrosGastos);
			pstmt.setDouble(7, resultado);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertBalance(int codigo, String fecha, double mobiliario, double equipos, int codigoAlmacen, double clientes, double caja, double bancos, double capitalSocial, double resultado, double credito, double proveedores, double valorBalance) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO BALANCE VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, codigo);
			pstmt.setString(2, fecha);
			pstmt.setDouble(3, mobiliario);
			pstmt.setDouble(4, equipos);
			pstmt.setInt(5, codigoAlmacen);
			pstmt.setDouble(6, clientes);
			pstmt.setDouble(7, caja);
			pstmt.setDouble(8, bancos);
			pstmt.setDouble(9, capitalSocial);
			pstmt.setDouble(10, resultado);
			pstmt.setDouble(11, credito);
			pstmt.setDouble(12, proveedores);
			pstmt.setDouble(13, valorBalance);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	

    /**
     * selecciona todas las lineas en la tabla SOCIO y los devuelve en un ArrayList de Socios.
     */
    public static ArrayList<Socio> selectAllSocio()
    {
    	ArrayList<Socio> socios = new ArrayList<Socio>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT dni, nombre, apellido, telefono, direccion, contrasena, numeroSocio, tipoCuota, cuota FROM SOCIO";
        try (Connection conn = DriverManager.getConnection(url);
        		Statement stmt  = conn.createStatement();
                ResultSet rs    = stmt.executeQuery(sql)) {
            // loop through the result set
            while (rs.next())
            {
            	Socio s = new Socio (rs.getString("dni"), rs.getString("nombre"), rs.getString("apellido"), rs.getInt("telefono"), rs.getString("direccion"), rs.getString("contrasena"), rs.getInt("numeroSocio"), rs.getString("tipoCuota"), rs.getInt("cuota"));
                socios.add(s);      
            }
        } catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
		return socios;
    }
    
    public static ArrayList <Mesa> selectAllMesa() {
    	ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	
    	String sql = "SELECT CODIGOMESA, CAPACIDAD FROM MESA";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			Mesa m = new Mesa(rs.getInt("CODIGOMESA"), rs.getInt("CAPACIDAD"));
    			mesas.add(m);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
		return mesas;
    }
    
    public static ArrayList <Reserva> selectAllReserva() {
    	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, DNISOCIO, CODIGOMESA, FECHA, HORARIO FROM RESERVA";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			Calendar c = new GregorianCalendar();
    			//calendar y date no son compatibles, revisar esto!!!!
    			//Reserva r = new Reserva(rs.getInt("CODIGO"), rs.getString("DNISOCIO"), rs.getInt("CODIGOMESA"), rs.getDate("FECHA"), rs.getString("HORARIO"));
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
		return reservas;
    }
    
    public static ArrayList <Administrador> selectAllAdministrador() {
    	ArrayList<Administrador> admins = new ArrayList<Administrador>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT DNI, NOMBRE, APELLIDO, TELEFONO, DIRECCION, CONTRASENA FROM ADMINISTRADOR";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			Administrador a = new Administrador(rs.getString("DNI"), rs.getString("NOMBRE"), rs.getString("APELLIDO"), rs.getInt("TELEFONO"), rs.getString("DIRECCION"), rs.getString("CONTRASENA"));
    			admins.add(a);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
		return admins;
    }
    
    public static ArrayList<TipoProducto> selectAllTipoProducto() {
    	ArrayList<TipoProducto> tipos = new ArrayList<TipoProducto>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, NOMBRE FROM TIPOPRODUCTO";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			TipoProducto t = new TipoProducto(rs.getString("NOMBRE"), rs.getInt("CODIGO"));
    			tipos.add(t);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	return tipos;
    }
    
    public static ArrayList<Producto> selectAllProducto(ArrayList<TipoProducto> tipos) {
    	ArrayList<Producto> productos = new ArrayList<Producto>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT NOMBRE, CODIGO, PRECIO, CODIGOTIPOPRODUCTO FROM PRODUCTO";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			Producto p = new Producto (rs.getString("NOMBRE"), rs.getInt("CODIGO"), rs.getInt("PRECIO"), rs.getInt("CODIGOTIPOPRODUCTO"));
    			p.convertirTipo(tipos);
    			productos.add(p);
    	
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	return productos;
    }
    
    public void selectAllProductoAlmacen() {
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGOALMACEN, CODIGOPRODUCTO FROM PRODUCTOALMACEN";
    	try (Connection conn = DriverManager.getConnection(url);
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
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, FECHA, VALOR FROM ALMACEN";
    	try (Connection conn = DriverManager.getConnection(url);
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
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, FECHA, INGRESOCUOTA, INGRESORESERVAS, GASTOCOMPRAS, OTROSGASTOS, RESULTADO FROM CUENTARESULTADOS";
    	try (Connection conn = DriverManager.getConnection(url);
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
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, FECHA, MOBILIARIO, EQUIPOS, CODIGOALMACEN, CLIENTES, CAJA, BANCOS, CAPITALSOCIAL, CCODIGOCUENTARESULTADOS, CREDITO, PROVEEDORES, VALORBALANCE FROM BALANCE";
    	try (Connection conn = DriverManager.getConnection(url);
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
    
    
    
    /**
     * Delete a warehouse specified by the id
     *
     * @param id
     */
    public void delete(String dni)
    {
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "DELETE FROM SOCIO WHERE dni = ?";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setString(1, dni);

            // execute the delete statement
            pstmt.executeUpdate();

        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }
	
    public static void main(String[] args) {
		ArrayList<Socio> socios = new ArrayList<Socio>();
    	socios=selectAllSocio();
    	for (int i=0; i<socios.size(); i++) {
    		System.out.println(socios.get(i).getNombre());
    	}
	}
}
