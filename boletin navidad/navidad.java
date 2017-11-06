//navidad.java
/**
 * Analisis
 * 	Proposito:
 * 	Entradas:
 * 	Salidas:
 * 	Restricciones:
 * 
 * Pseudocodigo Generalizado
 * 	INICIO
 * 		PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		MIENTRAS OPCION ELEGIDA SEA DISTINTA DE SALIR
 * 			SEGUN(OPCION)
 * 				CASO 1: TRABAJAR CON CARACTERES
 * 				CASO 2: TRABAJAR CON NUMEROS
 * 				CASO 3: TRABAJAR CON FECHAS
 * 				CASO 4: JUGAR
 * 				CASO 5: PINTAR RELOJ DE ARENA
 * 			FIN SEGUN
 * 			VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		FIN MIENTRAS
 * FIN 
 */
//------------------------------------------------------------------------
/*TRABAJAR CON CRACTERES
 * 
 *  PRESENTAR SUBMENU LEER Y VALIDAR OPCION
 *  MIENTRAS OPCION SEA DISTINTA DE SALIR
 *  	SEGUN OPCION
 * 			CASO 1:	COMPARAR CARACTERES DEL ALFABETO			
 * 			CASO 2: LETRA MAYUSCULA O MINUSCULA 
 * 			CASO 3: SIMBOLO DE PUNTUACION 			
 * 			CASO 4: DIGITO ENTRE 0 Y 9 
 * 			CASO 5: MENSAJE GRACIOSILLO		
 * 		FIN SEGUN
 * 		VOLVER A PRESENTAR SUBMENUCARACTERES LEER Y VALIDAR OPCION
 * 	FIN MIENTRAS

 */
//------------------------------------------------------------------------
/*TRABAJAR CON NUMEROS
 * 
 * 	PRESENTAR SUBMENU LEER Y VALIDAR OPCION
 * 	MIENTRAS OPCION SEA DISTINTA DE SALIR
 * 		SEGUN OPCION 
 * 			CASO 1:	NUMERO COMPUESTO
 * 			CASO 2: NUMERO PERFECTO
 * 			CASO 3: NUMERO SEMIPERFECTO 						
 * 			CASO 4: NUMERO FRIKI  
 * 			CASO 5: NUMERO PRIMO PROBABLE 
 * 		FIN SEGUN
 * 		VOLVER A PRESENTAR SUBMENUNUMEROS LEER Y VALIDAR OPCION
 * 	FIN MIENTRAS
 */
 //------------------------------------------------------------------------
 /*TRABAJAR CON FECHAS Y HORAS
  *		PRESENTAR MENUFECHAS LEER Y VALIDAR OPCION
  * 	MIENTRAS OPCIONFECHA SEA DISTINTA DE SALIR
  * 		SEGUN OPCIONFECHA
  * 			CASO 1: FECHA ATERIOR POSTERIOR IGUAL
  * 			CASO 2: CONVERTIR 24h EN AM/PM 
  * 			CASO 3: DIAS TRANSCURRIDOS
  * 		FIN SEGUN
  *  		VOLVER A PRESENTAR MENUFECHAS LEER Y VALIDAR OPCION
  * 	FIN MIENTRAS
  */
  //------------------------------------------------------------------------
  /*JUGAR
  *		PRESENTAR MENUJUGAR LEER Y VALIDAR OPCION
  * 	MIENTRAS OPCIONJUGAR SEA DISTINTA DE SALIR
  * 		SEGUN OPCIONJUGAR
  * 			CASO 1: JUGAR CHICAGO
  * 						PREGUNTAR SI QUIERE TIRAR DADOS
  * 						MIENTRAS TIRAR SEA DISTINTO DE NO
  * 							TIRAR DADOS USUARIO Y MAQUINA
  * 							SUMAR DADOS*
  * 							COMPROBAR SUMA DE LOS DADOS*
  * 							REALIZAR APUESTA
  * 							REALIZAR JUGADAS*
  * 							PREGUNTAR SI QUIERE VOLVER A JUGAR
  * 						FIN MIENTRAS
  * 			CASO 2: JUGAR BARBUDI 
  * 			CASO 3: JUAGR CHINOS
  * 		FIN SEGUN
  *  		VOLVER A PRESENTAR MENUJUGAR LEER Y VALIDAR OPCION
  * 	FIN MIENTRAS
  */
  //------------------------------------------------------------------------
  /*PINTAR RELOJ DE ARENA
  * 	LEER Y VALIDAR NUMERO*
  * 	PINTAR RELOJ*
  */
  //------------------------------------------------------------------------

