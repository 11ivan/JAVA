

public class Ordenacion {

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
	
	
	
	
	
	
	
	
	
	
	
	
	
}