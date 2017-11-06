//trilero.java
/**
 *Analisis
 * 	Proposito: Diseña un algoritmo para simular el juego de ¿dónde está la bolita? (trile)
 * 	Entradas: Un caracter.
 * 	Salidas: Si gana o pierde.
 * 	Restricciones: Solo introducir caracteres.
 * 
 *Pseudocodigo Generalizado
 *INICIO
 * 	PREGUNTAR Y VALIDAR SI JUEGA
 * 	MIENTRAS JUGAR SEA SI
 * 		MAREAR LA BOLITA
 * 		PREGUNTAR DONDE ESTA LA BOLITA
 * 		COMPROBAR BOLITA Y ESCRIBIR RESULTADO 
 *		VOLVER A PREGUNTAR SI JUEGA
 * 	FIN MIENTRAS 
 *FIN
 *  
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class trilero{
	public static void main(String[] args){
	
		//DECLARACION DE VARIABLES
		Scanner entrada=new Scanner(System.in);
		Random aleatorio=new Random();
		char jugar=' ';
		int bolita,decision;
		
		//PREGUNTAR Y VALIDAR SI JUEGA
		do{
		System.out.println("¿Quiere jugar? Si/No");
		jugar=Character.toLowerCase(entrada.next().charAt(0));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}while(jugar!='s' && jugar!='n');
		
		//MIENTRAS JUGAR SEA SI
		while(jugar=='s'){
			
				//MAREAR LA BOLITA
				bolita=aleatorio.nextInt(3) +1;
				//System.out.println(bolita);
				//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				
				//PREGUNTAR Y VALIDAR DONDE ESTA LA BOLITA
				do{
					System.out.println("¿Dónde esta la bolita? 1/2/3");
					decision=entrada.nextInt();
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				}while(decision<1 && decision>3);
				
				//COMPROBAR BOLITA
				if(bolita!=decision){
					System.out.println("Ha perdido!! JAJAJAJAJA");
					}else {
						System.out.println("Ha ganado!!");
						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
						}
							
				//VOLVER A PREGUNTAR SI JUEGA
				do{
					System.out.println("¿Quiere volver a buscar la bolita? Si/No");
					jugar=Character.toLowerCase(entrada.next().charAt(0));
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
					}while(jugar!='s' && jugar!='n');
			}//FIN MIENTRAS
	}
}
