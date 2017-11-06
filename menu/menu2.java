//menu.java
/**
 *Analisis
 * 	Proposito: Ejecutar programa elegido por el usuario.
 * 			   Los programas son: 0. Para salir.
 * 								  1. Calcular el factorial de un numero entero.
 * 								  2. Leer de teclado un número y
 * 			 						 calcular la cantidad de dígitos que tiene. 
 * 								  3. Programa que imprima, cuente y sume los múltiplos de 5 que
 *  								 hay entre 1 y un número leído por teclado. 
 * 	Entradas: Para el menu un caracter.
 * 			  Para el factorial: un numero.
 * 			  Para la cantidad de digitos: un numero.
 * 			  Para los multiplos de 5: un numero.
 * 
 * 	Salidas:  Para el factorial: Factorial del numero introducido
 * 			  Para la cantidad de digitos un numero: la catidad de digitos del numero introducido
 * 			  Para los multiplos de 5: La cantidad, la suma y todos los multiplos.
 * 
 *  Restricciones: Solo numeros en el menu.
 * 				   Para el factorial: Solo numero positivo.
 * 			 	   Para la cantidad de digitos un numero: Introducir solo numeros.
 * 				   Para los multiplos de 5: El numero introducido no debe ser mayor que 100.
 * 
 * PSEUDOCODIGO GENERALIZADO
 * 
 *INICIO	
 * 	PRESENTAR Y VALIDAR OPCION DEL MENU						//EL MENU SE REPETIRA MIENTRAS LA OPCION ELEGIDA SEA MENOR QUE 0 Ó MAYOR QUE 3			
 * 	MIENTRAS OPCION SEA DISTINTO A 0
 * 		SEGUN (OPCION)
 * 			CASO 1:	
 * 						PREGUNTAR Y VALIDAR SI EJECUTA
 * 						MIENTRAS EJECUTA SEA IGUAL A S
 * 							LEER Y VALIDAR NUMERO
 * 							CALCULAR FACTORIAL
 * 							ESCRIBIR FACTORIAL
 * 							PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR
 * 						FIN MIENTRAS
 * 			FIN CASO 1
 * 
 * 			CASO 2:
 * 						PREGUNTAR Y VALIDAR SI EJECUTA
 * 						MIENTRAS EJECUTA SEA IGUAL A S
 * 							LEER Y VALIDAR NUMERO
 * 							CONTAR DIGITOS
 * 							ESCRIBIR DIGITOS
 * 							PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR
 * 						FIN MIENTRAS
 * 			FIN CASO 2
 * 
 * 			CASO 3:
 * 						PREGUNTAR Y VALIDAR SI EJECUTA
 * 						MIENTRAS EJECUTA SEA IGUAL A S
 * 							LEER Y VALIDAR NUMERO LIMITE
 * 							CONTAR SUMAR Y ESCRIBIR MULTIPLOS DE 5
 * 							ESCRIBIR SUMA DE MULTIPLOS
 * 							ESCRIBIR CANTIDAD DE MULTIPLOS
 * 							PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR
 * 						FIN MIENTRAS
 * 			FIN CASO 3
 * 		FIN SEGUN
 * 	VOLVER A PRESENTAR Y VALIDAR OPCION DEL MENU	
 * 	FIN MIENTRAS
 *FIN
*/

import java.util.Scanner;//IMPORTAMOS CLASE SCANNER
import java.lang.Character;//IMPORTAMOS CLASE CHARACTER

