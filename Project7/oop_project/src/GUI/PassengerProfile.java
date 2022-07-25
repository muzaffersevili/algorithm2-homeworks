package GUI;
import CODE.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;

public class PassengerProfile extends JFrame {

	private JPanel contentPane;
	private Color background_color;
	
	public PassengerProfile(AirlineManager manager,Passenger passenger) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		background_color = new Color(101, 158, 199);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(background_color);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerMenu operations_menu = new PassengerMenu(manager, passenger);
				operations_menu.setVisible(true);
				setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(27, 21, 85, 21);
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(52, 52, 435, 532);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("My Profile", null, panel, null);
		panel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(87, 24, 225, 225);
		panel.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(PassengerProfile.class.getResource("/IMAGES/download.png")));
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setBounds(81, 259, 102, 29);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("Surname:");
		lblNewLabel_1_1.setBounds(81, 298, 119, 29);
		panel.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_2 = new JLabel("Email:");
		lblNewLabel_1_2.setBounds(81, 337, 102, 29);
		panel.add(lblNewLabel_1_2);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_3 = new JLabel("Age:");
		lblNewLabel_1_3.setBounds(81, 376, 102, 29);
		panel.add(lblNewLabel_1_3);
		lblNewLabel_1_3.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_4 = new JLabel("Gender:");
		lblNewLabel_1_4.setBounds(81, 415, 102, 29);
		panel.add(lblNewLabel_1_4);
		lblNewLabel_1_4.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Membership:");
		lblNewLabel_1_4_1.setBounds(81, 454, 148, 29);
		panel.add(lblNewLabel_1_4_1);
		lblNewLabel_1_4_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_5 = new JLabel(String.valueOf(passenger.getMemberShip()));
		lblNewLabel_2_5.setBounds(249, 458, 195, 25);
		panel.add(lblNewLabel_2_5);
		lblNewLabel_2_5.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_4 = new JLabel(String.valueOf(passenger.getGender()));
		lblNewLabel_2_4.setBounds(249, 419, 195, 25);
		panel.add(lblNewLabel_2_4);
		lblNewLabel_2_4.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_3 = new JLabel(String.valueOf(passenger.getAge()));
		lblNewLabel_2_3.setBounds(249, 380, 195, 25);
		panel.add(lblNewLabel_2_3);
		lblNewLabel_2_3.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_2 = new JLabel(passenger.getEmail());
		lblNewLabel_2_2.setBounds(249, 341, 195, 25);
		panel.add(lblNewLabel_2_2);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel(passenger.getSurname());
		lblNewLabel_2_1.setBounds(249, 302, 195, 25);
		panel.add(lblNewLabel_2_1);
		lblNewLabel_2_1.setFont(new Font("Arial", Font.BOLD, 15));
		
		
		JLabel lblNewLabel_2 = new JLabel(passenger.getName());
		lblNewLabel_2.setBounds(249, 263, 195, 25);
		panel.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 15));
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Point:");
		lblNewLabel_1_4_1_1.setBounds(338, 127, 148, 29);
		panel.add(lblNewLabel_1_4_1_1);
		lblNewLabel_1_4_1_1.setFont(new Font("Arial Black", Font.BOLD, 20));
		
		JLabel lblNewLabel_2_6 = new JLabel(String.valueOf(passenger.getPassengerPoint()));
		lblNewLabel_2_6.setBounds(338, 166, 140, 25);
		panel.add(lblNewLabel_2_6);
		lblNewLabel_2_6.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogOut.setBounds(415, 21, 111, 21);
		contentPane.add(btnLogOut);
	}
}
