//Temperatura.java


public class Temperatura implements Comparable<Temperatura> {

	private double tempMax;//temperatura maxima
	private double tempActual;//temperatura actual
	
	
	
	//Constructores
	public Temperatura(){
		tempMax=0.0;
		tempActual=0.0;
	}
	
	public Temperatura(double tempMax, double tempActual){
		this.tempMax=tempMax;
		
		this.tempActual=tempActual;
	}
	
	public Temperatura(Temperatura temperatura){
		this.tempMax=temperatura.getTempMax();
		this.tempActual=temperatura.getTempActual();
	}
	
	
	//Consultores 
	public double getTempMax(){
		return tempMax;
	}

	public double getTempActual(){
		return tempActual;
	}

	//Modificadores
	public void setTempMax(double tempMax){
		if(tempMax<=this.tempActual){
			alerta();
			this.tempMax=tempMax;
		}
	}

	public void setTempActual(double tempActual){
		if(tempActual>=this.tempMax){
			alerta();
			this.tempActual=tempActual;
			}
				
	}

	//Criterio de igualdad
	//Dos temperaturas son iguales si son objetos de la misma clase y tienen los mismos valores en sus atributos
	@Override
	public boolean equals(Object obj){
		boolean iguales=false;
		Temperatura temperatura=null;
		
		if(obj!=null && obj instanceof Temperatura){
			temperatura=(Temperatura) obj;
			if(this.tempMax==temperatura.getTempMax() && this.tempActual==temperatura.getTempActual()){
				iguales=true;
			}
		}
		return iguales;
	}

	//Orden natural
	//Si la temperatura que llega tiene la temperatura actual mayor devuelve -1, sino 1 y si son igules 0
	public int compareTo(Temperatura temperatura){
		int comparacion=0;
		
		if(this.tempMax>temperatura.getTempMax() && this.tempActual>temperatura.getTempActual()){
			comparacion=1;
			}else if(this.tempMax<temperatura.getTempMax() && this.tempActual<temperatura.getTempActual()){
				comparacion=-1;
			}
		return comparacion;
	}	
	
	//Representacion como cadena
	//Todos los atributos separados por coma
	public String toString(){
		String cadena=tempMax+", "+tempActual;
		return cadena;
	}
	
	//Alerta temperatura
	private void alerta(){
		Timbre timbre=new Timbre();
		timbre.activate();
	}
	
	
}













