/*Analisis
 *  Comentario: El departamento de personal de una Universidad tiene registros del nombre, sexo
	y edad de cada uno de los profesores adscritos. Escriba un programa que calcule e imprima los
	siguientes datos 
 * 
 * 	Entradas: Cadenas: opcion del menuPrincipal, opcion del menuBusqueda, opcion del menuModificar, dni, nombre, apellido, dia, mes, año
 * 
 * 	Salidas: Pinta en pantalla y genera fichero
 * 
 * 	Restricciones: La opcion del menu Principal debe ser mayor o igual que 0  y menor o igual que 11
 * 				   La opcion del menu Busqueda debe ser mayor o igual que 0  y menor o igual que 4
 * 				   La opcion del menu Modificar debe ser mayor o igual que 0  y menor o igual que 7
 * 
 * 
 * PSEUDOCODIGO GENERALIZADO
 * INICIO
 	//PRESENTAR MENU LEER Y VALIDAR OPCION*
 	
 	//MIENTRAS OPCION SEA DISTINTA DE 0
 	 
	 	//SEGUN(OPION)
	 	 	
	 	 	//CASO 1	EDAD PROMEDIO DEL GRUPO DE PROFESORES*
	 	 	
	 		//CASO 2	NOMBRE DEL PROFESOR MAS JOVEN DEL GRUPO*
	 		
	 		//CASO 3	NOMBRE DEL PROFESOR DE MAS EDAD*
	 		
	 		//CASO 4	NUMERO DE PROFESORES CON EDAD MAYOR AL PROMEDIO* 
	 
	 		//CASO 5	NUMERO DE PROFESORES CON EDAD MENOR AL PROMEDIO* 
	 		
	 		//CASO 6	LISTA PROFESORES*
	 		 
	 		//CASO 7	AÑADIR PROFESOR
	 		 
	 		//CASO 8	BORRAR PROFESOR
	 		
	 		//CASO 9	BÚSQUEDA PROFESOR
	 		 
	 		//CASO 10	MODIFICAR PROFESOR
	 		 
	 		//CASO 11	ORDENAR POR ANTIGUEDAD*
	 			
 	 	//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION*
	
 	//FIN MIENTRAS
 * FIN
 */



/*AÑADIR PROFESOR (PG. 2 lvl)
 * 	CREAPROFESOR*
 *	ADDPROFESOR*
 */

/*BORRAR PROFESOR (PG. 2 lvl)
 * 	LEER Y VALIDAR DNI
 * 	DROPPROFESOR*
 */


/*BÚSQUEDA PROFESOR (PG. 2 lvl)
 * 	LEERYVALIDAR OPCION MENU
 * 	MIENTRAS OPCION DISTINTA DE SALIR
 *  SEGUN(OPION)
 *	 	CASO 1	NOMBRE Y APELLIDO
 *	 	CASO 2	MATERIA
 *	 	CASO 3	SEXO
 *	 	CASO 4	DNI
 *	FIN_SEGUN
 *	VOLVER A LEERYVALIDAR OPCION MENU
 *	FIN MIENTRAS
 * */


