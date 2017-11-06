import java.util.ArrayList;

public class ListaPersonas {
	ArrayList<Persona> personas;
	
	
	public ListaPersonas(){
		personas=new ArrayList<Persona>();
	}
	
	public ListaPersonas(ArrayList<Persona> personas){
		for(int i=0;i<personas.size();i++){
			this.personas.add(personas.get(i));
		}
	}
	
	public ArrayList<Persona> getListaPersonas(){
		return personas;
	}
	
	public Persona getPersona(int i){
		//Persona persona=new Persona(personas.get(i));	
		return personas.get(i);
	}
	
	
	
	
}
