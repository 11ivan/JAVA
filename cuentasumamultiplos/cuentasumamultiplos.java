//cuentasumamultiplos.java
/**
 *Analisis.
 * 	Proposito: Hacer un programa que imprima, cuente y sume los múltiplos de 5 que hay entre 1 y
 * 			   un número leído por teclado.
 * 	Entradas: Un numero.
 * 	Salidas: Imprimir, contar y sumar los múltiplos de 5 que hay entre 1 y
 * 			 un número leído por teclado. 
 * 	Restricciones: El numero introducido no debe ser mayor que 100.
 * 
 *Pseudocódigo generalizado
 * LEER Y VALIDAR NUMERO
 * CONTAR Y SUMAR MULTIPLOS
 * ESCRIBIR CANTIDAD Y SUMA DE MULTIPLOS 
*/

import java.util.Scanner;//importamos clase Scanner

public class cuentasumamultiplos{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		int suma, cantidad, numerolimite, contador, multiplo;
		Scanner entrada=new Scanner(System.in);
		
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
	}
}
