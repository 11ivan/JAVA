
 
import java.io.*;
import java.util.*;

public class Main {
 

    public static void main(String[] args) {
        // TODO code application logic here
        InputStreamReader isr=new InputStreamReader (System.in);
        BufferedReader br=new BufferedReader (isr);
 
        Scanner teclado=new Scanner(System.in);
        int numero,val,mayor,menor;
        double media;
        System.out.println("cuantos numeros quiere ingresar: ");
        numero=teclado.nextInt();
        mayor=0;
        menor=1000000000;
        media=0;
        for (int i=1;i<=numero;i++)//numero control
        {
            System.out.println("Ingrese cantidad" + i+": ");
            val=teclado.nextInt();
            if (val>mayor)//valornumero, si valornumero > mayor, mayor toma el valornumero
            {
                mayor=val;
            }
            if (val<menor)//valornumero, si valornumero < menor, menor toma el valornumero
            {
                menor=val;
            }
            media=media+val;//media es la media mas el valor
        }
        media=media/numero;//calcula la media
        System.out.println("El numero mayor es: "+mayor+"\n");
        System.out.println("El numero menor es: "+menor+"\n");
        System.out.println("La media de los valores: "+media);
    }
 
} 
