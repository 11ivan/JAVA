//hdd.java
/**
 * An�lisis.
 * 	F�rmula: cilindros*pistas*sectores*bytesporsecor.
 * 	Prop�sito: Calular la capacidad de un disco duro.
 * 	Entrada: Cuatro n�meros.
 * 	Salidas: La capacidad del disco duro.
 * 	Restricciones: S�lo introducir n�meros mayores que cero.
 * Pseudoc�digo generalizado
 * 	LEER DATOS
 * 	COMPROBAR DATOS Y REALIZAR C�LCULO
 * 	ESCRIBIR RESULTADO
*/
import java.util.Scanner; // se importa la clase Scanner

public class hdd {
	public static void main(String[] args){
		
	//Declaraci�n de variables
	double cilindro,pista,sector,byt,capacidad1,capacidad2,capacidad3,capacidad4;
	
	//LEER DATOS
	Scanner entrada=new Scanner(System.in);
	System.out.println("Introduzca los cilindros");
	cilindro=entrada.nextDouble();
	
	System.out.println("Introduzca las pistas");
	pista=entrada.nextDouble();
	
	System.out.println("Introduzca los sectores");
	sector=entrada.nextDouble();
	
	System.out.println("Introduzca los bytes por sector");
	byt=entrada.nextDouble();
	//FIN LEER DATOS
	
	//COMPROBAR DATOS Y REALIZAR C�LCULO
	if(cilindro<=0){
		System.out.println("Los n�meros introducidos no pueden ser negativos o cero");
	}
	else if(pista<=0){
			System.out.println("Los n�meros introducidos no pueden ser negativos o cero");
			}
		else if(sector<=0){
				System.out.println("Los n�meros introducidos no pueden ser negativos o cero");
				}
			else if(byt<=0){
					System.out.println("Los n�meros introducidos no pueden ser negativos o cero");
					}
				else{
					capacidad1=cilindro*pista*sector*byt;
					capacidad2=capacidad1/1024;
					capacidad3=capacidad1/1024/1024;
					capacidad4=capacidad1/1024/1024/1024;
					}
					
	//ESCRIBIR RESULTADO
	System.out.println("Bytes: "+ capacidad1);
	System.out.println("KB: "+ capacidad2);
	System.out.println("MB: "+ capacidad3);
	System.out.println("GB: "+ capacidad4);

	}
}
