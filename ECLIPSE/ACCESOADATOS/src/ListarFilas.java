//package basico;
import java.sql.*;

public class ListarFilas {
  public static void main(String[] args) {

    // Carga el driver
    try {

      // Carga la clase del driver
      // No hace falta
      //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

      // Define the data source for the driver
      String sourceURL = "jdbc:sqlserver://localhost";
      String usuario = "pepito";
      String password = "qq";
      String miSelect = "SELECT cast(ID as char(10)) as ID, cast(Nombre as char(30)) as Nombre, cast(Descripcion as char(30)) as Descripcion, cast(PrecioUnitario as char(12)) as PrecioUnitario, cast(Stock as char(9)) as Stock FROM Productos";

      // Crear una connexión con el DriverManager
      Connection connexionBaseDatos = DriverManager.getConnection(sourceURL, usuario, password);
      Statement sentencia = connexionBaseDatos.createStatement();
      ResultSet nombresProductos = sentencia.executeQuery(miSelect);
      
      // Mostrar los datos del ResultSet
      System.out.println(" ID          Nombre           \t\tDescripcion     \tPrecioUnitario      Stock ");
      System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------");
      while (nombresProductos.next()){
    	  System.out.println(nombresProductos.getString("ID") +"|"+ nombresProductos.getString("Nombre") +"|"+ 
    			  			nombresProductos.getString("Descripcion")+"|"+ nombresProductos.getString("PrecioUnitario")+"|"+ 
    			  			nombresProductos.getString("Stock")+"|" );

      }//fin mientras
      
	  // Cerrar conexión
	  connexionBaseDatos.close();	      
    } catch (SQLException sqle) {
      System.err.println(sqle);
    } 
  }
}
