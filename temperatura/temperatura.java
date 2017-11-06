//temperatura.java
/**
 *Análisis
 * 	Fórmula: De Farenheit a Kelvin: Kelvin=(ºF+459.67)/1.8;
             De Kelvin a Farenheit: Farenheit=K*1.8-459.67.
 * 	Proposiciones:Covertir de grados Kelvin a Farenheit y viceversa.
 * 	Entrada: Un número.
 * 	Salida: La conversión de la temperatura.
 * 	Restricciones:Un número de dos cifras máximo, debe ser mayor que 0.
 *Pseudocódigo generalizado
 * 	Leer datos.
 * 	Comprobar datos y realizar cálculo.
 * 	Escribir resultado.
*/
import java.util.Scanner;//importamos clase Scanner

public class temperatura{
	public static void main(String[] args){
		//declaración de variables
		float grados,resultado=0;
		char conversion=' ';
		
		//LEER DATOS
		Scanner entrada1=new Scanner(System.in);
		System.out.println("Introduzca la temperatura");			
		grados=entrada1.nextFloat();
		
		Scanner entrada2=new Scanner(System.in);
		System.out.println("Introduzca F para conversión a Farenheit o K para conversión a Kelvin");	
		conversion=entrada2.next().charAt(0);
		
		//COMPROBAR DATOS Y REALIZAR CÁLCULO
		if (grados<=0){
			System.out.println("La temperatura introducida debe ser mayo que cero");
		}
		else if(conversion=='F' || conversion=='f'){
				resultado=grados*(float)1.8-(float)459.67;
			}
			else if(conversion=='K' || conversion=='k'){
					resultado=(grados+(float)459.67)/(float)1.8;
				}
				else{
					System.out.println("El carácter introducido no es correcto");
					}
		
		//ESCRIBIR RESULTADO
		if (conversion=='K'){
			System.out.println("El resultado es: "+resultado);
		}
		else if(conversion=='F'){
				System.out.println("El resultado es: "+resultado);
			}
	}	
}
