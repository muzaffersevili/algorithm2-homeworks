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

public class EmployeeMenu extends JFrame {

	private JPanel contentPane;
	private Color background_color;

	public EmployeeMenu(Employee emp) {

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
		tabbedPane.addTab("Employee", null, panel, null);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Operations");
		btnNewButton.setBackground(new Color(72, 99, 168));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println(emp.getName());
				if (emp.getField() == "MaintanenceWorker") {
					
					MaintenanceWorkerOperations maintenanceWorker = new MaintenanceWorkerOperations(emp);
					maintenanceWorker.setVisible(true);
					
				} else if (emp.getField() == "FlightWorker") {
					
					FlightWorkerOperations flightWorker = new FlightWorkerOperations(emp);
					flightWorker.setVisible(true);
				} 
				setVisible(false);

			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(84, 66, 267, 66);
		panel.add(btnNewButton);

		JButton btnFlightOperations = new JButton("My Profile");
		btnFlightOperations.setBackground(new Color(72, 99, 168));
		btnFlightOperations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFlightOperations.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnFlightOperations.setBounds(84, 184, 267, 66);
		panel.add(btnFlightOperations);
	}
}
