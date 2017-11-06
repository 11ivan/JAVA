//Procesador.java
/*	
	- Modelo: Basica, cadena, consultable, modificable
	- Velocidad: Basica, real, consultable, modificable
	- Precio: Basica, real, consultable, modificable
	- Criterio de igualdad:
	- Orden natural:
	- Representacion como cadena:
 
Restricciones:
	Modelo solo pueden ser Intel,AMD>>>>   - Intel: i3,i5,i7;  - AMD: A4, A6, A8, A10
	Velocidad: Mayor que 0
 
Interfaz:
	String getModel()
	void setModel(String model)
 
	double getVelocidad()
	void setVelocidad(double velocidad)
	
	double getPrecio()
	void setPrecio()
 
 */
 
 //Metodo replace(" ","") de String Elimina todos los espacios, pero no los tabuladores ni retornos
//Metodo trim() de String Elimina espacios delante y detras
//OJO: Los String en java son inmutables, eso quiere decir que no se pueden modificar, y eso quiere decir que trim(), replace() o replaceAll() 
//NO MODIFICAN la cadena original, sino que nos devuelven una cadena modificada que debemos guardar

public class Procesador implements Comparable<Procesador>, Cloneable{
	private String modelo;
	private double velocidad;
	private double precio;
	

	//Construcores
	public Procesador(){
		modelo="Intel i7";
		velocidad=2.8;
		precio=209.0;
	}
	
	public Procesador(String modelo, double velocidad, double precio){
		this.modelo=modelo.trim();
		this.velocidad=velocidad;
		this.precio=precio;
	}

	public Procesador(Procesador procesador){
		this.modelo=procesador.getModelo();
		this.velocidad=procesador.getVelocidad();
		this.precio=procesador.getPrecio();
	}

	
//------------------------------------------------------------------------------------------------------------------	
	//Consultores
	
	public String getModelo(){
		return modelo;
	}
	
	public double getVelocidad(){
		return velocidad;
	}
	
	public double getPrecio(){
		return precio;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	//Modificadores
	
	public void setModelo(String modelo){
		this.modelo=modelo;
	}
	
	public void setVelocidad(double velocidad){
		this.velocidad=velocidad;
	}
	
	public void setPrecio(double precio){
		this.precio=precio;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	//Criterio de igualdad
	
	@Override
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj != null && obj instanceof Procesador){
			Procesador procesador=(Procesador) obj;
			if(procesador.getModelo().toLowerCase()==this.modelo.toLowerCase() && procesador.getVelocidad()==this.velocidad && this.precio==procesador.getPrecio()){
				iguales=true;
			}
		}
		return iguales;
	}
		
//------------------------------------------------------------------------------------------------------------------	
		//Orden natural
		
		public int compareTo(Procesador procesador){
			int comparacion=0;
			
			if(this.velocidad>procesador.getVelocidad()){
				comparacion=1;
				}else if(this.velocidad<procesador.getVelocidad()){
					comparacion=-1;
					}else if(this.modelo.toLowerCase()==procesador.getModelo().toLowerCase() && this.velocidad==procesador.getVelocidad() && this.precio==procesador.getPrecio()){
						comparacion=0;
						}
			return comparacion;
		}
	
//------------------------------------------------------------------------------------------------------------------	
		//clone
		
		@Override
		public Procesador clone(){
			Procesador copia=null;
			
			try{
				copia=(Procesador) super.clone();
				}catch(CloneNotSupportedException error){
					System.out.println("Objeto no clonado");
					}
			return copia;
		}
	
//------------------------------------------------------------------------------------------------------------------	
		//toString
		
		@Override
		public String toString(){
			String cadena;
			cadena=modelo+", "+velocidad+", "+precio;
			return cadena;
		}
	
//------------------------------------------------------------------------------------------------------------------	
		//hashCode
		
		@Override
		public int hashCode(){
			int hash;
			int entero=(int) velocidad;
			
			hash=entero*modelo.length();
			return hash;
		}	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
