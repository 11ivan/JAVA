import java.io.Serializable;

//Fecha2.java

/**
	Propiedades:
		- Dia: Basica,Entero,consultable,modificable
		- Mes: Basica,Entero,consultable,modificable
		- Año: Basica,Entero,consultable,modificable
		- Año actual: Basica,Entero constante, consultable
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
		void setDate()
		boolean getBisiesto()
		
	Funcionalidades
		
 */
 

public class Fecha2 implements Comparable<Fecha2>, Cloneable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private final int YEAR=2017; ESTO NO
	private int dia;
	private int mes;
	private int anio;
	//private boolean bisiesto;	 AQUI SOLO PROPIEDADES BASICAS
	
	//Constructores	
	public Fecha2(){
		//super();
		dia=1;
		mes=1;
		anio=1;
	}
	
	public Fecha2(int dia, int mes, int anio) throws ExcepcionFecha{	
		
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
			throw new ExcepcionFecha("El a\u00f1o no puede ser negativo");
		}else{
				this.anio=anio;
			}
	}
	
	public Fecha2(Fecha2 fecha){
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
		boolean bisiesto=false;
		
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
		this.dia=dia;
		boolean valida=validafecha();
		if(valida==false){
			throw new ExcepcionFecha("la fecha no seria valida");
		}		
	}
	
	public void setMonth(int mes)throws ExcepcionFecha{
		//boolean fechavalida=validafecha2();
		if(mes<1 || mes>12){
			throw new ExcepcionFecha("El mes debe estar entre 1 y 12");
		}
		this.mes=mes;
	}
	
	public void setYear(int anio)throws ExcepcionFecha{
		if(anio<0){
			throw new ExcepcionFecha("El a\u00f1o no puede ser negativo");
		}
		this.anio=anio;
	}
//---------------------------------------------------------------------------------------------
	
	
	//CompareTo
	
	public int compareTo(Fecha2 fecha){
		int comparacion=0,compdia,compmes,companio;
			 
		compdia=comparaDia(fecha.getDay());
		compmes=comparaMes(fecha.getMonth());
		companio=comparaAnio(fecha.getYear());//si comparaanio devuelve es 1 el primer año es anterior al segundo
			 			 			 			 
		if(companio==-1 || companio==0 && compmes==-1 || companio==0 && compmes==0 && compdia==-1){		 				 
			comparacion=-1;		//la fecha que llega es anterior		 
		}else if(companio==1 || companio==0 && compmes==1 || companio==0 && compmes==0 && compdia==1){		
			comparacion=1;		//la fecha que llega es posterior		
			}		
		return comparacion;
	}
	
