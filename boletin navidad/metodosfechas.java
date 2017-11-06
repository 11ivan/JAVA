//metodosfechas.java
public class metodosfechas{

				/*menufechas
		 * INTERFAZ
		 * Proposito: mostrar un menu de opciones
		 * Prototipo: void menufechas()
		 * Precondiciones: no hay
		 * Entradas: no hay
		 * Salidas: no hay
		 * E/S: no hay
		 * Postcondiciones: no hay
		 */
		 //RESGUARDO
		 //public static void menufechas(){System.out.println("MENU");}
		 public static void menufechas(){
			 
			 System.out.println("Elija una opcion del menu");
			 System.out.println("0: Salir");
			 System.out.println("1: Fecha anterior posterior igual");
			 System.out.println("2: Convertir 24h en AM/PM");
			 System.out.println("3: Dias transcurridos");
		}
		 
//---------------------------------------------------------------------------------------------
				/*validafecha
		 * INTERFAZ
		 * Proposito: comprobar una fecha dada en dia mes año
		 * Prototipo: boolean validafecha(int dia,int mes,int anyo)
		 * Precondiciones: no hay
		 * Entradas: tres enteros
		 * Salidas: un booleano
		 * E/S: no hay
		 * Postcondiciones: AN un booleano que sera verdadero si la fecha es correcta
		 */
		 //RESGUARDO
		 //public static boolean validafecha(int dia,int mes,int anyo){return(true);}
		 public static boolean validafecha(int dia,int mes,int anyo){
			 boolean fechavalida=false;
			 boolean esbisiesto=false;
			 
			 if(anyo>=1582){
			 esbisiesto=bisiesto(anyo);
				}
				
			/* if(esbisiesto==false && dia==29){
				 fechavalida=false;
				 }else if(mes==1 && dia>=1 && dia<=31 || mes==3 && dia>=1 && dia<=31 || mes==5 && dia>=1 && dia<=31 || mes==7 && dia>=1 && dia<=31 || mes==8 && dia>=1 && dia<=31 || mes==10 && dia>=1 && dia<=31 || mes==12 && dia>=1 && dia<=31){
						fechavalida=true;
					 }else if(mes==4 && dia>=1 && dia<=30 || mes==6 && dia>=1 && dia<=30 || mes==9 && dia>=1 && dia<=30 || mes==11 && dia>=1 && dia<=30){
						 fechavalida=true;
						 }else if(mes==2 && dia>=1 && dia<=29){
							 fechavalida=true;
							 }*/
			if(anyo<0){
				fechavalida=false;
			}else{	
			switch(mes){
				
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:	
							if(dia>=1 && dia <=31){
							fechavalida=true;
							}
				break;
				
				case 2: if(esbisiesto==false && dia>=1 && dia<=28){
							fechavalida=true;
							}else if(esbisiesto==true && dia>=1 && dia<=29){
								fechavalida=true;
								}
				break;
				
				case 4:
				case 6:
				case 9:
				case 11:
							if(dia>=1 && dia <=30){
							fechavalida=true;
							}
				break;										
				}
			}				 

				return (fechavalida);

		}
		 
//---------------------------------------------------------------------------------------------
				/*bisiesto
		 * INTERFAZ
		 * Proposito: si un año es bisiesto
		 * Prototipo: boolean bisiesto(int anyo)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un booleano
		 * E/S: no hay
		 * Postcondiciones: AN un booleano que sera verdadero si el año es bisiesto
		 */
		 //RESGUARDO
		 //public static boolean bisiesto(int anyo){return true;}
		 
		 public static boolean bisiesto(int anyo){
			 boolean esbisiesto=false;
			 if(anyo%400==0 || anyo%4==0 && anyo%100!=0){
				 esbisiesto=true;
				 }
			 return (esbisiesto);

		}
//---------------------------------------------------------------------------------------------
					/*comparafechas
		 * INTERFAZ
		 * Proposito: comprobar si la primera fecha es posterior, anterior o igual que la segunda
		 * Prototipo: int comparafechas(int dia1,int mes1,int anyo1,int dia2,int mes2,int anyo2)
		 * Precondiciones: las fechas seran validas
		 * Entradas: seis entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera 1 si las primera fecha es posterior, 2 si la segunda es posterior y tres si son iguales
		 */
		 //RESGUARDO
		 //public static int comparafechas(int dia1,int mes1,int anyo1,int dia2,int mes2,int anyo2){return 1;}
		 
		 public static int comparafechas(int dia1,int mes1,int anyo1,int dia2,int mes2,int anyo2){
			 int comparacion,compdia,compmes,companyo;
			 
			 compdia=comparadia(dia1,dia2);
			 compmes=comparames(mes1,mes2);
			 companyo=comparaanyo(anyo1,anyo2);//si companyo es 1 el primer año es posterior al segundo
			 			 			 			 
			 if(companyo==1 || companyo==3 && compmes==1 || companyo==3 && compmes==3 && compdia==1){
				 				 
				 comparacion=1;		//la primera fecha es posterior a la segunda
				 
				}else if(companyo==2 || companyo==3 && compmes==2 || companyo==3 && compmes==3 && compdia==2){
					
					comparacion=2;		//la segunda fecha es posterior a la primera
					
					}else 
						comparacion=3;
			
			return (comparacion);

		}
//---------------------------------------------------------------------------------------------
						/*comparadia
		 * INTERFAZ
		 * Proposito: comprobar si un dia es posterior, anterior o igual que otro
		 * Prototipo: int comparadia(int dia1,int dia2)
		 * Precondiciones: las dias seran validos
		 * Entradas: seis entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera 1 si las primera fecha es mayor, 2 si la segunda es mayor y tres si son iguales
		 */
		 //RESGUARDO
		 //public static int int comparadia(int dia1,int dia2){return 1;}
		 
