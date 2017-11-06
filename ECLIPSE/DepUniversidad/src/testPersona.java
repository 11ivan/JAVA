//testPersona.java

public class testPersona{
	public static void main(String[] args){
		
	//	Profesor p1=new Profesor();
	//	Profesor clonado=null;
	//	clonado=(Profesor) p1.clone();
		
		//System.out.println(p1.toString());
	//	System.out.println(clonado.toString());
		
		Persona prueba=null;
		Persona persona=null;
		Persona persona2=new Persona();
		String cadena;
		boolean iguales=false;
		int comparacion;
		Fecha2 fechanac=null;
		Persona copiapersona=new Persona();
		
		
		try{
			fechanac=new Fecha2(3,2,2016);
		}catch(ExcepcionFecha error){
			System.out.println(error);
		}	
		//System.out.println(prueba.toString());
		try{
			prueba=new Persona("Pepe", "Castro", fechanac, "H", "47391688");
		}catch(ExcepcionPersona e){
			e.printStackTrace();
		}
		System.out.println(prueba.toString());
		
		//Prueba equals
		/*iguales=persona.equals(persona2);
		System.out.println(iguales);
		persona2.setNombre("Manuel");
		System.out.println(persona2.getNombre());
		iguales=persona.equals(persona2);
		System.out.println(iguales);
		System.out.println("/////////////////////////////////");*/
		
		
		//Prueba compareTo, setter y getter de apellido
		//devuelve 0
		System.out.println("Apellido persona "+persona.getApellido()+", apellido persona2 "+persona2.getApellido());
		comparacion=persona.compareTo(persona2);
		System.out.println(comparacion);
		//devuelve 1
		persona.setApellido("Alvarez");
		System.out.println("Apellido persona "+persona.getApellido()+", apellido persona2 "+persona2.getApellido());
		comparacion=persona.compareTo(persona2);
		System.out.println(comparacion);
		//devuelve -1
		persona.setApellido("Stark");
		System.out.println("Apellido persona "+persona.getApellido()+", apellido persona2 "+persona2.getApellido());
		comparacion=persona.compareTo(persona2);
		System.out.println(comparacion);
		System.out.println("/////////////////////////////////");
		
		System.out.println(persona.getNombre());
		persona.setNombre("Pepe");
		System.out.println(persona.getNombre());
		System.out.println("/////////////////////////////////");
		
						
		//Consulta fecha nacimiento
		System.out.println("Consulta fecha nacimiento");
		System.out.println(persona.getBirthDate());
		
		System.out.println("Set de fecha de nacimiento");
		
		persona.setBirthDate(fechanac);
		System.out.println(persona.getBirthDate());
		System.out.println("/////////////////////////////////");
		
		//Consulta de derivada edad
		System.out.println("Consulta edad");
		System.out.println(persona.getAge());
		System.out.println("/////////////////////////////////");
		
		//Consulta y modificacion dni		
		/*System.out.println(persona.getDNI());
		try{
			persona.setDNI("58796219L");
		}catch(ExcepcionPersona error){
				System.out.println(error);
		}
		
		System.out.println(persona.getDNI());
		System.out.println("/////////////////////////////////");*/
		
		//consulta y modificacion sexo
		System.out.println(persona.getSexo());
		try{
			persona.setSexo("P");
		}catch(ExcepcionPersona error){
				System.out.println(error);
			}
		System.out.println(persona.getSexo());
		System.out.println("/////////////////////////////////");
		
		
		//consulta y modificacion Peso
		/*System.out.println(persona.getPeso());
		persona.setPeso(85.40);
		System.out.println(persona.getPeso());
		System.out.println("/////////////////////////////////");
		
		//consulta y modificacion de Altura
		System.out.println(persona.getAltura());
		persona.setAltura(1.75);
		System.out.println(persona.getAltura());
		System.out.println("/////////////////////////////////");
		*/
		//Prueba toString 
		cadena=persona.toString();
		System.out.println(cadena);
		System.out.println("/////////////////////////////////");
		
		//Prueba clone
		cadena=copiapersona.toString();
		System.out.println("copiapersona creado por defecto: "+cadena);
		
		cadena=persona.toString();
		System.out.println("persona a clonar: "+cadena);		
		
		copiapersona=persona.clone();
		cadena=copiapersona.toString();
		System.out.println("copiapersona clonado: "+cadena);
		
		copiapersona=persona.clone();
		System.out.println("/////////////////////////////////");
		
		//hashcode
		System.out.println("Hashcode: "+persona.hashCode());
		System.out.println("/////////////////////////////////");
		
		
		//Prueba excepciones
		/*try{
			persona.setEdad(0);
			}catch(ExcepcionPersona error){
				System.out.println(error);
			}*/
			
		/*try{
			persona.setDNI("47391688G");
			/*persona.setDNI("1234567890");
			persona.setDNI("12345678?");
			persona.setDNI("123456");
			persona.setDNI("g5777444H");
		}catch(ExcepcionPersona error){
			System.out.println(error);
			}*/
		
		
		/*try{
			persona.setSexo('M');
			persona.setSexo('S');
			persona.setSexo('H');
			persona.setSexo('D');
			persona.setSexo('X');
			}catch(ExcepcionPersona error){
					System.out.println(error);
				}*/
		
	}
	

}
