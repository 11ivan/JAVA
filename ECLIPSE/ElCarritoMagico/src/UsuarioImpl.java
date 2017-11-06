/* UsuarioImpl.java
 * 
 * Propiedades: 
 * 	ID: Basica, cadena, consultable, modificable
 *  Nombre:  Basica, cadena, consultable, modificable
 *  Password:  Basica, cadena, consultable, modificable
 *  Tipo:  Basica, cadena, consultable, modificable
 * 
 * 
 * 
 * 
 * 
 * 
 */
class UsuarioImpl implements Usuario{
	private String id;
	private String nombre;
	private String password;
	private String tipo;
	
	
	//Constructores
	public UsuarioImpl(){
		id=" ";
		nombre=" ";
		password=" ";
		tipo=" ";
	}
	
	
	public UsuarioImpl(String id, String nombre, String password, String tipo) throws ExcepcionUsuarioImpl{
		this.id=id;
		
		if(nombre.replaceAll(" ", "").length()<3){
			throw new ExcepcionUsuarioImpl("El nombre debe tener una longitud de al menos 3 carácteres");
		}else{
			this.nombre=nombre;
		}
		
		if(password.length()<8){
			throw new ExcepcionUsuarioImpl("La contraseña debe tener una longitud de 8 carácteres");
		}else{
			this.password=password;
		}
		if(!tipo.equalsIgnoreCase("Cliente") && !tipo.equalsIgnoreCase("Operario")){
			throw new ExcepcionUsuarioImpl("El tipo debe ser 'Cliente' u 'Operario'");
		}else{
			this.tipo=tipo;
		}
	}
	
	
	//Consultores
	public String getID(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	
	
	//Modificadores
	public void setID(String id){
		this.id=id;
	}
	
	public void setNombre(String nombre) throws ExcepcionUsuarioImpl{
		if(nombre.replaceAll(" ", "").length()<3){
			throw new ExcepcionUsuarioImpl("El nombre debe tener una longitud de al menos 3 carácteres");
		}else{
			this.nombre=nombre;
		}
	}
	
	public void setPassword(String password) throws ExcepcionUsuarioImpl{
		if(password.length()<8){
			throw new ExcepcionUsuarioImpl("La contraseña debe tener una longitud de 8 carácteres");
		}else{
			this.password=password;
		}
	}
	
	public void setTipo(String tipo) throws ExcepcionUsuarioImpl{
		if(!tipo.equalsIgnoreCase("Cliente") && !tipo.equalsIgnoreCase("Operario")){
			throw new ExcepcionUsuarioImpl("El tipo debe ser 'Cliente' u 'Operario'");
		}else{
			this.tipo=tipo;
		}

	}
	
	
	//------------------------------------------------------------------------------------------------------
	//criterio de igualdad
	//Dos usuarios son iguales si tienen el mismo nombre
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj!=null && obj instanceof UsuarioImpl){
			UsuarioImpl usuario=(UsuarioImpl) obj;
			
			if(this.nombre.equalsIgnoreCase(usuario.getNombre())){
				iguales=true;						
			}
		}
		
		return iguales;
	}
	
	
	//-------------------------------------------------------------------------------------------------------
	//Orden natural
	/*@Override
	public int compareTo(UsuarioImpl usuario){
		int comparacion=0;
		
		if()
		
		
		
		return comparacion;
	}*/
	
}
