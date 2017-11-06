import java.util.Comparator;

public class ComparatorProfesorApellido implements Comparator<ProfesorImpl>{
	public int compare(ProfesorImpl p1, ProfesorImpl p2){
		int comparacion=0;
		
		if(p1.getApellido().charAt(0)>p2.getApellido().charAt(0)){
			comparacion=1;
		}else if(p1.getApellido().charAt(0)<p2.getApellido().charAt(0)){
			comparacion=-1;
		}		
		return comparacion;
	}	

}
