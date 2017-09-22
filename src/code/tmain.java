package code;

import javax.swing.JOptionPane;

public class tmain {
	private static DBConnect dbc;
	
	public static void main(String[] args) throws Exception {
    	dbc = new DBConnect();
    	try {
    		String db = JOptionPane.showInputDialog(null, "Name of database");
    		String user = JOptionPane.showInputDialog(null, "User");
    		String pw = JOptionPane.showInputDialog(null, "Password");
    		dbc.connect(db,user,pw);
    		JOptionPane.showMessageDialog(null, "Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
