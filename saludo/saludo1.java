//saludo1.java
/**
 *Análisis
 * 	Propósito: Escribiir un mensaje segun la hora.
 * 	Entradas: Dos números.
 * 	Salidas: Saludo correspondiente.
 * 	Restricciones: No introducir números negativos, cuatro dígitos máximo.
 *Pseudocódigo generalizado
 * 	Leer datos
 * 	Comprobar datos
 * 	Escribir resultado
*/
import java.lang.Integer;//importamos la clase Integer
import java.util.Scanner;//importamos clase Scaner
public class saludo1{
	public static void main(String[] args){
		
		//declaración de variables
		Scanner entrada= new Scanner(System.in);
		int hora,minuto,resultado;
		String salude="";

		//LEER DATOS
		System.out.println("Introduzca la hora");
		hora=entrada.nextInt();
		
		System.out.println("Introduzca los minutos");
		minuto=entrada.nextInt();
		//FIN LEER DATOS
		
		//COMPROBAR DATOS
		if (hora<0){
			System.out.println("La hora no puede ser negativa");
		}
		else if(minuto<0){
				System.out.println("Los minutos no pueden negativos");
			}
			else if(hora>23){
					System.out.println("La hora no puede ser mayor que 23");
				}
				else if(minuto>59){
						System.out.println("Los minutos no pueden ser mayor que 59");
					}
		 if(hora==7 && minuto>29 || hora>7 && hora<=13 && minuto<=59 || hora==14 && minuto==0){
			salude=("Buenos días");
			}
		else if(hora==14 && minuto>0 || hora>=15 && hora<=19 && minuto<=59 || hora==20 && minuto<=30){
				salude=("Buenas tardes");
				}
			else /*if(hora==20 && minuto>30 || hora>20 && hora<=23 && minuto<=59 || hora<=7 && minuto<=29)*/{
					salude=("Buenas noches");
					}
					

				System.out.println(salude);
	
			
	}
}			
				
