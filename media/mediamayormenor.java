//mediamayormenor.java

/**Análisis
 *	Propósito: Hallar el menor, el mayor y la media de n números positivos leidos de teclado
 * 	Entradas: Numeros.
 * 	Salida: Menor,mayor y media.
 * 	Restricciones: Sólo números positivos.
 *
 *Pseudocodigo Generalizado
 * INICIO 
 * 	Repetir mientras ejecucion sea distinto de si y no
 * 	Repetir mientras ejecutar sea si
 * 		Leer y validar numeros a introducir
 * 		Leer y validar numeros introducidos
 * 		Para (contador1, mientras contador1<=contador2, contador1++)
 * 			Comprobar numero mayor y menor
 * 			Actualizar el valor de la media
 * 		FIN PARA
 * 		Escribir mayor
 * 		Escribir menor
 * 		Calcular y scribir media
 * 		
 * 		Preguntar y validar si vuelve a ejecutar
 * 	FIN REPETIR MIENTRAS
 * FIN
*/


import java.util.Scanner;
import java.lang.Character;

public class mediamayormenor{
	public static void main(String[] args){
	
		//DECLARACION DE VARIABLES
		Scanner entrada=new Scanner(System.in);
		int numerocontrol,mayor,menor,valornumero;
		float media;
		char ejecuta;
		
		//PREGUNTAR Y VALIDAR EJECUCIÓN
		do{
			System.out.println("Introduzca Sí para ejecutar y No para salir");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}while(ejecuta!='s' && ejecuta!='n');//FIN REPETIR MIENTRAS
		
		while(ejecuta=='s'){
			//LEER Y VALIDAR NUMEROS A INTRODUCIR
			do{
				System.out.println("Cuántos números va a introducir");
				numerocontrol=entrada.nextInt();
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}while(numerocontrol<1);//FIN REPETIR MIENTRAS
			
			//Para (contador1, mientras contador1<=contador2, contador1++)
				mayor=0;
				menor=1000000000;
				media=0;
				
				for(int contador=1;contador<=numerocontrol;contador++){
				//LEER Y VALIDAR NUMEROS INTRODUCIDOS
					do{
						System.out.println("Introduzca el numero "+contador);
						valornumero=entrada.nextInt();
					}while(valornumero<0);
					
					//COMPROBAR MAYOR Y MENOR
					if(valornumero>mayor){
						mayor=valornumero;						
					}
					if(valornumero<menor){
						menor=valornumero;
						}
					//ACTUALIZAR EL VALOR DE LA MEDIA
					media=media+valornumero;
				}//FIN PARA
				
				//ESCRIBIR MAYOR
				System.out.println("El mayor es "+mayor);
				
				//ESCRIBIR MENOR
				System.out.println("El menor es "+menor);
				
				//CALCULAR Y ESCRIBIR MEDIA
				media=media/numerocontrol;
				System.out.println("La media es "+media);
			
		//VOLVER A PREGUNTAR SI EJECUTA
		System.out.println("¿Ejecutar de nuevo?1");
		ejecuta=Character.toLowerCase(entrada.next().charAt(0));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

			while(ejecuta!='s' && ejecuta!='n'){
			//VOLVER A PREGUNTAR
			System.out.println("¿Ejecutar de nuevo? 2");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}//fin while
				
		}//FIN MIENTRAS		
	}	
}
