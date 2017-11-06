//TestFecha2.java


public class TestFecha2{
	public static void main(String[] args){		

		Fecha2 fecha=new Fecha2();
		Fecha2 fecha2=null;
		try{
		fecha2=new Fecha2(5,8,1999);
		}catch(ExcepcionFecha error){
			System.out.println(error);
			}
		Fecha2 fechaincrementada=new Fecha2();
		Fecha2 fechadecrementada=new Fecha2();
		String cadena,cadena2;
		int dias;
		fecha2.muestraFecha();
		//Consulta modifica y consulta dia //excepciones
		System.out.println("Dia por defecto: "+fecha.getDay());
		try{
			fecha.setDay(20);
		}catch(ExcepcionFecha error){
			System.out.println(error);
		}
		System.out.println("Dia modificado: "+fecha.getDay());
		System.out.println("///////////////////////////////////////////////////////////////");
		
		//Consulta modifica y consulta mes //excepciones
		System.out.println("Mes por defecto: "+fecha.getMonth());
		try{
			fecha.setMonth(5);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}
		System.out.println("Mes modificado: "+fecha.getMonth());
		System.out.println("///////////////////////////////////////////////////////////////");
		
		//Consulta modifica y consulta mes //excepciones
		System.out.println("A\u00f1o por defecto: "+fecha.getYear());
		try{
			fecha.setYear(2000);
		}catch(ExcepcionFecha error){
				System.out.println(error);
			}
		System.out.println("A\u00f1o modificado: "+fecha.getYear());
		System.out.println("///////////////////////////////////////////////////////////////");
		
		//Consultar año actual
		//System.out.println("A\u00f1o actual "+fecha.getActualYear());
		//System.out.println("///////////////////////////////////////////////////////////////");
		
		//Consultar año bisiesto
			//true
		System.out.println("A\u00f1o a probar: "+fecha.getYear());
		System.out.println("Prueba bisiesto "+fecha.getBisiesto());
			//false  
		try{
			fecha.setYear(2001);
		}catch(ExcepcionFecha error){
				System.out.println(error);
			}
		System.out.println("A\u00f1o a probar: "+fecha.getYear());
		System.out.println("Prueba bisiesto "+fecha.getBisiesto());

			//true
		try{
			fecha.setYear(1600);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}		
		System.out.println("A\u00f1o a probar: "+fecha.getYear());
		System.out.println("Prueba bisiesto "+fecha.getBisiesto());
		System.out.println("///////////////////////////////////////////////////////////////");

		try{
			fecha.setYear(1991);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}		

		
		//Orden natural compareTo
			//devuelve 1 si la fecha enviada es posterior
			System.out.println("La fecha enviada es posterior devuelve 1");
			fecha.muestraFecha();
			fecha2.muestraFecha();
			System.out.println(fecha.compareTo(fecha2));
			
			//devuelve -1 si la fecha enviada es anterior
			System.out.println("La fecha enviada es anterior devuelve -1");
			fecha2.muestraFecha();
			fecha.muestraFecha();
			System.out.println(fecha2.compareTo(fecha));
			
			//devuelve 0 si son iguales
				//prueba metodo CLONE fecha y asignar a fecha2
			System.out.println("Las fechas son iguales devuelve 0");
			fecha2=fecha.clone();
			fecha2.muestraFecha();
			fecha.muestraFecha();
			System.out.println(fecha2.compareTo(fecha));
			System.out.println("///////////////////////////////////////////////////////////////");
			
		//Criterio de igualdad equals
		System.out.println("equals. Fechas enviadas:");
		fecha2.muestraFecha();
		fecha.muestraFecha();
		System.out.println(fecha.equals(fecha2));	
		
		System.out.println("equals. Fechas enviadas:");
		try{
			fecha.setDay(13);
		}catch(ExcepcionFecha error){
				System.out.println(error);
			}
		fecha2.muestraFecha();
		fecha.muestraFecha();
		System.out.println(fecha.equals(fecha2));	
		System.out.println("///////////////////////////////////////////////////////////////");
				
		//Representacion como cadena
		System.out.println("Fecha como cadena");
		cadena=fecha.toString();
		System.out.println(cadena);
		System.out.println("///////////////////////////////////////////////////////////////");
		
		//hashCode
		System.out.println("hashCode");
		System.out.println(fecha.hashCode());
		System.out.println("///////////////////////////////////////////////////////////////");

		//validafecha
		System.out.println("validafecha");
		fecha.muestraFecha();
		try{
			fecha.setDay(29);
			fecha.setMonth(2);
			fecha.setYear(1600);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}
		fecha.muestraFecha();
		System.out.println(fecha.validafecha());
		try{
			fecha.setDay(28);
			fecha.setMonth(2);
			fecha.setYear(1601);
		}catch(ExcepcionFecha error){
				System.out.println(error);
			}
		fecha.muestraFecha();
		System.out.println(fecha.validafecha());		
		System.out.println("///////////////////////////////////////////////////////////////");
	
		//diastotales
		System.out.println("diastotales");
		/*try{
			fecha.setDay(1);
			fecha.setMonth(1);
			fecha.setYear(1);
		}catch(ExcepcionFecha error){
				System.out.println(error);
			}
		fecha.muestraFecha();
		System.out.println("Los dias totales de los meses son "+Fecha2.diasMeses(fecha));
		System.out.println("Los dias totales de los a\u00f1os son "+Fecha2.diasAnios(fecha));
		System.out.println("Los dias totales son "+Fecha2.diasTotales(fecha));*/

		System.out.println("///////////////////////////////////////////////////////////////");
		
		//diastranscurridos
		System.out.println("diastranscurridos");
		try{
			fecha.setMonth(12);
			fecha.setDay(31);
			fecha.setYear(2000);
			fecha.muestraFecha();
			/*System.out.println("Los dias del mes son "+Fecha2.diasMeses(fecha));
			System.out.println("Los dias del a\u00f1o son "+Fecha2.diasAnios(fecha));*/
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}
		cadena=fecha.toString();
		
		try{
			fecha2.setDay(1);
			fecha2.setMonth(1);
			fecha2.setYear(2001);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}

		fecha2.muestraFecha();
			/*System.out.println("Los dias del mes son "+Fecha2.diasMeses(fecha));
			System.out.println("Los dias del a\u00f1o son "+Fecha2.diasAnios(fecha));*/

		cadena2=fecha2.toString();
		
		dias=fecha.diastranscurridos(fecha2);

		/*System.out.println("Los dias totales de "+cadena+" es "+Fecha2.diasTotales(fecha));
		System.out.println("Los dias totales de "+cadena2+" es "+Fecha2.diasTotales(fecha2));*/
		
		System.out.println("Los dias transcurridos entre "+cadena+" y "+cadena2+" es: "+dias);
		
		/////
		try{
		fecha.setDay(31);
		fecha.setMonth(12);
		fecha.setYear(1991);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}

		fecha.muestraFecha();
		cadena=fecha.toString();
		
		try{
		fecha2.setDay(3);
		fecha2.setMonth(1);
		fecha2.setYear(1992);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}

		fecha2.muestraFecha();
		cadena2=fecha2.toString();
		
		dias=fecha2.diastranscurridos(fecha);
		
		/*System.out.println("Los dias totales de "+cadena+" es "+Fecha2.diasTotales(fecha));
		System.out.println("Los dias totales de "+cadena2+" es "+Fecha2.diasTotales(fecha2));*/
		System.out.println("Los dias transcurridos entre "+cadena+" y "+cadena2+" es: "+dias);
		System.out.println("///////////////////////////////////////////////////////////////");
		
		//incrementDay
		System.out.println("incrementDay");
		try{
			fecha.setMonth(12);
			fecha.setDay(31);
			fecha.setYear(1991);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}

		fecha.muestraFecha();
		
		fecha.incrementDay();
		fecha.muestraFecha();
		
		//
		try{
			fecha.setDay(28);
			fecha.setMonth(2);
			fecha.setYear(1600);		
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}
		
		fecha.muestraFecha();
		fecha.incrementDay();
		fecha.muestraFecha();
		System.out.println("///////////////////////////////////////////////////////////////");


		//decrementDay
		System.out.println("decrementDay"); 
		try{
		fecha.setDay(1);
		fecha.setMonth(1);
		fecha.setYear(1991);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}

		fecha.muestraFecha();		
		fecha.decrementDay();
		fecha.muestraFecha();
		
		//
		try{
		fecha.setDay(1);
		fecha.setMonth(3);
		fecha.setYear(1600);
		}catch(ExcepcionFecha error){
				System.out.println(error);
		}

		fecha.muestraFecha();	
		fecha.decrementDay();
		fecha.muestraFecha();

			
	}

}
