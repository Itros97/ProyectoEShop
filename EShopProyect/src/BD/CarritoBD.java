package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CarritoBD {
	
	 protected static void CrearTablaCarrito(Connection con) {
			// TODO Auto-generated method stub
		    PreparedStatement preparedStatement = null;
		    //Nickname(id_usuario),nOMBREPRODUCTO E PRECIO
		    //TABLA PRODUCTO
		    String createcarrito = "CREATE TABLE CARRITO(" +
		    		"IDCARRITO INTEGER PRIMARY KEY AUTO_INCREMENT," +
		    		");";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createcarrito);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla Carrito creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
}
