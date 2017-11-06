//testCuenta.java

import java.util.Scanner;

public class testCuenta{
	public static void main(String[] args){
		
		Scanner teclado=new Scanner(System.in);
		Cuenta cuenta1=new Cuenta();
		Cuenta cuenta2=null;
		Cuenta cuenta3=null;
		
		try{
			cuenta2=new Cuenta(1234567890000000000000.0,500000.85);
		}catch(ExcepcionCuenta error){
				System.out.println(error);
			}	
		
		cuenta3=new Cuenta(cuenta2);

		
		/*//Excepcion
		try{
			cuenta2=new Cuenta(00000,-1);
		}catch(ExcepcionCuenta error){
				System.out.println(error);
			}*/
		
		//Consulta atributos
		System.out.println(cuenta1.getNumCuenta()+", "+cuenta1.getSaldo());
		System.out.println(cuenta2.getNumCuenta()+", "+cuenta2.getSaldo());
		System.out.println(cuenta3.getNumCuenta()+", "+cuenta3.getSaldo());

		//Modifica y consulta
		
		/*try{
			cuenta1.setSaldo(-1);
		}catch(ExcepcionCuenta error){
				System.out.println(error);
			}*/			
		try{
			cuenta1.setSaldo(10920.64);
		}catch(ExcepcionCuenta error){
				System.out.println(error);
		}
		
		System.out.println(cuenta1.getSaldo());

		//sacaPasta
		
		/*try{
			cuenta1.sacaPasta(-4);//valor negativo
		}catch(ExcepcionCuenta error){
				System.out.println(error);
		}*/
		
		/*try{
			cuenta1.sacaPasta(11000.0);//Mas dinero del que tiene
		}catch(ExcepcionCuenta error){
				System.out.println(error);
		}		
		System.out.println(cuenta1.getSaldo());
		*/

		try{
			cuenta1.sacaPasta(1000.0);
		}catch(ExcepcionCuenta error){
				System.out.println(error);
		}		
		System.out.println(cuenta1.getSaldo());

		
		//metePasta
		/*try{
			cuenta1.metePasta(-5);//valor negativo
		}catch(ExcepcionCuenta error){
				System.out.println(error);
			}
		*/
		
		try{
			cuenta1.metePasta(1000.0);
		}catch(ExcepcionCuenta error){
				System.out.println(error);
			}
		
		//tranferencia
		System.out.println("cuenta2 tenia "+cuenta2.getSaldo());
		
		/*try{
			cuenta1.tranferencia(cuenta2,-5);//valor negativo
			}catch(ExcepcionCuenta error){
				System.out.println(error);
			}
		*/
		
		/*try{
			cuenta1.tranferencia(cuenta2,20920.65);//No hay dinero suficiente
			}catch(ExcepcionCuenta error){
				System.out.println(error);
			}
		*/

		
		try{
			cuenta1.tranferencia(cuenta2,5000);
			}catch(ExcepcionCuenta error){
				System.out.println(error);
			}
		
		System.out.println("cuenta2 tiene ahora "+cuenta2.getSaldo());
	
		
		
		
		
		
		
		
		
		
		
	}
}
