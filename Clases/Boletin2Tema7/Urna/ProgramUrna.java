//ProgramUrna.java
/**
 * Analisis
 * 	Comentario:	Extraer dos bolas de la urna mientras quede 
				más de una bola en ella.
				Si las dos bolas sacadas son del mismo 
				color, se introducirá una bola negra en la 
				urna. 
				Si ambas bolas son de distinto color,
				deberá meterse en la urna una bola blanca.
				Cuando sólo quede una bola en la urna, 
				se extraerá y determinará su color. 
 * 
 * Entradas:
 * Salidas:
 * Restricciones: 
 * 
 * Pseudocodigo Generalizado
INICIO
	SACAR BOLAS MIENTRAS QUEDEN
		
		COMPROBAR BOLAS 
		COMPROBAR CANTIDAD TOTAL
		METER BOLA
			
		 





FIN

 */

import java.util.Scanner;

public class ProgramUrna{
	public static void main(String[] args){
		
		
		Scanner entrada=new Scanner(System.in);
		char ejecuta=' ';
		int contador;
		int bola1,bola2;
		Urna urna=new Urna(10,10);
		
		/*do{
			System.out.println("Ejecuta? S/N");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
		}while(ejecuta!='s' && ejecuta!='n');*/
		
		
		System.out.println("Hay "+urna.getCapacidadMax()+" como maximo" );//asignar a una variable el valor inicial de capacidadmax
		while(ejecuta=='s'){
			
							
				System.out.println("Quedan "+urna.getCantidadDisponible()+">>> "+urna.getCantidadNegras()+" bolas negras y "+urna.getCantidadBlancas()+" blancas");
				System.out.println("Sacar bola S/N");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
				/*if(contador==1){
					bola1=urna.sacaBola();
					System.out.println("Ha salido "+bola1);
				}else*/
					bola1=urna.sacaBola();
					bola2=urna.sacaBola();
					urna.restaBolas(bola1,bola2);
					System.out.println("Ha salido "+bola1+" y "+bola2);
					urna.meteBola(bola1,bola2);
		
			
			do{
				System.out.println("Salir? S/N");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			}while(ejecuta!='s' && ejecuta!='n');
			
			
			
			
		}
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
		
	}
}













