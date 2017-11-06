//testTemperaturaTimbre.java
import java.util.Scanner;

public class testTemperaturaTimbre{
	public static void main(String[]args){
		
		Temperatura temp=new Temperatura();
		Timbre timbre=new Timbre();
		Scanner teclado=new Scanner(System.in);
		char ejecuta=' ';
		
		do{
			//Leer y validar ejecuta
			System.out.println("¿Ejecuta? S/N");
			ejecuta=Character.toLowerCase(teclado.next().charAt(0));
		}while(ejecuta!='s' && ejecuta!='n');
		
		
		while(ejecuta!='n'){
			//Mostrar temperatura actual y Leer temperatura maxima
			System.out.println("Temperatura actual: "+temp.getTempActual());
			System.out.println("¿Cuál es la temperatura máxima?");
			temp.setTempMax(teclado.nextDouble());
			
			//Leer temperatura actual
			System.out.println("¿Cuál es la temperatura actual?");
			temp.setTempActual(teclado.nextDouble());

			do{
				//Volver a Leer y validar ejecuta
				System.out.println("¿Volver a ejecutar? S/N");
				ejecuta=Character.toLowerCase(teclado.next().charAt(0));
			}while(ejecuta!='s' && ejecuta!='n');

		}
		
		
	}
}
