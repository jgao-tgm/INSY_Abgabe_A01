package code;
 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

import gui.Booking;
import gui.Login;

public class Controller implements ActionListener{
	private static DBConnect dbc;
	private static Login login;
	private Booking booking;
	
	private static String servername;
	private String port;
	private static String database;
	private static String user;
	private static String password;
	
	public Controller() throws Exception {
		this.login = new Login(this); 
		
	}
	
	public static void main(String[] args) throws Exception {
    	dbc = new DBConnect();
    	new Controller();
  
    }

	@SuppressWarnings("deprecation")
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.connect) {
			setServername(login.txtServer.getText());
			setDatabase(login.txtDatabase.getText());
			setUser(login.txtUser.getText());
			setPassword(login.txtPassword.getText());
			
			try {

	    		//dbc.connect(getServername(),getDatabase(),getUser(),getPassword());
				dbc.connect("localhost","flightdata","root","Aed4ahni");
	    		JOptionPane.showMessageDialog(null, "Connected");
	    		login.close();
	    		
	    		booking = new Booking(this);
	    		//bm = new BookingModel();
	    		booking.addItemComboBox(dbc.getAllCountries(), booking.sCountry);
	    		booking.addItemComboBox(dbc.getAllCountries(), booking.zCountry);
	    		
	    		
	        } catch (Exception ex) {
	        	JOptionPane.showMessageDialog(null, "Connection failed");
	            ex.printStackTrace();
	        }
		}
		
		if(e.getSource()==booking.sCountry) {
			try {
				booking.addFreshItemComboBox(dbc.getAirports(
						dbc.getCodeCountry(booking.sCountry.getSelectedItem().toString())), 
						booking.sAirport);
				booking.addFreshItemComboBox(dbc.getAllFlightNr(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString())), 
						booking.flightnr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==booking.zCountry) {
			System.out.print("Actzjv");
			try {
				booking.addFreshItemComboBox(dbc.getAirports(
						dbc.getCodeCountry(booking.zCountry.getSelectedItem().toString())), 
						booking.zAirport);
				booking.addFreshItemComboBox(dbc.getAllFlightNr(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString())), 
						booking.flightnr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==booking.sAirport){
			try {
				System.out.println(dbc.getAllFlightNr(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString())
						).toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==booking.zAirport){
			try {
				System.out.println(dbc.getAllFlightNr(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString())
						).toString());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		if(e.getSource()==booking.month){
			booking.addDaysMonth((int)booking.month.getSelectedItem(), 
					(int)booking.month.getSelectedItem(), booking.day);
		}
		if(e.getSource()==booking.ab){
			try {
				booking.addFreshItemComboBox(dbc.getFlightNrAb(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString()), 
						booking.year.getSelectedItem().toString(), 
						booking.month.getSelectedItem().toString(), 
						booking.day.getSelectedItem().toString(), 
						booking.hour.getSelectedItem().toString(), 
						booking.minute.getSelectedItem().toString()), booking.flightnr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()==booking.an){
			try {
				booking.addFreshItemComboBox(dbc.getFlightNrAn(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString()), 
						booking.year.getSelectedItem().toString(), 
						booking.month.getSelectedItem().toString(), 
						booking.day.getSelectedItem().toString(), 
						booking.hour.getSelectedItem().toString(), 
						booking.minute.getSelectedItem().toString()), booking.flightnr);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}

	public String getServername() {
		return servername;
	}
	public void setServername(String servername) {
		this.servername = servername;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getDatabase() {
		return database;
	}
	public void setDatabase(String database) {
		this.database = database;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
