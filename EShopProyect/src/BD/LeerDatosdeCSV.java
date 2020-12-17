package BD;
import java.io.*;
import java.sql.*;
 
public class LeerDatosdeCSV {

	 
	    public  void insertardatos(Connection con,String query) throws IOException, ClassNotFoundException, SQLException {
	    
	    	try {
				BufferedReader bReader = new BufferedReader(new FileReader("datos.csv"));
				String line ="";
				while ((line = bReader.readLine()) != null) {
					try {
						  if (line != null) 
			                {
			                    String[] array = line.split(";+");
			                    for(String result:array)
			                    {
			                        System.out.println(result);
			                    }
			                    PreparedStatement ps= con.prepareStatement(query);
			                    ps.setString(1,array[0]);
			                    ps.setString(2,array[1]);
			                    ps.setString(3,array[2]);
			                    ps.executeUpdate();
			                    ps. close();
			                }
					 }
			            finally
			            {
			               if (bReader == null) 
			                {
			                    bReader.close();
			                }
			            }
			        }
			    } catch (FileNotFoundException ex) {
			        ex.printStackTrace();
			    }
	    }
	}

