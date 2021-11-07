package gestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {
	public static void createTable() {
		//Conectarse a esta BD
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		//Crear sentencia SQL para creaci�n de tablas
		String sql = "CREATE TABLE IF NOT EXISTS SOCIO (\n"
				+ " DNI TEXT PRIMARY KEY, \n"
				+ " NOMBRE TEXT NOT NULL, \n"
				+ " APELLIDO TEXT NOT NULL, \n"
				+ " TELEFONO NUMBER, \n"
				+ " DIRECCION TEXT, \n"
				+ " NUMEROSOCIO NUMBER, \n"
				+ " TIPOCUOTA TEXT, \n"
				+ " CUOTA NUMBER \n"
				+ ");";
		
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
		createTable();
	}
}
