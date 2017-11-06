
public class testClaseCadena {
	public static void main(String[] args){
		
		Cadena cadena=new Cadena();
		try{
			cadena.setCadena("Ke pasa crack, tocando las matrices o ke");
		}catch(excepcionCadena error){
			System.out.println(error);
		}
		
		
		//System.out.println(cadena.getCadena());
		
		//Metodo primeroMayusc
		/*cadena.primeroMayusc();		
		System.out.println(cadena.getCadena());
		*/
		
		//Metodo dropSpace
		/*cadena.dropSpace();
		System.out.println(cadena.getCadena());
		*/
		
		//Metodo matrixWord
		cadena.matrixWord();				
		
		
		
		//Metodo reverseString
		/*cadena.reverseString();
		System.out.println(cadena.getCadena());
		*/
		
		
		//Metodo formPlural
		/*try{
			cadena.formPlural();
		}catch(excepcionCadena error){
			System.out.println(error);
			}		
		System.out.println(cadena.getCadena());
		*/
		
		//Metodo capicua
		//System.out.println(cadena.capicua());
		
		
		
		
		
		
		
		
		
		
	}
}
