//menu.java
/**
 *Analisis
 * 	Proposito: Ejecutar programa elegido por el usuario.
 * 			   Los programas son: 1. Calcular el factorial de un numero entero.
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
 *  Restricciones: Solo introducir caracteres en el menu.
 * 				   Para el factorial: Solo numero positivo.
 * 			 	   Para la cantidad de digitos un numero: Introducir solo numeros.
 * 				   Para los multiplos de 5: El numero introducido no debe ser mayor que 100.
 * 
 *Pseudocodigo Generalizado
 * INICIO
 * 		PREGUNTAR Y VALIDAR SI EJECUTA
 * 		MIENTRAS EJECUTAR SEA SI
 * 			LEER Y VALIDAR PROGRAMA ELEGIDO
 * 			SEGUN(PROGRAMA ELEGIDO)
 * 				CASO 1: 
 * 						Leer y validar numero
 *			  			Calcular factorial
 *		  				Escribir factorial
 * 
 * 				CASO 2:
 * 						 LEER Y VALIDAR NUMERO
 * 					    CONTAR DIGITOS
 * 				    	ESCRIBIR DIGITOS 
 * 
 * 				CASO 3:
 * 						LEER Y VALIDAR NUMERO
 * 						CONTAR Y SUMAR MULTIPLOS
 * 						ESCRIBIR CANTIDAD Y SUMA DE MULTIPLOS
 * 			FIN SEGUN
 * 			ACTUALIZAR SALIDA
 * 		FIN MIENTRAS
 * FIN
 * 
*/

import java.util.Scanner;
import java.lang.Character;

public class menu{
	public static void main(String[] args){
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		char ejecuta;
		int programa;
		
		//PREGUNTAR Y VALIDAR SI EJECUTA
		do{
			System.out.println("Introduzca Si para ejecutar o No para salir");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
		}while(ejecuta!='s' && ejecuta!='n');//FIN MIENTRAS
		
		//MIENTRAS EJECUTA SEA SI
		while(ejecuta=='s'){
			//LEER Y VALIDAR PROGRAMA ELEGIDO
			do{
				System.out.println("¿Qué programa quiere ejecutar? 1 para Factorial, 2 para contar digitos o  3 contar y sumar multiplos de cinco");
				programa=entrada.nextInt();
			}while(programa!=1 && programa!=2 && programa!=3);//FIN MIENTRAS
			
			//SEGUN PROGRAMA ELEGIDO
			switch(programa){
					case 1:		//DECLARAMOS VARIABLES
									//Scanner entrada=new Scanner(System.in);//este sobra
								int numero1=0; 
								float fact;

								//LEER Y VALIDAR NUMERO
								do{
									System.out.println("Introduzca un numero");
									numero1=entrada.nextInt();
									System.out.println("///////////////////////////////");
								}while(numero1<0);//FIN REPETIR MIENTRAS
								
								//COMPROBAR SI NUMERO ES CERO Y ESCRIBIR RESULTADO
								if(numero1==0){
										System.out.println("El factorial de "+numero1+" es 1");
									}
									
								//Para (contador=1;mientras contador<numero1;contador++)
								fact=1;
								for(int contador=1;contador<=numero1;contador++){
									//CALCULAR FACTORIAL
											//PRUEBA	//System.out.print(contador+"*");
									fact=fact*contador;
									}//FIN PARA
									
								System.out.println("El factorial de "+numero1+" es "+fact);	
								System.out.println("///////////////////////////////");
								break;
							
					case 2:		//Declaramos variables
									//Scanner entrada=new Scanner(System.in);//este sobra
								int numero2;
								
								//LEER NUMERO
								System.out.println("Introduzca un número");
								numero2=entrada.nextInt();
								
								//CONTAR DIGITOS
								int digitos=0;
								do{
									numero2=numero2/10;
									digitos++;
								}while(numero2!=0);//FIN MIENTRAS
								
								//ESCRIBIR DIGITOS
								System.out.println("El numero tiene "+digitos+" dígitos");
								break;
								
					case 3:		//DECLARAMOS VARIABLES
								int suma, cantidad, numerolimite, contador, multiplo;
									//Scanner entrada=new Scanner(System.in);//este sobra
								
								//LEER Y VALIDAR NUMERO
								do{
									System.out.println("Ingrese un numero");
									numerolimite=entrada.nextInt();
								}while(numerolimite>100 && numerolimite<=0);
								
								//CONTAR Y SUMAR MULTIPLOS
								cantidad=0;
								suma=0;
								multiplo=5;

								System.out.print("Los multiplos son ");
								for(contador=1;contador<=numerolimite;contador++){
									if(contador%multiplo==0){
										cantidad++;
										suma=suma+contador;	
										System.out.print(contador+", ");
									}//FIN SI
								}//FIN PARA
								
								//ESCRIBIR CANTIDAD Y SUMA DE MULTIPLOS 
								System.out.println(" ");
								System.out.println("La suma de los multiplos es "+suma);
								System.out.println("La cantidad de multiplos es "+cantidad);
								break;
			}//FIN SEGUN
			
			//ACTUALIZAR SALIDA
			do{
				System.out.println("¿Ejecutar de nuevo?");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
				}while(ejecuta!='s' && ejecuta!='n');//FIN MIENTRAS
		}//FIN MIENTRAS
	
	}
}
