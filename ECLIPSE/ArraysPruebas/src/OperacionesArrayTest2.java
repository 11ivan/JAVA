import static org.junit.Assert.*;

import org.junit.Test;

public class OperacionesArrayTest2 {

	@Test
	public void testSumaArray() {
		int[] array={1,1,1};
		int[] arrayesperado={1,1,1};
		assertArrayEquals(arrayesperado,OperacionesArray.sumaArray(array));
	}

	@Test
	public void testMultiplicaArray() {
		int[] array={1,1,1};
		int[] arrayesperado={1,2,3};
		assertArrayEquals(arrayesperado,OperacionesArray.multiplicaArray(array));
	}

}
