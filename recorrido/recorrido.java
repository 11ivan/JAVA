//recorrido.java
/**
 * An�lisis
 *	F�rmula: espacio final=espacio inicial+velocidad*tiempo;
 * 	Prop�sito:Calcular el espacio recorrido por un objeto que se mueve a velocidad constante.
 * 	Entradas: Tres n�meros.
 * 	Salidas: El espacio recorrido.
 * 	Restricciones: Velocidad y tiempo no pueden ser n�meros menores o cero, excepto espacio inicial que puede ser 0.
 * Pseudoc�digo Generalizado
 * 	Leer datos.
 * 	Comprobar datos y Realizar c�lculos.
 * 	Escribir resultado.
*/
import java.util.Scanner;//importamos clase Scanner
public class recorrido{
	public static void main(String[] args){
	
	//Declaraci�n de variables
	Scanner entrada=new Scanner(System.in);
	int velocidad,espacio_inicial;
	float tiempo,espacio_final=0;
	
	//LEER DATOS	
	System.out.println("Introduzca el espacio inicial: ");
	espacio_inicial=entrada.nextInt();

	
	System.out.println("Introduzca la velocidad: ");
	velocidad=entrada.nextInt();
	
	System.out.println("Introduzca el tiempo: ");
	tiempo=entrada.nextFloat();
	
	//FIN LEER DATOS
	
	//COMPROBAR DATOS Y REALIZAR C�LCULOS
	if (velocidad<=0 || tiempo<=0 || espacio_inicial<0){
		System.out.println("La velocidad o el tiempo no pueden ser cero o negativo");	
	}
	else{
		espacio_final=espacio_inicial+(velocidad*tiempo);
		}
	//FIN COMPROBAR DATOS Y REALIZAR C�LCULOS
	
	//ESCRIBIR RESULTADO
	if(espacio_final>0){
		System.out.println("El espacio es: "+espacio_final);	
		}	
	
	}
}
