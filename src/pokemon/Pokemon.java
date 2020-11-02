package pokemon;

import javax.swing.JOptionPane;

import pokemon.funcionalidad.Busqueda;
import pokemon.funcionalidad.Conexion;
import pokemon.funcionalidad.Imprime;
import pokemon.funcionalidad.Listado;
import pokemon.funcionalidad.Ventana;

public class Pokemon {
	static boolean conexion=false;
	static String mensaje="Buscar pokémon por: ";
	static Object [] opc= {"Nombre","Número","Listado"};
	public static int opcion;
	public static void main (String[]args) {
		Conexion.abrir();
		conexion=Conexion.compruebaConexion(Conexion.con);
		if(conexion) {	
			Listado.llenaLista(Conexion.con, Conexion.st, Conexion.rs);
			Conexion.cerrar(Conexion.con);
			opcion=JOptionPane.showOptionDialog(null, "Seleccione una opción", mensaje,
				    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, opc,opc[0]);
			if(opcion==JOptionPane.YES_OPTION) {
				Imprime.lista.setVisible(false);
				Busqueda.nombre=JOptionPane.showInputDialog("Introduzca el nombre del pokemon: ");
				Busqueda.porNombre();
				Ventana.panelListado();
				Ventana.marco();
			}else if(opcion==JOptionPane.NO_OPTION) {
				Imprime.lista.setVisible(false);
				Busqueda.numero=JOptionPane.showInputDialog("Introduzca el número del pokemon: ");
				Busqueda.porNumero();
				Ventana.panelListado();
				Ventana.marco();
			}else if(opcion==JOptionPane.CANCEL_OPTION) {
				Ventana.panelListado();
				Ventana.marco();
			}
		}

	}
	
}


