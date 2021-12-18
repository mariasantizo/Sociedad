package gestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
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
	
	public static void main(String[] args) {
		String sqlSocio = "CREATE TABLE IF NOT EXISTS SOCIO (\n"
				+ " DNI TEXT PRIMARY KEY, \n"
				+ " NOMBRE TEXT NOT NULL, \n"
				+ " APELLIDO TEXT NOT NULL, \n"
				+ " TELEFONO NUMBER, \n"
				+ " DIRECCION TEXT, \n"
				+ " CONTRASENA TEXT, \n"
				+ " NUMEROSOCIO NUMBER, \n"
				+ " TIPOCUOTA TEXT, \n"
				+ " CUOTA NUMBER \n"
				+ ");";
		
		String sqlTipoProducto = "CREATE TABLE IF NOT EXISTS TIPOPRODUCTO (\n"
				+ "CODIGO NUMBER PRIMARY KEY, \n"
				+ "NOMBRE TEXT NOT NULL \n"
				+ ");";
		
		String sqlProducto = "CREATE TABLE IF NOT EXISTS PRODUCTO (\n"
				+ "NOMBRE TEXT, \n"
				+ "CODIGO NUMBER PRIMARY KEY, \n"
				+ "PRECIO NUMBER, \n"
				+ "CODIGOTIPOPRODUCTO NUMBER REFERENCES TIPOPRODUCTO (CODIGO) \n"
				+ ");";
		
		String sqlAdministrador = "CREATE TABLE IF NOT EXISTS ADMINISTRADOR (\n"
				+ " DNI TEXT PRIMARY KEY, \n"
				+ " NOMBRE TEXT NOT NULL, \n"
				+ " APELLIDO TEXT NOT NULL, \n"
				+ " TELEFONO NUMBER, \n"
				+ " DIRECCION TEXT, \n"
				+ " CONTRASENA TEXT \n"
				+ ");";
		
		String sqlMesa = "CREATE TABLE IF NOT EXISTS MESA (\n"
				+ "CODIGOMESA NUMBER PRIMARY KEY, \n"
				+ "CAPACIDAD NUMBER"
				+ ");";
		
		String sqlReserva = "CREATE TABLE IF NOT EXISTS RESERVA (\n"
				+ "CODIGO NUMBER PRIMARY KEY, \n"
				+ "DNISOCIO TEXT REFERENCES SOCIO(DNI), \n"
				+ "CODIGOMESA NUMBER REFERENCES MESA(CODIGOMESA), \n"
				+ "FECHA TEXT, \n"
				+ "HORARIO TEXT \n"
				+ ");";
		
		String sqlAlmacen = "CREATE TABLE IF NOT EXISTS ALMACEN (\n"
				+ "CODIGO NUMBER PRIMARY KEY, \n"
				+ "FECHA TEXT, \n"
				+ "VALOR NUMBER \n"
				+ ");";
		
		String sqlProductoAlmacen = "CREATE TABLE IF NOT EXISTS PRODUCTOALMACEN (\n"
				+ "CODIGOALMACEN NUMBER REFERENCES ALMACEN(CODIGO), \n"
				+ "CODIGOPRODUCTO NUMBER REFERENCES PRODUCTO(CODIGO) \n"
				+ ");";
		
		String sqlCuentaResultados = "CREATE TABLE IF NOT EXISTS CUENTARESULTADOS (\n"
				+ "CODIGO NUMBER PRIMARY KEY, \n"
				+ "FECHA TEXT, \n"
				+ "INGRESOCUOTA NUMBER, \n"
				+ "INGRESORESERVAS NUMBER, \n"
				+ "GASTOCOMPRAS NUMBER, \n"
				+ "OTROSGASTOS NUMBER, \n"
				+ "RESULTADO NUMBER \n"
				+ ");";
		
		String sqlBalance = "CREATE TABLE IF NOT EXISTS BALANCE (\n"
				+ "CODIGO NUMBER PRIMARY KEY, \n"
				+ "FECHA TEXT, \n"
				+ "MOBILIARIO NUMBER, \n"
				+ "EQUIPOS NUMBER, \n"
				+ "CODIGOALMACEN NUMBER REFERENCES ALMACEN(CODIGO), \n"
				+ "CLIENTES NUMBER, \n"
				+ "CAJA NUMBER, \n"
				+ "BANCOS NUMBER, \n"
				+ "CAPITALSOCIAL NUMBER, \n"
				+ "CODIGOCUENTARESULTADOS NUMBER REFERENCES CUENTARESULTADOS(CODIGO), \n"
				+ "CREDITO NUMBER, \n"
				+ "PROVEEDORES NUMBER, \n"
				+ "VALORBALANCE NUMBER \n"
				+ ");";
		
		createTable(sqlBalance);
	}
}
