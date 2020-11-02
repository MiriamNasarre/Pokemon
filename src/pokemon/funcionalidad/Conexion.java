package pokemon.funcionalidad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class Conexion {
	public static Connection con;
	public static Statement st;
	public static ResultSet rs;
	
	public static void abrir() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//driver
			con= DriverManager.getConnection("jdbc:mysql://localhost/pokemon?serverTimezone=UTC","root", "");
			
			st=con.createStatement();

			}catch(ClassNotFoundException cnfe) {
	        }catch (SQLException e) {
				JOptionPane.showMessageDialog(Ventana.mensaje(),"No se ha podido conectar a la base de datos.","Error", JOptionPane.ERROR_MESSAGE);
	        }
	}
public static boolean compruebaConexion(Connection con) {
	boolean seHaConectado=false;
	if(con!=null) {
		seHaConectado=true;
	}
	return seHaConectado;
}
	public static void cerrar(Connection con){
		try {
			if(!con.isClosed()) {
				con.close();
			}
		}catch(SQLException sql) {
			JOptionPane.showMessageDialog(Ventana.mensaje(),"No se ha podido realizar la desconexión de la base de datos.");
		}
	}
	
}
