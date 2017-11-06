import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.GregorianCalendar;

public class pruebadate {

	public static void main(String... args) {
		InetAddress address=null;
		try {
			address = InetAddress.getLocalHost();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
				
		System.out.println(address.getHostAddress());
		
		/*Fecha2 fecha=null;
		try {
			fecha = new Fecha2("1", "02", "1");
		} catch (ExcepcionFecha e) {
			e.printStackTrace();
		}
		System.out.println(fecha.toString());*/
		


	}

}
