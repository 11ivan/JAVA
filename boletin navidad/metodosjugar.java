//metodosjugar.java

public class metodosjugar{
				/*menujugar
		 * INTERFAZ
		 * Proposito: mostrar un menu de opciones
		 * Prototipo: void menujugar()
		 * Precondiciones: no hay
		 * Entradas: no hay
		 * Salidas: no hay
		 * E/S: no hay
		 * Postcondiciones: no hay
		 */
		 //RESGUARDO
		 //public static void menujugar(){System.out.println("MENU");}
		 public static void menujugar(){
			 
			 System.out.println("Elija una opcion del menu");
			 System.out.println("0: Salir");
			 System.out.println("1: Jugar CHICAGO");
			 System.out.println("2: Jugar BARBUDI");
			 System.out.println("3: Jugar CHINOS");
		}
		 
//---------------------------------------------------------------------------------------------
				/*sumadados
		 * INTERFAZ
		 * Proposito: suma dos numero
		 * Prototipo: int sumadados(int dado1,int dado2)
		 * Precondiciones: no hay
		 * Entradas: dos enteros
		 * Salidas: un entero AN
		 * E/S: no hay
		 * Postcondiciones: el entero sera la suma los dos numeros
		 */
		 //RESGUARDO
		 //public static int sumadados(int dado1,int dado2){return 1;}
		 public static int sumadados(int dado1,int dado2){
			 int suma=0;

			 suma=dado1+dado2;
			 return (suma);			 
		}
		 
//---------------------------------------------------------------------------------------------	
				/*compempate
		 * INTERFAZ
		 * Proposito: comprueba dos numeros y dice cual es mas alto
		 * Prototipo: int compruebasuma(int sumdad1,int sumdad2)
		 * Precondiciones: no hay
		 * Entradas: dos enteros
		 * Salidas: un entero AN
		 * E/S: no hay
		 * Postcondiciones: el entero sera 1 si el primer entero es mayor 2 si es menor y tres si son iguales
		 */
		 //RESGUARDO
		 //public static int compempate(int sumdad1,int sumdad2){return 1;}
		 public static int compempate(int sumdad12,int sumdad34){
			int mayor;
			
			if(sumdad12>sumdad34){
				mayor=1;
				}else if(sumdad12<sumdad34){
					mayor=2;
					}else 
						mayor=3;
				
			 return (mayor);			 
		}
		 
//---------------------------------------------------------------------------------------------	
				/*apuesta
		 * INTERFAZ
		 * Proposito: comprueba un numero, si es 1 el jugador apostara primero y si es dos la maquina apostara primero
		 * Prototipo: 
		 * Precondiciones: no hay
		 * Entradas: 
		 * Salidas: un entero AN
		 * E/S: no hay
		 * Postcondiciones: 
		 */
		 //RESGUARDO


		 
//---------------------------------------------------------------------------------------------	
				/*compclave
		 * INTERFAZ
		 * Proposito: recibe tres numeros dado1,dado2,clave; y dice si alguno de ellos o la suma de ambos coincide con la clave
		 * Prototipo: boolean compclave(int dado1,int dado2,int clave);
		 * Precondiciones: no hay
		 * Entradas: tres enteros
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si algun dado o la suma de ambos coincide con la clave y falso si no
		 */
		 //RESGUARDO
		//public static boolean compclave(int dado1,int dado2,int clave){return true;}

		public static boolean compclave(int dado1,int dado2,int clave){
			int suma=0;
			boolean coincide=false;
			
			suma=sumadados(dado1,dado2);
			
			if(dado1==clave){
				coincide=true;
				}else if(dado2==clave){
					coincide=true;
					}else if(suma==clave){
					coincide=true;
					}
					
			return (coincide);
		}
		 
//---------------------------------------------------------------------------------------------	
















}
