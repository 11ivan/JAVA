		//Leer y validar si juega
		//Mientras juega sea si
			//Leer nombre jugador1
			//Leer nombre jugador2
			//Tirar dados
			//Mientras no haya ganador
				//Leer y validar jugada
				//Pintar tablero*
				//Comprobar si hay ganador*
			//Fin Mientras
			//Volver a leer y validar si juega
		//Fin Mientras

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class JuegoTresEnRaya {

	public static void main(String[] args) throws IOException{
		
		Random aleatorio=new Random();
		Scanner entrada=new Scanner(System.in);
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		char juega=' ';
		String jug1,jug2;
		boolean winner1=false;
		int dado1,dado2;
		boolean empate=false,ganador=false,gana1=false,pasa=false;
		tresEnRaya juego=new tresEnRaya();
		int i,j;
		
		//Leer y validar si juega
		do{
			System.out.println("¿Quiere Jugar?");
			juega=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("");
		}while(juega!='s' && juega!='n');
		
		//Mientras juega sea si
		while(juega=='s'){
		
			//Leer nombre jugador1
			System.out.println("Introduzca el nombre del jugador 1");
			jug1=bf.readLine();
			System.out.println("");
			//jug1=entrada.next();
			
			//Leer nombre jugador2
			System.out.println("Introduzca el nombre del jugador 2");
			jug2=bf.readLine();
			System.out.println("");
			//jug2= entrada.next();
			
			//Repetir Mientras haya empate
			do{
				System.out.println("Tiremos los dados");System.out.println("");
				//Tirar dados
				dado1=aleatorio.nextInt(6)+1;
				dado2=aleatorio.nextInt(6)+1;
				//dado1=2;
				//dado2=6;
				System.out.println(jug1+" ha sacado "+dado1);System.out.println("");
				System.out.println(jug2+" ha sacado "+dado2);System.out.println("");
				if(dado1==dado2){
					empate=true;
					System.out.println("Ha habido empate");
				}else {
					empate=false;
				}
			}while(empate==true);//Fin Mientras
				
			//Comprobar primero en mover
			if(dado1>dado2){
				System.out.println("Pone ficha primero "+jug1);
				System.out.println("");
				gana1=true;
			}else 
				System.out.println("Pone ficha primero "+jug2);
				System.out.println("");
			
					//jugador 1 sale primero
					if(gana1==true){
						
						//Repetir Mientras los jugadores tengan fichas y no haya ganador
						do{
							//Si NO HAY GANADOR
							if(ganador==false){
																														
								//Leer y validar jugada
								do{
									
									juego.pintaTablero();
									System.out.println("");
									//Leer y validar posicion
									do{
										System.out.println("Turno de "+jug1);
										System.out.println("");
										System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
										i=entrada.nextInt();
										System.out.println("");
										System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
										j=entrada.nextInt();		
										System.out.println("");
									}while(!juego.validaPosicion(i, j));
									
									if(juego.validaPonFicha(i, j)){
										juego.ponFicha(i, j, 1);
										pasa=true;
									}
								}while( !pasa);
								pasa=false;
								
								//Comprobar si hay ganador*		//poner ganador a true y un indicador para saber quien gana								
								if(juego.compruebaGanador()){
									ganador=true;
									winner1=true;
								}																	
							}//FIN SI NO HAY GANADOR												
										
									
							//jugador 2 sale segundo
							//Si NO HAY GANADOR
							if(ganador==false){

								//Leer y validar jugada
								do{
									juego.pintaTablero();
									System.out.println("");
									//Leer y validar posicion
									do{
										System.out.println("Turno de "+jug2);
										System.out.println("");
										System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
										i=entrada.nextInt();
										System.out.println("");
										System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
										j=entrada.nextInt();	
										System.out.println("");
									}while(!juego.validaPosicion(i, j));
									
									//Si la posiscion elegida es correcta llamamos a ponFicha y cambiamos pasa a true
									if(juego.validaPonFicha(i, j)){
										juego.ponFicha(i, j, 2);
										pasa=true;
									}
								}while(!pasa);
								pasa=false;
								
								//Comprobar si hay ganador*									
								if(juego.compruebaGanador()){
									ganador=true;
									//winner2=true;;
								}									
							}//FIN SI NO HAY GANADOR																																
						}while(juego.getPosicionesLibres()>3 && ganador==false);//Fin Mientras queden fichas y no haya ganador
							
					}else{// jugador 2 sale primero						
						//Repetir Mientras los jugadores tengan fichas
						do{
							//Si NO HAY GANADOR
							if(ganador==false){
																														
								//Leer y validar jugada
								do{									
									juego.pintaTablero();
									System.out.println("");
									//Leer y validar posicion
									do{
										System.out.println("Turno de "+jug2);
										System.out.println("");
										System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
										i=entrada.nextInt();
										System.out.println("");
										System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
										j=entrada.nextInt();	
										System.out.println("");
									}while(!juego.validaPosicion(i, j));
									
									if(juego.validaPonFicha(i, j)){
										juego.ponFicha(i, j, 2);
										pasa=true;
									}
								}while( !pasa);
								pasa=false;
								
								//Comprobar si hay ganador*		//poner ganador a true y un indicador para saber quien gana								
								if(juego.compruebaGanador()){
									ganador=true;
									//winner2=true;
								}																	
							}//FIN SI NO HAY GANADOR									
										
									
							//jugador 2 sale segundo
							//Si NO HAY GANADOR
							if(ganador==false){
								
								//Leer y validar jugada
								do{
									juego.pintaTablero();
									System.out.println("");
									//Leer y validar posicion
									do{
										System.out.println("Turno de "+jug1);
										System.out.println("");
										System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
										i=entrada.nextInt();
										System.out.println("");
										System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
										j=entrada.nextInt();	
										System.out.println("");
									}while(!juego.validaPosicion(i, j));
									
									//Si la posiscion elegida es correcta llamamos a ponFicha y cambiamos pasa a true
									if(juego.validaPonFicha(i, j)){
										juego.ponFicha(i, j, 1);
										pasa=true;
									}
								}while(!pasa);
								pasa=false;
								
								//Comprobar si hay ganador*									
								if(juego.compruebaGanador()){
									ganador=true;
									//winner2=true;;
								}									
								
							}//FIN SI NO HAY GANADOR																																
						}while(juego.getPosicionesLibres()>3 && ganador==false);//Fin Mientras queden fichas
																		
					}//Fin SI sale jugador 1 SINO sale jugador 2	
					

					
				//A PARTIR DE AQUI SE EMPIEZA A MOVER FICHAS
				
				if(ganador==false){
									
					//jugador 1 mueve primero
					if(gana1==true){
						
						//Repetir Mientras no haya ganador
						do{
								//SI NO HAY GANADOR
								if(ganador==false){
							
									//Leer y validar QUITAR FICHA 
									do{								
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											System.out.println("Mueve ficha "+jug1);
											System.out.println("");
											System.out.println("Introduzca la posicion fila de la ficha que quiere cambiar");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna de la ficha que quiere cambiar");
											j=entrada.nextInt();
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										if(juego.validaQuitaFicha(i, j, 1)){
											juego.quitaFicha(i, j, 1);
											pasa=true;
										}									
									}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
									pasa=false;
																																	
									//Leer y validar PONER FICHA
									do{
										
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											//System.out.println("Turno de "+jug1);
											System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
											j=entrada.nextInt();	
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										if(juego.validaPonFicha(i, j)){
											juego.ponFicha(i, j, 1);
											pasa=true;
										}
									}while( !pasa);//FIN LEER Y VALIDAR PONER FICHA
									pasa=false;
									
									//Comprobar si hay ganador*	
									if(juego.compruebaGanador()){
										ganador=true;
										winner1=true;
									}									
								}//FIN SI NO HAY GANADOR		
								
							//jugador 2 mueve segundo
								
								//SI NO HAY GANADOR
								if(ganador==false){								
								
									
									//Leer y validar QUITAR FICHA 
									do{								
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											System.out.println("Mueve ficha "+jug2);
											System.out.println("");
											System.out.println("Introduzca la posicion fila de la ficha que quiere cambiar");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna de la ficha que quiere cambiar");
											j=entrada.nextInt();	
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										if(juego.validaQuitaFicha(i, j, 2)){
											juego.quitaFicha(i, j, 2);
											pasa=true;
										}									
									}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
									pasa=false;
	
									
									//Leer y validar PONER FICHA
									do{
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											//System.out.println("Turno de "+jug2);
											System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
											j=entrada.nextInt();	
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										//Si la posiscion elegida es correcta llamamos a ponFicha y cambiamos pasa a true
										if(juego.validaPonFicha(i, j)){
											juego.ponFicha(i, j, 2);
											pasa=true;
										}
									}while(!pasa);
									pasa=false;
									
									//Comprobar si hay ganador*	
									if(juego.compruebaGanador()){
										ganador=true;
										//winner2=true;
									}	
								}//FIN SI NO HAY GANADOR
						}while(ganador==false);
																				
						}else{								
							//Repetir Mientras no haya ganador
							do{
								// jugador 2 mueve primero
								//SI NO HAY GANADOR
								if(ganador==false){
									
								
								//Leer y validar QUITAR FICHA 
								do{								
									juego.pintaTablero();
									System.out.println("");
									//Leer y validar posicion
									do{
										System.out.println("Mueve ficha "+jug2);
										System.out.println("");
										System.out.println("Introduzca la posicion fila de la ficha que quiere cambiar");
										i=entrada.nextInt();
										System.out.println("");
										System.out.println("Introduzca la posicion columna de la ficha que quiere cambiar");
										j=entrada.nextInt();
										System.out.println("");
									}while(!juego.validaPosicion(i, j));
									
									if(juego.validaQuitaFicha(i, j, 2)){
										juego.quitaFicha(i, j, 2);
										pasa=true;
									}									
								}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
								pasa=false;

								
									//Leer y validar PONER FICHA
									do{										
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											//System.out.println("Turno de "+jug2);
											System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
											j=entrada.nextInt();
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										if(juego.validaPonFicha(i, j)){
											juego.ponFicha(i, j, 2);
											pasa=true;
										}
									}while( !pasa);
									pasa=false;
									
									//Comprobar si hay ganador*		
									if(juego.compruebaGanador()){
										ganador=true;
										//winner2=true;
									}																																									
								}//FIN SI NO HAY GANADOR
								
								
								//jugador 1 mueve segundo								
								//SI NO HAY GANADOR
								if(ganador==false){
																	
									//Leer y validar QUITAR FICHA 
									do{								
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											System.out.println("Mueve ficha "+jug1);
											System.out.println("");
											System.out.println("Introduzca la posicion fila de la ficha que quiere cambiar");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna de la ficha que quiere cambiar");
											j=entrada.nextInt();	
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										if(juego.validaQuitaFicha(i, j, 1)){
											juego.quitaFicha(i, j, 1);
											pasa=true;
										}									
									}while( !pasa);//FIN LEER Y VALIDAR QUITAR FICHA
									pasa=false;

									
									//Leer y validar PONER FICHA
									do{
										juego.pintaTablero();
										System.out.println("");
										//Leer y validar posicion
										do{
											//System.out.println("Turno de "+jug1);
											System.out.println("Introduzca la posicion fila donde quiere poner la ficha");
											i=entrada.nextInt();
											System.out.println("");
											System.out.println("Introduzca la posicion columna donde quiere poner la ficha");
											j=entrada.nextInt();			
											System.out.println("");
										}while(!juego.validaPosicion(i, j));
										
										//Si la posiscion elegida es correcta llamamos a ponFicha y cambiamos pasa a true
										if(juego.validaPonFicha(i, j)){
											juego.ponFicha(i, j, 1);
											pasa=true;
										}
									}while(!pasa);
									pasa=false;
									
									//Comprobar si hay ganador*	
									if(juego.compruebaGanador()){
										ganador=true;
										winner1=true;
									}
								}//FIN SI NO HAY GANADOR
							}while(ganador==false);																	
					}//Fin SI sale jugador 1 SINO sale jugador 2					
											
				}//Fin SI EN LA RONDA ANTERIOR NO HUBO GANADOR
			
			juego.pintaTablero();
			System.out.println("");
			
			ganador=false;
			gana1=false;
			juego.montaTablero();
			
			//ESCRIBIR GANADOR
			if(winner1==true){
				System.out.println("Gana "+jug1);System.out.println("");
			}else
				System.out.println("Gana "+jug2);System.out.println("");
						
			//Volver a leer y validar si juega
			do{
				System.out.println("¿Quiere volver a Jugar?");
				juega=Character.toLowerCase(entrada.next().charAt(0));
				System.out.println("");
			}while(juega!='s' && juega!='n');//Fin Mientras
			
		}//Fin Mientras jugar sea si	
		entrada.close();
	}
}
