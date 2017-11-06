//Fecha.java

/**
	Propiedades:
		- Dia: Basica,Entero,consultable,modificable
		- Mes: Basica,Entero,consultable,modificable
		- Año: Basica,Entero,consultable,modificable
		- Orden natural: Por el año, el mes y el dia
		- Criterio de igualdad: Si el año el mes y el dia son iguales
		- Representacion como cadena
		
	Propiedades derivadas:
		- Bisiesto: Booleano,consultable, no modificable

	Restricciones:
	- Los dias deben estar entre 1 y 31
	- Los meses deben estar entre 1 y 12
	- Los años no pueden ser negativos
	- Se controlara el que el mes de Febrero no tenga 29 dias si el año no es bisiesto
	
	Interfaz:
		int getDay()
		void setDay(int dia)
		int getMonth()
		void setMonth(int mes)
		int getYear()
		void setYear(int anio)
		boolean getBisiesto()
	
	Funcionalidades
		
 */
 

public class Fecha implements Comparable<Fecha>, Cloneable{
	
	private int dia;
	private int mes;
	private int anio;
	private boolean bisiesto;	
	
	//Constructores	
	public Fecha(){
		dia=1;
		mes=1;
		anio=1;
	}
	
	public Fecha(int dia, int mes, int anio) throws ExcepcionFecha{
		//boolean fechavalida=validafecha2(dia,mes,anio);
		
		if(dia<1){
			throw new ExcepcionFecha("El dia no puede ser menor que 1");
		}else{
				this.dia=dia;
			}
			
		if(mes<1 && mes>12){
			throw new ExcepcionFecha("El mes debe estar entre 1 y 12");
		}else{
			this.mes=mes;
			}
			
		if(anio<0){
			throw new ExcepcionFecha("El año no puede ser negativo");
		}else{
				this.anio=anio;
			}
	}
	
	public Fecha(Fecha fecha){
		this.dia=fecha.getDay();
		this.mes=fecha.getMonth();
		this.anio=fecha.getYear();
	}
//---------------------------------------------------------------------------------------------
	
	
	//Consultores Propiedades basicas
	public int getDay(){
			return dia;
	}
	
	public int getMonth(){
		return mes;
	}
	
	public int getYear(){
		return anio;
	}
//---------------------------------------------------------------------------------------------
	
	
	//Consultores propiedades derivadas
	//Bisiesto
	public boolean getBisiesto(){
		bisiesto=false;
		
		if(this.anio>=1582){
			if(anio%400==0 || anio%4==0 && anio%100!=0){
				bisiesto=true;
			}
		}
		return bisiesto;
	}
//---------------------------------------------------------------------------------------------
	
	//Modificadores
	
	public void setDay(int dia) throws ExcepcionFecha{//Para la excepcion del dia necesito saber el mes y el anio por si es bisiesto
			//boolean fechavalida=validafecha2(dia,this.mes,this.anio);
		if(dia<1){
			throw new ExcepcionFecha("El dia no puede ser menor que 1");
		}else
		this.dia=dia;
	}
	
	public void setMonth(int mes)throws ExcepcionFecha{
		//boolean fechavalida=validafecha2(this.dia,mes,this.anio);
		if(mes<1 && mes>12){
			throw new ExcepcionFecha("El mes debe estar entre 1 y 12");
		}
		this.mes=mes;
	}
	
	public void setYear(int anio)throws ExcepcionFecha{
		if(anio<0){
			throw new ExcepcionFecha("El año no puede ser negativo");
		}
		this.anio=anio;
	}
//---------------------------------------------------------------------------------------------
	
	
	//CompareTo
	
	/*public int compareTo(Fecha fecha){//si el que llega es anterior se devuelve -1
		int comparacion=0,compdia,compmes,companyo;;
		
		if(this.anio>fecha.getYear() || this.anio==fecha.getYear() && this.mes>fecha.getMonth() || this.anio==fecha.getYear() && this.mes==fecha.getMonth && this.dia>fecha.getDay()){
			comparacion=-1;
		}else if(this.anio<fecha.getYear() || this.anio==fecha.getYear() && this.mes<fecha.getMonth() || this.anio==fecha.getYear() && this.mes==fecha.getMonth && this.dia<fecha.getDay())
	}*/
	
