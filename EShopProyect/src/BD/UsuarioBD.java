package BD;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;

import GUI.VMain;
import GUI.VentanaTienda;
import Tienda.Tienda;
import Usuario.Usuario;

import Usuario.Usuario;

public class UsuarioBD {

	
	public static String nickg;
	public static boolean esadmin;
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
		    		"CALLE VARCHAR(250)," +
		    		"TARJETA_CREDITO VARCHAR(50)," +
		    		"TIPO_CUENTA BOOLEAN);";
		    try {
		    	
		    preparedStatement = con.prepareStatement(createUsuario);
	        preparedStatement.executeUpdate();

	        System.out.println("Tabla USUARIO creada correctamente.");
				
			} catch (Exception e) {
				System.err.println("Error al crear la tabla" +e+ "");
			}
}
	 //ELIMINAR TABLA
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
	 
	 public static void InsertarUsuarios(Usuario nuevoUsuario) 
	 {
		 PreparedStatement preparedStatement = null;
		 Connection con = LLamadasBD.Conexion();
	        try {
	            String query = " INSERT INTO USUARIO (NICKNAME,PASSWORD,CORREOELECTRONICO,CALLE,TARJETA_CREDITO,TIPO_CUENTA)"
	                    + " VALUES (?, ?, ?, ?, ?, ?)";

	            preparedStatement = con.prepareStatement(query);


	            preparedStatement.setString(1, nuevoUsuario.getNickname());
	            preparedStatement.setString(2, nuevoUsuario.getPassword());
	            preparedStatement.setString(3, nuevoUsuario.getCorreoElectronico());
	            preparedStatement.setString(4, nuevoUsuario.getCalle());
	            preparedStatement.setString(5, nuevoUsuario.getTarjeta_credito());
	            preparedStatement.setBoolean(6, nuevoUsuario.isTipo_cuenta());
	            preparedStatement.execute();

	            System.out.println("Operación existosa");

	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }
	 }
	 //Obtener usuario logeado
	    public static Usuario getUsuario(String nickname) 
	    {
	    Usuario user = new Usuario();
	     PreparedStatement preparedStatement= null;
		 Connection con = LLamadasBD.Conexion();
		 try {
			 String query = "SELECT NICKNAME,PASSWORD,TIPO_CUENTA FROM USUARIO WHERE NICKNAME = '" + nickname + "'";
			 Statement statement = con.createStatement();
	         ResultSet resultSet = statement.executeQuery(query);
	         while(resultSet.next()) 
	         {
	        	 if(resultSet.getString("NICKNAME").equals(nickname)) 
	        	 {
	        		user.setNickname(nickname);
	        		user.setPassword(resultSet.getString("PASSWORD"));
	        		user.setTipo_cuenta(resultSet.getBoolean("TIPO_CUENTA"));
	        	 }
	        	 else 
	        	 {
	        		 System.err.println("No hay usuario asi");
	        	 }
	         }
		} catch (Exception e) {
			// TODO: handle exception
		}
		 System.out.println(user.getNickname());
		 System.out.println(user.getPassword());
		 System.out.println(user.isTipo_cuenta());
		return user;
	    }
	
	 //COMPROBAR LOGIN

	 //LEER DATOS DE USUARIO CONCRETO(Solo posible si es admin su modificacion)
	 
	   public static boolean LoginUsuario(String nickName, String password, Usuario usuario) {
		      
		   boolean comprobar = false;
	  
	        try {
	        	PreparedStatement preparedStatement;
	        	Connection con = LLamadasBD.Conexion();

	            String query = "SELECT PASSWORD FROM USUARIO WHERE NICKNAME = '" + nickName + "'";

	            Statement statement = con.createStatement();
	            ResultSet resultSet = statement.executeQuery(query);

	            while (resultSet.next()) {
	               
	                if (resultSet.getString("PASSWORD").equals(password)) {
	                    System.out.println("Si");
	                    if(getUsuario(nickName).isTipo_cuenta() == true)
	                    {
	                    	//Tengo que hacer el enable del boton Administrar
	                    	System.out.println("Es Admin");
	                    	nickg = getUsuario(nickName).getNickname();
	                    	esadmin = getUsuario(nickName).isTipo_cuenta();
	                    	System.out.println(esadmin);
	                    }
	                    else {
	                    	System.out.println("No es admin");
	                    	nickg = getUsuario(nickName).getNickname();
	                    	esadmin = getUsuario(nickName).isTipo_cuenta();
	                    }
	                    comprobar = true;
	                    break;
	                } else {
	                    System.out.println("Contrasenya Incorrecta");
	                    JOptionPane.showMessageDialog(null, "EMAIL O CONTRASENYA INCORRECTAS");
	                }
	            }
	        } catch (Exception e) {
	            System.out.println("A ocurrido un ERROR");
	            System.out.println(e);
	        }
	        if (comprobar == true) {
	            System.out.println("Existe y la contraseña concuerda,permitir el logeo");
	            VMain window = new VMain(usuario);
	            window.ventanaMain.setVisible(true);
	            
			
	        }
	        //Unicamente para ver que esto es cierto
	        return comprobar;
	    }
	   
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
