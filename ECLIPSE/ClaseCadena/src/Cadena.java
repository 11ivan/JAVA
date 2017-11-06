/*
 * Propiedades
 * 	Cadena: Basica, Cadena, consultable, modificable
 * 
 * Interfaz:
 * 	String getCadena()
 * 	void setCadena(String cadena)
 * 
 * 
 * Funcionalidades:
 * 			- Cadena al reves
 * 		Proposito: Le da la vuelta a la cadena
 * 		Prototipo: void reverseString()
 * 		Precondiciones: La cadena no estará vacía
 * 		Entradas: El atributo cadena de la clase
 * 		E/S: No hay
 * 		Salidas: No hay
 * 		Postcondiciones: La cadena esta al reves
 * 
 * 			- Primero Mayuscula
 * 		Proposito: Transformar una cadena en ella misma pero cambiando por mayúscula su primer carácter.
 * 		Prototipo: void primeroMayusc()
 * 		Precondiciones: La cadena no estará vacía
 * 		Entradas: El atributo cadena de la clase
 * 		E/S: No hay
 * 		Salidas: No hay
 * 		Postcondiciones: El primer caracter de la cadena es Mayúscula 
 * 
 * 			- Borrar espacios
 * 		Proposito: Eliminar todos los espacios en blanco de una cadena de caracteres.
 * 		Prototipo: void dropSpace()
 * 		Precondiciones: La cadena no estará vacía
 * 		Entradas: El atributo cadena de la clase
 * 		E/S: No hay
 * 		Salidas: No hay
 * 		Postcondiciones: Se han eliminado todos los espacio de la cadena.
 * 
 * 			- Formar Plurales
 * 		Proposito: Formar los plurales de palabras (Añadir s si acaba en vocal y es si acaba en consonante.)
 * 		Prototipo: void formPlural()
 * 		Precondiciones: La cadena no estará vacía
 * 		Entradas: El atributo cadena de la clase
 * 		E/S: No hay
 * 		Salidas: No hay
 * 		Postcondiciones: Se ha formado el plural de la cadena dada
 * 
 * 			- Matriz de palabra
 * 		Proposito: matriz que contenga en cada fila la palabra un paso a la dcha.
 * 		Prototipo: void matrixWord()
 * 		Precondiciones: La cadena no estará vacía
 * 		Entradas: El atributo cadena de la clase
 * 		E/S: No hay
 * 		Salidas: No hay
 * 		Postcondiciones: Se imprimirá en pantalla la matriz
 * 
 * 			- Capicua
 * 		Proposito: comprobar si un número es o no capicúa.
 * 		Prototipo: boolean capicua()
 * 		Precondiciones: La cadena no estará vacía
 * 		Entradas: El atributo cadena de la clase
 * 		E/S: No hay
 * 		Salidas: Un booleano AN
 * 		Postcondiciones: El booleano será verdadero si el numero es capicua y false si no
 * 
 */

import java.lang.Character;

public class Cadena implements Comparable<Cadena>, Cloneable{

	private String cadena;
	
	//Constructor
	public Cadena(){
		cadena=" ";
	}
	
	public Cadena(String cadena)throws excepcionCadena{
		String sinespacios=cadena.replace(" ","");
		if(sinespacios.length()==0){
			throw new excepcionCadena("La cadena no puede estar vacia");
		}else{
			this.cadena=cadena;
		}
	}
	
	public Cadena(Cadena cadena){
		this.cadena=cadena.getCadena();
	}
	
	
	//Consultor
	public String getCadena(){
		return cadena;
	}
	
	//Modificador
	public void setCadena(String cadena)throws excepcionCadena{
		String sinespacios=cadena.replace(" ","");
		if(sinespacios.length()==0){
			throw new excepcionCadena("La cadena no puede estar vacia");
		}else{
			this.cadena=cadena;
		}
	}
	
	
	
//------------------------------------------------------------------------------------------------------------	
	
//Funciones
	
	
	 /* 		- Cadena al reves
	 * 		Proposito: Le da la vuelta a la cadena
	 * 		Prototipo: void reverseString()
	 * 		Precondiciones: La cadena no estará vacía
	 * 		Entradas: El atributo cadena de la clase
	 * 		E/S: No hay
	 * 		Salidas: No hay
	 * 		Postcondiciones: La cadena esta al reves
	 */
	public void reverseString(){
		StringBuilder cadenaReves=new StringBuilder(cadena);
		cadenaReves.reverse();
		cadena=cadenaReves.toString();
	}
	
//------------------------------------------------------------------------------------------------------------	
	 
	/* 			- Primero Mayuscula
	 * 		Proposito: Transformar una cadena en ella misma pero cambiando por mayúscula su primer carácter.
	 * 		Prototipo: void primeroMayusc()
	 * 		Precondiciones: La cadena no estará vacía
	 * 		Entradas: El atributo cadena de la clase
	 * 		E/S: No hay
	 * 		Salidas: No hay
	 * 		Postcondiciones: El primer caracter de la cadena es Mayúscula 
	 */
	public void primeroMayusc(){
		
		//if (cadena.isEmpty()) {
	    //    System.out.println("La cadena está vacía");        
	   // } else {
			cadena=Character.toUpperCase(cadena.charAt(0))+cadena.substring(1);
			//cadena=cadena.substring(0,1).toUpperCase() + cadena.substring(1);
	  //  }
	}
	
	
	
//------------------------------------------------------------------------------------------------------------	
	 
