//Memoria.java
/*
Propiedades: 
	- Tamaño: Basica, real, consultable, modificable
	- Tipo: Basica, cadena, consultable, modificable
	- Velocidad: Basica, real, consultable, modificable
	- Criterio de igualdad: Si tienen el mismo tamaño, tipo y velocidad;
	- Orden natural: Si el tamaño, tipo y velocidad de la memoria que llega es mayor devuelve -1; sino 1 y si son iguales 0.
	- Representacion como cadena: Tamaño, tipo y velocidad;
 
Restricciones:
	Tamaño mayor que 0
	Tipo solo pueden ser DDR2,DDR3 y DDR4
	Velocidad: Mayor que 0
 
Interfaz:
	String getSize()
	void setSize(String tamanio)
 
	String getTipo()
	void setTipo(String tipo)
 
	int getVelocidad()
	void setVelocidad(int velocidad)
 
 
 */

public class Memoria implements Comparable<Memoria>, Cloneable{
	
	private int size;
	private String tipo;
	private int velocidad;

	
	
	//Constructores
	public Memoria(){
		size=4;
		tipo="DDR3";
		velocidad=1600;
	}

	public Memoria(int size, String tipo, int velocidad){
		this.size=size;
		this.tipo=tipo;
		this.velocidad=velocidad;
	}
	
	public Memoria(Memoria memoria){
		this.size=memoria.getSize();
		this.tipo=memoria.getTipo();
		this.velocidad=memoria.getVelocidad();
	}
	
//------------------------------------------------------------------------------------------------------------------	

	//Consultores
	public int getSize(){
		return size;
	}
	
	public String getTipo(){
		return tipo;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
//------------------------------------------------------------------------------------------------------------------	

	//Modificadores
	public void setSize(int size){
		this.size=size;
	}

	public void setTipo(String tipo){
		this.tipo=tipo;
	}

	public void setVelocidad(int velocidad){
		this.velocidad=velocidad;
	}

//------------------------------------------------------------------------------------------------------------------	

	//Criterio de igualdad
	@Override
	public boolean equals(Object objeto){
		boolean iguales=false;
		
		if(objeto!= null && objeto instanceof Memoria){
			Memoria memoria= (Memoria) objeto;
			if(memoria.getSize()==this.size && memoria.getTipo()==this.tipo && memoria.getVelocidad()==this.velocidad){
				iguales=true;
			}
		}
		return iguales;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Orden natural
	public int compareTo(Memoria memoria){
		int comparacion=0;
		
		if(getSize()>memoria.getSize() && getVelocidad()>memoria.getVelocidad() && getTipo().charAt(3)>memoria.getTipo().charAt(3)){
			comparacion=1;
		}else if(getSize()<memoria.getSize() && getVelocidad()<memoria.getVelocidad() && getTipo().charAt(3)<memoria.getTipo().charAt(3)){
				comparacion=-1;
			}
		return comparacion;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Clone
	@Override
	public Memoria clone(){
		Memoria copia=null;
		
		try{
			copia =(Memoria) super.clone();
			}
		catch(CloneNotSupportedException error){
				System.out.println("Objeto no clonado");
			}
		return copia;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Representacion como cadena
	@Override
	public String toString(){
		String cadena;
		cadena=size+", "+tipo+", "+velocidad;
		return cadena;
	}
	
		
}