public class menu2{	
	public static void main(String[] args){
			//DECLARAMOS VARIABLES
			Scanner entrada=new Scanner(System.in);
			char ejecuta=' ';//VARIABLE PARA VALIDAR EJECUCION
			int opcion;
			int factorial,numero,contador;//VARIABLES PROGRAMA FACTORIAL
			int numero2,contadordig;//VARIABLES PROGRAMA CONTAR DIGITOS
			int numero3,cantidadmult,sumamult,contador3;//VARIABLES PROGRAMA MULTIPLOS
			
			
			//PRESENTAR Y VALIDAR OPCION DEL MENU
			do{
				System.out.println("Menú:");
				System.out.println("Introduzca 0 para salir");
				System.out.println("Introduzca 1 para calcular factorial");
				System.out.println("Introduzca 2 para contar dígitos");
				System.out.println("Introduzca 3 para contar y sumar múltiplos de cinco");
				opcion=entrada.nextInt();
				System.out.println("////////////////////////////////////////////////////////////");
				}while(opcion<0 || opcion>3);
				
			//MIENTRAS OPCION SEA DISTINTO A 0
			while(opcion!=0){
				
					//SEGUN (OPCION)
					switch(opcion){
						
						case 1:	
									//PREGUNTAR Y VALIDAR SI EJECUTA
									do{
										System.out.println("¿Quiere ejecutar?S/N");
										ejecuta=Character.toLowerCase(entrada.next().charAt(0));
										}while(ejecuta!='s' && ejecuta!='n');
										
									//MIENTRAS EJECUTA SEA IGUAL A S
									while(ejecuta=='s'){
										
										//LEER Y VALIDAR NUMERO
										do{
											System.out.println("Introduzca un número para calcular factorial");
											numero=entrada.nextInt();
											}while(numero<0);
										
										//CALCULAR FACTORIAL
										factorial=1;
										for(contador=1;contador<=numero;contador++){
												factorial=factorial*contador;
											}
										
  										//ESCRIBIR FACTORIAL
  										System.out.println("El factorial de "+numero+" es "+factorial);
  										//PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR
										do{
										System.out.println("¿Quiere volver a ejecutar? S/N");
										ejecuta=Character.toLowerCase(entrada.next().charAt(0));
										}while(ejecuta!='s' && ejecuta!='n');
									}//FIN MIENTRAS
								break;	
  										
  							case 2:
										//PREGUNTAR Y VALIDAR SI EJECUTA
										do{
										System.out.println("¿Quiere ejecutar? S/N");
										ejecuta=Character.toLowerCase(entrada.next().charAt(0));
										}while(ejecuta!='s' && ejecuta!='n');
										
  										//MIENTRAS EJECUTA SEA IGUAL A S
										while(ejecuta=='s'){
																								//en construccion
											//LEER Y VALIDAR NUMERO								//System.out.println("ESTAMOS DE OBRAS");
											//do{
												System.out.println("Introduzca un numero");
												numero2=entrada.nextInt();
											//	}while(numero);//FIN MIENTRAS
  											
  											//COMPROBAR NUMERO 0
  											if(numero2==0){System.out.println("La cantidad de dígitos es 1");
											}else{
  											
												//CONTAR DIGITOS
												contadordig=0;
  											
												while(numero2!=0){
													numero2=numero2/10;
													contadordig++;
													}//FIN MIENTRAS
											
													//ESCRIBIR DIGITOS
													System.out.println("La cantidad de dígitos es "+contadordig);
													}
  											//PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR
  											do{
												System.out.println("¿Quiere volver a ejecutar? S/N");
												ejecuta=Character.toLowerCase(entrada.next().charAt(0));
												}while(ejecuta!='s' && ejecuta!='n');//FIN MIENTRAS
												
  										}//FIN MIENTRAS
									break;
						
							case 3:	
										//PREGUNTAR Y VALIDAR SI EJECUTA
										do{
											System.out.println("¿Quiere ejecutar? S/N");
											ejecuta=Character.toLowerCase(entrada.next().charAt(0));
											}while(ejecuta!='s' && ejecuta!='n');
										
  										//MIENTRAS EJECUTA SEA IGUAL A S
  										while(ejecuta=='s'){
											//en construccion										
											//System.out.println("ESTAMOS DE OBRAS");
											
											//LEER Y VALIDAR NUMERO LIMITE
											do{
												System.out.println("Introduzca un número");
												numero3=entrada.nextInt();
												}while(numero3<0);
												
											//CONTAR SUMAR Y ESCRIBIR MULTIPLOS DE 5
											cantidadmult=0;
											sumamult=0;
											System.out.println("Los múltiplos son ");
											for(contador3=1;contador3<=numero3;contador3++){
													if(contador3%5==0){
														System.out.println(contador3);
														cantidadmult++;
														sumamult=sumamult+contador3;
														}
												}//FIN PARA
											System.out.println(" ");
											//ESCRIBIR SUMA DE MULTIPLOS
											System.out.println("La suma de los múltiplos es "+sumamult);
											
											//ESCRIBIR CANTIDAD DE MULTIPLOS
											System.out.println("La cantidad de múltilplos es "+cantidadmult);			
											
  											
  											//PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR
  											do{
												System.out.println("¿Quiere volver a ejecutar? S/N");
												ejecuta=Character.toLowerCase(entrada.next().charAt(0));
												}while(ejecuta!='s' && ejecuta!='n');
  										}//FIN MIENTRAS
									break;
						
						
						}//FIN SEGUN
						
				//VOLVER A PRESENTAR Y VALIDAR OPCION DEL MENU		
						do{
				System.out.println("Menú:");
				System.out.println("Introduzca 0 para salir");
				System.out.println("Introduzca 1 para calcular factorial");
				System.out.println("Introduzca 2 para contar dígitos");
				System.out.println("Introduzca 3 para contar y sumar múltiplos de cinco");
				opcion=entrada.nextInt();
				System.out.println("////////////////////////////////////////////////////////////");
				}while(opcion<0 || opcion>3);
				}//FIN MIENTRAS
	}
}






