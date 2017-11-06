import java.util.Comparator;

public class ComparatorProfesor implements Comparator<Profesor> {

	public int compare(Profesor p1, Profesor p2){
		int comparacion=0;
		
		if(p1.getAntiwedad()>p2.getAntiwedad()){
			comparacion=-1;
		}else if(p1.getAntiwedad()<p2.getAntiwedad()){
			comparacion=1;
		}		
		return comparacion;
	}	
	
}
