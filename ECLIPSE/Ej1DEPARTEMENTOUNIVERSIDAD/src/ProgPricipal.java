/*Analisis
 *  Comentario: El departamento de personal de una Universidad tiene registros del nombre, sexo
	y edad de cada uno de los profesores adscritos. Escriba un programa que calcule e imprima los
	siguientes datos 
 * 
 * 	Entradas: Cadenas: opcion del menu, 
 * 
 * 	Salidas: No hay
 * 
 * 	Restricciones: La opcion del menu debe ser mayor o igual que 0  y menor o igual que 5
 * 
 * 
 * PSEUDOCODIGO GENERALIZADO
 * 
 * INICIO
 	//PRESENTAR MENU LEER Y VALIDAR OPCION*
 	
 	//MIENTRAS OPCION SEA DISTINTA DE 0
 	 
	 	//SEGUN(OPION)
	 	 	
	 	 	//CASO 1	//EDAD PROMEDIO DEL GRUPO DE PROFESORES*
	 	 	
	 		//CASO 2	//NOMBRE DEL PROFESOR MAS JOVEN DEL GRUPO*
	 		
	 		//CASO 3	//NOMBRE DEL PROFESOR DE MAS EDAD*
	 		
	 		//CASO 4	//NUMERO DE PROFESORES CON EDAD MAYOR AL PROMEDIO* 
	 
	 		//CASO 5	//NUMERO DE PROFESORES CON EDAD MENOR AL PROMEDIO* 
 	
 	 	//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION*
	
 	//FIN MIENTRAS
 * FIN
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ProgPricipal {
	public static void main(String[] args) {
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		ListaPersonas personas=new ListaPersonas();
		String ruta;
		String opcion=null;
		GestoraProgPrinc gestora=new GestoraProgPrinc();
		
		
	 	//PRESENTAR MENU LEER Y VALIDAR OPCION*
	/* 	do{
	 		gestora.pintaMenu();
	 		try {
				opcion=br.readLine();		
			} catch (IOException e) {
				e.printStackTrace();
			}
	 	}while(!gestora.validaOpcion(opcion));
	 	
	 	//MIENTRAS OPCION SEA DISTINTA DE 0
	 	while(!opcion.equals("0")){
	 
		 	switch(opcion){
		 	 	
		 		case "1":	//EDAD PROMEDIO DEL GRUPO DE PROFESORES*
		 					System.out.println(gestora.edadPromedio());
		 	 	break;
		 	 	
		 	 	
		 		case "2":	//NOMBRE DEL PROFESOR MAS JOVEN DEL GRUPO*
		 			
		 		break;
		 		
		 			
		 		case "3":	//NOMBRE DEL PROFESOR DE MAS EDAD*
		 			
		 		break;
		 			
		 			
		 		case "4":	//NUMERO DE PROFESORES CON EDAD MAYOR AL PROMEDIO* 
		 			
		 		break;
		 			
		 			
		 		case "5":	//NUMERO DE PROFESORES CON EDAD MENOR AL PROMEDIO* 
	 	
		 			
		 		break;
		 		
		 		case "6":	//LISTA DE PROFESORES
		 					gestora.leePersonas();
		 			
		 		break;

		 	}//FIN SEGUN
	 		
	 	 	//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION*
		 	do{
		 		gestora.pintaMenu();
		 		try {
					opcion=br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
		 	}while(!gestora.validaOpcion(opcion));

	 	}//FIN MIENTRAS
*/
		
//gestora.escribePersonas();
gestora.leePersonas();		
		

		
		

	}//
}//
