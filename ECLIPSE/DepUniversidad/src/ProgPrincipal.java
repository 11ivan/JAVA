/*Analisis
 *  Comentario: El departamento de personal de una Universidad tiene registros del nombre, sexo
	y edad de cada uno de los profesores adscritos. Escriba un programa que calcule e imprima los
	siguientes datos 
 * 
 * 	Entradas: Cadenas: opcion del menuPrincipal, dni, opcion del menuBusqueda
 * 
 * 	Salidas: Pinta en pantalla y genera fichero
 * 
 * 	Restricciones: La opcion del menu debe ser mayor o igual que 0  y menor o igual que 8
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
	 		
	 		//CASO 6	//LISTA PROFESORES*
	 		 
	 		//CASO 7	//AÑADIR PROFESOR*
	 		 
	 		//CASO 8	//BORRAR PROFESOR*
	 		
	 		//CASO 9	//BÚSQUEDA PROFESOR*
	 		 
	 		//CASO 10	//MODIFICAR PROFESOR
	 		 
	 		//CASO 11	//ORDENAR POR ANTIGUEDAD*
	 			
 	 	//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION*
	
 	//FIN MIENTRAS
 * FIN
 */



/*AÑADIR PROFESOR (PG. 2 lvl)
 * 
 * CREAPROFESOR*
 * SI PROFESOR NO EXISTE
 * 	ADDPROFESOR*
 * FIN_SI
 * 
 * */


/*BÚSQUEDA PROFESOR (PG. 2 lvl)
 * 
 * SI HAY PROFESORES
 * 	LEERYVALIDAR OPCION MENU
 *  SEGUN(OPION)
 *	 	CASO 1	//NOMBRE Y APELLIDO
 *	 	CASO 2	//MATERIA
 *	 	CASO 3	//SEXO
 *	 	CASO 4	//DNI
 *	//FIN_SEGUN
 * FIN_SI
 * 
 * */


