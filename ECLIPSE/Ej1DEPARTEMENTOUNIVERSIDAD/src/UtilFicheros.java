import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.BufferedWriter;
//import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class UtilFicheros {

	
	/*Interfaz
	 * Proposito: Lista el contenido de un directorio
	 * Prorotipo: void listDir(String rutafichero)
	 * Precondiciones: La ruta sera valida
	 * Entradas: Una cadena que sera la ruta 
	 * Salidas: No hay
	 * Postcondiciones: Se lista el contenido del directorio
	 * Restricciones:  
	 * */
	public static void listDir(String rutafichero) throws ExcepcionUtilFicheros{
		File fichero=new File(rutafichero);
		File[] ficheros = fichero.listFiles();//listFiles devuelve un array de ficheros
		//String contenido;
		//contenido=fichero.getAbsolutePath();
		//System.out.println(contenido);
		if(ficheros==null){
			throw new ExcepcionUtilFicheros("No hay ficheros en el directorio");
		}else if(validaRutaDir(rutafichero)){
				for (int x=0;x<ficheros.length;x++){
					  System.out.println(ficheros[x].getName());
					}
			}
	}
	
//______________________________________________________________________________________
	
	/*Interfaz
	 * Proposito: Dada una cadena valida que esta sea la ruta correcta de un directorio
	 * Prorotipo: boolean validaRutaDir(String ruta)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: Un booleano
	 * Postcondiciones: El booleano sera verdadero si la ruta es correcta y falso si no
	 * */
	public static boolean validaRutaDir(String ruta){
		boolean valido=true;
		File fichero=new File(ruta);
		
		if(!fichero.isDirectory()){
			valido=false;
		}	
		return valido;
	}
	
//______________________________________________________________________________________
	
		/*Interfaz
		 * Proposito: Dada una cadena valida que esta sea la ruta correcta de un fichero
		 * Prorotipo: boolean validaRutaFile(String ruta)
		 * Precondiciones: No hay
		 * Entradas: Una cadena
		 * Salidas: Un booleano
		 * Postcondiciones: El booleano sera verdadero si la ruta es correcta y falso si no
		 * */
		public static boolean validaRutaFile(String ruta){
			boolean valido=true;
			File fichero=new File(ruta);
			
			if(!fichero.exists()){
				valido=false;
			}	
			return valido;
		}

	
