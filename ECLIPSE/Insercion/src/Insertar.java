
public class Insertar {

	/*INTERFAZ 
	Propósito: insertar un elemento en un array ordenado ascendentemente,
			   unidimensional, de enteros y de tamaño N donde no se permiten elementos repetidos. 
	Entradas: un array, el elemento a insertar (dato) y posición de la última casilla
			  con dato válido. 
	Precondiciones: el array debe estar ordenado. Por tanto, es responsabilidad del
					programa que llama, asegurarse que se cumplen la precondición antes de realizar la
					llamada. 	 
	Salida: un entero y el mismo array modificado si se insertó con éxito.
	Postcondiciones: asociado al nombre de la función se dispone de –1 si no se ha 
						 insertado satisfactoriamente ó la nueva longitud del array en otro caso. 
	
	PSEUDOCÓDIGO 	 
	entero insertarOrden(entero array[],entero dato, Entero ultCas)
	Inicio 
		entero i, s, nuevaLong = -1 //fracaso
		
		para (i=0; array[i]<dato && i<ultCas; i++)
		finpara //i queda en el lugar de inserción, o donde se	encuentra el dato buscado
			Si (array[i]!=dato) 
				Para (s = ultCas; s>=i; s--)
					array[s+1] = array[s]; 
				finPara 		  
				array[i]=dato;
				ultCas++; //se actualiza la última casilla con dato válido 
				nuevaLong = ultCas;  //éxito 
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
			ultCas++;//se actualiza la última casilla con dato válido 
			nuevaLong=ultCas; //éxito 
		}
		return nuevaLong;
	}






}
