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
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class TicketOperations extends JFrame {

	private JPanel contentPane;
	private Color background_color;

	private DefaultTableModel ticketModel = null;
	private DefaultTableModel flightModel = null;
	private Object[] ticketData = null;
	private Object[] flightData = null;
	private JTextField input_id_flight;
	private JTextField input_id_ticket;
	private JTable table;
	private JTable table_1;

	public TicketOperations(AirlineManager manager, Passenger passenger) {

		ticketModel = new DefaultTableModel();
		Object[] callTicketName = new Object[6];
		callTicketName[0] = "NameSurname";
		callTicketName[1] = "PassengerID";
		callTicketName[2] = "TicketClass";
		callTicketName[3] = "Price";
		callTicketName[4] = "Date";
		callTicketName[5] = "Seat";

		ticketModel.setColumnIdentifiers(callTicketName);
		ticketData = new Object[6];
		updateTicketModel(passenger);

		
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

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerMenu passengerMenu = new PassengerMenu(manager,passenger);
				passengerMenu.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(10, 10, 85, 21);
		contentPane.add(btnNewButton);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 54, 255, 378);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Flights", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 230, 331);
		panel.add(scrollPane);

		table = new JTable(flightModel);
		scrollPane.setViewportView(table);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(275, 54, 251, 378);
		contentPane.add(tabbedPane_1);

		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Tickets", null, panel_1, null);
		panel_1.setLayout(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 226, 331);
		panel_1.add(scrollPane_1);

		table_1 = new JTable(ticketModel);
		scrollPane_1.setViewportView(table_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Flight ID:");
		lblNewLabel_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(60, 442, 102, 19);
		contentPane.add(lblNewLabel_1_1_1);

		input_id_flight = new JTextField();
		input_id_flight.setColumns(10);
		input_id_flight.setBounds(60, 471, 163, 19);
		contentPane.add(input_id_flight);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Class:");
		lblNewLabel_1_1_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(60, 500, 102, 19);
		contentPane.add(lblNewLabel_1_1_1_1);

		JComboBox input_class = new JComboBox();
		input_class.setBounds(60, 529, 163, 21);
		input_class.addItem("Economy");
		input_class.addItem("Business");
		contentPane.add(input_class);

		JButton btnNewButton_1_1_1_1 = new JButton("EXCHANGE");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1_1_1.setBounds(321, 499, 163, 21);
		contentPane.add(btnNewButton_1_1_1_1);

		JLabel lblNewLabel_1_1_1_2 = new JLabel("Selected Ticket ID:");
		lblNewLabel_1_1_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1_1_2.setBounds(321, 442, 178, 19);
		contentPane.add(lblNewLabel_1_1_1_2);

		input_id_ticket = new JTextField();
		input_id_ticket.setColumns(10);
		input_id_ticket.setBounds(321, 471, 163, 19);
		contentPane.add(input_id_ticket);

		JButton btnNewButton_1_1_1_1_1 = new JButton("CANCEL");
		btnNewButton_1_1_1_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1_1_1_1.setBounds(321, 558, 163, 21);
		contentPane.add(btnNewButton_1_1_1_1_1);

		JButton btnNewButton_1_1_1_1_2 = new JButton("CHECK-IN");
		btnNewButton_1_1_1_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1_1_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1_1_1_2.setBounds(321, 527, 163, 21);
		contentPane.add(btnNewButton_1_1_1_1_2);

		JButton btnNewButton_1_1_1_1_3 = new JButton("BUY");
		btnNewButton_1_1_1_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ticket_price = passenger.buyingticket(Integer.parseInt(input_id_flight.getText()),
						input_class.getSelectedItem().toString());

				JPanel myPanel = new JPanel();

				myPanel.add(new JLabel("Your ticket price is: " + ticket_price + ", Do you wan to continue?"));

				int result = JOptionPane.showConfirmDialog(null, myPanel, "Payment", JOptionPane.YES_NO_OPTION);

				if (result == 0) {
					myPanel.removeAll();
					myPanel.add(new JLabel("Money withdrawn from your wallet"));
					JOptionPane.showInternalMessageDialog(null, myPanel, "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});
		btnNewButton_1_1_1_1_3.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1_1_1_3.setBounds(60, 558, 163, 21);
		contentPane.add(btnNewButton_1_1_1_1_3);

		JButton btnNewButton_1 = new JButton("TICKET INQUIRY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JTextField idField = new JTextField(5);

				JPanel myPanel = new JPanel();
				myPanel.setLayout(new GridLayout(7, 1));

				myPanel.add(new JLabel("Please enter Ticket ID:"));
				myPanel.add(idField);
				myPanel.add(Box.createVerticalStrut(15));

				int result = JOptionPane.showConfirmDialog(null, myPanel, "Ticket Inquiry",
						JOptionPane.OK_CANCEL_OPTION);
				String input_id_inquiry = idField.getText();

				if (result == 0) {
					myPanel.removeAll();
					////////////////////// TICKET OLACAK

					Employee temp = new Employee("emiran", "deniz", "rana@sasf.com", 111, 'F', 999, "field3",
							"6541233");

					myPanel.add(new JLabel("Name: " + temp.getName()));
					myPanel.add(new JLabel("Surname: " + temp.getSurname()));
					myPanel.add(new JLabel("Email: " + temp.getEmail()));
					myPanel.add(new JLabel("Salary: " + temp.getSalary()));
					myPanel.add(new JLabel("Gender: " + temp.getGender()));
					myPanel.add(new JLabel("Age: " + temp.getAge()));
					myPanel.add(new JLabel("Field: " + temp.getField()));

					JOptionPane.showInternalMessageDialog(null, myPanel, "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}

			}
		});

		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1.setBounds(144, 592, 294, 21);
		contentPane.add(btnNewButton_1);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogOut.setBounds(415, 12, 111, 21);
		contentPane.add(btnLogOut);
	}

	public void updateTicketModel(Passenger passenger) {

		for (int i = 0; i < passenger.getTickets().size(); i++) {

			ticketData[0] = passenger.getTickets().get(i).getPassengerNameSurname();
			ticketData[1] = passenger.getTickets().get(i).getPassengerID();
			ticketData[2] = passenger.getTickets().get(i).getTicketClass();
			ticketData[3] = passenger.getTickets().get(i).getPrice();
			ticketData[4] = passenger.getTickets().get(i).getDate();
			ticketData[5] = passenger.getTickets().get(i).getSeat();

			ticketModel.addRow(ticketData);
		}
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
