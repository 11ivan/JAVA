
public class OperacionesArray {
	
	/*		sumaArray
	 * 
	 * 
	 * 
	 */
		public static int[] sumaArray(int[] array){
			int[] suma=new int[array.length];
			
			for(int i=0;i<array.length;i++){
				suma[i]=suma[i]+array[i];
			}
			return suma;
		}
//___________________________________________________________________________________________
	
		/*		multiplicaArray
		 * 
		 * 
		 * 
		 */
		public static int[] multiplicaArray(int[] array){
			int[] multiplicacion=new int[array.length];
			int multiplicador=1;
			
			for(int i=0;i<array.length;i++){
				if(i<=array.length){
					multiplicacion[i]=array[i]*multiplicador;
				}
				multiplicador++;
			}
			return multiplicacion;
		}
			
	//___________________________________________________________________________________________

}
