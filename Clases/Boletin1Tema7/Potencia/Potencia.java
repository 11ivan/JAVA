//Potencia.java
/**
PotenciaEntera 
Propiedades:  
	Base, Entero positivo, consultable y modificable. 
	Exponente, Entero positivo, consultable y modificable. 
	Orden natural: por el valor que tenga. 
	Criterio de Igualdad: si tienen la misma base y el mismo exponente. 
	Representación como cadena: base y exponente separados por comas entre paréntesis.  
	
Funcionalidades: 
	Valor, devuelve un entero que es su valor entero.  
	

Interfaz:
	int getbase()
	void setbase(int nbase)
	int getexponente()
	void setexponente(int nexponente)
	Potencia getpotencia()//consulta de la propiedad compartida 
	 
	 
	
 */

class Potencia implements Comparable<Potencia>, Cloneable{
	
	private int base;
	private int exponente;
	private static Potencia potencia=new Potencia();
	
	//Constructores
	public Potencia(){ //por defecto
		base=0;
		exponente=0;
	}
	
	public Potencia(int base, int exponente){ //sobrecargado
		this.base=base;
		this.exponente=exponente;
	}
	
	public Potencia(Potencia npotencia){ //de copia
		this.base=npotencia.getbase();
		this.exponente=npotencia.getexponente();
	}
	
	//Consultores
	public int getbase(){
		return base;
	}
	
	public int getexponente(){
		return exponente;
	}
	
	public Potencia getpotencia(){
		return potencia;
	}
	
	//Modificadores
	public void setbase(int nbase){
		this.base=nbase;
	}
	
	public void setexponente(int nexponente){
		this.exponente=nexponente;
	}		
	
	//Funcionalidades
	
	public int valor(){
		int resultado=1;
		int contador;	
		for(contador=1;contador<=exponente;contador++){			

				resultado=resultado*base;
		}
		return resultado;
	}
	
	@Override
	public int compareTo(Potencia potencia){
		int comparacion=0;
		
		if(this.potencia.valor()>potencia.valor()){
			comparacion=1;
		}else if(this.potencia.valor()<potencia.valor()){
				comparacion=-1;
			}
		
		return comparacion;
	}
	
	@Override
	public boolean equals(Object objeto){
		boolean iguales=false;
		
		if(objeto!=null && objeto instanceof Potencia){
			Potencia potencia=(Potencia) objeto;
			
			if(this.base==potencia.getbase() && this.exponente==potencia.getexponente()){
					iguales=true;
				}
		}		
		return iguales;		
	}
	
	@Override
	public String toString(){
		String cadena;
		cadena="("+base+", "+exponente+")";
		return cadena;
	}
	
}
