//cuentadigitos.java
/**
 *Analisis
 * Proposito: Dise�ar un algoritmo que lea de teclado un n�mero y
 * 			 calcule la cantidad de d�gitos que tiene. 
 * Entradas:Un numero.
 * Salidas: La cantidad de digitos del numero introducido.
 * Restricciones: Introducir solo numeros.
 * 
 * Pseudocodigo generalizado
 * 	LEER Y VALIDAR NUMERO
 * 	CONTAR DIGITOS
 * 	ESCRIBIR DIGITOS 
 * 
*/

import java.util.Scanner;//Importamos clase Scanner
import java.lang.Character;//Importamos clase Character

public class cuentadigitos{
	public static void main (String[] args){
		//Declaramos variables
		Scanner entrada=new Scanner(System.in);
		int numero;
		
		//LEER NUMERO
		System.out.println("Introduzca un n�mero");
		numero=entrada.nextInt();
		
		//CONTAR DIGITOS
		int digitos=0;
		do{
			numero=numero/10;
			digitos++;
		}while(numero!=0);//FIN MIENTRAS
		
		//ESCRIBIR DIGITOS
		System.out.println("El numero tiene "+digitos+" d�gitos");
	}
}
