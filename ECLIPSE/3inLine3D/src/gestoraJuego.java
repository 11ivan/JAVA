
import java.util.Random;

public class gestoraJuego {
	
	private cubo3D cubo;
	
	//Constructor
	public gestoraJuego(){
		cubo=new cubo3D();
	}
	
	
	
	public cubo3D getCubo(){
		return cubo;
	}
	
	
	
//----------------------------------------------------------------------------------------------------		
	
	//validaJuega
	/*Proposito: Dada una cadena comprueba que sea "s" o "n"
	 * Prototipo: boolean validaJuega(String juega)
	 * Precondiciones: No hay
	 * Entradas: una cadena
	 * E/S: no hay
	 * Salidas: un booleano
	 * Postcondiciones: El booleano sera verdadero si la cadena es "s" o "n"
	 */			
	public boolean validaJuega(String juega){
		boolean valido=false;
		//String noespacios=juega.replace(" ","");
		
		if(juega.equals("s") || juega.equals("n")){
			valido=true;
		}
		return valido;
	}
	
//----------------------------------------------------------------------------------------------------	
	
	//tiraDado
	/*Proposito: Devuelve un número aleatorio entre 1 y 6 incluidos
	 * Prototipo: int tiraDado()
	 * Precondiciones: No hay
	 * Entradas: no hay
	 * E/S: no hay
	 * Salidas: un entero 
	 * Postcondiciones: El entero es un numero aleatorio entre 1 y 6 incluidos
	 */		
	public int tiraDado(){
		Random aleatorio=new Random();
		return aleatorio.nextInt(6)+1;
	}
	
//----------------------------------------------------------------------------------------------------
	
	//compruebaDados
	/*Proposito: Dado dos enteros comprueba el mayor o si son iguales
	 * Prototipo: int compruebaDados(int dado1, int dado2)
	 * Precondiciones: No hay
	 * Entradas: dos enteros
	 * E/S: no hay
	 * Salidas: un entero
	 * Postcondiciones: el entero sera 0 si son iguales, 1 si el dado1 es mayor, -1 si no
	 */		
	public int comparaDados(int dado1, int dado2){
		int mayor;
		if(dado1>dado2){
			mayor=1;
		}else if(dado1<dado2){
			mayor=-1;
		}else{
			mayor=0;
		}
		return mayor;
	}
		
//----------------------------------------------------------------------------------------------------	
	
	//compruebaNombre
	/*Proposito: Dada una cadena comprueba que no esté vacía
	 * Prototipo:  boolean compruebaNombre(String nombre)
	 * Precondiciones: No hay
	 * Entradas: una cadena
	 * E/S: 
	 * Salidas: un booleano
	 * Postcondiciones: el booleano será verdadero si la cadena no está vacía
	 */		
	public boolean compruebaNombre(String nombre){
		boolean valido=true;
		String noespacios=nombre.replace(" ", "");
		if(noespacios.length()==0){
			valido=false;
		}
		return valido;
	}
	
	
	
	
	
	
	
	
	//_____________________________________________________________________________________________		
	
			//ponFicha
			/*Proposito: Pone una ficha
			* Prototipo: boolean ponFicha(String icadena,String jcadena, String kcadena, int jugador)
			* Precondiciones: 
			* Entradas: tres cadenas que son las posiciones y un entero que es el jugador
			* E/S:
			* Salidas: un booleano 
			* Postcondiciones: el booleano sera verdadero si la ficha se ha puesto y falso si no
			* Restricciones: La posicion no puede estar ocupada
			*/
			
	/*		public boolean ponFicha(String icadena,String jcadena, String kcadena, int jugador){		
				boolean puesta=false;
				int i,j,k;
				
				if(validaPonFicha(icadena,jcadena,kcadena)){			
					i=Integer.parseInt(icadena);
					j=Integer.parseInt(jcadena);
					k=Integer.parseInt(kcadena);
					
					switch(jugador){
						case 1: cubo[i][j][k]='X';
						break;
						
						case 2: cubo[i][j][k]='O';
						break;					
					}
					puesta=true;
				}//else{		
					//System.out.println("La posicion no es valida");	
					//}
					
				return puesta;
			}
*/
			
	//_____________________________________________________________________________________________
			
			//validaPonFicha	
			/*Proposito: Comprueba que la casilla no esta ocupada cuando se va a poner una ficha
			* Prototipo: boolean validaPonFicha(String posI,String posJ, String posK)
			* Precondiciones: las Posiciones son validas
			* Entradas: tres cadenas que son las posiciones
			* E/S:
			* Salidas: un booleano
			* Postcondiciones: el booleano sera verdadero si la posicion es valida y no esta ocupada
			*/
	/*		public  boolean validaPonFicha(String posI,String posJ, String posK){
				boolean valida=false;
				int i,j,k;
				
				if(validaPosicion(posI,posJ,posK)){
					i=Integer.parseInt(posI);
					j=Integer.parseInt(posJ);
					k=Integer.parseInt(posK);
					
					if(cubo[i][j][k]!='X' && cubo[i][j][k]!='O'){
						valida=true;
					}	

				}
				return valida;
			}
*/
			