/*BORRAR PROFESOR (PG. 2 lvl)
 * 
 * SI HAY PROFESORES
 * 	LEER DNI
 * 	SI DNI EXISTE
 * 		DROPPROFESOR*
 * 	FIN_SI
 * FIN_SI
 * 
 * 
 * */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class ProgPrincipal {
	public static void main(String[] args) {
		
		Scanner teclado=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String ruta;
		String opcion=" ";
		String opcionBusqueda=" ";
		//GestoraProgPrinc gestora=new GestoraProgPrinc();
		Gestora2 gestora=new Gestora2();
		boolean vale=true;
		String materia=" ", nombre=" ", apellido=" ", sexo=" ", dni=" ";
		
	 	//PRESENTAR MENU LEER Y VALIDAR OPCION*
	 	do{
	 		gestora.pintaMenu();
	 		try {
				opcion=br.readLine();		
				System.out.println();
			} catch (IOException e) {
				e.printStackTrace();
			}
	 	}while(!gestora.validaOpcion(opcion));
	 	
	 	//MIENTRAS OPCION SEA DISTINTA DE 0
	 	while(!opcion.equals("0")){
	 
		 	switch(opcion){
		 	 	
		 		case "1":	//EDAD PROMEDIO DEL GRUPO DE PROFESORES*
		 					System.out.println("\nLa dedad promedio es "+gestora.edadPromedio());
		 	 	break;
		 	 	
		 	 	
		 		case "2":	//NOMBRE DEL PROFESOR MAS JOVEN DEL GRUPO*		 					
		 					gestora.ProfesorJoven();System.out.println();
		 		break;
		 		
		 			
		 		case "3":	//NOMBRE DEL PROFESOR DE MAS EDAD*		 					
		 					gestora.ProfesorMayor();System.out.println();
		 		break;
		 			
		 			
		 		case "4":	//NUMERO DE PROFESORES CON EDAD MAYOR AL PROMEDIO*	 					
		 					gestora.MayorAMedia();System.out.println();
		 		break;
		 			
		 			
		 		case "5":	//NUMERO DE PROFESORES CON EDAD MENOR AL PROMEDIO* 		 					
		 					gestora.MenorAMedia();System.out.println(); 			
		 		break;
		 		
		 		case "6":	//LISTA DE PROFESORES*
		 					gestora.leeProfesores();
		 		break;
		 		
		 		case "7":	//AÑADIR PROFESOR*
		 					Profesor profesor=new Profesor();
		 					profesor=gestora.creaProfesor();
		 					if(!gestora.profesorDniExists(profesor.getDNI())){
		 						gestora.addProfesor(profesor);
		 					}else{
		 						System.out.println("Ya existe un profesor con ese DNI");
		 					}
 				break;
 				
		 		case "8":	//BORRAR PROFESOR*
		 					if(gestora.cuentaProfesores()>0){
		 						//do{
				 					System.out.println("Introduzca el dni del profesor a eliminar");
				 					//if(gestora.profesorDniExists(dni)){
					 					try{			 						
					 						if(gestora.dropProfesor(br.readLine())){
					 							System.out.println("El profesor ha sido eliminado con éxito");
					 						}else{
					 							System.out.println("No se eliminó al profesor");
					 						}
					 					}catch(IOException error){
					 						error.printStackTrace();
					 					}
				 					//}
		 						//}while(gestora.validaDNI(dni));
		 					}else{
		 						System.out.println("El archivo debe exixstir y contener algún profesor");
		 					}
		 					
 				break;
 				
		 		case "9":	//BÚSQUEDA PROFESOR/ES
		 						//PRESENTAR MENU BUSQUEDA LEER Y VALIDAR OPCION*
		 						if(gestora.cuentaProfesores()>0){
				 					do{
				 						gestora.pintaMenuBusqueda();
				 						System.out.println("");
				 						try {
											opcionBusqueda=br.readLine();
											System.out.println("");
										} catch (IOException e) {
											e.printStackTrace();
										}
				 					}while(!gestora.validaOpcionBusqueda(opcionBusqueda));
				 					
				 					switch(opcionBusqueda){
				 						
				 						case "1":	//BÚSQUEDA POR NOMBRE Y APELLIDO
				 										//LEER NOMBRE
								 						System.out.println("Introduzca el nombre");
														try {
															nombre=br.readLine();
															System.out.println("");
														} catch (IOException e1) {														
															e1.printStackTrace();
														}
														
				 										//LEER APELLIDO
				 										System.out.println("Introduzca el apellido");
														try {
															apellido=br.readLine();
															System.out.println("");
														} catch (IOException e1) {													
															e1.printStackTrace();
														}
														
				 										//BUSCA PROFESOR/ES*
				 									 	gestora.buscaProfesores(nombre, apellido);			
				 						break;
				 						
				 						case "2":	//BUSQUEDA POR MATERIA			 										
				 										//LEER Y VALIDAR MATERIA
				 										do{
				 											System.out.println("Introduzca la materia");
				 											try {
																materia = br.readLine();
																System.out.println("");
															} catch (IOException e) {
																e.printStackTrace();
															}
				 										}while(!gestora.validaMateria(materia));
				 										
				 										//BUSCA PROFESOR/ES*
				 										gestora.buscaProfesoresMateria(materia);
				 						break;
				 						
				 						case "3":	//BÚSQUEDA POR SEXO			 									
				 										//LEER Y VALIDAR SEXO
				 										do{
				 											System.out.println("Introduzca el sexo");
				 											try {
																sexo=br.readLine();
																System.out.println("");
															} catch (IOException e) {
																e.printStackTrace();
															}
				 										}while(!gestora.validaSexo(sexo));
				 										
				 										//BUSCA PROFESOR/ES*
				 										gestora.buscaProfesoresSexo(sexo);
				 										
				 						break;
				 						
				 						case "4":	//BÚSQUEDA POR DNI	
				 										//LEER DNI
					 									System.out.println("Introduzca el DNI");
														try {
															dni=br.readLine();
															System.out.println("");
														} catch (IOException e1) {
															e1.printStackTrace();
														}
														
														//BUSCA PROFESOR/ES*
														gestora.buscaProfesorDNI(dni);
							 		break;				 						
			 						
				 					}//Fin segun
		 						}else{
		 							System.out.println("El archivo debe exixstir y contener algún profesor");
		 						}
			 	break;
		 			
		 		case "10":		//MODIFICAR PROFESOR
		 						gestora.leeProfesores();
		 						Profesor profesorMod=null;
		 						
		 						//LEER DNI
								System.out.println("Introduzca el DNI del profesor a modificar");
								try {
									dni=br.readLine();
									System.out.println("");
								} catch (IOException e1) {
									e1.printStackTrace();
								}
								if(gestora.profesorDniExists(dni)){
									profesorMod=gestora.creaProfesor();
									gestora.modificaProfesor(dni, profesorMod);
								}else{
									System.out.println("El DNI introducido no existe");
								}
								gestora.leeProfesores();
		 		break;
		 		
		 		case "11":	//ORDENAR POR ANTIGÜEDAD
		 					gestora.ordenarPorAntiwedad();

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
	}//
}//FIN
