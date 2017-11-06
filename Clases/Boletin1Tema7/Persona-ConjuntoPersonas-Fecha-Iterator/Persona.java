//Persona.java

/**		
 Propiedades:
	- Nombre: Cadena, Basica, Consultable, Modificable
	- Apellido: Cadena, Basica, Consultable, Modificable
	///- Edad: Entero, Basica, Consultable, no modificable// La cambiamos a derivada
	- DNI: Cadena, Basica, Consultable, no modificable
	- Sexo: Caracter, Basica, Consultable, Modificable
	- Peso: Real, Basica, Consultable, Modificable
	- Altura: Real, Basica, Consultable, Modificable
	- Orden natural: por nombre		//compareTo
	- Criterio de igualdad: si tienen todos los atributos iguales //equals
	- Representacion como cadena:
	- Fecha nacimiento: Fecha,  basica agregada, consultable,  modificable
	- ID: basica, entero autoincrementable, consultable, no modificable
	
	
 Propiedades derivadas:
	- IMC: Real, Derivada, Consultable, No modificable
	- Edad: Entero, consultable, no modificable
	

 Interfaz: 
	- String getNombre()
	- void setNombre(String nombre)
	- String getApellido()
	- void setApellido(String apellido)
	- String getDNI()
	- char getSexo()
	- void setSexo(char sexo)
	- float getPeso()
	- void setPeso(float peso)
	- float getAltura()
	- void setAltura(float altura)
	- Fecha getBirthdate()
	- void setBirthdate(Fecha fechanac)
	- int getAge()
	- in getID()

 Funciones:
	- Si es mayor de edad





*/

import java.lang.Character;
import java.util.Calendar;
import java.util.GregorianCalendar;

class Persona implements Comparable<Persona>, Cloneable {
	private boolean entra=true;
	private static int contador=0;
	private int id;
	private String nombre;
	private String apellido;
	//private int edad;
	private String dni;
	private char sexo;
	private double peso;
	private double altura;
	private Fecha2 fechanac;
	//private static Persona persona=new Persona();

	
	//Constructores
	public Persona(){//por defecto
		nombre="Vacio";
		apellido="Cabeza";
		dni="55555555T";
		sexo='x';
		peso=0.0;
		altura=0.0;
		fechanac= new Fecha2();
	}
	/*public Persona(){//por defecto
		id=++contador;
	}*/

	public Persona(String nombre, String apellido,  String dni,Fecha2 fechanac, char sexo, double peso, double altura) throws ExcepcionPersona{//sobrecargado
		
		//this();
		this.nombre=nombre;
		this.apellido=apellido;
		
		
		/*if(dni.length()!=9){
			entra=false;
			throw new ExcepcionPersona("La longitud del dni debe tener 9 caracteres");
		}else if(dni.toLowerCase().charAt(8)<'a' && dni.toLowerCase().charAt(8)>'z'){
				entra=false;
				throw new ExcepcionPersona("El ultimo caracter del DNI debe estar entre a-z");
			}else if(entra==true){
				
					for(int contador=0; contador<=7; contador++){
						 if(Character.isDigit(dni.charAt(contador))==false){
							 throw new ExcepcionPersona("Los 8 primeros digitos deben ser numeros");
						}
					}	
					
				}else{*/
					this.dni=dni;//
				//}
				
		if(Character.toLowerCase(sexo)!='m' && Character.toLowerCase(sexo)!='h' && Character.toLowerCase(sexo)!='x'){
			throw new ExcepcionPersona("El sexo debe ser (M-H-X)");
			}else{
				this.sexo=sexo;//
			}
			
		this.peso=peso;
		this.altura=altura;
		this.fechanac=fechanac;
		
	}
	
	public Persona(Persona persona){//de copia
		this.id=persona.getID();
		this.nombre=persona.getNombre();
		this.apellido=persona.getApellido();
		//this.edad=persona.getEdad();
		this.dni=persona.getDNI();
		this.sexo=persona.getSexo();
		this.peso=persona.getPeso();
		this.altura=persona.getAltura();
		this.fechanac=persona.getBirthDate();
	}
	
