//dosmonedas.java
/**
 *Analisis
 * 	Proposito: Lanzar al aire dos monedas y contar cuántas veces salen 2 caras, 2 cruces y una
 *			   cruz y una cara.
 * 	Entrada: Un caracter.
 * 	Salida: cuántas veces salen 2 caras, 2 cruces y una
 *			cruz y una cara.
 * 	Restricciones: Solo caracteres.
 * 
 * Pseudocodigo Generalizado
 *INICIO	
 * 	PREGUNTAR Y VALIDAR SI LANZA
 * 	MIENTRAS LANZAR SEA SI
 * 		LANZAR MONEDA1 Y MONEDA2
 * 		COMPROBAR CARA Y CARA
 * 		COMPROBAR CARA Y CRUZ
 * 		COMPROBAR CRUZ Y CRUZ
 * 		PREGUNTAR SI VUELVE A TIRAR
 * 	FIN MIENTRAS
 * 	ESCRIBIR RESULTADO
 *FIN
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class dosmonedas{
	public static void main (String[] args){
		
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		int caracara,caracruz,cruzcruz,moneda1,moneda2;
		Random tirada=new Random();
		char lanzar=' ';
		
		//PREGUNTAR Y VALIDAR SI LANZA
		System.out.println("¿Quiere lanzar las monedas? Si para lanzar y No para salir");
		lanzar=Character.toLowerCase(entrada.next().charAt(0));
		
		while(lanzar!='s' && lanzar!='n'){
			System.out.println("¿Quiere lanzar las monedas? Si para lanzar y No para salir");
			lanzar=Character.toLowerCase(entrada.next().charAt(0));
			}
		
		caracara=0;
		caracruz=0;
		cruzcruz=0;
		//MIENTRAS LANZAR SEA SI
		while(lanzar=='s'){
				
				//LANZAR MONEDA1 Y MONEDA2
				moneda1=tirada.nextInt(2);
				moneda2=tirada.nextInt(2);
				
				//COMPROBAR CARA Y CARA
				if(moneda1==0 && moneda2==0){
					caracara++;
					////COMPROBAR CARA Y CRUZ
					}else if(moneda1==1 && moneda2==0){
						caracruz++;
						}else{//COMPROBAR CRUZ Y CRUZ
							cruzcruz++;
							}
					//impresiones de control
					//System.out.println("cara y cara en este punto"+caracara+" veces");
					//System.out.println("cara y cruz en este punto"+caracruz+" veces");
					//System.out.println("cruz y cruz en este punto"+cruzcruz+" veces");
			
		//PREGUNTAR SI VUELVE A LANZAR LA MONEDA
		do{
			System.out.println("¿Quiere volver a lanzar las monedas? Si para lanzar y No para salir");
			lanzar=Character.toLowerCase(entrada.next().charAt(0));
		}while(lanzar!='s' && lanzar!='n');
			
		}//FIN MIENTRAS
		
		//ESCRIBIR RESULTADO
		System.out.println("Ha salido cara y cara "+caracara+" veces");
		System.out.println("Ha salido cara y cruz "+caracruz+" veces");
		System.out.println("Ha salido cruz y cruz "+cruzcruz+" veces");
		
	}
} 
