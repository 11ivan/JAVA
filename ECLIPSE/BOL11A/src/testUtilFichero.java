import java.io.File;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class testUtilFichero {
	public static void main(String[] args) throws IOException {
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String pathFile=" ";
		String pathFileCopia=" ";
		//String cadena;
		//String ejecuta;
		pathFile="C:\\users\\anonymous\\Desktop\\fichero.txt";
		pathFileCopia="C:\\users\\icastillo\\Desktop\\fileCopiado.txt";

		
		
	//	pathFile="C:\\Windows\\";//RUTA QUE LE ENVIAREMOS AL SUBPROGRAMA listDir
		
		//LEER Y VALIDAR RUTA Directorio
/*		do{
			System.out.println("Introduzca la ruta del directorio a listar");
			try {
				pathFile=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!UtilFicheros.validaRutaDir(pathFile));
*/	
		
		
		//----Prueba Subprograma listDir----
		//Devuelve los archivos que hay en la ruta especificada
/*		try{
			UtilFicheros.listDir(pathFile);
		}catch(ExcepcionUtilFicheros error){
			error.printStackTrace();
		}
*/
	
		
		//----Prueba Subprograma dirPropierties----
/*		try{
			UtilFicheros.dirPropierties(pathFile);
		}catch(ExcepcionUtilFicheros error){
			error.printStackTrace();
		}
*/		
	
		
		//----Prueba Subprograma filePropierties----
/*		try{
			UtilFicheros.filePropierties(pathFile);
		}catch(ExcepcionUtilFicheros error){
			error.printStackTrace();
		}
*/		
		
		
		//----Prueba Subprograma showContentSort----
/*		try {
			UtilFicheros.showContentSort(pathFile);
		} catch (ExcepcionUtilFicheros e) {
			e.printStackTrace();
		}
*/	
	
		
/*		do{
			//LEER Y VALIDAR RUTA ARCHIVO
			do{
				System.out.println("Introduzca la ruta del fichero a escribir");
				try {
					pathFile=br.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}while(!UtilFicheros.validaRutaFile(pathFile));
	
			do{
				System.out.println("Introduzca lo que quiere escribir en el fichero");
				cadena=br.readLine();
			}while(!UtilFicheros.compruebaCadena(cadena));
	
			
			//----Prueba subprograma writeFile----
			UtilFicheros.writeFile(pathFile,cadena);
			
			do{
				System.out.println("¿Quiere escribir otra cosa?");
				ejecuta=br.readLine().replace(" ", "").toUpperCase();
			}while(!ejecuta.equals("SI") && !ejecuta.equals("NO"));
			
		}while(ejecuta.equals("SI"));
*/
		
		
		//----Prueba subprograma countWords
		//LEER Y VALIDAR RUTA ARCHIVO
/*		do{
			System.out.println("Introduzca la ruta del fichero");
			try {
				pathFile=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!UtilFicheros.validaRutaFile(pathFile));
*/
		//System.out.println(UtilFicheros.countWords(pathFile));

		
		
		
		//----Prueba subprograma countChars----
		//LEER Y VALIDAR RUTA ARCHIVO
/*		do{
			System.out.println("Introduzca la ruta del fichero");
			try {
				pathFile=br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!UtilFicheros.validaRutaFile(pathFile));
*/
		//System.out.println(UtilFicheros.countChars(pathFile));
		
		
		//----Prueba subprograma countPara----     ---Me da el numero de lineas   :(		
		//System.out.println(UtilFicheros.countPara(pathFile));
				
		
		//----Prueba subprograma avgCharPerWord----
		//System.out.println(UtilFicheros.avgCharPerWord(pathFile));
		
		
		//----Prueba subprograma avgWordsPerPara----
		//System.out.println(UtilFicheros.avgWordsPerPara(pathFile));
		
		
		//System.out.println(UtilFicheros.validaRutaFile(pathFile));
		
		
		//----Prueba subprograma copyFile----
		//UtilFicheros.copyFile(pathFile, pathFileCopia);
		
		
		//----Prueba subprograma createOrderfile----
		//UtilFicheros.createOrderfile(pathFile);
		
		
		//----Prueba subprograma createHowlar----
		UtilFicheros.createHowler(pathFile);

		
		
		
	}	
}
