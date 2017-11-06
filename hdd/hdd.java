//hdd.java
/**
 * Análisis.
 * 	Fórmula: cilindros*pistas*sectores*bytesporsecor.
 * 	Propósito: Calular la capacidad de un disco duro.
 * 	Entrada: Cuatro números.
 * 	Salidas: La capacidad del disco duro.
 * 	Restricciones: Sólo introducir números mayores que cero.
 * Pseudocódigo generalizado
 * 	LEER DATOS
 * 	COMPROBAR DATOS Y REALIZAR CÁLCULO
 * 	ESCRIBIR RESULTADO
*/
import java.util.Scanner; // se importa la clase Scanner

public class hdd {
	public static void main(String[] args){
		
	//Declaración de variables
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
	
	//COMPROBAR DATOS Y REALIZAR CÁLCULO
	if(cilindro<=0){
		System.out.println("Los números introducidos no pueden ser negativos o cero");
	}
	else if(pista<=0){
			System.out.println("Los números introducidos no pueden ser negativos o cero");
			}
		else if(sector<=0){
				System.out.println("Los números introducidos no pueden ser negativos o cero");
				}
			else if(byt<=0){
					System.out.println("Los números introducidos no pueden ser negativos o cero");
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
