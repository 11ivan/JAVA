//Utiles.java
/*Implementa una clase de utilidad donde se contemplen funcionalidades como:
a. Dado un array cargado aleatoriamente, generar a partir de él otro array que contenga los elementos pares que se encuentran en el primero.
b. Crear un array de 20 elementos, con números aleatorios comprendidos entre 100 y 300, de forma que no se repita ningún elemento.
c. Dado un array de números enteros, generar a partir de él un nuevo array donde se almacenen los elementos del primero que sean primos.
d. A partir de un array generar otro con los elementos al revés.
e. Funcionalidad que reciba un array de enteros y un número y devuelva la posición en la que lo encuentre y 0 si el número no está en el array. En el array no puede haber números repetidos.
*/

import java.util.Random;
import java.util.ArrayList;
//import java.lang.Math;

public class Utiles{

	/*		cargaArray
	 * Proposito: Carga un array de forma aleatoria
	 * Prototipo: public int[] cargaArray(int[] array)
	 * Precondiciones: No hay
	 * Entradas: No hay
	 * Salidas: Un array de numeros enteros
	 * Postcondiciones: Asociado al nombre devuelve un array de enteros 
	 */
	 public static int[] cargaArray(int longitud, int maximo, int minimo){
			int[] miarray=new int[longitud];
			Random aleatorio=new Random();
			
			for(int i=0;i<miarray.length;i++){
					miarray[i]=aleatorio.nextInt((maximo-minimo)+1)+minimo;
				}
			return miarray;
	}
	
//___________________________________________________________________________________________	

/*		cargaArrayPares
	 * Proposito: Dado un array cargado aleatoriamente, generar a partir de él otro array que contenga los elementos pares que se encuentran en el primero.
	 * Prototipo: public int[] cargaArray(int[] array)
	 * Precondiciones: No hay
	 * Entradas: No hay
	 * Salidas: Un array de numeros enteros
	 * Postcondiciones: Asociado al nombre devuelve un array de enteros 
	 */
	 public static int[] cargaArrayPares(int[] array){
		int[] arraypares=new int[array.length/2];
		
		for(int i=0;i<arraypares.length;i++){
			if(array[i]%2==0){
				arraypares[i]=array[i*2];
			}
		}
		return arraypares;
	}
	 
	 
//___________________________________________________________________________________________	
	 
	 	
	
	//b. Crear un array de 20 elementos, con 
	/*		arrayNoRepeatElement
	 * Proposito: Cargar un array de 20 numeros
	 * Prototipo: public int[] arrayNoRepeatElement()
	 * Precondiciones: No hay
	 * Entradas: No hay
	 * Salidas: Un array de numeros enteros
	 * Postcondiciones: Asociado al nombre devuelve un array de enteros 
	 * Restricciones:  Números aleatorios comprendidos entre 100 y 300, de forma que no se repita ningún elemento.
	 */
	 //usamos otro for para recorrer el array y comprobar si el valor del numero esta en algun hueco del
	 //array y si esta saltaremos esa iteracion
	 
		public static int[] arrayNoRepeatElement(){
		//(Uso del método añadir al final): NombreDelArrayList.add (objeto_a_añadir);
		//	ArrayList <int> array;
		//	array=new ArrayList<int>();
			int numero;
			int[] miarray=new int[20];
			int indice=0,indice2;
			Random aleatorio=new Random();
			
			
				for(indice=0;indice<miarray.length;){		
					
					//numero=aleatorio.nextInt(300)+100;	
					numero=aleatorio.nextInt(21) +10;	
					System.out.println("numero generado"+numero);//control	

						for(indice2=0;indice2<miarray.length;indice2++){ 		
							//numero=aleatorio.nextInt(201) +100;	//(maximo-minimo+1) + el numero que empieza
																							
							if(numero==miarray[indice2]){				
									System.out.println("Repetido, damos otra vuelta, esta no se cuenta");			    
							}else{
									//array[indice].add(numero);
									//indice--;
									miarray[indice2]=numero;
									indice++;
									System.out.println("Indice: "+indice2+", numero en el indice "+miarray[indice2]);//control	

								}																				
							} 								
					} 
			return miarray;
		}
		
		
		
		
	/*		
	 * Proposito:  
	 * Prototipo: 
	 * Precondiciones: No hay
	 * Entradas: No hay
	 * Salidas: 
	 * Postcondiciones: 
	 */

}
