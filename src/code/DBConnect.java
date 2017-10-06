package code;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {
	
	private static Connection con;
	
	public void connect(String host, String port, String db, String user, String pw) throws Exception{

	    if(con != null) return;

	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	    } catch (ClassNotFoundException e) {
	        throw new Exception("No database");
	    }

	    con = DriverManager.getConnection(
				"jdbc:mysql://"+host+":"+port+"/"+db+"?autoReconnect=true&useSSL=false", user, pw); 
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
	public static int getDesAirportCount(String depAir) throws SQLException{
		int cdc = 0;
		Statement stmt1 = con.createStatement();
		String query1 = "select count(destination_airport) from flights where departure_airport='"+depAir+"';";
		ResultSet res1 = stmt1.executeQuery(query1);
		if (res1.next()) {
			cdc = res1.getInt("count(destination_airport)");
			
		}
		return cdc;
		
	}
	
	public static String getDesAirportCode(String country, String depAir, int count) throws SQLException{

		String desport = "";
		int i = 0;

		Statement stmt2 = con.createStatement();
		String query2 = "select destination_airport from flights,airports where departure_airport='"+depAir+"'"
				+ "and flights.destination_airport=airports.airportcode and airports.country='"+country+"';";
		ResultSet res2 = stmt2.executeQuery(query2);
		while (res2.next()) {
			desport = res2.getString("destination_airport");

		}
		
		return desport;
	}
	
	public static String[] getDesCountryCode(String depAir) throws SQLException{
		int c =  0;
		
		Statement stmt1 = con.createStatement();
		String query1 = "select count(country) from flights,airports where departure_airport='"+depAir+"'"
				+ "and flights.departure_airport=airports.airportcode;";
		ResultSet res1 = stmt1.executeQuery(query1);
		while (res1.next()) {
			c = res1.getInt("count(country)");

		}
		String[] desco = new String[c];
		int i = 0;

		Statement stmt2 = con.createStatement();
		String query2 = "select country from flights,airports where departure_airport='"+depAir+"'"
				+ "and flights.departure_airport=airports.airportcode;";
		ResultSet res2 = stmt2.executeQuery(query2);
		while (res2.next()) {
			desco[i] = res2.getString("country");
			System.out.println(desco[i]);
			i++;
		
		}
		
		return desco;
	}
	
	public static String getAirportFromCode(String aircode) throws SQLException{
		String name = "";
		int i = 0;
		Statement stmt = con.createStatement();
		String query = "select name from airports where airportcode ='"+aircode+"';";
		ResultSet res = stmt.executeQuery(query);
		while (res.next()) {
			name = res.getString("name");
		}
		return name;
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
	
	public static String getInfoAirline(String flightnr) throws SQLException{
		String info = "";
		
		Statement stmt = con.createStatement();
		String query = "select airline from flights where flightnr='"+flightnr+"';";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			info = res.getString("airline");
		}
		return info;
		
	}
	
	
	public static String getInfoDepTime(String flightnr) throws SQLException{
		String info = "";
		
		Statement stmt = con.createStatement();
		String query = "select departure_time from flights where flightnr='"+flightnr+"';";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			info = res.getString("departure_time");
		}
		return info;
		
	}
	
	public static String getInfoDepAir(String flightnr) throws SQLException{
		String info = "";
		
		Statement stmt = con.createStatement();
		String query = "select departure_airport from flights where flightnr='"+flightnr+"';";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			info = res.getString("departure_airport");
		}
		return info;
		
	}
	
	public static String getInfoDesTime(String flightnr) throws SQLException{
		String info = "";
		
		Statement stmt = con.createStatement();
		String query = "select destination_time from flights where flightnr='"+flightnr+"';";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			info = res.getString("destination_time");
		}
		return info;
		
	}
	
	public static String getInfoDesAir(String flightnr) throws SQLException{
		String info = "";
		
		Statement stmt = con.createStatement();
		String query = "select destination_airport from flights where flightnr='"+flightnr+"';";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			info = res.getString("destination_airport");
		}
		return info;
		
	}
	
	public static String getInfoPlane(String flightnr) throws SQLException{
		String info = "";
		
		Statement stmt = con.createStatement();
		String query = "select planetype from flights where flightnr='"+flightnr+"';";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			info = res.getString("planetype");
		}
		return info;
		
	}
	
	public int getNextID() throws SQLException{
		int id = 0;
		
		Statement stmt = con.createStatement();
		String query = "select max(id) from passengers;";
		ResultSet res = stmt.executeQuery(query);
		if(res.next()) {
			id = res.getInt("max(id)")+1;
		}
		return id;
	}
	
	public static void savePassenger(String id, String fname, String lname, String air, String flightnr) throws SQLException{
		Statement stmt = con.createStatement();
		String insert = "insert into passengers (`id`,`firstname`,`lastname`,`airline`,`flightnr`)"
				+ "values ("
				+ "'"+id+"',"
						+ "'"+fname+"',"
								+ "'"+lname+"',"
										+ "'"+air+"',"
												+ "'"+flightnr+"');";
		
		
		stmt.executeUpdate(insert);
		
		System.out.println("Insert complete");
	}
	
	
}
