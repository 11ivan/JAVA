//Urna.java
/*
Propiedades: 
	- Bola: entero, basica, consultable, modificable
	- Capacidad maxima: entero,derivada,consultable, no modificable  //deriva de la cantidad de bolas blancas y negras que hay en total
	- Cantidad disponible: entero, derivada,consultable, no modificable
	- Cantidad de bolas negras: entero,basica,consultable, modificable  //tomare como 0 la negra y 1 la blanca
	- Cantidad de bolas blancas: entero,basica,consultable, modificable
	- Criterio de igualdad:
	- Representacion como cadena:
	- Orden natural:

Interfaz:
* int getCapacidadMax()
* void setCapacidad( int capacidad )
* int getCantidadNegras()
* void setCandidadNegras(int cantidad)
* int getCantidadBlancas()
* void setCandidadBlancas(int cantidad)* 
* 

Funcionalidades:
	* 	//mostrarUrna
	* Proposito: Muestra en pantalla el estado de la urna
	* Prototipo: public void muestraUrna()
	* Precondiciones: no hay
	* entradas: no hay
	* salidas: no hay
	* Postcondiciones: se ha pintado en pantalla el estado de la urna
	* Restricciones: no hay
	
	*	//sacarBola
	* Proposito: Saca una bola de la urna
	* Prototipo: public int sacarBola()
	* Precondiciones: en la urna habra al menos 1 bola
	* Entradas: no hay
	* Salidas: un entero
	* Postcondiciones: asociado al nombre un entero que sera 0 si la bola es negra y 1 si es blanca
	* Restricciones: Solo se puede sacar si quedan al menos una bola
	
	*	//meterBola
	* Proposito: Mete una bola en la urna
	* Prototipo: public void meterBola(int bola)
	* Precondiciones: La urna no estara llena
	* Entradas: un entero
	* Salidas: no hay
	* Postcondiciones: La urna con una bola mas
	* Restricciones: Solo se puede meter si la urna no esta llena

*/

import java.util.Random;

public class Urna{
	
	private int cantidadblancas;
	private int cantidadnegras;
	//private Random aleatorio= new Random();  QUE DICES AQUI NO VA ESTO     SOLO BASICAS!!!!
	
	//Constructores
	public Urna(){
		cantidadblancas=25;
		cantidadnegras=25;
	}
	
	public Urna(int cantidadblancas, int cantidadnegras){
		this.cantidadnegras=cantidadnegras;
		this.cantidadblancas=cantidadblancas;
	}
	
	public Urna(Urna urna){
		this.cantidadblancas=urna.getCantidadBlancas();
		this.cantidadnegras=urna.getCantidadNegras();
	}
	
	
	
	//Consultores

	public int getCantidadDisponible(){
		int cantidad=cantidadblancas+cantidadnegras;
		return cantidad;
	}

	public int getCantidadBlancas(){
		return cantidadblancas;
	}
	
	public int getCantidadNegras(){
		return cantidadnegras;
	}

	public int getCapacidadMax(){
		int capacidadmax=this.cantidadblancas+this.cantidadnegras;
		return capacidadmax;
	}

	//Modificadores

	public void setCantidadNegras(int cantidad){
		this.cantidadnegras=cantidad;
	}

	public void setCantidadBlancas(int cantidad){
		this.cantidadblancas=cantidad;
	}
	
	
	//meteBola
	public void meteBola(int ball,int ball2){
		if(ball==ball2){
			this.cantidadnegras=this.cantidadnegras+1;
		}else if(ball!=ball2){
				this.cantidadblancas=this.cantidadblancas+1;
			}
	}
	
	
	//sacaBola
	public int sacaBola(){
		Random aleatorio= new Random();
		int bola;
		bola=aleatorio.nextInt(2);					
		return bola;
	}
	
	public void restaBolas(int bola1,int bola2){
		if(bola1==0 && bola2==0){
			this.cantidadnegras=this.cantidadnegras-2;
		}else if(bola1==1 && bola2==1){
				this.cantidadblancas=this.cantidadblancas-2;
			}else if(bola1==1 && bola2==0 || bola1==0 && bola2==1){
						this.cantidadnegras=this.cantidadnegras-1;
						this.cantidadblancas=this.cantidadblancas-1;
					}
	}
	
	
	//Criterio de igualdad
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj!=null && obj instanceof Urna){
			Urna urna=(Urna) obj;
			
			if(this.cantidadblancas==urna.getCantidadBlancas() && this.cantidadnegras==urna.getCantidadNegras()){
				iguales=true;
			}
		}
		return iguales;
	}
	
	//Orden natural
	public int compareTo(Urna urna){
		int comparacion=0;
		
		if(this.cantidadblancas==urna.getCantidadBlancas() && this.cantidadnegras==urna.getCantidadNegras()){
				comparacion=0;
			}else if (this.cantidadblancas>urna.getCantidadBlancas() &&this.cantidadnegras>urna.getCantidadNegras()){
					comparacion=1;
				}else if(this.cantidadblancas<urna.getCantidadBlancas() &&this.cantidadnegras<urna.getCantidadNegras()){
						comparacion=-1;
					}
		return comparacion;
	}
	
	//Representacion como cadena
	
	
	//clone
	
	
	//comapreTo
	
	
}
