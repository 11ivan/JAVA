//temperatura.java
/**
 *An�lisis
 * 	F�rmula: De Farenheit a Kelvin: Kelvin=(�F+459.67)/1.8;
             De Kelvin a Farenheit: Farenheit=K*1.8-459.67.
 * 	Proposiciones:Covertir de grados Kelvin a Farenheit y viceversa.
 * 	Entrada: Un n�mero.
 * 	Salida: La conversi�n de la temperatura.
 * 	Restricciones:Un n�mero de dos cifras m�ximo, debe ser mayor que 0.
 *Pseudoc�digo generalizado
 * 	Leer datos.
 * 	Comprobar datos y realizar c�lculo.
 * 	Escribir resultado.
*/
import java.util.Scanner;//importamos clase Scanner

public class temperatura{
	public static void main(String[] args){
		//declaraci�n de variables
		float grados,resultado=0;
		char conversion=' ';
		
		//LEER DATOS
		Scanner entrada1=new Scanner(System.in);
		System.out.println("Introduzca la temperatura");			
		grados=entrada1.nextFloat();
		
		Scanner entrada2=new Scanner(System.in);
		System.out.println("Introduzca F para conversi�n a Farenheit o K para conversi�n a Kelvin");	
		conversion=entrada2.next().charAt(0);
		
		//COMPROBAR DATOS Y REALIZAR C�LCULO
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
					System.out.println("El car�cter introducido no es correcto");
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
