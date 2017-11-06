//testTemperatura.java

public class testTemperatura{
	public static void main (String[] args){
		
		
		Temperatura temp=new Temperatura();
		Temperatura temp2=new Temperatura(80.0,40.0);
		Temperatura temp3=new Temperatura(temp2);
		String cadena;
		
		//Consulta temp
		System.out.println(temp.getTempMax()+", "+temp.getTempActual()+"\n");
		
		//Consulta temp2
		System.out.println(temp2.getTempMax()+", "+temp2.getTempActual()+"\n");
		
		//Consulta temp3
		System.out.println(temp3.getTempMax()+", "+temp3.getTempActual()+"\n");
		
		//Modifica temp y consulta
		temp.setTempMax(100.0);
		temp.setTempActual(50.0);
		System.out.println(temp.getTempMax()+", "+temp.getTempActual()+"\n");
		
		
		//toString
		cadena=temp.toString();
		System.out.println(cadena);
		
		//equals
		System.out.println(temp2.equals(temp3));
		System.out.println(temp2.equals(temp));
		
		//compareTo
		System.out.println(temp.compareTo(temp2));
		System.out.println(temp2.compareTo(temp));
		System.out.println(temp2.compareTo(temp3));
		
	}
}








