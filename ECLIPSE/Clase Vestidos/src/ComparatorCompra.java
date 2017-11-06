import java.util.*;
public class ComparatorCompra implements Comparator<Compra>{

		public int compare(Compra compra1, Compra compra2){
		
			int compara=0;
			
			if(Integer.parseInt(compra1.getVestido().getCodigo())>Integer.parseInt(compra2.getVestido().getCodigo())){
				compara=1;
			}else{
				if(Integer.parseInt(compra1.getVestido().getCodigo())>Integer.parseInt(compra2.getVestido().getCodigo())){
					compara=-1;
				}
			}
		
			return compara;
		}	
}
