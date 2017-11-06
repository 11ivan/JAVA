//Timbre.java

public class Timbre{
	private int estado;
	private String sonido;
	
	
	
	//Constructores
	public Timbre(){
		estado=0;
		sonido="piiiiiiiiii";
	}
	
	public Timbre(int estado, String sonido){
		this.estado=estado;
		this.sonido=sonido;
	}
	
	public Timbre(Timbre timbre){
		this.estado=timbre.getEstado();
		this.sonido=timbre.getSonido();
	}
	
	//Consultores
	public int getEstado(){
		return estado;
	}
	
	public String getSonido(){
		return sonido;
	}
	
	//Modificadores
	public void setEstado(int estado){
		if(estado==1){
			this.pita();
			this.estado=0;
			}
	}
	
	public void getSonido(String sonido){
		this.sonido=sonido;
	}
	
	
	//Funcionalidades
	public void activate(){
		if(this.estado==0){
			this.pita();
			}
	}
	
	private void pita(){
		System.out.println(this.getSonido());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
























