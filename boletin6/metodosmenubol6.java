//metodosmenubol6.java

public class metodosmenubol6{

	/*menuprincipal*/
	//INTERFAZ	
	/*
	 * Comentario: Presenta el menu prinipal
	 * Prototipo: void menuprincipal()
	 * Precondiciones: N/A
	 * Entradas: N/A
	 * Salidas: N/A
	 * E/S: N/A
	 * Postcondiciones: N/A 
	 */
	 //RESGUARDO
	/* public static void menuprincipal{
		System.out.println("En construccion");
	}*/
	public static void menuprincipal(){
		System.out.println("Elija una opcion del menu");
		System.out.println("0: Salir");
		System.out.println("1: Calculos circunferencia");
		System.out.println("2: N/A");
	}
//____________________________________________________________________

	/*menucircunferencia*/
	//INTERFAZ	
	/*
	 * Comentario: Presenta el menu para calculos de la circunferencia
	 * Prototipo: void menucircunferencia()
	 * Precondiciones: N/A
	 * Entradas: N/A
	 * Salidas: N/A
	 * E/S: N/A
	 * Postcondiciones: N/A 
	 */
	 //RESGUARDO
	/* public static void menucircunferencia{
		System.out.println("En construccion");
	}*/
	public static void menucircunferencia(){
		System.out.println("Elija una opcion del menu");
		System.out.println("0: Salir");
		System.out.println("1: Longitud circunferencia");
		System.out.println("2: Area circunferencia");
		System.out.println("3: Volumen esfera");
	}
//____________________________________________________________________
	
	/*validaradio*/
	//INTERFAZ	
	/*
	 * Comentario: Valida el radio introducido
	 * Prototipo: boolean validaradio(float radio)
	 * Precondiciones: No hay
	 * Entradas: Un numero real
	 * Salidas: AN un booleano
	 * E/S: N/A
	 * Postcondiciones: el booleano sera veradero en caso de que el radio sea correcto y falso de lo contrario
	 */
	 //RESGUARDO
	/* public static boolean validaradio(double radio){
		System.out.println("En construccion");
		return false;
	}*/
	public static boolean validaradio(double radio){
		boolean vale=false;
		if(radio<=0){
			vale=false;
			}else
				vale=true;
		return (vale);
	}
//____________________________________________________________________
	
		/*LONGITUDCIRCUNF*/
	//INTERFAZ	
	/*
	 * Comentario: clacula la longitud de la circunferencia
	 * Prototipo: double longitudcincunf(double radio,double pi)
	 * Precondiciones: El radio sera mayor que 0
	 * Entradas: Un numero real
	 * Salidas: AN un booleano
	 * E/S: N/A
	 * Postcondiciones: el booleano sera veradero en caso de que el radio sea correcto y falso de lo contrario
	 */
	 //RESGUARDO
	/* public static boolean validaradio(float radio){
		System.out.println("En construccion");
		return false;
	}*/
	public static double longitudcincunf(double radio,double pi){   //L=2*pi*r
		double longitud;
		longitud=(2.0*pi)*radio;
		return (longitud);
	}
//____________________________________________________________________
	
	
	
	
	
	
}
