//package Ejer1;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/*
 * Clase Profesor
 * 
 * Propiedades Relevantes:
 * 		Fecha contratación: Agregada, Fecha, consultable, modificable
 * 		Materia: Basica, cadena, consultable, modificable.
 * 		ID: Basica, entero, consultable, no modificable.
 * 
 * Propiedades Derivadas:
 * 		Antigüedad:
 * 
 * Propiedades Compartidas:
 * 
 * Interfaz:
 * 	Fecha2 getFechaCont()
 * 	void setFechaCont(Fecha2 fechaCont)
 * 	String getMateria()
 *  void setMateria(String materia)
 *  int getID()
 * 
 */

public class ProfesorImpl extends PersonaImpl implements Profesor, Cloneable, Serializable {
	
	private static final long serialVersionUID = -7196920011701358936L;
	//Propiedades
	private String materia;
	private Fecha2 fechaCont;
	private int ID;
	private static int cont;
	
	//Constructores
	public ProfesorImpl(){
		super();
		materia="Default";
		fechaCont=new Fecha2();
		
	}
	
	public ProfesorImpl(String nombre, String apellido, Fecha2 fechanac, String sexo,String dni, String materia, Fecha2 fechaCont) throws ExcepcionProfesor, ExcepcionPersona{				
		super(nombre, apellido, fechanac, sexo, dni);
				
		if(!materia.toLowerCase().replaceAll(" ", "").equals("programacion") && !materia.toLowerCase().replaceAll(" ", "").equals("basededatos") && !materia.toLowerCase().replaceAll(" ", "").equals("entornosdedesarrollo")){
			throw new ExcepcionProfesor("La materia no es valida");
		}else{
			if(materia.length()>25){
				materia=materia.substring(0, 24);
			}else if(materia.length()<25){
				this.materia=this.rellenaConBlanco(materia, 25);
			}else{
				this.materia=materia;
			}
		}
		
		this.fechaCont=fechaCont;
	}
	
	public ProfesorImpl(ProfesorImpl p){
		super(p);
		this.materia=p.getMateria();
		this.fechaCont=p.getFechaCont();
	}	
	
	//Consultores
	
	public String getMateria(){
		return materia;
	}
	
	public Fecha2 getFechaCont(){
		return fechaCont;
	}
	
	//Modificadores
	
	public void setMateria(String materia)throws ExcepcionProfesor{
		if(!materia.toLowerCase().equals("programacion") && !materia.toLowerCase().equals("base de datos") && !materia.toLowerCase().equals("entornos de desarrollo")){
			throw new ExcepcionProfesor("La materia no es valida");
		}else if(materia.length()>25){
				materia=materia.substring(0, 24);
		}else if(materia.length()<25){
				this.materia=this.rellenaConBlanco(materia, 25);
		}else{
			this.materia=materia;
			}
	}
	
	public void setFechaCont(Fecha2 fechaCont){
		this.fechaCont=fechaCont;
	}

	//Antigüedad
	public int getAntiwedad(){
		int ant;
		Calendar calendario = new GregorianCalendar(); 
			
		ant=(calendario.get(Calendar.YEAR))-(Integer.parseInt(fechaCont.getYear()));
		if(Integer.parseInt(fechaCont.getMonth())-1>calendario.get(Calendar.MONTH) || 
			Integer.parseInt(fechaCont.getMonth())-1==calendario.get(Calendar.MONTH) &&
			Integer.parseInt(fechaCont.getDay())>calendario.get(Calendar.DAY_OF_MONTH)){
			ant--;
		}
		return ant;
	}

	
	//Métodos Sobrescritos
	@Override
	public String toString(){
		String s;
		s=super.toString()+","+materia+","+fechaCont.toString()+"\n";
		return s;
	}
	
	@Override
	public int hashCode() {
		int codigo = 0;
			codigo=getNombre().hashCode();
		return codigo;
	}
	
	
	@Override
	public boolean equals(Object o) {
		boolean igual = false;

		if (o != null && o instanceof ProfesorImpl) {
			ProfesorImpl profesor = (ProfesorImpl) o;
			if (super.equals(profesor) && this.materia.equals(profesor.getMateria()) && this.fechaCont.equals(profesor.getFechaCont())) {
				igual = true;
			}
		}
		return igual;
	}
	
	/*@Override
	public Profesor clone(){
		Profesor copia = null;
		try {
			copia = (Profesor) super.clone();
			System.out.println("Profesor clonado con exito");
		} catch (CloneNotSupportedException error) {
			System.out.println("Profesor no clonado");
		}
		return copia;
	}*/

	/*@Override
	public int compareTo(Profesor p) {
		int compara = 0;
			if(this.getEdad()>p.getEdad()){
				compara = 1;
			}else{
				if(this.getEdad()<p.getEdad()){
					compara = -1;
				}
			}
		return compara;
	}*/
	
	
	
	
}
