//moneda.java
/**
*Analisis
*	Proposito:Simular el lanzamiento de una moneda al aire e imprimir si ha salido cara o cruz.
*			  Repetir el proceso tantas veces como desee el jugador.
* 	Entradas: Un caracter.
* 	Salidas: Cara o cruz de una moneda.
* 	Restricciones: L para lanzar y S para salir.
* 
* Pseudocodigo generalizado
* INICIO	
* 	PREGUNTAR Y VALIDAR SI TIRA
* 	MIENTRAS TIRAR SEA SI
* 		PREGUNTAR Y VALIDAR CARA O CRUZ
* 		TIRAR COMPROBAR MONEDA Y ESCRIBIR RESULTADO
* 		COMPROBAR DECISION Y ESCRIBIR RESULTADO
* 		PREGUNTAR SI VUELVE A TIRAR
* 	FIN MIENTRAS
* FIN
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class moneda{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		char lanzar=' ';
		Scanner entrada=new Scanner(System.in);
		int aleatorio, decision;
		Random caracruz=new Random();
		
		
		//PREGUNTAR Y VALIDAR SI TIRA
		do{
			System.out.println("¿Quiere lanzar la moneda?");
			lanzar=Character.toLowerCase(entrada.next().charAt(0));
			}while(lanzar!='s' && lanzar!='n');
			
		//MIENTRAS TIRAR SEA SI
		while(lanzar=='s'){
			
			//PREGUNTAR Y VALIDAR CARA O CRUZ
			do{
				System.out.println("Introduzca 0 para Cara o 1 para Cruz");
				decision=entrada.nextInt();
			}while(decision!=1 && decision!=0);
			
			//TIRAR COMPROBAR MONEDA Y ESCRIBIR RESULTADO
			aleatorio=caracruz.nextInt(2);
			if(aleatorio==0){
				System.out.println(aleatorio+" Ha salido cara");
			}else{
				System.out.println(aleatorio+" Ha salido cruz");
				}
			
			//COMPROBAR DECISION Y ESCRIBIR RESULTADO 
			if(aleatorio==decision){
				System.out.println("Ha ganado!!");
				}else {
						System.out.println("Ha perdido");
					}

			//PREGUNTAR SI VUELVE A TIRAR
			do{
				System.out.println("¿Quiere volver a lanzar la moneda?");
				lanzar=Character.toLowerCase(entrada.next().charAt(0));
			}while(lanzar!='s' && lanzar!='n');
			
		}//FIN MIENTRAS

	}
}
