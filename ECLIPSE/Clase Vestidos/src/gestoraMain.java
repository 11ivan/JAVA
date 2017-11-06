
import java.util.ArrayList;

public class gestoraMain {
	
//________________________________________________________________________________________________________________________	
	
	/* Proposito: Dada una cadena comprueba que sea SI o NO
	 * Prototipo:  boolean validaIntroduce(String introduce)
	 * Precondiciones: no hay
	 * Entradas: una cadena
	 * E/S: 
	 * Salidas: un booleano
	 * Postcondiciones: el booleano sera verdadero si la cadena es SI o NO y falso si no
	 */
	public boolean validaIntroduce(String introduce){
		boolean vale=true;
		
		if(!introduce.equals("SI") && !introduce.equals("NO")){
			vale=false;
		}		
		return vale;
	}
	
//________________________________________________________________________________________________________________________	
	
	/* Proposito: Dada una cantidad como cadena comprueba que sea mayor que 0
	 * Prototipo:  boolean validaCantidad(String cantidad)
	 * Precondiciones: no hay
	 * Entradas: una cadena
	 * E/S: 
	 * Salidas: un booleano
	 * Postcondiciones: el booleano sera verdadero si la cadena es mayor que 0 y falso si no
	 */	
	public boolean validaCantidad(String cantidad){
		int cantidadpars=0;
		boolean vale=true;
		try{
			cantidadpars=Integer.parseInt(cantidad);
		}catch(NumberFormatException error){
			System.out.println("Se espera un numero");
			vale=false;
		}
		if(vale && cantidadpars<=0){
			vale=false;
		}
		return vale;		
	}
	
//________________________________________________________________________________________________________________________	
	
	/* Proposito: Dado un codigo y una lista de diseños comprueba que el codigo se encuentre en dicha lista
	 * Prototipo: boolean validaCodigo(String codigo, Disenos disenos)
	 * Precondiciones: El codigo debe ser valido, lista de diseños no estara vacia
	 * Entradas: una cadena y una lista de diseños 
	 * E/S: 
	 * Salidas: un booleano
	 * Postcondiciones: el booleano sera verdadero si la cadena es mayor que 0 y falso si no
	 */
	public boolean validaCodigo(String codigo, Disenos disenos){
		boolean vale=false;
		
		for(int i=0;i<disenos.getSize();i++){
			if(disenos.getDiseno(i).getCodigo().toString().equals(codigo)){
				vale=true;
			}
		}
		return vale;
	}
	
	
	
	
	
//________________________________________________________________________________________________________________________	

	/* Proposito: Dado un codigo, una cantidad y un array de diseños comprueba que el codigo este en el array y si esta crea la compra 
	 * 			  correspondiente, con la cantidad y el vestido.
	 * Prototipo: Compra creaCompra(String codigo, String cantidad, Disenos disenos)
	 * Precondiciones: La cantidad y el codigo seran validos y el array de diseños no estara vacio
	 * Entradas: Dos cadenas: codigo y cantidad.  Y un array de diseños
	 * E/S: 
	 * Salidas:
	 * Postcondiciones: 
	 */
	public Compra creaCompra(String codigo, String cantidad, Disenos disenos){
		Compra compra=new Compra();
		Vestido vestido=new Vestido();
		String cantCompra=" ";
		
		for(int i=0;i<disenos.getSize();i++){
			if(disenos.getDiseno(i).getCodigo().toString().equals(codigo)){
				vestido=disenos.getDiseno(i);
			}
		}
		
		try{
			compra.setCantidad(cantidad);
		}catch(ExcepcionCompra error){
			System.out.println(error);
		}
		
		try{
		compra.getVestido().setCodigo(vestido.getCodigo());
		compra.getVestido().setNombre(vestido.getNombre());
		compra.getVestido().setPrecio(vestido.getPrecio());
		}catch(ExcepcionVestido error){
			System.out.println(error);
		}
		
		return compra;
	}
	
//________________________________________________________________________________________________________________________	
	
		/* Proposito: 
		 * Prototipo: Pedido creaPedido()
		 * Precondiciones: El array no estara vacio
		 * Entradas: 
		 * E/S: 
		 * Salidas: 
		 * Postcondiciones: 
		 */
	public Pedido copiaPedido(Pedido acopiar){
		Pedido copiado=new Pedido();
		ArrayList<Compra>compras=new ArrayList<Compra>(acopiar.getPedido().size());
		Compra compra=new Compra();
		
		for(int i=0;i<acopiar.getPedido().size();i++){
			compra=acopiar.getCompra(i);
			compras.add(compra);
		}
		for(int i=0;i<acopiar.getPedido().size();i++){
			copiado.addCompra(compras.get(i));		
		}
	
		return copiado;
	}
	
//________________________________________________________________________________________________________________________	
	
	/* Proposito: Pintar una Lista de Pedidos
	 * Prototipo: void paintListaPedidos(ArrayList<Pedido> listaPedidos)
	 * Precondiciones: El array no estara vacio
	 * Entradas: Un ArrayList de Pedidos
	 * E/S: No hay
	 * Salidas: No hay
	 * Postcondiciones: Se pinta en pantalla la lista de pedidos
	 */
	public void paintListaPedidos(ArrayList<Pedido> listaPedidos){
		for(int i=0;i<listaPedidos.size();i++){
			listaPedidos.get(i).paintPedido();
			System.out.println("_______________________________________________________");
		}
		
	}
	
	//________________________________________________________________________________________________________________________	
	
			/* Proposito: 
			 * Prototipo: Pedido creaPedido()
			 * Precondiciones: El array no estara vacio
			 * Entradas: 
			 * E/S: 
			 * Salidas: 
			 * Postcondiciones: 
			 */
	
	
}
