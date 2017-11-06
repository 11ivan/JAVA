/*Disenos.java
 * 
 * Propiedades:
 * 	Vestido: Basica, tipo Vestido, consultable, no modificable
 * 	Cantidad: Basica, String, consultable, modificable
 * 
 * 
 */
import java.util.ArrayList;
//import java.util.Arrays;

public class Disenos implements Cloneable{
	private ArrayList<Vestido> listaDisenos;
	
	
	//Constructor por defecto
	public Disenos(){
		listaDisenos=new ArrayList<Vestido>();
	}
	
	
	public Disenos(ArrayList<Vestido> listaDisenos)throws ExcepcionVestido{
		for(int i=0;i<listaDisenos.size();i++){
			try{
				this.listaDisenos.get(i).setNombre(listaDisenos.get(i).getNombre());
				this.listaDisenos.get(i).setCodigo(listaDisenos.get(i).getCodigo());
				this.listaDisenos.get(i).setPrecio(listaDisenos.get(i).getPrecio());
			}catch(ExcepcionVestido error){
				System.out.println(error);
			}
		}
	}
	
	
	public ArrayList<Vestido> getListaDisenos(){
		return listaDisenos;
	}
	
	public Vestido getDiseno(int i){
		Vestido diseno=new Vestido();
		diseno=listaDisenos.get(i);
		return diseno;
	}
	
	public void addVestido(Vestido vestido)throws ExcepcionDisenos{
		if(listaDisenos.contains(vestido)){
			throw new ExcepcionDisenos("El vestido ya esta en la lista");
		}else{
			listaDisenos.add(vestido);
		}
	}
	
	
	public void pintaLista(){
		for(int i=0;i<listaDisenos.size();i++){
			System.out.println(listaDisenos.get(i));
		}
	}

	public void pintaLista(Vestido[] listaVestidos){
		for(int i=0;i<listaVestidos.length;i++){
			System.out.println(listaVestidos[i]);
		}
	}

	
	public Vestido[] toArray(){
		Vestido[] arrayVestidos=new Vestido[listaDisenos.size()];
		
		for(int i=0;i<arrayVestidos.length;i++){
			arrayVestidos[i]=listaDisenos.get(i);
		}
		
		return arrayVestidos;
	}

	
	public int getSize(){		
		return listaDisenos.size();
	}
	
	
	/*public void ordenaLista(){
		int i,j;
		Vestido aux=null,aux2=null;
		for(i=0;i<listaDisenos.size();i++){
			//if(listaDisenos.get(i).getCodigo()<){
			for(j=i;j>0 && listaDisenos.get(i-1).getCodigo()>listaDisenos.get(j).getCodigo();j--){
				//intercambio de elementos
				aux = listaDisenos.get(j);
				listaDisenos.remove(j);
				listaDisenos.add(j,listaDisenos.get(j-1));				
				listaDisenos.remove(j-1);
				listaDisenos.add(j-1, aux);
			}			
		}
	}*/
	


	
	
}