	/* 			- Borrar espacios
	 * 		Proposito: Eliminar todos los espacios en blanco de una cadena de caracteres.
	 * 		Prototipo: void dropSpace()
	 * 		Precondiciones: La cadena no estará vacía
	 * 		Entradas: El atributo cadena de la clase
	 * 		E/S: No hay
	 * 		Salidas: No hay
	 * 		Postcondiciones: Se han eliminado todos los espacio de la cadena.
	 */
	public void dropSpace(){
		cadena=cadena.replace(" ", "");
	}


	
//------------------------------------------------------------------------------------------------------------	
	
	/* 		- Formar Plurales
	 * 		Proposito: Formar los plurales de palabras (Añadir s si acaba en vocal y es si acaba en consonante.)
	 * 		Prototipo: void formPlural()
	 * 		Precondiciones: La cadena no estará vacía
	 * 		Entradas: El atributo cadena de la clase
	 * 		E/S: No hay
	 * 		Salidas: No hay
	 * 		Postcondiciones: Se ha formado el plural de la cadena dada
	 */
	public void formPlural() throws excepcionCadena{
		int longitud=cadena.length()-1;
		
		//cadena.toLowerCase().charAt(8)<'a' && cadena.toLowerCase().charAt(8)>'z'
		if(Character.isDigit(cadena.charAt(longitud)) && !Character.isLetter(cadena.charAt(longitud))){
			throw new excepcionCadena("La terminacion de la cadena no es valida");			
		}else if(cadena.toLowerCase().charAt(longitud)=='a' || cadena.toLowerCase().charAt(longitud)=='e' || cadena.toLowerCase().charAt(longitud)=='i' || cadena.toLowerCase().charAt(longitud)=='o' || cadena.toLowerCase().charAt(longitud)=='u'){
				cadena=cadena+"s";
			}else{
				cadena=cadena+"es";
				}
				
	}	 	 	
	
//------------------------------------------------------------------------------------------------------------	
	 
	/* 			- Matriz de palabra
	 * 		Proposito: matriz que contenga en cada fila la palabra un paso a la izqda.
	 * 		Prototipo: void matrixWord()
	 * 		Precondiciones: La cadena no estará vacía
	 * 		Entradas: El atributo cadena de la clase
	 * 		E/S: No hay
	 * 		Salidas: No hay
	 * 		Postcondiciones: Se imprimirá en pantalla la matriz
	 */
	public void matrixWord(){
		String[] array=cadena.split("");
		String aux;

		for(int i=0;i<=array.length;i++){
			for(int j=0;j<array.length;j++){
				System.out.print(array[j]);
			}
			/*for(int cont=0;cont<array.length-1;cont++){
				aux=array[cont+1];
				array[cont+1]=array[cont];
				array[cont]=aux;
			}*/
			for(int cont=array.length-1;cont>0;cont--){
				aux=array[cont-1];
				array[cont-1]=array[cont];
				array[cont]=aux;
			}
			
			System.out.println("");
		}
	}
	
//------------------------------------------------------------------------------------------------------------	
	
	/* 			- Capicua
	 * 		Proposito: comprobar si un número es o no capicúa.
	 * 		Prototipo: boolean capicua()
	 * 		Precondiciones: La cadena no estará vacía
	 * 		Entradas: El atributo cadena de la clase
	 * 		E/S: No hay
	 * 		Salidas: Un booleano AN
	 * 		Postcondiciones: El booleano será verdadero si el numero es capicua y false si no
	 */
	public boolean capicua(){
		boolean escap=false;
		StringBuilder cadenaReves=new StringBuilder(cadena);
		String cadenaReves2=cadenaReves.reverse().toString();
		
		if(cadena.equals(cadenaReves2)){
			escap=true;
		}
				
		return escap;
	}
	
//------------------------------------------------------------------------------------------------------------	
	
		/* 			- compareTo
		 * 		Proposito: comparar dos objetos de la clase Cadena
		 * 		Prototipo: int compareTo(Cadena cadena)
		 * 		Precondiciones: La cadena no estará vacía
		 * 		Entradas: Un objeto tipo Cadena
		 * 		E/S: No hay
		 * 		Salidas: Un entero AN
		 * 		Postcondiciones: El entero será 0 si los objetos tienen el mismo valor en los atributos, -1 si el atributo del objeto Cadena que entra es tiene mayor longitud y 1 si no
		 */
		@Override
		public int compareTo(Cadena cadena){
			int comparacion;
			
			if(this.cadena==cadena.getCadena()){
				comparacion=0;
			}else if(this.cadena.length()<cadena.getCadena().length()){
				comparacion=-1;
			}else{
				comparacion=1;
			}
			
			return comparacion;
		}

}
