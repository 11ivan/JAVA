


public interface Persona {
			
	//Consultores
	public String getNombre();
	
	public String getApellido();
	
	public String getDNI();
	
	public String getSexo();
	
	public Fecha2 getBirthDate();
	
	
	//Modificadores
	
	public void setNombre(String nombre);
	
	public void setApellido(String apellido);
		
	public void setDNI(String dni) throws ExcepcionPersona;
	
	public void setSexo(String sexo) throws ExcepcionPersona;
	
	public void setBirthDate(Fecha2 fechanac);
	
	
	//Derivadas	
	//Edad
	public int getAge();
	
	//calculaLetra
	public Character calculaLetra(String dni);
		

}
