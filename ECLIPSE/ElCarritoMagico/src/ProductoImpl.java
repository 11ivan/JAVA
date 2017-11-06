import java.util.InputMismatchException;

/*
Propiedades:
	ID: Basica, cadena, consultable, modificable
	Nombre: Basica, cadena, consultable, modificable
	Descripcion: Basica, cadena, consultable, modificable
	Precio: Basica, cadena, consultable, modificable
	Stock: Basica, cadena, consultable, modificable
	IDCategoria: Basica, cadena, consultable, modificable
*/



public class ProductoImpl implements Producto, Comparable<ProductoImpl> {
	private String id;
	private String nombre;
	private String descripcion;
	private String precio;
	private String stockage;
	private String idcategoria;
	
	//Constructores
	public ProductoImpl(){
		id="0";
		nombre="default";
		descripcion="default";
		precio="0.0";
		stockage="0";
		idcategoria="default";
	}
	
	public ProductoImpl(String id, String nombre, String descripcion, String precio, String stockage, String idcategoria) throws ExcepcionProducto{
		double precioPars=-1;
		int stockPars=-1;
		boolean sigue=true; 
		
		this.id=id;
		
		if(nombre.replaceAll(" ", "").length()<4){
			throw new ExcepcionProducto("El nombre debe tener una longitud de al menos 4 carácteres");
		}else{
			this.nombre=nombre;
		}
		
		if(descripcion.length()>50){
			throw new ExcepcionProducto("El campo descripción no puede tener más de 50 caracteres");
		}else if(descripcion.replaceAll(" ", "").length()==0){
			throw new ExcepcionProducto("El campo descripción no puede estar vacío");
		}else{
			this.descripcion=descripcion;
		}
		
		try{
			precioPars=Double.parseDouble(precio);
		}catch(InputMismatchException e){
			System.out.println("Se espera un número");
			sigue=false;			
		}
		if(sigue){
			if(precioPars<=0){
				throw new ExcepcionProducto("El precio no puede ser negativo o 0");
			}else{
				this.precio=precio;
			}
		}
		sigue=true;
		
		try{
			stockPars=Integer.parseInt(stockage);
		}catch(InputMismatchException e){
			System.out.println("Se espera un número");
			sigue=false;			
		}
		if(sigue){
			if(stockPars<0){
				throw new ExcepcionProducto("El stock no puede ser negativo");
			}else{
				this.stockage=stockage;
			}
		}

		this.idcategoria=idcategoria;
		
	}
	
	
	public ProductoImpl(ProductoImpl producto){
		id=producto.getID();
		nombre=producto.getNombre();
		descripcion=producto.getDescripcion();
		precio=producto.getPrecio();
		stockage=producto.getStockage();
		idcategoria=producto.getIDCategoria();
	}

	
	
	//Consultores
	public String getID(){
		return id;
	}
	public String getNombre(){
		return nombre;
	}
	public String getDescripcion(){
		return descripcion;
	}
	public String getPrecio(){
		return precio;
	}
	public String getStockage(){
		return stockage;
	}
	public String getIDCategoria(){
		return idcategoria;
	}
	
	
	//Modificadores
	public void setID(String id){
		this.id=id;
	}
	
	public void setNombre(String nombre) throws ExcepcionProducto{
		if(descripcion.length()>30){
			throw new ExcepcionProducto("El nombre no puede tener más de 30 caracteres");
		}else if(nombre.replaceAll(" ", "").length()<4){
			throw new ExcepcionProducto("El nombre debe tener una longitud de al menos 4 carácteres");
		}else{
			this.nombre=nombre;
		}
	}
	
	public void setDescripcion(String descripcion) throws ExcepcionProducto{
		if(descripcion.length()>50){
			throw new ExcepcionProducto("El campo descripción no puede tener más de 50 caracteres");
		}else if(descripcion.replaceAll(" ", "").length()<4){
			throw new ExcepcionProducto("El campo descripción debe tener una longitud de al menos 4 carácteres");					
		}else{
			this.descripcion=descripcion;
		}
	}
	
	
	public void setPrecio(String precio)throws ExcepcionProducto{
		double precioPars=-1;
		boolean sigue=true; 
		
		if(precio.replaceAll(" ", "").length()==0){
			throw new ExcepcionProducto("El precio no puede estar vacío");
		}else{
			try{
				precioPars=Double.parseDouble(precio);
			}catch(NumberFormatException e){
				System.out.println("Se espera un número");
				sigue=false;			
			}
			if(sigue){
				if(precioPars<=0){
					throw new ExcepcionProducto("El precio no puede ser negativo o 0");
				}else if(precioPars>99.99){
					throw new ExcepcionProducto("El precio no puede ser mayor que 99.99");
				}else{
					this.precio=precio;
				}
			}	
		}
	}
	
	public void setStockage(String stockage)throws ExcepcionProducto{
		int stockPars=-1;
		boolean sigue=true; 

		if(stockage.replaceAll(" ", "").length()==0){
			throw new ExcepcionProducto("El stock no puede estar vacío");
		}else{
			try{
				stockPars=Integer.parseInt(stockage);
			}catch(NumberFormatException e){
				//System.out.println("Se espera un número");
				sigue=false;			
			}
			if(sigue){
				if(stockPars<0){
					throw new ExcepcionProducto("El stock no puede ser negativo");
				}else{
					this.stockage=stockage;
				}
			}else{
				throw new ExcepcionProducto("Se espera un número");
			}
		}
	}
	
	public void setIDCategoria(String idcategoria){
		this.idcategoria=idcategoria;
	}
	
	//--------------------------------------------------
	
	@Override
	public int compareTo(ProductoImpl producto) {
		int comparacion=0;
		
		if(Double.parseDouble(this.precio)>Double.parseDouble(producto.getPrecio())){
			comparacion=1;
		}else if(Double.parseDouble(this.precio)<Double.parseDouble(producto.getPrecio())){
			comparacion=-1;
		}
		
		return comparacion;
	}

	//---------------------------------------------------
	public boolean equals(Object obj){
		boolean iguales=false;
		
		if(obj!=null && obj instanceof ProductoImpl){
			ProductoImpl producto=(ProductoImpl) obj;
			
			if(this.id.equals(producto.getID()) && this.nombre.equalsIgnoreCase(producto.getNombre()) && this.descripcion.equalsIgnoreCase(producto.getDescripcion()) && 
					this.stockage.equals(producto.getStockage()) && this.idcategoria.equals(producto.getIDCategoria())){
				iguales=true;
			}
		}
		
		return iguales;
	}
	
	
	//-----------------------------------------------------
	public String toString(){
		String cadena;
		
		cadena=id+","+nombre+","+descripcion+","+precio+","+stockage+","+idcategoria;
		
		return cadena;
	}
	
	
}
