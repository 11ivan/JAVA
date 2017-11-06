//TestCirculo.java

/**
 *Analisis
 * Comentario: Programa Para probar clase Circulo
 * Entradas:  Para el radio un decimal y para el centro (que es de la clase Punto) dos numeros decimales
 * Salidas: No hay
 * Restricciones: El radio debe ser mayor que 0
 * 				  El centro no puede ser null
 * 
 * Pseudocodigo Genealizado
 * 	INICIO
 * 		LEER Y VALIDAR CENTRO DEL CIRCULO
 * 		LEER Y VALIDAR RADIO DEL CIRCULO
 * 		PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		MIENTRAS LA OPCION SEA DISTINTA DE SALIR
 * 			SEGUN OPCION
 * 				CASO1: OBTENER AREA DEL CIRCULO
 * 				CASO2: OBTENER PERIMETRO DEL CIRCULO
 * 				CASO3: CAMBIAR EL CENTRO DEL CIRCULO Y MOSTRAR
 * 				CASO4: CAMBIAR EL RADIO DEL CIRCULO Y MOSTRAR
 * 				CASO5: ESCRIBIR PROPIEDADES DEL CIRCULO CIRCULO COMO CADENA
 * 				CASO6: COMPARAR CON OTRO CIRCULO
 * 			FIN SEGUN
 * 		VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
 * 		FIN MIENTRAS
 * 	FIN 
 * 
 */
 
 
import java.util.Scanner;
import java.util.InputMismatchException;



public class TestCirculo{
	
