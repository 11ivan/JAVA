import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GestoraCorrectorProg {
	
	
	
	
	
	 /*Interfaz
	 * Proposito: Dada la ruta de un archivo, corregir las palabras que deben empezar por mayúsculas.
	 * Prototipo: void correct(String password, String ruta)
	 * Precondiciones: La ruta del fichero debe ser correcta(existe) y la contraseña será válida 
	 * Entradas: Una cadena que será la ruta del archivo
	 * Salidas: No hay
	 * Postcondiciones: Se habrá corregido el archivo. 
	 * Restricciones:  
	 */
	
/*	public void correct(String ruta){
		ArrayList<Character> array=new ArrayList<Character>();		
		
		//Cargamos el arrayList con lo que contenga el archivo
		array=loadArrayListChar(ruta);
		
		//Corregimos las necesarias
		for(int i=0;i<array.size()-1;i++){
			if(array.get(i).equals("\r") && array.get(i+1).equals("\n") && array.get(i+2).equals("\r") ){
				i=i+2;
			}else{
				if(i==0){
					char primercar=array.get(i);
					if(Character.toLowerCase(primercar)==array.get(i)){
						array.add(i, Character.toUpperCase(primercar));
						array.remove(i+1);
					}
				}
				if(array.get(i)=='.' && array.get(i+1)==' '){//Cuando se encuentra un punto al final de la linea peta
					array.add(i+2, Character.toUpperCase(array.get(i+2)));
					array.remove(i+3);
				}else if(array.get(i)=='.' && Character.isAlphabetic(array.get(i+1))){				
					array.add(i+1, Character.toUpperCase(array.get(i+1)));
					array.remove(i+2);
				}else if(array.get(i)=='.' && array.get(i+1)=='\r'){				
					array.add(i+3, Character.toUpperCase(array.get(i+3)));
					array.remove(i+4);
				}
			}
		}
		
		//Escribimos en el fichero
		writeFile(array, ruta);
		
	}
*/	//^^^^^^^^^^^^////ERA////^^^^^^^^^^^^
	
	//ES//
	public void correct(String ruta){
		ArrayList<Character> array=new ArrayList<Character>();	
		boolean haypoint;
		boolean sale;
		int vueltas=0;
		
		//Cargamos el arrayList con lo que contenga el archivo
		array=loadArrayListChar(ruta);
		
		//Corregimos las necesarias
		for(int i=0;i<array.size()-1;i++){
			vueltas=0;
			if(i==0){
				char primercar=array.get(i);
				if(Character.toLowerCase(primercar)==array.get(i)){
					array.add(i, Character.toUpperCase(primercar));
					array.remove(i+1);
				}
			}				
			if(array.get(i)=='.'){
				haypoint=true;
			}else{
				haypoint=false;
			}
			if(haypoint==true){				
				sale=false;
				for(int i2=i+1;i2<array.size()-1 && !sale;i2++){//Si en el indice i tenemos el '.' pasamos a mirar la siguiente>>(i2=i+1)   //Salimos del bucle cuando ponemos alguna mayuscula
					if(Character.isAlphabetic(array.get(i2))){																				//o llegamos a la ultima posicion del array -1
						array.add(i2, Character.toUpperCase(array.get(i2)));
						array.remove(i2+1);
						sale=true;
					}else{
						sale=false;
						vueltas++;
					}
				}
			}
			i=i+vueltas;//Sumamos al indice las vueltas nulas que hemos dado(En las que no hay ningun caracter del alfabeto)
		}
		
		//Escribimos en el fichero
		writeFile(array, ruta);		
	}
	
//--------------------------------------------------------------------------------------------------	
	 /*Interfaz
	 * Proposito: Cargar un arrayList de caracteres desde un archivo
	 * Prototipo: void loadArrayListChar(ArrayList<Character> array, String rutaFile)
	 * Precondiciones: La ruta del fichero será válida(existe)
	 * Entradas: Un ArrayList de caracteres, una cadena que es la ruta del fichero
	 * Salidas: No hay
	 * Postcondiciones: Se habrá cargado el arrayList con lo que contenga el archivo
	 * Restricciones:  
	 */
	public ArrayList<Character> loadArrayListChar(String rutaFile){
		FileReader fr=null;
		BufferedReader br=null;
		File fichero=new File(rutaFile);
		int ff=0;
		ArrayList<Character> array=new ArrayList<Character>();;
		
		try {
			fr=new FileReader(fichero);
		}catch(IOException e){				
			e.printStackTrace();
		}
		br=new BufferedReader(fr);

		try {
			ff=br.read();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		while(ff!=-1){		
			//Pasamos el caracter leido al array
			array.add((char)ff);				
			try {
				ff=br.read();
			}catch(IOException e){
				e.printStackTrace();
			}			
		}
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return array;
	}
	
//--------------------------------------------------------------------------------------------------	
		 /*Interfaz
		 * Proposito: Escribir un archivo con lo que contenga un arrayList de caracteres
		 * Prototipo: void writeFile(ArrayList<Character> array, String rutaFile)
		 * Precondiciones: La ruta del fichero será válida(existe)
		 * Entradas: Un ArrayList de caracteres, una cadena que es la ruta del fichero
		 * Salidas: No hay
		 * Postcondiciones: Se habrá escrito el archivo con lo que contenga el arrayList
		 * Restricciones:  
		 */
		public void writeFile(ArrayList<Character> array, String rutaFile){
			File fichero=new File(rutaFile);
			FileWriter fw=null;
			BufferedWriter bw=null;

			//Machacamos el archivo creándolo de nuevo si existe
			try {
				fw=new FileWriter(fichero);
			}catch(IOException e){				
				e.printStackTrace();
			}
			bw=new BufferedWriter(fw);
			
			//Escribimos en el archivo
			for(int i=0;i<array.size();i++){
				try{
					bw.write(array.get(i));			
				} catch(IOException e){
					e.printStackTrace();
				}
			}
			
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			

		}
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

		
	
	
}
