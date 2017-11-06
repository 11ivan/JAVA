/*
 * Analisis
 * 	Proposito: Realizar una factura para un restaurante
 * 
 * 	Entradas: introducir:char. ejecuta:char. 
 *  Concepto es el código del plato, cadena
 *  Cantidad el número de raciones de este, cadena
 *  Importe el precio por unidad por el número de raciones. cadena
 *  
 * 	Salidas: No hay. Se imprimira en pantalla el importe de la factura
 * 
 * 	Restricciones: Cantidad se controlara que sea entero positivo y el precio decimal positivo. ejecuta e introducir solo pueden ser 's' o 'n'
 * 
 *  Pseudocodigo generalizado
 *  INICIO
 *  	LEER Y VALIDAR SI EJECUTA
 *  	MIENTRAS EJECUTA SEA S
 *  		REPETIR	
 *  			LEER Y VALIDAR PLATOS DIFERENTES A INTRODUCIR
 * 				LEER CONCEPTO
 * 				LEER NOMBRE DEL PLATO
 * 				LEER Y VALIDAR CANTIDAD*
 * 				LEER Y VALIDAR PRECIO*
 * 				OBTENER IMPORTE*
 * 				LEER Y VALIDAR SI INTRODUCE MAS PLATOS
 * 			MIENTRAS INTRODUCIR SEA S
 * 			VOLVER A LEER Y VALIDAR SI EJECUTA
 * 		PINTAR FACTURA**
 * 		FIN MIENTRAS			
 * 	FIN
 * */

import java.util.Scanner;
//import java.util.ArrayList;
//import java.util.List;

public class FacturaRestaurante {
	public static void main(String[] args){
		
		//ArrayList<String> arrayListStrings = new ArrayList<String>()
		//ArrayList<String> arrayListStrings = new ArrayList<String>(42)
		//List<List<Point>> pointsList = new ArrayList<List<Point>>();
		
		//Variables
		Scanner entrada=new Scanner (System.in);
		char ejecuta=' ';
		char introducir=' ';
		int cantidad;
		boolean valido=false;
		//int i=0;
		int j=1;
		String[][] factura;
		
		
		
		
		//LEER Y VALIDAR SI EJECUTA
		do{
			System.out.println("Realizar Factura? S/N");
			ejecuta=Character.toLowerCase(entrada.next().charAt(0));
		}while(ejecuta!='s' && ejecuta!='n');
		
		//MIENTRAS EJECUTA SEA S
		while(ejecuta=='s'){
			
			//LEER Y VALIDAR PLATOS DIFERENTES A INTRODUCIR
			do{
				System.out.println("¿Cuátos platos diferentes va a introducir?");
				cantidad=entrada.nextInt();
				valido=MetodosFacturaRestaurante.validaCantidad(cantidad);
			}while(valido==false);
			
			factura=new String[5][cantidad+1];
			factura[0][0]="Concepto";
			factura[1][0]="Nombre";
			factura[2][0]="Cantidad";
			factura[3][0]="Precio";
			factura[4][0]="Importe";

			
			do{
												
		  		//LEER CONCEPTO
				System.out.println("Introduzca el concepto del plato "+j);
				factura[0][j]=entrada.next();
				
				//LEER NOMBRE DEL PLATO
				System.out.println("Introduzca el nombre del plato "+j);
				factura[1][j]=entrada.next();
				
		  		//LEER Y VALIDAR CANTIDAD*
				do{
					System.out.println("Introduzca la cantidad del plato "+j);
					factura[2][j]=entrada.next();
					valido=MetodosFacturaRestaurante.validaCantidad(factura[2][j]);
				}while(valido==false);
				
		  		//LEER Y VALIDAR PRECIO*
				do{
					System.out.println("Introduzca el precio del plato "+j);
					factura[3][j]=entrada.next();
					valido=MetodosFacturaRestaurante.validaPrecio(factura[3][j]);
				}while(valido==false);				
				
				//OBTENER IMPORTE*
				factura[4][j]=MetodosFacturaRestaurante.obtenerImporte(factura[2][j], factura[3][j]);
				
		  		//LEER Y VALIDAR SI INTRODUCE MAS PLATOS
				/*do{
					System.out.println("Va a introducir mas platos? S/N");
					introducir=Character.toLowerCase(entrada.next().charAt(0));
				}while(introducir!='s' && introducir!='n');*/
				j++;
			}while(j<=cantidad);//FIN MIENTRAS INTRODUCIR SEA S
				
			//PINTAR FACTURA*
			MetodosFacturaRestaurante.pintaFactura(factura);
			
		  	//VOLVER A LEER Y VALIDAR SI EJECUTA
			do{
				System.out.println("Realizar otra Factura? S/N");
				ejecuta=Character.toLowerCase(entrada.next().charAt(0));
			}while(ejecuta!='s' && ejecuta!='n');
				
		}//FIN MIENTRAS	
		
		  	
				
	}
}
