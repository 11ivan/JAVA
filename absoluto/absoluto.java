//absoluto.java
/**
 * Análisis
	 * Fórmula: Valor absoluto(Raíz del cuadrado del numero); Inverso(1/numero).
	 * Propósito: Calcular inverso y valor absoluto de un número.
	 * Entrada: Un número.
	 * Salida: Inverso y valor absoluto de un número.
	 * Restricciones: Si se introduce 0 no podrá calcularse.
 * Pseudocódigo generalizado
	 * Leer datos
	 * Comprobar datos y calcular datos
	 * Escribir resultado
 */
import java.util.Scanner; //Importamos clase Scanner
import java.lang.Math; //Importamos clase Math
public class absoluto{
		public static void main(String[] args){
			//Declaramos variables
			int numero;
			int radicando=0;
			float inverso=0;
			int base=0;
			int absolut=0;
			
			//Leer datos
			Scanner entrada = new Scanner(System.in);
			System.out.print("Introduzca un número: ");
			numero=entrada.nextInt();
			
			//Comprobar datos y calcular datos
			if (numero!=0){
				radicando=numero*numero;
				absolut=(int)Math.sqrt(radicando);
				inverso=(float)1.0/(float)numero;
			}
			else{
				System.out.println("No se puede clacular absoluto e inverso de 0");
			}
			//Escribir resultado
			System.out.println("El valor absoluto es: " +absolut+ " y el inverso es: " +inverso);
		}	
}
