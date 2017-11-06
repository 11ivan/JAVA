import java.util.Comparator;

public class ComparatorProfesor implements Comparator<ProfesorImpl> {

	public int compare(ProfesorImpl p1, ProfesorImpl p2){
		int comparacion=0;
		
		if(p1.getAntiwedad()>p2.getAntiwedad()){
			comparacion=-1;
		}else if(p1.getAntiwedad()<p2.getAntiwedad()){
			comparacion=1;
		}		
		return comparacion;
	}	
	
}
