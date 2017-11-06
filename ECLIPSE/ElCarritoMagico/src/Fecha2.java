import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

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
	/*private int dia;
	private int mes;
	private int anio;*/
	private String dia;
	private String mes;
	private String anio;

	
	//Constructores	
	public Fecha2(){
		//super();
		dia="01";
		mes="01";
		anio="1900";
	}
	
	/*public Fecha2(int dia, int mes, int anio) throws ExcepcionFecha{	
		
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
	}*/
	
	
	public Fecha2(String dia, String mes, String anio) throws ExcepcionFecha{	
		int diaPars=0, mesPars=0, anioPars=0;
		boolean vale=true;
		
		if(dia.length()>2){
			dia=dia.substring(0, 1);
		}else if(dia.length()<2){
			dia=this.rellenaConBlanco(dia, 2);
		}
		if(mes.length()>2){
			mes=mes.substring(0, 1);
		}else if(mes.length()<2){
			mes=this.rellenaConBlanco(mes, 2);
		}
		if(anio.length()>4){
			anio=anio.substring(0, 3);
		}else if(anio.length()<4){
			anio=this.rellenaConBlanco(anio, 4);
		}

		try{
			diaPars=Integer.parseInt(dia);
			mesPars=Integer.parseInt(mes);
			anioPars=Integer.parseInt(anio);
		}catch(InputMismatchException e){
			System.out.println("Se esperaba un numero");
			vale=false;
		}
		
		if(vale){
			if(diaPars<1){
				throw new ExcepcionFecha("El dia no puede ser menor que 1");
			}else{
					this.dia=dia;
				}
				
			if(mesPars<1 && mesPars>12){
				throw new ExcepcionFecha("El mes debe estar entre 1 y 12");
			}else{
				this.mes=mes;
				}
				
			if(anioPars<0){
				throw new ExcepcionFecha("El a\u00f1o no puede ser negativo");
			}else{
					this.anio=anio;
				}
		}
	}

	
	
	public Fecha2(Fecha2 fecha){
		this.dia=fecha.getDay();
		this.mes=fecha.getMonth();
		this.anio=fecha.getYear();
	}
//---------------------------------------------------------------------------------------------	
	
	//Consultores Propiedades basicas
	public String getDay(){
			return dia;
	}
	
	public String getMonth(){
		return mes;
	}
	
	public String getYear(){
		return anio;
	}
	
	
//---------------------------------------------------------------------------------------------	
	
	//Consultores propiedades derivadas
	
	//Bisiesto
	public boolean getBisiesto(){
		int anioPars=0;
		boolean bisiesto=false;
		
		try{
			anioPars=Integer.parseInt(this.anio);
		}catch(InputMismatchException e){
			System.out.println(e);
		}

		if(anioPars>=1582){
			if(anioPars%400==0 || anioPars%4==0 && anioPars%100!=0){
				bisiesto=true;
			}
		}
		return bisiesto;
	}
//---------------------------------------------------------------------------------------------
	
	//Modificadores
	
	public void setDay(String dia) throws ExcepcionFecha{//Para la excepcion del dia necesito saber el mes y el anio por si es bisiesto
		int diaPars=0;
		boolean valida=true;
		
		try{
			diaPars=Integer.parseInt(dia);
		}catch(InputMismatchException e){
			System.out.println("Se esperan n�meros");
			valida=false;
		}
		
		if(diaPars<1){
			throw new ExcepcionFecha("El dia no puede ser menor que 1");
		}else if(valida){
			if(dia.length()>2){
				this.dia=dia.substring(0, 1);
			}else if(dia.length()<2){
				this.dia=this.rellenaConBlanco(dia, 2);
			}else{
				this.dia=dia;
			}
		}
	}
	
	public void setMonth(String mes)throws ExcepcionFecha{
		int mesPars=0;
		boolean valida=true;
		
		try{
			mesPars=Integer.parseInt(mes);
		}catch(InputMismatchException e){
			System.out.println("Se esperan n�meros");
			valida=false;
		}
		
		if(mesPars<1 || mesPars>12){
			throw new ExcepcionFecha("El mes debe estar entre 1 y 12");
		}else if(valida){
			if(mes.length()>2){
				this.mes=mes.substring(0, 1);
			}else if(mes.length()<2){
				this.mes=this.rellenaConBlanco(mes, 2);
			}else{
				this.mes=mes;
			}
		}
	}
	
	public void setYear(String anio)throws ExcepcionFecha{
		int anioPars=0;
		boolean valida=true;
		
		try{
			anioPars=Integer.parseInt(anio);
		}catch(InputMismatchException e){
			System.out.println("Se esperan n�meros");
			valida=false;
		}
		if(anioPars<0){
			throw new ExcepcionFecha("El a\u00f1o no puede ser negativo");
		}else if(valida){
			if(anio.length()>4){
				this.anio=anio.substring(0, 3);
			}else if(anio.length()<4){
				this.anio=this.rellenaConBlanco(anio, 4);
			}else{
				this.anio=anio;
			}
		}
	}
	
