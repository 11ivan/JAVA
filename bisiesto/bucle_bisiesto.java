//bucle_bisiesto.java
/**
 *Análisis.
 * 	Propósito: Dado un año decir si es bisiesto o no.
 * 	Entradas: Un número.
 * 	Salidas: Bisiesto o no bisiesto.
 * 	Restricciones: No se pueden introducir años menores de 1582.
 *Pseudocódigo generalizado
 * 	Preguntar si ejecuta.
 * 	Mientras que ejecutar sea distinto a Sí y No.
 * 		Volver a preguntar si ejecuta.
 * FIN MIENTRAS
 * 
 * Mientras ejecutar sea Sí
 * 		Leer y validar año.
 * 		Mientras año sea inválido
 * 			Volver a preguntar año
 * 		FIN MIENTRAS
 * 		Realizar cálculos y comprobar datos.
 * 		Escribir resultado.
 * 		Volver a preguntar
 * FIN MIENTRAS
 * FIN 
 * 
*/
import java.util.Scanner;//importamos clase Scanner
import java.lang.Character;//importamos clase Character
public class bucle_bisiesto{
	public static void main(String[] args){
		//Declaracion de variables
		Scanner entrada=new Scanner(System.in);
		boolean bisiest=true;
		int year;
		char bucle='S';
		
		
		//PREGUNTAR SI EJECUTA
		System.out.println("Introduzca Sí para ejecutar o No para salir 1");
		bucle=Character.toLowerCase(entrada.next().charAt(0));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		
		//MIENTRAS EJECUTAR SEA DISTINTO DE SI Y NO
		while(bucle!='n' && bucle!='s'){
			System.out.println("Letra incorrecta");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

		//VOLVER A PREGUNTAR SI EJECUTA
		System.out.println("Introduzca Sí para ejecutar o No para salir 2");
		bucle=Character.toLowerCase(entrada.next().charAt(0));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
		}//FIN MIENTRAS
			
			
		while(bucle=='s'){
		
				//LEER Y VALIDAR AÑO
				System.out.println("Introduzca el año");
				year=entrada.nextInt();
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

				
				//REALIZAR CÁLCULOS Y COMPROBAR DATOS

				
				if (year<1582){
					System.out.println("Los años bisisestos comienzan a partir de 1582");	
					bisiest=false;
					System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
					}
				else if (year%4==0 && year%100==0 || year%400){
						bisiest=true;
						}
						else{
							bisiest=false;	
							}
			
				//ESCRIBIR RESULTADO
				System.out.println(bisiest);
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

			
		//VOLVER A PREGUNTAR
		System.out.println("¿Ejecutar de nuevo? 1");
		bucle=Character.toLowerCase(entrada.next().charAt(0));
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");

			while(bucle!='s' && bucle!='n'){
			//VOLVER A PREGUNTAR
			System.out.println("¿Ejecutar de nuevo? 2");
			bucle=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}//fin while
		
		
		
		}//fin while
		
		
		


	
	}	
}
