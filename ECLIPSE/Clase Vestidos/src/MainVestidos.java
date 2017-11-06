/*Analisis
 * 	Proposito: Programa para realizar pedidos de vestidos.
 * 	Entradas: Ejecuta>> cadena
 * 			  Codigo vestido>> cadena
 * 			  Cantidad>> Cadena
 * 	Salidas: No hay
 * 	Restricciones: Ejecuta solo será SI o NO.
 * 				   Codigo vestido debe tener tres digitos enteros
 * 				   Cantidad debe ser mayor que 0
 * 
 * 	Pseudocodigo Generalizado
 * 	INICIO
 * 		LEER Y VALIDAR SI EJECUTA*
 * 		MIENTRAS EJECUTA SEA SI
 * 			REPETIR
	  			LEER Y VALIDAR CODIGO*
	  			LEER Y VALIDAR CANTIDAD*
	  			AÑADIR AL PEDIDO*
	  			LEER Y VALIDAR SI INTRODUCE OTRO ARTICULO*
 * 			MIENTRAS INTRODUCIR SEA SI
 * 			VOLVER A LEER Y VALIDAR SI EJECUTA*
 * 		FIN MIENTRAS
 * 	FIN
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
public class MainVestidos {
	public static void main(String[] args)throws IOException {
		Vestido vestido=null;
		Vestido vestido2=null;
		Vestido vestido3=null;
		Vestido vestido4=null;
		Vestido vestido5=null;
		Vestido vestido6=null;
		Vestido vestido7=null;
		Vestido vestido8=null;
		Vestido vestido9=null;
		Vestido vestido10=null;
		Disenos disenos=new Disenos();
		Pedido pedido=new Pedido();
		ArrayList <Pedido> listaPedidos=new ArrayList<Pedido>();
		Compra compra=null;
		String ejecuta=" ";
		String introduce=" ";
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		gestoraMain gestora=new gestoraMain();
		String cantidad, codigo;
		int contador=0;
		Pedido copia=null;
		
		try{
			vestido=new Vestido("Gala",109.95,"455");
			vestido2=new Vestido("Informal",56.40,"201");
			vestido3=new Vestido("Tarde",40.95,"106");
			vestido4=new Vestido("Boda",35.30,"050");
			vestido5=new Vestido("Chandal",70.50,"789");
			vestido6=new Vestido("Vestido 2",55.0,"845");
			vestido7=new Vestido("Vestido 3",25.0,"012");
			vestido8=new Vestido("Vestido 4",36.0,"215");
			vestido9=new Vestido("Vestido 5",14.0,"990");
			vestido10=new Vestido("Vestido 6",24.0,"001");
		}catch(ExcepcionVestido error){
			System.out.println(error);
		}
		
		
		try{
			disenos.addVestido(vestido);
			disenos.addVestido(vestido2);
			disenos.addVestido(vestido3);
			disenos.addVestido(vestido4);
			disenos.addVestido(vestido5);
			disenos.addVestido(vestido6);
			disenos.addVestido(vestido7);
			disenos.addVestido(vestido8);
			disenos.addVestido(vestido9);
			disenos.addVestido(vestido10);		
		}catch(ExcepcionDisenos error){
			System.out.println(error);
		}
		
		//Leer y validar si introduce pedido
		do{
			System.out.println("¿Quiere introducir un pedido? SI/NO");
			introduce=bf.readLine();
		}while(introduce.equals("SI") && introduce.equals("NO"));
		
		//Mientras INTRODUCE sea SI
		while(introduce.equals("SI")){
		
			//Mientras INTRODUCE sea SI
			while(introduce.equals("SI")){
			
				//MIENTRAS INTRODUCE SEA SI
				while(introduce.equals("SI")){
					
					//PINTA LISTA VESTIDOS*
					System.out.println("\nElija el diseño\n");
					disenos.pintaLista();
					
					//LEER Y VALIDAR CODIGO*
					do{
						System.out.println("\nIntroduzca el codigo");
						codigo=bf.readLine();
					}while(! gestora.validaCodigo(codigo, disenos));
						
					//LEER Y VALIDAR CANTIDAD*
					do{
						System.out.println("Introduzca la cantidad");
						cantidad=bf.readLine();
					}while(! gestora.validaCantidad(cantidad));	
					
					//AÑADIR AL PEDIDO*
					compra=gestora.creaCompra(codigo, cantidad, disenos);
					pedido.addCompra(compra);
				
					//LEER Y VALIDAR SI INTRODUCE OTRA COMPRA*
					do{
						System.out.println("¿Quiere introducir otra ficha al pedido? SI/NO");
						introduce=bf.readLine();
					}while(!gestora.validaIntroduce(introduce));
									
				}//Fin Mientras Introducir compra	
				
				//ORDENAR PEDIDO*			
				//pedido.ordenaPedido();
				Collections.sort(pedido.getPedido());
				//pedido.paintPedido();	
				
				
				//AÑADIR A LA LISTA DE PEDIDOS
				copia=gestora.copiaPedido(pedido);
				//copia=pedido.cloneProf();
				
				listaPedidos.add(copia);
				pedido.getPedido().clear();
				
				//Volver a Leer y validar si introduce pedido**
				do{
					System.out.println("¿Quiere introducir otro pedido?");
					introduce=bf.readLine();
				}while(introduce.equals("SI") && introduce.equals("NO"));
				
			}//FIN MIENTRAS Introducir pedido
						
			//PINTAR LISTA DE PEDIDOS*
			gestora.paintListaPedidos(listaPedidos);
			
			//LEER Y VALIDAR SI EJECUTA DE NUEVO
			do{
				System.out.println("¿Quiere volver a ejecutar?");
				introduce=bf.readLine();
			}while(introduce.equals("SI") && introduce.equals("NO"));
		}
		
		
	
		
		
	}
}
