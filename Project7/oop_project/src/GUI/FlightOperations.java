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

public class FlightOperations extends JFrame {

	private JPanel contentPane;
	private Color background_color;
	private JTable table;

	private DefaultTableModel flightModel = null;
	private Object[] flightData = null;
	
	
	private JTextField input_date;
	private JTextField input_source;
	private JTextField input_destination;
	private JTextField input_departure;
	private JTextField input_arrival;
	private JTextField input_gate;
	private JTextField input_flightWorkerCount;
	private JTextField inpur_id;

	public FlightOperations(AirlineManager manager) {

		flightModel = new DefaultTableModel();
		Object[] callFlightName = new Object[4];
		callFlightName[0] = "FlightID";
		callFlightName[1] = "Source";
		callFlightName[2] = "Destination";
		callFlightName[3] = "Date";

		flightModel.setColumnIdentifiers(callFlightName);
		flightData = new Object[4];
		updateFlightModel(manager);


		background_color = new Color(101, 158, 199);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(background_color);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 60, 338, 553);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Flight Operations", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 313, 506);
		panel.add(scrollPane);

		table = new JTable(flightModel);
		scrollPane.setViewportView(table);

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
		//		input_id.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
			}
		});

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerMenu managerMenu = new ManagerMenu(manager);
				managerMenu.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(10, 29, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogOut.setBounds(419, 29, 111, 21);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_1_2 = new JLabel("Date:");
		lblNewLabel_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(358, 70, 96, 13);
		contentPane.add(lblNewLabel_1_2);
		
		input_date = new JTextField();
		input_date.setColumns(10);
		input_date.setBounds(358, 93, 172, 19);
		contentPane.add(input_date);
		
		JLabel lblNewLabel_1 = new JLabel("Source:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(358, 122, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		input_source = new JTextField();
		input_source.setColumns(10);
		input_source.setBounds(358, 145, 172, 19);
		contentPane.add(input_source);
		
		JLabel lblSurname = new JLabel("Destination:");
		lblSurname.setForeground(Color.DARK_GRAY);
		lblSurname.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSurname.setBounds(358, 174, 113, 13);
		contentPane.add(lblSurname);
		
		input_destination = new JTextField();
		input_destination.setColumns(10);
		input_destination.setBounds(358, 194, 172, 19);
		contentPane.add(input_destination);
		
		JLabel lblEmail = new JLabel("Departure Time:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblEmail.setBounds(358, 223, 156, 13);
		contentPane.add(lblEmail);
		
		input_departure = new JTextField();
		input_departure.setColumns(10);
		input_departure.setBounds(358, 246, 172, 19);
		contentPane.add(input_departure);
		
		JLabel lblSalary = new JLabel("Arrival Time:");
		lblSalary.setForeground(Color.DARK_GRAY);
		lblSalary.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSalary.setBounds(358, 275, 156, 19);
		contentPane.add(lblSalary);
		
		input_arrival = new JTextField();
		input_arrival.setColumns(10);
		input_arrival.setBounds(358, 304, 172, 19);
		contentPane.add(input_arrival);
		
		JLabel lblAge = new JLabel("Gate:");
		lblAge.setForeground(Color.DARK_GRAY);
		lblAge.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAge.setBounds(358, 327, 96, 19);
		contentPane.add(lblAge);
		
		input_gate = new JTextField();
		input_gate.setColumns(10);
		input_gate.setBounds(358, 356, 172, 19);
		contentPane.add(input_gate);
		
		JLabel lblGender = new JLabel("FilghtWorker Count:");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblGender.setBounds(358, 392, 188, 13);
		contentPane.add(lblGender);
		
		input_flightWorkerCount = new JTextField();
		input_flightWorkerCount.setColumns(10);
		input_flightWorkerCount.setBounds(358, 415, 172, 19);
		contentPane.add(input_flightWorkerCount);
		
		JButton btnNewButton_1 = new JButton("ADD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.addFlight(1, 20, input_source.getText(), input_destination.getText(), 
						input_date.getText(), input_departure.getText(), input_arrival.getText(), 
						Integer.parseInt(input_gate.getText()))) {
					JOptionPane.showMessageDialog(null, "Flight Added");
					updateFlightModel(manager);
				}
				else {
					JOptionPane.showMessageDialog(null, "Flight Does Not Added");
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1.setBounds(358, 444, 172, 21);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(358, 511, 102, 19);
		contentPane.add(lblNewLabel_1_1);
		
		inpur_id = new JTextField();
		inpur_id.setColumns(10);
		inpur_id.setBounds(358, 540, 172, 19);
		contentPane.add(inpur_id);
		
		JButton btnNewButton_1_1 = new JButton("DELETE");
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(358, 569, 172, 21);
		contentPane.add(btnNewButton_1_1);
		
		
	}

	public void updateFlightModel(AirlineManager manager) {

		for (int i = 0; i < manager.getFlightList().size(); i++) {

			flightData[0] = manager.getFlightList().get(i).getFlightID();
			flightData[1] = manager.getFlightList().get(i).getSource();
			flightData[2] = manager.getFlightList().get(i).getDestination();
			flightData[3] = manager.getFlightList().get(i).getFlightTime();

			flightModel.addRow(flightData);
			System.out.println(flightData);
		}
		
	}
}
