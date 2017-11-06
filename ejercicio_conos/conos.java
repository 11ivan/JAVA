//conos.java
/**
An�lisis
	F�rmulas: Generatriz(ra�z cuadrada de altura al cuadrado + radio al cuadrado)cm;
			  Area lateral(pi*radio*generatriz)cm�;Area total(pi*generatriz+pi*radio al cuadrado)cm�;
			  Volumen(pi*radio al cuadrado*altura/3) cm�.
	Prop�sito: Calcular �rea latereal, total y el volumen del cono.
	Entrada: Tres n�meros.
	Salida: Resultado �rea latereal, total y el volumen del cono.
	Restricciones: Ning�n n�mero introducido no puede ser negativo o cero.

Pseudoc�digo generalizado
	Leer datos
	Comprobar datos y Realizar c�lculo
	Escribir resultado
 */
import java.util.Scanner; // se importa la clase Scanner.
import java.lang.Math; //se importa la clase Math.
public class conos{
	public static void main(String[] args){	
		//Declaracion de variables
		float pi=(float)3.14;
		float r=0;
		float h=0;
		float g=0;
		float v=0;
		float radicando=0;
		float al=0;
		float at=0;
		
		//LEER DATOS
		Scanner entrada1=new Scanner(System.in);
		System.out.println("Introduzca el radio: ");
		r=entrada1.nextFloat();
		Scanner entrada2=new Scanner(System.in);
		System.out.println("Introduzca la altura: ");
		h=entrada2.nextFloat();	
		
		//CMPROBAR DATOS Y REALIZAR CALCULO
		if (r<=0){
			System.out.println("El radio no puede ser 0 o menor");
		}
		else{
			if(h<=0){
				System.out.println("La altura no puede ser 0 o menor");	
			}
			else{
				radicando=(r*r)+(h*h);//calculo de generatriz
				g=(float)Math.sqrt(radicando);
				al=(pi*r)*g;
				at=(pi*g)+(pi*(r*r));
				v=((pi*r)*(r*h))/3;
			}
		}
		//ESCRIBIR RESULTADO
		System.out.println("generatriz "+g);
		System.out.println("El �rea lateral es: " +al);
		System.out.println("El �rea total es: " +at);
		System.out.println("El volumen es: " +v);
	}
}
