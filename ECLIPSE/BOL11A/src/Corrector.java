/*
 *Propiedades:
 *		Contraseña: Cadena, Basica, Consutable, modificable. 
 * 
 * Interfaz:
 * 		String getPassword()
 * 		void setPassword(String password)
 * 
 *
 * Funcionalidades:
 * 		 void corrector(String password, String ruta)
 *
 *
 *
 */



import java.io.File;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.FileReader;

public class Corrector {

	private String password;
	
	//Constructores
	public Corrector(){
		password="0000";
	}
	
	public Corrector(String password)throws ExcepcionCorrector{
		if(password.length()!=4){
			throw new ExcepcionCorrector("La contraseña debe tener cuatro caracteres");
		}else{
			this.password=password;
		}
	}
	
	public Corrector(Corrector corrector){
		this.password=corrector.getPassword();
	}
	
	
	public String getPassword(){
		return password;
	}
	
	public void setPassword(String password)throws ExcepcionCorrector{		
		if(password.length()!=4){
			throw new ExcepcionCorrector("La contraseña debe tener cuatro caracteres");
		}else{
			this.password=password;
		}
	}
	
	
	
	//validaPassword
	public boolean validaPassword(String password){
		boolean vale=false;
		if(this.password.equals(password)){
			vale=true;
		}
		return vale;
	}
	
	
	
	 /*Interfaz
	 * Proposito: Dade la ruta de un archivo, corregir las palabras que deben empezar por mayúsculas.
	 * Prototipo: void correct(String password, String ruta)
	 * Precondiciones: La ruta del fichero debe ser correcta(existe) y la contraseña será válida 
	 * Entradas: Una cadena que será la ruta del archivo
	 * Salidas: No hay
	 * Postcondiciones: Se habrá corregido el archivo. 
	 * Restricciones:  
	 */
	public void correct(String ruta){
		File fichero=new File(ruta);
		//File aux=new File("C:\\users\\icastillo\\desktop\\temp.txt");
		FileReader fr=null;
		FileWriter fw=null;
		BufferedReader br=null;
		BufferedWriter bw=null;
		int ff=0;
		//String rutacopia;
		ArrayList<Character> array=new ArrayList<Character>();
		//int contador=0;
			
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
		
		//Corregimos las necesarias
		for(int i=0;i<array.size();i++){

			if(array.get(i)=='.' && array.get(i+1)==' '){
				array.add(i+2, Character.toUpperCase(array.get(i+2)));
			}else if(array.get(i)=='.' && Character.isAlphabetic(array.get(i+1))){
				array.add(i+1, Character.toUpperCase(array.get(i+1)));
			}else if(array.get(i)=='.' && array.get(i+1)=='\r'){
				array.add(i+3, Character.toUpperCase(array.get(i+3)));
			}
		}
		
		//Machacamos el archivo a corregir escribiendo encima

		try{
			fw=new FileWriter(fichero);
		}catch(IOException e){				
			e.printStackTrace();
		}
		bw=new BufferedWriter(fw);

		for(int i=0;i<array.size();i++){
			try{
				bw.write(array.get(i));			
			} catch(IOException e){
				e.printStackTrace();
			}
		}

		try{
			bw.close();
			fw.close();
			br.close();
			fr.close();					
		}catch(IOException e){
			e.printStackTrace();
		}	
	}
	
	
	
	
	
	
	
	
}
