import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Search extends Home {
 


	
	public static   Connection connect(){
		try {
			String connectString = "jdbc:mysql://localhost/DPS_Project";
			
			Connection conn = DriverManager.getConnection(connectString,"root","");
			return conn;
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
	
}
