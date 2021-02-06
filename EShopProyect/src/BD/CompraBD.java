package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CompraBD {
	protected static void CrearTablaCarrito(Connection con) {
		// TODO Auto-generated method stub
	    PreparedStatement preparedStatement = null;
	    //TABLA PRODUCTO
	    String createcarrito = "CREATE TABLE COMPRA(" +
	    		"IDCARRITO INTEGER," +
	    		"IDCOMPRA INTEGER, "+
	    		"NICKNAME VARCHAR(50),"+
	    		"NOMBRE VARCHAR(50),"+
	    		"CODIGOACCESO VARCHAR(20),"+
	    		"PRECIO DOUBLE,"
	    		+ "PRIMARY KEY(IDCARRITO,IDCOMPRA));";
	    try {
	    	
	    preparedStatement = con.prepareStatement(createcarrito);
        preparedStatement.executeUpdate();

        System.out.println("Tabla COMPRA creada correctamente.");
			
		} catch (Exception e) {
			System.err.println("Error al crear la tabla" +e+ "");
		}
}
//ELIMINAR TABLA
	 protected static void EliminarTablaCarrito(Connection con) {
		 
	     PreparedStatement preparedStatement = null;
		 
		 String EliminarCarrito= "DROP TABLE IF EXISTS COMPRA";
		 try {
			 preparedStatement = con.prepareStatement(EliminarCarrito);
	         preparedStatement.executeUpdate();

	            System.out.println("Tabla COMPRA eliminada correctamente.");

		} catch (Exception e) {
				System.err.println("Tabla COMPRA no ha podido eliminarse : "+e);
		}
	 }

}
