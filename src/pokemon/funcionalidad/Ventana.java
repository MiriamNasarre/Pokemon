package pokemon.funcionalidad;

import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Ventana {

	public static int ancho=1200;
	static int altura=600;
	static Image icono;
	static JPanel panel=new JPanel();
	public static int pos=0;
	public static JFrame marco=new JFrame();
	
	
	
	
	static String t[]=new String[2];
	static String v[]=new String[12];
	static String r[]=new String[12];

	
	
	
	public static void marco() {
		panel=(JPanel) panelListado();
		marco.setBounds(0,0,ancho,altura-40);
		marco.setTitle("Pokemons");
		icono=new ImageIcon("src/pokemon/p.jpg").getImage();
		marco.setIconImage(icono);
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.add(panel);
		
		marco.setResizable(false);
		Imprime.lista.setSelectedIndex(pos);
		marco.setLocationRelativeTo(null);
		marco.setVisible(true);
	}
	
	
	public static Component panelListado() {
		panel.setLayout(null); 
		

		Imprime.muestraElementos();

		t=Listado.tipos[0].split(" ");
		v=Listado.vulnerable[0].split(" ");
		r=Listado.resistente[0].split(" ");
	
		Imprime.lista.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	Imprime.imagenes();
		    }
		    
		});
		return panel;
	}
	
	public static Component mensaje() {
		JPanel mensaje=new JPanel();
		return mensaje;
	}
	
	
	public static void nuevoPanel() {
		marco.getContentPane().remove(panel);
		Imprime.lista.setSelectedIndex(Busqueda.pos);
		JPanel nuevoPanel=(JPanel) panelListado();
		marco.getContentPane().add(nuevoPanel);
		marco.invalidate();
		marco.validate();
	}
	
	
	
	

}
