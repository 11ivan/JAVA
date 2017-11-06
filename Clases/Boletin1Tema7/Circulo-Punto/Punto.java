//punto.java
/**Tipo Punto:  
Propiedades:
	X: Double, consultable y modificable 
	Y: Double, consultable y modificable
	
	Origen: Punto, Consultable, compartida  //propiedad de la clase
	DistanciaAlOrigen: Double, consultable, derivada  //será calculada
	DistanciaAOtroPunto(Punto p):Double, consultable, derivada //calculada 
	
Operaciones o Funcionalidades: 

Interfaz: 
	Double getX()//consulta
	Double getY()
	void setX(Double nx) //modificación
	void setY(Double ny)
	Punto getOrigen();//consulta de la propiedad compartida 
	
	//cálculo de las propiedades derivadas
	Double  getDistanciaAlOrigen(); 
	Double  getDistanciaAOtroPunto(Punto  p);

Restricciones:
	X e Y no pueden ser negativos (ni mayor que la resolucion de la pantalla).
*/

public class Punto implements Cloneable { //  implements Comparable<Punto>, Cloneable

	private double X;
	private double Y;
	//private static Punto p=new Punto();
	private static Punto Origen= new Punto();

	
	//Constructores
	public Punto(){//Constructor por defecto
		X=0.0;
		Y=0.0;
	}
	
	
	public Punto(double X, double Y){//Constructor sobrecargado
		this.X=X;
		this.Y=Y;
	}
	
	public Punto(Punto npunto){//Constructor de copia
		this.X=npunto.getX();
		this.Y=npunto.getY();
	}
	
	//Consultor de X
	public double getX(){
		return X;
	}
	
	//Modificador de X
	public void setX(double X){
		this.X=X;
	}
	
	//Consultor de Y	
	public double getY(){
		return Y;
	}
	
	//Modificador de Y	
	public void setY(double Y){
		this.Y=Y;
	}
	
	public Punto getOrigen(){ 
		return Origen;
	} 
	
	public Double getDistanciaAotropunto(Punto p){ 
		Double dx = this.getX()-p.getX();  
		Double dy = getY()-p.getY();
		return Math.sqrt(dx*dx+dy*dy); 
	}
	
	public Double getDistanciaAlOrigen(){ 
		return this.getDistanciaAotropunto(Origen);
	}
	
	public void mostrar(){ 
		System.out.println("("+this.getX()+","+this.getY()+")");
	} 
	
 
	public String toString() {
		String s="("+this.getX()+","+ this.getY()+")";  
		return s;
	}	
	
	//clone
	@Override 
	public Punto clone(){
		Punto p=null;
		try{
			p=(Punto) super.clone();
			}catch(CloneNotSupportedException error){
				System.out.println(error);
				}
		return p;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
