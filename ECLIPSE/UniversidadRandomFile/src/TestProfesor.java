//package Ejer1;

public class TestProfesor {
	public static void main(String[] args) throws ExcepcionProfesor{
		
		ProfesorImpl p1=null;
		
		try {
			p1 = new ProfesorImpl("Manuel","Parra", new Fecha2("1","2","1980"), "M", "12345678", "Programacion", new Fecha2("6","5","2010"));
		} catch (ExcepcionPersona e) {
			System.out.println(e);
		} catch (ExcepcionFecha e) {
			System.out.println(e);
		}
		//ProfesorImpl p2=new ProfesorImpl("Xio", 65, 'F');
		//ProfesorImpl p3=new ProfesorImpl("Sole", 75, 'F'); 
		//ProfesorImpl p4=new ProfesorImpl("Xarli", 29, 'M');
		
		//ProfesorImpl p10=new ProfesorImpl("Xarli", 29, 'X');
		//ProfesorImpl p11=new ProfesorImpl("Xarli", 95, 'M');
		
		System.out.println(p1.toString());
	//	System.out.println(p2.toString());
	//	System.out.println(p3.toString());
	//	System.out.println(p4.toString());
		
		System.out.println("Modificamos el profesor 4 (El nombre y la edad)");
		p1.setNombre("Carlos");
		System.out.println(p1.toString());
		
	//	System.out.println("Comparamos profesor 4 con el profesor 1");
	//	System.out.println(p4.compareTo(p1));
		
	//Prueba metodo getAntiwedad
	System.out.println(p1.getAntiwedad());
		
	}
}
