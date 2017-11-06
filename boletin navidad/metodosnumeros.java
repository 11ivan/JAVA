public class metodosnumeros{
	
		/* submenunumeros
		 * INTERFAZ
		 * Proposito: Mostrar un menu de opciones
		 * Prototipo: void submenunumeros()
		 * Precondiciones: no hay
		 * Entradas: no hay
		 * Salidas: no hay
		 * E/S: no hay
		 * Postcondiciones: no hay
		 */
		 //RESGUARDO
		 //public static void submenunumeros(){System.out.println("En construccion");}
		 
			public static void submenunumeros(){
				System.out.println("Elija una opcion del menu");
				System.out.println("0: Salir");
				System.out.println("1: Numero compuesto");
				System.out.println("2: Numero perfecto");
				System.out.println("3: Numero semiperfecto");
				System.out.println("4: Numero friki");
				System.out.println("5: Numero primo probable");
			}
//---------------------------------------------------------------------------------------------
				/* compuesto
		 * INTERFAZ
		 * Proposito: Comprobar si un numero es compuesto
		 * Prototipo: boolean compuesto(int numero)
		 * Precondiciones: no hay
		 * Entradas: un numero entero
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si el numero es compuesto y falso si no
		 */
		 //RESGUARDO
		 //public static boolean compuesto(int numero){return (true);}
		 
			public static boolean compuesto(int numero){
				boolean escompuesto=false;
				int contador,acumulador=0;
				for(contador=1;contador<=numero;contador++){
					if(numero%contador==0){
						acumulador++;
					}
				}
				if(acumulador>2){
					escompuesto=true;
				}
				return (escompuesto);
			}
			
//---------------------------------------------------------------------------------------------
				/*perfecto
		 * INTERFAZ
		 * Proposito: Comprobar si un numero es perfecto
		 * Prototipo: boolean perfecto(int numero)
		 * Precondiciones: no hay
		 * Entradas: un numero entero
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si el numero es perfecto y falso si no
		 */
		 //RESGUARDO
		 //public static boolean perfecto(int numero){return (true);}
		 
			public static boolean perfecto(int numero){
				boolean esperfecto=false;
				int sumas=0;
				int contador;
				
				for(contador=1;contador<numero-1;contador++){
					 if(numero%contador==0){
					  sumas=sumas+contador; 
				  }
				} 
				if (sumas==numero){
					 esperfecto=true;
					 }									
				return (esperfecto);
			}
						

//---------------------------------------------------------------------------------------------

				/*semiperfecto
		 * INTERFAZ
		 * Proposito: Comprobar si un numero es semiperfecto
		 * Prototipo: boolean semiperfecto(int numero)
		 * Precondiciones: no hay
		 * Entradas: un numero entero
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si el numero es semiperfecto y falso si no
		 */
		 //RESGUARDO
		 //public static boolean semiperfecto(int numero){return (true);}
		 
			public static boolean semiperfecto(int numero){
				boolean essemiperfecto=false;
				int sumas=0;
				int contador;
				
				for(contador=1;contador<numero;contador++){
					 if(numero%contador==0){
					  sumas=sumas+contador; 
				  }
				  System.out.println(sumas);
				} 
				System.out.println(sumas);
				if (sumas==numero){
					 essemiperfecto=true;
					 }									
				return (essemiperfecto);
			}
						

//---------------------------------------------------------------------------------------------

				/*friki
		 * INTERFAZ
		 * Proposito: Comprobar si un numero es friki
		 * Prototipo: boolean friki(int numero)
		 * Precondiciones: no hay
		 * Entradas: dos numero entero
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si el numero es friki y falso si no
		 */
		 //RESGUARDO
		 //public static boolean friki(int digito1,int digito2){return (true);}
		 
			/*public static boolean friki(int digito1,int digito2){
				boolean esfriki=false;
				
				if(digito1+digito2==13 && digito1%7==0 && digito2%7==0){
					esfriki=true;
					}
					System.out.println(digito1+digito2);
									
				return (esfriki);
			}*/
			

//---------------------------------------------------------------------------------------------

















}
