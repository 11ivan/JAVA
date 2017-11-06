//saludo.java
/**
 *An�lisis
 * 	Prop�sito: Escribiir un mensaje segun la hora.
 * 	Entradas: Dos n�meros.
 * 	Salidas: Saludo correspondiente.
 * 	Restricciones: No introducir n�meros negativos, cuatro d�gitos m�ximo.
 *Pseudoc�digo generalizado
 * 	Leer datos
 * 	Comprobar datos
 * 	Escribir resultado
*/
import java.lang.Integer;//importamos la clase Integer
import java.util.Scanner;//importamos clase Scaner
public class saludo{
	public static void main(String[] args){
		//declaraci�n de variables
		Scanner entrada= new Scanner(System.in);
		int resultado,longitud;
		String hora1,hora2,salude;
		
		//LEER DATOS
		System.out.println("Introduzca la hora en formato hh:mm");
		hora1=entrada.nextLine();
		hora2=hora1.replace(":", "");System.out.println(hora2); //prueba para ver si reemplaza
		resultado=Integer.parseInt(hora2);//convertimos String a int
		longitud=hora2.length();System.out.println("esto es la longitud: "+longitud);//prueba longitud
		//FIN LEER DATOS
		
		//COMPROBAR DATOS
		if(longitud>4){
			salude="No puede introducir m�s de cuatro n�meros";
			}
		else if((resultado>2359)||(resultado<0)){
				salude="D�jame no s� que hora es";
				}
			else if((resultado>=0730)&&(resultado<=1400)){
					salude="Buenos d�as";
					}
				else if ((resultado>=0)&&(resultado<=729)){//resultado>=1401)&&(resultado<=2030
						salude="Buenas noches";
						}
					else{
						salude="Buenas tardes";
						}
		//FIN COMPROBAR DATOS
		
		//ESCRIBIR RESULTADO
		System.out.println(salude);						
	}
}
