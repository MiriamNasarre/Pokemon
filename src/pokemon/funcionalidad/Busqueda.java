package pokemon.funcionalidad;

public class Busqueda {
	public static String nombre;
	static String nombreBusqueda = "";
	static String []nombreCompleto=new String[2];
	public static String numero="";
	static String numerob="#";
	static boolean existe;
	static int pos;
	static int contador=0;
	public static boolean porNombre() {
			
			try {
				if (nombre.length()>0 && nombre.charAt(0)!=' ' && nombre.charAt(nombre.length()-1)!=' '){	
					nombre=nombre.replaceAll("\\s+"," ");
					if(nombre.length()>0 && nombre.contains(" ")) {
						nombreCompleto=nombre.split(" ");
						nombreBusqueda=nombreCompleto[0].toUpperCase().charAt(0)+nombreCompleto[0].substring(1).toLowerCase()+" "+nombreCompleto[1].toUpperCase().charAt(0)+nombreCompleto[1].substring(1).toLowerCase();
					}else if(nombre.trim().length()>0){
						nombreBusqueda=nombre.toUpperCase().charAt(0)+nombre.substring(1).toLowerCase();
					}
					System.out.println(nombreBusqueda);
					for(contador=0;contador<Listado.nomb.length;contador++) {
						if(nombreBusqueda.equals(Listado.nomb[contador])) {
							existe=true;
							System.out.println(existe);
							numero=Listado.numpoke[contador];

							
							if(existe) {
								pos=contador;
								Ventana.pos=contador;
								Imprime.lista.setSelectedIndex(contador);
								break;
							}
						}
						
				}
					
					
					
				}
				}catch(NullPointerException npe){
					
				}
			return existe;
		}
		
	
		public static boolean porNumero(){	
			try {
					
				
				if(numero.length()==1) {
					numerob+="00"+numero;
				}else if(numero.length()==2) {
					numerob+="0"+numero;
				}else {
					numerob+=numero;
				}
				
					
					
					if (numerob.length()>0 && numerob.charAt(0)!=' ' && numerob.charAt(numerob.length()-1)!=' '){	
						numerob=numerob.replaceAll("\\s+"," ");
						
						
						System.out.println(numerob);
						for(int contador=0;contador<Listado.numpoke.length;contador++) {
							if(numerob.equals(Listado.numpoke[contador])) {
								existe=true;
								numerob=Listado.numpoke[contador];
								System.out.println(existe);
								if(existe) {
									pos=contador;
									Ventana.pos=contador;
									Imprime.lista.setSelectedIndex(contador);
									break;
								}
							}
							
					}
						
						
					}
					}catch(NullPointerException npe){
						
					}
			numerob="#";
			return existe;
		}
		
	}
	

