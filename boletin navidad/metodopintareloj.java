//metodopintareloj.java
public class metodopintareloj{

				/*impar
		 * INTERFAZ
		 * Proposito: Comprobar si un numero es impar
		 * Prototipo: boolean impar(int numero)
		 * Precondiciones: el numero estara entre 1 y 15
		 * Entradas: un numero entero
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si el numero es impar y falso si no
		 */
		 //RESGUARDO
		 //public static boolean impar(int numero){return (true);}
		 public static boolean impar(int numero){
			boolean valido=false;
			boolean novale=false;
			
			novale=entre1y15(numero);
			
			if(novale==false){
				valido=false;
				}else if(numero%2!=0){
					valido=true;
				}
			return (valido);
		}
			

//---------------------------------------------------------------------------------------------
				/*entre1y15
		 * INTERFAZ
		 * Proposito: Comprobar si un numero esta entre 1 y 15
		 * Prototipo: boolean entre1y15(int numero)
		 * Precondiciones: no hay
		 * Entradas: un numero entero
		 * Salidas: un booleano AN
		 * E/S: no hay
		 * Postcondiciones: el booleano sera verdadero si el numero esta entre 1 y 15 y falso si no
		 */
		 //RESGUARDO
		 //public static boolean entre1y15(int numero){return (true);}
		 public static boolean entre1y15(int numero){
			boolean valido=false;
			
			if (numero>=1 && numero<=15){
				valido=true;
				}
			return (valido);
		}
			

//---------------------------------------------------------------------------------------------
				/*pintareloj
		 * INTERFAZ
		 * Proposito: pinta un reloj de arena
		 * Prototipo: void pintareloj(int numero,char caracter)
		 * Precondiciones: el numero sera impar entre 1 y 15
		 * Entradas: un numero entero y un caracter
		 * Salidas: no hay
		 * E/S: no hay
		 * Postcondiciones: no hay
		 */
		 //RESGUARDO
		 //public static  void pintareloj(int numero,char caracter){System.out.println("En contruccion");;}
		 public static  void pintareloj(int base,char caracter){
			 
			int contador1=base,contador2,contadorx;
			
			for(;contador1>=1;contador1=contador1-2){
					/*if(contador1==base-14){
						System.out.print(" "+" "+" "+" "+" "+" "+" ");
						}else if(contador1==base-12){
							System.out.print(" "+" "+" "+" "+" "+" ");
							}else if(contador1==base-10){
								System.out.print(" "+" "+" "+" "+" ");
								}else if(contador1==base-8){
									System.out.print(" "+" "+" "+" ");
									}else if(contador1==base-6){
										System.out.print(" "+" "+" ");
										}else if(contador1==base-4){
											System.out.print(" "+" ");
											}else if(contador1==base-2){
												System.out.print(" ");
												}*/
				for(contadorx=1;contadorx<=base-contador1;contadorx=contadorx+2){
					System.out.print(" ");
					}

						
				for(contador2=0;contador2<contador1;contador2++){

					System.out.print(caracter);
				}
				System.out.println("");

			}
			//2ª MITAD
			for(contador1=1;contador1<=base;contador1=contador1+2){
				
							
										/*if(contador1==base-2){
											System.out.print(" ");
											}else if(contador1==base-4){
												System.out.print(" "+" ");
												}else if(contador1==base-6){
													System.out.print(" "+" "+" ");
													}else if(contador1==base-8){
														System.out.print(" "+" "+" "+" ");
														}else if(contador1==base-10){
															System.out.print(" "+" "+" "+" "+" ");
															}else if(contador1==base-12){
																System.out.print(" "+" "+" "+" "+" "+" ");
																}*/
													
				if(contador1>1){
					for(contadorx=1;contadorx<=base-contador1;contadorx=contadorx+2){
					System.out.print(" ");
					}
					for(contador2=1;contador2<=contador1;contador2++){

						System.out.print(caracter);
					}

					System.out.println("");
				}
			}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
