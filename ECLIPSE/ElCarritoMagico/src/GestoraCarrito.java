import java.util.InputMismatchException;

public class GestoraCarrito {
	
	
	
	//MENU PRINCIPAL
	public void menuPrincipal(){
		System.out.println("\nEscoja una opción del menú");
		System.out.println("0: Salir");
		System.out.println("1: Iniciar Sesión");
		System.out.println("2: Registrarse\n");
	}
	
	//MENU OPERARIO
	public void menuOperario(){
		System.out.println("\nEscoja una opción del menú");
		System.out.println("0: Salir");
		System.out.println("1: Ver productos");
		System.out.println("2: Insertar nuevo producto");
		System.out.println("3: Desactivar producto");
		System.out.println("4: Activar producto");
		System.out.println("5: Añadir producto al pedido");
		System.out.println("6: Soltar producto");
		System.out.println("7: Ver pedido");
		System.out.println("8: Realizar pedido");
		System.out.println("9: Vaciar pedido\n");
	}

	//MENU CLIENTE
	public void menuCliente(){
		System.out.println("\nEscoja una opción del menú");
		System.out.println("0: Salir");
		System.out.println("1: Ver productos");
		System.out.println("2: Añadir producto al carrito");
		System.out.println("3: Soltar producto");
		System.out.println("4: Ver carrito");
		System.out.println("5: Realizar pedido");
		System.out.println("6: Vaciar el carrito\n");
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Valida la opcion elegida del menú
	 Prototipo: boolean validaOpcion(String opcion, int cantidad)
	 Precondiciones: no hay
	 Entradas: Una cadena que será la opción elegida y un entero que será el número de opciones posibles
	 Salidas: Un booleano
	 Postcondiciones: El booleano será verdadero si la opción elegida está en el rango de opciones posibles y falso si no
	 */
	public boolean validaOpcion(String opcion, int cantidad){
		boolean vale=false;
		int opcionPars=-1;
		boolean compara=true;
		//System.out.println("Última opcion: "+cantidad);
		//System.out.println("Opción elegida: "+opcion);
		
		try{
			opcionPars=Integer.parseInt(opcion);
		}catch(NumberFormatException e){
			System.out.println("Se espera un numero");
			compara=false;
		}
		if(compara){
			if(opcionPars>=0 && opcionPars<=cantidad){
				vale=true;
			}	
		}
		return vale;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Verifica que dos cadenas son iguales
	 Prototipo: boolean verifyPass(String password1, String password2)
	 Precondiciones: no hay
	 Entradas: Dos cadenas
	 Salidas: Un booleano
	 Postcondiciones: El booleano será verdadero si las cadenas son iguales y falso si no
	 */
	 public boolean verifyPass(String password1, String password2){
		 boolean iguales=false;
		 
		 if(password1.equals(password2)){
			 iguales=true;
		 }
		 return iguales;
	 }

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Muestra un menú con las opciones de añadir un producto a la venta
	 Prototipo: void menuVenta()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay
	 Postcondiciones: Se muestra en pantalla un menu de opciones
	 */
		public void menuVenta(){
			System.out.println("\nEscoja una opción del menú");
			System.out.println("0: Salir");
			System.out.println("1: Ver todos los productos");
			System.out.println("2: Ver productos por categoria\n");
		}

	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Parsea dos cadenas a enteros y comprueba el mayor
	 Prototipo: int compruebaMayor(String cantidadElegida, String cantidadActual, String StockProducto)
	 Precondiciones: no hay
	 Entradas: Dos cadenas
	 Salidas: un entero
	 Postcondiciones: El entero será 1 si la cantidadElegida>StockProducto, -1 sino y 0 si son iguales
	 */
	public int compruebaMayor(String cantidadElegida, int cantidadActual, Integer StockProducto){
		int comparacion=1;
		int cantElPars=-1;
		boolean compara=true;
		
		try{
			cantElPars=Integer.parseInt(cantidadElegida);
		}catch(NumberFormatException e){
			System.out.println("Se esperaba un número");
			compara=false;
		}
			if(compara){
				if(cantElPars>0){
					if(cantElPars+cantidadActual>StockProducto){
						comparacion=1;
					}else if(cantElPars+cantidadActual<StockProducto){
						comparacion=-1;
					}
				}
			}
		return comparacion;
	}
	 
	 
	 
	 
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Recibe un Integer(Cantidad actual de un producto en una venta) y una cadena(cantidad a soltar del producto),
	  			parsea la cadena a entero y comprueba que no sea mayor que no sea mayor que el Integer recibido
	 Prototipo: int compruebaMayor(Integer cantidadActual, String cantidadSuelta)
	 Precondiciones: no hay
	 Entradas: Un Integer y una cadena
	 Salidas: Un entero
	 Postcondiciones: El entero será 1 si la cantidad que suelta es menor que la actual, -1 si es mayor y 0 si son iguales
	 */
	public int compruebaMayor(Integer cantidadActual, String cantidadSoltar){
		int comparacion=0;
		int cantidadSoltarPars=0;
		boolean sigue=true;
		
		try{
			cantidadSoltarPars=Integer.parseInt(cantidadSoltar);
		}catch(NumberFormatException e){
			System.out.println("Se esperaba un número");
			sigue=false;
		}
		
		if(sigue){
			if(cantidadSoltarPars<cantidadActual){
				comparacion=1;
			}else if(cantidadSoltarPars>cantidadActual){
				comparacion=-1;
			}
		}
		
		return comparacion;
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

	
}
