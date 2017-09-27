package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;

public class FlugGui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FlugGui frame = new FlugGui();
					frame.setVisible(true);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
					frame.setUndecorated(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FlugGui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1270, 1193);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Box verticalBox = Box.createVerticalBox();
		contentPane.add(verticalBox, BorderLayout.NORTH);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut);
		
		Box horizontalBox = Box.createHorizontalBox();
		verticalBox.add(horizontalBox);
		
		JLabel lblNewLabel = new JLabel("Start");
		horizontalBox.add(lblNewLabel);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut);
		
		JComboBox comboBox = new JComboBox();
		horizontalBox.add(comboBox);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalBox.add(horizontalStrut_2);
		
		JComboBox comboBox_2 = new JComboBox();
		horizontalBox.add(comboBox_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_1);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_1);
		
		JLabel lblZiel = new JLabel("Ziel");
		horizontalBox_1.add(lblZiel);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_1);
		
		JComboBox comboBox_1 = new JComboBox();
		horizontalBox_1.add(comboBox_1);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		horizontalBox_1.add(horizontalStrut_3);
		
		JComboBox comboBox_3 = new JComboBox();
		horizontalBox_1.add(comboBox_3);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalBox.add(verticalStrut_2);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		verticalBox.add(horizontalBox_4);
		
		Component horizontalStrut_24 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_24);
		
		JLabel label_9 = new JLabel("Vorname");
		horizontalBox_4.add(label_9);
		
		Component horizontalStrut_25 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_25);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		horizontalBox_4.add(textField_5);
		
		Component horizontalStrut_26 = Box.createHorizontalStrut(100);
		horizontalBox_4.add(horizontalStrut_26);
		
		JLabel label_10 = new JLabel("Nachname");
		horizontalBox_4.add(label_10);
		
		Component horizontalStrut_27 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_27);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		horizontalBox_4.add(textField_6);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_4);
		
		JLabel label_11 = new JLabel("Flugnummer");
		horizontalBox_4.add(label_11);
		
		Component horizontalStrut_28 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_28);
		
		JComboBox comboBox_10 = new JComboBox();
		horizontalBox_4.add(comboBox_10);
		
		Component horizontalStrut_29 = Box.createHorizontalStrut(100);
		horizontalBox_4.add(horizontalStrut_29);
		
		JLabel label_12 = new JLabel("Reihe");
		horizontalBox_4.add(label_12);
		
		Component horizontalStrut_31 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_31);
		
		JComboBox comboBox_11 = new JComboBox();
		horizontalBox_4.add(comboBox_11);
		
		Component horizontalStrut_32 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_32);
		
		JLabel label_13 = new JLabel("Sitzplatz");
		horizontalBox_4.add(label_13);
		
		Component horizontalStrut_33 = Box.createHorizontalStrut(20);
		horizontalBox_4.add(horizontalStrut_33);
		
		JComboBox comboBox_12 = new JComboBox();
		horizontalBox_4.add(comboBox_12);
		
		textField = new JTextField();
		contentPane.add(textField, BorderLayout.SOUTH);
		textField.setColumns(10);
	}

}
