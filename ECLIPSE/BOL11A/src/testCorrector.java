import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class testCorrector {
	public static void main(String[] args){
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Corrector corrector=new Corrector();
		String pass=" ";
		String pathFile=null;
		
		try{
			corrector.setPassword("5555");
		}catch(ExcepcionCorrector error){
			error.printStackTrace();
		}
		
		/*do{
			System.out.println("Introduzca la contraseña");
			try {
				pass=br.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
		}while(!corrector.validaPassword(pass));
		*/
	
		do{
			System.out.println("Introduzca la ruta del archivo que quiere corregir");/*C:users\icastillo\desktop\fileOriginal.txt*/
			try {
				pathFile=br.readLine();
			}catch(IOException e){
				e.printStackTrace();
			}
		}while(!UtilFicheros.validaRutaFile(pathFile));

		
		corrector.correct(pathFile);
		
		
		
		
		
	}
}
