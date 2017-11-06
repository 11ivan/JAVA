//CopyCharacters.java
//Ejemplo de uso de FileReader y FileWriter

import java.io.*;
import java.util.*;

public  class  CopyCharacters{
	public static void main(String[] args){
		File ficheroleido=new File("prueba.txt");
		File ficherocopiado=new File("characteroutput.txt");
		FileReader fr = null;
		FileReader fr2=null;
		FileWriter fw = null; 
		FileWriter fw2=null;
		
		try{
			if(!ficheroleido.exists()){//Si no existe el archivo a leer lo crea
				fw2=new FileWriter(ficheroleido);
			}
			fr = new FileReader(ficheroleido);//LECTOR DE ficheroleido
			fw = new FileWriter(ficherocopiado);//SE CREA EL FICHERO DE COPIA
			int c;//CONTROLA EL FIN DE FICHERO
			c = fr.read();//ASIGNAMOS AL ENTERO EL VALOR ASCII DEL CARACTER QUE LEEMOS
			while (c!= -1){ 
				fw.write(c);
				c = fr.read();
			}
		}catch(IOException error){
			error.printStackTrace();
		} 
			
			try {
				fr.close(); 	
				
				if(fw2!=null){//SI NO HEMOS USADO EL ESCRITOR DEL FICHERO COPIADO
					fw2.close();
				}
				
				fw.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}						
		
		//ESTA PARTE LA USAMOS PARA LEER AMBOS FICHEROS E IMPRIMIRLOS EN PANTALLA
		try{
			fr=new FileReader(ficheroleido);
			fr2=new FileReader(ficherocopiado);
		}catch(IOException error){
			error.printStackTrace();
		}
		
		
		int c2=-1;
		int c=-1;
	
		try {
			c=fr2.read();
			c2=fr.read();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		while(c!=-1){
			System.out.println("El fichero leido es "+(char)c);
			System.out.println("El fichero copiado es "+(char)c2);
			System.out.println("");
			try {
				c=fr2.read();
				c2=fr.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
		
		
		
		try {
			fr.close();
			fr2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//BORRA EL FICHEROCOPIADO
		//ficherocopiado.delete();
		
	}//FIN MAIN
}
