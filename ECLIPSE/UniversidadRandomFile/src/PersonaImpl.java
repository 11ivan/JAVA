//Persona.java

/**		
 Propiedades:
	- Nombre: Cadena, Basica, Consultable, Modificable
	- Apellido: Cadena, Basica, Consultable, Modificable
	- DNI: Cadena, Basica, Consultable, no modificable
	- Sexo: Caracter, Basica, Consultable, Modificable
	- Fecha nacimiento: Fecha, agregada, consultable,  modificable
	- ID: basica, entero autoincrementable, consultable, no modificable
	- Orden natural: por nombre		//compareTo
	- Criterio de igualdad: si tienen todos los atributos iguales //equals
	- Representacion como cadena:
	
	
 Propiedades derivadas:
	- Edad: Entero, consultable, no modificable
	

 Interfaz: 
	- String getNombre()
	- void setNombre(String nombre)
	- String getApellido()
	- void setApellido(String apellido)
	- String getDNI()
	- char getSexo()
	- void setSexo(char sexo)
	- Fecha getBirthdate()
	- void setBirthdate(Fecha fechanac)
	- int getAge()
	- int getID()

 Funciones:
	- Si es mayor de edad





*/

import java.io.Serializable;
import java.lang.Character;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;

class PersonaImpl implements Persona, Comparable<PersonaImpl>, Cloneable, Serializable {

	private static final long serialVersionUID = 1L;
	private boolean entra=true;
	//private static int contador=0;    //Para codigo autoincrementado
	//private int id;
	private String nombre;
	private String apellido;
	private String dni;
	private String sexo;
	private Fecha2 fechanac;

	
	//Constructores
	public PersonaImpl(){//por defecto
		nombre="default";
		apellido="default";
		dni="default";
		sexo="default";
		fechanac= new Fecha2();
	}
	
	/*public Persona(){//por defecto para id autoincrementado
		id=++contador;
	}*/

	public PersonaImpl(String nombre, String apellido, Fecha2 fechanac, String sexo, String dni) throws ExcepcionPersona{//sobrecargado
		//this();
		if(nombre.length()>20){
			this.nombre=nombre.substring(0, 19);
		}else if(nombre.length()<20){
			this.nombre=this.rellenaConBlanco(nombre, 20);
		}else{
			this.nombre=nombre;
		}
		
		if(apellido.length()>25){
			this.apellido=apellido.substring(0, 24);
		}else if(apellido.length()<25){
			this.apellido=this.rellenaConBlanco(apellido, 25);
		}else{
			this.apellido=apellido;
		}
	
		if(dni.length()!=8){
			entra=false;
			throw new ExcepcionPersona("La longitud del dni debe ser de 8 digitos");
		}else if(entra){
				for(int contador=0; contador<=7 && entra; contador++){
					if(Character.isDigit(dni.charAt(contador))==false){
						entra=false;
						throw new ExcepcionPersona("Los 8 primeros digitos deben ser numeros");					 
					}									
				}
			}
		if(entra){
			this.dni=dni+calculaLetra(dni);//
		}
		
		if(!sexo.toLowerCase().equals("m") && !sexo.toLowerCase().equals("h")){
			throw new ExcepcionPersona("El sexo debe ser (M-H)");
		}else{
			this.sexo=sexo;//
			}
			
		this.fechanac=fechanac;
		
	}
	
	public PersonaImpl(PersonaImpl persona){//de copia
		//this.id=persona.getID();
		this.nombre=persona.getNombre();
		this.apellido=persona.getApellido();
		this.dni=persona.getDNI();
		this.sexo=persona.getSexo();
		this.fechanac=persona.getBirthDate();
	}
	
	//Consultores
	/*public int getID(){
		return id;
	}*/
	
	public String getNombre(){
		return nombre;
	}
	
	public String getApellido(){
		return apellido;
	}	
	
	public String getDNI(){
		return dni;
	}	
	
	public String getSexo(){
		return sexo;
	}	
	
	public Fecha2 getBirthDate(){
		return fechanac;
	}
	
	
	//Modificadores
	
	public void setNombre(String nombre){
		if(nombre.length()>20){
			this.nombre=nombre.substring(0, 19);
		}else if(nombre.length()<20){
			this.nombre=this.rellenaConBlanco(nombre, 20);
		}else{
			this.nombre=nombre;
		}
	}
	
	public void setApellido(String apellido){
		if(apellido.length()>25){
			this.apellido=apellido.substring(0, 24);
		}else if(apellido.length()<25){
			this.apellido=this.rellenaConBlanco(apellido, 25);
		}else{
			this.apellido=apellido;
		}
	}
		