//______________________________________________________________________________________
	
		/*Interfaz
		 * Proposito: Lista el contenido de un directorio y sus propiedades
		 * Prorotipo: void dirPropierties(String rutafichero)
		 * Precondiciones: La ruta sera valida
		 * Entradas: Una cadena que sera la ruta 
		 * Salidas: No hay
		 * Postcondiciones: Se lista el contenido y las propiedades del directorio
		 * Restricciones:  
		 * */
		public static void dirPropierties(String rutafichero) throws ExcepcionUtilFicheros{
			Calendar calendario = new GregorianCalendar();
			Date fecha=null;
			File fichero=new File(rutafichero);
			File[] ficheros = fichero.listFiles();//listFiles devuelve un array de ficheros

			if(ficheros==null){
				throw new ExcepcionUtilFicheros("No hay ficheros en el directorio");
			}else if(validaRutaDir(rutafichero)){
					System.out.println("Propiedades del directorio consultado");
					  System.out.println("Nombre: "+fichero.getName());
					  System.out.println("Ruta: "+fichero.getAbsolutePath());
					  System.out.println("Escritura: "+fichero.canWrite());
					  System.out.println("Lectura: "+fichero.canRead());
					  System.out.println("Ejecucion: "+fichero.canExecute());
					  System.out.println("Oculto: "+fichero.isHidden());
					  fecha=new Date(fichero.lastModified());//Devuelve milisegundos
					  calendario.setTime(fecha);
					  System.out.println("Ultima modificacion: "+Integer.toString(calendario.get(Calendar.DATE))+"/"+Integer.toString(calendario.get(Calendar.MONTH))+"/"+Integer.toString(calendario.get(Calendar.YEAR)));
					  System.out.println("Tamaño disponible: "+(((fichero.getTotalSpace()/1024)/1024)/1024)+" GB");
					  //System.out.println("Tamaño usado: "+(((fichero.getUsableSpace()/1024)/1024)/1024)+" GB");
					  System.out.println("Tamaño libre: "+(((fichero.getFreeSpace()/1024)/1024)/1024)+" GB");
					  System.out.println("++++++++++++++++++++++++++++++++++++++");

					System.out.println("Contenido del directorio");
					for (int x=0;x<ficheros.length;x++){
						  System.out.println("Nombre: "+ficheros[x].getName());
						  System.out.println("Ruta: "+ficheros[x].getAbsolutePath());
						  System.out.println("Escritura: "+ficheros[x].canWrite());
						  System.out.println("Lectura: "+ficheros[x].canRead());
						  System.out.println("Ejecucion: "+ficheros[x].canExecute());
						  System.out.println("Oculto: "+ficheros[x].isHidden());
						  fecha=new Date(ficheros[x].lastModified());//Devuelve milisegundos
						  calendario.setTime(fecha);
						  System.out.println("Ultima modificacion: "+Integer.toString(calendario.get(Calendar.DATE))+"/"+Integer.toString(calendario.get(Calendar.MONTH))+"/"+Integer.toString(calendario.get(Calendar.YEAR)));
						  System.out.println("Tamaño disponible: "+(((ficheros[x].getTotalSpace()/1024)/1024)/1024)+" GB");
						  //System.out.println("Tamaño usado: "+(((ficheros[x].getUsableSpace()/1024)/1024)/1024)+" GB");
						  System.out.println("Tamaño libre: "+(((ficheros[x].getFreeSpace()/1024)/1024)/1024)+" GB");
						  System.out.println("-----------------------------");
						}
				}
		}

//______________________________________________________________________________________
		
			/*Interfaz
			 * Proposito: Lista el contenido de un directorio y sus propiedades
			 * Prorotipo: void dirPropierties(String rutafichero)
			 * Precondiciones: La ruta sera valida
			 * Entradas: Una cadena que sera la ruta 
			 * Salidas: No hay
			 * Postcondiciones: Se lista el contenido y las propiedades del directorio
			 * Restricciones:  
			 * */
			public static void filePropierties(String rutafichero) throws ExcepcionUtilFicheros{
				Calendar calendario = new GregorianCalendar();
				Date fecha=null;
				File fichero=new File(rutafichero);
				//File[] ficheros = fichero.listFiles();//listFiles devuelve un array de ficheros

				if(!fichero.exists()){
					throw new ExcepcionUtilFicheros("No existe el fichero");
				}else{
						 System.out.println("Nombre: "+fichero.getName());
						 System.out.println("Ruta: "+fichero.getAbsolutePath());
						 System.out.println("Escritura: "+fichero.canWrite());
						 System.out.println("Lectura: "+fichero.canRead());
						 System.out.println("Ejecucion: "+fichero.canExecute());
						 fecha=new Date(fichero.lastModified());//Devuelve milisegundos
						 calendario.setTime(fecha);
						 System.out.println("Ultima modificacion: "+Integer.toString(calendario.get(Calendar.DATE))+"/"+Integer.toString(calendario.get(Calendar.MONTH))+"/"+Integer.toString(calendario.get(Calendar.YEAR)));
						 System.out.println("-----------------------------");
							
					}
			}

