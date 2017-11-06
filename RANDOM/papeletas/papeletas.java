//papeletas.java
/**
 *Analisis
 * 	Proposito: Una caja contiene una serie de papeletas marcadas con los números 1, . . . , n.
 *			   Elegimos al azar una papeleta de la caja. Determinar las probabilidades de los
 * 			   siguientes sucesos.
 *			   1. La primera papeleta tiene el número 1 y la segunda el número 2.
 *			   2. Los números de las dos papeletas son números enteros consecutivos, esto es,
 * 				  la primera papeleta tiene un número una unidad inferior a la segunda.
 * 	Entrada: Un numero y un caracter.
 * 	Salidas: Probabilidad de que salga 1 en la primera papeleta y 2 en la segunda.
 * 			 Probabilidad de que una papeleta tenga el numero siguiente a la anterior sacada.
 * 	Restricciones:Solo caracteres y numeros positivos
 * 
 *Pseudocodigo Generalizado
 * INICIO
 * 	PREGUNTAR Y VALIDAR SI EJECUTA
 * 	MIENTRAS EJECUTAR SEA SI
 * 		PREGUNTAR Y VALIDAR NUMERO DE PAPELETAS
 * 		SACAR PAPELETA
 * 		COMPROBAR PROBABILIDAD
 * 		PREGUNTAR SI VUELVE A EJECUTAR
 * 	FIN MIENTRAS	
 * 	ESCRIBIR RESULTADO 
 * FIN
*/


import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class papeletas{
	public static void main(String[] args){
			
		//DECLARACION DE VARIABLES
		Scanner entrada=new Scanner(System.in);
		Random aleatorio=new Random();
		char ejecuta=' ';
		
		int npapeletas,papeleta,posibilidad1,posibilidad2;
		
		//PREGUNTAR Y VALIDAR SI EJECUTA
		do{
			System.out.println("¿Quiere ejecutar? S/N");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			}while(ejecuta!='s' && ejecuta!='n');
		
		//MIENTRAS EJECUTAR SEA SI
		
		while(ejecuta=='s'){
			
			//PREGUNTAR Y VALIDAR NUMERO DE PAPELETAS
			do{
				System.out.println("Cuántas papeletas quiere que haya");
				npapeletas=entrada.nextInt();
			}while(npapeletas<1);
			
		
			//SACAR PAPELETA
			
			posibilidad1=0;
			posibilidad2=0;
			
				papeleta=aleatorio.nextInt(npapeletas) +1;
			
				//COMPROBAR PROBABILIDAD
				if(papeleta>=1){
					posibilidad1=(papeleta*100)/npapeletas;	
					System.out.println(posibilidad1);
				}
				
				if(papeleta!=npapeletas){
					posibilidad2=(papeleta*100)/(npapeletas-1);
					System.out.println(posibilidad2);
				}

			
			//ESCRIBIR RESULTADO 
			System.out.println("La posibilidad de que salga 1 y después 2 es "+posibilidad1);
			System.out.println("La posibilidad de que salga la papeleta consecutiva a la sacada es "+posibilidad2);
			
			//PREGUNTAR SI VUELVE A EJECUTAR
			do{
			System.out.println("¿Quiere volver a ejecutar? S/N");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			}while(ejecuta!='s' && ejecuta!='n');
		
			
		
		}//FIN MIENTRAS
		
		
		
		
	}
}
