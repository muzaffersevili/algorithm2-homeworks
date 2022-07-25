package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import CODE.Employee;

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

public class FlightWorkerOperations extends JFrame {

	private JPanel contentPane;
	private Color background_color;

	private DefaultTableModel employeeModel = null;
	private Object[] employeeData = null;
	private JTable table;
	private JTable table_1;
	private JTextField textField;
	
	public FlightWorkerOperations(Employee emp) {
		
		employeeModel = new DefaultTableModel();
		Object[] callEmployeeName = new Object[8];
		callEmployeeName[0] = "Id";
		callEmployeeName[1] = "Name";
		callEmployeeName[2] = "Surname";
		callEmployeeName[3] = "Email";
		callEmployeeName[4] = "Salary";
		callEmployeeName[5] = "Age";
		callEmployeeName[6] = "Gender";
		callEmployeeName[7] = "Field";

		employeeModel.setColumnIdentifiers(callEmployeeName);
		employeeData = new Object[8];

//		updateEmployeeModel();

		background_color = new Color(101, 158, 199);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(background_color);
		setContentPane(contentPane);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(20, 20, 85, 21);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EmployeeMenu empMenu = new EmployeeMenu(emp);
				empMenu.setVisible(true);
				setVisible(false);
			}
		});
		contentPane.setLayout(null);
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		contentPane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 63, 241, 358);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Flights", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 216, 311);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(285, 63, 241, 358);
		contentPane.add(tabbedPane_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane_1.addTab("Passengers", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 10, 216, 311);
		panel_1.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JButton btnNewButton_1_1 = new JButton("List Flight's Passengers");
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_1_1.setBounds(20, 518, 252, 21);
		contentPane.add(btnNewButton_1_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(20, 489, 108, 19);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1_1 = new JLabel("Selected ID:");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 460, 136, 19);
		contentPane.add(lblNewLabel_1_1);
		
		
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
}
