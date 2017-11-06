import java.util.ArrayList;

/*
 Propiedades:
 	ID: Basica, cadena, consultable, modificable
 	IDUsuario: Basica, cadena, consultable, modificable
 	FechaVenta: Agregada, Fecha2, consultable, modificable
 	ListaProductos: ArrayList de ProductoImpl, consultable, modificable
 	ListaCantidades: ArrayList de enteros, consultable, modificable
 	
 Derivadas:
 	PrecioVenta: Double, consultable, no modificable
 	
 */

public class VentaImpl implements Venta {
	private String id;
	private String idUsuario;
	private Fecha2 fechaventa;
	private ArrayList<ProductoImpl> listaProductos;
	private ArrayList<Integer> listaCantidades;
	
	
	//Constructores
	public VentaImpl(){
		id="0";
		idUsuario="default";
		fechaventa=new Fecha2();
		listaProductos=new ArrayList<ProductoImpl>(0);
		listaCantidades= new ArrayList<Integer>(0);
	}
	
	
	public VentaImpl(String id, String idUsuario, Fecha2 fechaventa, ArrayList<ProductoImpl> productos, ArrayList<Integer> cantidades){
		this.id=id;
		this.idUsuario=idUsuario;
		this.fechaventa=fechaventa;
		listaProductos=productos;
		listaCantidades=cantidades;
	}
	
	
	//Consultores
	public String getID(){
		return id;
	}
	
	public String getIDUsuario(){
		return idUsuario;
	}
	
	
	public Fecha2 getFechaventa(){
		return fechaventa;
	}
	
	public ArrayList<ProductoImpl> getListaProductos(){
		return listaProductos;
	}
	
	public ArrayList<Integer> getCantidades(){
		return listaCantidades;
	}

	
	
	//Modificadores
	public void setId(String id) {
		this.id = id;
	}


	public void setIDUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}


	public void setFechaventa(Fecha2 fechaventa) {
		this.fechaventa = fechaventa;
	}


	public void setListaProductos(ArrayList<ProductoImpl> listaProductos) {
		this.listaProductos = listaProductos;
	}


	public void setListaCantidades(ArrayList<Integer> listaCantidades) {
		this.listaCantidades = listaCantidades;
	}
	
	
	//------------------------------------
	public double getPrecioVenta(){
		double precio=0;
		
		for(int i=0;i<this.listaProductos.size();i++){
			precio=Math.round(Double.parseDouble(listaProductos.get(i).getPrecio())*listaCantidades.get(i));
		}
		
		return precio;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Dado un id de producto devuelve la cantidad asociada a este
	 Prototipo: int cantidadProducto(String idProducto)
	 Precondiciones: no hay
	 Entradas: Una cadena
	 Salidas: Un entero
	 Postcondiciones: El entero será la cantidad asociada al Producto, 0 si no se encontró en la lista
	 */
	public int cantidadProducto(Integer idProducto){
		int cantidad=0;
		//ProductoImpl producto=null;
		
		for(int i=0;i<this.getListaProductos().size();i++){
			if(idProducto.equals(this.getListaProductos().get(i).getID())){
				cantidad=this.getCantidades().get(i);
			}
		}
		
		return cantidad;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Muestra los productos y cantidades de cada uno que hay en la venta
	 Prototipo: void muestraProductos
	 Precondiciones: no hay
	 Entradas: No hay
	 Salidas: No hay
	 Postcondiciones: Se muestra en pantalla los productos de la venta
	 */
	public void muestraProductos(){
		for(int i=1;i<=this.getListaProductos().size();i++){
			System.out.println("Producto "+i+": "+this.getListaProductos().get(i-1).toString());
			//System.out.println("Cantidad: "+this.getCantidades().get(i));	
			//System.out.println();
		}
	}

	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Muestra las cantidades y productos de la venta
	 Prototipo: void muestraCantidadProducto
	 Precondiciones: no hay
	 Entradas: No hay
	 Salidas: No hay
	 Postcondiciones: Se muestra en pantalla las cantidades de un producto de la venta
	 */
	public void muestraCantidadesProductos(){
		
		for(int i=1;i<=this.getListaProductos().size();i++){
			System.out.println("Producto "+i+": "+this.getListaProductos().get(i-1).toString());
			System.out.println("Cantidad: "+this.getCantidades().get(i-1));	
			System.out.println();
		}
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: 
	 Prototipo: 
	 Precondiciones: 
	 Entradas: 
	 Salidas: 
	 Postcondiciones: 
	 */
	public boolean productExists(String idProducto){
		boolean esta=false;
		
		for(int i=0;i<this.listaProductos.size();i++){
			if(idProducto.equals(listaProductos.get(i).getID())){
				esta=true;
			}
		}			
		return esta;
	}

	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Recibe el indice de un producto y lo elimina del arrayList de productos y su cantidad asociada del array de cantidades, si la cantidad del producto es 0
	 Prototipo: void dropProductoCantidad(int indiceProducto)
	 Precondiciones: La posición del producto es válida
	 Entradas: Un entero que es la posición del producto
	 Salidas: no hay
	 Postcondiciones: Se elimina el producto y su cantidad asociada de cada arrayList si la cantidad es 0
	 */
	public void dropProductoCantidad(int indiceProducto){
		if(this.getCantidades().get(indiceProducto).equals(0)){
			this.getCantidades().remove(indiceProducto);
			this.getListaProductos().remove(indiceProducto);
		}
	}
	
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Devuelve el indice de un producto
	 Prototipo: int indexProduct(String idProducto)
	 Precondiciones: El id del producto es válido
	 Entradas: Una cadena
	 Salidas: un entero
	 Postcondiciones: Se devuelve el indice del producto
	 */
	public int indexProduct(String idProducto){
		int index=0;
		boolean sal=false;	
		
		for(int i=0;i<this.listaCantidades.size() && !sal;i++){
			if(idProducto.equals(listaProductos.get(i).getID())){
				index=i;
				sal=true;
			}
		}
		
		return index;
	}
	
	
}
