import java.util.Arrays;
import java.util.Collections;
public class testDisenos {

	public static void main(String[] args) {
		Vestido vestido=null;
		Vestido vestido2=null;
		Vestido vestido3=null;
		Vestido vestido4=null;
		Vestido vestido5=null;
		Vestido vestido6=null;
		Vestido vestido7=null;
		Vestido vestido8=null;
		Vestido vestido9=null;
		Vestido vestido10=null;
		Disenos lista=new Disenos();
		Vestido[] arrayOrdenado=new Vestido[0];
		//Collections coleccion=new  Collections();
		
		try{
			vestido=new Vestido("Gala",109.95,"455");
			vestido2=new Vestido("Informal",56.40,"201");
			vestido3=new Vestido("Tarde",40.95,"106");
			vestido4=new Vestido("Boda",35.30,"050");
			vestido5=new Vestido("Chandal",70.50,"789");
			vestido6=new Vestido("Vestido 2",55.0,"845");
			vestido7=new Vestido("Vestido 3",25.0,"012");
			vestido8=new Vestido("Vestido 4",36.0,"215");
			vestido9=new Vestido("Vestido 5",14.0,"990");
			vestido10=new Vestido("Vestido 6",24.0,"001");
		}catch(ExcepcionVestido error){
			System.out.println(error);
		}
		
		lista.getListaDisenos().add(vestido);
		lista.getListaDisenos().add(vestido2);
		lista.getListaDisenos().add(vestido3);
		lista.getListaDisenos().add(vestido4);
		lista.getListaDisenos().add(vestido5);
		lista.getListaDisenos().add(vestido6);
		lista.getListaDisenos().add(vestido7);
		lista.getListaDisenos().add(vestido8);
		lista.getListaDisenos().add(vestido9);
		lista.getListaDisenos().add(vestido10);
		
		lista.pintaLista();
		
		System.out.println("");
		lista.getListaDisenos().remove(0);
		//lista.getListaDisenos().add(vestido4);
		lista.pintaLista();
		
		System.out.println("");
		//arrayOrdenado=lista.toArray();		
		//Arrays.sort(arrayOrdenado);
		
		//lista.pintaLista(arrayOrdenado);
		
		
		
		//lista.ordenaLista();
		//System.out.println("");
		//lista.pintaLista();
		
		
		
		Collections.sort(lista.getListaDisenos());
		lista.pintaLista();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
