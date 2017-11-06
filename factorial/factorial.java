//factorial.java
/**
 *Analisis.
 * 	Comentario: Ejemplo de factorial; 5!= 5*4*3*2*1.
 * 	Proposito: Calcular el factorial de un numero entero.
 * 	Entradas: Un numero.
 * 	Salidas: El factorial del numero.
 * 	Restricciones: Solo numero positivo.
 * 
 *Pseudocodigo generalizado
 * 	INICIO
 * 		Leer y validar numero
 * 		Comprobar si numero es cero y escribir factorial
 * 		mientras contador sea menor que numero
 * 			Calcular factorial
 * 		FIN MIENTRAS
 * 		Escribir factorial
 * 	FIN 
*/

import java.util.Scanner;

public class factorial{
	public static void main(String[] args){
	//DECLARAMOS VARIABLES
	Scanner entrada=new Scanner(System.in);
	int numero=0,contador;
	float fact;

	//LEER Y VALIDAR NUMERO
	do{
		System.out.println("Introduzca un numero");
		numero=entrada.nextInt();
		System.out.println("///////////////////////////////");
	}while(numero<0);//FIN REPETIR MIENTRAS
	
	//COMPROBAR SI NUMERO ES CERO Y ESCRIBIR RESULTADO
	if(numero==0){
			System.out.println("El factorial de "+numero+" es 1");
		}
		
	//mientras contador sea menor que numero
	fact=1;
	contador=1;
	while(contador<=numero){						
		//CALCULAR FACTORIAL
				//PRUEBA	//System.out.print(contador+"*");
		fact=fact*contador;
		contador++;
		}//FIN MIENTRAS
		
	System.out.println("El factorial de "+numero+" es "+fact);	
	System.out.println("///////////////////////////////");
		
	}
}
