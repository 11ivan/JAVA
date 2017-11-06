
import java.io.File;

public class testUtil {
	public static void main(String[] args) {
		
		Util util=new Util();
		String rutaFichero="archivo.txt";
		File fichero=new File(rutaFichero);
		
		String cadena="Escribe esto";
		
		
		System.out.println(util.escribeFichero(fichero, cadena));

	}

}
