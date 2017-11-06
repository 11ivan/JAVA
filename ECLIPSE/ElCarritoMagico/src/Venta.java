import java.util.ArrayList;

public interface Venta {

	//Consultores
	String getID();

	String getIDUsuario();

	Fecha2 getFechaventa();

	ArrayList<ProductoImpl> getListaProductos();

	ArrayList<Integer> getCantidades();

	//Modificadores
	void setId(String id);

	void setIDUsuario(String idUsuario);

	void setFechaventa(Fecha2 fechaventa);

	void setListaProductos(ArrayList<ProductoImpl> listaProductos);

	void setListaCantidades(ArrayList<Integer> listaCantidades);

	//------------------------------------
	double getPrecioVenta();

}