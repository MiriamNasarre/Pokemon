package pokemon.funcionalidad;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import pokemon.Pokemon;

public class Imprime {
	static String numpok;
	public static JComboBox<String> lista=new JComboBox<String>();
	static JLabel pic[]=new JLabel[40];
	static JLabel vul=new JLabel();
	static JLabel res=new JLabel();
	static ImageIcon img[]=new ImageIcon[40];
	static Button evento=new Button("Evento");
	public static Button buscar=new Button("Buscar");
	static int pos=40;
	static int contPos=4;
	static int nuevaPos=0;
	static int posActual=0;
	static int con=0;
	static boolean exist;
	
	public static void vulnerabilidad() {
		img[posActual+4]=new ImageIcon("src/pokemon/tipos/"+Ventana.v[posActual].toLowerCase()+".gif");
		pic[posActual+4].setBounds(pos, 350, 75, 75);
		pic[posActual+4].setIcon(img[posActual+4]);
		pos+=80;
		//imprime vulnerabilidades
		if(Ventana.v.length>1) {
			contPos+=posActual;
		}else {
			contPos++;
		}
	}
	
	public static void resistencias() {
		img[contPos+nuevaPos]=new ImageIcon("src/pokemon/tipos/"+Ventana.r[nuevaPos].toLowerCase()+".gif");
		pic[contPos+nuevaPos].setBounds(pos, 450, 75, 75);
		pic[contPos+nuevaPos].setIcon(img[contPos+nuevaPos]);
		pos+=80;
	}
	
