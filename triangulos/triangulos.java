//triangulos.java
/**
 *An�lisis
 * 	Prop�sito:Decir tipo de tri�ngulo seg�n la longitud de sus lados.
 * 	Entradas: Tres n�meros.
 * 	Salidas: Tipo de tri�ngulo.
 * 	Restricciones: No se puede introducir n�meros negativos o 0.
 *Pseudoc�digo generalizado
 * 	Leer lados
 * 	Comprobar datos Y Escribir resultado
*/

import java.util.Scanner; //importamos clase Scanner

public class triangulos{
	public static void main(String[] args){
		
		//Declaraci�n de variables
		int lado1,lado2,lado3;
		
		//LEER LADOS
		Scanner entrada=new Scanner(System.in);
		System.out.println("Introduzca el lado 1");
		lado1=entrada.nextInt();
		
		System.out.println("Introduzca el lado 2");
		lado2=entrada.nextInt();

		System.out.println("Introduzca el lado 3");
		lado3=entrada.nextInt();
	
		//COMPROBAR DATOS Y ESCRIBIR RESULTADO
		if((lado1<=0) || (lado2<=0) || (lado3<=0)){
			System.out.println("No se puede introducir un n�mero menor o igual que cero");
		}
		else if((lado1>=lado2+lado3)||(lado2>=lado1+lado3)||(lado3>=lado1+lado2)){
				System.out.println("No se trata de un tri�ngulo");
			}
			else if(lado1*lado1==lado2*lado2+lado3*lado3){
					System.out.println("Es un tri�ngulo rect�ngulo");
				}
				else if(lado1*lado1>lado2*lado2+lado3*lado3){
						System.out.println("Es un tri�ngulo obtus�ngulo");
					}
					else if(lado1*lado1<lado2*lado2+lado3*lado3){
							System.out.println("Es un tri�ngulo acut�ngulo");
						}
	}
}
