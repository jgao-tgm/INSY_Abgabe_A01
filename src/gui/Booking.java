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
	
	public JComboBox year;
	public JComboBox month;
	public JComboBox day;
	
	public JComboBox flightnr;
	public JComboBox row;
	public JComboBox seat;

	public JComboBox sCountry;
	public JComboBox sAirport;
	public JComboBox zCountry;
	public JComboBox zAirport;
	
	public JRadioButton an;
	public JRadioButton ab;
	public ButtonGroup group;
	
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
	
	public void add1FreshItemComboBox(String string, JComboBox cbox){
		cbox.removeAllItems();
		cbox.addItem(string);
		
	}
	
	public void addFreshItemComboBox(String[] string, JComboBox cbox){
		int c = string.length;
		cbox.removeAllItems();
		for(int i = 0; i < c; i++){
			cbox.addItem(string[i]);
		}
	}
	
	public void addDaysMonth(int month, int year, JComboBox cbox){
		cbox.removeAllItems();
		if(month == 2 && year % 4 == 0){
			for(int f=0; f<29; f++){
				cbox.addItem(1+f);
			}
		}
		else if(month == 2 && year % 4 != 0){
			for(int f=0; f<29; f++){
				cbox.addItem(1+f);
			}
		}
		else if(month == 7){
			for(int f=0; f<31; f++){
				cbox.addItem(1+f);
			}
		} 
		else if(month % 2 != 0 && month < 7){
			for(int f=0; f<31; f++){
				cbox.addItem(1+f);
			}
		} 
		else if(month % 2 == 0 && month > 7){
			for(int f=0; f<31; f++){
				cbox.addItem(1+f);
			}
		} 
		else {
			for(int f=0; f<30; f++){
				cbox.addItem(1+f);
			}
		}

	}



	private void initialize() {
		this.setTitle("Booking");
		this.setSize(1000, 300);
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
		sCountry.addItem("--Country--");
		sCountry.addActionListener(main);
		sAirport = new JComboBox();
		sAirport.setSize(1,5);
		sAirport.addItem("--Airport--");
		sAirport.addActionListener(main);
		hbf2.add(sCountry);
		Component hsf1 = Box.createHorizontalStrut(5);
		hbf2.add(hsf1);
		hbf2.add(sAirport);

		Component vsf2 = Box.createVerticalStrut(15);
		hbf3.add(vsf2);
		
		hbf4.add(new JLabel("Destination: "));
		zCountry = new JComboBox();
		zCountry.setSize(1,5);
		zCountry.addItem("--Country--");
		zCountry.addActionListener(main);
		zAirport = new JComboBox();
		zAirport.setSize(1,5);
		zAirport.addItem("--Airport--");
		zAirport.addActionListener(main);
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
		group = new ButtonGroup();
		group.add(ab);
		group.add(an);
		ab.addActionListener(main);
		an.addActionListener(main);
		hbt1.add(ab);
		hbt1.add(an);
		hbt1.add(new JLabel(":"));
		Component hst1 = Box.createHorizontalStrut(5);
		hbt1.add(hst1);
		year = new JComboBox();
		for(int y=0; y<20; y++){
			year.addItem(2000+y);
		}
		year.addActionListener(main);
		month = new JComboBox();
		for(int y=0; y<12; y++){
			month.addItem(1+y);
		}
		month.addActionListener(main);
		day = new JComboBox();
		for(int y=0; y<31; y++){
			day.addItem(1+y);
		}
		hour = new JComboBox();
		for(int y=0; y<24; y++){
			if(y<10){
				hour.addItem("0"+y);
			} else {
				hour.addItem(y);
			}
		}
		minute = new JComboBox();
		for(int y=0; y<60; y++){
			if(y<10){
				minute.addItem("0"+y);
			} else {
				minute.addItem(y);
			}
		}
		hbt1.add(year);
		Component hst9 = Box.createHorizontalStrut(5);
		hbt1.add(hst9);
		hbt1.add(new JLabel("/"));
		Component hst10 = Box.createHorizontalStrut(5);
		hbt1.add(hst10);
		hbt1.add(month);
		Component hst5 = Box.createHorizontalStrut(5);
		hbt1.add(hst5);
		hbt1.add(new JLabel("/"));
		Component hst6 = Box.createHorizontalStrut(5);
		hbt1.add(hst6);
		hbt1.add(day);
		Component hst7 = Box.createHorizontalStrut(20);
		hbt1.add(hst7);
		
		hbt1.add(hour);
		Component hst2 = Box.createHorizontalStrut(5);
		hbt1.add(hst2);
		hbt1.add(new JLabel(":"));
		Component hst21 = Box.createHorizontalStrut(5);
		hbt1.add(hst21);
		hbt1.add(minute);
		Component hst3 = Box.createHorizontalStrut(100);
		hbt1.add(hst3);
		
		Component vst1 = Box.createVerticalStrut(20);
		hbt2.add(vst1);
		
		hbt3.add(new JLabel("Flight Nr.: "));
		flightnr = new JComboBox();
		flightnr.addActionListener(main);
		hbt3.add(flightnr);
		Component hst4 = Box.createHorizontalStrut(10);
		hbt3.add(hst4);
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
		submit.addActionListener(main);
		

		
		this.setVisible(true);
	}



}