	public static void muestraElementos() {
		vul.setText("Vulnerable a: ");
		res.setText("Resistente a: ");
		
		lista.setBounds(20, 20, Ventana.ancho/4, Ventana.altura/30);
		
		
		//Instancia los objetos JLabel para rellenar con las imagenes.
		for(int picture=0;picture<pic.length;picture++) {
				pic[picture]=new JLabel(img[picture]);
		}
		
		
		
		pic[0].setBounds(20,58, 256, 256);
		pic[1].setBounds(300,58,256,256);
		pic[2].setBounds(40, 280, 75, 75);//tipo1
		pic[3].setBounds(120, 280, 75, 75);//tipo2
		
		
		
		vul.setBounds(40,300,100,100);
		res.setBounds(40,400,100,100);
		evento.setBounds(40,580,50,50);
	
		Ventana.panel.add(lista);
		Ventana.panel.add(vul);
		Ventana.panel.add(res);
		Ventana.panel.add(evento);
		if(Pokemon.opcion==0 | Pokemon.opcion==1) {
			buscar.setBounds(40,20,50,50);
			Ventana.panel.add(buscar);
		}
		buscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent puls) {
				Busqueda.existe=false;
				if(Pokemon.opcion==0 && exist==false) {
						Busqueda.nombre=JOptionPane.showInputDialog("Introduzca el nombre del pokemon: ");
						exist=Busqueda.porNombre();
						
				}else if(Pokemon.opcion==1 && exist ==false) {
					Busqueda.numero=JOptionPane.showInputDialog("Introduzca el número del pokemon: ");
					exist=Busqueda.porNumero();
				}else {
					exist=false;
				}
			}
		});
		
		evento.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent pulsado) {

				if(pulsado.getActionCommand()=="Evento") {
					img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"e.png");
					img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"es.png");
					
					
					pic[0].setIcon(img[0]);
					pic[1].setIcon(img[1]);
					evento.setLabel("Normal");
				}
				
				if(pulsado.getActionCommand()=="Normal") {
					img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"m.png");
					img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ms.png");

					pic[0].setIcon(img[0]);
					pic[1].setIcon(img[1]);
					evento.setLabel("Evento");
				}
				
				
			}	
			
		});

		
	}
	
	
	
	public static void imagenes() {
    	
		borrar();
    	
		anyadir();
    	
    	
    	numpok=String.valueOf(lista.getSelectedItem()).substring(1,4);
    	img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"m.png");
   	 	img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"f.png");
    	
    	
    	if(evento.getLabel()=="Normal") 
    		evento.setLabel("Evento");
    	
    	
    	try {
    		if(lista.getSelectedItem().toString().contains("Squirtle")||lista.getSelectedItem().toString().contains("Wartortle")||lista.getSelectedItem().toString().contains("Blastoise")||lista.getSelectedItem().toString().contains("Stantler")||lista.getSelectedItem().toString().contains("Eevee"))
    				evento.setVisible(true);
    		else
    			evento.setVisible(false);
    		
    		Ventana.t=Listado.tipos[Listado.cuentaPokemon()].split(" ");
    		Ventana.v=Listado.vulnerable[Listado.cuentaPokemon()].split(" ");
       	 	Ventana.r=Listado.resistente[Listado.cuentaPokemon()].split(" ");
    	}catch(Exception err) {
    		JOptionPane.showMessageDialog(Ventana.mensaje(), "No se ha podido cargar la lista de elementos.");
    	}
    	 

    	if(Ventana.t!=null) 
    		img[2]=new ImageIcon("src/pokemon/tipos/"+Ventana.t[0].toLowerCase()+".gif");
    		
    	pic[2].setIcon(img[2]);
		
    	if(Ventana.t.length<2) 
    		pic[3].setIcon(null);
    	else {
    		img[3]=new ImageIcon("src/pokemon/tipos/"+Ventana.t[1].toLowerCase()+".gif");
    		pic[3].setIcon(img[3]);
    		
    	}


	    
    	pos=40;
    	contPos=4;
    	
    	if(Ventana.v!=null) {
    		for(posActual=0;posActual<Ventana.v.length;posActual++) 
				Imprime.vulnerabilidad();
			
    	}
    	
    	
    	pos=40;
    	if(Ventana.r!=null) {
    		for(nuevaPos=0;nuevaPos<=Ventana.r.length-1;nuevaPos++) 
    			Imprime.resistencias();
    	}
		
    	contPos+=Ventana.r.length;
    	img[contPos]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ms.png");
		

		if(img[0].getImageLoadStatus()==4) 
			pic[contPos].setBounds(20,58,256,256);
		else if(img[1].getImageLoadStatus()==4) 
			pic[contPos].setBounds(300,58,256,256);
		else 
			pic[contPos].setBounds(580,58,256,256);
		
		pic[contPos].setIcon(img[contPos]);
		img[contPos+1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fs.png");
    	
		try {
	    	if((lista.getSelectedItem().toString().contains("Alola"))) {
	
	    		img[contPos+1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"a.png");
	    		img[contPos+2]=new ImageIcon("src/pokemon/imagenes/"+numpok+"as.png");
	    		pic[contPos+1].setBounds(20,58,256,256);
	    		pic[contPos+2].setBounds(300,58,256,256);
	    		pic[contPos].setIcon(null);
	
	    	}else if(lista.getSelectedItem().toString().contains("Sunny")||lista.getSelectedItem().toString().contains("Burmy Sandy")||lista.getSelectedItem().toString().contains("Sky")||lista.getSelectedItem().toString().contains("Wormadam Sandy")||lista.getSelectedItem().toString().contains("Siniestro")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"s.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ss.png");
	    		
	    	}else if(lista.getSelectedItem().toString().contains("Rainy")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"l.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ls.png");
	    		
	    	}else if(lista.getSelectedItem().toString().contains("Snowy")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"n.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ns.png");
	    		
	    	}else if(lista.getSelectedItem().toString().contains("Defense")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"d.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ds.png");
	    		
	    	}else if(lista.getSelectedItem().toString().contains("Speed")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"v.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"vs.png");
	    		
	    	}else if(lista.getSelectedItem().toString().contains("Attack")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"at.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ats.png");
	    		
	    		
	    	}else if(lista.getSelectedItem().toString().contains("Burmy Trash")||lista.getSelectedItem().toString().contains("Wormadam Trash")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"t.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ts.png");
	    	
	    	}else if(lista.getSelectedItem().toString().contains("East")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"e.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"es.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Rotom Heat")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"h.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"hs.png");
			    	
	    	}else if(lista.getSelectedItem().toString().contains("Wash")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"w.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ws.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Frost")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fr.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"frs.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Rotom Fan")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fa.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fas.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Mow")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"mo.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"mos.png");
		    	
	
	    	}else if(lista.getSelectedItem().toString().contains("Origin")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"o.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"os.png");
			    	
	    	}else if(lista.getSelectedItem().toString().contains("Hielo")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"h.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"hs.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Planta")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"pl.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"pls.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Agua")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ag.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ags.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Fuego")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fu.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fus.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Dragón")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"d.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ds.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Hada")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ha.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"has.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Bicho")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"b.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"bs.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Electrico")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"el.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"els.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Fantasma")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fa.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"fas.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Psiquico")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ps.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"pss.png");
		
	    	}else if(lista.getSelectedItem().toString().contains("Volador")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"v.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"vs.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Acero")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ac.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"acs.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Tierra")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"t.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ts.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Roca")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"r.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"rs.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Lucha")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"l.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ls.png");
		    	
	    	}else if(lista.getSelectedItem().toString().contains("Veneno")){
	    		pic[contPos].setIcon(null);
	    		img[0]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ve.png");
	    		img[1]=new ImageIcon("src/pokemon/imagenes/"+numpok+"ves.png");
	    	}else {
	    		pic[contPos+1].setBounds(858,58,256,256);
	    	
	    	}
	    	pic[contPos+1].setIcon(img[contPos+1]);
	    	pic[contPos+2].setIcon(img[contPos+2]);
	    	
			if(img[0].getImage()!=null && !lista.getSelectedItem().toString().contains("Alola")) {
				pic[0].setIcon(img[0]);
			}
			
			if(img[1].getImage()!=null && !lista.getSelectedItem().toString().contains("Alola")) {
				pic[1].setIcon(img[1]);
			}
			
	}catch(Exception e) {
		
	}

  }
	
	
	public static void borrar() {
		for(con=0;con<pic.length;con++) {
    		img[con]=null;
    		pic[con].setIcon(null);

    	}
	}
	
	public static void anyadir() {
		for(int picture=0;picture<pic.length;picture++) {
			Ventana.panel.add(pic[picture]);
		}
	}
}


