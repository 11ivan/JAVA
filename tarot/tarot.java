//tarot.java
/**
 *Analisis
 * 	Proposito: Realizar un programa que lea una fecha de nacimiento de la forma día, mes, año, y
 * 			   dé como resultado el número de Tarot.
 * 	Comentario: El número de Tarot se haya sumando los números de la fecha de nacimiento y
 * 			    reduciéndolos a un único dígito. Por ejemplo, si su fecha de nacimiento es 20 de julio de 1984, el número de Tarot sería:
				20 + 7+ 1984 = 2011 >> 2 + 0+ 1+1 = 4nºtarot
 *				Meses con 31 dias: 1Enero,3Marzo,5Mayo,7Julio,8Agosto,10Octubre,12Diciembre 
 * 				Meses con 30 dias: Abril,Junio,Septiembre,Noviembre
 * 				Febrero 28 dias o 29 en año bisiesto.
 *  
 * 	Entrada: Numeros.
 * 	Salidas: El número de Tarot.
 * 	Restricciones: La fecha introducida debe ser correcta
 * 
 * Pseudocódigo  Generalizado
 *INICIO
 * 	PREGUNTAR SI EJECUTA
 * 	MIENTRAS EJECUTA SEA SI
 * 		REPETIR MIENTRAS FECHA SEA FALSA
 * 			LEER Y VALIDAR DIA
 * 			LEER Y VALIDAR MES
 * 			LEER Y VALIDAR AÑO
 * 			COMPROBAR BISIESTO
 * 			COMPROBAR FECHA
 * 		FIN REPETIR MIENTRAS
 * 		CALCULAR Nº TAROT
 * 		ESCRIBIR Nº TAROT
 * 		PREGUNTAR SI EJECUTA DE NUEVO
 * 	FIN MIENTRAS
 *FIN
 * 	
*/

import java.util.Scanner;
import java.lang.Character;

public class tarot{
	public static void main(String[] args){
		
		//DECLARAMOS VARIABLES
		Scanner entrada=new Scanner(System.in);
		char ejecuta=' ';
		int dia,mes,year,digito1,digito2,digito3,digito4,numerotarot,resto1,resto2,resto3,signo;
		boolean fecha=false;
		boolean bisiest=true;
		
		
		//PREGUNTAR SI EJECUTA
		do{
			System.out.println("¿Quiere ejecutar?");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			System.out.println("++++++++++++++++++++++++++++++++++++++++");
			}while(ejecuta!='s' && ejecuta!='n');
			
		//MIENTRAS EJECUTA SEA SI
		while(ejecuta=='s'){
			
			//REPETIR MIENTRAS FECHA SEA FALSA
			do{	
		
					//LEER Y VALIDAR DIA
					do{
						System.out.println("Ingrese el dia");
						dia=entrada.nextInt();
						System.out.println("++++++++++++++++++++++++++++++++++++++++");
						}while(dia>31 || dia<1);
						
					//LEER Y VALIDAR MES
					do{
						System.out.println("Ingrese el mes");
						mes=entrada.nextInt();
						System.out.println("++++++++++++++++++++++++++++++++++++++++");
						}while(mes>12 || mes<1);
						
					//LEER Y VALIDAR AÑO
					do{
					System.out.println("Ingrese el año");
					year=entrada.nextInt();
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
					
					resto1=year%4;
					resto2=year%100;
					resto3=year%400;
					
					//COMPROBAR BISIESTO
					if (year<1582){
						bisiest=false;
						}
					else if (resto1==0 && resto2!=0){
							bisiest=true;
							}	
						else if (resto3==0){
								bisiest=true;	
								}
							else{
								bisiest=false;	
								}		
					}while(year>3000 || year<1457);//FIN MIENTRAS	
					
					//COMPROBAR FECHA	
					if(dia>29 && mes==2){
						fecha=false;
						System.out.println("El dia no corresponde al mes");
						}else if(dia==29 && mes==2 && bisiest==false){
							fecha=false;
							System.out.println("Febrero no tiene 29 días en el año introducido");
							}else if(dia>30 && mes==1 || dia>30 && mes==3 || dia>30 && mes==5 || dia>30 && mes==7 || dia>30 && mes==8 || dia>30 && mes==10 || dia>30 && mes==12){
								fecha=false;
								System.out.println("El dia no corresponde al mes");
								}else{
									fecha=true;
									}
				}while(fecha==false);//FIN MIENTRAS		
				
				//CALCULAR Nº TAROT
				numerotarot=dia+mes+year;
				System.out.println(numerotarot);
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
				
				digito1=numerotarot/1000;
				digito2=(numerotarot%1000)/100;
				digito3=((numerotarot%1000)%100)/10;
				digito4=(((numerotarot%1000)%100)%10)/1;
				System.out.println(digito1);
				System.out.println(digito2);
				System.out.println(digito3);
				System.out.println(digito4);
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
				
				numerotarot=digito1+digito2+digito3+digito4;
				System.out.println(numerotarot);
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
				
				
				//ESCRIBIR Nº TAROT
				System.out.println("Su numero del tarot es "+numerotarot);
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
				
				//PREGUNTAR SI EJECUTA DE NUEVO
				do{
					System.out.println("¿Quiere ejecutar de nuevo?");
					ejecuta=Character.toLowerCase(entrada.next().charAt(0));
					System.out.println("++++++++++++++++++++++++++++++++++++++++");
				}while(ejecuta!='s' && ejecuta!='n');

			}//FIN MIENTRAS
	
	}
}
