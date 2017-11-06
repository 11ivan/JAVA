//testTimbre.java


public class testTimbre{
	public static void main(String[] args){
		Timbre timbre=new Timbre();
		Timbre timbre2=new Timbre(1,"pito pito pito");
		Timbre timbre3=new Timbre(timbre2);
		
		//Consulta timbre
		System.out.println(timbre.getEstado()+", "+timbre.getSonido());
		
		//consulta timbre2
		System.out.println(timbre2.getEstado()+", "+timbre2.getSonido());
		
		//consulta timbre3
		System.out.println(timbre3.getEstado()+", "+timbre3.getSonido()+"\n");
		
		//Modificar timbre
		timbre.setEstado(1);
		System.out.println(timbre.getEstado());
		
		//Activar timbre
		timbre.activate();
		
	}
}
