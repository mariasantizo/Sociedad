package gestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	
	public static void insertSocio(String dni, String nombre, String apellido, int telefono, String direccion, int numeroSocio, String tipoCuota, int cuota) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO SOCIO VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, dni);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setInt(4, telefono);
			pstmt.setString(5, direccion);
			pstmt.setInt(6, numeroSocio);
			pstmt.setString(7, tipoCuota);
			pstmt.setInt(8, cuota);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) {
		insertSocio("72451234A", "Ana", "Sanchez", 687333222, "Avenida 8", 20, "Anual", 960);
	}
	
}
