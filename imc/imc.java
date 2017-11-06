//imc.java
/**
Análisis
	 Fórmula IMC=peso/altura²
	 Propósito: Calcular IMC
	 Entrada: Se introduce el peso y la altura
	 Salida: Se obtiene el IMC
	 Restricciones: El peso debe ser en kg y la altura en centimetros,sólo números positivos.
Pseudocódigo generalizado
	 Leer datos
	 Comprobar datos y calcular imc
	 Escribir resultado
 */
import java.util.Scanner; // se importa la clase Scanner

public class imc {
	public static void main(String[] args)
	{
		//declaración de variables
		float peso,altura; 
		float inc = 0;
		
		//LEER DATOS
		Scanner entrada1=new Scanner(System.in);
		
		System.out.println("Ingrese el peso: ");
		
		peso = entrada1.nextInt();
	
		Scanner entrada2=new Scanner(System.in);
		
		System.out.println("Ingrese la altura: ");
		
		altura = entrada2.nextInt();
		
		//COMPROBAR DATOS Y CALCULAR IMC
		
		if (peso<=0){
			
			System.out.println("El peso debe ser mayor que 0");
		}	
		else{
			if (altura<=0){
					
				System.out.println("La altura debe ser mayor que 0");	
			}	
			else{
			inc = peso/((altura*altura)/10000);
			}
		}
		
		//ESCRIBIR RESULTADO
		
		System.out.println("Su IMC es:" +inc);
	}

}
