//mes.java

/**
 *An�lisis
 * 	Proposiciones:Decir que mes es.
 * 	Entrada: Un n�mero.
 * 	Salida: El mes del a�o.
 * 	Restricciones:Un n�mero de dos cifras m�ximo, debe ser mayor que 0.
 * Pseudoc�digo generalizado
 * 	Leer dato.
 * 	Comprobar dato.
 * 	Escribir resultado.
*/
import java.util.Scanner;

public class mes{
	public static void main(String[] args) {
		//Declaraci�n de variables
		int numero;
		String resultado="";
		
		//LEER DATO
		Scanner entrada1=new Scanner(System.in);
		System.out.println("Introduzca con n�meros el mes del a�o: ");
		numero=entrada1.nextInt();
		
		//Comprobar dato
		if (numero<=0){
			System.out.println("El n�mero introducido no puede ser negativo o cero");
		}
		else if(numero>12){
				System.out.println("El n�mero no corresponde a un mes");
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
		System.out.println("El mes del a�o es: "+resultado);
		}	
	}
	
}
