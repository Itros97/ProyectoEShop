package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Usuario.Usuario;

public class LLamadasBD 
{
	//Llamadas de la base de datos y todos sus metodos
	//REINICIO DE LA BD PARA EVITAR PROBLEMAS
	public void ReiniciarBasesDeDatos(String codSeguridad) {

        if (codSeguridad.equals("Admin")) {
            //EJECUTAR EL REINICIO DE TODOS LOS DATOS
            Connection con = Conexion();
         //   BorrarBasesDeDatos(con);
            CrearBasesDeDatos(con);
            //   InsertarBasesDeDatos(con);

        } else {
            System.out.println("El código no es el correcto");
        }
	}
	
	//CODIGO PARA LA CONEXION CON LA BASE DE DATOS
	 private static Connection Conexion() {
	        Connection con = null;

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            //Conexion con la BD de XAMPP
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaonline", "root", "");

	        } catch (Exception e) {
	            System.err.println("No se ha podido conectar a la base de datos de la tienda\n" + e.getMessage());
	        }

	        return con;
	    }
	 //CREACION DE LA BASE DE DATOS
	 private void CrearBasesDeDatos(Connection con) {
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

	 //ELIMINACION DE LA BASE DE DATOS
	 private void BorrarBasesDeDatos(Connection con) {
			// TODO Auto-generated method stub
		 PreparedStatement preparedStatement = null;
		 
		 String borrarUsuarios = "DROP TABLE IF EXISTS USUARIOS";
		 try {
			 //DEBE EFECTUARSE AL REVES DE COMO SE CREAN PARA EVITAR PROBLEMAS DE RELACION
			 preparedStatement = con.prepareStatement(borrarUsuarios);
	         preparedStatement.executeUpdate();

	         System.out.println("Tabla USUARIOS eliminada correctamente.");
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Error al eliminarP la tabla" +e+ "");
		}
		}
	 
	   //INSERT USUARIOS
	    public void InsertarUsuario(Usuario nuevoUsuario) {
	        PreparedStatement preparedStatement;
	        Connection con = Conexion();

	        try {

	            String query = " INSERT INTO USUARIOS (NICKNAME,PASSWORD, EMAIL, CALLE, TARJETA_CREDITO, TIPO_CUENTA)"
	                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

	            preparedStatement = con.prepareStatement(query);

	            preparedStatement.setString(1, nuevoUsuario.getNickname());
	            preparedStatement.setString(2, nuevoUsuario.getPassword());
	            //Metodo por si queremos encriptar la contraseña
	            //String password = nuevoUsuario.getPassword();
	            //String encriptMD5 = DigestUtils.md5Hex(password);
	            //preparedStatement.setString(2	, encriptMD5);
	            preparedStatement.setString(3, nuevoUsuario.getCorreoElectronico());
	            preparedStatement.setString(4, nuevoUsuario.getCalle());
	            preparedStatement.setInt(5, nuevoUsuario.getTarjeta_credito());
	           
	            preparedStatement.execute();

	            System.out.println("Operación existosa");

	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }

	    }
	    

}
