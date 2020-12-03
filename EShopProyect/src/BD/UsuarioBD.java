package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
	            String query = " INSERT INTO USUARIO (NICKNAME,PASSWORD,CORREOELECTRONICO,FECHADENACIMIENTO,CALLE,TARJETA_CREDITO,TIPO_CUENTA)"
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
	//COMPROBAR LOGIN
	   public boolean LoginUsuario(String nickName, String password) {

	        boolean comprobar = false;
	        try {
	        	PreparedStatement preparedStatement;
	        	Connection con = LLamadasBD.Conexion();

	            String query = "SELECT PASSWORD FROM USUARIOS WHERE NICKNAME = '" + nickName + "'";

	            Statement statement = con.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	               
	                if (resultSet.getString("PASSWORD").equals(password)) {
	                    System.out.println("Si");
	                    comprobar = true;
	                    break;
	                } else {
	                    System.out.println("Contrasenya Incorrecta");
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }
	        if (comprobar == true) {
	            System.out.println("Existe y la contraseña concuerda,permitir el logeo");
	        }
	        return comprobar;
	    }
	 //LEER DATOS DE USUARIO CONCRETO(Solo posible si es admin su modificacion)
	 //ELIMINAR USUARAIO
	 public void EliminarUsuario(String nickname) {
	     
	        PreparedStatement preparedStatement= null;
	   	 	Connection con = LLamadasBD.Conexion();

	        try {

	            String query = "DELETE FROM USUARIO WHERE NICKNAME = '" + nickname + "'";

	            preparedStatement = con.prepareStatement(query);

	            preparedStatement.execute();
	            preparedStatement.close();

	        } catch (SQLException e) {

	            System.out.println("No se pudo eliminar el usuario");
	            System.out.println(e);
	        }

	    }
	 //MODIFICAR USUARIO
	    protected static void ModificarUsuario(Usuario usuario) {
	        Connection con = LLamadasBD.Conexion();
	        PreparedStatement preparedStatement = null;
	        try {
	            String query = "UPDATE USUARIO" +
	                    "SET PASSWORD = '" + usuario.getPassword() + "'" +
	                    " WHERE NICKNAME = '" +  usuario.getNickname() + "'";

	            preparedStatement = con.prepareStatement(query);

	            preparedStatement.executeUpdate();
	            preparedStatement.close();

	        } catch (Exception e) {
	            System.err.println("A ocurrido un ERROR modificando los datos, intentelo mas tarde o contacte con el servicio técnico.");
	            System.out.println(e);
	            e.getMessage();
	        }

	    }
	 
}
