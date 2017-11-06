
public interface Profesor extends Persona {
	
	//Consultores
	public String getMateria();
	
	public Fecha2 getFechaCont();
	
	//Modificadores
	public void setMateria(String materia)throws ExcepcionProfesor;
	
	public void setFechaCont(Fecha2 fechaCont);

	//Derivadas
	//Antig�edad
	public int getAntiwedad();

	
	//M�todos Sobrescritos
	@Override
	public String toString();
	
	@Override
	public int hashCode();
	
	@Override
	public boolean equals(Object o);
	
}
