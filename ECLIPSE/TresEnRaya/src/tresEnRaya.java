/* 		tresEnRaya.java
 * 
 * Propiedades:
 * 	- Tablero: Basica,  array caracteres, consultable, no modificable,
 *  
 * 
 * Interfaz:
 * 	- char[][] getTablero()
 * 
 * Funcionalidades:
 * 	- void montaTablero()
 * 	- void pintaTablero()
 * 	- void ponFicha(int i,int j,int jugador)
 * 	- void quitaFicha(int posI,int posJ,int jug)
 * 	- boolean validaPonFicha(int posI,int posJ)
 * 	- boolean validaQuitaFicha(int posI,int posJ,int jug)
 * 	- boolean compruebaGanador()
 * 	- boolean validaPosicion()
 */


public class tresEnRaya {
	
	private char[][] tablero;
	//private int fichasX;
	//private int fichasO;
	
	//Constructores
	public tresEnRaya(){
		tablero= new char[3][3];		
		//fichasX=3;
		//fichasO=3;
	}
	

	
	//Consultores
	public char[][]getTablero(){
		
		return tablero;
	}
	
	
	
	//Modificadores
	
	
	
	//getPosicionesLibres
	public int getPosicionesLibres(){
		int posiciones=0;
		
		for(int i=0;i<tablero.length;i++){
			
			for(int j=0;j<tablero.length;j++){
				if(tablero[i][j]!='X' && tablero[i][j]!='O'){
					posiciones++;
				}
			}
		}			
		return posiciones;
	}
	