//---------------------------------------------------------------------------------------------

	
	//equals
	@Override
	public boolean equals(Object objeto){
		boolean iguales=false;
		
		if(objeto!=null && objeto instanceof Fecha2){
			Fecha2 fecha=(Fecha2) objeto;
			
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
		String cadena=dia+"/"+mes+"/"+anio;
		return cadena;
	}
	
//---------------------------------------------------------------------------------------------
	
	//clone
	@Override
	public Fecha2 clone(){
		Fecha2 copiafecha=null;
		try{
			copiafecha=(Fecha2) super.clone();
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
		 * Prototipo: boolean validafecha()
		 * Precondiciones: no hay
		 * Entradas: no hay
		 * Salidas: un booleano
		 * E/S: no hay
		 * Postcondiciones: AN un booleano que sera verdadero si la fecha es correcta
		 * Restricciones: 
		 */
		 //RESGUARDO
		 //public static boolean validafecha(){return(true);}
		 public boolean validafecha(){
			 Fecha2 fecha=null;
			 try{
				 fecha=new Fecha2(this.dia,this.mes,this.anio);
			}catch(ExcepcionFecha error){
					System.out.println(error);
				}
				
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
		 
		 
		 
		 
		 public int comparaDia(int dia){
			 int comparacion=0;
			 								 
			 if(this.dia>dia){
				 comparacion=-1;
				 }else if(this.dia<dia){
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
		 
		 public int comparaMes(int mes){
			 int comparacion=0;
			 								 
			 if(this.mes>mes){
				 comparacion=-1;
				 }else if(this.mes<mes){
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
		 //public static int comparaanio(int anyo1,int anyo2){return 1;}
		 
		 public int comparaAnio(int anio){
			 int comparacion=0;
			 								 
			 if(this.anio>anio){
				 comparacion=-1;
				 }else if(this.anio<anio){
					 comparacion=1;
					}
			return comparacion;

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
		 public int diastranscurridos(Fecha2 fecha2){
			int dias=0,comparacion,diastotalesfecha1,diastotalesfecha2;
			Fecha2 fecha=null;
			try{
			fecha=new Fecha2(this.dia,this.mes,this.anio);
			}catch(ExcepcionFecha error){
				System.out.println(error);
				}
			comparacion=fecha.compareTo(fecha2);
			diastotalesfecha1=diasTotales(fecha);
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
		 * Prototipo: int diasTotales(Fecha2 fecha)
		 * Precondiciones: las fechas seran correctas
		 * Entradas: tres enteros
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias totales de la fecha dada
		 */
		 //RESGUARDO//public static int diasTotales(Fecha2 fecha){	return 1;	}
			public static int diasTotales(Fecha2 fecha){
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
		 * Prototipo: Fecha2 diasAnios(Fecha2 fecha)
		 * Precondiciones: no hay
		 * Entradas: un entero
		 * Salidas: un entero
		 * E/S: no hay
		 * Postcondiciones: AN un entero que sera el numero de dias totales de un año
		 */
		 //RESGUARDO
			//public static int diasanios(Fecha2 fecha){return 1;}
			
			public static int diasAnios(Fecha2 fecha){
				int dias=0,contador;
				boolean esbisiesto=false;
				Fecha2 copia=new Fecha2(fecha);
				
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

			public static int diasMeses(Fecha2 fecha){
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
		  //public void incrementDay(Fecha fecha){System.out.println("La fecha se a incrementado en un dia");}
	
		public void incrementDay(){
			Fecha2 fecha=null;
			try{
			fecha=new Fecha2(this.dia,this.mes,this.anio);
			}catch(ExcepcionFecha error){
				System.out.println(error);
				}
			switch(fecha.getMonth()){						
						case 2: if(fecha.getBisiesto()==true && fecha.getDay()==29){								
										this.mes=this.mes+1;
										this.dia=1;										
								}else if(fecha.getDay()==28 && fecha.getBisiesto()==false){
										this.mes=this.mes+1;
										this.dia=1;
									}else if(fecha.getDay()==28 && fecha.getBisiesto()==true){
											this.dia=this.dia+1;
										}else
												this.dia=this.dia+1;
						break;
								
						case 1:								
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:							
									if(fecha.getDay()==31){
										this.mes=this.mes+1;
										this.dia=1;	
									}else 
										this.dia=this.dia+1;	
						break;
						
						case 12:	if(fecha.getDay()==31){
										this.anio=this.anio+1;
										this.mes=1;
										this.dia=1;
									}else
											this.dia=this.dia+1;
						break;
						
						case 4:
						case 6: 
						case 9:
						case 11:
									if(fecha.getDay()==30){
										this.mes=this.mes+1;
										this.dia=1;
									}else 
										this.dia=this.dia+1;
						break;
			
				
				}			
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
	
		public void decrementDay(){
			Fecha2 fecha=null;
			try{
			fecha=new Fecha2(this.dia,this.mes,this.anio);
			}catch(ExcepcionFecha error){
				System.out.println(error);
				}
			switch(fecha.getMonth()){						
						case 3: if(fecha.getBisiesto()==true && fecha.getDay()==1){
									this.mes=this.mes-1;
									this.dia=29;
								}else if(fecha.getDay()==1 && fecha.getBisiesto()==false){
										this.mes=this.mes-1;
										this.dia=28;										
									}else
											this.dia=this.dia-1;
						break;
								
						case 1:	
								if(fecha.getDay()==1){
									this.anio=this.anio-1;
									this.mes=12;
									this.dia=31;
								}else
										this.dia=this.dia-1;
						break;
													
						case 2:						
						case 4:
						case 6:
						case 8:
						case 9:
						case 11:
								if(fecha.getDay()==1){
									this.mes=this.mes-1;
									this.dia=31;
								}else
										this.dia=this.dia-1;
						break;
						
						case 5:																		 
						case 7:												
						case 10:																											
						case 12:						
								if(fecha.getDay()==1){
									this.mes=this.mes-1;
									this.dia=30;
								}else
										this.dia=this.dia-1;
						break;						
				}	
		}
	
	
	
	


}
