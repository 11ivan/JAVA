
public class MetodosFacturaRestaurante {
	
	
//_____________________________________________________________________________________________________________________________	
	/*	validaCantidad
	 * Proposito: Dada una cadena, pasarla a entero y comprobar que la cantidad sea mayor que 0
	 * Prototipo: boolean validaCantidad(String cantidad)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: un booleano
	 * E/S:
	 * Postcondiciones: El booleano será true si la cantidad es mayor que 0, y false si es 0 o menor.
	 * */
	public static boolean validaCantidad(String cantidad){
		boolean valido=false;
		int cantidadint;
		
		cantidadint=Integer.parseInt(cantidad);
		if(cantidadint>0){
			valido=true;
		}		
		return valido;
	}
	
//_____________________________________________________________________________________________________________________________	
	
	/*	validaCantidad
	 * Proposito: Dada una cadena, pasarla a entero y comprobar que la cantidad sea mayor que 0
	 * Prototipo: boolean validaCantidad(String cantidad)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: un booleano
	 * E/S:
	 * Postcondiciones: El booleano será true si la cantidad es mayor que 0, y false si es 0 o menor.
	 * */
	public static boolean validaCantidad(int cantidad){
		boolean valido=false;
		
		if(cantidad>0){
			valido=true;
		}		
		return valido;
	}
	
//_____________________________________________________________________________________________________________________________	
		
	/*	validaPrecio
	 * Proposito: Dada una cadena, pasarla a decimal y comprobar que la catidad sea mayor que 0
	 * Prototipo: boolean validaPrecio(String precio)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: un booleano
	 * E/S:
	 * Postcondiciones: El booleano será true si el precio es mayor que 0, y false si es 0 o menor.
	 * */
	public static boolean validaPrecio(String precio){
		boolean valido=false;
		Double preciodec=new Double(precio);

		if(preciodec>0){
			valido=true;
		}
		return valido;
	}
	
		
//_____________________________________________________________________________________________________________________________		
		
	/*	obtenerImporte
	 * Proposito: Dada dos cadenas, cantidad y precio, pasarlas a decimal y obtener el importe
	 * Prototipo: double obtenerImporte(String cantidad, String precio)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: un booleano
	 * E/S:
	 * Postcondiciones: El booleano será true si el precio es mayor que 0, y false si es 0 o menor.
	 * */
	public static String obtenerImporte(String cantidad, String precio){
		Double preciodec=new Double(precio);
		Double cantidaddec=new Double(cantidad);
		Double importe=preciodec*cantidaddec;
		String importecadena=importe.toString();
		
		return importecadena;
	}
	
		
//_____________________________________________________________________________________________________________________________		
	
	/*	obtenerTotal
	 * Proposito: Dada dos cadenas, cantidad y precio, pasarlas a decimal y obtener el importe
	 * Prototipo: double obtenerImporte(String cantidad, String precio)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: un booleano
	 * E/S:
	 * Postcondiciones: El booleano será true si el precio es mayor que 0, y false si es 0 o menor.
	 * */
	public static double obtenerTotal(double total,String importe){
		Double importedec=Double.parseDouble(importe);
		double total2=total+importedec;
		
		return total2;
	}
	
		
//_____________________________________________________________________________________________________________________________		
	
	/*	pintaFactura
	 * Proposito: Dado un array bidimensional pitar la factura de modo que quede así:
	
	Concepto	Nombre	Cantidad	Precio	Importe
	  ---		  ---	   ---		  ---	  ---
	  ---		  ---	   ---		  ---	  ---
	  												Total
	  												 ---

	 * Prototipo: void pintaFactura(String[][] factura)
	 * Precondiciones: No hay
	 * Entradas: Una cadena
	 * Salidas: un booleano
	 * E/S:
	 * Postcondiciones: El booleano será true si el precio es mayor que 0, y false si es 0 o menor.
	 * */
	public static void pintaFactura(String[][] factura){
		double total=0;
		//factura[3].length
		//int segundaposicion=factura[].length;
		
		for(int i=0;i<factura[i].length;i++){
			int contador=0;
			
			for(int j=0;j<factura.length;j++){
				//if(i>0){
					System.out.print(factura[j][i]+"\t");
				//}else{
						//System.out.print("\t"+factura[j][i]+"\t");
						//}
				contador=j;
			}
			if(i>0){
				total=obtenerTotal(total,factura[contador][i]);//Debo mandar i+1 para que no me coja importe(posicion 0) y me coja la posicion 1, pero que cuando llegue 
													   //al final no se desborde.
			}
			System.out.println("");	
		}
		System.out.println("\t\t\t\t\t\t\t\t\t Total: "+total);	
	}
			
//_____________________________________________________________________________________________________________________________		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