	public void setDNI(String dni) throws ExcepcionPersona{
		if(dni.length()!=8){
			entra=false;
			throw new ExcepcionPersona("La longitud del dni debe ser de 8 digitos");
		}else if(entra){
			for(int contador=0; contador<7 && entra; contador++){
				if(Character.isDigit(dni.charAt(contador))==false){
					entra=false;
					throw new ExcepcionPersona("Los 8 primeros digitos deben ser numeros");					 
				}									
			}
		}
		if(entra){
			this.dni=dni+calculaLetra(dni);//
		}
	}
	
	public void setSexo(String sexo) throws ExcepcionPersona{
		if(!sexo.toLowerCase().equals("m") && !sexo.toLowerCase().equals("h")){
			throw new ExcepcionPersona("El sexo debe ser (M-H)");
		}else{
			this.sexo=sexo;//
		}
	}
	
	
	
	public void setBirthDate(Fecha2 fechanac){
		this.fechanac=fechanac;
	}
	
	
	//Derivadas	
	
	//Edad
	public int getAge(){
		int edad;
		Calendar calendario = new GregorianCalendar(); 
			
		edad=(calendario.get(Calendar.YEAR))-(Integer.parseInt(fechanac.getYear()));
		if(Integer.parseInt(fechanac.getMonth())-1>calendario.get(Calendar.MONTH) || 
			Integer.parseInt(fechanac.getMonth())-1==calendario.get(Calendar.MONTH) &&
			Integer.parseInt(fechanac.getDay())>calendario.get(Calendar.DAY_OF_MONTH)){
			edad--;
		}
		return edad;
	}
	
	
	//Funciones
	//Comprobar mayoria de edad
	/*public boolean mayordeEdad(){
		boolean mayor=false;
		
		if(getAge()>=18){
			mayor=true;
		}
		return mayor;
	}
	*/
	
	//orden natural
	public int compareTo(PersonaImpl persona){
		int comparacion=0;
		
		if(this.apellido.toLowerCase().charAt(0)<persona.getApellido().toLowerCase().charAt(0)){
			comparacion=1;
		}else if(this.apellido.toLowerCase().charAt(0)>persona.getApellido().toLowerCase().charAt(0)){
				comparacion=-1;
			}
		
		return comparacion;
	}
	
	
	//criterio de igualdad
	@Override
	public boolean equals(Object objeto){
		boolean iguales=false;
		
		if(objeto!=null && objeto instanceof PersonaImpl){
			PersonaImpl persona=(PersonaImpl) objeto;

			if(this.nombre==persona.getNombre() && this.apellido==persona.getApellido() && this.sexo==persona.getSexo() ){
				iguales=true;
			}
		}
		return iguales;
	}
	
	
	//representacion como cadena
	@Override
	public String toString(){
		String cadena;
		//cadena=nombre+", "+apellido+", "+this.getAge()+", "+sexo+", "+dni;
		cadena=nombre+","+apellido+","+fechanac.toString()+","+sexo+","+dni;
		return cadena;
	}
	
	
	//hashcode
	@Override
	public int hashCode(){
			int code;
			code=21*15+5*7-8+5*3;
			return code;
	}
	
	
	//clone
	@Override
	public PersonaImpl clone(){
		PersonaImpl copia=new PersonaImpl();
		
		try{
			copia=(PersonaImpl) super.clone();
		}catch(CloneNotSupportedException error){
				System.out.println("Objeto no clonado");
			}
		return copia;
	}
	
		

//-----------------------------------------------------------------------------------------------
		//rellenaConBlanco
		/* Proposito: Recibe una cadena y un entero, rellenar� la cadena con espacios blancos hasta la posicion indicada
		 * Prototipo: String rellenaConBlanco(String cadena, int pos)
		 * Precondiciones: no hay
		 * Entradas: una cadenas
		 * Salidas: 
		 * Postcondiciones: 
		 * Restricciones: 
		 */
		protected String rellenaConBlanco(String cadena, int pos){
			String cadRellena=cadena;
			do{
				cadRellena=cadRellena+" ";
			}while(cadRellena.length()<pos);
			return cadRellena;
		}

	
	//validaLetraDni
	public Character calculaLetra(String dni){
		int parseado=0;
		boolean vale=true;
	    String juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKE";
	    int modulo;
	    char letra=' ';

		try{
			parseado=Integer.parseInt(dni);
		}catch(InputMismatchException e){
			e.printStackTrace();
			vale=false;
		}
		if(vale){
			modulo= parseado % 23;
	    	letra = juegoCaracteres.charAt(modulo);
		}
	    return letra; 
    } 
	
	
}