	public int compareTo(Fecha fecha){
		int comparacion=0,compdia,compmes,companyo;
			 
		compdia=comparaDia(this.dia,fecha.getDay());
		compmes=comparaMes(this.mes,fecha.getMonth());
		companyo=comparaAnio(this.anio,fecha.getYear());//si comparaanio devuelve es 1 el primer año es anterior al segundo
			 			 			 			 
		if(companyo==-1 || companyo==0 && compmes==-1 || companyo==0 && compmes==0 && compdia==-1){		 				 
			comparacion=-1;		//la fecha que llega es anterior		 
		}else if(companyo==1 || companyo==0 && compmes==1 || companyo==0 && compmes==0 && compdia==1){		
			comparacion=1;		//la fecha que llega es posterior		
			}		
		return comparacion;
	}
//---------------------------------------------------------------------------------------------

	
	//equals
	@Override
	public boolean equals(Object objeto){
		boolean iguales=false;
		
		if(objeto!=null && objeto instanceof Fecha){
			Fecha fecha=(Fecha) objeto;
			
			if(this.anio==fecha.getYear() && this.mes==fecha.getMonth() && this.dia==fecha.getDay()){
				iguales=true;				
			}			
		}
		return iguales;
	}
//---------------------------------------------------------------------------------------------
	
	//toString
	@Override
	public String toString(){
		String cadena="( "+dia+"/"+mes+"/"+anio+" )";
		return cadena;
	}
//---------------------------------------------------------------------------------------------
	
	//clone
	@Override
	public Fecha clone(){
		Fecha copiafecha=null;
		try{
			copiafecha=(Fecha) super.clone();
			}catch(CloneNotSupportedException error){
					System.out.println("Objeto no clonado");
				}
		return copiafecha;
	}
//---------------------------------------------------------------------------------------------
	
	//hashcode
	@Override
	public int hashCode(){
		int code=((dia+mes)+(anio-dia))*mes;
		return code;
	}
//---------------------------------------------------------------------------------------------
	
	//muestraFecha
	public void muestraFecha(){
		System.out.println("( "+dia+"/"+mes+"/"+anio+" )");
	}
//---------------------------------------------------------------------------------------------


