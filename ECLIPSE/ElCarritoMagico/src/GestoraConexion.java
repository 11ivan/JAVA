import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class GestoraConexion {

	private Connection connexionBaseDatos;
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Abre la conexion con la base de datos
	 Prototipo: void connect()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay 
	 Postcondiciones: Se ha abierto la conexión con la base de datos
	 */	
	public void connect(){
		String[] camposConexion=new String[3];	
		camposConexion=this.getDatosConexion();

		try {			
			connexionBaseDatos = DriverManager.getConnection(camposConexion[0], camposConexion[1], camposConexion[2]);
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Cierra la conexión con la base de datos
	 Prototipo: void close()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay 
	 Postcondiciones: Se ha cerrado la conexión con la base de datos
	 */	
	public void close(){
		try {			
			connexionBaseDatos.close();		
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Crea un fichero binario que se usará para la conexión a la base de datos
	 Prototipo: void creaFicheroConexion(String sourceURL, String usuarioConexion, String password)
	 Precondiciones: Todos los datos son correctos
	 Entradas: tres cadenas, una será el nombre de usuario, la contraseña y la direccion de la base de datos ("jdbc:sqlserver://localhost")
	 Salidas: no hay
	 Postcondiciones: Se habrá creado un archivo binario
	 */	
	public void creaFicheroConexion(String sourceURL, String usuarioConexion, String password){
		File file =new File("DatosConexion.dat");
		ObjectOutputStream oos=null;
		FileOutputStream fos=null;
		String campos=sourceURL+","+usuarioConexion+","+password;
		
		try {
			fos=new FileOutputStream(file);
			oos=new ObjectOutputStream(fos){@Override protected void writeStreamHeader(){}};
			
			oos.writeObject(campos);

		} catch (FileNotFoundException e) {
			System.out.println(e);
		} catch (IOException e) {
			System.out.println(e);
		}finally {
			try{
				if(oos!=null){
					oos.close();
				}
				if(fos!=null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Lee un archivo binario con los datos de la conexión a la base de datos y devuelve una cadcena un array de cadenas con los mismos
	 Prototipo: String[] getDatosConexion()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: Un array de cadenas
	 Postcondiciones: El array de cadenas contendrá los datos para la conexión con la base de datos
	 */	

	public String[] getDatosConexion(){
		File file =new File("DatosConexion.dat");
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		String[] camposConexion=new String[3];
		//String campos=null;
		
		try {
			fis=new FileInputStream(file);
			ois=new ObjectInputStream(fis){@Override protected void readStreamHeader(){}};	
			camposConexion=ois.readObject().toString().split(",");
						
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally{	
			try {
				if(ois!=null){
					ois.close();
				}
				if(fis!=null){
					fis.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		return camposConexion;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Comprueba si un usuario existe en la base de datos
	 Prototipo: boolean validaUsuario(String usuario, String password)
	 Precondiciones: No hay
	 Entradas: Dos cadenas, una será el nombre de usuario y la otra la contraseña
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el usuario existe en la base de datos y false si no
	 */	
	public boolean validaUsuario(String usuario, String password){
		//File file =new File("DatosConexion.dat");
		//FileInputStream fis=null;
		//ObjectInputStream ois=null;
		//String[] camposConexion=new String[3];
		String miSelect = "Select nombre from Usuarios where Nombre="+"'"+usuario+"'"+" and Password=hashbytes('SHA1',"+"'"+password+"'"+")";
		boolean vale=false;
		
		//camposConexion=this.getDatosConexion();

		try {			
			//Connection connexionBaseDatos = DriverManager.getConnection(camposConexion[0], camposConexion[1], camposConexion[2]);
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(miSelect);
			
			while(resultados.next()){
				if(resultados.getString("Nombre").equalsIgnoreCase(usuario)){
					vale=true;
				}
			}
			//connexionBaseDatos.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		
		return vale;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Inserta un nuevo usuario Cliente en la base de datos
	 Prototipo: boolean addUser(String usuario, String password)
	 Precondiciones: no hay
	 Entradas: Dos cadenas que serán nombre de usuario y contraseña
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el usuario se ha insertado correctamente en la base de datos (el usuario no existe) y 
	 				  falso si no (el usuario ya existe en la base de datos)
	 */
	public boolean addUser(UsuarioImpl usuario){
		boolean insertado=false;		
		//String[] camposConexion=new String[3];
		//camposConexion=this.getDatosConexion();
		String consulta = "Select nombre from Usuarios where Nombre="+"'"+usuario.getNombre()+"'";
		String insercion="INSERT INTO Usuarios values ("+"'"+usuario.getNombre()+"'"+", "+"'"+usuario.getTipo()+"'"+", HASHBYTES('SHA1',"+"'"+usuario.getPassword()+"'"+ "))";
		
		try {
			//Connection connexionBaseDatos = DriverManager.getConnection(camposConexion[0], camposConexion[1], camposConexion[2]);
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);

			if(resultados==null){
				sentencia.executeQuery(insercion);
				insertado=true;
			}

			
			//connexionBaseDatos.close();
		} catch (SQLException e) {
			System.out.println(e);
			//System.out.println("El usuario ya existe");
		}	
	
		return insertado;
	}
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Devuelve el tipo de un usuario de la base de datos
	 Prototipo: String getTipoUsuario(String usuario)
	 Precondiciones: El usuario existe en la base de datos
	 Entradas: Una cadena que será el nombre de usuario
	 Salidas: Una cadena
	 Postcondiciones: La cadena será el tipo del usuario consultado
 	 */	
	public String getTipoUsuario(String usuario){
		String tipo=" ";	
		String consulta = "Select tipo from Usuarios where Nombre="+"'"+usuario+"'";
		//String[] camposConexion=new String[3];
		//camposConexion=this.getDatosConexion();
		try {
			//Connection connexionBaseDatos = DriverManager.getConnection(camposConexion[0], camposConexion[1], camposConexion[2]);
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);
			
			while(resultados.next()){
				tipo=resultados.getString("Tipo");
			}
			//connexionBaseDatos.close();
		} catch (SQLException e) {
			System.out.println(e);
		}			
		return tipo;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Devuelve el ID de un usuario de la base de datos
	 Prototipo: String getIDUsuario(String usuario)
	 Precondiciones: El usuario existe en la base de datos
	 Entradas: Una cadena que será el nombre de usuario
	 Salidas: Una cadena
	 Postcondiciones: La cadena será el id del usuario consultado
 	 */	
	public String getIDUsuario(String usuario){
		String id=" ";	
		String consulta = "Select ID from Usuarios where Nombre="+"'"+usuario+"'";
		//String[] camposConexion=new String[3];
		//camposConexion=this.getDatosConexion();
		try {
			//Connection connexionBaseDatos = DriverManager.getConnection(camposConexion[0], camposConexion[1], camposConexion[2]);
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);
			
			while(resultados.next()){
				id=resultados.getString("ID");
			}
			//connexionBaseDatos.close();
		} catch (SQLException e) {
			System.out.println(e);
		}			
		return id;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Lista todos los productos de la base de datos
	 Prototipo: void muestraProductosOperario()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay
	 Postcondiciones: Se muestran los productos por pantalla
 	 */	
	public void muestraProductosOperario(){		   
		String miSelect = "SELECT cast(P.ID as char(10)) as ID, cast(P.Nombre as char(30)) as Nombre, cast(Descripcion as char(30)) as Descripcion, cast(PrecioUnitario as char(16)) as PrecioUnitario, cast(Stock as char(11)) as Stock, cast(P.Activo as char(13)) as Activo, cast(C.Nombre as char(30)) as Categoria FROM Productos as P inner join Categorias as C on P.IDCategoria=C.ID Order by C.Nombre";

		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet nombresProductos = sentencia.executeQuery(miSelect);
			
			// Mostrar los datos del ResultSet
			System.out.println("ID          Nombre           \t\t  Descripcion     \t    PrecioUnitario      Stock \t   Activo  \t Categoria");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			while (nombresProductos.next()){
				
			  System.out.println(nombresProductos.getString("ID") +"|"+ nombresProductos.getString("Nombre") +"|"+ 
					  			nombresProductos.getString("Descripcion")+"|"+ nombresProductos.getString("PrecioUnitario")+"|"+ 
					  			nombresProductos.getString("Stock")+"|"+nombresProductos.getString("Activo")+"|"+nombresProductos.getString("Categoria")+"|" );
			
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 

	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Lista los productos activos de la base de datos
	 Prototipo: void muestraProductosCliente()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay
	 Postcondiciones: Se muestran los productos por pantalla
 	 */	
	public void muestraProductosCliente(){		   
		String miSelect = "SELECT cast(P.ID as char(10)) as ID, cast(P.Nombre as char(30)) as Nombre, cast(Descripcion as char(30)) as Descripcion, cast(PrecioUnitario as char(15)) as PrecioUnitario, cast(Stock as char(9)) as Stock, P.Activo, cast(C.Nombre as char(30)) as Categoria FROM Productos as P inner join Categorias as C on P.IDCategoria=C.ID Order by C.Nombre";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet nombresProductos = sentencia.executeQuery(miSelect);
			
			// Mostrar los datos del ResultSet
			System.out.println("ID          Nombre           \t\t  Descripcion     \t    PrecioUnitario      Stock \t  Categoria");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			while (nombresProductos.next()){
				if(nombresProductos.getString("Activo").equals("1")){
					System.out.println(nombresProductos.getString("ID") +"|"+ nombresProductos.getString("Nombre") +"|"+ 
					  			nombresProductos.getString("Descripcion")+"|"+ nombresProductos.getString("PrecioUnitario")+"|"+ 
					  			nombresProductos.getString("Stock")+"|"+nombresProductos.getString("Categoria")+"|" );
				}
			}//fin mientras
	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 

	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Lista las categorias de la base de datos
	 Prototipo: void muestraCategorias()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay
	 Postcondiciones: Se muestran las categorias por pantalla
 	 */	
	public void muestraCategorias(){		   
		String miSelect = "SELECT cast(ID as char(5))as ID, Nombre FROM Categorias";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet nombresCategorias = sentencia.executeQuery(miSelect);
			
			// Mostrar los datos del ResultSet
			System.out.println("Nombre");
			System.out.println("--------");
			while (nombresCategorias.next()){
			  System.out.println(nombresCategorias.getString("ID")+nombresCategorias.getString("Nombre"));
			
			}//fin mientras      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 

	}

	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Comprueba si una categoria de producto existe en la base de datos
	 Prototipo: boolean compruebaCategoria(String categoria)
	 Precondiciones: no hay
	 Entradas: una cadena que será el nombre de la categoria
	 Salidas: un booleano
	 Postcondiciones: el booleano será verdadero si la categoria existe en la base de datos
 	 */	
	public boolean compruebaCategoria(String idcategoria){
		boolean existe=false;
		String consulta="SELECT ID FROM Categorias";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet nombresCategorias = sentencia.executeQuery(consulta);
						
			while (nombresCategorias.next() && !existe){
			 if(nombresCategorias.getString("ID").equalsIgnoreCase(idcategoria)){
				 existe=true;
			 }			
			}//fin mientras      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 
		
		return existe;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*																				
	 Proposito: Inserta un nuevo Producto en la base de datos
	 Prototipo: boolean addProducto(ProductoImpl producto)
	 Precondiciones: no hay
	 Entradas: Un objeto ProductoImpl
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el producto se ha insertado correctamente en la base de datos (el producto no existe) y 
	 				  falso si no (el producto ya existe en la base de datos)
	 */	
	public boolean addProducto(ProductoImpl producto){
		boolean insertado=true;		
		String consulta = "select nombre from Productos";
		String insercion="INSERT INTO Productos values ("+"'"+producto.getNombre()+"'"+", "+"'"+producto.getDescripcion()+"'"+","+ Double.parseDouble(producto.getPrecio())+", "+Integer.parseInt(producto.getStockage())+", "+Integer.parseInt(producto.getIDCategoria())+")";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);

			while(resultados.next() && insertado){
				if(resultados.getString("Nombre").equalsIgnoreCase(producto.getNombre())){
					insertado=false;	
				}
			}
			if(insertado==true){
				sentencia.executeQuery(insercion);		
			}
		} catch (SQLException e) {
			System.out.println(e);
		}	
		return insertado;
	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Desactiva un producto de la base de datos
	 Prototipo: boolean desactivaProducto(String idproducto)
	 Precondiciones: El producto está en la base de datos
	 Entradas: Una cadena
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el producto se ha desactivado correctamente en la base de datos  y 
	 				  falso si no (Ya está desactivado)
	 */
	public boolean desactivaProducto(String idproducto){
		boolean borrado=false;		
		String consulta = "Select ID, Activo from Productos";
		String marcar="update Productos set Activo=0 where ID=" +"'"+idproducto+"'";
		String IDProducto=" ";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);

			while(!borrado && resultados.next()){
				IDProducto=resultados.getString("ID");
				System.out.println(IDProducto);
				if(IDProducto.equalsIgnoreCase(idproducto) && resultados.getString("Activo").equals("1")){
					borrado=true;	
					sentencia.execute(marcar);					
				}
			}
		} catch (SQLException e) {
			//System.out.println(e);      
			e.printStackTrace();
		}		
		return borrado;
	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Desactiva un producto de la base de datos
	 Prototipo: boolean activaProducto(String idproducto)
	 Precondiciones: El producto está en la base de datos
	 Entradas: Una cadena
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el producto se ha desactivado correctamente en la base de datos  y 
	 				  falso si no (Ya está activado)
	 */
	public boolean activaProducto(String idproducto){
		boolean activado=false;		
		String consulta = "Select ID, Activo from Productos";
		String desmarcar="update Productos set Activo=1 where ID=" +"'"+idproducto+"'";
		String IDProducto=" ";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet resultados = sentencia.executeQuery(consulta);

			while(!activado && resultados.next()){
				IDProducto=resultados.getString("ID");
				System.out.println(IDProducto);
				if(IDProducto.equalsIgnoreCase(idproducto) && resultados.getString("Activo").equals("0")){
					activado=true;	
					sentencia.execute(desmarcar);					
				}
			}
		} catch (SQLException e) {
			//System.out.println(e);     
			e.printStackTrace();
		}		
		return activado;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Comprueba que un ID producto exista en la base de datos
	 Prototipo: boolean compruebaProducto(String id)
	 Precondiciones: no hay
	 Entradas: Una cadena
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el id existe en la base de datos y falso si no 
	 */
	public boolean compruebaProducto(String idProducto){
		boolean existe=false;
		String consulta="SELECT ID FROM Productos";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet idProductos = sentencia.executeQuery(consulta);
						
			while (!existe && idProductos.next()){
			 if(idProductos.getString("ID").equalsIgnoreCase(idProducto)){
				 existe=true;
			 }			
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 		
		return existe;
	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Muestra el stock actual de un producto
	 Prototipo: int stockProducto(String idProducto)
	 Precondiciones: El id del producto existe en la base de datos
	 Entradas: Una cadena
	 Salidas: Una cadena
	 Postcondiciones: La cadena es el stock del producto
	 */
	public Integer stockProducto(String idProducto){
		String stock="0";	
		String consulta="SELECT Stock FROM Productos where ID="+"'"+idProducto+"'";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet idProductos = sentencia.executeQuery(consulta);
						
			while (idProductos.next()){
			 stock=idProductos.getString("Stock");
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 		
		return Integer.parseInt(stock);
	}
	
	
	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Devuelve Un objeto ProductoImpl dado un id
	 Prototipo: ProductoImpl getProducto(String idproducto)
	 Precondiciones: El id del producto existe en la base de datos
	 Entradas: Una cadena
	 Salidas: Un ProductoImpl
	 Postcondiciones: Se devuelve un objeto ProductoImpl
	 */
	public ProductoImpl getProducto(String idProducto){
		ProductoImpl producto=null;
		String consulta="SELECT cast(ID as nvarchar)as ID, Nombre, Descripcion, cast(PrecioUnitario as nvarchar)as PrecioUnitario, cast(Stock as nvarchar)as Stock, cast(IDCategoria as nvarchar)as IDCategoria FROM Productos where ID="+"'"+idProducto+"'";

		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet Producto = sentencia.executeQuery(consulta);
						
			while (Producto.next()){
				producto=new ProductoImpl();
				producto.setID(Producto.getString("ID"));				
				try {
					producto.setNombre(Producto.getString("Nombre"));
					producto.setDescripcion(Producto.getString("Descripcion"));
					producto.setPrecio(Producto.getString("PrecioUnitario"));
					producto.setStockage(Producto.getString("Stock"));
				} catch (ExcepcionProducto e) {
					System.out.println(e);
				}
				producto.setIDCategoria(Producto.getString("IDCategoria"));
			
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 		
		return producto;
	}
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Muestra los productos activos de una categoria
	 Prototipo: void productosPorCategoria(String idCategoria)
	 Precondiciones: El id de la categoria existe en la base de datos
	 Entradas: Una cadena
	 Salidas: Una cadena
	 Postcondiciones: Se muestran los productos por categoria 
	 */
	public void productosPorCategoria(String idCategoria){		   
		String miSelect = "SELECT cast(P.ID as char(10)) as ID, cast(P.Nombre as char(30)) as Nombre, cast(Descripcion as char(30)) as Descripcion, cast(PrecioUnitario as char(16)) as PrecioUnitario, cast(Stock as char(11)) as Stock, P.Activo, cast(C.Nombre as char(30)) as Categoria FROM Productos as P inner join Categorias as C on P.IDCategoria=C.ID where P.IDCategoria="+idCategoria;
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet nombresProductos = sentencia.executeQuery(miSelect);
			
			// Mostrar los datos del ResultSet
			System.out.println("ID          Nombre           \t\t  Descripcion     \t    PrecioUnitario      Stock \t  Categoria");
			System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
			while (nombresProductos.next()){
				if(nombresProductos.getString("Activo").equals("1")){
					System.out.println(nombresProductos.getString("ID") +"|"+ nombresProductos.getString("Nombre") +"|"+ 
					  			nombresProductos.getString("Descripcion")+"|"+ nombresProductos.getString("PrecioUnitario")+"|"+ 
					  			nombresProductos.getString("Stock")+"|"+nombresProductos.getString("Categoria")+"|" );
				}
			}//fin mientras
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 
	}

	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Muestra todos los productos de una categoria
	 Prototipo: ProductoImpl getProducto(String idproducto)
	 Precondiciones: El id de la categoria existe en la base de datos
	 Entradas: Una cadena
	 Salidas: Una cadena
	 Postcondiciones: Se muestran los productos por categoria 
	 */
	public void productosPorCategoriaOperario(String idCategoria){		   
		String miSelect = "SELECT cast(P.ID as char(10)) as ID, cast(P.Nombre as char(30)) as Nombre, cast(Descripcion as char(30)) as Descripcion, cast(PrecioUnitario as char(16)) as PrecioUnitario, cast(Stock as char(11)) as Stock, cast(P.Activo as char(13)) as Activo, cast(C.Nombre as char(30)) as Categoria FROM Productos as P inner join Categorias as C on P.IDCategoria=C.ID where P.IDCategoria="+idCategoria;
		
			try {
				Statement sentencia = connexionBaseDatos.createStatement();
				ResultSet nombresProductos = sentencia.executeQuery(miSelect);
				
				// Mostrar los datos del ResultSet
				System.out.println("ID          Nombre           \t\t  Descripcion     \t    PrecioUnitario      Stock \t   Activo  \t Categoria");
				System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
				while (nombresProductos.next()){
					
				  System.out.println(nombresProductos.getString("ID") +"|"+ nombresProductos.getString("Nombre") +"|"+ 
						  			nombresProductos.getString("Descripcion")+"|"+ nombresProductos.getString("PrecioUnitario")+"|"+ 
						  			nombresProductos.getString("Stock")+"|"+nombresProductos.getString("Activo")+"|"+nombresProductos.getString("Categoria")+"|" );
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 
	}

	
	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: valida que un ID producto filtrado por categoria exista en la base de datos
	 Prototipo: compruebaProducto(String id, String idCategoria)
	 Precondiciones: no hay
	 Entradas: Una cadena
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el id existe en la base de datos y falso si no 
	 */
	public boolean compruebaProductoPorCategoria(String idProducto, String idCategoria){
		boolean existe=false;
		String consulta="SELECT ID FROM Productos where IDCategoria="+"'"+idCategoria+"'";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet idProductos = sentencia.executeQuery(consulta);
						
			while (!existe && idProductos.next()){
			 if(idProductos.getString("ID").equalsIgnoreCase(idProducto)){
				 existe=true;
			 }			
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 
		return existe;
	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: valida que un producto esté activo en la base de datos
	 Prototipo:  boolean compruebaProductoActivo(String idProducto)
	 Precondiciones: no hay
	 Entradas: Una cadena
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el id existe en la base de datos y falso si no 
	 */
	public boolean compruebaProductoActivo(String idProducto){
		boolean existe=false;
		String consulta="SELECT Activo FROM Productos where ID="+"'"+idProducto+"'";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet idProductos = sentencia.executeQuery(consulta);
			
			
			while (!existe && idProductos.next()){
			 if(idProductos.getString("Activo").equals("1")){
				 existe=true;
			 }			
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 
		
		return existe;
	}

	
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Registra una venta en la base de datos
	 Prototipo: void regVenta(VentaImpl venta)
	 Precondiciones: Los datos de la venta son correctos, y contiene productos
	 Entradas: Un objeto VentaImpl
	 Salidas: no hay
	 Postcondiciones: La venta se habrá registrado en la base de datos (Grabamos en la tabla ventas y ProductosVentas)
	 */
	public void regVenta(VentaImpl venta){
		String instruccion1="insert into Ventas values ("+"'"+venta.getIDUsuario()+"'"+",getDate())";
		String consultaIDVenta="select top 1 ID from ventas order by FechaVenta desc";
		String instruccion2=" ";
		String instruccion3=" ";
		int stockPars=0;
		int cantidadPars=0;
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();	
			
			sentencia.execute(instruccion1);	
			ResultSet resultado=sentencia.executeQuery(consultaIDVenta);
			
			while(resultado.next()){
				venta.setId(resultado.getString("ID"));
			}
			
			for(int i=0;i<venta.getListaProductos().size();i++){
				instruccion2="insert into ProductosVentas values("+venta.getID()+","+venta.getListaProductos().get(i).getID()+","+venta.getCantidades().get(i)+","+venta.getListaProductos().get(i).getPrecio()+")";
				sentencia.execute(instruccion2);
				stockPars=this.stockProducto(venta.getListaProductos().get(i).getID());
				cantidadPars=venta.getCantidades().get(i);
				instruccion3="update Productos set Stock="+(stockPars-cantidadPars)+"where ID="+venta.getListaProductos().get(i).getID();
				sentencia.execute(instruccion3);
			}
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		  } 
	}
		
		
	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Registra un pedido en la base de datos
	 Prototipo: void regPedido(PedidoImpl pedido)
	 Precondiciones: Los datos del pedido son correctos, y contiene productos
	 Entradas: Un objeto PedidoImpl
	 Salidas: no hay
	 Postcondiciones: La venta se habrá registrado en la base de datos (Grabamos en la tabla pedidos y ProductosPedidos)
	 */
	public void regPedido(PedidoImpl pedido){
		String instruccion1="insert into Pedidos values ("+pedido.getIDUsuario()+", "+pedido.getIDProveedor()+", "+"getDate())";
		String consultaIDPedido="select top 1 ID from Pedidos order by FechaPedido desc";
		String instruccion2=" ";
		String instruccion3=" ";
		int stockPars=0;
		int cantidadPars=0;
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();	
			
			sentencia.execute(instruccion1);	
			ResultSet resultado=sentencia.executeQuery(consultaIDPedido);
			
			while(resultado.next()){
				pedido.setId(resultado.getString("ID"));
			}
			
			for(int i=0;i<pedido.getListaProductos().size();i++){
				instruccion2="insert into ProductosPedidos values("+pedido.getID()+","+pedido.getListaProductos().get(i).getID()+","+pedido.getCantidades().get(i)+","+pedido.getListaProductos().get(i).getPrecio()+")";
				sentencia.execute(instruccion2);
				stockPars=this.stockProducto(pedido.getListaProductos().get(i).getID());
				cantidadPars=pedido.getCantidades().get(i);
				instruccion3="update Productos set Stock="+(stockPars+cantidadPars)+"where ID="+pedido.getListaProductos().get(i).getID();
				sentencia.execute(instruccion3);
			}
		  } catch (SQLException sqle) {
		    sqle.printStackTrace();
		  } 
	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Comprueba si un ID proveedor existe en la base de datos
	 Prototipo: boolean compruebaIDProveedor(String idProveedor)
	 Precondiciones: no hay
	 Entradas: Una cadena
	 Salidas: un booleano
	 Postcondiciones: El booleano será verdadero si el id existe en la base de datos y falso si no 
	 */
	public boolean compruebaIDProveedor(String idProveedor){
		boolean existe=false;
		String consulta="SELECT ID FROM Proveedores where ID="+idProveedor;
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet idProveedores = sentencia.executeQuery(consulta);
			
			
			while (!existe && idProveedores.next()){
			 if(idProveedores.getString("ID").equals(idProveedor)){
				 existe=true;
			 }			
			}//fin mientras	      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 
		
		return existe;
	}

	//------------------------------------------------------------------------------------------------------------------------------
	/*
	 Proposito: Lista los proveedores de la base de datos
	 Prototipo: void muestraCategorias()
	 Precondiciones: no hay
	 Entradas: no hay
	 Salidas: no hay
	 Postcondiciones: Se muestran los proveedores
 	 */	
	public void muestraProveedores(){		   
		String miSelect = "SELECT cast(ID as char(10))as ID, Nombre FROM Proveedores";
		
		try {
			Statement sentencia = connexionBaseDatos.createStatement();
			ResultSet nombresCategorias = sentencia.executeQuery(miSelect);
			
			// Mostrar los datos del ResultSet
			System.out.println("ID        Nombre");
			System.out.println("--------");
			while (nombresCategorias.next()){
			  System.out.println(nombresCategorias.getString("ID")+nombresCategorias.getString("Nombre"));
			
			}//fin mientras      
		  } catch (SQLException sqle) {
		    System.err.println(sqle);
		  } 

	}

	
	
	
	
	
}
