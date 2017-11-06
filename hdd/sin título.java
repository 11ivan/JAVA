//hdd.java
/**
 * Análisis.
 * 	Fórmula: cilindros*pistas*sectores*bytesporsecor.
 * 	Propósito: Calular la capacidad de un disco duro.
 * 	Entrada: Cuatro números.
 * 	Restricciones: Sólo introducir números mayores que cero.
 * Pseudocódigo generalizado
 * 	LEER DATOS
 * 	COMPROBAR DATOS Y REALIZAR CÁLCULO
 * 	ESCRIBIR RESULTADO
*/
import java.util.Scanner; // se importa la clase Scanner

public class imc {
	public static void main(String[] args){
		
	//Declaración de variables
	double cilindro,pista,sector,byt,capacidad;
	
	//LERR DATOS
	Scanner entrada1=new Scanner(System.in);
	System.out.println("Introduzca los cilindros");
	cilindro=entrad1.nextDouble();
	
	Scanner entrada2=new Scanner(System.in);
	System.out.println("Introduzca las pistas");
	pista=entrada2.nextDouble();
	
	Scanner entrada3=new Scanner(System.in);
	System.out.println("Introduzca los sectores");
	sector=entrad3.nextDouble();
	
	Scanner entrada4=new Scanner(System.in);
	System.out.println("Introduzca los bytes por sector");
	byt=entrada4.nextDouble();



	capacidad=cilindro*pista*sector*byt;
	System.out.println(capacidad);

	
	
	
	}
}
