
public class Busqueda {

	/*INTERFAZ
	Prop�sito: localizar un elemento en un array unidimensional de elementos enteros de tama�o N.
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