		 public static int comparadia(int dia1,int dia2){
			 int comparacion;
			 								 
			 if(dia1>dia2){
				 comparacion=1;
				 }else if(dia2>dia1){
					 comparacion=2;
					 }else 
						comparacion=3;
			return (comparacion);

		}
//---------------------------------------------------------------------------------------------
						/*comparames
		 * INTERFAZ
		 * Proposito: comprobar si un mes es posterior, anterior o igual que otro
		 * Prototipo: int comparames(int mes1,int mes2)
		 * Precondiciones: las meses seran validos
		 * Entradas: seis entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera 1 si las primera fecha es mayor, 2 si la segunda es mayor y tres si son iguales
		 */
		 //RESGUARDO
		 //public static int int comparames(int mes1,int mes2){return 1;}
		 
		 public static int comparames(int mes1,int mes2){
			 int comparacion;
			 								 
			 if(mes1>mes2){
				 comparacion=1;
				 }else if(mes2>mes1){
					 comparacion=2;
					 }else 
						comparacion=3;
			return (comparacion);

		}
//---------------------------------------------------------------------------------------------
						/*comparaanyo
		 * INTERFAZ
		 * Proposito: comprobar si un mes es posterior, anterior o igual que otro
		 * Prototipo: int comparaanyo(int anyo1,int anyo2)
		 * Precondiciones: las meses seran validos
		 * Entradas: seis entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera 1 si las primera fecha es mayor, 2 si la segunda es mayor y tres si son iguales
		 */
		 //RESGUARDO
		 //public static int int comparaanyo(int anyo1,int anyo2){return 1;}
		 
		 public static int comparaanyo(int anyo1,int anyo2){
			 int comparacion;
			 								 
			 if(anyo1>anyo2){
				 comparacion=1;
				 }else if(anyo2>anyo1){
					 comparacion=2;
					 }else 
						comparacion=3;
			return (comparacion);

		}
//---------------------------------------------------------------------------------------------
						/*conv24hampm
		 * INTERFAZ
		 * Proposito: convertir una hora dada en formato 24h en formato AM/PM
		 * Prototipo: int conv24hampm(int hora)
		 * Precondiciones: la hora sera valida
		 * Entradas: un entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera la hora convertida en formato AM/PM
		 */
		 //RESGUARDO
		 //public static int conv24hampm(int hora){return 1;}
		 
		 public static int conv24hampm(int hora){
			 int conversion=0,contador;
			 
			 if(hora==0){
				 conversion=12;
			 }else if(hora<=12){
				 for(contador=0;contador<hora;contador++){
					 conversion++;
					 }
				 }else if(hora>=13){
					 for(contador=12;contador<hora;contador++){
					 conversion++;
					 }
					 }
			return (conversion);
		 }

		
//---------------------------------------------------------------------------------------------
						/*validahora
		 * INTERFAZ
		 * Proposito: comprobar si una hora es correcta
		 * Prototipo: boolean validahora(int hora)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un booleano
		 * E/S: no hay
		 * Postcondiciones: AN un booleano que sera verdadero sin la hora es correcta y falso si no
		 */
		 //RESGUARDO
		 //public static boolean validahora(int hora){return true;}
		 public static boolean validahora(int hora){
			boolean horavalida=false;
			
			if(hora>=0 && hora<24){
				horavalida=true;
				}
			 return (horavalida);
		}
		 		
//---------------------------------------------------------------------------------------------
						/*diastranscurridos
		 * INTERFAZ
		 * Proposito: calcular dias transcurridos entre dos fechas dadas en dia mes año
		 * Prototipo: int diastranscurridos(int dia1,int mes1,int anyo1,int dia2,int mes2,int anyo2)
		 * Precondiciones: las fechas seran correctas
		 * Entradas: seis entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias trancurridos entre las fechas
		 */
		 //RESGUARDO
		 //public static int diastranscurridos(int dia1,int mes1,int anyo1,int dia2,int mes2,int anyo2){return 1;}
		 public static int diastranscurridos(int dia1,int mes1,int anyo1,int dia2,int mes2,int anyo2){
			int dias=0,comparacion,diastotalesfecha1,diastotalesfecha2;
			

			comparacion=comparafechas(dia1,mes1,anyo1,dia2,mes2,anyo2);
			diastotalesfecha1=metodosfechas.diastotales(dia1,mes1,anyo1);
			diastotalesfecha2=metodosfechas.diastotales(dia2,mes2,anyo2);
			
			if(comparacion==3){
				dias=0;
				}else if(comparacion==1){				
					dias=diastotalesfecha1-diastotalesfecha2;
					
					}else if(comparacion==2){
					dias=diastotalesfecha2-diastotalesfecha1;
					}
			
			return (dias);
		}
		 		
//---------------------------------------------------------------------------------------------
						/*diastotales
		 * INTERFAZ
		 * Proposito: calcular dias totales de una fecha
		 * Prototipo: int diastotales(int dia,int mes,int anyo)
		 * Precondiciones: las fechas seran correctas
		 * Entradas: tres enteros
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias totales de la fecha dada
		 */
		 //RESGUARDO
			public static int diastotales(int dia,int mes,int anyo){
				int totaldias;
				
				int daysyear=0;
				int daysmonth=0;
				
				daysyear=diasanyo(anyo);
				daysmonth=diasmes(mes,anyo);
				
				totaldias=daysyear+daysmonth+dia;
				
				return totaldias;
				}



//---------------------------------------------------------------------------------------------
						/*diasanyo
		 * INTERFAZ
		 * Proposito: calcular dias totales de un año
		 * Prototipo: int diasanyo(int anyo)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias totales de un año
		 */
		 //RESGUARDO
			//public static int diasanyo(int anyo){return 1;}
			
