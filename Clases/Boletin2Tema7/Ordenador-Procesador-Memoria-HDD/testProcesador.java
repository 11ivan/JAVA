//testProcesador.java


import java.util.Scanner;

public class testProcesador{
	public static void main(String[] args){
		Procesador procesador=new Procesador();
		Procesador copia=new Procesador();
		String cadena;
		Scanner entrada=new Scanner(System.in);
		
		//Cnsulta modifica consulta
		System.out.println(procesador.getModelo());
		System.out.println(procesador.getVelocidad());
		
		System.out.println("Introduzca modelo");
		cadena=entrada.nextLine().replace(" ","");
		procesador.setModelo(cadena);
		
		procesador.setVelocidad(3.2);

		System.out.println(procesador.getModelo());
		System.out.println(procesador.getVelocidad());
		
		//clone
		cadena=procesador.toString();
		System.out.println("A clonar "+cadena);
		
		copia=procesador.clone();
		cadena=copia.toString();
		System.out.println("Clonado "+cadena);
		
		//compareTo
		System.out.println("compareTo "+ procesador.compareTo(copia));//Devuelve 0
		
		procesador.setVelocidad(3.4);
		
		System.out.println("compareTo "+ procesador.compareTo(copia));//Devuelve 1

		procesador.setVelocidad(2.4);
		System.out.println("compareTo "+ procesador.compareTo(copia));//Devuelve -1

		
	}
}
