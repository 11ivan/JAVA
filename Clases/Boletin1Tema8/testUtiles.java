//testUtiles.java


public class testUtiles{
	public static void main(String [] args){
		
		int[] array2=new int[5];
		int[] array=new int[20];
		int indice=0;
		
		
	/*array2=Utiles.cargaArray(6,9,0);
		for(indice=0;indice<array2.length;indice++){
			System.out.println(array2[indice]);
		}
		
					System.out.println("");

		
		array=Utiles.cargaArrayPares(array2);
		for(indice=0;indice<array.length;indice++){
			System.out.print(array[indice]);
		}*/
		
		
		array=Utiles.arrayNoRepeatElement();
		for(indice=0;indice<array.length;indice++){
				System.out.println("El numero insertado en el indice "+indice+" es "+array[indice]);
			}
		
		
		
		
		
		
	}
}
