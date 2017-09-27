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
	
	public JComboBox hour;
	public JComboBox minute;
	
	public JComboBox flightnr;
	public JComboBox row;
	public JComboBox seat;

	public JComboBox sCountry;
	public JComboBox sAirport;
	public JComboBox zCountry;
	public JComboBox zAirport;
	
	public JRadioButton an;
	public JRadioButton ab;
	
	public JButton submit;
	
	
	public Booking(Controller main) {
		this.main = main;
		initialize();
	}
	
	public void close(){
		this.dispose();
	}
	
	public void addItemComboBox(String[] string, JComboBox cbox){
		int c = string.length;
		
		for(int i = 0; i < c; i++){
			cbox.addItem(string[i]);
		}
	}

	
	private void initialize() {
		this.setTitle("Booking");
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
		centerPanel.setLayout(new GridLayout(2,3));
		
		Box vbf1 = Box.createVerticalBox();
		centerPanel.add(vbf1);
		Box hbf1 = Box.createHorizontalBox();
		vbf1.add(hbf1);
		Box hbf2 = Box.createHorizontalBox();
		vbf1.add(hbf2);
		Box hbf3 = Box.createHorizontalBox();
		vbf1.add(hbf3);
		Box hbf4 = Box.createHorizontalBox();
		vbf1.add(hbf4);
		Box hbf5 = Box.createHorizontalBox();
		vbf1.add(hbf5);
		
		Component vsf1 = Box.createVerticalStrut(15);
		hbf1.add(vsf1);
		
		hbf2.add(new JLabel("Departure: "));
		sCountry = new JComboBox();
		sCountry.setSize(1,5);
		sAirport = new JComboBox();
		sAirport.setSize(1,5);
		hbf2.add(sCountry);
		Component hsf1 = Box.createHorizontalStrut(5);
		hbf2.add(hsf1);
		hbf2.add(sAirport);

		Component vsf2 = Box.createVerticalStrut(15);
		hbf3.add(vsf2);
		
		hbf4.add(new JLabel("Destination: "));
		zCountry = new JComboBox();
		zCountry.setSize(1,5);
		zAirport = new JComboBox();
		zAirport.setSize(1,5);
		hbf4.add(zCountry);
		Component hsf2 = Box.createHorizontalStrut(5);
		hbf4.add(hsf2);
		hbf4.add(zAirport);
		
		Component vsf3 = Box.createVerticalStrut(15);
		hbf5.add(vsf3);
		
		//Passenger Data
		Box vbp = Box.createVerticalBox();
		vbp.setBorder(BorderFactory.createTitledBorder("Passenger:"));
		centerPanel.add(vbp);
		
		Box hbp1 = Box.createHorizontalBox();
		vbp.add(hbp1);
		Box hbp2 = Box.createHorizontalBox();
		vbp.add(hbp2);
		Box hbp3 = Box.createHorizontalBox();
		vbp.add(hbp3);
		Box hbp4 = Box.createHorizontalBox();
		vbp.add(hbp4);
		
		Component vsp1 = Box.createVerticalStrut(20);
		hbp1.add(vsp1);
		
		hbp2.add(new JLabel("   First name: "));
		Component hsp1 = Box.createHorizontalStrut(10);
		hbp2.add(hsp1);
		txtFname = new JTextField();
		hbp2.add(txtFname);
		txtFname.setColumns(5);
		Component hsp2 = Box.createHorizontalStrut(30);
		hbp2.add(hsp2);
		
		
		hbp3.add(new JLabel("   Last name: "));
		Component hsp3 = Box.createHorizontalStrut(10);
		hbp3.add(hsp3);
		txtLname = new JTextField();
		hbp3.add(txtLname);
		txtLname.setColumns(5);
		Component hsp4 = Box.createHorizontalStrut(30);
		hbp3.add(hsp4);
		
		Component vsp2 = Box.createVerticalStrut(20);
		hbp4.add(vsp2);
		
		//Time
		Box vbt = Box.createVerticalBox();
		centerPanel.add(vbt);
		Box hbt1 = Box.createHorizontalBox();
		vbt.add(hbt1);
		Box hbt2 = Box.createHorizontalBox();
		vbt.add(hbt2);
		Box hbt3 = Box.createHorizontalBox();
		vbt.add(hbt3);
		Box hbt4 = Box.createHorizontalBox();
		vbt.add(hbt4);
		
		ab = new JRadioButton("Ab");
		an = new JRadioButton("An");
		ButtonGroup group = new ButtonGroup();
		group.add(ab);
		group.add(an);
		hbt1.add(ab);
		hbt1.add(an);
		hbt1.add(new JLabel(":"));
		Component hst1 = Box.createHorizontalStrut(5);
		hbt1.add(hst1);
		hour = new JComboBox();
		minute = new JComboBox();
		hbt1.add(hour);
		Component hst2 = Box.createHorizontalStrut(5);
		hbt1.add(hst2);
		hbt1.add(minute);
		
		Component vst1 = Box.createVerticalStrut(20);
		hbt2.add(vst1);
		
		hbt3.add(new JLabel("Flight Nr.: "));
		flightnr = new JComboBox();
		hbt3.add(flightnr);
		Component hst3 = Box.createHorizontalStrut(10);
		hbt3.add(hst3);
		hbt3.add(new JLabel("Row / Seat: "));
		row = new JComboBox();
		hbt3.add(row);
		hbt3.add(new JLabel(" / "));
		seat = new JComboBox();
		hbt3.add(seat);
		
		Component vst2 = Box.createVerticalStrut(50);
		hbt4.add(vst2);
	
		
		//Fluginfo
		Box info = Box.createVerticalBox();
		centerPanel.add(info);
		info.setBorder(BorderFactory.createTitledBorder("Info:"));
		txtInfo = new JTextArea("details",5,10);
		info.add(txtInfo);
		
		
		submit = new JButton("Submit");
		southPanel.add(submit);
		

		
		this.setVisible(true);
	}



}