//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Recibe una ruta y muestra por pantalla un listado con los ficheros y carpetas contenidos en ella, ordenados alfabéticamente
		 * Prorotipo: void muestraContenido(String ruta)
		 * Precondiciones: La ruta sera valida
		 * Entradas: Una cadena que sera la ruta 
		 * Salidas: No hay
		 * Postcondiciones: Se muestra el contenido del directorio ordenado alfabeticamente
		 * Restricciones:  
		 * */
		public static void showContentSort(String ruta)throws ExcepcionUtilFicheros{
			File fichero=new File(ruta);
			File[] ficheros=fichero.listFiles();
			
			Arrays.sort(ficheros);
			
			if(ficheros==null){
				throw new ExcepcionUtilFicheros("No hay ficheros en el directorio");
			}else if(validaRutaDir(ruta)){
				for(int i=0;i<ficheros.length;i++){
					System.out.println(ficheros[i].getName());
				}
			}
		}
	
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Programa para crear un fichero de texto que contenga las cadenas de caracteres suministradas desde la línea de comandos, una en cada línea del fichero de texto. 
		 * Prorotipo: void writeFile(String ruta, String cadena)
		 * Precondiciones: La ruta sera valida y la cadena a introducir no estará vacía
		 * Entradas: Una cadena que sera la ruta y otra cadena que será la que se introduzca en el fichero de texto
		 * Salidas: No hay
		 * Postcondiciones: Se habrá escrito en el fichero la cadena dada
		 * Restricciones:
		 * */
		public static void writeFile(String ruta,String cadena){
			File fichero=new File(ruta);
			FileWriter fw=null;
			BufferedWriter bw=null;
			
			try {
				if(fichero.exists()){
					fw=new FileWriter(fichero,true);
					bw=new BufferedWriter(fw);
					bw.newLine();
					bw.write(cadena);
				}else{
					fw=new FileWriter(fichero);
					bw=new BufferedWriter(fw);					
					bw.write(cadena);
				}
			} catch (IOException e){
				e.printStackTrace();
			}
			
			try {
				bw.close();
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}		
	
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Comprueba que una cadena no esté vacía
		 * Prorotipo: boolean compruebaCadena(String cadena)
		 * Precondiciones: no hay
		 * Entradas: Una cadena 
		 * Salidas: un booleano
		 * Postcondiciones: el booleano será falso si la cadena está vacía y verdadero si no
		 * Restricciones:  
		 * */
		public static boolean compruebaCadena(String cadena){
			boolean vale=true;
			if(cadena.replace(" ", "").length()==0){
				vale=false;
			}
			
			return vale;
		}
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: realizar unas estadísticas respecto a ficheros de texto.
		 * 			  La ruta de un fichero de texto será pasada desde la línea 
		 * 			  de comando y queremos un listado en pantalla con el número de
		 * 			  palabras de ese fichero, el número de párrafos, el número de
		 *			  caracteres, la media de caracteres por palabra y la media de palabras por párrafo
		 * Prorotipo: void fileStatistics(String ruta)
		 * Precondiciones: no hay
		 * Entradas: Una cadena 
		 * Salidas: 
		 * Postcondiciones: 
		 * Restricciones:  
		 * */
		
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Cuenta el numero de palabras de un fichero de texto
		 * Prototipo: int countWords(String ruta)
		 * Precondiciones: la ruta del fichero será válida
		 * Entradas: Una cadena que es la ruta del fichero de texto
		 * Salidas: Un entero
		 * Postcondiciones: El entero será el numero de palabras que contiene el fichero
		 * Restricciones:  
		 * */
		//
/*		public static int countWords(String ruta){
			File fichero=new File(ruta);
			FileReader fr=null;
			BufferedReader br=null;
			int npalabras=0;
			int ff=0;
			
			try{
				fr=new FileReader(fichero);
				br=new BufferedReader(fr);
			}catch(IOException error){
				error.printStackTrace();
			}
				
			try {
				ff=br.read();
			} catch (IOException error) {
				error.printStackTrace();
			}
			
			if(ff==-1){
				npalabras=0;
			}else{
				npalabras++;
				while(ff!=-1){//FM JP ME HA CAMBIADO EL FF POR 65535!!   cuando lee asi >>>  ff=(char) br.read();
					
					//if(ff!='\r'){
						if(ff==' ' || ff=='\t' || ff=='\n'){    //Si el caracter que leemos despues de \r es un ' ', '\t' o '\n' es que comienza una palabra    //Seguro?
							npalabras++;
						}
					//}
					try{
						ff=br.read();
					}catch(IOException e){
						e.printStackTrace();
					}
				}
			}
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return npalabras;
		}
*/		
		//Aqui usare el metodo split						//MUCHO MEJOR CON DIFERENCIA
		public static int countWords(String ruta){
			File fichero=new File(ruta);
			String cadena=" ";
			FileReader fr=null;
			BufferedReader br=null;
			int npalabras=0;
			//int ff=0;
			String [] array;
			
			try{
				fr=new FileReader(fichero);
				br=new BufferedReader(fr);
			}catch(IOException error){
				error.printStackTrace();
			}
				
			try {
				cadena=br.readLine();
			} catch (IOException error) {
				error.printStackTrace();
			}
			while(cadena!=null){
				
				if(cadena.replace(" ", "").length()!=0){
					array=cadena.split(" ");
					npalabras=npalabras+array.length;
				}
				try{
					cadena=br.readLine();
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
			
			return npalabras;
		}
	
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Cuenta el numero de parrafos de un fichero de texto
		 * Prototipo: int countPara(String ruta)
		 * Precondiciones: la ruta del fichero será válida
		 * Entradas: Una cadena que es la ruta del fichero de texto
		 * Salidas: Un entero
		 * Postcondiciones: El entero será el numero de parrafos que contiene el fichero
		 * Restricciones:  
		 * */
		
		public static int countPara(String ruta){
			File fichero=new File(ruta);
			FileReader fr=null;
			BufferedReader br=null;
			int npara=0;
			String ff=" ";
			
			try{
				fr=new FileReader(fichero);
				br=new BufferedReader(fr);
			}catch(IOException error){
				error.printStackTrace();
			}
				
			try {
				ff=br.readLine();
			} catch (IOException error) {
				error.printStackTrace();
			}
			
			while(ff!=null){
				
				if(ff.replace(" ", "").length()==0){
					npara++;
				}

				try{
					ff=br.readLine();
				}catch(IOException e){
					e.printStackTrace();
				}															//Primero se lee el retorno de carro "\r" y despues el salto de linea "\n"				
			}
			
			try{
				br.close();
				fr.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			
			return npara;
		}				
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Cuenta el numero de caracteres de un fichero de texto
		 * Prototipo: int countChars(String ruta)
		 * Precondiciones: la ruta del fichero será válida
		 * Entradas: Una cadena que es la ruta del fichero de texto
		 * Salidas: Un entero
		 * Postcondiciones: El entero será el numero de caracteres que contiene el fichero
		 * Restricciones:  
		 * */
		public static int countChars(String ruta){
			File fichero=new File(ruta);
			FileReader fr=null;
			BufferedReader br=null;
			int ncar=0;
			int ff=0;
			
			try{
				fr=new FileReader(fichero);
				br=new BufferedReader(fr);
			}catch(IOException error){
				error.printStackTrace();
			}
				
			try {
				ff=br.read();
			} catch (IOException error) {
				error.printStackTrace();
			}
			
			while(ff!=-1){
				
				if(ff!='\r' && ff!=' ' && ff!='\t' && ff!='\n'){//Si el caracter que leemos no es un espacio, tabulador, nueva linea o retorno de carro es que es un caracter
					ncar++;
				}
				
				try {
					ff=br.read();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return ncar;
		}			
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Calcula la media de caracteres por palabra de un fichero de texto
		 * Prototipo: int avgCharPerWord(String ruta)
		 * Precondiciones: la ruta del fichero será válida
		 * Entradas: Una cadena que es la ruta del fichero de texto
		 * Salidas: Un entero
		 * Postcondiciones: El entero será la media de caracteres por palabra que contiene el fichero
		 * Restricciones:  
		 * */
		public static int avgCharPerWord(String ruta){
			int media, npalabras, ncaracteres;
			//File fichero=new File(ruta);
			
			npalabras=countWords(ruta);
			ncaracteres=countChars(ruta);
			
			media=ncaracteres/npalabras;
			
			return media;
		}		
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Calcula la media de palabras por parrafo de un fichero de texto
		 * Prototipo:
		 * Precondiciones: la ruta del fichero será válida
		 * Entradas: Una cadena que es la ruta del fichero de texto
		 * Salidas: Un entero
		 * Postcondiciones: El entero será el numero de caracteres que contiene el fichero
		 * Restricciones:  
		 * */
		public static int avgWordsPerPara(String ruta){
			int media, npalabras, npara;
			//File fichero=new File(ruta);
			
			npalabras=countWords(ruta);
			npara=countPara(ruta);
			
			media=npalabras/npara;
			
			return media;
		}						
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito: Toma un fichero de texto y realiza una copia a otro. Las rutas de ambos archivos son recibidas como parámetros.
		 * Prototipo: void copyFile(String ruta1, String ruta2)
		 * Precondiciones: Las rutas serán válidas
		 * Entradas: Dos cadenas que son las rutas de los archivos  
		 * Salidas: No hay
		 * Postcondiciones: Se habrá copiado el fichero original a otro
		 * Restricciones:  
		 * */
/*		public static void copyFile(String ruta1, String ruta2){
			File original=new File(ruta1);
			File copiado=new File(ruta2);
			FileReader frO=null;
			//FileReader frC=null;
			FileWriter fw=null;
			BufferedReader brO=null;
			//BufferedReader brC=null;
			BufferedWriter bw=null;
			String ff=" ";
			
			try{
				frO=new FileReader(original);
				//frC=new FileReader(copiado);
				brO=new BufferedReader(frO);
				//brC=new BufferedReader(frC);
				fw=new FileWriter(copiado);
				bw=new BufferedWriter(fw);
			}catch(IOException error){
				error.printStackTrace();
			}
			
			try {
				ff=brO.readLine();
			}catch(IOException error){				
				error.printStackTrace();
			}
			
			
			while(ff!=null){
				try {
					bw.write(ff);
					ff=brO.readLine();
				}catch(IOException e){					
					e.printStackTrace();
				}
			}	
			
			try {
				bw.close();
				fw.close();
				brO.close();
				frO.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
*/
		
		public static void copyFile(String rutaFileOriginal, String rutaFileCopia){
			File original=new File(rutaFileOriginal);
			File copiado=new File(rutaFileCopia);
			FileReader frO=null;
			FileWriter fw=null;
			BufferedReader brO=null;
			BufferedWriter bw=null;
			int ff=0;
			
			try{
				frO=new FileReader(original);
				brO=new BufferedReader(frO);
				fw=new FileWriter(copiado);
				bw=new BufferedWriter(fw);
			}catch(IOException error){
				error.printStackTrace();
			}
			
			try {
				ff=brO.read();
			}catch(IOException error){				
				error.printStackTrace();
			}
			
			
			while(ff!=-1){
				try {
					bw.write(ff);
					ff=brO.read();
				}catch(IOException e){					
					e.printStackTrace();
				}
			}	
			
			try {
				bw.close();
				fw.close();
				brO.close();
				frO.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}			
		
//______________________________________________________________________________________
		
		/*Interfaz
		 * Proposito:  Método que reciba la ruta de un archivo de texto y muestre por pantalla
					   los caracteres del alfabeto ordenados según su frecuencia de aparición (primero el carácter que
					   más veces aparece, luego el segundo que más aparece, etc), indicando también el número de
					   veces que aparece cada carácter.  
		 * Prototipo:
		 * Precondiciones: La ruta del fichero debe ser correcta(existe)
		 * Entradas: Una cadena 
		 * Salidas: 
		 * Postcondiciones: 
		 * Restricciones:  
		 * */
		
		
//______________________________________________________________________________________
					//Utiliza ordenación híbrida para ello.
		/*Interfaz
		 * Proposito: Metodo que reciba el nombre de un fichero de texto y cree en el
					  directorio actual un fichero con el mismo nombre añadiendo al final ordenado (por ejemplo, si se 
					  ejecuta sobre fichero.txt, creará ficheroOrdenado.txt, con las mismas palabras que fichero.txt, pero ordenadas alfabéticamente. 
		 * Prototipo: void createOrderfile(String ruta)
		 * Precondiciones: La ruta del fichero debe ser correcta(existe)
		 * Entradas: Una cadena 
		 * Salidas: No hay
		 * Postcondiciones: Se habrá creado un fichero con las mismas palabras que fichero de la ruta dada, pero ordenadas alfabéticamente. 
		 * Restricciones:  
		 * */
		public static void createOrderfile(String ruta){
			ComparatorWord comparator=new ComparatorWord();
			File ficheroOriginal=new File(ruta);
			File ficheroOrdenado=new File("ficheroOrdenado.txt");
			FileReader fr=null;
			BufferedReader br=null;
			FileWriter fw=null;
			BufferedWriter bw=null;
			ArrayList<String> array=new ArrayList<String>();
			String ff=null;
			
			try{
				fr=new FileReader(ficheroOriginal);
			}catch(IOException error){
				error.printStackTrace();
			}
			br=new BufferedReader(fr);			
			
			try {
				ff=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			while(ff!=null){
				String[] aux=ff.split(" ");
				for(int i=0;i<aux.length;i++){
					array.add(aux[i]);
				}
				
				try {
					ff=br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			Collections.sort(array,comparator);
			
			try{
				fw=new FileWriter(ficheroOrdenado);
			}catch(IOException error){
				error.printStackTrace();
			}
			bw=new BufferedWriter(fw);
			
			for(int i=0;i<array.size();i++){
				try {
					bw.write(array.get(i));
					bw.newLine();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
					
			try {
				bw.close();
				fw.close();
				br.close();
				fr.close();
			} catch (IOException e) {				
				e.printStackTrace();
			}
			
		}
	
//______________________________________________________________________________________

		/*Interfaz
		 * Proposito:
		 * Prototipo:
		 * Precondiciones: no hay
		 * Entradas: Una cadena 
		 * Salidas: 
		 * Postcondiciones: 
		 * Restricciones:  
		 */
	
		
//-----------------------------------------------------------------------------------------CORRECTOR
		
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
		public static ArrayList<Character> loadArrayListChar(String rutaFile){
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
			public static void writeFile(ArrayList<Character> array, String rutaFile){
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
			public static void writeFile(ArrayList<Character> array){
				File fichero=new File("Howler.txt");
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
				
		
//______________________________________________________________________________________

	/*Interfaz
	 * Proposito: Crear un Howler a partir de un texto.
	 * Prototipo: void createHowler(String ruta)
	 * Precondiciones: La ruta del archivo será válida(existe)
	 * Entradas: Una cadena que será la ruta del archivo a howlarizar
	 * Salidas: no hay
	 * Postcondiciones: Se habrá creado un archivo con el texto en mayúscula
	 * Restricciones:  
	 */
	public static void createHowler(String ruta){
		ArrayList<Character> array=new ArrayList<Character>();	

		
		//Cargamos el arrayList con lo que contenga el archivo
		array=loadArrayListChar(ruta);
		
		//Pasamos a mayúscula
		for(int i=0;i<array.size()-1;i++){																
			array.add(i, Character.toUpperCase(array.get(i)));
			array.remove(i+1);
		}
		
		//Escribimos en el fichero
		writeFile(array);	
	}
		
		
		
		
		
	
}
