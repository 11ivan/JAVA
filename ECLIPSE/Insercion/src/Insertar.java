
public class Insertar {

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
			for(s=ultCas;s>=i;s--){
				array[s+1]=array[s];
			}
			array[i]=dato;
			ultCas++;//se actualiza la �ltima casilla con dato v�lido 
			nuevaLong=ultCas; //�xito 
		}
		return nuevaLong;
	}






}
