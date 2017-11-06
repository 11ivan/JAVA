/*Matriz.java
 * 
 * Propiedades:
 * 	Matriz: Basica, array bidimensional de cadenas, consultable, modificable
 * 	
 * 
 * 
 * 
 * 
 * Interfaz
 * 	
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * */


import java.util.Random; 

public class Matriz {
	private String[][] matriz;
	
	public Matriz(){
		matriz=new String[12][31];
		matriz[0][0]="Enero";
		matriz[1][0]="Febrero";
		matriz[2][0]="Marzo";
		matriz[3][0]="Abril";
		matriz[4][0]="Mayo";
		matriz[5][0]="Junio";
		matriz[6][0]="Julio";		
		matriz[7][0]="Agosto";		
		matriz[8][0]="Septiembre";
		matriz[9][0]="Octubre";
		matriz[10][0]="Noviembre";
		matriz[11][0]="Diciembre";
	}
	
	
	public void fillMatriz(){
		Random aleatorio=new Random();
		Integer numero;
		for(int i=0;i<matriz.length;i++){
			
			for(int j=1;j<matriz[0].length;j++){
				
				switch(i){			
					case 0:	numero=aleatorio.nextInt(((18-(-8))+1)+(-8));
							matriz[i][j]=numero.toString();
						break;	
						
					case 1:	numero=aleatorio.nextInt(((20-(-5))+1)+(-5));
							matriz[i][j]=numero.toString();
						break;
						
					case 2:	numero=aleatorio.nextInt(((25-0)+1)+(0));
							matriz[i][j]=numero.toString();
						break;
						
					case 3:	numero=aleatorio.nextInt(((25-3)+1)+(3));
							matriz[i][j]=numero.toString();
						break;
						
					case 4:	numero=aleatorio.nextInt(((30-9)+1)+(9));
							matriz[i][j]=numero.toString();
						break;
						
					case 5:	numero=aleatorio.nextInt(((35-12)+1)+(12));
							matriz[i][j]=numero.toString();
						break;
						
					case 6:	numero=aleatorio.nextInt(((40-18)+1)+(18));
							matriz[i][j]=numero.toString();
						break;
						
					case 7:	numero=aleatorio.nextInt(((45-24)+1)+(24));
							matriz[i][j]=numero.toString();
						break;
						
					case 8:	numero=aleatorio.nextInt(((37-(15))+1)+(15));
							matriz[i][j]=numero.toString();
						break;
						
					case 9:	numero=aleatorio.nextInt(((30-(14))+1)+(14));
							matriz[i][j]=numero.toString();
						break;
						
					case 10:numero=aleatorio.nextInt(((28-(10))+1)+(10));
							matriz[i][j]=numero.toString();
						break;
						
					case 11:numero=aleatorio.nextInt(((20-(-5))+1)+(-5));
							matriz[i][j]=numero.toString();
						break;
				}
			}		
		}
	}
	
	
//-------------------------------------------------------------------------------------------------		
	public void paintMatriz(){
		for(int i=0;i<matriz.length;i++){
			for(int j=0;j<matriz[0].length;j++){
				//System.out.println(" __________________\n");
				System.out.print("| "+matriz[i][j]+" ");
				//System.out.print(" __________________");
			}		
			System.out.println("");
		}
	}
	
	
//-------------------------------------------------------------------------------------------------	
	/*
	 *Proposito:Calcular la temperatura media de cada mes.
	 *Prototipo: void tempMedia()
	 *Precondiciones: La matriz no esta vacia
	 *Entradas: no hay
	 *E/S: no hay
	 *Salidas: no hay
	 *Postcondiciones: Se imprime en pantalla la temperatura media de cada mes
	 */
	public void tempMedia(){
		int suma=0;
		Integer media;
		String[][] array=new String[12][2];
		for(int i=0;i<matriz.length;i++){
			for(int j=1;j<matriz[0].length;j++){
				suma=suma+Integer.parseInt(matriz[i][j]);
			}
			media=suma/30;
			array[i][1]=media.toString();
			suma=0;
		}
		Utiles.copyColumn(array, matriz, 0);
		Utiles.pintaArray(array);
	}
	
	
//-------------------------------------------------------------------------------------------------	
	/*
	 *Proposito: El día más caluroso y el más frío de cada mes.
	 *Prototipo: 
	 *Precondiciones: La matriz no esta vacia
	 *Entradas: no hay
	 *E/S: no hay
	 *Salidas: no hay
	 *Postcondiciones: Se imprime en pantalla la temperatura maxima y minima de cada mes
	 */
	public void tempMaxMin(){
		//String tempMax,tempMin;
		String [][]array=new String[12][3];
		Utiles.copyColumn(array, matriz, 0);
		Integer max,min,comparacion;
		
		for(int i=0;i<matriz.length;i++){
			max=Integer.parseInt(matriz[i][1]);
			min=Integer.parseInt(matriz[i][1]);
			
			for(int j=2;j<matriz[0].length;j++){
				comparacion=Integer.parseInt(matriz[i][j]);				
				if(max<comparacion){
					max=comparacion;
				}
				if(min>comparacion){
					min=comparacion;
				}
			}
			array[i][1]=max.toString();
			array[i][2]=min.toString();
		}
		Utiles.pintaArray(array);
	}
	
	
	
	
//-------------------------------------------------------------------------------------------------	
	//El día más caluroso del año.
	
	
	
	
//-------------------------------------------------------------------------------------------------	
	//El día más frío del año.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
