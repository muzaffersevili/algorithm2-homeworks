package GUI;
import CODE.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerMenu extends JFrame {

	private JPanel contentPane;
	private Color background_color;

	public ManagerMenu(AirlineManager manager) {
		
		background_color = new Color(188, 207, 236);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		contentPane = new JPanel();
		contentPane.setBackground(background_color);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(48, 106, 433, 352);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Manager", null, panel, null);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Employee Operations");
		btnNewButton.setBackground(new Color(72,99,168));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeOperations operationsMenu = new EmployeeOperations(manager);
				operationsMenu.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(84, 33, 267, 66);
		panel.add(btnNewButton);

		JButton btnFlightOperations = new JButton("Flight Operations");
		btnFlightOperations.setBackground(new Color(72,99,168));
		btnFlightOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FlightOperations flightOperations = new FlightOperations(manager);
				flightOperations.setVisible(true);
				setVisible(false);
			}
		});
		btnFlightOperations.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnFlightOperations.setBounds(84, 123, 267, 66);
		panel.add(btnFlightOperations);

		JButton btnPlaneOperations = new JButton("Plane/Airport Operations");
		btnPlaneOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PlaneAirportOperations flightOperations = new PlaneAirportOperations(manager);
				flightOperations.setVisible(true);
				setVisible(false);
			}
		});
		btnPlaneOperations.setBackground(new Color(72,99,168));
		btnPlaneOperations.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnPlaneOperations.setBounds(84, 210, 267, 66);
		panel.add(btnPlaneOperations);
	}
}
