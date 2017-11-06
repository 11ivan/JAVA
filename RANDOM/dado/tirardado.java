//tirardado.java
/**
 *Analisis
 * 	Proposito: Simular n tiradas de un dado y contar las veces que aparece cada número.
 *			   Presentar los resultados en forma de porcentajes. Hacer que el algoritmo se repita
 *			   hasta que se desee terminar.
 * 	Entrada: Un caracter.
 * 	Salida: Los resultados de las veces que a salido cada cara en forma de porcentajes.
 * 	Restricciones: solo introducir caracteres
 * 
 * Psdeudocodigo Generalizado
 *INICIO
 * 	PREGUNTAR SI LANZA EL DADO
 * 	PARA (tirada=1,mientras lanzar=='s',tirada++)
 * 		LANZAR EL DADO
 * 		COMPROBAR DADO Y ACTUALIZAR CONTADOR DE LA CARA
 * 		HACER CALCULOS
 * 		PREGUNTAR SI VUELVE A LANZAR EL DADO
 * 	FIN PARA
 * 	ESCRIBIR RESULTADO
 *FIN
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class tirardado{
	public static void main(String[] args){
	
	//DECLARAMOS VARIABLES
	char lanzar=' ';
	Scanner entrada=new Scanner(System.in);
	Random numero=new Random();
	int tirada,lado,cara1,cara2,cara3,cara4,cara5,cara6,porcentaje1,porcentaje2,porcentaje3,porcentaje4,porcentaje5,porcentaje6;
	
	//PREGUNTAR SI LANZA EL DADO
	do{
		System.out.println("¿Quiere lanzar el dado? si o no");
		lanzar=Character.toLowerCase(entrada.next().charAt(0));
		}while(lanzar!='s' && lanzar!='n');
	
	//PARA (tirada=1,mientras lanzar=='s',tirada++)
	cara1=0;
	cara2=0;
	cara3=0;
	cara4=0;
	cara5=0;
	cara6=0;
	porcentaje1=0;
	porcentaje2=0;
	porcentaje3=0;
	porcentaje4=0;
	porcentaje5=0;
	porcentaje6=0;
	for(tirada=1;lanzar=='s';tirada++){
		//LANZAR EL DADO
		lado=numero.nextInt(6) +1;
			
		//COMPROBAR DADO Y ACTUALIZAR CONTADOR DE LA CARA
		if(lado==1){
			cara1++;
			}else if(lado==2){
				cara2++;
				}else if(lado==3){
					cara3++;
					}else if(lado==4){
						cara4++;
						}else if(lado==5){
							cara5++;
							}else{
								cara6++;
							}
								//impresiones de control en pantalla
								System.out.println("LADO Y SUMA DE CARAS++++++++++++++++++++++++++");
								System.out.println("LADO "+lado);	
								System.out.println("CARA1 "+cara1);
								System.out.println("CARA2 "+cara2);
								System.out.println("CARA3 "+cara3);
								System.out.println("CARA4 "+cara4);
								System.out.println("CARA5 "+cara5);
								System.out.println("CARA6 "+cara6);
								System.out.println("tirada "+tirada);
		//HACER CALCULOS
		porcentaje1=cara1*100/tirada;
		porcentaje2=cara2*100/tirada;
		porcentaje3=cara3*100/tirada;
		porcentaje4=cara4*100/tirada;
		porcentaje5=cara5*100/tirada;
		porcentaje6=cara6*100/tirada;
		
			//impresiones de control en pantalla
			System.out.println("PORCENTAJES++++++++++++++++++++++++++");	
			System.out.println("PORCENTAJE CARA1 "+porcentaje1);
			System.out.println("PORCENTAJE CARA2 "+porcentaje2);
			System.out.println("PORCENTAJE CARA3 "+porcentaje3);
			System.out.println("PORCENTAJE CARA4 "+porcentaje4);
			System.out.println("PORCENTAJE CARA5 "+porcentaje5);
			System.out.println("PORCENTAJE CARA6 "+porcentaje6);
				
		//PREGUNTAR SI VUELVE A LANZAR EL DADO					
		do{
			System.out.println("¿Quiere volver a lanzar el dado?");
			lanzar=Character.toLowerCase(entrada.next().charAt(0));
			}while(lanzar!='s' && lanzar!='n');
		}//FIN PARA
			
		//ESCRIBIR RESULTADO
		System.out.println("La cara 1 ha salido "+cara1+" veces en "+tirada+" tiradas, su porcentaje es "+porcentaje1+"%");
		System.out.println("La cara 2 ha salido "+cara2+" veces en "+tirada+" tiradas, su porcentaje es "+porcentaje2+"%");
		System.out.println("La cara 3 ha salido "+cara3+" veces en "+tirada+" tiradas, su porcentaje es "+porcentaje3+"%");
		System.out.println("La cara 4 ha salido "+cara4+" veces en "+tirada+" tiradas, su porcentaje es "+porcentaje4+"%");
		System.out.println("La cara 5 ha salido "+cara5+" veces en "+tirada+" tiradas, su porcentaje es "+porcentaje5+"%");
		System.out.println("La cara 6 ha salido "+cara6+" veces en "+tirada+" tiradas, su porcentaje es "+porcentaje6+"%");		
	}
}
