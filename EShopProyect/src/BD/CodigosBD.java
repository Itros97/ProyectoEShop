package BD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class CodigosBD {
	//CREAR
		 protected static void CrearTablaCodigos(Connection con) {
				// TODO Auto-generated method stub
			    PreparedStatement preparedStatement = null;
			    
			    //TABLA CODIGOS
			    String createUsuario = "CREATE TABLE CODIGOS(" +
			    		"CODIGO VARCHAR(50) PRIMARY KEY  NOT NULL);";
			    try {
			    	
			    preparedStatement = con.prepareStatement(createUsuario);
		        preparedStatement.executeUpdate();

		        System.out.println("Tabla CODIGO creada correctamente.");
					
				} catch (Exception e) {
					System.err.println("Error al crear la tabla" +e+ "");
				}
	}
		 //ELIMINAR TABLA
		 protected static void EliminarTablaCodigo(Connection con) {
			 
		     PreparedStatement preparedStatement = null;
			 
			 String EliminarCodigo= "DROP TABLE IF EXISTS CODIGO";
			 try {
				 preparedStatement = con.prepareStatement(EliminarCodigo);
		         preparedStatement.executeUpdate();

		            System.out.println("Tabla CODIGO eliminada correctamente.");

			} catch (Exception e) {
					System.err.println("Tabla CODIGO no ha podido crearse : "+e);
			}
		 }

}
