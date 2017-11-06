//carrera.java
/**
 * Analisis
 * 	Proposito: Diseña un programa para simular una carrera de tres caballos.
 * 			   Las probabilidades de ganar las simulará el diseñador según sus propios criterios.
 * 			   El programa permitirá al usuario jugar repetidas veces si lo desea. Puede incluirse la posibilidad de
 * 			   apostar interactivamente.
 * 	Entradas: Un caracter y un numero.
 * 	Salidas: Si gana o pierde.
 * 	Restricciones: Solo numeros positivos.
 * 
 * Pseudocodigo Generalizado
 *INICIO
 * 	PREGUNTAR Y VALIDAR SI EJECUTA
 * 	MIENTRAS EJECUTAR SEA SI
 * 		PREGUNTAR Y VALIDAR POR QUE CABALLO APUESTA
 * 		PREGUNTAR Y VALIDAR CANTIDAD DE APUESTA
 * 		REALIZAR CARRERA
 * 		COMPROBAR CABALLO GANADOR
 * 		COMPROBAR CABALLO GANADOR Y CABALLO APUESTA
 * 		ESCRIBIR RESULTADO
 * 		PREGUNTAR SI VUELVE A EJECUTAR 
 * 	FIN MIENTRAS
 * 
 * 
 *FIN 
*/

import java.util.Scanner;
import java.util.Random;
import java.lang.Character;

public class carrera{
	public static void main(String[] args){
		
		//DECLARACION DE VARIABLES
		Random aleatorio=new Random();
		Scanner entrada=new Scanner(System.in);
		char ejecuta=' ';
		int cantidad,caballoapuesta,caballo,bote;
		boolean gana1=false,gana2=false,gana3=false,caen=false,millonario=false;
		
		//PREGUNTAR Y VALIDAR SI EJECUTA
		do{
			System.out.println("¿Quiere hacer una carrera? S/N");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
			}while(ejecuta!='s' && ejecuta!='n');
	
		//MIENTRAS EJECUTAR SEA SI
		bote=500;
		while(ejecuta=='s'){
			
			//PREGUNTAR Y VALIDAR POR QUE CABALLO APUESTA
			do{
				System.out.println("Hay un bote de "+bote+" $");
				System.out.println("¿Por qué caballo apuesta? 1/2/3");
				caballoapuesta=entrada.nextInt();
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}while(caballoapuesta<1 || caballoapuesta>3);
			
			//PREGUNTAR Y VALIDAR CANTIDAD DE APUESTA
			do{
				System.out.println("¿Qué cantidad quiere apostar por el caballo?");
				cantidad=entrada.nextInt();
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}while(cantidad<1);
				bote=bote+cantidad;
									//System.out.println(bote);//control
									//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
			//REALIZAR CARRERA
			caballo=aleatorio.nextInt(100) +1; 												
						//System.out.println("sale el caballo "+caballo);//control caballo que sale
						//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
			
			//COMPROBAR CABALLO GANADOR
			if(caballo>0 && caballo<=40){//EL CABALLO1 TENDRA UN 40% DE PROBABILIDAD DE GANAR
				gana1=true;
							//System.out.println("gana caballo1 "+gana1);//control caballo que gana
							//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}else if(caballo>40 && caballo<=75){//EL CABALLO2 TENDRA UN 35% DE PROBABILIDAD DE GANAR
					gana2=true;
								//System.out.println("gana caballo2 "+gana2);//control caballo que gana
								//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
					}else if(caballo>75 && caballo<=95){//EL CABALLO1 TENDRA UN 20% DE PROBABILIDAD DE GANAR
						gana3=true;
									//System.out.println("gana caballo3 "+gana3);//control caballo que gana
									//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
						}else{//EXISTE UNA PROBABILIDAD DEL 5% DE  TODOS LOS CABALLOS SE CAIGAN
							caen=true;
										//System.out.println("caen "+caen);
										//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
							}
			
			//COMPROBAR CABALLO GANADOR Y CABALLO APUESTA
			if(gana1==true && caballoapuesta==1){
				millonario=true;
								//System.out.println("ganaaa con el 1 "+millonario);//control si gana apuesta
								//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}else if(gana2==true && caballoapuesta==2){
					millonario=true;
									//System.out.println("ganaaa con el 2 "+millonario);//control si gana apuesta
									//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
					}else 
					if(gana3==true && caballoapuesta==3){
						millonario=true;
										//System.out.println("ganaaa con el tres "+millonario);//control si gana apuesta
										//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
						}else{
							millonario=false;
											//System.out.println("gana "+millonario);//control si gana apuesta
											//System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
							}
			
			//ESCRIBIR RESULTADO
			if(caen==true){
				System.out.println("Todos los caballos se han caido");
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}else if(millonario==true){
					System.out.println("Ha ganado, se lleva un bote de "+bote+" $");
					System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
					bote=300;
					}else{
						System.out.println("Ha perdido el bote asciende a "+bote);
						System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
						}
			
			//PREGUNTAR Y VALIDAR SI VUELVE A EJECUTAR 
			do{
				System.out.println("¿Quiere volver a hacer una carrera? S/N");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
				System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::");
				}while(ejecuta!='s' && ejecuta!='n');

		}//FIN MIENTRAS
	
	}
}//FIN
