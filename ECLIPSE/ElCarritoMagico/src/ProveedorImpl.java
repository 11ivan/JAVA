/*
 * Propiedades:
 * 		Nombre: Basica, cadena, consultable, modificable
 * 		ID: Basica, cadena, consultable, modificable
 * 
 * */
public class ProveedorImpl implements Proveedor {
	
	private String id;
	private String nombre;
	
	public ProveedorImpl(){
		id="0";
		nombre="default";
	}
	
	public ProveedorImpl(String id, String nombre){
		this.id=id;
		this.nombre=nombre;
	}
	
	public String getID(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	
	public void setID(String id){
		this.id=id;
	}
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	
	
}
