
public class CorrectorPrograma {
	public static void main(String[] arrayArgs) {
		
		GestoraCorrectorProg gestora=new GestoraCorrectorProg();
			
		if(!arrayArgs[0].equals("algo")){
			System.out.println("contraseña incorrecta");
		}else if(!UtilFicheros.validaRutaFile(arrayArgs[1])){
			System.out.println("Ruta no válida");
		}else{
			gestora.correct(arrayArgs[1]);
			System.out.println("Se ha corregido el archivo");
		}
		
	}

}
