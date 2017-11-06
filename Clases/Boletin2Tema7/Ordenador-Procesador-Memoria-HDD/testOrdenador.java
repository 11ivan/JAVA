//testOrdenador.java
import java.util.Scanner;


public class testOrdenador{
	public static void main(String[] args){
		
		Memoria memoria=new Memoria();
		Procesador procesador=new Procesador();
		HDD hdd =new HDD();
		Ordenador ordenador=new Ordenador();		
		
		//Consultar todos los objetos por defecto
		System.out.println("Por defecto Memoria "+memoria.getTipo()+", "+memoria.getVelocidad()+"\n"+memoria.getSize());
		System.out.println("Por defecto Procesador "+procesador.getModelo()+", "+procesador.getVelocidad()+"\n");
		System.out.println("Por defecto HDD "+hdd.getSize()+", "+hdd.getVelocidad()+"\n");
		System.out.println("Por defecto Ordenador: \nMemoria "+ordenador.getMemoria()+"\nProcesador "+ordenador.getProcesador()+"\n"+
		"HDD "+ordenador.getHDD()+"\nPrecio base "+ ordenador.getPrecioBase()+"\n"+"IVA "+ordenador.getIVA()+"\n");
		
		
		//Consultar precio mercado
		System.out.println("Precio mercado: "+ordenador.getPrecioMercado()+"\n");
		
		
		//Modificar procesador memoria y hdd
		memoria.setSize(8);
		memoria.setVelocidad(2400);
		memoria.setTipo("DDR4");
			System.out.println("Por defecto Memoria "+memoria.getTipo()+", "+memoria.getVelocidad()+"\n"+memoria.getSize());

		
		
	}
}


