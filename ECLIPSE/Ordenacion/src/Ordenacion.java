

public class Ordenacion {

	//Metodo Burbuja
	/*INTERFAZ 
		Propósito: ordenación ascendente de un array unidimensional de tamaño tam.
		Entradas: un array. En principio también se necesita el tamaño, pero al 
		implementar en Java lo conocemos, por estar implícito al crearlo.
		Precondiciones: el array no debe estar vacío.
		Salida: el mismo array modificado.
		Postcondiciones: array [0], ..., array[tam-1] está ordenado según el criterio de 			
						 ordenación establecido.
		
		PSEUDOCÓDIGO
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
	  SELECCIÓN (entero ARRAY [], entero tam)
		Inicio
			Entero I, J, MÍNIMO
			
			Para (I= 0, mientras I<tam, incremento 1)
				MINIMO = I //bucle para encontrar el elemento más pequeño
				Para (J=I+1, mientras J<tam, incrementa en 1)
					Si(ARRAY[J] < ARRAY[MINIMO])
					MINIMO = J
					Finsi
				Finpara
				
				//intercambio para poner en su lugar el más pequeño
				aux = array[I];
				array[I] = array[MINIMO];
				array[MINIMO] = aux;
			Finpara
		Fin-selección
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
	
	/*INSERCIÓN (entero ARRAY [], entero tam)
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
	Fin-inserción
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
	
	
	
	
	
	
	
	
	
	
	
	
	
}