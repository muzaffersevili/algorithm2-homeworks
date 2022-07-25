package GUI;
import CODE.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaneAirportOperations extends JFrame {

	private JPanel contentPane;
	private Color background_color;
	private JTable table;

	private DefaultTableModel planeModel = null;
	private Object[] planeData = null;

	private DefaultTableModel airportModel = null;
	private Object[] airportData = null;
	
	private JTable table_1;
	private JTextField input_type;
	private JTextField input_age;
	private JTextField input_seatCount;
	private JTextField input_id_plane;
	private JTextField input_name;
	private JTextField input_id_airport;

	public PlaneAirportOperations(AirlineManager manager) {

		planeModel = new DefaultTableModel();
		Object[] callPlaneName = new Object[2];
		
		callPlaneName[0] = "Type";
		callPlaneName[1] = "Plane ID";

		planeModel.setColumnIdentifiers(callPlaneName);
		planeData = new Object[2];
		updatePlaneModel(manager);
		
		airportModel = new DefaultTableModel();
		Object[] callAirportName = new Object[2];
		
		callAirportName[0] = "Airport Name";
		callAirportName[1] = "Airport Code";

		airportModel.setColumnIdentifiers(callAirportName);
		airportData = new Object[2];
		updateAirportModel(manager);
		
		
		background_color = new Color(101, 158, 199);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(background_color);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 49, 394, 297);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Plane Operations", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 369, 250);
		panel.add(scrollPane);

		table = new JTable(planeModel);
		scrollPane.setViewportView(table);
		

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(10, 20, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerMenu managerMenu = new ManagerMenu(manager);
				managerMenu.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(10, 350, 394, 273);
		contentPane.add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Airport Operations", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 369, 226);
		panel_1.add(scrollPane_1);

		table_1 = new JTable(airportModel);
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_1 = new JLabel("Type:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(407, 63, 119, 13);
		contentPane.add(lblNewLabel_1);
		
		input_type = new JTextField();
		input_type.setColumns(10);
		input_type.setBounds(407, 86, 119, 19);
		contentPane.add(input_type);
		
		JLabel lblSurname = new JLabel("Age:");
		lblSurname.setForeground(Color.DARK_GRAY);
		lblSurname.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSurname.setBounds(407, 112, 119, 13);
		contentPane.add(lblSurname);
		
		input_age = new JTextField();
		input_age.setColumns(10);
		input_age.setBounds(407, 135, 119, 19);
		contentPane.add(input_age);
		
		JLabel lblEmail = new JLabel("Seat Count:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblEmail.setBounds(408, 164, 118, 13);
		contentPane.add(lblEmail);
		
		input_seatCount = new JTextField();
		input_seatCount.setColumns(10);
		input_seatCount.setBounds(407, 187, 119, 19);
		contentPane.add(input_seatCount);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1.setBounds(408, 216, 118, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(407, 247, 119, 19);
		contentPane.add(lblNewLabel_1_1);
		
		input_id_plane = new JTextField();
		input_id_plane.setColumns(10);
		input_id_plane.setBounds(407, 276, 119, 19);
		contentPane.add(input_id_plane);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(408, 305, 118, 21);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Name:");
		lblNewLabel_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(414, 374, 96, 13);
		contentPane.add(lblNewLabel_1_2);
		
		input_name = new JTextField();
		input_name.setColumns(10);
		input_name.setBounds(414, 397, 113, 19);
		contentPane.add(input_name);
		
		JButton btnNewButton_1_2 = new JButton("ADD");
		btnNewButton_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_2.setBounds(415, 426, 112, 21);
		contentPane.add(btnNewButton_1_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ID:");
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(414, 521, 102, 19);
		contentPane.add(lblNewLabel_1_1_1);
		
		input_id_airport = new JTextField();
		input_id_airport.setColumns(10);
		input_id_airport.setBounds(414, 550, 113, 19);
		contentPane.add(input_id_airport);
		
		JButton btnNewButton_1_1_2 = new JButton("DELETE");
		btnNewButton_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1_2.setBounds(414, 579, 112, 21);
		contentPane.add(btnNewButton_1_1_2);
		
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogOut.setBounds(415, 20, 111, 21);
		contentPane.add(btnLogOut);
	}

	public void updatePlaneModel(AirlineManager manager) {

		for (int i = 0; i < manager.getPlaneList().size(); i++) {

			planeData[0] = manager.getPlaneList().get(i).getType();
			planeData[1] = manager.getPlaneList().get(i).getPlaneID();

			planeModel.addRow(planeData);
		}
	}
	public void updateAirportModel(AirlineManager manager) {

		for (int i = 0; i < manager.getAirportList().size(); i++) {

			airportData[0] = manager.getAirportList().get(i).getAirportName();
			airportData[1] = manager.getAirportList().get(i).getAirportCode();

			airportModel.addRow(airportData);
		}
	}
}