import java.lang.Character;
import java.util.Scanner;
import java.util.Random;

public class navidad{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		Random tirada=new Random();
		int dado1,dado2,dado3,dado4,sumdad12,sumdad34,empate,apuesta1=0,apuesta2=0,pozo=0,clave,puntosjug=0,puntosia=0;
		int opcion,opcioncaracteres,opcionnumeros,opcionfechas,opcionjugar;
		int caractermayor,numero,digito1,digito2,entre09;
		int dia1,mes1,anyo1, dia2,mes2,anyo2,fechamayor,diastrans,hora,horaconv;
		char caracter1=' ', caracter2=' ', letra=' ',digito=' ',tirar=' ';
		boolean caractervalido=false,esmayuscula=false,espuntuacion=false;
		boolean escompuesto=false,esperfecto=false, esfriki=false;
		boolean fechavalida=false,horavalida=false;
		boolean coincide=false;
		boolean valido=false;
		
		//PRESENTAR MENU LEER Y VALIDAR OPCION
		do{
			metodosalfabeto.menuprincipal();
			opcion=entrada.nextInt();
			System.out.println("_________________________________________________________");
			}while(opcion<0 && opcion>5);
		
  		//MIENTRAS OPCION ELEGIDA SEA DISTINTA DE SALIR
		while(opcion!=0){
			
 			//SEGUN(OPCION)
 			switch(opcion){
				
  				case 1:		//TRABAJAR CON CARACTERES
								   //PRESENTAR SUBMENU LEER Y VALIDAR OPCION
								   do{
									  metodosalfabeto.submenucaracteres();
									  opcioncaracteres=entrada.nextInt();
									}while(opcioncaracteres<0 && opcioncaracteres>5);
									   
								   //MIENTRAS OPCION SEA DISTINTA DE SALIR
								   while(opcioncaracteres!=0){
									   
										//SEGUN OPCION
										switch(opcioncaracteres){
											case 1:	//COMPARAR CARACTERES DEL ALFABETO
													//LEER Y VALIDAR CARACTER1*
													do{
														System.out.println("Introduzca un caracter. A-Z");
														caracter1=Character.toLowerCase(entrada.next().charAt(0));
														caractervalido=metodosalfabeto.compruebacaracter(caracter1);
														}while(caractervalido==false);
														
													//LEER Y VALIDAR CARACTER2*
													do{
														System.out.println("Introduzca un caracter. A-Z");
														caracter2=Character.toLowerCase(entrada.next().charAt(0));
														caractervalido=metodosalfabeto.compruebacaracter(caracter2);
													}while(caractervalido==false);
													
													//COMPARAR CARACTERES* 
													caractermayor=metodosalfabeto.comparacaracteres(caracter1,caracter2);
													
													//ESCRIBIR RESULTADO
													switch(caractermayor){
															case 1: System.out.println("El caracter "+caracter1+" es posterior al caracter "+caracter2);
															System.out.println("________________________________________________");
															break;
															
															case 2: System.out.println("El caracter "+caracter1+" es anterior al caracter "+caracter2);
															System.out.println("________________________________________________");
															break;
															
															case 3: System.out.println("El caracter "+caracter1+" es igual que el caracter "+caracter2);
															System.out.println("________________________________________________");
															break;
														}
												break;//fin comparar caracteres
												
												
												case 2:	//LETRA MAYUSCULA O MINUSCULA
										  					//LEER Y VALIDAR CARACTER*
										  					do{
																System.out.println("Introduzca una letra del alfabeto");
																letra=entrada.next().charAt(0);
																//caractervalido=metodosalfabeto.compruebacaracter(letra);
															}while(metodosalfabeto.compruebacaracter(letra)==false);
															
										  					//COMPROBAR MAYUSCULA O MINUSCULA*
										  					esmayuscula=metodosalfabeto.mayuscula(letra);
										  					
										 					//ESCRIBIR SI MAYUSCULA O MINUSCULA
															if(esmayuscula==true){
																System.out.println("Es mayuscula");
																System.out.println("________________________________________________");
																}else 
																	System.out.println("Es minuscula");
																	System.out.println("________________________________________________");
										 		break;//fin letra mayuscula o minuscula
										 		
										 		
										 		case 3:	//SIMBOLO DE PUNTUACION
															//LEER CARACTER
															System.out.println("Introduzca un caracter");
															caracter1=entrada.next().charAt(0);
															
															//COMPROBAR CARACTER*
															
															
															//ESCRIBIR SI ES SIMBOLO DE PUNTUACION
															System.out.println("EN CONSTRUCCION");
															System.out.println("________________________________________________");
												break;//FIN SIMBOLO DE PUNTUACION
												
												case 4: //DIGITO ENTRE 0 Y 9
									  						//LEER DIGITO(CARACTER)
									  						System.out.println("Introduzca un digito");
									  						digito=entrada.next().charAt(0);
									  						
									  						//COMPROBAR DIGITO(CARACTER)
									  						entre09=metodosalfabeto.estain09(digito);
									  						
															//ESCRIBIR SI ESTA ENTRE 0 Y 9
															if(entre09==1){
																System.out.println("El digito esta entre 0 y 9");
																System.out.println("________________________________________________");
																}else
																	System.out.println("El digito no esta entre 0 y 9");
																	System.out.println("________________________________________________");
												break;//fin digito entre 0 y 9
												
												
												case 5:	//MENSAJE GRACIOSILLO
															//LEER Y VALIDAR NUMERO ENTRE 0 Y 9
									  						do{
																System.out.println("Introduzca un digito entre 0 y 9");
																digito=entrada.next().charAt(0);
																System.out.println("________________________________________________");
															}while(metodosalfabeto.estain09(digito)!=1);
															
															
									  						//MENSAJE GRACIOSILLO*
									  						metodosalfabeto.mensaje(digito);	
									  						System.out.println("________________________________________________");								  			
												break;
											}//FIN SEGUN
											
											//VOLVER A PRESENTAR SUBMENUCARACTERES LEER Y VALIDAR OPCION
											do{
											   metodosalfabeto.submenucaracteres();
											   opcioncaracteres=entrada.nextInt();
											   System.out.println("________________________________________________");
										   }while(opcioncaracteres<0 && opcioncaracteres>5);
										   
										}//fin mientras distinto de salir
										
  				break;//FIN CASO 1 TRABAJAR CON CARACTERES
  				
  				case 2: //TRABAJAR CON NUMEROS
							  	//PRESENTAR SUBMENU LEER Y VALIDAR OPCION
							  	do{
									metodosnumeros.submenunumeros();
									opcionnumeros=entrada.nextInt();
									System.out.println("________________________________________________");
									}while(opcionnumeros<0 && opcionnumeros>5);
									
							  	//MIENTRAS OPCION SEA DISTINTA DE SALIR
							  	while(opcionnumeros!=0){
									
							  		//SEGUN OPCION
							  		switch(opcionnumeros){
										
							  			case 1:	//NUMERO COMPUESTO
													//LEER NUMERO
													System.out.println("Introduzca un numero");
													numero=entrada.nextInt();
													System.out.println("________________________________________________");
													
								  					//COMPROBAR SI ES COMPUESTO*
								  					escompuesto=metodosnumeros.compuesto(numero);
								  					
								  					//ESCRIBIR SI ES COMPUESTO
								  					if(escompuesto==true){
														System.out.println("El numero es compuesto");
														System.out.println("________________________________________________");
													}else
														System.out.println("El numero no es compuesto");
														System.out.println("________________________________________________");
										break;
										
										
							  			case 2: //NUMERO PERFECTO
													//LEER NUMERO
													System.out.println("Introduzca un numero");
													numero=entrada.nextInt();
													System.out.println("________________________________________________");
													
  													//COMPROBAR SI ES PERFECTO*
													esperfecto=metodosnumeros.perfecto(numero);
 
 													//ESCRIBIR SI ES PERFECTO
													if(esperfecto==true){
														System.out.println("El numero es perfecto");
														System.out.println("________________________________________________");
													}else
														System.out.println("El numero no es perfecto");
														System.out.println("________________________________________________");

										break;
										
										
										case 3: //NUMERO SEMIPERFECTO
													
													//LEER NUMERO
													System.out.println("Introduzca un numero");
													numero=entrada.nextInt();
													System.out.println("________________________________________________");
													
  													//COMPROBAR SI ES SEMIPERFECTO*
 
 
 													//ESCRIBIR SI ES SEMIPERFECTO
													 System.out.println("En construccion");
													 System.out.println("________________________________________________");
										break;
										
										
							  			case 4: //NUMERO FRIKI
													//LEER NUMERO
													System.out.println("Introduzca un numero");
													numero=entrada.nextInt();
													System.out.println("________________________________________________");
													
							  						//COMPROBAR SI ES FRIKI*
							  						
							  						
							  						//ESCRIBIR SI ES FRIKI
							  						System.out.println("En construccion");
							  						System.out.println("________________________________________________");
							  						
										break;
										
										
							  			case 5: //NUMERO PRIMO PROBABLE
													//LEER NUMERO
													System.out.println("Introduzca un numero");
													numero=entrada.nextInt();
													System.out.println("________________________________________________");
													
								 					//COMPROBAR SI ES PRIMO PROBABLE*
								 					
								 					
								  					//ESCRIBIR SI ES PRIMO RPOBABLE
								  					System.out.println("En construccion");
								  					System.out.println("________________________________________________");
										break;
														
							  		}//FIN SEGUN
							  		
							  		//VOLVER A PRESENTAR SUBMENUNUMEROS LEER Y VALIDAR OPCION
									do{
										metodosnumeros.submenunumeros();
										opcionnumeros=entrada.nextInt();
									}while(opcionnumeros<0 && opcionnumeros>5);	
							  }//FIN MIENTRAS
							  
				case 3: //TRABAJAR CON FECHAS
							//PRESENTAR MENUFECHAS LEER Y VALIDAR OPCION
							do{
								metodosfechas.menufechas();
								opcionfechas=entrada.nextInt();
							}while(opcionfechas<0 && opcionfechas>3);
								
							//MIENTRAS OPCIONFECHA SEA DISTINTA DE SALIR
							while(opcionfechas!=0){
								
								//SEGUN OPCIONFECHA
								switch(opcionfechas){
									case 1: //FECHA ATERIOR POSTERIOR IGUAL
												//LEER Y VALIDAR DIA MES AÑO 1*
												do{
													System.out.println("Introduzca el dia");
													dia1=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el mes");
													mes1=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el año");
													anyo1=entrada.nextInt();
													System.out.println("________________________________________________");
													
													fechavalida=metodosfechas.validafecha(dia1,mes1,anyo1);
												}while(fechavalida==false);
												
												//LEER Y VALIDAR DIA MES AÑO 2*
												do{
													System.out.println("Introduzca el dia");
													dia2=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el mes");
													mes2=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el año");
													anyo2=entrada.nextInt();
													System.out.println("________________________________________________");
													
													fechavalida=metodosfechas.validafecha(dia2,mes2,anyo2);
												}while(fechavalida==false);
												
												//COMPARAR FECHAS*
												fechamayor=metodosfechas.comparafechas(dia1,mes1,anyo1,dia2,mes2,anyo2);
												
												//ESCRIBIR FECHA MAYOR IGUAL O POSTERIOR
												if(fechamayor==1){
													System.out.println("La primera fecha es posterior a la segunda");
													System.out.println("________________________________________________");
													}else if(fechamayor==2){
														System.out.println("La primera fecha es anterior a la segunda");
														System.out.println("________________________________________________");
														}else
															System.out.println("Las fechas son iguales");
															System.out.println("________________________________________________");
									break;
									
									
									case 2: //CONVERTIR 24h EN AM/PM
												//LEER Y VALIDAR HORA*
												do{
													System.out.println("Introduzca la hora en formato 24h");
													hora=entrada.nextInt();
													System.out.println("________________________________________________");
													horavalida=metodosfechas.validahora(hora);
												}while(horavalida==false);
													
						   						//CONVERTIR HORA A FORMATO AM/PM*
						   						horaconv=metodosfechas.conv24hampm(hora);
						   						
						  						//ESCRIBIR HORA
						  						if(hora>=13){
													System.out.println("La hora "+hora+" h, son las "+horaconv+" PM");
													System.out.println("________________________________________________");
													}else if(hora<=12){
														System.out.println("La hora "+hora+" h, son las "+horaconv+" AM");
														System.out.println("________________________________________________");
														}
									break;
									
									
									case 3: //DIAS TRANSCURRIDOS
												//LEER Y VALIDAR DIA MES AÑO 1*
												do{
													System.out.println("Introduzca el dia");
													dia1=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el mes");
													mes1=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el año");
													anyo1=entrada.nextInt();
													System.out.println("________________________________________________");
													
													fechavalida=metodosfechas.validafecha(dia1,mes1,anyo1);
												}while(fechavalida==false);
												
												//LEER Y VALIDAR DIA MES AÑO 2*
												do{
													System.out.println("Introduzca el dia");
													dia2=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el mes");
													mes2=entrada.nextInt();
													System.out.println("");
													System.out.println("Introduzca el año");
													anyo2=entrada.nextInt();
													System.out.println("________________________________________________");
													
													fechavalida=metodosfechas.validafecha(dia2,mes2,anyo2);
												}while(fechavalida==false);	
												
												//COMPROBAR DIAS TRANSCURRIDOS*
												diastrans=metodosfechas.diastranscurridos(dia1,mes1,anyo1,dia2,mes2,anyo2);
												
								  				//ESCRIBIR DIAS TRANSCURRIDOS	
								  				System.out.println("Los dias transcurridos entre "+dia1+"/"+mes1+"/"+anyo1+" y "+dia2+"/"+mes2+"/"+anyo2+" es "+diastrans);
								  											
									break;
									
									
								}//FIN SEGUN
								
								//VOLVER A PRESENTAR MENUFECHAS LEER Y VALIDAR OPCION
								do{
									metodosfechas.menufechas();
									opcionfechas=entrada.nextInt();
									System.out.println("________________________________________________");
								}while(opcionfechas<0 && opcionfechas>3);	
							}//FIN MIENTRAS
				
				break;
				
				
				case 4:	//JUGAR	
							//PRESENTAR MENUJUGAR LEER Y VALIDAR OPCION
							do{
								metodosjugar.menujugar();
								opcionjugar=entrada.nextInt();
								System.out.println("_________________________________________________________");
								}while(opcionjugar<0 && opcionjugar>3);
								
							//MIENTRAS OPCIONJUGAR SEA DISTINTA DE SALIR
							while(opcionjugar!=0){
								
								//SEGUN OPCIONJUGAR
								switch(opcionjugar){
									case 1: //JUGAR CHICAGO
												//PREGUNTAR SI QUIERE TIRAR DADOS
												do{
													System.out.println("¿Quiere tirar los dados? S/N");
													tirar=Character.toLowerCase(entrada.next().charAt(0));
													System.out.println("_________________________________________________________");
													}while(tirar!='s' && tirar!='n');
													
												//MIENTRAS TIRAR SEA DISTINTO DE NO
												while(tirar!='n'){								
													
														do{
															//TIRAR DADOS USUARIO Y MAQUINA
															dado1=tirada.nextInt(6)+1;
															dado2=tirada.nextInt(6)+1;
															System.out.println("Ha sacado "+dado1+" y "+dado2);
															System.out.println("_________________________________________________________");
															
															dado3=tirada.nextInt(6)+1;
															dado4=tirada.nextInt(6)+1;
															System.out.println("La maquina ha sacado "+dado3+" y "+dado4);
															System.out.println("_________________________________________________________");
															
															//SUMAR DADOS*
															sumdad12=metodosjugar.sumadados(dado1,dado2);
															sumdad34=metodosjugar.sumadados(dado3,dado4);
															
															//COMPROBAR SUMA DE LOS DADOS*
															empate=metodosjugar.compempate(sumdad12,sumdad34);
															
															}while(empate==3);//si empate==3 es que han empatado la tirada preliminar
															
														//REALIZAR APUESTA
														empate=metodosjugar.compempate(sumdad12,sumdad34);
														if(empate==1){
															do{
																System.out.println("Introduzca la apuesta");
																apuesta1=entrada.nextInt();
																System.out.println("_________________________________________________________");
															}while(apuesta1<=0);															
															apuesta2=apuesta1+tirada.nextInt(100)+1;
															System.out.println("La apuesta de la maquina es "+apuesta2);
															System.out.println("_________________________________________________________");
															
															}else if(empate==2){
																apuesta2=tirada.nextInt(1000)+500;
																	System.out.println("La apuesta de la maquina es "+apuesta2);
																	System.out.println("_________________________________________________________");
																	System.out.println("");
																	
																do{
																	System.out.println("Introduzca una apuesta semejante");
																	apuesta1=entrada.nextInt();
																	System.out.println("_________________________________________________________");
																	}while(apuesta1<apuesta2);
																}
														pozo=apuesta1+apuesta2;
														
														//REALIZAR JUGADAS*
														do{
															for(clave=2;clave<=12;clave++){
																
																dado1=tirada.nextInt(6)+1;
																dado2=tirada.nextInt(6)+1;
																coincide=metodosjugar.compclave(dado1,dado2,clave);
																if(coincide==true){
																	puntosjug=puntosjug+clave;
																	}
																System.out.println("Ha sacado "+dado1+" y "+dado2+"; la clave es "+clave);
																System.out.println("Su puntuacion es "+puntosjug);
																System.out.println("_________________________________________________________");
																
																dado3=tirada.nextInt(6)+1;
																dado4=tirada.nextInt(6)+1;
																coincide=metodosjugar.compclave(dado3,dado4,clave);
																if(coincide==true){
																	puntosia=puntosia+clave;
																	}
																System.out.println("La maquina ha sacado "+dado3+" y "+dado4+"; la clave es "+clave);
																System.out.println("Su puntuacion es "+puntosia);
																System.out.println("_________________________________________________________");

															}
															
															empate=metodosjugar.compempate(puntosjug,puntosia);
															if(empate==3){
																System.out.println("Han empatado, se repetira la jugada");
																}
														}while(empate==3);//FIN MIENTRAS HAYA EMPATE
													
													//COMPROBAR GANADOR													
													if(empate==1){
														System.out.println("Felicidades ha ganado la suma de "+pozo);	
														System.out.println("_________________________________________________________");													
														}else
															System.out.println("Ha perdido la suma de "+pozo);
															System.out.println("_________________________________________________________");
													pozo=0;
													//PREGUNTAR SI QUIERE VOLVER A JUGAR
													do{
														System.out.println("¿Quiere volver a jugar? S/N");
														tirar=Character.toLowerCase(entrada.next().charAt(0));
														System.out.println("_________________________________________________________");
													}while(tirar!='s' && tirar!='n');													
												}//FIN MIENTRAS
												
									break;		
									
									//CASO 2: JUGAR BARBUDI
						   
									//CASO 3: JUAGR CHINOS
						   

									
									}//FIN SEGUN
									//VOLVER A PRESENTAR MENUJUGAR LEER Y VALIDAR OPCION
									do{
										metodosjugar.menujugar();
										opcionjugar=entrada.nextInt();
										System.out.println("_________________________________________________________");
									}while(opcionjugar<0 && opcionjugar>3);
							}//FIN MIENTRAS
				break;
				
				case 5:	//PINTAR RELOJ DE ARENA
							// LEER Y VALIDAR NUMERO*
							do{
								System.out.println("Introduzca un numero impar entre 1 y 15");
								numero=entrada.nextInt();
								valido=metodopintareloj.impar(numero);
								}while(valido==false);
							
							//LEER CARACTER
							System.out.println("Introduzca un caracter");
							caracter1=Character.toLowerCase(entrada.next().charAt(0));
							
							// PINTAR RELOJ
							metodopintareloj.pintareloj(numero,caracter1);
				break;
  			}//FIN SEGUN PRINCIPAL
  			
  			//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
  			do{
				metodosalfabeto.menuprincipal();
				opcion=entrada.nextInt();
				System.out.println("________________________________________________");
			}while(opcion<0 && opcion>5);
			
  		}//FIN MIENTRAS
	
	}
}
