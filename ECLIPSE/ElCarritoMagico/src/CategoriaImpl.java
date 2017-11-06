
public class CategoriaImpl implements Categoria {
	private String id;
	private String nombre;
	
	
	
	//Constructores
	public CategoriaImpl(){
		id=" ";
		nombre=" ";
	}
	
	public CategoriaImpl(String id, String nombre){
		this.id=id;
		
		this.nombre=nombre;
	}
	
	//Consultores
	public String getID(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	
	//Modificadores
	public void setID(String id){
		this.id=id;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	
	//----------------------------------------------
	//criterio de igualdad
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj!=null && obj instanceof CategoriaImpl){
			CategoriaImpl categoria=(CategoriaImpl) obj;
			
			if(this.nombre.equalsIgnoreCase(categoria.getNombre())){
				iguales=true;						
			}
		}		
		return iguales;
	}

	//----------------------------------------------
	public String toString(){
		String cadena=id+","+nombre;	
		return cadena;
	}
	
	
}
