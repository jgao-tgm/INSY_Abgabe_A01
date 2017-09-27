package gui;

import java.awt.*;

import javax.swing.*;

import com.sun.javafx.tk.Toolkit;

import code.Controller;

public class Booking extends JFrame {
	
	private Controller main;

	private JFrame frame;
	
	private JPanel northPanel = new JPanel();
	private JPanel centerPanel = new JPanel();
	private JPanel southPanel = new JPanel();
	private JPanel westPanel = new JPanel();
	private JPanel eastPanel = new JPanel();
	
	public JTextField txtLname;
	public JTextField txtFname;
	public JTextArea txtInfo;

	public JComboBox sCountry;
	public JComboBox sAirport;
	public JComboBox zCountry;
	public JComboBox zAirport;
	
	public JButton submit;
	
	public Booking() {
		//this.main = main;
		initialize();
	}
	
	public void close(){
		this.dispose();
	}
	
	private void initialize() {
		this.setTitle("Login");
		this.setSize(700, 300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(new BorderLayout());
		
		this.add(centerPanel, BorderLayout.CENTER);
		this.add(northPanel, BorderLayout.NORTH);
		this.add(southPanel, BorderLayout.SOUTH);
		this.add(westPanel, BorderLayout.WEST);
		this.add(eastPanel, BorderLayout.EAST);
		
		//Flight data
		centerPanel.setBorder(BorderFactory.createTitledBorder("Flight:"));
		Box hbf = Box.createHorizontalBox();
		centerPanel.add(hbf);
		
		Box vbf1 = Box.createVerticalBox();
		hbf.add(vbf1);
		Box vbf2 = Box.createVerticalBox();
		hbf.add(vbf2);
		Box vbf3 = Box.createVerticalBox();
		hbf.add(vbf3);
		
		vbf1.add(new JLabel("Departure: ", SwingConstants.LEFT));
		sCountry = new JComboBox();
		sAirport = new JComboBox();
		vbf2.add(sCountry);
		vbf3.add(sAirport);
		
		vbf1.add(new JLabel("Destination: ", SwingConstants.LEFT));
		zCountry = new JComboBox();
		zAirport = new JComboBox();
		vbf2.add(zCountry);
		vbf3.add(zAirport);
		
		
		
		
		
		//Passenger data
		westPanel.setBorder(BorderFactory.createTitledBorder("Passenger:"));
		Box hbp = Box.createHorizontalBox();
		westPanel.add(hbp);
		
		Box vbp1 = Box.createVerticalBox();
		hbp.add(vbp1);
		Box vbp2 = Box.createVerticalBox();
		hbp.add(vbp2);
		
		vbp1.add(new JLabel("First name: "));
		Component vsp1 = Box.createVerticalStrut(10);
		vbp1.add(vsp1);
		vbp1.add(new JLabel("Last name: "));
		
		txtLname = new JTextField();
		vbp2.add(txtLname);
		txtLname.setColumns(5);
		Component vsp2 = Box.createVerticalStrut(8);
		vbp2.add(vsp2);
		txtFname = new JTextField();
		vbp2.add(txtFname);
		txtFname.setColumns(5);
		
		//Fluginfo
		eastPanel.setBorder(BorderFactory.createTitledBorder("Info:"));
		txtInfo = new JTextArea("details",20,10);
		eastPanel.add(txtInfo);
		
		
		submit = new JButton("Submit");
		southPanel.add(submit);
		

		
		this.setVisible(true);
	}



}
