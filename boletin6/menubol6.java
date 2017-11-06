//menubol6.java
/**
 * Analisis
 * Proposito: Menu para: 1.-Crear un programa dado el radio de una circunferencia calcule
 *			 			 según opción del usuario la 
 * 							 1.1.- longitud de la misma 						L=2*pi*r
 * 							 1.2.- el área 										A=pi*r²
 *							 1.3.- el volumen de la esfera que determina. 		V=3/4*pi*r³
 * Entradas: Para opcion de los menus un numero entero
 * 			 Para la opcion 1.1; 1.2 y 1.3 un numero real
 * 
 * Salidas:  Para la opcion 1.1; 1.2 y 1.3 un numero real.
 * 
 * Restricciones: Para la opcion de los menus el numero sera mayor o igual que cero y menor que 4 *por ahora*
 * 
 * 
 * Pseudocodigo generalizado
 * 	INICIO
 * 		PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		MIENTRAS OPCION ELEGIDA NO SEA SALIR
 * 			SEGUN(OPCIO NMENU)
 * 				
 * 				CASO 1: CALCULOS CIRCUNFERENCIA
 * 
 * 			FIN SEGUN
 * 			VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		FIN MIENTRAS
 * 	FIN
 * 
 */

//ABRIMOS EL MODULO CALCULOS CIRCUNFERENCIA
/*	INICIO
 * 		PRESENTAR MENU ELEGIR Y VALIDAR OPCION
 * 		MIENTRAS OPCION ELEGIDA SEA DISTINTA DE SALIR
 * 			SEGUN (OPCION MENUCIRCUNFERENCIA)
 * 
 * 				CASO 1: LONGITUD CIRCUNFERENCIA
 * 
 * 				CASO 2: AREA CIRCUNFERENCIA
 * 			
 * 				CASO 3: VOLUMEN ESFERA
 * 
 * 			FIN SEGUN
 * 			VOLVER A PRESENTAR MENU ELEGIR Y VALIDAR OPCION
 * 		FIN MIENTRAS
 * 	FIN  
 */

//ABRIMOS LONGITUD CIRCUNFERENCIA
/*	INICIO
 * 		LEER RADIO
 * 		VALIDARADIO**
 * 		CALCULAR LONGITUD CIRCUNFERENCIA**
 * 		ESCRIBIR RESULTADO
 * FIN
 */

//ABRIMOS AREA CIRCUNFERENCIA
/*	INICIO
 * 		LEER RADIO
 * 		VALIDARADIO**
 * 		CALCULAR AREA CIRCUNFERENCIA**
 * 		ESCRIBIR RESULTADO
 * FIN
 */

//ABRIMOS VOLUMEN ESFERA
/*	INICIO
 * 		LEER RADIO
 * 		VALIDARADIO**
 * 		CALCULAR VOLUMEN ESFERA**
 * 		ESCRIBIR RESULTADO
 * FIN
 */

import java.util.Scanner;
import java.io.*;
import java.lang.Character;

public class menubol6{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		int opcion,opcionesfera;
		double radio,longitud,area,volumen;
		final double pi=3.14;
		boolean vale=false;
		
		//PRESENTAR MENU ELEGIR Y VALIDAR OPCION
		do{
			//LLAMAR A MENUPRINCIPAL
			metodosmenubol6.menuprincipal();
			//ELEGIR Y VALIDAR OPCION
			opcion=entrada.nextInt();
			}while(opcion<0 && opcion>2);
		
  		//MIENTRAS OPCION ELEGIDA SEA DISTINTA DE SALIR
  		while(opcion!=0){
			
  			//SEGUN (OPCION MENUCIRCUNFERENCIA)
  			switch(opcion){
				
				case 1:		//CALCULOS CIRCUNFERENCIA
								//PRESENTAR MENUcircunferencia ELEGIR Y VALIDAR OPCION
								do{
									//LLAMAR A MENUCIRCUNFERENCIA
									metodosmenubol6.menucircunferencia();
									//ELEGIR Y VALIDAR OPCION
									opcionesfera=entrada.nextInt();
									}while(opcionesfera<0 && opcionesfera>3);
									
								//MIENTRAS OPCION ELEGIDA SEA DISTINTA DE SALIR
								while(opcion!=0){
									
									//SEGUN (OPCION MENUCIRCUNFERENCIA)
									switch(opcionesfera){
										case 1: //LONGITUD CIRCUNFERENCIA
										
													//LEER Y VALIDAR RADIO
													do{	
														//LEER RADIO
														System.out.println("Introduzca el radio");
														radio=entrada.nextDouble();
														//LLAMA A VALIDARADIO**
														vale=metodosmenubol6.validaradio(radio);
													}while(vale==false);
													
													//LLAMAR A LONGITUDCIRCUNF**		//L=2*pi*r
													longitud=metodosmenubol6.longitudcincunf(radio,pi);
													
													//ESCRIBIR RESULTADO
													System.out.println("La longitud de la circunferencia es "+longitud);
										break;
											
										case 2: //AREA CIRCUNFERENCIA      //A=pi*r²
										
										
										break;
										
										//CASO 3: VOLUMEN ESFERA			//V=3/4*pi*r³
						  
									}//FIN SEGUN
									//VOLVER A PRESENTAR MENU ELEGIR Y VALIDAR OPCION
									do{
										//PRESENTAR MENUCIRCUNFERENCIA
										metodosmenubol6.menucircunferencia();
										
										//ELEGIR Y VALIDAR OPCION
										opcionesfera=entrada.nextInt();
										
										}while(opcionesfera<0 && opcionesfera>3);
								}//FIN MIENTRAS
								
				break;
				
  				//CASO 2: N/A
  			
  
  			}//FIN SEGUN
  			//VOLVER A PRESENTAR MENU ELEGIR Y VALIDAR OPCION
  			do{
				//LLAMA A MENUPRINCIPAL
				metodosmenubol6.menuprincipal();
				//ELEGIR Y VALIDAR OPCION
				opcion=entrada.nextInt();
			}while(opcion<0 && opcion>2);
  		}//FIN MIENTRAS
	}
}