				/*validafecha
		 * INTERFAZ
		 * Proposito: comprobar una fecha dada en dia mes año
		 * Prototipo: boolean validafecha(Fecha fecha)
		 * Precondiciones: no hay
		 * Entradas: una Fecha
		 * Salidas: un booleano
		 * E/S: no hay
		 * Postcondiciones: AN un booleano que sera verdadero si la fecha es correcta
		 * Restricciones: 
		 */
		 //RESGUARDO
		 //public static boolean validafecha(Fecha fecha){return(true);}
		 public static boolean validafecha(Fecha fecha){
			 boolean fechavalida=false;
			 boolean esbisiesto=false;			

			esbisiesto=fecha.getBisiesto();				 
			
			if(fecha.getYear()<0){
				fechavalida=false;
			}else{	
				switch(fecha.getMonth()){
					
					case 1:
					case 3:
					case 5:
					case 7:
					case 8:
					case 10:
					case 12:	
								if(fecha.getDay()>=1 && fecha.getDay() <=31){
								fechavalida=true;
								}
					break;
					
					case 2: if(esbisiesto==false && fecha.getDay()>=1 && fecha.getDay()<=28){
								fechavalida=true;
								}else if(esbisiesto==true && fecha.getDay()>=1 && fecha.getDay()<=29){
									fechavalida=true;
									}
					break;
					
					case 4:
					case 6:
					case 9:
					case 11:
								if(fecha.getDay()>=1 && fecha.getDay()<=30){
								fechavalida=true;
								}
					break;										
					}
				}				 
			return fechavalida;
		}
		 

//---------------------------------------------------------------------------------------------
						/*comparaDia
		 * INTERFAZ
		 * Proposito: comprobar si un dia es posterior, anterior o igual que otro
		 * Prototipo: int comparaDia(int dia1,int dia2)
		 * Precondiciones: los dias seran validos
		 * Entradas: dos enteros
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera -1 si el dia que llega es anterior, 1 si el que llega es posterior y 0 si son iguales
		 * Restricciones: Los dias deben estar entre 1 y 31
		 */
		 //RESGUARDO
		 //public static int comparaDia(int dia1,int dia2){return 1;}
		 
		 
		 
		 
		 public int comparaDia(int dia1, int dia2){
			 int comparacion=0;
			 								 
			 if(dia1>dia2){
				 comparacion=-1;
				 }else if(dia1<dia2){
					 comparacion=1;
					 }
			return comparacion;

		}
//---------------------------------------------------------------------------------------------
						/*comparaMes
		 * INTERFAZ
		 * Proposito: comprobar si un mes es posterior, anterior o igual que otro
		 * Prototipo: int comparaMes(int mes1,int mes2)
		 * Precondiciones: los meses seran validos
		 * Entradas: dos enteros
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera -1 si el mes que llega es anterior, 1 si el que llega es posterior y 0 si son iguales
		 */
		 //RESGUARDO
		 //public static int comparaMes(int mes1,int mes2){return 1;}
		 
		 public int comparaMes(int mes1, int mes2){
			 int comparacion=0;
			 								 
			 if(mes1>mes2){
				 comparacion=-1;
				 }else if(mes1<mes2){
					 comparacion=1;
					}
			return comparacion;

		}
//---------------------------------------------------------------------------------------------
						/*comparaAnio
		 * INTERFAZ
		 * Proposito: comprobar si un mes es posterior, anterior o igual que otro
		 * Prototipo: int comparaanyo(int anyo1,int anyo2)
		 * Precondiciones: los años seran validos
		 * Entradas: dos enteros
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera -1 si el año que llega es anterior, 1 si el que llega es posterior y 0 si son iguales
		 */
		 //RESGUARDO
		 //public static int comparaanio(int anio1,int anio2){return 1;}
		 
		 public int comparaAnio(int anio1, int anio2){
			 int comparacion=0;
			 								 
			 if(anio1>anio2){
				 comparacion=-1;
				 }else if(anio1<anio2){
					 comparacion=1;
					}
			return comparacion;

		}
	
//---------------------------------------------------------------------------------------------
						/*diastranscurridos
		 * INTERFAZ
		 * Proposito: calcular dias transcurridos entre dos fechas dadas en dia mes año
		 * Prototipo: int diastranscurridos(Fecha fecha1, Fecha fecha2)
		 * Precondiciones: las fechas seran correctas
		 * Entradas: seis entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias trancurridos entre las fechas
		 */
		 //RESGUARDO
		 //public static int diastranscurridos(Fecha fecha1, Fecha fecha2){return 1;}
		 public static int diastranscurridos(Fecha fecha1, Fecha fecha2){
			int dias=0,comparacion,diastotalesfecha1,diastotalesfecha2;
			

			comparacion=fecha1.compareTo(fecha2);
			diastotalesfecha1=diasTotales(fecha1);
			diastotalesfecha2=diasTotales(fecha2);
			
			if(comparacion==0){
				dias=0;
				}else if(comparacion==-1){				
					dias=diastotalesfecha1-diastotalesfecha2;
					
					}else if(comparacion==1){
					dias=diastotalesfecha2-diastotalesfecha1;
					}
			
			return dias;
		}
		 		
//---------------------------------------------------------------------------------------------
						/*diastotales
		 * INTERFAZ
		 * Proposito: calcular transcurridos hasta una fecha
		 * Prototipo: int diastotales(Fecha fecha)
		 * Precondiciones: las fechas seran correctas
		 * Entradas: tres enteros
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias totales de la fecha dada
		 */
		 //RESGUARDO//public static int diastotales(Fecha fecha){	return 1;	}
			public static int diasTotales(Fecha fecha){
				int totaldias;				
				int daysyear=0;
				int daysmonth=0;
				
				daysyear=diasAnios(fecha);
				daysmonth=diasMeses(fecha);
				
				totaldias=daysyear+daysmonth+fecha.getDay();
				
				return totaldias;
				}



//---------------------------------------------------------------------------------------------
						/*diasanios
		 * INTERFAZ
		 * Proposito: calcular dias transcurridos hasta un año
		 * Prototipo: Fecha diasanios(Fecha fecha)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias totales de un año
		 */
		 //RESGUARDO
			//public static int diasanios(Fecha fecha){return 1;}
			