	//_____________________________________________________________________________________________
			
			//validaPosicion	
			/*Proposito: Comprueba la posicion elegida
			* Prototipo: boolean validaPosicion(String icadena, String jcadena, String kcadena)
			* Precondiciones: no hay
			* Entradas: tres cadenas que son las posiciones
			* E/S:
			* Salidas: un booleano
			* Postcondiciones: el booleano sera verdadero si la posicion es valida
			*/
		/*public boolean validaPosicion(String icadena, String jcadena, String kcadena){
				boolean valida=false,pasa=true;
				int i=-1,j=-1,k=-1;			
				try{
					i=Integer.parseInt(icadena);
					j=Integer.parseInt(jcadena);
					k=Integer.parseInt(kcadena);				
					}catch(NumberFormatException error){
						System.out.println("Se espera un numero\n");	
						pasa=false;
					}										
				if(pasa){				
					if(i>=0 && i<=2 && j>=0 && j<=2 && k>=0 && k<=2){
						valida=true;
					}
				}
				
				return valida;
			}
	*/		
			
	//_____________________________________________________________________________________________
			
			//quitaFicha	
			/*Proposito: Quita una ficha
			* Prototipo: boolean quitaFicha(String posI,String posJ, String posK, int jug)
			* Precondiciones: las Posiciones son validas
			* Entradas: tres cadenas que son las posiciones y un entero que es el jugador
			* E/S:
			* Salidas: un booleano
			* Postcondiciones: el booleano sera verdadero si la ficha se ha quitado
			*/		
	/*		public boolean quitaFicha(String posI,String posJ, String posK, int jug){			
				boolean quitada=false;
				int i,j,k;
				
				if(validaQuitaFicha(posI,posJ,posK,jug)){
					i=Integer.parseInt(posI);
					j=Integer.parseInt(posJ);
					k=Integer.parseInt(posK);

					cubo[i][j][k]=' ';
					quitada=true;
				}//else{
					//System.out.println("Mejor no");	
					//}
				
				return quitada;
			}
	*/		
			
	//_____________________________________________________________________________________________
			
			//validaQuitaFicha	
			/*Proposito: Comprueba que la ficha que se va a quitar es del jugador 
			* Prototipo: validaQuitaFicha(String posI,String posJ, String posK, int jug)
			* Precondiciones: las Posiciones son validas
			* Entradas: tres cadenas que son las posiciones y un entero que es el jugador
			* E/S:
			* Salidas: un booleano
			* Postcondiciones: el booleano sera verdadero si la posicion es valida y la ficha es del jugador
			*/		
	/*		public boolean validaQuitaFicha(String posI,String posJ, String posK, int jug){
				boolean valida=false;
				int i,j,k;
				
				if(validaPosicion(posI,posJ,posK)){
					i=Integer.parseInt(posI);
					j=Integer.parseInt(posJ);
					k=Integer.parseInt(posK);

					if(cubo[i][j][k]=='X' && jug==1 || cubo[i][j][k]=='O' && jug==2 ){
						valida=true;
					}	
				}
				return valida;
			}
		*/		
			
	//_____________________________________________________________________________________________
			
