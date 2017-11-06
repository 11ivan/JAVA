//domino.java
/**
 *Analisis
 * 	Proposito: El juego del dominó consta de 28 fichas. Sacamos una al azar y anotamos la suma de las puntuaciones.
 * 			   Analiza cuántas veces sale cada uno de los 13 casos que pueden darse (0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10, 11, 12).
 * 	Entradas: un caracter
 * 	Salidas: cuántas veces sale cada uno de los 13 casos que pueden darse
 * 	Restricciones: Solo introducir caracteres
 * 
 *Pseudocodigo generalizado
 *INICIO 
 * 	PREGUNTAR Y VALIDAR SI SACA FICHA
 * 	MIENTRAS SACAR FICHA SEA SI
 * 
 * 		SACAR FICHA
 * 		ACUMULAR SUMA DE FICHA
 * 		COMPROBAR SUMA DE FICHA
 *		ACUMULAR NUMERO DE TIRADA
 * 
 * 		PREGUNTAR SI VUELVE A SACAR FICHA
 * 	FIN MIENTRAS
 * 	ESCRIBIR CASOS
 *FIN	 
 * 
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class domino{
	public static void main(String[] args){
	
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		Random aleatoria=new Random();
		char sacar=' ';
		int parte1,parte2,sumapartes,tirada,caso1,caso2,caso3,caso4,caso5,caso6,caso7,caso8,caso9,caso10,caso11,caso12,caso13;
		
		//PREGUNTAR Y VALIDAR SI SACA FICHA
		do{
			System.out.println("¿Quiere sacar ficha?");
			sacar=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			}while(sacar!='s' && sacar!='n');
		
		sumapartes=0;
		caso1=0;	
		caso2=0;
		caso3=0;
		caso4=0;
		caso5=0;
		caso6=0;
		caso7=0;
		caso8=0;
		caso9=0;
		caso10=0;
		caso11=0;
		caso12=0;
		caso13=0;
		tirada=0;
		//MIENTRAS SACAR FICHA SEA SI
		while (sacar=='s'){
			//SACAR FICHA
			parte1=aleatoria.nextInt(6);
			parte2=aleatoria.nextInt(6);
			//System.out.println(parte1);
			//System.out.println(parte2);
			//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			//ACUMULAR SUMA DE FICHA
			sumapartes=parte1+parte2;
			//System.out.println(sumapartes);
			//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			
			//COMPROBAR SUMA DE FICHA
			if(sumapartes==0){
				caso1++;
				}else if(sumapartes==1){
					caso2++;
					}else if(sumapartes==2){
						caso3++;
						}else if(sumapartes==3){
							caso4++;
							}else if(sumapartes==4){
								caso5++;
								}else if(sumapartes==5){
									caso6++;
									}else if(sumapartes==6){
										caso7++;
										}else if(sumapartes==7){
											caso8++;
											}else if(sumapartes==8){
												caso9++;
												}else if(sumapartes==9){
													caso10++;
													}else if(sumapartes==10){
														caso11++;
														}else if(sumapartes==11){
															caso12++;
															}else {
																caso13++;
																}
			//ACUMULAR NUMERO DE TIRADA
			tirada++;	
			//System.out.println(tirada);
			//System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");											
				
			//PREGUNTAR SI VUELVE A SACAR FICHA
			do{
				System.out.println("¿Quiere volver a sacar ficha?");
				sacar=Character.toLowerCase(entrada.next().charAt(0));
				System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
				}while(sacar!='s' && sacar!='n');
					
		}//FIN MIENTRAS
			
		//ESCRIBIR CASOS
		System.out.println("Ha salido 0 "+caso1+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 1 "+caso2+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 2 "+caso3+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 3 "+caso4+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 4 "+caso5+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 5 "+caso6+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 6 "+caso7+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 7 "+caso8+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 8 "+caso9+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 9 "+caso10+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 10 "+caso11+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 11 "+caso12+" veces en "+tirada+" tiradas");
		System.out.println("Ha salido 12 "+caso13+" veces en "+tirada+" tiradas");
	
	}
}
