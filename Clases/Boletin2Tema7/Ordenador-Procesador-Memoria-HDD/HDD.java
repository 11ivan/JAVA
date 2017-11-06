//HDD.java
/*
	- Tamaño: Basica, real, consultable, modificable
	- Velocidad: Basica, real, consultable, modificable
	- Criterio de igualdad: Si el tamaño y velocidad son iguales
	- Orden natural: Si el tamaño y velocidad del HDD que llega es mayor devuelve -1; sino 1 y si son iguales 0.
	- Representacion como cadena: Tamaño y velocidad;
 
Restricciones:
	Tamaño mayor que 0
	Velocidad: Mayor que 0
 
Interfaz:
	double getSize()
	void setSize(double tamanio)
  
	double getVelocidad()
	void setVelocidad(double velocidad)
 
 
 */


public class HDD implements Comparable<HDD>, Cloneable{
	
	private int size;
	private int velocidad;
	
	
	
	//Constructores
	public HDD(){
		size=500;
		velocidad=7200;
	}
	
	public HDD(int size, int velocidad){
		this.size=size;
		this.velocidad=velocidad;
	}
	
	public HDD(HDD hdd){
		this.size=hdd.getSize();
		this.velocidad=hdd.getVelocidad();
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Consultores
	public int getSize(){
		return size;
	}
	
	public int getVelocidad(){
		return velocidad;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Modificadores
	public void setSize(int size){
		this.size=size;
		this.velocidad=velocidad;
	}
	
	public void setVelocidad(int velocidad){
		this.velocidad=velocidad;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Criterio de igualdad
	@Override
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj!=null && obj instanceof HDD){
			HDD hdd=(HDD) obj;
			if(getSize()==hdd.getSize() && getVelocidad()==hdd.getVelocidad()){
				iguales=true;
			}
		}
		
		return iguales;
	}
	
//------------------------------------------------------------------------------------------------------------------	
	
	//Orden natural
	public int compareTo(HDD hdd){
		int comparacion=0;
	
		if(this.size>hdd.getSize() && this.velocidad>hdd.getVelocidad()){
			comparacion=1;
		}else if(this.size<hdd.getSize() && this.velocidad<hdd.getVelocidad()){
				comparacion=-1;
			}
		return comparacion;
	}
	
//------------------------------------------------------------------------------------------------------------------	
		
		//clone
		@Override
		public HDD clone(){
			HDD copia=null;
			try{
				copia=(HDD) super.clone();
				}catch(CloneNotSupportedException error){
					System.out.println("Objeto no clonado");
					}
			return copia;
		}
	
	
//------------------------------------------------------------------------------------------------------------------	
		
		//Representacion como cadena
		@Override
		public String toString(){
			String cadena;
			cadena=size+", "+velocidad;
			return cadena;
		}
	
	
	
	
	
	
}
