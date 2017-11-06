/*
 * Clase para testear la gestora.
 */
public class TestGestora {
	public static void main(String[] args){
		GestoraProgPrinc gestor=new GestoraProgPrinc();
		
		Profesor p1=null;
		
		try {
			p1 = new Profesor("Manuel","Parra", new Fecha2(1,2,1980), "M", "12345678", "Programacion", new Fecha2(6,5,2010));
		} catch (ExcepcionProfesor e) {
		} catch (ExcepcionPersona e) {
		} catch (ExcepcionFecha e) {
			System.out.println(e);
		}
		
		
		System.out.println(p1.toString());
		
		//Agregar Profesor
		System.out.println("Agregar Profesor: ");
		System.out.println(gestor.addProfesor(p1));
		
		//Listar Profesores
		System.out.println("Listar Profesores: ");
		gestor.leeProfesores();
		
		//Borrar Profesor
		//System.out.println("Borrar Profesor:  (en este caso el que se metio antes)");
		//System.out.println(gestor.dropProfesor("12345678Z"));
		
		//Contar Profesores
		System.out.println("Numero de profesores registrados:");
		System.out.println(gestor.cuentaProfesores());
	}
}
