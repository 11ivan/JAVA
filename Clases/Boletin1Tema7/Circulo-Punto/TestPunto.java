public class TestPunto{
	public static void main(String[ ] args) {
		
		
		//Punto punto1 = new Punto(); //Constructor por defecto
		
		//Punto punto2 = new Punto(3,6); //Constructor sobrecargado
		
		//Punto punto3 = new Punto(punto2); //Constructor de copia
		
		
		Punto p= new Punto(2.0,3.0);
		
		p.mostrar( );
		p.setX(4.0);		
		p.mostrar( );
		p.setY(6.0);
		p.mostrar( );
		System.out.println(p.getOrigen());
	}
}
