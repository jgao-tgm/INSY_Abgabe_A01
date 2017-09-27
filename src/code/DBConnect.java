package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	
	private static Connection con;
	
	public void connect(String port, String db, String user, String pw) throws Exception{

	    if(con != null) return;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new Exception("No database");
	    }

	    con = DriverManager.getConnection(
				"jdbc:mysql://"+port+"/"+db+"?autoReconnect=true&useSSL=false", user, pw); 
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
	
	public static String[] getAllCountries() throws SQLException{
		String[] count = new String[232];
		int i = 0;

		Statement stmt = con.createStatement();
		String query = "select name from countries;";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			count[i] = res.getString("name");
			i++;
		}
		return count;
		
	}
	
	public static String getCodeCountry(String country) throws SQLException{
		String code = "";
		Statement stmt = con.createStatement();
		String query = "select code from countries where name ='"+country+"';";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			code = res.getString("code");
		}
		return code;
	}
	
	public static String[] getAirports(String country) throws SQLException{
		String[] aport = new String[100];
		int i = 0;

		Statement stmt = con.createStatement();
		String query = "select name from airports where country='"+country+"';";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			aport[i] = res.getString("name");
			i++;
		}
		return aport;
		
	}
}