	public static void main(String[] args){
		
		Circulo circulo= new Circulo();
		//Punto centro=new Punto();
		
		Circulo circulo2=new Circulo();
		Circulo circuloclonado=new Circulo();
		//Punto centro2=new Punto();
		Scanner entrada=new Scanner(System.in);
		//double X;//,Y,radio; //no las necesito
		int opcion=10;
		String cadena;
		boolean iguales=false;
		Object objeto=new Object();
		
		System.out.println(circulo.getcentro());
		circuloclonado=circulo.clone();
		
		//LEER Y VALIDAR CENTRO DEL CIRCULO
		
		do{
			//InputMismatchException
			try{
				do{
					System.out.println("Introduzca el centro: eje X");
					circulo.getcentro().setX(entrada.nextDouble());
					//centro.setX(entrada.nextDouble());
					//X=entrada.nextDouble(); //no necesito variables, le hago un setX a centro
				}while(circulo.getcentro().getX()<=0);
			}catch(InputMismatchException error){
					System.out.println("No pasa nada. Seguimos");
				}
			//centro.setX(X);
			try{			
				do{
					System.out.println("Introduzca el centro: eje Y");
					circulo.getcentro().setY(entrada.nextDouble());
					//centro.setY(entrada.nextDouble());
					//Y=entrada.nextDouble(); //no necesito variables, le hago un setY a centro
				}while(circulo.getcentro().getY()<=0);	
			}catch(InputMismatchException error){
					System.out.println("No pasa nada. Seguimos");
				}
				
			//centro.setY(Y);
			
			//circulo.setcentro(centro);
			
			//circulo.getcentro().setX(X);// error: centro has private access in Circulo  //SOLUCIONADO↓↓↓↓↓↓↓↓↓↓↓↓
			//circulo.centro.setY(Y);// error: centro has private access in Circulo	 //necesito la variable centro de tipo punto o asi>> circulo.getcentro().setY(entrada.nextDouble());
			}while(circulo.getcentro()==null);
		
  		//LEER Y VALIDAR RADIO DEL CIRCULO
  		try{
			do{
				System.out.println("Introduzca el radio");
				circulo.setradio(entrada.nextDouble());
				//radio=entrada.nextDouble(); //no necesito variables
				//circulo.setradio(radio);
				}while(circulo.getradio()<=0);
  			}catch(InputMismatchException error){
				System.out.println("No pasa nada. Seguimos");
			}

  		//PRESENTAR MENU LEER Y VALIDAR OPCION
  		try{
			do{
				metodospruebacirculo.menu();
				
				opcion=entrada.nextInt();			
				}while(opcion<0 && opcion>9);
  		}catch(InputMismatchException error){
					System.out.println(error);
				}
  		//MIENTRAS LA OPCION SEA DISTINTA DE SALIR
  		try{
  		while(opcion!=0){
  		
  			switch(opcion){
  				case 1: //OBTENER AREA DEL CIRCULO
						System.out.println(circulo.getarea());
  				break;
  				
  				
  				case 2: //OBTENER PERIMETRO DEL CIRCULO
						System.out.println(circulo.getperimetro());
  				break;
  				
  				
  				case 3: //CAMBIAR EL CENTRO DEL CIRCULO Y MOSTRAR
						do{
							System.out.println("Introduzca el nuevo centro: eje X");
							//X=entrada.nextDouble();//no necesito variables, le hago un setradio a circulo 
							//centro.setX(X);
							circulo.getcentro().setX(entrada.nextDouble());
							System.out.println("Introduzca el nuevo centro: eje Y");
							//Y=entrada.nextDouble();//no necesito variables
							//centro.setY(Y);
							circulo.getcentro().setY(entrada.nextDouble());
							//circulo.setcentro(circulo.getcentro());			ASI NO SE HACE. SE HACE COMO ESTA ARRIBA				
						}while(circulo.getcentro()==null);
						circulo.mostrar();
  				break;
  				
  				
  				case 4: //CAMBIAR EL RADIO DEL CIRCULO Y MOSTRAR
						do{
							System.out.println("Introduzca el nuevo radio");
							//radio=entrada.nextDouble();//no necesito variables
							//circulo.setradio(radio);↓↓↓↓↓↓↓↓↓↓↓↓
							circulo.setradio(entrada.nextDouble());
						}while(circulo.getradio()<=0);
						circulo.mostrar();
  				break;
  				
  				
  				case 5: //ESCRIBIR PROPIEDADES DEL CIRCULO COMO CADENA
						cadena=circulo.toString();
						System.out.println(cadena);
  				break;
  				
  				
  				case 6: //COMPARAR CON OTRO CIRCULO
								//LEER Y VALIDAR EJES DEL CENTRO
									do{
										do{
											System.out.println("Introduzca el eje X del nuevo circulo a comparar con el anterior");
											circulo2.getcentro().setX(entrada.nextDouble());
										}while(circulo2.getcentro().getX()<=0);
										
										do{
											System.out.println("Introduzca el eje Y del nuevo circulo a comparar con el anterior");
											circulo2.getcentro().setY(entrada.nextDouble());
										}while(circulo2.getcentro().getY()<=0);
									}while(circulo2.getcentro()==null);
								
								//LEER Y VALIDAR RADIO
								do{
									System.out.println("Introduzca el radio del nuevo circulo a comparar con el anterior");
									circulo2.setradio(entrada.nextDouble());
								}while(circulo2.getradio()<=0);
								
								//COMPARAR CIRCULOS
								System.out.println(circulo.compareTo(circulo2));
								
  				break;
  				
  				
  				case 7 : 	//CLONAR EL CIRCULO
									circuloclonado=circulo.clone();
									circuloclonado.mostrar();
									
  				
  				break;
  				
  				
  				case 8 : 	//COMPROBAR SI UN OBJETO ES DE TIPO CIRCULO Y DECIR SI SON IGUALES
									iguales=circulo.equals(objeto);
									System.out.println(iguales);
									
									iguales=circulo.equals(circulo2);
									System.out.println(iguales);
  				
  				break;
  				
  				
  				case 9:		//OBTENER HASHCODE
									System.out.println(circulo.hashCode());

  			}//FIN SEGUN
  		//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
  		do{
			metodospruebacirculo.menu();
			opcion=entrada.nextInt();
		}while(opcion<0 && opcion>9);

  		
  		}//FIN MIENTRAS
		}catch(InputMismatchException error){
				System.out.println("No pasa nada. Seguimos");
		}
			
	}
}

















