//nota.java
/**
 * Analisis
 * 	Proposito: Diseñar un algoritmo que lea de teclado una nota de un examen de cada uno de los
 * 			   alumnos de una clase y calcule la media, la nota más alta, la más baja y
 * 			   el número de alumnos presentados al examen. 
 * 			   La entrada de datos acaba cuando se lee una nota negativa.
 * 	Entrada: Numeros
 * 	Salidas: Media, nota mas alta, nota mas baja y alumnos presentados al examen.
 * 	Restricciones: La nota no puede ser mayor que 10.
 * 
 * Pseudocodigo Generalizado
 * 	INICIO
 * 		LEER Y VALIDAR NOTAS
 * 		MIENTRAS NOTA SEA >=0
 * 			COMPROBAR NOTA MAYOR
 * 			COMPROBAR NOTA MENOR
 * 			ACUMULAR MEDIA
 * 			CONTAR ALUMNOS PRESENTADOS
 * 			VOLVER A PEDIR NOTA
 * 		FIN MIENTRAS
 * 		CALCULAR MEDIA
 * 		ESCRIBIR NOTA MAYOR
 * 		ESCRIBIR NOTA MENOR
 * 		ESCRIBIR MEDIA
 * 		ESCRIBIR ALUMNOS PRESENTADOS 		
 * 	FIN
 * 
*/

import java.util.Scanner;//IMPORTAMOS CLASE SCANNER

public class nota{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		float mayor,menor,calificacion,alumnos,media;
		Scanner entrada=new Scanner(System.in);
		
		//LEER Y VALIDAR NOTAS	
		
			System.out.println("Introduzca la nota. Ingrese un numero negativo para finalizar.");
			calificacion=entrada.nextFloat();
			while(calificacion>10){
			System.out.println("La nota no puede ser mayor que 10.");
			System.out.println("Introduzca la nota. Ingrese un numero negativo para finalizar.");
			calificacion=entrada.nextFloat();
			}//FIN MIENTRAS
			
			mayor=0;
			menor=10;
			alumnos=0;
			media=0;
			//MIENTRAS NOTA SEA >=0
			while(calificacion>=0){
					if(calificacion>mayor){
					mayor=calificacion;
					}
					//COMPROBAR MENOR	
					if(calificacion<menor){
					menor=calificacion;
					}
									
					//ACUMULAR MEDIA
					media=media+calificacion;
					System.out.println("La media acumulada en este punto es "+media);			
					//CONTAR ALUMNOS PRESENTADOS
					alumnos++;
					System.out.println("Se han presentado "+alumnos);
					
					
					//VOLVER A PEDIR NOTA
					System.out.println("Introduzca otra nota. Ingrese un numero negativo para finalizar.");
					calificacion=entrada.nextFloat();
					while(calificacion>10){
					System.out.println("La nota no puede ser mayor que 10.");
					System.out.println("Introduzca la nota. Ingrese un numero negativo para finalizar.");
					calificacion=entrada.nextFloat();
					}//FIN MIENTRAS
			}//FIN MIENTRAS
			
			//CALCULAR MEDIA
			media=media/alumnos;
			
			//ESCRIBIR NOTA MAYOR
			System.out.println("La nota mayor es "+mayor);
					
			//ESCRIBIR NOTA MENOR
			System.out.println("La nota menor es "+menor);
					
			//ESCRIBIR MEDIA
			System.out.println("La media es "+media);
					
			//ESCRIBIR ALUMNOS PRESENTADOS
			System.out.println("Se han presentado "+alumnos);
		
	}
}




