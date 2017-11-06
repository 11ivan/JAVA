/*Vestidos.java
 * Propiedades: 
 * 	Nombre: Basica, cadena, consultable, no modificable.
 * 	Precio: Basica, decimal, consultable, modificable.
 * 	Codigo: Basica, cadena, consultable, no modificable.
 * 
 * 
 * Interfaz:
 * 	String getNombre
 * 	double getPrecio
 * 	double setPrecio
 * 	String getCodigo
 * 
 * 
 * Restricciones:
 * 	El codigo es una cifra de tres digitos enteros positivos
 * 	El precio debe ser positivo
 * 
 */
public class Vestido implements Comparable<Vestido>, Cloneable {
	private String nombre;
	private Double precio;
	private String codigo;
	//private static int contador;
	
	//Constructores
	public Vestido(){
		nombre=" ";
		codigo="000";
		precio=0.0;
	}
	
	public Vestido(String nombre, double precio, String codigo)throws ExcepcionVestido{
		int codigopars=0;
		
		
		if(nombre.replace(" ", "").length()<4){
			throw new ExcepcionVestido("El nombre debe tener una longitud de cuatro como minimo");
		}else{
			this.nombre=nombre;
		}
		
		
		try{
			codigopars=Integer.parseInt(codigo);
		}catch(NumberFormatException error){
			System.out.println("Se espera un numero");
		}
		if(codigopars<99 && codigopars>999){
			throw new ExcepcionVestido("El codigo debe tener tres digitos numericos");
		}else{
			this.codigo=codigo;
		}
		
		if(precio<=0){
			throw new ExcepcionVestido("El precio no puede ser negativo o cero");
		}else{
			this.precio=precio;
		}
		
	}
	
	
	public Vestido(Vestido vestido){
		this.nombre=vestido.getNombre();
		this.codigo=vestido.getCodigo();
		this.precio=vestido.getPrecio();
	}

	
	
	//Consultores
	public String getNombre(){
		return nombre;
	}
	
	
	public Double getPrecio() {
		return precio;
	}

	
	public String getCodigo() {
		return codigo;
	}
	
	
	
	//Modificadores
	public void setPrecio(Double precio)throws ExcepcionVestido {
		if(precio<=0){
			throw new ExcepcionVestido("El precio no puede ser negativo o cero");
		}else{
			this.precio=precio;
		}
	}

	
	public void setNombre(String nombre)throws ExcepcionVestido {
		if(nombre.replace(" ", "").length()<4){
			throw new ExcepcionVestido("El nombre debe tener una longitud de cuatro");
		}else{
			this.nombre=nombre;
		}
	}

	
	public void setCodigo(String codigo)throws ExcepcionVestido{
		int codigopars=0;
		
		try{
			codigopars=Integer.parseInt(codigo);
		}catch(NumberFormatException error){
			System.out.println("Se espera un numero");
		}
		if(codigopars<99 && codigopars>999){
			throw new ExcepcionVestido("El codigo debe tener tres digitos numericos");
		}else{
			this.codigo=codigo;
		}

		this.codigo = codigo;
	}

	
	/*
	 * Devolverá 0 si los vestidos tienen los mismos valores en los atributos, -1 si el vestido que llega tiene el codigo anterior 1 si no.
	 */
	@Override
	public int compareTo(Vestido vestido){
		int comparacion=0;
		
		if(nombre==vestido.getNombre() && codigo==vestido.getCodigo() && precio==vestido.getPrecio()){
			comparacion=0;
		}else if(Integer.parseInt(codigo)<Integer.parseInt(vestido.getCodigo())){
				comparacion=-1;
			}else if(Integer.parseInt(codigo)>Integer.parseInt(vestido.getCodigo())){
				comparacion=1;
			}
		
		return comparacion;
	}
	
	
	
	//Los objetos son iguales si tienen los mismos valores en sus atributos
	@Override
	public boolean equals(Object obj){
		boolean iguales=false;
		if(obj!=null && obj instanceof Vestido){
			Vestido vestido=(Vestido) obj;
			if(nombre==vestido.getNombre() && codigo==vestido.getCodigo() && precio==vestido.getPrecio()){
				iguales=true;
			}
		}
		return iguales;
	}
	
	@Override
	public Vestido clone(){
		Vestido copia=null;
		
		try{
			copia=(Vestido) super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println(error);
		}
		
		return copia;
	}
	
	
	@Override
	public int hashCode(){
		int cod=codigo.hashCode()+nombre.hashCode();
		return cod;
	}
	
	@Override
	public String toString(){
		String cadena=nombre+", "+precio+", "+codigo;
		return cadena;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
