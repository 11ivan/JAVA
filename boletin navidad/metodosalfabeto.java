//metodosalfabeto.java
public class metodosalfabeto{

/* menuprincipal
 * INTERFAZ
 * Proposito: Mostrar un menu de opciones
 * Prototipo: void menuprincipal()
 * Precondiciones: no hay
 * Entradas: no hay
 * Salidas: no hay
 * E/S: no hay
 * Postcondiciones: no hay
 */
 //RESGUARDO
 //public static void menuprincipal(){System.out.println("En construccion");}
 
	public static void menuprincipal(){
		System.out.println("Elija una opcion del menu");
		System.out.println("0: Salir");
		System.out.println("1: Trabajar con caracteres");
		System.out.println("2: Trabajar con numeros");
		System.out.println("3: Trabajar con fechas");
		System.out.println("4: Jugar");
		System.out.println("5: Pintar reloj de arena");
	}
//---------------------------------------------------------------------------------------------
/* submenucaracteres
 * INTERFAZ
 * Proposito: Mostrar un menu de opciones
 * Prototipo: void submenucaracteres()
 * Precondiciones: no hay
 * Entradas: no hay
 * Salidas: no hay
 * E/S: no hay
 * Postcondiciones: no hay
 */
 //RESGUARDO
 //public static void submenucaracteres(){System.out.println("En construccion");}
 
	public static void submenucaracteres(){
		System.out.println("Elija una opcion del menu");
		System.out.println("0: Salir");
		System.out.println("1: Comparar caracteres del alfabeto");
		System.out.println("2: Letra mayuscula o minuscula");
		System.out.println("3: Simbolo de puntuacion");
		System.out.println("4: Digito entre 0 y 9");
		System.out.println("5: Mensaje graciosillo");
	}
//---------------------------------------------------------------------------------------------

/*compruebacaracter
 * INTERFAZ
 * Proposito: Recibe un caracter y devuelve verdadero si es del alfabeto y falso si no lo es
 * Prototipo: boolean compruebacaracter(char caracter)
 * Precondiciones: no hay
 * Entradas: un caracter
 * E/S: no hay
 * Salidas: un booleano A/N
 * Postcondiciones: el booleano sera verdadero si es un caracter del alfabeto y falso si no
 */
//RESGUARDO
	/*public static boolean compruebacaracter(char caracter){
		return false;	
	}*/
public static boolean compruebacaracter(char caracter){
		boolean valido=false;
		if(caracter>='a' && caracter<='z' || caracter>='A' && caracter<='Z' || caracter=='\u00f1' || caracter=='\u00d1'){
			valido=true;
			}
		return (valido);
}

//---------------------------------------------------------------------------------------------


/*comparacaracteres
 * INTERFAZ
 * Proposito: Compara dos caracteres y dice si el primero es anterior posterior o igual que el segundo
 * Prototipo: int comparacaracteres(char caracter1,char caracter2)
 * Precondiciones: los caracteres son del alfabeto
 * Entradas: dos caracteres
 * E/S: 
 * Salidas: A/N un numero entero
 * Postcondiciones: el numero sera 1 si es posterior, 2 si es anterior, 3 si es igual
 */
//RESGUARDO
/*public static int comparacaracteres(char caracter1,char caracter2){
	return 1;
	}*/
public static int comparacaracteres(char caracter1,char caracter2){
	int devuelve;
	if(caracter1>caracter2){
		devuelve=1;
		}else if(caracter1<caracter2){
			devuelve=2;
			}else
				devuelve=3;
	
		return (devuelve);
	}

//---------------------------------------------------------------------------------------------


/*		mayuscula
 * INTERFAZ
 * Proposito: Comprueba si una letra del alfabeto es mayuscula
 * Prototipo: boolean mayuscula(char letra)
 * Precondiciones: la letra es del alfabeto
 * Entradas: un caracter
 * E/S: no hay
 * Salidas: A/N un booleano
 * Postcondiciones: el booleano sera verdadero si la letra es mayuscula y falso sino
 */
//RESGUARDO
//public static boolean mayuscula(char letra){return true;}
	public static boolean mayuscula(char letra){
			boolean esmayusc=false;
			if(letra>='A' && letra<='Z'){
				esmayusc=true;
				}
				return (esmayusc);
		}
//---------------------------------------------------------------------------------------------


/*		simbolopuntuacion
 * INTERFAZ
 * Proposito: Comprueba si una letra del alfabeto es mayuscula
 * Prototipo: boolean simbolopuntuacion(char caracter1)
 * Precondiciones: no hay
 * Entradas: un caracter
 * E/S: no hay
 * Salidas: A/N un booleano
 * Postcondiciones: el booleano sera verdadero si la letra es mayuscula y falso sino
 */
//RESGUARDO
//public static boolean mayuscula(char letra){return true;}
	/*public static boolean simbolopuntuacion(char caracter1){
			boolean puntuacion=false;
			if(caracter1=="," || caracter1==";" || caracter1=="." || caracter1==":" || caracter1=="-" || caracter1=="_" || caracter1=="´" || caracter1=='¨' || caracter1=='{' || caracter1=='}'){
				puntuacion=true;
				}
				return (puntuacion);*
		}*/

//---------------------------------------------------------------------------------------------


/*		estain09
 * INTERFAZ
 * Proposito: Comprueba si una letra del alfabeto es mayuscula
 * Prototipo: int estain09(char digito)
 * Precondiciones: no hay
 * Entradas: un caracter
 * E/S: no hay
 * Salidas: A/N un entero
 * Postcondiciones: el int sera 1 si el digito esta entre 0 y 9, 0 si no
 */
//RESGUARDO
//public static int estain09(char digito){return true;}
	public static int estain09(char digito){
			int esta=0;
			if(digito>='0' && digito<='9'){
				esta=1;
				}
				return (esta);
		}
//---------------------------------------------------------------------------------------------


/*		mensaje
 * INTERFAZ
 * Proposito: Recibe un digito y escribe una frase que rime con el numero
 * Prototipo: void mensaje(char digito)
 * Precondiciones: el digito esta entre 0 y 9
 * Entradas: un caracter
 * E/S: no hay
 * Salidas: no hay
 * Postcondiciones: no hay
 */
//RESGUARDO
//public static void mensaje(char digito){return true;}
	public static void mensaje(char digito){
			switch(digito){
				case 0:
							System.out.println("MENSAJE");
				
				break;
				
				case 1:
							System.out.println("MENSAJE");
				
				break;
				
				case 2:
							System.out.println("MENSAJE");
				
				break;
				
				case 3:
							System.out.println("MENSAJE");
				
				break;
				
				case 4:
							System.out.println("MENSAJE");
				
				break;
				
				case 5:
							System.out.println("MENSAJE");
				
				break;
				
				case 6:
							System.out.println("MENSAJE");
				
				break;
				
				case 7:
							System.out.println("MENSAJE");
				
				break;
				
				case 8:
							System.out.println("MENSAJE");
				
				break;
				
				case 9:
							System.out.println("MENSAJE");
				
				break;
				}
		}




}