	//Consultores
	public int getID(){
		return id;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public String getApellido(){
		return apellido;
	}
	
	/*public int getEdad(){
		return edad;
	}*/
	
	public String getDNI(){
		return dni;
	}
	
	public char getSexo(){
		return sexo;
	}
	
	public double getPeso(){
		return peso;
	}
	
	public double getAltura(){
		return altura;
	}
	
	public Fecha2 getBirthDate(){
		return fechanac;
	}
	
	//Modificadores
	
	public void setNombre(String nombre){
		this.nombre=nombre;
	}
	
	public void setApellido(String apellido){
		this.apellido=apellido;
	}
	
	/*public void setEdad(int edad) throws ExcepcionPersona{
		if(edad<=0){
			ExcepcionPersona excepcionedad=new ExcepcionPersona("La edad no puede ser menor o igual que 0");
		}else{
			this.edad=edad;
		}
	}*/
	
	public void setDNI(String dni) throws ExcepcionPersona{
		
			if(dni.length()!=9){
				entra=false;
				throw new ExcepcionPersona("La longitud del dni debe tener 9 caracteres");
		}else if(dni.toLowerCase().charAt(8)<'a' || dni.toLowerCase().charAt(8)>'z'){
				entra=false;
				throw new ExcepcionPersona("El ultimo caracter del DNI debe estar entre a-z");
			}else if(entra==true){
					for(int contador=0; contador<=7; contador++){
						 if(Character.isDigit(dni.charAt(contador))==false){
							 throw new ExcepcionPersona("Los 8 primeros digitos deben ser numeros");
						}
					}
				}else {
					this.dni=dni;
				}
	}
	
	public void setSexo(char sexo) throws ExcepcionPersona{
		if(Character.toLowerCase(sexo)!='m' && Character.toLowerCase(sexo)!='h' && Character.toLowerCase(sexo)!='x'){
			throw new ExcepcionPersona("El sexo debe ser (M-H-X)");
			}else{
				this.sexo=sexo;
			}
	}
	
	
	public void setPeso(double peso){
		this.peso=peso;
	}
	
	
	public void setAltura(double altura){
		this.altura=altura;
	}
	
	
	public void setBirthDate(Fecha2 fechanac){
			this.fechanac=fechanac;
	}
	
	
	//Derivadas
	//IMC
	public double getIMC(){
		double imc;
		imc=peso/(altura*altura);
		return imc;
	}
	
	
	//Edad
	public int getAge(){
			int edad;
			Calendar calendario = new GregorianCalendar(); 
			
			edad=(calendario.get(Calendar.YEAR))-(fechanac.getYear());
			if(fechanac.getMonth()-1>calendario.get(Calendar.MONTH) || fechanac.getMonth()-1==calendario.get(Calendar.MONTH) && fechanac.getDay()>calendario.get(Calendar.DAY_OF_MONTH)){
					edad--;
			}
			return edad;
	}
	
	
	//Funciones
	//Comprobar mayoria de edad
	public boolean mayordeEdad(){
		boolean mayor=false;
		
		if(getAge()>=18){
			mayor=true;
		}
		return mayor;
	}
	
	
	//orden natural
	public int compareTo(Persona persona){
		int comparacion=0;
		
		if(this.apellido.charAt(0)<persona.getApellido().charAt(0)){
			comparacion=1;
		}else if(this.apellido.charAt(0)>persona.getApellido().charAt(0)){
				comparacion=-1;
			}
		
		return comparacion;
	}
	
	
	//criterio de igualdad
	@Override
	public boolean equals(Object objeto){
		boolean iguales=false;
		
		if(objeto!=null && objeto instanceof Persona){
			Persona persona=(Persona) objeto;

			if(this.nombre==persona.getNombre() && this.dni==persona.getDNI() && this.sexo==persona.getSexo() && this.peso==persona.getPeso() && this.altura==persona.getAltura()){
				iguales=true;
			}
		}
		return iguales;
	}
	
	
	//representacion como cadena
	@Override
	public String toString(){
		String cadena;
		cadena="("+id+", "+nombre+", "+apellido+", "+getDNI()+", "+fechanac+", "+sexo+", "+peso+", "+altura+")";
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
	public Persona clone(){
		Persona copia=new Persona();
		
		try{
			copia=(Persona) super.clone();
		}catch(CloneNotSupportedException error){
				System.out.println("Objeto no clonado");
			}
		return copia;
	}
	
	
	
}
