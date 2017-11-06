/*
 * Analisis
 * 	Proposito: Juego que simula el tres en raya de forma tridimensional
 * 	Entradas: 
 * 				juega>> cadena
 * 				jug1, jug2: nombre de los jugadores
 * 				icadena, jcadena, kcadena: profundidad, fila y columna
 * 	Salidas:
 * 	Restricciones: 
 * 				juega>> solo puede ser 's' o 'n'
 * 				jug1, jug2>> no pueden estar vacios
 * 				icadena, jcadena, kcadena>> deben ser mayor o igual que 0 y menor que 3
 * 				Las fichas solo pueden ponerse en espacios vacios
 * 				Cada jugador tiene tres fichas y debe mover solo las suyas
 * 
 * 
 * 
 *Pseudocodigo Generalizado
  
  //Leer y validar si juega*
  //Mientras juega sea si
  	//Leer y validar nombre jugador1*
  	//Leer y validar nombre jugador2*
  	//Tirar dados Mientras haya empate*
  	//Comprobar primero en mover*
  	//PONER FICHAS
  	//Si NO HAY GANADOR
 		//MOVER FICHAS
  	//Pintar Cubo*
  	//Vaciar Cubo
 	//Escribir Ganador
  	//Volver a leer y validar si juega*
  //Fin Mientras jugar sea si
  
  FIN
*/


/*	//PONER FICHAS	
    	//SI jugador 1 sale primero
  		//Repetir Mientras los jugadores tengan fichas* y no haya ganador
  				//Turno Jugador 1
  				//Pintar Cubo*
  				//Leer y validar Poner Ficha*
  				//Poner ficha*
 				//Comprobar si hay ganador*
  			//Si NO HAY GANADOR
  				//Turno Jugador 2
  				//Pintar Cubo*
  				//Leer y validar Poner Ficha*
  				//Poner ficha*
  				//Comprobar si hay ganador*
  			//FIN SI NO HAY GANADOR
  		//Fin Repetir Mientras 
  	//SINO SI jugador 2 sale primero
  		//Repetir Mientras los jugadores tengan fichas* y no haya ganador
  				//Turno Jugador 2
  				//Pintar Cubo*
  				//Leer y validar Poner Ficha*
  				//Poner ficha*
  				//Comprobar si hay ganador*
  			//Si NO HAY GANADOR
  				//Turno Jugador 1
  				//Pintar Cubo*
  				//Leer y validar Poner Ficha*
  				//Poner ficha*
  				//Comprobar si hay ganador*
  			//FIN SI NO HAY GANADOR
  		//Fin Repetir Mientras 
  	//Fin SI SINO
*/


