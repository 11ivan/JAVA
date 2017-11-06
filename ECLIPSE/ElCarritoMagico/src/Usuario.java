
public interface Usuario {
	
	public String getID();
	public String getNombre();
	public String getPassword();
	public String getTipo();
	
	public void setID(String id);
	public void setNombre(String nombre) throws ExcepcionUsuarioImpl;
	public void setPassword(String password) throws ExcepcionUsuarioImpl;
	public void setTipo(String tipo) throws ExcepcionUsuarioImpl;
	
	
}
