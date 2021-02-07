package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import Producto.Producto;
import Tiendapck.Usuario;

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
		    		"DESCRIPCION VARCHAR(300)," +
		    		"IMAGEN VARCHAR(225)," +
		    		"MARCA VARCHAR(20));";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createProducto);
	        preparedStatement.executeUpdate();

	        LLamadasBD.loggerBD.log(Level.FINE, "Tabla PRODUCTO creada correctamente");       
			
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			     LLamadasBD.loggerBD.log(Level.WARNING, "Tabla PRODUCTO no pudo ser creada");   
			}
}
	 //ELIMINAR TABLA
	 protected static void EliminarTablaProducto(Connection con) {
		 
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
	//INSERTAR PRODUCTOS
	 public static void InsertarProducto(Producto nuevoProducto) 
	 {
		 PreparedStatement preparedStatement = null;
		 Connection con = LLamadasBD.Conexion();
	        try {
	            String query = " INSERT INTO PRODUCTO (NOMBRE,PRECIO,STOCK,DESCRIPCION,IMAGEN,MARCA)"
	                    + " VALUES (?, ?, ?, ?, ?, ?)";

	            preparedStatement = con.prepareStatement(query);


	            preparedStatement.setString(1, nuevoProducto.getNombre());
	            preparedStatement.setDouble(2, nuevoProducto.getPrecio());
	            preparedStatement.setInt(3, nuevoProducto.getStock());
	            preparedStatement.setString(4, nuevoProducto.getDescripcion());
	            preparedStatement.setString(5, nuevoProducto.getImagen());
	            preparedStatement.setString(6, nuevoProducto.getMarca());
	            preparedStatement.execute();

	            System.out.println("Operaci�n existosa");
	            JOptionPane.showMessageDialog(null, "PRODUCTO INSERTADO CORRECTAMENTE EN LA BD");

	        } catch (Exception e) {
	            System.out.println("A ocurrido un error al a�adir el producto");
	            JOptionPane.showMessageDialog(null, "EL PRODUCTO NO PUEDO SER INSERTADO CORRECTAMENTE EN LA BD");
	            System.out.println(e);
	        }
	 }
	 //ELIMINAR Producto
	 public static void EliminarUsuario(int id) {
	     
	        PreparedStatement preparedStatement= null;
	   	 	Connection con = LLamadasBD.Conexion();

	        try {

	            String query = "DELETE FROM PRODUCTO WHERE IDPRODUCTO = '" + id + "'";

	            preparedStatement = con.prepareStatement(query);

	            preparedStatement.execute();
	            preparedStatement.close();

	        } catch (SQLException e) {

	            System.out.println("No se pudo eliminar el producto");
	            System.out.println(e);
	        }

	    }
}
