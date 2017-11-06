import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class prueba2 {
	public static void main(String[] args){
		
		BufferedReader teclado=new BufferedReader(new InputStreamReader(System.in));
		String ruta=".\\src\\texto.txt";
		File archivo=new File(ruta);
		FileWriter fW=null;
		FileReader fR=null;
		BufferedReader bufR=null;
		String introducido;
		String leido=null;
		int finFile;
		
		
		//CREAMOS Y ESCRIBIMOS EN EL ARCHIVO
		try {
			if(!archivo.exists()){
				fW=new FileWriter(archivo);//AQUI SE CREA EL ARCHIVO SI NO EXISTE 
				System.out.println("Introduzca algo");
				introducido=teclado.readLine();
				fW.write(introducido);
				fW.close();
			}else{
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		//LEEMOS EL CONTENIDO ARCHIVO
		try {
			fR=new FileReader(archivo);
			bufR=new BufferedReader(fR);
			try {
				leido=bufR.readLine();//la cadena "leido" recoge todo el contenido hasta que encuentra un retorno de carro    (NO MOLA)
			}catch(IOException e){
				e.printStackTrace();
			}			
			try {
				fR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//PINTAMOS
		System.out.println(leido);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
