//Circulo.java
/**
 * Círculo 
Propiedades:  
	- Centro: Punto,derivada, consultable y modificable. 
	- Radio: real, consultable y modificable. 
	- Orden natural: por el centro y a igualdad de éste por el radio. //compareto
	- Criterio de Igualdad: si tienen el mismo centro y el mismo radio. //equal
	- Representación como cadena: Centro y Radio separados por comas y entre paréntesis. 
	- Area: real,derivada, consultable no modificable
	- Perimetro: real,derivada, consultable no modificable
	
Funcionalidades:
	- Desplazar: desplaza el centro pero conserva el radio. 

Interfaz
	- Punto get Centro();
	- void set Centro(Punto nCentro);
	- float get Radio();
	- void set Radio(float nRadio);


Restricciones:
	centro no puede ser null 
	radio no puede ser menor o igual a cero.  

Consideraciones:
	Estamos interesados en saber el área A=pi*r²
	 y el perímetro. P=2*pi*r
*/

import java.lang.*;

public class Circulo implements Comparable<Circulo>, Cloneable {
	
	private Punto centro;
	private double radio;
	final double pi=3.14;
	
	//Constructores
	public Circulo(){//por defecto
		centro=new Punto();
		radio=1.0;
	}
	
	public Circulo(Punto ncentro, double nradio){//sobrecargado
		this.centro=ncentro;
		this.radio=nradio;
	}
	
	public Circulo(Circulo ncirculo){//de copia
		this.centro=ncirculo.getcentro();
		this.radio=ncirculo.getradio();
	}
	
	//consultores
	public double getradio(){
		return radio;
	}
	
	public Punto getcentro(){
		return centro;
	}
	
	//modificadores
	public void setradio(double nradio){
		this.radio=nradio;
	}
	
	//public void setcentro(Punto ncentro){///////¡¡¡¡¡¡¡¡¡¡!!!!!!!!!!!!!!!!    NO SE HACE SET A CENTRO!!!!!!!!!!!!!!!!!!
	//	this.centro=ncentro;
	//}
	
	public void setCentro(Punto centro){
		this.centro.setX(centro.getX());
		this.centro.setY(centro.getY());
	}
	
	//Consulta derivadas
	
	//Area del circulo A=pi*r² 
	 public double getarea(){
		double a= radio*radio*pi;
		//double a=math.pow((getradio()),2)*pi;
		return a;
	}
	 
	//Perimetro del circulo P=2*pi*r
	public double getperimetro(){
		return(2*pi)*getradio();		
	}
	
	
	//funcionalidades
	public void desplazacentro(Punto ncentro){
		this.centro=ncentro;
		//centro.setcentro(ncentro);
	}
	
	//Representación como cadena
	@Override
	public String toString(){
		String cadena="("+centro+", "+radio+")";
		return cadena;
	}
	
	//Muestra en pantalla
	public void mostrar(){
		System.out.println("("+centro+" ,"+radio+")");
	}
	
	//Orden natural	
	public int compareTo(Circulo circulo){
		int compara=0;
		if(this.getradio()==circulo.getradio() && this.centro.getX()==circulo.centro.getX() && this.centro.getY()==circulo.centro.getY()){
			compara=0;
		}
		if(this.getradio()>circulo.getradio()){
			compara=1;
		}else if(this.getradio()<circulo.getradio()){
				compara=-1;
			}
		return compara;
	}
	
	//Criterio de Igualdad //SERA EL RADIO
	@Override
	public boolean equals(Object objeto){
		boolean igual=false;
		
		if(objeto!=null  && objeto instanceof Circulo){
			Circulo circulo=(Circulo) objeto;
			
				if(radio==circulo.getradio()){
					igual=true;
				}
		}
		return igual;
	}
	
	@Override
	public Circulo clone(){
		Circulo copia=null;
		
		try{
			copia=(Circulo) super.clone();
			copia.centro=centro.clone(); //asi no -Asun 
			}
		catch(CloneNotSupportedException error){
				System.out.println("Objeto no clonado");
			}
		return copia; 
		
	}
	
	
	//@Override
	public int hashCode(){
			int code=((int) (centro.getX()*centro.getY()+1000*getradio()));
			return code;
	}
	
	
	
	
}
