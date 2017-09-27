package gui;

import java.awt.*;

import javax.swing.*;

import com.sun.javafx.tk.Toolkit;

import code.Controller;

public class Login extends JFrame {
	
	private Controller main;

	private JFrame frame;
	
	private JPanel centerPanel = new JPanel();
	
	public JTextField txtServer;
	public JTextField txtPort;
	public JTextField txtDatabase;
	public JTextField txtUser;
	public JPasswordField txtPassword;
	
	public JButton connect;
	
	public Login(Controller main) {
		this.main = main;
		initialize();
	}
	
	public void close(){
		this.dispose();
	}
	
	private void initialize() {
		this.setTitle("Login");
		this.setSize(300, 170);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		this.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel cPanel1 = new JPanel();
		JPanel cPanel2 = new JPanel();
		JPanel cPanel3 = new JPanel();
		
		centerPanel.setBorder(BorderFactory.createTitledBorder("Connect to database:"));
		Box vb1 = Box.createVerticalBox();
		Box vb2 = Box.createVerticalBox();
		centerPanel.add(vb1, BorderLayout.NORTH);
		centerPanel.add(vb2, BorderLayout.NORTH);
		
		Box hb1 = Box.createHorizontalBox();
		vb2.add(hb1);
		
		Box hb2 = Box.createHorizontalBox();
		vb1.add(hb2);
		
		Box hb3 = Box.createHorizontalBox();
		vb1.add(hb3);
		
		Box hb4 = Box.createHorizontalBox();
		vb1.add(hb4);
		
		vb1.add(new JLabel("Servername:Port :"));
		txtServer = new JTextField();
		hb1.add(txtServer);
		txtServer.setColumns(5);
		
		hb1.add(new JLabel(" : "));
		txtPort = new JTextField();
		hb1.add(txtPort);
		txtPort.setColumns(5);
		
		vb1.add(new JLabel("Database: "));
		txtDatabase = new JTextField();
		vb2.add(txtDatabase);
		txtDatabase.setColumns(5);
		
		vb1.add(new JLabel("User: "));
		txtUser = new JTextField();
		vb2.add(txtUser);
		txtUser.setColumns(5);
		
		vb1.add(new JLabel("Password: "));
		txtPassword = new JPasswordField();
		vb2.add(txtPassword);
		txtPassword.setColumns(5);
		
		setConnect(new JButton("Connect"));
		centerPanel.add(getConnect());
		getConnect().addActionListener(main);

		this.setVisible(true);
	}

	public JButton getConnect() {
		return connect;
	}

	public void setConnect(JButton connect) {
		this.connect = connect;
	}

}
