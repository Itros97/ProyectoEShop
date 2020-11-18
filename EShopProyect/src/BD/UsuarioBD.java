package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UsuarioBD {

	//CREAR
	 protected static void CrearTablaUsuario(Connection con) {
			// TODO Auto-generated method stub
		    PreparedStatement preparedStatement = null;
		    
		    //TABLA USUARIO
		    String createUsuario = "CREATE TABLE USUARIO(" +
		    		"NICKNAME VARCHAR(50) PRIMARY KEY NOT NULL," +
		    		"PASSWORD VARCHAR(50) NOT NULL," +
		    		"EMAIL VARCHAR(50) NOT NULL," +
		    		"CALLE VARCHAR(250)," +
		    		"TARJETA_CREDITO INT," +
		    		"TIPO_CUENTA BOOLEAN);";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createUsuario);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla USUARIOS creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
	 //ELIMINAR
	 protected static void EliminarTablaUsuario(Connection con) {
		 
	     PreparedStatement preparedStatement = null;
		 
		 String EliminarUsuario= "DROP TABLE IF EXISTS USUARIOS";
		 try {
			 preparedStatement = con.prepareStatement(EliminarUsuario);
	         preparedStatement.executeUpdate();

	            System.out.println("Tabla USUARIO eliminada correctamente.");

		} catch (Exception e) {
				System.err.println("Tabla usuario no ha podido crearse : "+e);
		}
	 }
}
