package pokemon.funcionalidad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;



public class Listado {
	static String tipos[]=new String [550];
	static String vulnerable[]=new String [550];
	static String resistente[]=new String [550];
	static String numpoke[]=new String [550];
	static String nomb[]=new String [550];
	public static void llenaLista(Connection con , Statement st, ResultSet rs) {
		int cont=0;
        try {
        	rs=st.executeQuery("SELECT * FROM pokemon");	
			while (rs.next()) {
			   Imprime.lista.addItem(rs.getString("num_pok").substring(0, 4)+" "+rs.getString("nombre"));
			   numpoke[cont]=rs.getString("num_pok");
			   nomb[cont]=rs.getString("nombre");
			   tipos[cont]=rs.getString("tipos");
			   vulnerable[cont]=rs.getString("vulnerable");
			   resistente[cont]=rs.getString("resistente");
			   cont++;
			
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(Ventana.mensaje(), "No existen registros en la base de datos.");
		}    

	}
	
	public static int cuentaPokemon() {
		int cuenta=0;
		cuenta=Imprime.lista.getSelectedIndex();
		return cuenta;
	}
	
	
	
}