			//compruebaGanador	
			/*Proposito: Comprueba si hay ganador
			* Prototipo:  boolean compruebaGanador()
			* Precondiciones: las Posiciones son validas
			* Entradas: no hay
			* E/S:
			* Salidas: un booleano
			* Postcondiciones: el booleano sera verdadero si hay ganador y false si no
			*/		
		/*	public boolean compruebaGanador(){
				boolean ganador=false;
				
				for(int caso=0;caso<13 && !ganador;caso++){
						
						switch(caso){
						
							case 0://Filas de cada parte del cubo
								for(int i=0;i<3;i++){
									for(int j=0;j<3;j++){
										if(cubo[i][j][0]=='X' && cubo[i][j][1]=='X' && cubo[i][j][2]=='X' || cubo[i][j][0]=='O' && cubo[i][j][1]=='O' && cubo[i][j][2]=='O'){
											ganador=true;
										}
									}
								}
							break;
		
							case 1://Columnas de cada parte del cubo
								for(int i=0;i<3;i++){
									for(int j=0;j<3;j++){
										if(cubo[i][0][j]=='X' && cubo[i][1][j]=='X' && cubo[i][2][j]=='X' || cubo[i][0][j]=='O' && cubo[i][1][j]=='O' && cubo[i][2][j]=='O'){
											ganador=true;
										}
									}
								}
							break;
		
							
							case 2://plano, diagonales izqda a dcha
									for(int i=0;i<3;i++){
										if(cubo[i][0][0]=='X' && cubo[i][1][1]=='X' && cubo[i][2][2]=='X' || cubo[i][0][0]=='O' && cubo[i][1][1]=='O' && cubo[i][2][2]=='O'){
											ganador=true;
										}				
									}
							break;	
							
							case 3://plano, diagonales dcha a izqda
									for(int i=0;i<3;i++){
										if(cubo[i][2][0]=='X' && cubo[i][1][1]=='X' && cubo[i][0][2]=='X' || cubo[i][2][0]=='O' && cubo[i][1][1]=='O' && cubo[i][0][2]=='O'){
											ganador=true;
										}				
									}
							break;										
							
							case 4://profundidad, va comprobando fila por fila y columna por columna de cada parte del cubo
									for(int i=0;i<3;i++){
										for(int j=0;j<3;j++){
											if(cubo[0][j][i]=='X' && cubo[1][j][i]=='X' && cubo[2][j][i]=='X' || cubo[0][j][i]=='O' && cubo[1][j][i]=='O' && cubo[2][j][i]=='O'){
												ganador=true;
											}
										}
									}
							break;
							
							case 5://profundidad, arriba a abajo, izq a dcha diagonal cruzada 
									if(cubo[0][0][0]=='X' && cubo[1][1][1]=='X' && cubo[2][2][2]=='X' || cubo[0][0][0]=='O' && cubo[1][1][1]=='O' && cubo[2][2][2]=='O'){
										ganador=true;
									}
							break;
							
							case 6://profundidad, abajo a arriba, izq a dcha diagonal cruzada 
									if(cubo[0][2][0]=='X' && cubo[1][1][1]=='X' && cubo[2][0][2]=='X' || cubo[0][2][0]=='O' && cubo[1][1][1]=='O' && cubo[2][0][2]=='O'){
										ganador=true;
									}
							break;
		
							case 7://profundidad, arriba a abajo, dcha a izq diagonal cruzada 
									if(cubo[0][0][2]=='X' && cubo[1][1][1]=='X' && cubo[2][2][0]=='X' || cubo[0][0][2]=='O' && cubo[1][1][1]=='O' && cubo[2][2][0]=='O' ){
										ganador=true;
									}
							break;
		
							case 8://profundidad, abajo a arriba, dcha a izq diagonal cruzada 
									if(cubo[0][2][2]=='X' && cubo[1][1][1]=='X' && cubo[2][0][0]=='X' || cubo[0][2][2]=='O' && cubo[1][1][1]=='O' && cubo[2][0][0]=='O' ){
										ganador=true;
									}
							break;					
		
							case 9://profundidad, frente al fondo de izq a dcha en diagonal horizontal
									for(int i=0;i<3;i++){
										if(cubo[0][i][0]=='X' && cubo[1][i][1]=='X' && cubo[2][i][2]=='X' || cubo[0][i][0]=='O' && cubo[1][i][1]=='O' && cubo[2][i][2]=='O' ){
											ganador=true;
										}
									}
							break;
							
							case 10://profundidad, frente al fondo de dcha a izq en diagonal horizontal
									for(int i=0;i<3;i++){
										if(cubo[0][i][2]=='X' && cubo[1][i][1]=='X' && cubo[2][i][0]=='X' || cubo[0][i][2]=='O' && cubo[1][i][1]=='O' && cubo[2][i][0]=='O'  ){
											ganador=true;
										}
									}
							break;
							
							case 11://profundidad, frente al fondo de arriba a abajo en diagonal vertical 
									for(int i=0;i<3;i++){
										if(cubo[0][0][i]=='X' && cubo[1][1][i]=='X' && cubo[2][2][i]=='X' || cubo[0][0][i]=='O' && cubo[1][1][i]=='O' && cubo[2][2][i]=='O'){
											ganador=true;
										}
									}
							break;
							
							case 12://profundidad, frente al fondo de abajo a arriba en diagonal vertical
								for(int i=0;i<3;i++){
									if(cubo[0][2][i]=='X' && cubo[1][1][i]=='X' && cubo[2][0][i]=='X' || cubo[0][2][i]=='O' && cubo[1][1][i]=='O' && cubo[2][0][i]=='O' ){
										ganador=true;
									}
								}
						break;

							
						}//Fin SEGUN
					//}//Fin SI no hay ganador
				}//Fin PARA
						
				return ganador;
			}
		*/	

	
	
	
		
}
