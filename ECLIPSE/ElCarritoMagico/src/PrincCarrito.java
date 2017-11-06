
/*
 * Analisis
 * 	Comentario: El supermercado “El carrito mágico” necesita de su ayuda para la creación de un programa
 * 			    que automatice el proceso de ventas de éste. El dueño del supermercado necesita que cada
 * 			    uno de sus productos este codificado (para lo cuál puede usar la clasificación de familias
 * 				de productos, por ej. Fideos, y luego una clasificación de un producto particular dentro de
 * 				esta familia, por ej. Ravioles marca “La casa” de 250 grs.) y que se mantenga la información
 * 				de relevancia de estos, junto a su precio. La idea es que cuando el cliente pase por la caja,
 * 				la cajera ingrese el código del producto o su nombre, la cantidad que el cliente lleva de ese
 * 				producto y automáticamente el sistema le entregue el precio por cada producto y le genere la
 * 				factura final, donde, además de aparecer el monto de la compra, debe aparecer la cantidad de
 * 				artículos que el cliente lleva.
 * 				Se necesita, además, generar un listado de los productos más vendidos, los montos vendidos en
 * 				un día y el listado de clientes que compra en el supermercado.
 * 
 * 
 * PseudoCodigo	
INICIO
	//PRESENTAR MENU LEER Y VALIDAR OPCION*
	//SEGUN OPCION
		CASE1:	LEER Y VALIDAR LOGIN*
					//SEGUN TIPO USUARIO
			
						CASE 1: //TIPO OPERARIO
				
						CASE 2:	//TIPO CLIENTE
					//FIN SEGUN

		CASE 2: REGISTRARSE
	//FIN SEGUN	
FIN
 */

//nivel 2
/*--CASE 1: TIPO OPERARIO
 			//PRESENTAR MENU LEER Y VALIDAR OPCION*
 			//MIENTRAS OPCION NO SEA SALIR
 			//SEGUN OPCION
				CASE 1: VER LISTA DE PRODUCTOS*
				CASE 2: INSERTAR PRODUCTO
				CASE 3: DESACTIVAR PRODUCTO
				CASE 4: ACTIVAR PRODUCTO 
				CASE 5: AÑADIR PRODUCTO AL PEDIDO
				CASE 6: SOLTAR PRODUCTO
				CASE 7: VER PEDIDO*
				CASE 8: REALIZAR PEDIDO* 
				CASE 9: VACIAR PEDIDO*
			//FIN SEGUN 
			//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
			//FIN MIENTRAS
*/



//nivel 2
/*--CASE 2: //TIPO CLIENTE
 			//PRESENTAR MENU LEER Y VALIDAR OPCION*
 			//MIENTRAS OPCION NO SEA SALIR
 			//SEGUN OPCION
				CASE 1: AÑADIR UN PRODUCTO
				CASE 2: SOLTAR PRODUCTO*
				CASE 3: PASAR POR CAJA*
				CASE 4: SALIR SIN COMPRAR*
			//FIN SEGUN 
			//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
			//FIN MIENTRAS
*/



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JPasswordField;
import java.io.Console;

