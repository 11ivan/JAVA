//Utiles.java
/*Implementa una clase de utilidad donde se contemplen funcionalidades como:
a. Dado un array cargado aleatoriamente, generar a partir de él otro array que contenga los elementos pares que se encuentran en el primero.
b. Crear un array de 20 elementos, con números aleatorios comprendidos entre 100 y 300, de forma que no se repita ningún elemento.
c. Dado un array de números enteros, generar a partir de él un nuevo array donde se almacenen los elementos del primero que sean primos.
d. A partir de un array generar otro con los elementos al revés.
e. Funcionalidad que reciba un array de enteros y un número y devuelva la posición en la que lo encuentre y 0 si el número no está en el array. En el array no puede haber números repetidos.
*/

import java.util.Random;
//import java.util.ArrayList;
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
	 public int[] cargaArray(int longitud, int maximo, int minimo){
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
	 public int[] cargaArrayPares(int[] array){
		int[] arraypares=new int[array.length/2];
		int j=0;
		
		for(int i=0;j<arraypares.length && i<array.length ;i++){
			if(i%2==0){
				arraypares[j]=array[i];
				j++;
			}
		}
		return arraypares;
	}
	 
	 
//___________________________________________________________________________________________		 	 		
	
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
	 
		public int[] arrayNoRepeatElement(){
		//(Uso del método añadir al final): NombreDelArrayList.add (objeto_a_añadir);
		//	ArrayList <int> array;
		//	array=new ArrayList<int>();
			int numero=0;
			int[] miarray=new int[20];
			Random aleatorio=new Random();
			boolean repetido=true;
			int contador;
				for(int indice=0;indice<miarray.length;){								
					numero=aleatorio.nextInt(21) +10;						
					repetido = false;
					contador = 0; // Iterador									  
					while ((!repetido) && (contador < miarray.length)) {
						if(miarray[contador] == numero){
							repetido = true;
						 }
						 contador++;
					}	
					if(repetido==false){
						miarray[indice]=numero;
						indice++;
					}
				}
			return miarray;
		}
		
		
//___________________________________________________________________________________________
		
	/*		
	 * Proposito:  Recorrer un array pintando en pantalla su indice y contenido
	 * Prototipo: void pintaArray(int[] array)
	 * Precondiciones: No hay
	 * Entradas: un array de enteros
	 * Salidas: no hay, solo pinta en pantalla
	 * Postcondiciones: Se pinta en pantalla cada indice y su contenido
	 */
		public void pintaArray(int[] array){
			
			for(int i=0;i<array.length;i++){
				System.out.println("Indice: "+i+", contenido: "+array[i]);
			}
		}

		
//___________________________________________________________________________________________		
		public void pintaArray(String[][] array){
			
			for(int i=0;i<array.length;i++){
				for(int j=0;j<array[0].length;j++){
					System.out.print("|"+array[i][j]);
				}
				System.out.println("");
			}
		} 
			
//___________________________________________________________________________________________	
					
	/*		
	* Proposito: Dado un array de n�meros enteros, generar a partir de �l un nuevo array donde se almacenen los elementos del primero que sean primos.
	* Prototipo: int[] arrayPrimos(int[] array)
	* Precondiciones: No hay
	* Entradas: un array de enteros
	* Salidas: asociado al nombre se devuelve un array de enteros
	* Postcondiciones: El array devuelto contiene los numero primos que hay en el array recibido
	*/
	
	/*public static ArrayList <Integer> arrayPrimos(ArrayList<Integer> miarraylist){
		ArrayList <Integer> arrayprimos=new ArrayList<Integer>();
			
		for(){				
		}
		
		return arrayprimos;
	}*/
		
		public int[] arrayPrimos(int[] array){
			int[] arraycopia=new int[array.length];
			
			int numero;
			int contador=0;
			int contador2=0;
			int primos=0;
			int divisores=0;
			
			for(int i=0;i<array.length;i++){
				numero=array[i];
				for(contador=1;contador<=numero;contador++){
					if(numero%contador==0){
						divisores++;
					}
				}//fin para
				if(divisores==2){
					arraycopia[contador2]=array[i];
					primos++;
					contador2++;
				}
				divisores=0;
			}//fin para
			
			int[] arrayprimos=new int[primos];
			contador=0;
			
			/*for(int i=0;i<primos;i++){
				if(arraycopia[contador]>0){
					arrayprimos[i]=arraycopia[contador];
					i++;
				}*/
			for(int i=0;i<primos;i++){				
					arrayprimos[i]=arraycopia[i];			
			}//fin para
			
			
			return arrayprimos;
		}
		
		
		//Copiar columna array bidimensional
		public void copyColumn(String[][]arrayCopiado,String[][]arrayAcopiar,int columna){
			for(int i=0;i<arrayCopiado.length;i++){
				arrayCopiado[i][columna]=arrayAcopiar[i][columna];
			}
		}								
		
//----------------------------------------------------------------------------------------------------------		
//ORDENACION
		//Metodo Burbuja
		/*INTERFAZ 
			Prop�sito: ordenaci�n ascendente de un array unidimensional de tama�o tam.
			Entradas: un array. En principio tambi�n se necesita el tama�o, pero al 
			implementar en Java lo conocemos, por estar impl�cito al crearlo.
			Precondiciones: el array no debe estar vac�o.
			Salida: el mismo array modificado.
			Postcondiciones: array [0], ..., array[tam-1] est� ordenado seg�n el criterio de 			
							 ordenaci�n establecido.
			
			PSEUDOC�DIGO
			burbuja (entero array [], entero tam)
			Inicio
				entero i, j, aux
				para(i=0 , mientras i<tam-1, incremento 1)
					//hace burbujear al menor
					para (j=tam-1, mientras j>i,decremento 1)
						si (array[j] < array[j-1])
							//intercambio de elementos
							aux = array[j];
							array[j] = array[j-1];
							array[j-1] = aux;
						Finsi
					Finpara
				Finpara
			Fin-burbuja 
		 */

		public void burbuja (int[] array){
			int i, j, aux;
			
			for (i=0 ; i< array.length -1 ; i++){
				for (j = array.length -1 ; j > i ; j--){
					if (array[j] < array[j-1]){
					//intercambio de elementos
					aux = array[j];
					array[j] = array[j-1];
					array[j-1] = aux;
					}
				}
			}		
		}

		
		
//____________________________________________________________________________
		
		/*
		  SELECCI�N (entero ARRAY [], entero tam)
			Inicio
				Entero I, J, M�NIMO
				
				Para (I= 0, mientras I<tam, incremento 1)
					MINIMO = I //bucle para encontrar el elemento m�s peque�o
					Para (J=I+1, mientras J<tam, incrementa en 1)
						Si(ARRAY[J] < ARRAY[MINIMO])
						MINIMO = J
						Finsi
					Finpara
					
					//intercambio para poner en su lugar el m�s peque�o
					aux = array[I];
					array[I] = array[MINIMO];
					array[MINIMO] = aux;
				Finpara
			Fin-selecci�n
		 */
		public void seleccion(int array[]){
			int i, j, minimo, aux;
			
			for(i=0;i<array.length;i++){
				minimo=i;
				for(j=i+1;j<array.length;j++){
					if(array[j]<array[minimo]){
						minimo=j;
					}				
				}
				aux=array[i];
				array[i]=array[minimo];
				array[minimo]=aux;
			}
			
		}
		
		
//____________________________________________________________________________	
		
		/*INSERCI�N (entero ARRAY [], entero tam)
		Inicio
			Entero I, J
			Para (I=1 , mientras I<tam, incremento 1)
				Para (J=I, mientras ARRAY[J-1]>ARRAY[J] Y J>0, decremento 1)
					//intercambio de elementos
					aux = array[j];
					array[j] = array[j-1];
					array[j-1] = aux;
				Finpara
			Finpara
		Fin-inserci�n
		*/
		public void insercion(int array[]){
			int i,j,aux;
			for(i=0;i<array.length;i++){
				for(j=i;j>0 && array[j-1]>array[j];j--){
					//intercambio de elementos
					aux = array[j];
					array[j] = array[j-1];
					array[j-1] = aux;
				}
			}		
		}
		
		
//____________________________________________________________________________		
//BUSQUEDA
		
		/*INTERFAZ
		Prop�sito: localizar un elemento en un array unidimensional de elementos enteros de tama�o N. El array llega desordenado
		Entradas: un array, el elemento a buscar (dato).
		Precondiciones: el array debe no estar vac�o.
		Salida: un entero con la posici�n si encuentra el dato � -1 en caso contrario.
		Postcondiciones: asociado al nombre de la funci�n se devuelve la posici�n del elemento buscado � � 1 si no se encuentra.
		PSEUDOC�DIGO
			Entero busqueda_sec (entero array[], entero dato)
			inicio
				entero i, encontrado = -1
				Para (i=0, mientras encontrado = -1 y i < array.lenght, i++)
					Si (array[i]==dato)
						encontrado = i
					Fin_si
				Fin_para
				devolver (encontrado)
			FinBus-Sec
		*/
		public int busquedaSec(int array[], int dato){
			int encontrado=-1, i;
			
			for(i=0;encontrado==-1 && i<array.length;i++){
				if(array[i]==dato){
					encontrado=i;
				}		
			}		
			return encontrado;
		}
								
//______________________________________________________________________________________________________________________________________
		/*INTERFAZ
		Prop�sito: localizar un elemento en un array unidimensional de elementos enteros de tama�o N. El array llega ordenado
		Entradas: un array, el elemento a buscar (dato).
		Precondiciones: el array debe no estar vac�o.
		Salida: un entero con la posici�n si encuentra el dato � -1 en caso contrario.
		Postcondiciones: asociado al nombre de la funci�n se devuelve la posici�n del elemento buscado � � 1 si no se encuentra.
		*/
		public int busquedaSecOrd(int array[], int dato){
			int encontrado=-1, i;
			
			for(i=0;encontrado==-1 && i<array.length;i++){
				if(array[i]==dato){
					encontrado=i;
				}		
			}		
			return encontrado;
		}
								
//______________________________________________________________________________________________________________________________________
		
		/*INTERFAZ
		Prop�sito: buscar un elemento en un array ordenado, unidimensional, de enteros y de tama�o N.
		Entradas: un array, el elemento a buscar (dato).
		Precondiciones: el array no debe estar vac�o y si ordenado.
		Salida: un entero con la posici�n si se encuentra el dato � -1 en caso contrario.
		Postcondiciones: Asociado al nombre de la funci�n se devuelve la posici�n del elemento en la estructura � �1 si no se encuentra dentro de ella.
		PSEUDOC�DIGO
			Entero busquedaBinaria(entero array[], entero dato)
			Inicio
				entero inicio=0, fin=n-1, med=p.e ((ini +fin)/2), encontrado=-1 //No encontrado
				Mientras (inicio<= fin y encontrado= -1)
					Si(array[med] = dato)
						encontrado = med
						//Mover inicio y fin para dividir el �rea de b�squeda
					En otro caso
						Si(array[med]>dato) //El dato estar� del principio a la mitad
							fin = med � 1
						En otro caso //El dato estar� de la mitad al final
							inicio = med + 1
						Fin_si
						med = p.e. ((inicio + fin)/ 2) //p.e. parte entera de la divisi�n
					Fin_si
				Fin_mientras
				Devolver (encontrado)
			FinBus-Bin
		*/
		public int busquedaBin(int array[], int dato){
			int encontrado=-1, inicio=0, fin=array.length-1, medio=(inicio+fin)/2;
			
			while(inicio<=fin && encontrado==-1){
				if(array[medio] == dato){
					encontrado = medio;
					//Mover inicio y fin para dividir el �rea de b�squeda																
				}else{
					if(array[medio]>dato){
						//El dato estar� del principio a la mitad
						fin=medio-1;
					}else{//El dato estar� de la mitad al final
							inicio=medio+1;
						}
					
					medio=(inicio+fin)/2;//p.e. parte entera de la divisi�n
				}
			}//FIN MIENTRAS		
			return encontrado;
		}
								
//______________________________________________________________________________________________________________________________________	
//INSERCION
		/*INTERFAZ 
		Prop�sito: insertar un elemento en un array ordenado ascendentemente,
				   unidimensional, de enteros y de tama�o N donde no se permiten elementos repetidos. 
		Entradas: un array, el elemento a insertar (dato) y posici�n de la �ltima casilla
				  con dato v�lido. 
		Precondiciones: el array debe estar ordenado. Por tanto, es responsabilidad del
						programa que llama, asegurarse que se cumplen la precondici�n antes de realizar la
						llamada. 	 
		Salida: un entero y el mismo array modificado si se insert� con �xito.
		Postcondiciones: asociado al nombre de la funci�n se dispone de �1 si no se ha 
							 insertado satisfactoriamente � la nueva longitud del array en otro caso. 
		
		PSEUDOC�DIGO 	 
		entero insertarOrden(entero array[],entero dato, Entero ultCas)
		Inicio 
			entero i, s, nuevaLong = -1 //fracaso
			
			para (i=0; array[i]<dato && i<ultCas; i++)
			finpara //i queda en el lugar de inserci�n, o donde se	encuentra el dato buscado
				Si (array[i]!=dato) 
					Para (s = ultCas; s>=i; s--)
						array[s+1] = array[s]; 
					finPara 		  
					array[i]=dato;
					ultCas++; //se actualiza la �ltima casilla con dato v�lido 
					nuevaLong = ultCas;  //�xito 
				Fin_si
			Devolver (nuevaLong) 
		fin InsertarOrden 
		*/
		public int insertarOrden(int array[], int dato, int ultCas){
			int i, s, nuevaLong = -1; //fracaso
			
			for(i=0;array[i]<dato && i<ultCas;i++){
				
			}
			if(array[i]!=dato){
				array=aumentaLongitud(array,1);
				//pintaArray(array);
				for(s=ultCas;s>=i;s--){					
					array[s+1]=array[s];
				}
				System.out.println("");				
				array[i]=dato;
				//pintaArray(array);
				ultCas++;//se actualiza la �ltima casilla con dato v�lido 
				nuevaLong=ultCas; //�xito 
			}
			return nuevaLong;
		}

//____________________________________________________________________________________________________________________________

		
		public int[] aumentaLongitud(int[] array,int cant){
			int[]nArray=new int[array.length+cant];
			
			for(int i=0;i<array.length;i++){
				nArray[i]=array[i];
			}
			
			return nArray;
		}
		
		
//____________________________________________________________________________________________________________________________
		
		
		
		/*
		rapido(entero lista[ ], primero, ultimo)
		entero puntoParticion 
		si (primero < ultimo)
		 	/*divide el array seg�n las especificaciones de
			partir dejando puntoParticion en su sitio*/
			/*puntoParticion = partir(lista, primero, ultimo)
					//ordena las dos mitades.
					<rapido> (lista, primero, puntoParticion - 1)
					<rapido> (lista, puntoParticion + 1, ultimo) 
		finsi
		fin rapido*/
		
		
		
		
		
		//PSEUDOC�DIGO DE LA FUNCI�N PARTIR 
		 
		//entero partir (entero tabla[ ], ppio, fin)  
				/* Estas dos variables no son necesarias, se usan  
				para que el algoritmo sea m�s f�cil de leer, i
				recorre el array de  arriba hacia abajo, o de
				izquierda a derecha , y j desde abajo hacia arriba, o
				de derecha a izquierda */ 
		//entero valorParticion, i, j, aux
				/* Se elige por comodidad como valor de partici�n el 
				elemento que se encuentra en la primera casilla */
		//valorParticion = tabla[ppio] 
				/*En el siguiente Para no aparece la variaci�n de los
				�ndices porque se incrementan o decrementan dentro */ 
		//Para(i = ppio+1, j = fin; mientras (i< j); )
				/* A continuaci�n, se saltan todos los elementos del 
				array que sean menores o iguales a valorParticion
				empezando por la primera casilla. Se utiliza la
				segunda condici�n i<j para controlar el
				desbordamiento de rango del array y para que no se
				crucen los �ndices  */ 
		//Para( ;mientras((tabla[i]<=valorParticion)Y(i<j));i++) 
		//Finpara
				/* i apunta al primer elemento encontrado mayor que 
				valorPartici�n */
				/* Se saltan todos los elementos que son mayores que 
				valorParticion empezando por la �ltima casilla */
		//Para( ;mientras((tabla[j]>valorParticion)Y(i<j));j--) 
		  
		 
		//Finpara
				/*j apunta al primer elemento que ha encontrado menor 
				o igual que valorPartici�n, salvo cuando i =j */ 
				/* A continuaci�n intercambiamos el primer elemento
				encontrado mayor que valorParticion, tabla [i], con
				el primer elemento encontrado menor, tabla[j]*/ 
				 /*Se podr�a a�adir un if para intercambiar s�lo en el
				caso en que i sea distinto de j, pero ser�an
				iguales s�lo una vez en cada llamada, por tanto, no
				vale la pena. Incluir el if ir�a en detrimento de
				la velocidad de ejecuci�n del algoritmo */ 
			//aux = tabla [ i ]      
			//tabla [ i ] = tabla [ j ]     
			//tabla [ j ] = aux            
		//FinPara
				 /* Decrementamos i puesto que se ha quedado apuntando 
				a la misma casilla que j y debemos llevar
				valorParticion a la casilla anterior a la que ocupa
				el primer valor mayor que �l y devolver la posici�n
				donde se ha colocado */  
		
		//SI (valorParticion <= tabla[i]) 
			//i = i - 1 
		//FINSI
		// Intercambio para poner en su sitio valorParticion.
		//tabla[ppio] = tabla[i]
		//tabla [ i ] = valorParticion
		//Devolver i 
		//FINPartir 
		
		
		
		
		
		
		
		
		
		
		
		
}//Fin utiles








