
public class testVestido {

	public static void main(String[] args) {
		Vestido vestido2=null;
		//Vestido vestido=new Vestido();
		Vestido clonado=new Vestido();
		try{
			vestido2=new Vestido("Vestido 1",5.0,"005");
		}catch(ExcepcionVestido error){
			System.out.println(error);
		}
		
		System.out.println(vestido2.getNombre()+", "+vestido2.getCodigo()+", "+vestido2.getPrecio());		
		System.out.println(vestido2.toString());
		System.out.println(vestido2.hashCode());
		try{
		vestido2.setPrecio(5.65);
		}catch(ExcepcionVestido error){
			System.out.println(error);
		}
		System.out.println(vestido2.getPrecio());
		clonado=vestido2.clone();
		System.out.println(clonado.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
