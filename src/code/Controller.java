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
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource()==booking.zCountry) {
			try {
				if(booking.sAirport.getSelectedItem().toString()=="--Airport--"){
					booking.addFreshItemComboBox(dbc.getAirports(
							dbc.getCodeCountry(booking.zCountry.getSelectedItem().toString())), 
							booking.zAirport);
				} else {
					
					
					booking.add1FreshItemComboBox(dbc.getAirportFromCode(dbc.getDesAirportCode(
							dbc.getCodeCountry(booking.zCountry.getSelectedItem().toString()),
							dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()),
							dbc.getDesAirportCount(dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString())))), 
							booking.zAirport);
				}
				
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
				if(dbc.getFlightNrAb(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString()), 
						booking.year.getSelectedItem().toString(), 
						booking.month.getSelectedItem().toString(), 
						booking.day.getSelectedItem().toString(), 
						booking.hour.getSelectedItem().toString(), 
						booking.minute.getSelectedItem().toString())!=null){
					
					booking.addFreshItemComboBox(dbc.getFlightNrAb(
							dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
							dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString()), 
							booking.year.getSelectedItem().toString(), 
							booking.month.getSelectedItem().toString(), 
							booking.day.getSelectedItem().toString(), 
							booking.hour.getSelectedItem().toString(), 
							booking.minute.getSelectedItem().toString()), booking.flightnr);
					booking.txtInfo.setText(
							"Airline: "+dbc.getInfoAirline(booking.flightnr.getSelectedItem().toString())
							+"\n Flight Nr:"+booking.flightnr.getSelectedItem().toString()
							+"\n Departure Time: "+dbc.getInfoDepTime(booking.flightnr.getSelectedItem().toString())
							+"\n Departure Airport: "+dbc.getInfoDepAir(booking.flightnr.getSelectedItem().toString())
							+"\n Destination Time: "+dbc.getInfoDesTime(booking.flightnr.getSelectedItem().toString())
							+"\n Destination Airport: "+dbc.getInfoDesAir(booking.flightnr.getSelectedItem().toString())
							+"\n Planetyp: "+dbc.getInfoPlane(booking.flightnr.getSelectedItem().toString())
							);
				} else {
					JOptionPane.showMessageDialog(null, "Kein Flug vorhanden");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()==booking.an){
			try {
				if(dbc.getFlightNrAn(
						dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
						dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString()), 
						booking.year.getSelectedItem().toString(), 
						booking.month.getSelectedItem().toString(), 
						booking.day.getSelectedItem().toString(), 
						booking.hour.getSelectedItem().toString(), 
						booking.minute.getSelectedItem().toString())!=null){
					
					booking.addFreshItemComboBox(dbc.getFlightNrAn(
							dbc.getCodeAirport(booking.sAirport.getSelectedItem().toString()), 
							dbc.getCodeAirport(booking.zAirport.getSelectedItem().toString()), 
							booking.year.getSelectedItem().toString(), 
							booking.month.getSelectedItem().toString(), 
							booking.day.getSelectedItem().toString(), 
							booking.hour.getSelectedItem().toString(), 
							booking.minute.getSelectedItem().toString()), booking.flightnr);
					booking.txtInfo.setText(
							" Airline: "+dbc.getInfoAirline(booking.flightnr.getSelectedItem().toString())
							+"\n Flight Nr:"+booking.flightnr.getSelectedItem().toString()
							+"\n Departure Time: "+dbc.getInfoDepTime(booking.flightnr.getSelectedItem().toString())
							+"\n Departure Airport: "+dbc.getInfoDepAir(booking.flightnr.getSelectedItem().toString())
							+"\n Destination Time: "+dbc.getInfoDesTime(booking.flightnr.getSelectedItem().toString())
							+"\n Destination Airport: "+dbc.getInfoDesAir(booking.flightnr.getSelectedItem().toString())
							+"\n Planetyp: "+dbc.getInfoPlane(booking.flightnr.getSelectedItem().toString())
							);
				} else {
					JOptionPane.showMessageDialog(null, "Kein Flug vorhanden");
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
		if(e.getSource()==booking.submit){
			try {
				System.out.println(dbc.getNextID());
				
				dbc.savePassenger(Integer.toString(dbc.getNextID()),
						booking.txtFname.getText(),
						booking.txtLname.getText(), 
						dbc.getInfoAirline(booking.flightnr.getSelectedItem().toString()), 
						booking.flightnr.getSelectedItem().toString());
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
