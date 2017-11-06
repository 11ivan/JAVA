/*La compra es el vestido junto con la cantidad pedida de ese vestido
 * 
 * Propiedades:
 * 	Cantidad: Basica, Cadena, Consultable, Modificable
 * 
 * Propiedades Agregadas:
 * 	Vestido: tipo Vestido, Consultable, no modificable
 * 
 * 
 * 
 */
public class Compra implements Comparable<Compra>, Cloneable{
	private Vestido vestido;
	private String cantidad;
	
	
	public Compra(){
		vestido=new Vestido();
		cantidad="0";
	}
	
	
	public Compra(Vestido vestido,String cantidad)throws ExcepcionCompra{
		int cantidadpars=0;
		boolean entra=true;
						
		this.vestido=vestido;
		
		try{
			cantidadpars=Integer.parseInt(cantidad);
		}catch(NumberFormatException error){
			System.out.println("Se espera un numero");
			entra=false;
		}
		if(entra && cantidadpars<=0){
			throw new ExcepcionCompra("La cantidad debe ser positiva");
		}else{
			this.cantidad=cantidad;
		}

	}
	
	
	public Compra(Compra compra){
		this.vestido=compra.getVestido();
		this.cantidad=compra.getCantidad();
	}
	
	
	//consultores
	public Vestido getVestido(){
		return vestido;
	}
	
	public String getCantidad(){
		return cantidad;
	}
	
	
	//Modificadores
	public void setCantidad(String cantidad)throws ExcepcionCompra{
		int cantidadpars=0;
		boolean entra=true;
		
		try{
			cantidadpars=Integer.parseInt(cantidad);
		}catch(NumberFormatException error){
			System.out.println("Se espera un numero");
			entra=false;
		}
		if(entra && cantidadpars<=0){
			throw new ExcepcionCompra("La cantidad debe ser positiva");
		}else{
			this.cantidad=cantidad;
		}

	}
	
	public void addVestido(Vestido vestido){
		this.vestido=vestido;
	}
	
	public double getPrecioCompra(){
		double precio;
		int cantidadpars=Integer.parseInt(cantidad);
		
		precio=Math.round(vestido.getPrecio()*cantidadpars);
		
		return precio;
	}
	
	
	@Override
	public int compareTo(Compra compra){
		int comparacion=0;
		if(Integer.parseInt(this.vestido.getCodigo())>Integer.parseInt(compra.getVestido().getCodigo())){
			comparacion=1;
		}else if(Integer.parseInt(this.vestido.getCodigo())<Integer.parseInt(compra.getVestido().getCodigo())){
			comparacion=-1;
		}
		return comparacion;
	}
	
	
	@Override
	public Compra clone(){
		Compra compra=null;
		
		try{
			compra=(Compra) super.clone();
		}catch(CloneNotSupportedException error){
			System.out.println("Objeto no clonado");
		}
		
		return compra;
	}
	
	
	
	
	
	
	
	
	

}