	//montaTablero
	public void montaTablero(){
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero.length;j++){
				tablero[i][j]=' ';			
			}			
		}
	}
	
	//pintaTablero
	/*public void pintaTablero(){		
		for(int i=0;i<tablero.length;i++){

			for(int j=0;j<tablero.length;j++){	
				//System.out.println(" _____");
				//System.out.println("|     |");
				System.out.print("|__"+tablero[i][j]+"__|");
				//System.out.print("|_____|");
			}
			System.out.println("");	
		}
	}*/
	
	//pintaTablero
	public void pintaTablero(){	
		System.out.println("");
		System.out.println("");
		System.out.print("\t\t\t\t");			System.out.print("     0");					System.out.print("     1");						System.out.print("     2\n");
				
		System.out.print("\t\t\t\t");			System.out.print("   _____");				System.out.print(  " _____");				System.out.print(" _____\n");	
		System.out.print("\t\t\t\t");			System.out.print("  |     |");				System.out.print("     |");					System.out.print("     |\n");
		System.out.print("\t\t\t\t0");		System.out.print(" |  "+tablero[0][0]+"  |");System.out.print("  "+tablero[0][1]+"  |");System.out.print("  "+tablero[0][2]+"  |\n");
		System.out.print("\t\t\t\t");			System.out.print("  |_____|");				System.out.print("_____|");					System.out.print("_____|\n");
								
		System.out.print("\t\t\t\t");			System.out.print("  |     |");				System.out.print("     |");					System.out.print("     |\n");
		System.out.print("\t\t\t\t1");		System.out.print(" |  "+tablero[1][0]+"  |");System.out.print("  "+tablero[1][1]+"  |");System.out.print("  "+tablero[1][2]+"  |\n");
		System.out.print("\t\t\t\t");			System.out.print("  |_____|");				System.out.print("_____|");					System.out.print("_____|\n");
											
		System.out.print("\t\t\t\t");			System.out.print("  |     |");				System.out.print("     |");					System.out.print("     |\n");
		System.out.print("\t\t\t\t2");		System.out.print(" |  "+tablero[2][0]+"  |");System.out.print("  "+tablero[2][1]+"  |");System.out.print("  "+tablero[2][2]+"  |\n");
		System.out.print("\t\t\t\t");			System.out.print("  |_____|");				System.out.print("_____|");					System.out.print("_____|\n");		
	}

		
	//ponFicha
	public void ponFicha(int i,int j,int jugador){		
		
		if(! validaPonFicha(i,j)){			
			System.out.println("La posicion está ocupada!!");					
		}else{			
			switch(jugador){
				case 1: tablero[i][j]='X';
				break;
				
				case 2: tablero[i][j]='O';
				break;
			}
		}
	}
	
	//quitaFicha
	public void quitaFicha(int posI,int posJ,int jug){
		
		if(validaQuitaFicha(posI,posJ,jug)){
			tablero[posI][posJ]=' ';
		}else{
			System.out.println("Mejor no");	
			}
		
	}
	
	
	//validaPosicion
	public boolean validaPosicion(int i, int j){
		boolean valida=true;
		
		if(i<0 || i>2 || j<0 || j>2){
			valida=false;
		}	
		return valida;
	}
	
	
	//validaPonFicha
	//Valida la jugada cuando se va a poner una ficha
	public boolean validaPonFicha(int posI,int posJ){
		boolean valida=true;

			if(tablero[posI][posJ]=='X' || tablero[posI][posJ]=='O'){
				valida=false;
			}															
		return valida;
	}
	
	
	//validaQuitaFicha
	//Valida la jugada cuando se va a quitar una ficha
	public boolean validaQuitaFicha(int posI,int posJ,int jug){
		boolean valida=false;
		
		if(tablero[posI][posJ]=='X' && jug==1 || tablero[posI][posJ]=='O' && jug==2){
			valida=true;
		}													
		return valida;
	}
	
	
	//compruebaGanador
	public boolean compruebaGanador(){
		boolean ganador=false;
		
		for(int caso=0;caso<6;caso++){
			switch(caso){
				
				case 0:
						if(tablero[0][0]=='X' && tablero[0][1]=='X' && tablero[0][2]=='X' || tablero[0][0]=='O' && tablero[0][1]=='O' && tablero[0][2]=='O'){
							ganador=true;
						}
				break;
				
				case 1:
						if(tablero[0][0]=='X' && tablero[1][0]=='X' && tablero[2][0]=='X' || tablero[0][0]=='O' && tablero[1][0]=='O' && tablero[2][0]=='O'){
							ganador=true;
						}				
				break;
				
				case 2:
					if(tablero[1][0]=='X' && tablero[1][1]=='X' && tablero[1][2]=='X' || tablero[1][0]=='O' && tablero[1][1]=='O' && tablero[1][2]=='O'){
						ganador=true;
					}				
					break;
				case 3:
					if(tablero[0][1]=='X' && tablero[1][1]=='X' && tablero[2][1]=='X' || tablero[0][1]=='O' && tablero[1][1]=='O' && tablero[2][1]=='O'){
						ganador=true;
					}				
					break;
			
				case 4:
					if(tablero[2][0]=='X' && tablero[2][1]=='X' && tablero[2][2]=='X' || tablero[2][0]=='O' && tablero[2][1]=='O' && tablero[2][2]=='O'){
						ganador=true;
					}				
					break;
			
				case 5:
					if(tablero[0][2]=='X' && tablero[1][2]=='X' && tablero[2][2]=='X' || tablero[0][2]=='O' && tablero[1][2]=='O' && tablero[2][2]=='O'){
						ganador=true;
					}				
					break;										
			}
		}
				
		return ganador;
	}
	
	
	
	
	
	
	
	
	
	
	
	
/*
	* *			
   *   * 
    * *	
     
   *   * 
	 *
   *   *
    
    
      __________
     /  *    * /|
    /    *    / |
   /_* ____*_/  |       
   | *    *  |  /      
   |         | /   
   |_*____*__|/

      ____________
     /|          /|
    / |         / |
   /  |        /  |
  /___|_______/   |       
  |   |_______|___|            
  |   /       |   / 
  |  /        |  / 
  | /         | /    
  |/__________|/   
                  


*/	
	
	
	
	
}
