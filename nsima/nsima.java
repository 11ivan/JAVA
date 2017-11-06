//nsima.java
/**
 *Análisis
 * 	Propósito: Escribir en pantalla los N primeros números naturales, sus raíces cuadradas,
 * 			   su potencia n-sima y el producto de todos ellos.
 * 	Entrada: Dos números.
 * 	Salida: N primeros números naturales y sus raices cuadradas, su potencia n-sima y el 
 * 			producto de todos ellos.
 * 	Restricciones: N entre 1 y 20; n entre 2 y 5.
 * 
 * Pseudocódigo Generalizado
 * INICIO	
 * 	Preguntar y validar ejecucion
 * 	Mientras ejecutar sea si
 * 		Leer y validar numero natural
 * 		Leer y validar n-sima
 * 		Pintar N numeros
 * 		Calcular y escribir raíz cuadrada
 * 		Calcular y escribir potencia n-sima
 * 		Calcular y escribir producto
 * 		Condicion de salida
 *	FIN MIENTRAS 
 * FIN
 */

import java.util.Scanner;//importamos clase Scanner
import java.lang.Math;//importamos clase Math
import java.lang.Character;//importamos clase Character;

public class nsima{
	public static void main(String[] args){
	
			//Declaramos Variables
			char ejecuta='s';
			int natural=0, sima=0, contador, potencia=0;
			float radicando, producto;
			Scanner entrada=new Scanner(System.in);
			
			
			//PREGUNTAR Y VALIDAR EJECUCIÓN
			System.out.println("Introduzca Sí para ejecutar o No para salir");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("////////////////////////////////////////////////////");
			
			while (ejecuta!='n' && ejecuta!='s'){
				System.out.println("Introduzca Sí para ejecutar o No para salir 2");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
				System.out.println("////////////////////////////////////////////////////");
			}
			
			while (ejecuta=='s'){
				
				//LEER Y VALIDAR NÚMERO NATURAL 
				System.out.println("Introduzca un número entre 1 y 20");
				natural=entrada.nextInt();
				while(natural<1 || natural>20){
					System.out.println("Introduzca un número entre 1 y 20");
					natural=entrada.nextInt();
					System.out.println("////////////////////////////////////////////////////");
				}//FIN MIENTRAS
				
				//LEER Y VALIDAR N-SIMA
				System.out.println("Introduzca la potencia n-sima, entre 2 y 5");
				sima=entrada.nextInt();
				while(sima<2 || sima>5){
					System.out.println("Introduzca la potencia n-sima, entre 2 y 5");
					sima=entrada.nextInt();
				}//FIN MIENTRAS
				
				
				contador=1;
				while(contador<=natural){
					//ESCRIBIR N NÚMEROS
					System.out.println("Número natural  "+contador);
					//CALCULAR Y ESCRIBIR RAÍZ CUADARADA
					radicando=(float)Math.sqrt(contador);
					System.out.println("Raíz cuadrada  "+radicando);
					//CALCULAR Y ESCRIBIR POTENCIA
					potencia=(int)Math.pow(contador,sima);
					System.out.println("Potencia n-sima  "+potencia);
					//CALCULAR Y ESCRIBIR PRODUCTO
					producto=contador*radicando*potencia;
					System.out.println("Producto total  "+producto);
					System.out.println("////////////////////////////////////////////////////");
					contador++;
				}//FIN MIENTRAS
				
				//VOLVER A PREGUNTAR SI EJECUTA
				System.out.println("¿Ejecutar de nuevo? Sí para ejecutar y No para salir");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
				System.out.println("////////////////////////////////////////////////////");
				while(ejecuta!='s' && ejecuta!='n'){
					System.out.println("¿Ejecutar de nuevo? Sí para ejecutar y No para salir");
					ejecuta=Character.toLowerCase(entrada.next().charAt(0));
					System.out.println("////////////////////////////////////////////////////");
				}//FIN MIENTRAS
				
			}//FIN MIENTRAS
	
	}	
}

