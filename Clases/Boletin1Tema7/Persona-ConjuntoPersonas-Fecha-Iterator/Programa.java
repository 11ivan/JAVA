//Programa.java

//javac -Xlint:unchecked yourfilename.java    //Compilar desde consola con esto
//Importamos clase Iterator y se soluciona el warning
import java.util.Iterator;

public class Programa {


    public static void main(String arg[]) {
			Fecha2 fechanac=null;
			Persona p1 =null;
			Persona p2 =null;
			Persona p3 =null;
		
		try{
			fechanac=new Fecha2(2,5,1900);
		}catch(ExcepcionFecha error){
			System.out.println(error);
			}
			
		try{
			p1 = new Persona("Manue", "oju", fechanac, "44556677f", 'h', 78.5, 1.75);
			p2 = new Persona("Pepe", "ji", fechanac, "87456321f", 'm', 60.5, 1.95);
			p3 = new Persona("sdfgbsdfb", "ojdfbdfbu", fechanac, "12345678f", 'h', 55.5, 1.55);
        }catch(ExcepcionPersona error){
			System.out.println(error);
			}
		
		
		Persona[] pp = {p1,p2,p3};
        ConjuntoPersonas cp = new ConjuntoPersonas(pp);
        
        //ejemplo con for
        /*for (Persona p : cp){
			System.out.println("La persona con id: "+p.getID()+" tiene una edad de:"+p.getAge()); 		
		}*/
		
		//ejemlo con while
		Iterator<Persona> it1 = cp.iterator();
        while (it1.hasNext()){
            Persona tmp = it1.next();
            System.out.println("La persona:"+tmp.getID()+" tiene una edad de:"+tmp.getAge());
		}
		
		
		
		
		
	} 
}
