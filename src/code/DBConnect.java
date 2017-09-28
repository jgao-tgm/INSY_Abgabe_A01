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
		int c = 0;
		
		Statement stmt1 = con.createStatement();
		String query1 = "select count(name) from airports where country='"+country+"';";
		ResultSet res1 = stmt1.executeQuery(query1);
		while (res1.next()) {
			c = res1.getInt("count(name)");
		}
		
		String[] aport = new String[c];
		int i = 0;

		Statement stmt2 = con.createStatement();
		String query2 = "select name from airports where country='"+country+"';";
		ResultSet res2 = stmt2.executeQuery(query2);
		while (res2.next()) {
			aport[i] = res2.getString("name");
			i++;
		}
		return aport;
		
	}
	
	public static String getCodeAirport(String airport) throws SQLException{
		String code = "";
		Statement stmt = con.createStatement();
		String query = "select airportcode from airports where name ='"+airport+"';";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			code = res.getString("airportcode");
		}
		return code;
	}
	 
	public static String[] getFlightNrAb(String depair, String desair, 
			String year, String month, String day, 
			String hour, String minute) throws SQLException{
		int c = 0;
		
		Statement stmt1 = con.createStatement();
		String query1 = "select count(flightnr) from flights where "
				+ "departure_time>'"+year+"-"+month+"-"+day+" "+hour+":"+minute+"' "
						+ "and departure_airport='"+depair+"' and destination_airport='"+desair+"';";
		ResultSet res1 = stmt1.executeQuery(query1);
		while (res1.next()) {
			c = res1.getInt("count(flightnr)");
		}
		String[] fnr = new String[c];
		int i = 0;

		Statement stmt2 = con.createStatement();
		String query2 = "select flightnr from flights where "
				+ "departure_time>'"+year+"-"+month+"-"+day+" "+hour+":"+minute+"' "
						+ "and departure_airport='"+depair+"' and destination_airport='"+desair+"';";
		ResultSet res2 = stmt2.executeQuery(query2);
		while (res2.next()) {
			fnr[i] = res2.getString("flightnr");
			i++;
		}
		return fnr;
		
	}
	
	public static String[] getFlightNrAn(String depair, String desair, 
			String year, String month, String day, 
			String hour, String minute) throws SQLException{
		int c = 0;
		
		Statement stmt1 = con.createStatement();
		String query1 = "select count(flightnr) from flights where "
				+ "departure_time<'"+year+"-"+month+"-"+day+" "+hour+":"+minute+"' "
						+ "and departure_airport='"+depair+"' and destination_airport='"+desair+"';";
		ResultSet res1 = stmt1.executeQuery(query1);
		while (res1.next()) {
			c = res1.getInt("count(flightnr)");
		}
		String[] fnr = new String[c];
		int i = 0;

		Statement stmt2 = con.createStatement();
		String query2 = "select flightnr from flights where "
				+ "departure_time<'"+year+"-"+month+"-"+day+" "+hour+":"+minute+"' "
						+ "and departure_airport='"+depair+"' and destination_airport='"+desair+"';";
		ResultSet res2 = stmt2.executeQuery(query2);
		while (res2.next()) {
			fnr[i] = res2.getString("flightnr");
			i++;
		}
		return fnr;
		
	}
	
	public static String[] getAllFlightNr(String depair, String desair) throws SQLException{
		int c = 0;
		
		Statement stmt1 = con.createStatement();
		String query1 = "select count(flightnr) from flights where "
						+ "departure_airport='"+depair+"' and destination_airport='"+desair+"';";
		ResultSet res1 = stmt1.executeQuery(query1);
		while (res1.next()) {
			c = res1.getInt("count(flightnr)");
		}
		String[] fnr = new String[c];
		int i = 0;

		Statement stmt2 = con.createStatement();
		String query2 = "select flightnr from flights where "
						+ "departure_airport='"+depair+"' and destination_airport='"+desair+"';";
		ResultSet res2 = stmt2.executeQuery(query2);
		while (res2.next()) {
			fnr[i] = res2.getString("flightnr");
			i++;
		}
		return fnr;
		
	}
	
	
}
