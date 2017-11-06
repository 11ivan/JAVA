import java.util.ArrayList;

public interface Pedido {

	//Consultores
	String getID();

	String getIDUsuario();

	String getIDProveedor();

	Fecha2 getFechaPedido();

	ArrayList<ProductoImpl> getListaProductos();

	ArrayList<Integer> getCantidades();

	//Modificadores
	void setId(String id);

	void setIDUsuario(String idUsuario);

	void setIDProveedor(String idProveedor);

	void setFechaPedido(Fecha2 fechaPedido);

	void setListaProductos(ArrayList<ProductoImpl> listaProductos);

	void setListaCantidades(ArrayList<Integer> listaCantidades);

}