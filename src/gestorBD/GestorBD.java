package gestorBD;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import datos.Administrador;
import datos.Mesa;
import datos.Producto;
import datos.Reserva;
import datos.Socio;
import datos.TipoProducto;
import negocio.Almacen;
import negocio.Balance;
import negocio.CuentaResultados;

public class GestorBD {
	
	private int a;
	private int b;
	
	
	
	public GestorBD(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	
	

	public int getA() {
		return a;
	}



	public void setA(int a) {
		this.a = a;
	}



	public int getB() {
		return b;
	}



	public void setB(int b) {
		this.b = b;
	}



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
	public static void insertSocio(Socio s) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO SOCIO VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, s.getDni());
			pstmt.setString(2, s.getNombre());
			pstmt.setString(3, s.getApellido());
			pstmt.setInt(4, s.getTelefono());
			pstmt.setString(5, s.getDireccion());
			pstmt.setString(6, s.getContrasena());
			pstmt.setInt(7, s.getCuota());
			pstmt.setString(8, s.getTipoCuota());
			pstmt.setInt(9, s.getCuota());
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
	
	public static void insertAdministrador(Administrador a) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO ADMINISTRADOR VALUES (?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, a.getDni());
			pstmt.setString(2, a.getNombre());
			pstmt.setString(3, a.getApellido());
			pstmt.setInt(4, a.getTelefono());
			pstmt.setString(5, a.getDireccion());
			pstmt.setString(6, a.getContrasena());
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
	public static void insertTipoProducto(TipoProducto t) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO TIPOPRODUCTO VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, t.getNombre());
			pstmt.setInt(2, t.getCodigo());
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
	public static void insertProducto(Producto p, TipoProducto t) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO PRODUCTO VALUES (?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, p.getNombre());
			pstmt.setInt(2, p.getCodigo());
			pstmt.setInt(3, t.getCodigo());
			pstmt.setDouble(4, p.getPrecio());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertMesa(Mesa m) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO MESA VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, m.getCodigoMesa());
			pstmt.setInt(2, m.getCapacidad());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	
	public static void insertReserva(Reserva r) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		String year = String.valueOf(r.getFecha().get(Calendar.YEAR));
		String month = String.valueOf(r.getFecha().get(Calendar.MONTH));
		String day = String.valueOf(r.getFecha().get(Calendar.DAY_OF_MONTH));
		String fecha = day+"-"+month+"-"+year;
		
		String sql = "INSERT INTO RESERVA VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, r.getCodigo());
			pstmt.setString(2, r.getSocio().getDni());
			pstmt.setInt(3, r.getMesa().getCodigoMesa());
			pstmt.setString(4, fecha);
			pstmt.setString(5, r.getHorario());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertAlmacen(Almacen a) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		String year = String.valueOf(a.getFecha().get(Calendar.YEAR));
		String month = String.valueOf(a.getFecha().get(Calendar.MONTH));
		String day = String.valueOf(a.getFecha().get(Calendar.DAY_OF_MONTH));
		String fecha = day+"-"+month+"-"+year;
		
		String sql = "INSERT INTO ALMACEN VALUES (?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, a.getCodigo());
			pstmt.setString(2, fecha);
			pstmt.setDouble(3, a.getValor());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertProductoAlmacen(Producto p, Almacen a) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO PRODUCTOALMACEN VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, a.getCodigo());
			pstmt.setDouble(2, p.getCodigo());
			pstmt.executeUpdate();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

	public static void insertCuentaResultados(CuentaResultados c) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		String year = String.valueOf(c.getFecha().get(Calendar.YEAR));
		String month = String.valueOf(c.getFecha().get(Calendar.MONTH));
		String day = String.valueOf(c.getFecha().get(Calendar.DAY_OF_MONTH));
		String fecha = day+"-"+month+"-"+year;
		
		
		String sql = "INSERT INTO CUENTARESULTADOS VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, c.getCodigo());
			pstmt.setString(2, fecha);
			pstmt.setDouble(3, c.getIngresoCuota());
			pstmt.setDouble(4, c.getIngresoReservas());
			pstmt.setDouble(5, c.getGastoCompras());
			pstmt.setDouble(6, c.getOtrosGastos());
			pstmt.setDouble(7, c.getResultado());
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void insertBalance(Balance b) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		String year = String.valueOf(b.getFecha().get(Calendar.YEAR));
		String month = String.valueOf(b.getFecha().get(Calendar.MONTH));
		String day = String.valueOf(b.getFecha().get(Calendar.DAY_OF_MONTH));
		String fecha = day+"-"+month+"-"+year;
		
		
		String sql = "INSERT INTO BALANCE VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setInt(1, b.getCodigo());
			pstmt.setString(2, fecha);
			pstmt.setDouble(3, b.getMobiliario());
			pstmt.setDouble(4, b.getEquipos());
			pstmt.setInt(5, b.getAlmacen().getCodigo());
			pstmt.setDouble(6, b.getClientes());
			pstmt.setDouble(7, b.getCaja());
			pstmt.setDouble(8, b.getBancos());
			pstmt.setDouble(9, b.getCapitalSocial());
			pstmt.setDouble(10, b.getResultado().getResultado());
			pstmt.setDouble(11, b.getCredito());
			pstmt.setDouble(12, b.getProveedores());
			pstmt.setDouble(13, b.getValorBalance());
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
    
    public static ArrayList <Reserva> selectAllReserva(ArrayList<Socio> socios, ArrayList<Mesa> mesas) {
    	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, DNISOCIO, CODIGOMESA, FECHA, HORARIO FROM RESERVA";
 
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			int indice=0;
    			for (int i=0; i<socios.size(); i++) {
    				if (socios.get(i).getDni().equals(rs.getString("DNISOCIO"))) {
    					indice=i;
    				}
    			}
    			int indiceMesa=0;
    			for (int i=0; i<mesas.size(); i++) {
    				if (mesas.get(i).getCodigoMesa()==(rs.getInt("CODIGOMESA"))) {
    					indiceMesa=i;
    				}
    			}
    			String fechaString = rs.getString("FECHA");
    			String [] array = fechaString.split("-");
    			
    			Calendar c = new GregorianCalendar(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
    			Reserva r = new Reserva (rs.getInt("CODIGO"), socios.get(indice), mesas.get(indiceMesa), c, rs.getString("HORARIO"));
    			reservas.add(r);
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
    
    public ArrayList<GestorBD> selectAllProductoAlmacen() {
    	ArrayList<GestorBD> gestor = new ArrayList<GestorBD>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGOALMACEN, CODIGOPRODUCTO FROM PRODUCTOALMACEN";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			GestorBD g = new GestorBD(rs.getInt("CODIGOALMACEN"), rs.getInt("CODIGOPRODUCTO"));
    			gestor.add(g);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	return gestor;
    }
    
    public void selectAllAlmacen(ArrayList<Producto> productos) {
    	ArrayList<GestorBD> tuplas =selectAllProductoAlmacen();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, FECHA, VALOR FROM ALMACEN";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			ArrayList<Producto> productosEsteAlmacen = new ArrayList<Producto>();
    			String fechaString = rs.getString("FECHA");
    			String [] array = fechaString.split("-");
    			Calendar c = new GregorianCalendar(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
    			for (int i=0; i<tuplas.size(); i++) {
    				if (tuplas.get(i).getA()==rs.getInt("CODIGO")) {
    					for (int j=0; i<productos.size();i++) {
        					if (tuplas.get(i).getB()==productos.get(j).getCodigo()) {
        						productosEsteAlmacen.add(productos.get(j));
        					}
        				}
					}
    				
    			}
    			Almacen a = new Almacen(rs.getInt("CODIGO"), c, productosEsteAlmacen,rs.getInt("VALOR"));	
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }
    
    public void selectAllCuentaResultados() {
    	ArrayList<CuentaResultados> cuentas = new ArrayList<CuentaResultados>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, FECHA, INGRESOCUOTA, INGRESORESERVAS, GASTOCOMPRAS, OTROSGASTOS, RESULTADO FROM CUENTARESULTADOS";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			String fechaString = rs.getString("FECHA");
    			String [] array = fechaString.split("-");
    			Calendar c = new GregorianCalendar(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
    			CuentaResultados cuenta = new CuentaResultados(rs.getInt("CODIGO"), c, rs.getDouble("INGRESOCUOTA"), rs.getDouble("INGRESORESERVAS"), rs.getDouble("GASTOCOMPRAS"), rs.getDouble("OTROSGASTOS"));
    			cuentas.add(cuenta);
    		}
    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    }

    public void selectAllBalance(ArrayList<Almacen> almacenes, ArrayList<CuentaResultados> cuentas) {
    	ArrayList<Balance> balances = new ArrayList<Balance>();
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "SELECT CODIGO, FECHA, MOBILIARIO, EQUIPOS, CODIGOALMACEN, CLIENTES, CAJA, BANCOS, CAPITALSOCIAL, CODIGOCUENTARESULTADOS, CREDITO, PROVEEDORES, VALORBALANCE FROM BALANCE";
    	try (Connection conn = DriverManager.getConnection(url);
    			Statement stmt = conn.createStatement();
    			ResultSet rs = stmt.executeQuery(sql)){
    		while (rs.next()) {
    			int indiceAlmacen = 0;
    			for (int i=0; i<almacenes.size(); i++) {
    				if (almacenes.get(i).getCodigo()==rs.getInt("CODIGOALMACEN")) {
    					indiceAlmacen=i;
    				}
    			}
    			int indiceCuentas = 0;
    			for (int i=0; i<cuentas.size(); i++) {
    				if (cuentas.get(i).getCodigo()==rs.getInt("CODIGOCUENTARESULTADOS")) {
    					indiceCuentas=i;
    				}
    			}
    			
    			String fechaString = rs.getString("FECHA");
    			String [] array = fechaString.split("-");
    			Calendar c = new GregorianCalendar(Integer.parseInt(array[2]), Integer.parseInt(array[1]), Integer.parseInt(array[0]));
    			Balance b = new Balance(rs.getInt("CODIGO"), c, rs.getDouble("MOBILIARIO"), rs.getDouble("EQUIPOS"), almacenes.get(indiceAlmacen), rs.getDouble("CLIENTES"), rs.getDouble("CAJA"), rs.getDouble("BANCOS"), rs.getDouble("CAPITALSOCIAL"), cuentas.get(indiceCuentas), rs.getDouble("CREDITO"), rs.getDouble("PROVEEDORES"));
    			balances.add(b);
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
    public static void deleteSocio(String dni)
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
	
    public static void deleteReserva(int codigo)
    {
    	String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
    	String sql = "DELETE FROM RESERVA WHERE codigo = ?";

        try
                (
                        Connection conn = DriverManager.getConnection(url);
                        PreparedStatement pstmt = conn.prepareStatement(sql)
                )
        {

            // set the corresponding param
            pstmt.setInt(1, codigo);

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
    		//System.out.println(socios.get(i).getNombre());
    	}
    	//createNewDatabase("BaseDeDatos.db");
    	//createTable();
    	Socio s1=new Socio("72451234A","Ana", "Sanchez", 687333222, "Avenida 8", "1234", 1, "Anual", 960);
    	/*Socio s2=new Socio("70001234U","Jon", "Murua", 688883222, "Kale Nagusia 8", "5678", 2, "Anual", 960);
    	insertSocio(s1);
    	insertSocio(s2);*/
    	/*Administrador a1= new Administrador ("43676767E", "Mikel", "Etxeberria", 677676767, "Balea kalea", "0000");
    	insertAdministrador(a1);*/
    	Mesa m1= new Mesa(1, 10);
    	//insertMesa(m1)
    	
    	Calendar c= new GregorianCalendar (2021,12,18);
    	Reserva r=new Reserva(1, s1, m1, c, "Desayuno");
    	//insertReserva(r);
    	
    	Calendar f1 = new GregorianCalendar (2021,10,30);
    	Reserva r1= new Reserva (2, s1, m1, f1, "Comida");
    	//insertReserva(r1);
    		
    	ArrayList<Mesa> mesas = new ArrayList<Mesa>();
    	mesas=selectAllMesa();
    	for (int i=0; i<mesas.size(); i++) {
    		//System.out.println(mesas.get(i).getCodigoMesa());
    	}
    	
    	ArrayList<Reserva> reservas = new ArrayList<Reserva>();
    	reservas=selectAllReserva(socios, mesas);
    	for (int i=0; i<reservas.size(); i++) {
    		System.out.println(reservas.get(i).getCodigo());

    	}
    	
    }
}
