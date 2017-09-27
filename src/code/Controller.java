package code;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==login.connect) {
			setServername(login.txtServer.getText());
			setDatabase(login.txtDatabase.getText());
			setUser(login.txtUser.getText());
			setPassword(login.txtPassword.getText());
			
			try {

	    		dbc.connect(getServername(),getDatabase(),getUser(),getPassword());
	    		JOptionPane.showMessageDialog(null, "Connected");
	    		login.close();
	    		//booking = new Booking(this);
	    		
	        } catch (Exception ex) {
	            ex.printStackTrace();
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
