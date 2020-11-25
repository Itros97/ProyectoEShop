package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Usuario.Usuario;

public class UsuarioBD {

	//CREAR
	 protected static void CrearTablaUsuario(Connection con) {
			// TODO Auto-generated method stub
		    PreparedStatement preparedStatement = null;
		    
		    //TABLA USUARIO
		    String createUsuario = "CREATE TABLE USUARIO(" +
		    		"IDUSUARIO INTEGER AUTO_INCREMENT PRIMARY KEY,"+
		    		"NICKNAME VARCHAR(50)  NOT NULL," +
		    		"PASSWORD VARCHAR(50) NOT NULL," +
		    		"CORREOELECTRONICO VARCHAR(50) NOT NULL," +
		    		"FECHADENACIMIENTO INTEGER,"+
		    		"CALLE VARCHAR(250)," +
		    		"TARJETA_CREDITO INT," +
		    		"TIPO_CUENTA BOOLEAN);";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createUsuario);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla USUARIO creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
	 //ELIMINAR
	 protected static void EliminarTablaUsuario(Connection con) {
		 
	     PreparedStatement preparedStatement = null;
		 
		 String EliminarUsuario= "DROP TABLE IF EXISTS USUARIO";
		 try {
			 preparedStatement = con.prepareStatement(EliminarUsuario);
	         preparedStatement.executeUpdate();

	            System.out.println("Tabla USUARIO eliminada correctamente.");

		} catch (Exception e) {
				System.err.println("Tabla usuario no ha podido crearse : "+e);
		}
	 }
	 //INSERT USUARIOS
	 
	 protected static void InsertarUsuarios(Usuario nuevoUsuario) 
	 {
		 PreparedStatement preparedStatement = null;
		 Connection con = LLamadasBD.Conexion();
	        try {
	            String query = " INSERT INTO PERSONAJES (NICKNAME,PASSWORD,CORREOELECTRONICO,FECHADENACIMIENTO,CALLE,TARJETA_CREDITO,TIPO_CUEJNTA)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?)";

	            preparedStatement = con.prepareStatement(query);


	            preparedStatement.setString(1, nuevoUsuario.getNickname());
	            preparedStatement.setString(2, nuevoUsuario.getPassword());
	            preparedStatement.setString(3, nuevoUsuario.getCorreoElectronico());
	            preparedStatement.setInt(4, nuevoUsuario.getFechaNacimiento());
	            preparedStatement.setString(5, nuevoUsuario.getCalle());
	            preparedStatement.setString(6, nuevoUsuario.getTarjeta_credito());
	            preparedStatement.setBoolean(7, nuevoUsuario.isTipo_cuenta());
	            preparedStatement.execute();

	            System.out.println("Operación existosa");

	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }
	 }
}
