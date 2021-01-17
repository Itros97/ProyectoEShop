 package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Producto.Producto;
import Usuario.Usuario;

public class LLamadasBD
{
	//Llamadas de la base de datos y todos sus metodos
	//REINICIO DE LA BD PARA EVITAR PROBLEMAS 
	public void ReiniciarBasesDeDatos(String codSeguridad) {

        if (codSeguridad.equals("Admin")) {
            //EJECUTAR EL REINICIO DE TODOS LOS DATOS
            Connection con = Conexion();
            BorrarBasesDeDatos(con);
            CrearBasesDeDatos(con);
            //   InsertarBasesDeDatos(con);

        } else {
            System.out.println("El código no es el correcto");
            
        }
        
	}
	
	//CODIGO PARA LA CONEXION CON LA BASE DE DATOS
	 public static Connection Conexion() {
		 
	        Connection con = null;

	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            //Conexion con la BD de XAMPP(EN MI CASO USO EL PUERTO 3307 EN VEZ DEL 3306 YA QUE NO ME DEJA ACCEDER A ESTE PRIMERO)
	            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tiendaonline", "root", "");

	        } catch (Exception e) {
	            System.err.println("No se ha podido conectar a la base de datos de la tienda\n" + e.getMessage());
	        }

	        return con;
	    }
	 //CREACION DE LA BASE DE DATOS
	 private void CrearBasesDeDatos(Connection con) {
		 UsuarioBD.CrearTablaUsuario(con);
		 ProductoBD.CrearTablaProducto(con);
		 CarritoBD.CrearTablaCarrito(con);
		 CodigosBD.CrearTablaCodigos(con);
		}

	 //ELIMINACION DE LA BASE DE DATOS
	 private void BorrarBasesDeDatos(Connection con) {
		 UsuarioBD.EliminarTablaUsuario(con);
		 ProductoBD.EliminarTablaProducto(con);
		 CarritoBD.EliminarTablaCarrito(con);
		 CodigosBD.EliminarTablaCodigo(con);
	 	}
	 
	 //INSERT USUARIOS
	 public void InsertarUsuario(Usuario nuevoUsuario) {
		 UsuarioBD.InsertarUsuarios(nuevoUsuario);

	    }
	  //MODIFICAR USUARIOS
	  public void ModificarUsuario(Usuario usuario) {
		  UsuarioBD.ModificarUsuario(usuario);
	      }
	  //INSERT PRODUCTOS
	  public void InsertarProducto(Producto nuevoProducto) {
      ProductoBD.InsertarProducto(nuevoProducto);
		    
	}
	 //COMPROBAR LOGIN
    // public boolean LoginUsuarios(String nickname, String password) {
   //  return UsuarioBD.LoginUsuario(nickname, password);
		    //}
	}
