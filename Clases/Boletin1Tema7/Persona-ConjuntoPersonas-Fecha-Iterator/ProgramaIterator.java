//ProgramaIterator.java

import java.util.Iterator;

public class ProgramaIterator{
    public static void main(String arg[]){
		
            ConjuntoPersonas conjuntopersonas=new ConjuntoPersonas();
            Iterator<Persona> iterador;//Objeto tipo Iterator
            Persona personatemporal; // Este objeto nos servirá para guardar temporalmente objetos Persona
			Fecha2 fechanac=null;
			Persona p1 = new Persona("Paco", "Mer", "12345678b", fechanac, 'h', 78.5, 1.69);
			//Persona p1 =new Persona();
			Persona p2 =new Persona();
			Persona p3 =new Persona();
		
			try{
				fechanac=new Fecha2(2,5,1900);
			}catch(ExcepcionFecha error){
				System.out.println(error);
				}
				
			/*try{
				
				p2 = new Persona("James", "Bond","87456321f", fechanac,  'h', 98.5, 1.95);
				p3 = new Persona("Shin", "Shampu","12345678f", fechanac,  'm', 55.5, 1.55);
				p1.setDNI("44556677f");
			}catch(ExcepcionPersona error){
				System.out.println(error);
				}*/
			
			System.out.println(p1.toString());
			//Añadimos las personas al Array
            conjuntopersonas.getConjuntoPersonas().add(p1);
            conjuntopersonas.getConjuntoPersonas().add(p2);
            conjuntopersonas.getConjuntoPersonas().add(p3);
            
            System.out.println("Lista antes de recorrer/eliminar: "+conjuntopersonas.getConjuntoPersonas());
            
            iterador = conjuntopersonas.iterator();
            while (iterador.hasNext()){
                personatemporal = iterador.next();
                if (personatemporal.getAltura()<1.70){
					iterador.remove();
					} //  it.remove() elimina la persona de la colección
            }
            System.out.println("Lista despues de recorrer/eliminar: " + conjuntopersonas.toString());
      }  
}
