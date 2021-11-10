package gestorBD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertData {
	
	/**
	 * inserta Socios en la BD
	 * @author mariasantizo
	 */
	
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
	
	/**
	 * inserta Administradores en la BD
	 * @author malensanz
	 */
	
	public static void insertAdministrador(String dni, String nombre, String apellido, int telefono, String direccion) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO ADMINISTRADOR VALUES (?, ?, ?, ?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, dni);
			pstmt.setString(2, nombre);
			pstmt.setString(3, apellido);
			pstmt.setInt(4, telefono);
			pstmt.setString(5, direccion);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
/*	
	*//**
	 * inserta Tipos de producto en la BD
	 * @author malensanz
	 *//*
	
	public static void insertTipoProducto(String nombre, int codigo) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO TIPOPRODUCTO VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codigo);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	
	*//**
	 * inserta productos en la base de datos
	 * @author malensanz
	 *//*
	
	public static void insertTipoProducto(String nombre, int codigo) {
		String name = "BaseDeDatos.db";
		String url = "jdbc:sqlite:"+name;
		
		String sql = "INSERT INTO TIPOPRODUCTO VALUES (?, ?)";
		
		try (Connection conn = DriverManager.getConnection(url);
			PreparedStatement pstmt = conn.prepareStatement(sql)){
			
			pstmt.setString(1, nombre);
			pstmt.setInt(2, codigo);

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
	*/
	public static void main(String[] args) {
		insertSocio("72451234A", "Ana", "Sanchez", 687333222, "Avenida 8", 20, "Anual", 960);
		insertSocio("71233123D", "Jon", "Agirre", 677345233, "Gipuzkoa kalea 5A, 1A", 1, "Anual", 960);
		insertSocio("72555234T", "Mikel", "Etxabe", 688883222, "Avenida Navarra 39B, 2A", 2, "Anual", 960);
		insertSocio("44533123D", "Ainhoa", "Agirre", 677345290, "Balea Kalea 5, 1A", 3, "Anual", 960);
		insertSocio("72225111X", "Maria", "Aramburu", 688090210, "Avenida de la Libertad 8B, 2A", 4, "Semestral", 960);
/*		insertSocio("71233883W", "Juan Carlos", "Agirre", 601455233, "Avenida San Francisco 12, 4C", 5, "Anual", 960);
		insertSocio("43551234A", "Jorge", "Legorburu", 677373222, "Avenida Gipuzcoa 32, 5A", 6, "Mensual", 960);
		insertSocio("44233443P", "Jon", "Etxabe", 670015233, "Avenida Zumalakarregi 5C, 3A", 7, "Anual", 960);
		insertSocio("77322234Q", "Iñigo", "Agirrezabalaga", 687303200, "Avenida Alava 3, 2A", 8, "Anual", 960);
		insertSocio("43233553S", "June", "Merketegi", 677775637, "Avenida Zarautz 2, 1B", 9, "Trimestral", 960);
		insertSocio("72221224V", "Marina", "Etxeberria", 600102562, "Avenida Navarra 4, 3C", 10, "Anual", 960);
		insertSocio("71221623H", "Carlos", "Manterola", 607341231, "Zuberoa kalea 5, 1C", 11, "Mensual", 960);
		insertSocio("42453234S", "Carla", "Diaz", 617333212, "Gipuzkoa plaza 8, 2A", 12, "Anual", 960);
		insertSocio("76663123D", "Karmele", "Zubiaurre", 607445233, "Plaza del Ayuntamiento 5, 3A", 13, "Anual", 960);
		insertSocio("43451794J", "Miguel", "Atxa", 680333002, "Avenida Colón 13, 1C", 14, "Anual", 960);
		insertSocio("44234123L", "David", "Erro", 600145231, "Lauaxeta kalea 5B, 3B", 4, "Anual", 960);
		insertSocio("44851234T", "Gaizka", "Perez", 697333092, "Calle Axular 8, 1B", 15, "Anual", 960);
		insertSocio("43233893P", "Cristina", "Jaio", 600345013, "Avenida Navarra 22, 4C", 16, "Semestral", 960);
		insertSocio("44651234B", "Alejandro", "Landa", 687333222, "Avenida Barcelona 1, 8A", 17, "Anual", 960);
		insertSocio("43232623K", "Ines", "Bernal", 677646233, "Calle Mitxelena 5A, 2A", 18, "Anual", 960);
		insertSocio("71411234H", "Elisa", "Artola", 607833822, "Avenida Gipuzcoa 22, 4A", 19, "Mensual", 960);
		insertSocio("42233123G", "Miren", "Arregi", 699345233, "Avenida Alava 5, 4A", 21, "Trimestral", 960);
		insertSocio("42451434C", "Ignacio", "Manterola", 617333219, "Calle Lauaxeta 5A, 3A", 22, "Anual", 960);
		insertSocio("78283128N", "Malen", "Bengoetxea", 677643233, "Kale Nagusia 1, 5B", 23, "Anual", 960);
		insertSocio("43451234U", "Miguel Angel", "Azcue", 601303222, "Calle Mendilauta 2, 2A", 24, "Anual", 960);
		insertSocio("44234123F", "Aitziber", "Zabala", 677945293, "Indamendi Kalea 5, 6C", 25, "Semestral", 960);
		insertSocio("71858234M", "Peru", "Diez", 688883282, "Indamendi Kalea 8, 1B", 26, "Anual", 960);
		insertSocio("44234423X", "Asier", "Etxabe", 677695263, "Avenida Navarra 11, 5A", 27, "Trimestral", 960);
		insertSocio("72441284I", "Ignacio", "Illarramendi", 601103222, "Calle Iturribide 8, 3A", 28, "Anual", 960);
		insertSocio("71166123X", "Juan", "Rodriguez", 607340730, "Calle Lampardo 5, 4B", 29, "Mensual", 960);
		
		insertAdministrador("72838383D", "Juan", "Lopetegi", 610100304, "Calle Herrikosoro 15, 1A");
		insertAdministrador("43838382Z", "Angela", "Perez", 600107307, "Calle Balenciaga 3, 2A");
		
		insertTipoProducto("Aliño", 1);
		insertTipoProducto("Vinos", 2);
		insertTipoProducto("Refrescos", 3);
		insertTipoProducto("Cafes", 4);
		insertTipoProducto("Tabaco", 5);
		insertTipoProducto("Licores", 6);
		insertTipoProducto("Conservas", 7);
		insertTipoProducto("Cocina", 8);
		insertTipoProducto("Helados", 9);
		insertTipoProducto("Material", 10);
		
	}*/
	}
}
