//bisiesto.java
/**
 *Análisis.
 * 	Propósito: Dado un año decir si es bisiesto o no.
 * 	Entradas: Un número.
 * 	Salidas: Bisiesto o no bisiesto.
 * 	Restricciones: No se pueden introducir números negativos o 0.
 *Pseudocódigo generalizado
 * 	Leer datos
 * 	Realizar cáculos y Comprobar datos
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
		System.out.println("Introduzca el año");
		year=entrada.nextInt();
		
		//REALIZAR CÁLCULOS Y COMPROBAR DATOS
		resto1=year%4;
		resto2=year%100;
		resto3=year%400;
		
		if (year<1582){
			System.out.println("Los años bisisestos comienzan a partir de 1582");	
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
