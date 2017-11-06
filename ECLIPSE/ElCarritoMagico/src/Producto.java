
public interface Producto {

	public String getID();
	public String getNombre();
	public String getDescripcion();
	public String getPrecio();
	public String getStockage();
	public String getIDCategoria();
	
	
	public void setID(String id);
	public void setNombre(String nombre) throws ExcepcionProducto;
	public void setDescripcion(String descripcion) throws ExcepcionProducto;
	public void setPrecio(String precio) throws ExcepcionProducto;
	public void setStockage(String stockage) throws ExcepcionProducto;
	public void setIDCategoria(String categoria);
	
	
	
	
}
