//ConjuntoPersonas.java

/*
 Propiedades:
	- 
  
  
  
  
  
  
  
  
 
  
  
  
  
  
  
  
  
  
 */

import java.util.ArrayList;
import java.util.Iterator;

public class ConjuntoPersonas implements Iterable<Persona>{
	
	//private Persona[] grupo;
	private ArrayList<Persona> conjuntopersonas = null;  // atributo de la clase
	

	//Constructores
    public ConjuntoPersonas(){
		conjuntopersonas = new ArrayList<Persona>();
	}  // Constructor de la clase
	
	/*public ConjuntoPersonas(Persona[] grupo){
		this.grupo=grupo;
	}*/
	
	//Consultor
	public ArrayList<Persona> getConjuntoPersonas(){
		return conjuntopersonas;
	}
	
	//toString
	@Override
    public String toString(){
		return conjuntopersonas.toString();
	} 
	
	//Metodo iterator
	@Override
	public Iterator<Persona> iterator(){
		Iterator it= new MiIterator();
		return it;
	}
	
	
	
	/*Para poder devolver un objeto de tipo Iterator (que es algo a lo que al fin y al cabo nos obliga la interface Iterable)
	  necesitamos instanciar un objeto Iterator y esto no podemos hacerlo directamente. Para resolver este problema, recurrimos
	  a definir una clase interna dentro de la clase ConjuntoPersonas denominada MiIterator, que implementará la interface Iterator,
	  y que por tanto nos permitirá devolver una instancia de Iterator para nuestra clase Persona.*/
	
	
	protected class MiIterator implements Iterator<Persona> {//clase interna
		
		private int posicion=0;
		private boolean sepuedeeliminar=false;
		
		
		//Constructor
		public MiIterator(){
			posicion=0;
		}
		

		@Override
        public boolean hasNext(){
			return posicion<conjuntopersonas.size();
		}  	
		
        
        public Persona next(){
			Persona pers =null;// Creamos un objeto Persona igual al que recorremos
			if(posicion>conjuntopersonas.size()){
				System.out.println("No hay mas elementos");
				sepuedeeliminar = false;
				}else{
					pers = conjuntopersonas.get(posicion); 
					posicion ++;
					sepuedeeliminar = true;
					}            
            return pers;
        }
            
            
        @Override
        public void remove()throws UnsupportedOperationException{
            if (sepuedeeliminar){
                conjuntopersonas.remove(posicion-1);
                posicion--;
                sepuedeeliminar = false;
               }else{
					throw new UnsupportedOperationException("No soportado");
				   }
        }	
        	
	} //Fin clase MiIterator
	
	

	
	
	
	
}