			public static int diasanyo(int anyo){
				int dias=0,contador;
				boolean esbisiesto=false;
				
				for(contador=0;contador<=anyo;contador++){
					if(contador>=1582){
						esbisiesto=bisiesto(contador);
					}
					
					if(esbisiesto==true){
						dias=dias+366;
					}else
						dias=dias+365;
				}
				
				if(anyo>=1582){
					esbisiesto=bisiesto(anyo);
				}
				if(anyo==0){
					dias=0;				
				}else if(esbisiesto==true){
					dias=dias-366;
					}else
						dias=dias-365;
						
				return (dias);
			}



//---------------------------------------------------------------------------------------------
						/*diasmes
		 * INTERFAZ
		 * Proposito: calcular dias totales los meses de un año
		 * Prototipo: int diasmes(int mes,int anyo)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias de los meses de un año
		 */
		 //RESGUARDO
			//public static diasmes(int mes,int anyo){return 1;}

			public static int diasmes(int mes,int anyo){
				int dias=0,contador;
				boolean esbisiesto=false;
				
				if(anyo>=1582){
					esbisiesto=bisiesto(anyo);
				}
				for(contador=1;contador<mes;contador++){
					
					switch(contador){
						
						case 1: if(mes==1){
									dias=0;
								}else
									dias=dias+31;
																	
						break;
						
						case 2: if(esbisiesto==true){
									dias=dias+29;
								}else
									dias=dias+28;
						
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:
						case 12:
									dias=dias+31;
						break;
						
						case 4:
						case 6: 
						case 9:
						case 11:
									dias=dias+30;
						break;
						}
					
					}
				
				
				
				/*if(mes==1){
					dias=0;
				}else if(mes==2){
					dias=31;
					}else if(mes==3 && esbisiesto==true){
						dias=31+29;
						}else if(mes==3 && esbisiesto==false){
							dias=31+28;
							}else if(mes==4 && esbisiesto==true){
								dias=31+29+31;
								}else if(mes==4 && esbisiesto==false){
									dias=31+28+31;
									}else if(mes==5 && esbisiesto==true){
										dias=31+29+31+30;
										}else if(mes==5 && esbisiesto==false){
											dias=31+28+31+30;
											}else if(mes==6 && esbisiesto==true){
												dias=31+29+31+30+31;
												}else if(mes==6 && esbisiesto==false){
													dias=31+28+31+30+31;
													}else if(mes==7 && esbisiesto==true){
														dias=31+29+31+30+31+30;
														}else if(mes==7 && esbisiesto==false){
															dias=31+28+31+30+31+30;
															}else if(mes==8 && esbisiesto==true){
																dias=31+29+31+30+31+30+31;
																}else if(mes==8 && esbisiesto==false){
																	dias=31+28+31+30+31+30+31;
																	}else if(mes==9 && esbisiesto==true){
																		dias=31+29+31+30+31+30+31+31;
																		}else if(mes==9 && esbisiesto==false){
																			dias=31+28+31+30+31+30+31+31;
																			}else if(mes==10 && esbisiesto==true){
																				dias=31+29+31+30+31+30+31+31+30;
																				}else if(mes==10 && esbisiesto==false){
																					dias=31+28+31+30+31+30+31+31+30;
																					}else if(mes==11 && esbisiesto==true){
																						dias=31+29+31+30+31+30+31+31+30+31;
																						}else if(mes==11 && esbisiesto==false){
																							dias=31+28+31+30+31+30+31+31+30+31;
																							}else if(mes==12 && esbisiesto==true){
																								dias=31+29+31+30+31+30+31+31+30+31+30;
																								}else if(mes==12 && esbisiesto==false){
																									dias=31+28+31+30+31+30+31+31+30+31+30;
																									}*/
				return (dias);
			}
			
//---------------------------------------------------------------------------------------------





}
