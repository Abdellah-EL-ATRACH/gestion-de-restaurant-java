package dbconnection;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class connecttodb {

	public static Connection connect() {
		try {
		String  user = "abdellah";
		String pass= "elatrach";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection("jdbc:oracle:thin:@(DESCRIPTION =(ADDRESS = (PROTOCOL = TCP)(HOST = localhost)(PORT = 1521))(CONNECT_DATA =(SERVER = DEDICATED)(SERVICE_NAME = orclpdb)))",user,pass);
		return con;
		}catch( ClassNotFoundException| SQLException se) 
			{
			Logger.getLogger(connecttodb.class.getName()).log(Level.SEVERE,null,se);
			se.printStackTrace();
			}
		return null;

}
}
