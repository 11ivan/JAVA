import static org.junit.Assert.*;

import org.junit.Test;

public class OperacionesArrayTest {

	@Test
	public void testSumaArray() {
		int[] array={1,1,1};
		int[] arrayesperado={1,1,1};
		assertArrayEquals(arrayesperado,OperacionesArray.sumaArray(array));
	}

}
