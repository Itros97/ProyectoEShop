package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ProductoBD {

	 protected static void CrearTablaProducto(Connection con) {
			// TODO Auto-generated method stub
		    PreparedStatement preparedStatement = null;
		    
		    //TABLA PRODUCTO
		    String createProducto = "CREATE TABLE PRODUCTO(" +
		    		"IDPRODUCTO INTEGER PRIMARY KEY AUTO_INCREMENT," +
		    		"NOMBRE VARCHAR(50) NOT NULL," +
		    		"PRECIO DOUBLE NOT NULL," +
		    		"STOCK INTEGER," +
		    		"TIPODEPRODUCTO VARCHAR(20)" +
		    		"DESCRIPCION VARCHAR(300)" +
		    		"IMAGEN VARCHAR(225)" +
		    		"MARCA VARCHAR(20));";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createProducto);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla PRODUCTO creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
	 //ELIMINAR
	 protected void EliminarTablaProducto(Connection con) {
		 
	     PreparedStatement preparedStatement = null;
		 
		 String EliminarUsuario= "DROP TABLE IF EXISTS PRODUCTO";
		 try {
			 preparedStatement = con.prepareStatement(EliminarUsuario);
	         preparedStatement.executeUpdate();

	            System.out.println("Tabla PRODUCTO eliminada correctamente.");

		} catch (Exception e) {
				System.err.println("Tabla Producto no ha podido crearse : "+e);
		}
	 }
	
}