/*	MODIFICAR PROFESOR
 * 		PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		MIENTRAS OPCION SEA DISTINTO DE SALIR
 * 			LEER Y VALIDAR DNI PROFESOR
 * 			SEGUN OPCION
 * 				CASO 1  MODIFICAR NOMBRE
 * 				CASO 2  MODIFICAR APELLIDO
 * 				CASO 3  MODIFICAR FECHA NACIMIENTO			//EN AMBAS OPCIONES DE MODIFICAR FECHA LEEMOS Y VALIDAMOS POR SEPARADO: DIA, MES Y AÑO
 * 				CASO 4  MODIFICAR SEXO
 * 				CASO 5  MODIFICAR DNI
 * 				CASO 6  MODIFICAR MATERIA
 * 				CASO 7  MODIFICAR FECHA CONTRATACION
 * 			FIN SEGUN
 * 			VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		FIN MIENTRAS
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.InputMismatchException;
//import java.util.Scanner;


public class ProgPrincipal {
	public static void main(String[] args) {
		ComparatorProfesor comparatorAnt=new ComparatorProfesor();
		ComparatorProfesorApellido comparatorApellido=new ComparatorProfesorApellido();
		//Persona p=new PersonaImpl();
		//Scanner teclado=new Scanner(System.in);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String opcion=" ";
		String opcionBusqueda=" ";
		Gestora2 gestora=new Gestora2();
		boolean vale=true;
		String materia=" ", nombre=" ", apellido=" ", sexo=" ", dni=" ";
		int posicion;
		String campo = null;
		int campoPars =0;
		Fecha2 fecha=null;
		
		
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
		 					ProfesorImpl profesor=new ProfesorImpl();
		 					//profesor=gestora.creaProfesor();
		 					//gestora.addProfesor(profesor);
		 					gestora.addProfesores();

 				break;
 				
		 		case "8":	//MARCAR PROFESOR A BORRAR*
		 					gestora.leeProfesores();
		 					do{
		 						vale=true;
		 						System.out.println("Introduzca el DNI del profesor a eliminar");

		 						try{
		 							dni=br.readLine();
		 							//System.out.println(dni.substring(0, 8)+", "+dni.charAt(8));
		 							if(!dni.matches("\\d{8}[a-zA-Z]{1}")){
		 								vale=false;
		 							}
		 							/*if(dni.length()!=9){
		 								vale=false;
		 							}
		 							if(vale){
		 								if(!gestora.validaDNI(dni.substring(0, 8)) || !Character.isAlphabetic(dni.charAt(8))){
		 									vale=false;
		 								}
		 							}*/							
		 						} catch (IOException e) {
									e.printStackTrace();
								}
		 					}while(!vale);
		 					//gestora.marcaProfesor(posPars); 
		 					posicion=gestora.posicionProfesor(dni);
		 					if(posicion>=0){
		 						gestora.marcaProfesorChungo(posicion);
		 					}else{
		 						System.out.println("No se encontró el DNI");
		 					}
 				break;
 				
		 		case "9":	//BÚSQUEDA PROFESOR/ES
		 						//PRESENTAR MENU BUSQUEDA LEER Y VALIDAR OPCION*
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
				 					
				 					while(opcionBusqueda!="0"){
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
			
			 						//Volver a pinta menu leer y validar opcion
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
				 				}//fin mientras

			 	break;
		 			
		 		case "10":		//MODIFICAR PROFESOR
		 						//ProfesorImpl profesorMod=null;
		 						 					
		 						//Presentar MenuMod Leer y validar opcion
			 					do{ 						
			 						try{
			 							gestora.pintaMenuMod();
			 							campo = br.readLine();
			 						} catch (IOException e) {
										System.out.println(e);
									}
			 					}while(!gestora.validaOpcionMod(campo));
			 					
			 					while(!campo.equals("0")){
				 					
			 						//LEER Y VALIDAR DNI
				 					do{
				 						gestora.leeProfesores();
				 						vale=true;
				 						System.out.println("Introduzca el DNI del profesor a modificar");

				 						try{
				 							dni=br.readLine();
				 							//System.out.println(dni.substring(0, 8)+", "+dni.charAt(8));
				 							if(!dni.matches("\\d{8}[a-zA-Z]{1}")){
				 								vale=false;
				 							}
				 							/*if(dni.length()!=9){
				 								vale=false;
				 							}
				 							if(vale){
				 								if(!gestora.validaDNI(dni.substring(0, 8)) || !Character.isAlphabetic(dni.charAt(8))){
				 									vale=false;
				 								}
				 							}*/							
				 						} catch (IOException e) {
											e.printStackTrace();
										}
					 					posicion=gestora.posicionProfesor(dni);
					 					if(posicion<0){
					 						System.out.println("No se encontró el DNI");
					 					}

				 					}while(!vale && posicion<0);
			 						
			 						switch(campo){

				 						case "1":	//Modificar Nombre*
				 										//LEER Y VALIDAR NOMBRE
				 										do{						//solo valido que no contenga numeros
				 											System.out.println("Introduzca el nuevo nombre");
				 											try {
																nombre=br.readLine();
															} catch (IOException e) {
																e.printStackTrace();
															}
				 										}while(!nombre.matches("[a-zA-Z]*"));
				 										gestora.modProfesor(nombre, posicion, 1);	
				 										//gestora.modProfesorNombre(nombre, posicion);
				 						break;			
				 						
				 						case "2":	//Modificar Apellido*
				 										//LEER Y VALIDAR APELLIDO
				 										do{						//solo valido que no contenga numeros
				 											System.out.println("Introduzca el nuevo apellido");
				 											try {
																apellido=br.readLine();
															} catch (IOException e) {
																e.printStackTrace();
															}
				 										}while(!apellido.matches("[a-zA-Z]*"));
				 										gestora.modProfesor(apellido, posicion, 2);							 							
					 					break;
					 						
				 						case "3":	//Modificar Fecha Nacimiento*
				 									fecha=new Fecha2();
							 							//LEER Y VALIDAR FECHA
							 							//do{
							 								System.out.println("\nIntroduzca la fecha de nacimiento");
							 								do{
							 									vale=true;
							 									System.out.println("\n\tIntroduzca el año");
							 									try{
							 										fecha.setYear(br.readLine());
							 									}catch(ExcepcionFecha error){
							 										System.out.println(error);
							 										vale=false;
							 									}catch (IOException e) {					
							 										e.printStackTrace();
							 									}
							 								}while(!vale);
							 								
							 								do{
							 									vale=true;
							 									System.out.println("\n\tIntroduzca el mes");
							 									try{
							 										fecha.setMonth(br.readLine());
							 									}catch(ExcepcionFecha error){
							 										System.out.println(error);
							 										vale=false;
							 									}catch (IOException e) {					
							 										e.printStackTrace();
							 									}
							 								}while(!vale);
							 								
							 								do{
							 									vale=true;
							 									System.out.println("\tIntroduzca el dia");
							 									try{
							 										fecha.setDay(br.readLine());
							 									}catch(ExcepcionFecha error){
							 										System.out.println(error);
							 										vale=false;
							 									}catch (IOException e) {					
							 										e.printStackTrace();
							 									}
							 								}while(!vale);
							 								System.out.println(fecha.toString());
							 							//}while(!fecha.validafecha());
							 							gestora.modProfesor(fecha.toString(), posicion, 3);	
						 				break;
					 					
				 						case "4":	//Modificar Sexo*
				 										//LEER Y VALIDAR SEXO
				 										do{
				 											System.out.println("Introduzca el sexo");
				 											try {
																sexo=br.readLine();
															} catch (IOException e) {
																e.printStackTrace();
															}
				 										}while(!gestora.validaSexo(sexo));
				 										gestora.modProfesor(sexo, posicion, 4);
					 					break;
					 						
				 						case "5":	//Modificar DNI*
							 						//LEER Y VALIDAR DNI
								 					do{
								 						//gestora.leeProfesores();
								 						vale=true;
								 						System.out.println("Introduzca el DNI");
		
								 						try{
								 							dni=br.readLine();
								 							//System.out.println(dni.substring(0, 8)+", "+dni.charAt(8));
								 							if(!dni.matches("\\d{8}")){
								 								vale=false;
								 							}
								 						} catch (IOException e) {
															e.printStackTrace();
														}
								 					}while(!vale);
								 					gestora.modProfesor(dni, posicion, 5);
					 					break;
					 						
				 						case "6":	//Modificar Materia*
				 									do{
				 										System.out.println("Introduzca la materia");
				 										try {
															materia=br.readLine();
														} catch (IOException e) {
															System.out.println(e);
														}
				 									}while(!gestora.validaMateria(materia));
				 									gestora.modProfesor(materia, posicion, 6);
					 					break;
					 						
					 						
				 						case "7":	//Modificar Fecha Contratacion*
				 									fecha=new Fecha2();
						 							//LEER Y VALIDAR FECHA
						 							//do{
						 								System.out.println("\nIntroduzca la fecha de nacimiento");
						 								do{
						 									vale=true;
						 									System.out.println("\n\tIntroduzca el año");
						 									try{
						 										fecha.setYear(br.readLine());
						 									}catch(ExcepcionFecha error){
						 										System.out.println(error);
						 										vale=false;
						 									}catch (IOException e) {					
						 										e.printStackTrace();
						 									}
						 								}while(!vale);
						 								
						 								do{
						 									vale=true;
						 									System.out.println("\n\tIntroduzca el mes");
						 									try{
						 										fecha.setMonth(br.readLine());
						 									}catch(ExcepcionFecha error){
						 										System.out.println(error);
						 										vale=false;
						 									}catch (IOException e) {					
						 										e.printStackTrace();
						 									}
						 								}while(!vale);
						 								
						 								do{
						 									vale=true;
						 									System.out.println("\tIntroduzca el dia");
						 									try{
						 										fecha.setDay(br.readLine());
						 									}catch(ExcepcionFecha error){
						 										System.out.println(error);
						 										vale=false;
						 									}catch (IOException e) {					
						 										e.printStackTrace();
						 									}
						 								}while(!vale);
						 								System.out.println(fecha.toString());
						 							//}while(!fecha.validafecha());
						 								gestora.modProfesor(fecha.toString(), posicion, 7);
					 					break;
			 						
			 						}//fin segun
			 						
			 						//Volver a Presentar MenuMod Leer y validar campo a modificar
				 					do{ 						
				 						try{
				 							gestora.pintaMenuMod();
				 							campo = br.readLine();
				 						} catch (IOException e) {
											System.out.println(e);
										}
				 					}while(!gestora.validaOpcionMod(campo));

			 					}//fin mientras

		 		break;
		 		
		 		case "11":	//ORDENAR POR ANTIGÜEDAD
		 					gestora.Ordenar(comparatorAnt);
		 		break;
		 		
		 		case "12":	//ORDEN POR APELLIDO
		 					gestora.Ordenar(comparatorApellido);
		 		break;
		 		
		 		case "13":	//ACTUALIZAR MASTER
 							gestora.actualizarMaster();
 				break;
 				
		 		case "14":	//LISTA ARCHIVO MASTER
							gestora.leeProfesoresMaster();
				break;

		 		case "15":	//ORDENAR ARCHIVO MASTER
		 					//gestora.leeProfesoresMaster();
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
	}//
}//FIN
