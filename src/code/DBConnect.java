package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static Connection con;
	
	public void connect(String db, String user, String pw) throws Exception{

	    if(con != null) return;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new Exception("No database");
	    }

	    con = DriverManager.getConnection(
				"jdbc:mysql://localhost/"+db+"?autoReconnect=true&useSSL=false", user, pw); 
	}

	public void close(){
	    if(con != null){
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