public class PrincCarrito {
	public static void main(String[] args){
		
		//JPasswordField passField = new JPasswordField();
		Console terminal = null;
		String opcion=" ";
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String nombreusuario=" ";
		char[] password=new char[0];
		char[] passwordVer=new char[0];
		GestoraCarrito gestora=new GestoraCarrito();
		GestoraConexion gestConnect=new GestoraConexion();
		boolean vale=false;
		UsuarioImpl usuario=null;
		ProductoImpl producto=null;
		String nombreProducto=" ";
		boolean  productoBorrado=false;
		String sigueComprando=" ";
		VentaImpl venta=null;
		String idProducto=" ";
		String cantidadElegida =" ";
		Integer stockProducto=0;
		String idCategoria=" ";
		String posicionProducto=" ";
		String cantidadSuelta=" ";
		PedidoImpl pedido=null;
		Scanner teclado =new Scanner(System.in);
		String idProveedor=" ";
		
		try{
			gestConnect.creaFicheroConexion("jdbc:sqlserver://localhost", "pepito", "qq");
			gestConnect.connect();
		//PRESENTAR MENU LEER Y VALIDAR OPCION*
		do{
			gestora.menuPrincipal();
			opcion=br.readLine();
		}while(!gestora.validaOpcion(opcion, 2));		
		
		//MIENTRAS OPCION SEA DISTINTA DE SALIR
		while(!opcion.equals("0")){
				switch(Integer.parseInt(opcion)){
				
					case 1:	//INICIAR SESION
							
								//LEER Y VALIDAR LOGIN*
								do{
									System.out.println("\nIntroduzca el nombre de usuario");
									nombreusuario=br.readLine();
									
									/* if (terminal == null) {
								            System.out.println("Couldn't get Console instance");
								            System.exit(0);
								        }

									 	terminal.printf("Testing password%n");
								        password = terminal.readPassword("Enter your secret password: ");
								        Arrays.fill(password, ' ');
								        terminal.printf("Password entered was: %s%n", new String(password));*/

									 /*if ((terminal = System.console()) != null && (password = terminal.readPassword("[%s]", "Password:")) != null) {
									     java.util.Arrays.fill(password, ' ');
									 }*/
									 
									System.out.println("\nIntroduzca la contraseña");
									password=br.readLine().toCharArray();
									//password=terminal.readPassword("[%s]", "Password:");
									//password=terminal.readPassword();
									vale=gestConnect.validaUsuario(nombreusuario, new String(password));
									if(!vale){
										System.out.println("\nUsuario incorrecto");
									}
								}while(!vale);
								vale=false;
							
								//SEGUN TIPO USUARIO*
								switch(gestConnect.getTipoUsuario(nombreusuario)){
								
									case "Operario": //TIPO OPERARIO
																				//System.out.println("Eres Operario");
													pedido=new PedidoImpl();
													pedido.setIDUsuario(gestConnect.getIDUsuario(nombreusuario));
										 			//PRESENTAR MENU LEER Y VALIDAR OPCION*
													do{
														gestora.menuOperario();												
														opcion=br.readLine();
													}while(!gestora.validaOpcion(opcion, 9));
													
										 			//MIENTRAS OPCION NO SEA SALIR
													while(!opcion.equals("0")){
											 			switch(opcion){
													 			case "1": //VER LISTA DE PRODUCTOS*
													 					  gestConnect.muestraProductosOperario();
													 				
													 			break;
													 			
													 			
													 			case "2": //INSERTAR PRODUCTO*
													 					producto=new ProductoImpl();
													 					
													 					//LEER Y VALIDAR NOMBRE
													 					do{
													 						vale=true;
													 					
														 					System.out.println("\nInserte el nombre del producto");
																			try {
																				producto.setNombre(br.readLine());
																			} catch (ExcepcionProducto e) {
																				System.out.println(e);
																				vale=false;
																			}
													 					}while(!vale);
													 					
													 					//LEER Y VALIDAR DESCRIPCION
													 					do{
													 						vale=true;
													 					
														 					System.out.println("\nInserte la descripción del producto");
																			try {
																				producto.setDescripcion(br.readLine());
																			} catch (ExcepcionProducto e) {
																				System.out.println(e);
																				vale=false;
																			}
													 					}while(!vale);
	
													 					//LEER Y VALIDAR PRECIO
													 					do{
													 						vale=true;
													 					
														 					System.out.println("\nInserte el precio del producto");
																			try {
																				producto.setPrecio(br.readLine());
																			} catch (ExcepcionProducto e) {
																				System.out.println(e);
																				vale=false;
																			}
													 					}while(!vale);
	
													 					//LEER Y VALIDAR STOCK
													 					do{
													 						vale=true;
													 					
														 					System.out.println("\nInserte el stock actual del producto");
																			try {
																				producto.setStockage(br.readLine());
																			} catch (ExcepcionProducto e) {
																				System.out.println(e);
																				vale=false;
																			}
													 					}while(!vale);
	
													 					//LEER Y VALIDAR CATEGORIA
													 					do{
													 						//vale=true;
													 						
													 						//MOSTRAR CATEGORIAS
													 						gestConnect.muestraCategorias();
													 						
														 					System.out.println("\nInserte el ID de la categoría del producto");
																			producto.setIDCategoria(br.readLine());
																			
																			//vale=false;
																			
													 					}while(!gestConnect.compruebaCategoria(producto.getIDCategoria()));												 																	 					
													 					
													 					gestConnect.addProducto(producto);
													 			break;
													 			
													 			
													 			case "3": //DESACTIVAR PRODUCTO*											 					 
													 					  do{
													 						 gestConnect.muestraProductosOperario();
													 						 System.out.println("\nIntroduzca el ID del producto");
													 						idProducto=br.readLine();
													 					  }while (!gestConnect.compruebaProductoActivo(idProducto));

														 				  if(gestConnect.desactivaProducto(idProducto)){
														 					  System.out.println("\nProducto desactivado");
														 				  }else{
														 					  System.out.println("\nEl producto no existe");
														 				  }
														 		break;
														 		
													 			case "4": //ACTIVAR PRODUCTO*													 					  
													 					  do{
													 						 gestConnect.muestraProductosOperario();
													 						 System.out.println("\nIntroduzca el ID del producto");
													 						idProducto=br.readLine();
													 					  }while(gestConnect.compruebaProductoActivo(idProducto));
	
														 				  if(gestConnect.activaProducto(idProducto)){
														 					  System.out.println("\nProducto activado");
														 				  }else{
														 					  System.out.println("\nEl producto no existe");
														 				  }
													 		break;
		
														 		
													 			case "5": //AÑADIR PRODUCTO AL PEDIDO
													 				
												 					  	producto=new ProductoImpl();
																	 
																		//PRESENTAR MENU LEER Y VALIDAR OPCION
																		do{
																			gestora.menuVenta();
																			opcion=br.readLine();
																		}while(!gestora.validaOpcion(opcion, 2));
																		
																	 	//MIENTRAS OPCION NO SEA SALIR
																		while(!opcion.equals("0")){
																	 		switch(opcion){
																	   
																		 		case "1":   do{
																			 					//MOSTRAR TODOS LOS PRODUCTOS*
																			 					gestConnect.muestraProductosOperario();
																				   				//LEER Y VALIDAR CODIGO PRODUCTO *
																			 					System.out.println("\nIntroduzca el ID del producto");
																			 					idProducto = br.readLine();
																		 					}while(!gestConnect.compruebaProductoActivo(idProducto));
																		 		
																			   				//LEER Y VALIDAR CANTIDAD*
																		 					do{
																		 						//MOSTRAR CANTIDAD DISPONIBLE*
																		 						stockProducto=gestConnect.stockProducto(idProducto);
																		 						System.out.println("\nIntroduzca la cantidad que quiere");
																		 						System.out.println("\nStock del producto:"+ stockProducto);
																		 						cantidadElegida = br.readLine();
																		 					}while(gestora.compruebaMayor(cantidadElegida, pedido.cantidadProducto(Integer.parseInt(idProducto)), stockProducto)==1);
																		 					
																		 					
																			   				//AÑADIR A LA VENTA*		
																		 					if(pedido.productExists(idProducto)){
																		 						pedido.getCantidades().set(pedido.indexProduct(idProducto), (Integer.parseInt(cantidadElegida)+pedido.getCantidades().get(pedido.indexProduct(idProducto))));
																		 					}else{
																		 						producto=gestConnect.getProducto(idProducto);
																		 						pedido.getListaProductos().add(producto);																			   				
																		 						pedido.getCantidades().add(Integer.parseInt(cantidadElegida));
																		 					}
																		 		break;
																		 			
																		 		case "2":   do{
																			 					//MOSTRAR POR CATEGORIA*
																			 					gestConnect.muestraCategorias();
																		 						//LEER Y VALIDAR CATEGORIA PRODUCTO *
																			 					System.out.println("\nIntroduzca el id de la categoría");
																			 					idCategoria=br.readLine();
																		 					}while(!gestConnect.compruebaCategoria(idCategoria));
																		 		
																					 		do{
																			 					//MOSTRAR TODOS LOS PRODUCTOS POR CATEGORIA*
																			 					gestConnect.productosPorCategoriaOperario(idCategoria);
																			 					
																				   				//LEER Y VALIDAR CODIGO PRODUCTO *						//debe ser de los que aparezcan en el filtrado por categoria
																			 					System.out.println("\nIntroduzca el ID del producto");
																			 					idProducto = br.readLine();
																		 					}while(!gestConnect.compruebaProductoPorCategoria(idProducto, idCategoria) && !gestConnect.compruebaProductoActivo(idProducto));
																					 		
																					 		//LEER Y VALIDAR CANTIDAD*
																		 					do{
																		 						//MOSTRAR CANTIDAD DISPONIBLE*
																		 						stockProducto=gestConnect.stockProducto(idProducto);
																		 						System.out.println("\nIntroduzca la cantidad que quiere");
																		 						System.out.println("\nStock del producto:"+ stockProducto);
																		 						cantidadElegida = br.readLine();
																		 					}while(gestora.compruebaMayor(cantidadElegida, pedido.cantidadProducto(Integer.parseInt(idProducto)), stockProducto)==1);
																		 					
																		 					
																			   				//AÑADIR A LA VENTA*
																		 					if(pedido.productExists(idProducto)){
																		 						pedido.getCantidades().set(pedido.indexProduct(idProducto), Integer.parseInt(cantidadElegida)+pedido.getCantidades().get(pedido.indexProduct(idProducto)));
																		 					}else{
																		 						producto=gestConnect.getProducto(idProducto);
																		 						pedido.getListaProductos().add(producto);																			   				
																		 						pedido.getCantidades().add(Integer.parseInt(cantidadElegida));
																		 					}
																		 		break;
																	 		}//FIN SEGUN
																	 		//LEER Y VALIDAR SI AÑADE OTRO PRODUCTO
																	 		do{
																				System.out.println("\n¿Quiere añadir otro producto?");
																				sigueComprando=br.readLine();
																			}while(!sigueComprando.equalsIgnoreCase("s") && !sigueComprando.equalsIgnoreCase("n"));
																	 		
																	 		if(sigueComprando.equalsIgnoreCase("s")){
																	 			
																	 			//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
																				do{
																					gestora.menuVenta();
																					opcion=br.readLine();
																				}while(!gestora.validaOpcion(opcion, 2));
																	 		}else{
																	 			opcion="0";
																	 		}				
																		}//fin mientras
													 				
														 		break;
														 		
														 		case "6"://SOLTAR PRODUCTO*
													 					  if(pedido.getListaProductos().size()==0){
													 						 System.out.println("\nNo tiene ningún producto en el carrito");
													 						 
													 					  }else{
													 						 //LEER Y VALIDAR POSICION PRODUCTO
													 						  do{
													 							 pedido.muestraProductos();
													 							  System.out.println("\nIntroduzca la posición del producto");
													 							  posicionProducto=br.readLine();
													 							 // System.out.println(venta.getListaProductos().size());//
													 							  //System.out.println(gestora.validaOpcion(String.valueOf(Integer.parseInt(posicionProducto)-1), venta.getListaProductos().size()-1));
													 						  }while(!gestora.validaOpcion(String.valueOf(Integer.parseInt(posicionProducto)-1), pedido.getListaProductos().size()-1));
													 						  
													 						  //LEER Y VALIDAR CANTIDAD
													 						 do{																		  
													 							  System.out.println("\nIntroduzca la cantidad que quiere soltar");
													 							  System.out.println("Cantidad actual: "+pedido.cantidadProducto(pedido.getCantidades().get(Integer.parseInt(posicionProducto)-1)));
													 							  cantidadSuelta=br.readLine();
													 						  }while(gestora.compruebaMayor(pedido.getCantidades().get(Integer.parseInt(posicionProducto)-1), cantidadSuelta)==-1);
													 						  
													 						pedido.getCantidades().set(Integer.parseInt(posicionProducto)-1, (pedido.getCantidades().get(Integer.parseInt(posicionProducto)-1)-Integer.parseInt(cantidadSuelta)));
												 							  
													 						pedido.dropProductoCantidad(Integer.parseInt(posicionProducto)-1);												 						 												 		
													 					  }											 				
												 				
												 			break;
												 			
												 			case "7": //VER PEDIDO*
												 					  if(pedido.getListaProductos().size()>0){
												 						 pedido.muestraCantidadesProductos();						 				
												 						  System.out.println("\nPrecio Total del pedido: "+pedido.getPrecioPedido());
												 					  }else{
												 						  System.out.println("\nEl carrito está vacío");
												 					  }
													 		break;
												 			
													 		case "8": 	//REALIZAR PEDIDO*													 		
													 					if(pedido.getListaProductos().size()>0){
													 						//LEER Y VALIDAR ID PROVEEDOR*
													 						do{
													 							gestConnect.muestraProveedores();
													 							System.out.println("Introduzca el ID del proveedor");
													 							idProveedor=br.readLine();
													 						}while(!gestConnect.compruebaIDProveedor(idProveedor));
													 						pedido.setIDProveedor(idProveedor);
													 						
														 					//REGISTRAR VENTA EN LA BASE DE DATOS*													 						
													 						gestConnect.regPedido(pedido);
	
														 					//VACIAR LA VENTA*
													 						pedido.getCantidades().clear();
													 						pedido.getListaProductos().clear();	
													 					}
													 		break;
													 			

												 			case "9": 	//VACIAR VENTA*
												 						if(pedido.getListaProductos().size()>0){
												 							pedido.getCantidades().clear();
												 							pedido.getListaProductos().clear();		
												 						}
													 		break;								
											 			}//FIN SEGUN 
											 			
														//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
														do{
															gestora.menuOperario();
															opcion=br.readLine();
	
														}while(!gestora.validaOpcion(opcion, 9));
	
													}//FIN MIENTRAS
	
										
									break;//broke type operator
									
									case "Cliente": //TIPO CLIENTE
																						//System.out.println("Eres Cliente");	
													venta=new VentaImpl();
													venta.setIDUsuario(gestConnect.getIDUsuario(nombreusuario));
													
										 			//PRESENTAR MENU LEER Y VALIDAR OPCION*
													do{
														gestora.menuCliente();
														opcion=br.readLine();
													}while(!gestora.validaOpcion(opcion, 6));
													
										 			//MIENTRAS OPCION NO SEA SALIR
													while(!opcion.equals("0")){
														
											 			switch(opcion){
											
												 			case "1": //MOSTRAR PRODUCTOS*
												 					  gestConnect.muestraProductosCliente();											 															 				
												 			break;
												 				
												 			case "2": //AÑADIR PRODUCTO
												 					  producto=new ProductoImpl();
																	 
																		//PRESENTAR MENU LEER Y VALIDAR OPCION
																		do{
																			gestora.menuVenta();
																			opcion=br.readLine();
																		}while(!gestora.validaOpcion(opcion, 2));
																		
																	 	//MIENTRAS OPCION NO SEA SALIR
																		while(!opcion.equals("0")){
																	 		switch(opcion){
																	   
																		 		case "1":   do{
																			 					//MOSTRAR TODOS LOS PRODUCTOS*
																			 					gestConnect.muestraProductosCliente();																				   				//LEER Y VALIDAR CODIGO PRODUCTO *
																			 					System.out.println("\nIntroduzca el ID del producto");
																			 					idProducto = br.readLine();
																		 					}while(!gestConnect.compruebaProducto(idProducto));
																		 		
																			   				//LEER Y VALIDAR CANTIDAD*
																		 					do{
																		 						//MOSTRAR CANTIDAD DISPONIBLE*
																		 						stockProducto=gestConnect.stockProducto(idProducto);
																		 						System.out.println("\nIntroduzca la cantidad que quiere");
																		 						System.out.println("\nStock del producto:"+ stockProducto);
																		 						cantidadElegida = br.readLine();
																		 					}while(gestora.compruebaMayor(cantidadElegida, venta.cantidadProducto(Integer.parseInt(idProducto)), stockProducto)==1);
																		 					
																		 					
																			   				//AÑADIR A LA VENTA*		
																		 					if(venta.productExists(idProducto)){
																		 						venta.getCantidades().set(venta.indexProduct(idProducto), (Integer.parseInt(cantidadElegida)+venta.getCantidades().get(venta.indexProduct(idProducto))));
																		 					}else{
																		 						producto=gestConnect.getProducto(idProducto);
																		 						venta.getListaProductos().add(producto);																			   				
																		 						venta.getCantidades().add(Integer.parseInt(cantidadElegida));
																		 					}
																		 		break;
																		 			
																		 		case "2":   do{
																			 					//MOSTRAR POR CATEGORIA*
																			 					gestConnect.muestraCategorias();
																		 						//LEER Y VALIDAR CATEGORIA PRODUCTO *
																			 					System.out.println("\nIntroduzca el id de la categoría");
																			 					idCategoria=br.readLine();
																		 					}while(!gestConnect.compruebaCategoria(idCategoria));
																		 		
																					 		do{
																			 					//MOSTRAR TODOS LOS PRODUCTOS POR CATEGORIA*
																			 					gestConnect.productosPorCategoria(idCategoria);
																			 					
																				   				//LEER Y VALIDAR CODIGO PRODUCTO *						//debe ser de los que aparezcan en el filtrado por categoria
																			 					System.out.println("\nIntroduzca el ID del producto");
																			 					idProducto = br.readLine();
																		 					}while(!gestConnect.compruebaProductoPorCategoria(idProducto, idCategoria));
																					 		
																					 		//LEER Y VALIDAR CANTIDAD*
																		 					do{
																		 						//MOSTRAR CANTIDAD DISPONIBLE*
																		 						stockProducto=gestConnect.stockProducto(idProducto);
																		 						System.out.println("\nIntroduzca la cantidad que quiere");
																		 						System.out.println("\nStock del producto:"+ stockProducto);
																		 						cantidadElegida = br.readLine();
																		 					}while(gestora.compruebaMayor(cantidadElegida, venta.cantidadProducto(Integer.parseInt(idProducto)), stockProducto)==1);
																		 					
																		 					
																			   				//AÑADIR A LA VENTA*
																		 					if(venta.productExists(idProducto)){
																		 						venta.getCantidades().set(venta.indexProduct(idProducto), Integer.parseInt(cantidadElegida)+venta.getCantidades().get(venta.indexProduct(idProducto)));
																		 					}else{
																		 						producto=gestConnect.getProducto(idProducto);
																		 						venta.getListaProductos().add(producto);																			   				
																		 						venta.getCantidades().add(Integer.parseInt(cantidadElegida));
																		 					}
																		 		break;
																	 		}//FIN SEGUN	
																	 		
																	 		//LEER Y VALIDAR SI AÑADE OTRO PRODUCTO
																	 		do{
																				System.out.println("\n¿Quiere añadir otro producto?");
																				sigueComprando=br.readLine();
																			}while(!sigueComprando.equalsIgnoreCase("s") && !sigueComprando.equalsIgnoreCase("n"));
																	 		
																	 		if(sigueComprando.equalsIgnoreCase("s")){
																	 			
																	 			//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
																				do{
																					gestora.menuVenta();
																					opcion=br.readLine();
																				}while(!gestora.validaOpcion(opcion, 2));
																	 		}else{
																	 			opcion="0";
																	 		}																	 		
																		}//FIN MIENTRAS											 				
												 				
												 			break;

												 			case "3": //SOLTAR PRODUCTO*
												 					  if(venta.getListaProductos().size()==0){
												 						 System.out.println("\nNo tiene ningún producto en el carrito");
												 						 
												 					  }else{
												 						 //LEER Y VALIDAR POSICION PRODUCTO
												 						  do{
												 							  venta.muestraProductos();
												 							  System.out.println("\nIntroduzca la posición del producto");
												 							  posicionProducto=br.readLine();
												 							 // System.out.println(venta.getListaProductos().size());//
												 							  //System.out.println(gestora.validaOpcion(String.valueOf(Integer.parseInt(posicionProducto)-1), venta.getListaProductos().size()-1));
												 						  }while(!gestora.validaOpcion(String.valueOf(Integer.parseInt(posicionProducto)-1), venta.getListaProductos().size()-1));
												 						  
												 						  //LEER Y VALIDAR CANTIDAD
												 						 do{																		  
												 							  System.out.println("\nIntroduzca la cantidad que quiere soltar");
												 							  System.out.println("Cantidad actual: "+venta.cantidadProducto(venta.getCantidades().get(Integer.parseInt(posicionProducto)-1)));
												 							  cantidadSuelta=br.readLine();
												 						  }while(gestora.compruebaMayor(venta.getCantidades().get(Integer.parseInt(posicionProducto)-1), cantidadSuelta)==-1);
												 						  
											 							  venta.getCantidades().set(Integer.parseInt(posicionProducto)-1, (venta.getCantidades().get(Integer.parseInt(posicionProducto)-1)-Integer.parseInt(cantidadSuelta)));
											 							  
											 							  venta.dropProductoCantidad(Integer.parseInt(posicionProducto)-1);												 						 												 		
												 					  }											 				
												 				
												 			break;
												 			
												 			case "4": //VER VENTA*
												 					  if(venta.getListaProductos().size()>0){
												 						  venta.muestraCantidadesProductos();						 				
												 						  System.out.println("\nPrecio Total del pedido: "+venta.getPrecioVenta());
												 					  }else{
												 						  System.out.println("\nEl carrito está vacío");
												 					  }
													 		break;
												 			
													 		case "5": 	//REALIZAR PEDIDO*													 		
													 					if(venta.getListaProductos().size()>0){
														 					//REGISTRAR VENTA EN LA BASE DE DATOS*
													 						gestConnect.regVenta(venta);
													 						//gestConnect.aver(venta);
														 					//VACIAR LA VENTA*
														 			 	  	venta.getCantidades().clear();
														 			 	  	venta.getListaProductos().clear();	
													 					}
													 		break;
													 			

												 			case "6": 	//VACIAR VENTA*
												 						if(venta.getListaProductos().size()>0){
												 							venta.getCantidades().clear();
												 							venta.getListaProductos().clear();		
												 						}
													 		break;
													 			

											 			}//FIN SEGUN 
											 			
														//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION
														do{
															gestora.menuCliente();
															opcion=br.readLine();
														}while(!gestora.validaOpcion(opcion, 6));

													}//FIN MIENTRAS
										
									break;//broke type client		
								}//fin segun 
					break;//fin iniciar sesion
					
					
					case 2: //REGISTRARSE
							usuario=new UsuarioImpl();
							//LEER Y VALIDAR USUARIO Y CONTRASEÑA
							do{
								vale=true;
								do{
									System.out.println("\nIntroduzca el nombre de usuario");
									try {							
										nombreusuario=br.readLine();
										usuario.setNombre(nombreusuario);
									} catch (ExcepcionUsuarioImpl e) {
										System.out.println(e);
										vale=false;
									}
								}while(!vale);
								
								
								do{							
									do{
										vale=true;
										System.out.println("\nIntroduzca la contraseña");
										try{						
											password=terminal.readPassword();									
											usuario.setPassword(new String(password));
										}catch(ExcepcionUsuarioImpl e){
											System.out.println(e);
											vale=false;
										}
									}while(!vale);
									
									System.out.println("\nRepita la contraseña");
									
									passwordVer=terminal.readPassword();
	
									vale=gestora.verifyPass(new String(password), new String(passwordVer));
									if(!vale){
										System.out.println("\nNo coinciden las contraseñas");
									}
								}while(!vale);
								
								vale=false;
								try {
									usuario.setTipo("\nCliente");
								} catch (ExcepcionUsuarioImpl e) {
									System.out.println(e);
								}
								vale=gestConnect.addUser(usuario);
								if(!vale){
									System.out.println("\nEl usuario ya existe");
								}
							}while(!vale);
							vale=false;
					break;
				
				
				}//FIN SEGUN	
		
				
				//VOLVER A PRESENTAR MENU LEER Y VALIDAR OPCION*
				do{
					gestora.menuPrincipal();
					opcion=br.readLine();		
				}while(!gestora.validaOpcion(opcion, 2));		
	
			}//FIN MIENTRAS
		} catch (IOException e) {
			e.printStackTrace();
		}catch(NullPointerException error){
			error.printStackTrace();
		}
		
		gestConnect.close();
	}	
}
	
	
	
