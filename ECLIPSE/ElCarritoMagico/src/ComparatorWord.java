import java.util.Comparator;

public class ComparatorWord implements Comparator<String>{
		
	
	public int compare(String cadena1, String cadena2){
		int comparacion=0;
		
		comparacion=cadena1.toLowerCase().compareTo(cadena2.toLowerCase());
					
		return comparacion;
	}
		
		
		
}
