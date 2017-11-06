//mes.java

/**
 *Análisis
 * 	Proposiciones:Decir que mes es.
 * 	Entrada: Un número.
 * 	Salida: El mes del año.
 * 	Restricciones:Un número de dos cifras máximo, debe ser mayor que 0.
 * Pseudocódigo generalizado
 * 	Leer dato.
 * 	Comprobar dato.
 * 	Escribir resultado.
*/
import java.util.Scanner;

public class mes{
	public static void main(String[] args) {
		//Declaración de variables
		int numero;
		String resultado="";
		
		//LEER DATO
		Scanner entrada1=new Scanner(System.in);
		System.out.println("Introduzca con números el mes del año: ");
		numero=entrada1.nextInt();
		
		//Comprobar dato
		if (numero<=0){
			System.out.println("El número introducido no puede ser negativo o cero");
		}
		else if(numero>12){
				System.out.println("El número no corresponde a un mes");
			}
		else if (numero==1){
				resultado="Enero";
			}
			else if (numero==2){
					resultado="Febrero";
				}
				else if (numero==3){
						resultado="Marzo";
					}
					else if (numero==4){
							resultado="Abril";
						}
						else if (numero==5){
								resultado="Mayo";
							}
							else if (numero==6){
									resultado="Junio";
								}
								else if (numero==7){
										resultado="Julio";
									}
									else if (numero==8){
											resultado="Agosto";
										}
										else if (numero==9){
												resultado="Septiembre";
											}
											else if (numero==10){
													resultado="Octubre";
												}
												else if (numero==11){
														resultado="Noviembre";
													}
														else{
															resultado="Diciembre";
															}
		
		//ESCRIBIR RESULTADO
		if(numero>0 && numero<=12){
		System.out.println("El mes del año es: "+resultado);
		}	
	}
	
}
