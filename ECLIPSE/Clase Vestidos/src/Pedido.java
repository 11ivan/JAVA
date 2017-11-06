/*Pedido.java
 * 
 *  Propiedades: 
 *  	Compras: Agregada, Array de Compras, consultable, no modificable.
 *  	
 *  Propiedades Derivadas:
 *  	Precio del pedido: double, consultable, no modificable.
 *  
 *  Interfaz:
 *  	
 * 
 */
//import java.util.Arrays;
import java.util.ArrayList;
//import java.util.AbstractCollection;
//import java.util.AbstractList;

public class Pedido implements Cloneable{
	//private Compra[] compras;
	private ArrayList<Compra> pedido;
	
	public Pedido(){
		pedido=new ArrayList<Compra>(10);
	}
	
	
	public Pedido(ArrayList<Compra> compras){
		this.pedido=compras;
	}

	public Pedido(Pedido pedido){
		for(int i=0;i<pedido.getPedido().size()-1;i++){
			try{
				this.pedido.get(i).setCantidad(pedido.getPedido().get(i).getCantidad());
				this.pedido.get(i).getVestido().setCodigo(pedido.getPedido().get(i).getVestido().getCodigo());
				this.pedido.get(i).getVestido().setNombre(pedido.getPedido().get(i).getVestido().getNombre());
				this.pedido.get(i).getVestido().setPrecio(pedido.getPedido().get(i).getVestido().getPrecio());
			}catch(ExcepcionCompra error){
				System.out.println(error);
			}
			catch(ExcepcionVestido error){
				System.out.println(error);
			}
		}
	}
	
	public void addCompra(Compra compra){
		pedido.add(compra);
	}
	
	public ArrayList<Compra> getPedido() {
		return pedido;
	}
	
	public ArrayList<Vestido> getVestidos() {
		ArrayList <Vestido>vestidos=new ArrayList<Vestido>(pedido.size());
		
		for(int i=0;i<vestidos.size();i++){
			vestidos.add(pedido.get(i).getVestido());
		}
		
		return vestidos;
	}

	
	
	public Compra getCompra(int i){
		return pedido.get(i);
	}
	
	
	/*Proposito: Calcula el precio total de un pedido hecho
	 *Prototipo: double getPrecioPedido()
	 *Precondiciones: El array no estará vacio
	 *Entradas: No hay, se usa el atributo pedido de la clase
	 *E/S:No hay
	 *Salidas: Un double. AN
	 *Postcondiciones: EL double que es el precio total del pedido
	 */
	public double getPrecioPedido(){
		double precio=0;
		for(int i=0;i<pedido.size();i++){
			precio=precio+pedido.get(i).getPrecioCompra();
		}					
		return precio;
	}
	
	
	
//_____________________________________________________________________________________________________________________________	
	public void paintPedido(){
		System.out.println("Codigo\tCantidad\tPrecio Unitario\tPrecio Total");
		for(int i=0;i<pedido.size();i++){
			System.out.println(" "+pedido.get(i).getVestido().getCodigo()+"\t   "+pedido.get(i).getCantidad()+"\t\t     "+pedido.get(i).getVestido().getPrecio()+"\t    "+pedido.get(i).getPrecioCompra());
		}
		System.out.println("\n\t\t\t\t\t\tTotal Pedido");
		System.out.println("\t\t\t\t\t\t\t    "+Math.round(getPrecioPedido()));
	}


	//Usa el metodo de insercion para ordenar
	public void ordenaPedido(){
		int i,j;
		Compra aux=new Compra();
		for(i=0;i<pedido.size();i++){
			for(j=i;j>0 && Integer.parseInt(pedido.get(j-1).getVestido().getCodigo())>Integer.parseInt(pedido.get(j).getVestido().getCodigo());j--){
				aux = pedido.get(j);
				pedido.remove(j);
				pedido.add(j,pedido.get(j-1));
				pedido.remove(j-1);
				pedido.add(j-1,aux);

			}
		}
	}

	@Override
	public Pedido clone(){
		Pedido copia=null;	
		try{
			copia=(Pedido) super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println("Objeto no clonado");
		}	
		return copia;
	}
	
	
	public Pedido cloneProf(){
		Pedido copia=null;
		
		try{
			copia=(Pedido) super.clone();
			for(int i=0;i<pedido.size()-1;i++){
				copia.getPedido().add(i,this.getCompra(i).clone());
			}
		}catch(CloneNotSupportedException error){
			System.out.println("Objeto no clonado");
		}
		
		
		return copia;
	}
	
	
	
	
	
	
	
	
}