/* 	//MOVER FICHAS
 		
  		//Si jugador 1 mueve primero
  			//Repetir Mientras no haya ganador
  					//Turno Jugador 1
  					//Pintar Cubo*
  					//Leer y validar QUITAR FICHA *
  					//QUITAR FICHA* 
 					//Leer y validar PONER FICHA*
  					//Poner Ficha*
  					//Comprobar si hay ganador*	
  				//SI NO HAY GANADOR
 					//Turno Jugador 2
  					//Pintar Cubo*
  					//Leer y validar QUITAR FICHA *
  					//QUITAR FICHA* 
  					//Leer y validar PONER FICHA*
  					//Poner Ficha*
  					//Comprobar si hay ganador*	
  				//FIN SI NO HAY GANADOR
 			//FIN Repetir Mientras no haya ganador
  		//SINO SI jugador 2 sale primero
  			//Repetir Mientras no haya ganador
  					//Turno Jugador 2
  					//Pintar Cubo*
  					//Leer y validar QUITAR FICHA *
  					//QUITAR FICHA* 
  					//Leer y validar PONER FICHA*
  					//Poner Ficha*
  					//Comprobar si hay ganador*	
  				//SI NO HAY GANADOR
  					//Turno Jugador 1
  					//Pintar Cubo*
  					//Leer y validar QUITAR FICHA *
  					//QUITAR FICHA* 
  					//Leer y validar PONER FICHA*
  					//Poner Ficha*
  					//Comprobar si hay ganador*	
  				//FIN SI NO HAY GANADOR
  			//FIN Repetir Mientras no haya ganador
  		//Fin SI SINO
  	//Fin SI EN LA RONDA ANTERIOR NO HUBO GANADOR 
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Juego3enRaya3D {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String juega=" ";
		String jug1,jug2;
		boolean winner1=false;
		int dado1,dado2;
		boolean ganador=false,gana1=false,pasa=false;
		gestoraJuego juego=new gestoraJuego();
		String icadena,jcadena,kcadena;
		
		
		//Leer y validar si juega*
		do{
			System.out.println("¿Quiere Jugar? S/N");
			juega=bf.readLine().replace(" ","").toLowerCase();
			System.out.println("");
		}while(!juego.validaJuega(juega));
		
		//Mientras juega sea si
		while(juega.equals("s")){
		
			//Leer y validar nombre jugador1*
			do{
				System.out.println("Introduzca el nombre del jugador 1");
				jug1=bf.readLine();
				System.out.println("");
			}while(!juego.compruebaNombre(jug1));
			
			//Leer y validar nombre jugador2*
			do{
				System.out.println("Introduzca el nombre del jugador 2");
				jug2=bf.readLine();
				System.out.println("");
			}while(!juego.compruebaNombre(jug2));
			
			//Tirar dados Mientras haya empate*
			do{
				System.out.println("Tiremos los dados");System.out.println("");				
				dado1=juego.tiraDado();
				dado2=juego.tiraDado();
				//dado1=5;
				//dado2=3;
				System.out.println(jug1+" ha sacado "+dado1);System.out.println("");
				System.out.println(jug2+" ha sacado "+dado2);System.out.println("");
				
				if(juego.comparaDados(dado1, dado2)==0){
					System.out.println("Ha habido empate");
				}
				
			}while(juego.comparaDados(dado1, dado2)==0);//Fin Repetir Mientras
				
			//Comprobar primero en mover
			if(juego.comparaDados(dado1, dado2)==1){
				System.out.println("Pone ficha primero "+jug1);
				System.out.println("");
				gana1=true;
			}else if (juego.comparaDados(dado1, dado2)==-1){
					System.out.println("Pone ficha primero "+jug2);
					System.out.println("");
				}	
					
					//jugador 1 sale primero
					if(gana1==true){
						
						//Repetir Mientras los jugadores tengan fichas y no haya ganador
						do{							
								//Turno Jugador 1
								//Leer y validar Poner Ficha
								do{										
									
									juego.getCubo().pintaCubo();
									System.out.println("");
										System.out.println("Turno de "+jug1);										
										System.out.println("");
										
										System.out.println("Introduzca la profundidad donde quiere poner la ficha");
										icadena=bf.readLine().replace(" ", "");									
										System.out.println("");	
										
										System.out.println("Introduzca la fila donde quiere poner la ficha");										
										jcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										System.out.println("Introduzca la columna donde quiere poner la ficha");										
										kcadena=bf.readLine().replace(" ", "");
										System.out.println("");								
																				
									//Poner ficha*
									pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 1);
																	
								}while( !pasa);
								pasa=false;
								
								//Comprobar si hay ganador							
								if(juego.getCubo().compruebaGanador()){
									ganador=true;
									winner1=true;
								}																																									
									
							//Si NO HAY GANADOR
							if(ganador==false){
								//Turno Jugador 2
								//Leer y validar Poner Ficha
								do{
									juego.getCubo().pintaCubo();
									System.out.println("");
										System.out.println("Turno de "+jug2);
										System.out.println("");
										
										System.out.println("Introduzca la profundidad donde quiere poner la ficha");
										icadena=bf.readLine().replace(" ", "");									
										System.out.println("");	
										
										System.out.println("Introduzca la fila donde quiere poner la ficha");
										jcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										System.out.println("Introduzca la columna donde quiere poner la ficha");
										kcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										//Poner Ficha
										pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 2);
								}while(!pasa);
								pasa=false;
								
								//Comprobar si hay ganador*									
								if(juego.getCubo().compruebaGanador()){
									ganador=true;								
								}									
							}//FIN SI NO HAY GANADOR																																
						}while(juego.getCubo().getPosicionesLibres()>21 && ganador==false);//Fin Mientras queden fichas y no haya ganador
							
					}else{// jugador 2 sale primero						
						//Repetir Mientras los jugadores tengan fichas y no haya ganador
						do{
								//Turno Jugador 2
								//Leer y validar Poner Ficha
								do{									
									juego.getCubo().pintaCubo();
									System.out.println("");
										System.out.println("Turno de "+jug2);
										System.out.println("");
										
										System.out.println("Introduzca la profundidad donde quiere poner la ficha");
										icadena=bf.readLine().replace(" ", "");										
										System.out.println("");	
										
										System.out.println("Introduzca la fila donde quiere poner la ficha");
										jcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										System.out.println("Introduzca la columna donde quiere poner la ficha");
										kcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										//Poner Ficha
										pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 2);
								}while( !pasa);
								pasa=false;
								
								//Comprobar si hay ganador*						
								if(juego.getCubo().compruebaGanador()){
									ganador=true;
								}																																			
									
							//jugador 1 sale segundo
							//Si NO HAY GANADOR
							if(ganador==false){
								//Turno Jugador 1
								//Leer y validar Poner Ficha
								do{
									juego.getCubo().pintaCubo();
									System.out.println("");
										System.out.println("Turno de "+jug1);
										System.out.println("");
										
										System.out.println("Introduzca la profundidad donde quiere poner la ficha");
										icadena=bf.readLine().replace(" ", "");									
										System.out.println("");	
										
										System.out.println("Introduzca la fila donde quiere poner la ficha");
										jcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										System.out.println("Introduzca la columna donde quiere poner la ficha");
										kcadena=bf.readLine().replace(" ", "");
										System.out.println("");

										//Poner Ficha
										pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 1);
								}while(!pasa);
								pasa=false;
								
								//Comprobar si hay ganador*									
								if(juego.getCubo().compruebaGanador()){
									ganador=true;
								}									
								
							}//FIN SI NO HAY GANADOR																																
						}while(juego.getCubo().getPosicionesLibres()>21 && ganador==false);//Fin Mientras queden fichas
																		
					}//Fin SI sale jugador 1 SINO sale jugador 2	
							
					
				//Si no hay ganador
				if(ganador==false){
						
					//MOVER FICHAS
					
					//Si jugador 1 mueve primero
					if(gana1==true){
						
						//Repetir Mientras no haya ganador
						do{
									//Leer y validar QUITAR FICHA 
									do{								
										juego.getCubo().pintaCubo();
										System.out.println("");
											System.out.println("Mueve ficha "+jug1);
											System.out.println("");
											
											System.out.println("Introduzca la profundidad de la ficha que quiere cambiar");
											icadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la fila de la ficha que quiere cambiar");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna de la ficha que quiere cambiar");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");											
										
											//Quitar Ficha
											pasa=juego.getCubo().quitaFicha(icadena, jcadena, kcadena, 1);
											
									}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
									pasa=false;
																																	
									//Leer y validar PONER FICHA
									do{
										
										juego.getCubo().pintaCubo();
										System.out.println("");
										
										//do{
											System.out.println("Introduzca la profundidad donde quiere poner la ficha");
											icadena=bf.readLine().replace(" ", "");									
											System.out.println("");	
											
											System.out.println("Introduzca la fila donde quiere poner la ficha");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna donde quiere poner la ficha");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");

											//Poner Ficha
											pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 1);

									}while( !pasa);//FIN LEER Y VALIDAR PONER FICHA
									pasa=false;
									
									//Comprobar si hay ganador*	
									if(juego.getCubo().compruebaGanador()){
										ganador=true;
										winner1=true;
									}										
								
							//jugador 2 mueve segundo
								
								//SI NO HAY GANADOR
								if(ganador==false){								
								
									
									//Leer y validar QUITAR FICHA 
									do{								
										juego.getCubo().pintaCubo();
										System.out.println("");
											System.out.println("Mueve ficha "+jug2);
											System.out.println("");
											
											System.out.println("Introduzca la profundidad de la ficha que quiere cambiar");
											icadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la fila de la ficha que quiere cambiar");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna de la ficha que quiere cambiar");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											//QUITAR FICHA
											pasa=juego.getCubo().quitaFicha(icadena, jcadena, kcadena, 2);							
									}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
									pasa=false;
	
									
									//Leer y validar PONER FICHA
									do{
										juego.getCubo().pintaCubo();
										System.out.println("");									
											System.out.println("Introduzca la profundidad donde quiere poner la ficha");
											icadena=bf.readLine().replace(" ", "");										
											System.out.println("");	
											
											System.out.println("Introduzca la fila donde quiere poner la ficha");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna donde quiere poner la ficha");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");

											//Poner Ficha
											pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 2);
									}while(!pasa);
									pasa=false;
									
									//Comprobar si hay ganador*	
									if(juego.getCubo().compruebaGanador()){
										ganador=true;
									}	
								}//FIN SI NO HAY GANADOR
						}while(ganador==false);//FIN Repetir Mientras no haya ganador
																				
						}else{								
							//Repetir Mientras no haya ganador
							do{
								// jugador 2 mueve primero
																	
								//Leer y validar QUITAR FICHA 
								do{								
									juego.getCubo().pintaCubo();
									System.out.println("");
										System.out.println("Mueve ficha "+jug2);
										System.out.println("");
										
										System.out.println("Introduzca la profundidad de la ficha que quiere cambiar");
										icadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										System.out.println("Introduzca la fila de la ficha que quiere cambiar");
										jcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										System.out.println("Introduzca la columna de la ficha que quiere cambiar");
										kcadena=bf.readLine().replace(" ", "");
										System.out.println("");
										
										//QUITAR FICHA 
										pasa=juego.getCubo().quitaFicha(icadena, jcadena, kcadena, 2);												
								}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
								pasa=false;

								
									//Leer y validar PONER FICHA
									do{										
										juego.getCubo().pintaCubo();
										System.out.println("");
											System.out.println("Introduzca la profundidad donde quiere poner la ficha");
											icadena=bf.readLine().replace(" ", "");										
											System.out.println("");	
											
											System.out.println("Introduzca la fila donde quiere poner la ficha");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna donde quiere poner la ficha");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");

											//Poner Ficha
											pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 2);
									}while( !pasa);
									pasa=false;
									
									//Comprobar si hay ganador*		
									if(juego.getCubo().compruebaGanador()){
										ganador=true;
									}																																									
													
								//jugador 1 mueve segundo								
								//SI NO HAY GANADOR
								if(ganador==false){
																	
									//Leer y validar QUITAR FICHA 
									do{								
										juego.getCubo().pintaCubo();
										System.out.println("");
										//Leer y validar posicion
										//do{
											System.out.println("Introduzca la profundidad de la ficha que quiere cambiar");
											icadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la fila de la ficha que quiere cambiar");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna de la ficha que quiere cambiar");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											//QUITAR FICHA 
											pasa=juego.getCubo().quitaFicha(icadena, jcadena, kcadena, 1);							
									}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
									pasa=false;

									
									//Leer y validar PONER FICHA
									do{
										juego.getCubo().pintaCubo();
										System.out.println("");
											System.out.println("Introduzca la profundidad donde quiere poner la ficha");
											icadena=bf.readLine().replace(" ", "");										
											System.out.println("");	
											
											System.out.println("Introduzca la fila donde quiere poner la ficha");
											jcadena=bf.readLine().replace(" ", "");
											System.out.println("");
											
											System.out.println("Introduzca la columna donde quiere poner la ficha");
											kcadena=bf.readLine().replace(" ", "");
											System.out.println("");

											//Poner Ficha
											pasa=juego.getCubo().ponFicha(icadena, jcadena, kcadena, 1);

									}while(!pasa);
									pasa=false;
									
									//Comprobar si hay ganador*	
									if(juego.getCubo().compruebaGanador()){
										ganador=true;
										winner1=true;
									}
								}//FIN SI NO HAY GANADOR
							}while(ganador==false);																	
					}//Fin SI sale jugador 1 SINO sale jugador 2					
											
				}//Fin SI EN LA RONDA ANTERIOR NO HUBO GANADOR
			
			juego.getCubo().pintaCubo();
			System.out.println("");
			
			ganador=false;
			gana1=false;
			
			//Vaciar Cubo
			juego.getCubo().montaCubo();
			
			//ESCRIBIR GANADOR
			if(winner1==true){
				System.out.println("Gana "+jug1);System.out.println("");
			}else
				System.out.println("Gana "+jug2);System.out.println("");
						
			//Volver a leer y validar si juega*
			do{
				System.out.println("¿Quiere volver a Jugar? S/N");
				//juega=Character.toLowerCase(entrada.next().charAt(0));
				juega=bf.readLine();
				System.out.println("");
			}while(!juego.validaJuega(juega));//Fin Mientras
			
		}//Fin Mientras jugar sea si	
		//entrada.close();
	}
}