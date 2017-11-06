//testMemoria.java


public class testMemoria{
	public static void main(String[] args){
		Memoria memoria= new Memoria();
		
		//Consulta
		System.out.println(memoria.getTipo());
		System.out.println(memoria.getVelocidad());
		
		//Modifica
		memoria.setTipo("DDR3");
		memoria.setVelocidad(2400);
		
		//Consulta
		System.out.println(memoria.getTipo());
		System.out.println(memoria.getVelocidad());

	}
}
