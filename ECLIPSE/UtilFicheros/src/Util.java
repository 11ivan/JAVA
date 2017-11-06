/**
 * 
 */

/**
 * 
 *
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedWriter;

public class Util {

	
	public boolean escribeFichero(File fichero, String cadena){
		boolean escrito=true;
		FileWriter fw=null;
		BufferedWriter bw=null;
		
		if(fichero.exists()){
			try {
				fw=new FileWriter(fichero,true);
				bw=new BufferedWriter(fw);
				bw.newLine();
				bw.write(cadena);
			} catch (IOException e) {
				e.printStackTrace();
				escrito=false;
			}	
		}else{
			try {
				fw=new FileWriter(fichero);
				bw=new BufferedWriter(fw);
				bw.write(cadena);
			} catch (IOException e) {
				e.printStackTrace();
				escrito=false;
			}	
		}	
		
		try {
			fw.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return escrito;
	}
	
	
	
	
	
	
	
	
	
	
	
}
