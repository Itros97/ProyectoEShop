package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Producto.Carrito;
import Tiendapck.Usuarioconcod;

public class UsuarioconcodBD {
	 protected static void CrearTablaUcod(Connection con) {
			// TODO Auto-generated method stub
		    PreparedStatement preparedStatement = null;
		    //TABLA PRODUCTO
		    String createcarrito = "CREATE TABLE USUARIOCOD(" +
		    		"NICKNAME VARCHAR(50),"+
		    		"CODIGOACCESO VARCHAR(20),"+
		    		"PRIMARY KEY(NICKNAME,CODIGOACCESO));";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createcarrito);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla USUARIOCOD creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
	//ELIMINAR TABLA
		 protected static void EliminarTablaCarrito(Connection con) {
			 
		     PreparedStatement preparedStatement = null;
			 
			 String EliminarCarrito= "DROP TABLE IF EXISTS USUARIOCOD";
			 try {
				 preparedStatement = con.prepareStatement(EliminarCarrito);
		         preparedStatement.executeUpdate();

		            System.out.println("Tabla USUARIOCOD eliminada correctamente.");

			} catch (Exception e) {
					System.err.println("Tabla USUARIOCOD no ha podido eliminarse : "+e);
			}
		 }
		 
		 public static void InsertarUsuarioconcod(Usuarioconcod nuc) 
		 {
			 PreparedStatement preparedStatement = null;
			 Connection con = LLamadasBD.Conexion();
		        try {
		            String query = " INSERT INTO USUARIOCOD (NICKNAME,CODIGOACCESO)"
		                    + " VALUES (?, ?)";

		            preparedStatement = con.prepareStatement(query);


		            preparedStatement.setString(1, nuc.getNickname());
		            preparedStatement.setString(2, nuc.getCod());
		            preparedStatement.execute();

		            System.out.println("Operación existosa");

		        } catch (Exception e) {
		            System.out.println("A ocurrido un ERROR");
		            System.out.println(e);
		        }
		 }

}
