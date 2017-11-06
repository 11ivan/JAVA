import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Formatter;
import java.io.FileReader;

public class prueba {
	public static void main(String[] args){
		
		int leido=0;//Lo usaremos para
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String ruta="archivo.txt";//Ruta donde estara nuestro archivo
		File archivo=new File(ruta);
		FileWriter fw=null;
		FileReader fr=null;

		
		
		try{
			fw=new FileWriter(archivo);//Se crea el archivo
			fr=new FileReader(archivo);//Se crea el lector del archivo
		}catch(Exception error){
			error.printStackTrace();
		}
		
		
		//No usar Formatter
		/*
		try{
			Formatter format=new Formatter(ruta);
		}catch(Exception error){
			System.out.println(error);
		}
		*/
		
		
		if(archivo.exists()){
			System.out.println(archivo.getName()+" existe");
		}else{
			System.out.println("No existe");
		}

	
		try{
			fw.write("Esto es lo que es 1");
			fw.close();
		}catch(Exception error){
			error.printStackTrace();
		}
		
		/*try {
			leido=fr.read();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		while(leido!=-1){
			System.out.print((char)leido);
			try {
				leido=fr.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		
		try{
			fw=new FileWriter(archivo,true);
			fr=new FileReader(archivo);
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (Exception e1) {
			e1.printStackTrace();
		}

		
		try {
			fw.write("\nEsto es lo que es2");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		
		try {
			leido=fr.read();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		
		while(leido!=-1){
			System.out.print((char)leido);
			try {
				leido=fr.read();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
