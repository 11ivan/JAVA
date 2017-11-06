//bisiesto.java
/**
 *An�lisis.
 * 	Prop�sito: Dado un a�o decir si es bisiesto o no.
 * 	Entradas: Un n�mero.
 * 	Salidas: Bisiesto o no bisiesto.
 * 	Restricciones: No se pueden introducir n�meros negativos o 0.
 *Pseudoc�digo generalizado
 * 	Leer datos
 * 	Realizar c�culos y Comprobar datos
 * 	Escribir resultado
*/
import java.util.Scanner;//importamos clase Scanner

public class bisiesto{
	public static void main(String[] args){
		//Declaracion de variables
		Scanner entrada=new Scanner(System.in);
		boolean bisiest=true;
		int year,resto1,resto2,resto3;
		
		//LEER DATOS
		System.out.println("Introduzca el a�o");
		year=entrada.nextInt();
		
		//REALIZAR C�LCULOS Y COMPROBAR DATOS
		resto1=year%4;
		resto2=year%100;
		resto3=year%400;
		
		if (year<1582){
			System.out.println("Los a�os bisisestos comienzan a partir de 1582");	
			bisiest=false;
			}
		else if (resto1==0 && resto2!=0){
				bisiest=true;
				}	
			else if (resto3==0){
					bisiest=true;	
					}
				else{
					bisiest=false;	
					}
	
		//ESCRIBIR RESULTADO
		System.out.println(bisiest);	
	}
}
