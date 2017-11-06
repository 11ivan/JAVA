//Ordenador.java
/*
Propiedades: 
	- Memoria: Basica, Tipo Memoria, consultable, modificable
	- HDD: Basica, Tipo HDD, consultable, modificable
	- Procesador: Basica, Tipo Procesador, consultable, modificable
	- Precio base: Basica, real, consultable, modificable
	- Criterio de igualdad:
	- Orden natural:
	- Representacion como cadena:

Propiedades derivadas:
	- Precio mercado: Derivada, real, consultable
	- Precio Total: real,consultable		//es el precio base + el precio de cada componente

Propiedades compartidas:
 	- IVA: Basica, entero, consultable, modificable


 
Restricciones:
	
 
Interfaz:
	Memoria getMemoria()
	void setMemoria()
	
	HDD getHDD()
	void setHDD(HDD hdd)
 
	Procesador getProcesador()
	void setProcesador(Procesador procesador)
 
	double getPrecioBase()
	void setPrecioBase(double preciobase)
 
	int getIVA()
	void setIVA(double iva)
 
	double getPrecioMercado()

 
 
 
 */

public class Ordenador{

	//Atributos
	private Memoria memoria;
	private HDD hdd;
	private Procesador procesador;
	private double preciobase;
	private static double iva;
	
	
	//Constructores
	public Ordenador(){
		memoria=new Memoria();
		hdd=new HDD();
		procesador=new Procesador();
		preciobase=110.10;
		iva=21.0;
	}
	
	public Ordenador(Memoria memoria,HDD hdd, Procesador procesador, double preciobase, double iva){
		this.memoria=memoria;
		this.hdd=hdd;
		this.procesador=procesador;
		this.preciobase=preciobase;
		this.iva=iva;
	}
	
	public Ordenador(Ordenador ordenador){
		this.memoria=ordenador.getMemoria();
		this.hdd=ordenador.getHDD();
		this.procesador=ordenador.getProcesador();
		this.preciobase=ordenador.getPrecioBase();
		this.iva=ordenador.getIVA();		
	}
	
//------------------------------------------------------------------------------------------------------------------	
	//Consultores
	public Memoria getMemoria(){
		return memoria;
	}

	public HDD getHDD(){
		return hdd;
	}

	public Procesador getProcesador(){
		return procesador;
	}

	public double getPrecioBase(){
		return preciobase;
	}

	public double getIVA(){
		return iva;
	}
//------------------------------------------------------------------------------------------------------------------	
	//Consultor propiedades derivadas
	public double getPrecioMercado(){
		double precio=(((preciobase*iva)/100)+preciobase);
		return precio;
	}
	
	public double getPrecioTotal(){
		double precio;
		precio=getPrecioMercado()+this.procesador.getPrecio()+
	}


//------------------------------------------------------------------------------------------------------------------	
	//Modificadores
	public void setPrecioBase(double preciobase){
		this.preciobase=preciobase;
	}

	public void setIVA(double iva){
		this.iva=iva;
	}


//-------------------------------------------------------------------------------------------------------------------
	//compareTo
	public int compareTo(Ordenador ordenador){
		int comparacion=0;
		if(this.precioTotal()>ordenador.getPrecioTotal()){
			comparacion=1;
		}else if(this.precioTotal()<ordenador.getPrecioTotal()){
				comparacion=-1;
			}
		return comparacion;
	}




























	
}


































