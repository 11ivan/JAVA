
public class testUtiles {

	public static void main(String[] args) {
		int[] array={1,3,4,5};
		Utiles util=new Utiles();
		//array=util.aumentaLongitud(array, 1);
		System.out.println(util.insertarOrden(array, 2, array.length-1));
		util.pintaArray(array);
		//System.out.println(util.busquedaBin(array, 4));

	}

}