			public static int diasAnios(Fecha fecha){
				int dias=0,contador;
				boolean esbisiesto=false;
				Fecha copia=new Fecha(fecha);
				
				for(contador=1;contador<=fecha.getYear();contador++){
					try{
						copia.setYear(contador);
					}catch(ExcepcionFecha error){
							System.out.println(error);
						}
					esbisiesto=copia.getBisiesto();					
					
					if(esbisiesto==true){
						dias=dias+366;
					}else
						dias=dias+365;
				}

				if(fecha.getYear()==0){
					dias=0;				
				}else if(fecha.getBisiesto()==true){
					dias=dias-366;
					}else
						dias=dias-365;
						
				return dias;
			}



//---------------------------------------------------------------------------------------------
						/*diasmeses
		 * INTERFAZ
		 * Proposito: calcular transcurridos hasta un mes
		 * Prototipo: int diasmeses(Fecha fecha)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias de los meses de un año
		 */
		 //RESGUARDO
			//public static int diasmeses(Fecha fecha){return 1;}

			public static int diasMeses(Fecha fecha){
				int dias=0,contador;
				
				for(contador=1;contador<fecha.getMonth();contador++){
					
					switch(contador){
						
						case 1:
								dias=0;
																	
						break;
						
						case 2: if(fecha.getBisiesto()==true){
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
				
				return dias;
			}
	

//---------------------------------------------------------------------------------------------
			/*incrementDay
		 * Interfaz
		 * 	Proposito: Incrementa una fecha dada en un dia
		 * 	Prototipo: Fecha incrementDay(Fecha fecha)
		 * 	Precondiciones:	no hay
		 * 	Entradas: una fecha de tipo Fecha
		 * 	Salidas: no hay, solo se incrementa en uno el dia
		 * 	Postcondiciones: La fecha dada se incrementa en uno
		 *  Restricciones: no hay //El valor no podra ser cero o menor, ni mayor que el numero de dias correspondientes al mes
		 */ 
		  //Resguardo
		  //public Fecha incrementDay(Fecha fecha){Fecha fecha=new Fecha(); return fecha);}
	
		public static Fecha incrementDay(Fecha fecha){
			Fecha fechaincrementada=new Fecha(fecha);
			switch(fecha.getMonth()){						
						case 2: if(fecha.getBisiesto()==true && fecha.getDay()==29){
									try{
										fechaincrementada.setMonth(fecha.getMonth()+1);
										fechaincrementada.setDay(1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
											}
								}else if(fecha.getDay()==28 && fecha.getBisiesto()==false){
									try{
										fechaincrementada.setMonth(fecha.getMonth()+1);
										fechaincrementada.setDay(1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
									}

									}else if(fecha.getDay()==28 && fecha.getBisiesto()==true){
										try{
											fechaincrementada.setDay(fecha.getDay()+1);
											}catch(ExcepcionFecha error){
												System.out.println(error);
										}

										}else
											try{
												fechaincrementada.setDay(fecha.getDay()+1);
												}catch(ExcepcionFecha error){
													System.out.println(error);
											}

						break;
								
						case 1:								
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:							
									if(fecha.getDay()==31){
										try{
										fechaincrementada.setMonth(fecha.getMonth()+1);
										fechaincrementada.setDay(1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
											}
									}else 
										try{
										fechaincrementada.setDay(fecha.getDay()+1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

						break;
						
						case 12:	if(fecha.getDay()==31){
										try{
										fechaincrementada.setYear(fecha.getYear()+1);
										fechaincrementada.setMonth(1);
										fechaincrementada.setDay(1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

									}else
										try{
											fechaincrementada.setDay(fecha.getDay()+1);
											}catch(ExcepcionFecha error){
												System.out.println(error);
											}

						break;
						
						case 4:
						case 6: 
						case 9:
						case 11:
									if(fecha.getDay()==30){
										try{
										fechaincrementada.setMonth(fecha.getMonth()+1);
										fechaincrementada.setDay(1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

									}else 
										try{
										fechaincrementada.setDay(fecha.getDay()+1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

						break;
			
				
				}
				
			return fechaincrementada;	
			
		}

//---------------------------------------------------------------------------------------------
			/*decrementDay
		 * Interfaz
		 * 	Proposito: Decrementa una fecha dada en un dia
		 * 	Prototipo: Fecha decrementDay(Fecha fecha)
		 * 	Precondiciones:	no hay
		 * 	Entradas: una fecha de tipo Fecha
		 * 	Salidas: no hay, solo se incrementa en uno el dia
		 * 	Postcondiciones: La fecha dada se incrementa en uno
		 *  Restricciones: no hay //El valor no podra ser cero o menor, ni mayor que el numero de dias correspondientes al mes
		 */ 
		  //Resguardo
		  //public Fecha decrementDay(Fecha fecha){System.out.println("La fecha se a incrementado en un dia");}
	
		public static Fecha decrementDay(Fecha fecha){
			Fecha fechadecrement=new Fecha(fecha);
			switch(fecha.getMonth()){						
						case 3: if(fecha.getBisiesto()==true && fecha.getDay()==1){
									try{
									fechadecrement.setMonth(fecha.getMonth()-1);
									fechadecrement.setDay(29);
									}catch(ExcepcionFecha error){
										System.out.println(error);
									}
								}else if(fecha.getDay()==1 && fecha.getBisiesto()==false){
										try{
										fechadecrement.setMonth(fecha.getMonth()-1);
										fechadecrement.setDay(28);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

									}else
										try{
											fechadecrement.setDay(fecha.getDay()-1);
											}catch(ExcepcionFecha error){
												System.out.println(error);
											}

						break;
								
						case 1:	
								if(fecha.getDay()==1){
									try{
									fechadecrement.setYear(fecha.getYear()-1);
									fechadecrement.setMonth(12);
									fechadecrement.setDay(31);
									}catch(ExcepcionFecha error){
										System.out.println(error);
									}

								}else
									try{
										fechadecrement.setDay(fecha.getDay()-1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

						break;
													
						case 2:						
						case 4:
						case 6:
						case 8:
						case 9:
						case 11:
								if(fecha.getDay()==1){
									try{
									fechadecrement.setMonth(fecha.getMonth()-1);
									fechadecrement.setDay(31);
									}catch(ExcepcionFecha error){
										System.out.println(error);
									}

								}else
									try{
										fechadecrement.setDay(fecha.getDay()-1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

						break;
						
						case 5:																		 
						case 7:												
						case 10:																											
						case 12:						
								if(fecha.getDay()==1){
									try{
									fechadecrement.setMonth(fecha.getMonth()-1);
									fechadecrement.setDay(30);
									}catch(ExcepcionFecha error){
										System.out.println(error);
									}

								}else
									try{
										fechadecrement.setDay(fecha.getDay()-1);
										}catch(ExcepcionFecha error){
											System.out.println(error);
										}

						break;						
				}
				
			return fechadecrement;	
			
		}
	
	
	
	


}
