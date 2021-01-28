package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Producto.Carrito;
import Tiendapck.Usuario;

public class CarritoBD {
	
	 protected static void CrearTablaCarrito(Connection con) {
			// TODO Auto-generated method stub
		    PreparedStatement preparedStatement = null;
		    //TABLA PRODUCTO
		    String createcarrito = "CREATE TABLE CARRITO(" +
		    		"IDCARRITO INTEGER PRIMARY KEY AUTO_INCREMENT," +
		    		"NICKNAME VARCHAR(50),"+
		    		"NOMBRE VARCHAR(50),"+
		    		"CODIGOACCESO VARCHAR(20),"+
		    		"PRECIO DOUBLE);";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createcarrito);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla Carrito creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
	//ELIMINAR TABLA
		 protected static void EliminarTablaCarrito(Connection con) {
			 
		     PreparedStatement preparedStatement = null;
			 
			 String EliminarCarrito= "DROP TABLE IF EXISTS CARRITO";
			 try {
				 preparedStatement = con.prepareStatement(EliminarCarrito);
		         preparedStatement.executeUpdate();

		            System.out.println("Tabla CARRITO eliminada correctamente.");

			} catch (Exception e) {
					System.err.println("Tabla CARRITO no ha podido eliminarse : "+e);
			}
		 }
		 
		 public static void InsertarCarrito(Carrito nuevoCarro) 
		 {
			 PreparedStatement preparedStatement = null;
			 Connection con = LLamadasBD.Conexion();
		        try {
		            String query = " INSERT INTO CARRITO (NICKNAME,NOMBRE,CODIGOACCESO,PRECIO)"
		                    + " VALUES (?, ?, ?, ?)";

		            preparedStatement = con.prepareStatement(query);


		            preparedStatement.setString(1, nuevoCarro.getNickname());
		            preparedStatement.setString(2, nuevoCarro.getNombre());
		            preparedStatement.setString(3, nuevoCarro.getCodigoac());
		            preparedStatement.setLong(4, (long) nuevoCarro.getPrecio());
		          
		            preparedStatement.execute();

		            System.out.println("Operación existosa");

		        } catch (Exception e) {
		            System.out.println("A ocurrido un ERROR");
		            System.out.println(e);
		        }
		 }
		 
}
