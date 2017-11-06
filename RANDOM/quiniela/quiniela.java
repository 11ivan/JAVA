//quiniela.java
/**
 *Analisis
 * 	Proposito:Generar aleatoriamente una quiniela de n columnas. Supóngase que las probabilidades son:
			  50% para que salga 1
			  30% para que salga x
		      20% para que salga 2
 * 	Entradas: un caracter y un numero.
 * 	Salidas: una quiniela de n columnas
 * 	Restricciones: Solo introducir caracteres y numeros positivos.
 * 
 * Pseudocodigo Generalizado
 *INICIO
 *  PREGUNTAR Y VALIDAR SI EJECUTA
 * 	MIENTRAS EJECUTAR SEA SI
 * 		PEDIR NUMERO DE COLUMNAS
 * 		GENERAR QUINIELA
 * 			COMPROBAR LO GENERADO
 * 			ESCRIBIR RESULTADO
 * 		PREGUNTAR SI VUELVE A EJECUTAR
 * 	FIN MIENTRAS
 * 	
 * 
 * 
 * 
 * 
 *FIN 
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class quiniela{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		Random aleatorio=new Random();
		char ejecuta=' ';
		int columnas,generado;
		
		//PREGUNTAR Y VALIDAR SI EJECUTA
		do{
			System.out.println("¿Quiere ejecutar? Si/No");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			}while(ejecuta!='s' && ejecuta!='n');
			
		//MIENTRAS EJECUTAR SEA SI
		while(ejecuta=='s'){
			
				//PEDIR Y VALIDAR NUMERO DE COLUMNAS	
				System.out.println("¿Cuántas columnas quiere?");
				columnas=entrada.nextInt();
				
				//GENERAR QUINIELA
				for(int contador=1;contador<=columnas;contador++){
					generado=aleatorio.nextInt(100) +1;
					
					
					//COMPROBAR LO GENERADO
					if(generado>0 && generado<=50){//50% para que salga 1
						System.out.println("1");
						}else if(generado>50 && generado<=80){//30% para que salga x
								System.out.println("X");
								}else {
									System.out.println("2");//20% para que salga 2
									}
					}//FIN PARA
				
				//PREGUNTAR SI VUELVE A EJECUTAR
				do{
					System.out.println("¿Quiere volver a ejecutar? Si/No");
					ejecuta=Character.toLowerCase(entrada.next().charAt(0));
					}while(ejecuta!='s' && ejecuta!='n');
				
			}//FIN MIENTRAS

	}
}