//---------------------------------------------------------------------------------------------
	
	
	//CompareTo
	
	public int compareTo(Fecha2 fecha){
		int comparacion=0,compdia,compmes,companio;
			 
		compdia=comparaDia(Integer.parseInt(fecha.getDay()));
		compmes=comparaMes(Integer.parseInt(fecha.getMonth()));
		companio=comparaAnio(Integer.parseInt(fecha.getYear()));//si comparaanio devuelve es 1 el primer año es anterior al segundo
			 			 			 			 
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
		String cadena=dia+","+mes+","+anio;
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
		int code=anio.hashCode()+dia.hashCode();
		return code;
	}
	
	
//-----------------------------------------------------------------------------------------------
	//rellenaConBlanco
	/* Proposito: Recibe una cadena y un entero, rellenar� la cadena con espacios blancos hasta la posicion indicada
	 * Prototipo: String rellenaConBlanco(String cadena, int pos)
	 * Precondiciones: no hay
	 * Entradas: una cadenas
	 * Salidas: 
	 * Postcondiciones: 
	 * Restricciones: 
	 */
	protected String rellenaConBlanco(String cadena, int pos){
		String cadRellena=cadena;
		do{
			cadRellena="0"+cadRellena;
		}while(cadRellena.length()<pos);
		return cadRellena;
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
			 //Calendar calendario = new GregorianCalendar(); 
			 try{
				 fecha=new Fecha2(this.dia,this.mes,this.anio);
			 }catch(ExcepcionFecha error){
					System.out.println(error);
			 }
				
			 boolean fechavalida=false;
			 boolean esbisiesto=false;			

			esbisiesto=fecha.getBisiesto();				 
			
			if(Integer.parseInt(fecha.getYear())<0){
				fechavalida=false;
			}else{	
				switch(fecha.getMonth()){
					
					case "01":
					case "03":
					case "05":
					case "07":
					case "08":
					case "10":
					case "12":	
								if(Integer.parseInt(fecha.getDay())>=1 && Integer.parseInt(fecha.getDay()) <=31){
									fechavalida=true;
								}
					break;
					
					case "2": if(esbisiesto==false && Integer.parseInt(fecha.getDay())>=1 && Integer.parseInt(fecha.getDay())<=28){
								fechavalida=true;
								}else if(esbisiesto==true && Integer.parseInt(fecha.getDay())>=1 && Integer.parseInt(fecha.getDay())<=29){
									fechavalida=true;
									}
					break;
					
					case "04":
					case "06":
					case "09":
					case "11":
								if(Integer.parseInt(fecha.getDay())>=1 && Integer.parseInt(fecha.getDay())<=30){
									fechavalida=true;
								}
					break;										
					}
				}			
				//if(Calendar.YEAR<Integer.parseInt(fecha.getYear()) || Calendar.MONTH<Integer.parseInt(fecha.getMonth()) && Calendar.YEAR==Integer.parseInt(fecha.getYear()) ||
				//		Calendar.DAY_OF_MONTH<Integer.parseInt(fecha.getDay()) && Calendar.MONTH==Integer.parseInt(fecha.getMonth()) && Calendar.YEAR==Integer.parseInt(fecha.getYear())){
				//	fechavalida=false;
				//}
				
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
			 								 
			 if(Integer.parseInt(this.dia)>dia){
				 comparacion=-1;
				 }else if(Integer.parseInt(this.dia)<dia){
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
			 								 
			 if(Integer.parseInt(this.mes)>mes){
				 comparacion=-1;
				 }else if(Integer.parseInt(this.mes)<mes){
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
			 								 
			 if(Integer.parseInt(this.anio)>anio){
				 comparacion=-1;
				 }else if(Integer.parseInt(this.anio)<anio){
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
				
				totaldias=daysyear+daysmonth+Integer.parseInt(fecha.getDay());
				
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
				
				for(contador=1;contador<=Integer.parseInt(fecha.getYear());contador++){
					try{
						copia.setYear(String.valueOf(contador));
					}catch(ExcepcionFecha error){
							System.out.println(error);
						}
					esbisiesto=copia.getBisiesto();					
					
					if(esbisiesto==true){
						dias=dias+366;
					}else
						dias=dias+365;
				}

				if(Integer.parseInt(fecha.getYear())==0){
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
				
				for(contador=1;contador<Integer.parseInt(fecha.getMonth());contador++){
					
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
			switch(Integer.parseInt(fecha.getMonth())){						
						case 2: if(fecha.getBisiesto()==true && Integer.parseInt(fecha.getDay())==29){								
										this.mes=String.valueOf(Integer.parseInt(this.mes)+1);
										this.dia="1";										
								}else if(Integer.parseInt(fecha.getDay())==28 && fecha.getBisiesto()==false){
									this.mes=String.valueOf(Integer.parseInt(this.mes)+1);
										this.dia="1";
									}else if(Integer.parseInt(fecha.getDay())==28 && fecha.getBisiesto()==true){
											this.dia=String.valueOf(Integer.parseInt(this.dia)+1);
										}else
											this.dia=String.valueOf(Integer.parseInt(this.dia)+1);
						break;
								
						case 1:								
						case 3:
						case 5:
						case 7:
						case 8:
						case 10:							
									if(Integer.parseInt(fecha.getDay())==31){
										this.mes=String.valueOf(Integer.parseInt(this.mes)+1);
										this.dia="1";	
									}else 
										this.dia=String.valueOf(Integer.parseInt(this.dia)+1);
						break;
						
						case 12:	if(Integer.parseInt(fecha.getDay())==31){
										this.anio=String.valueOf(Integer.parseInt(this.anio)+1);
										this.mes="1";
										this.dia="1";
									}else
										this.dia=String.valueOf(Integer.parseInt(this.dia)+1);
						break;
						
						case 4:
						case 6: 
						case 9:
						case 11:
									if(Integer.parseInt(fecha.getDay())==30){
										this.mes=String.valueOf(Integer.parseInt(this.mes)+1);
										this.dia="1";
									}else 
										this.dia=String.valueOf(Integer.parseInt(this.dia)+1);
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
			switch(Integer.parseInt(fecha.getMonth())){						
						case 3: if(fecha.getBisiesto()==true && Integer.parseInt(fecha.getDay())==1){
							this.mes=String.valueOf(Integer.parseInt(this.mes)-1);
									this.dia="29";
								}else if(Integer.parseInt(fecha.getDay())==1 && fecha.getBisiesto()==false){
									this.mes=String.valueOf(Integer.parseInt(this.mes)-1);
										this.dia="28";										
									}else
										this.dia=String.valueOf(Integer.parseInt(this.dia)-1);
						break;
								
						case 1:	
								if(Integer.parseInt(fecha.getDay())==1){
									this.anio=String.valueOf(Integer.parseInt(this.anio)-1);
									this.mes="12";
									this.dia="31";
								}else
									this.dia=String.valueOf(Integer.parseInt(this.dia)-1);
						break;
													
						case 2:						
						case 4:
						case 6:
						case 8:
						case 9:
						case 11:
								if(Integer.parseInt(fecha.getDay())==1){
									this.mes=String.valueOf(Integer.parseInt(this.mes)-1);
									this.dia="31";
								}else
									this.dia=String.valueOf(Integer.parseInt(this.dia)-1);
						break;
						
						case 5:																		 
						case 7:												
						case 10:																											
						case 12:						
								if(Integer.parseInt(fecha.getDay())==1){
									this.mes=String.valueOf(Integer.parseInt(this.mes)-1);
									this.dia="30";
								}else
									this.dia=String.valueOf(Integer.parseInt(this.dia)-1);
						break;						
				}	
		}
	
	
	
	


}
