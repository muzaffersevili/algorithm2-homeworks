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
import java.io.IOException;
import java.awt.event.ActionEvent;

public class EmployeeOperations extends JFrame {

	private JPanel contentPane;
	private Color background_color;
	private JTable table;

	private DefaultTableModel employeeModel = null;
	private Object[] employeeData = null;

	private JTextField input_name;
	private JTextField input_surname;
	private JTextField input_email;
	private JTextField input_salary;
	private JTextField input_age;
	private JTextField input_gender;
	private JTextField input_field;
	private JTextField input_tc;
	private JTextField input_id;

	public EmployeeOperations(AirlineManager manager) {

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

		updateEmployeeModel(manager);

		background_color = new Color(101, 158, 199);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(background_color);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(20, 62, 384, 340);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Employee Operations", null, panel, null);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 359, 288);
		panel.add(scrollPane);

		table = new JTable(employeeModel);
		scrollPane.setViewportView(table);


		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManagerMenu managerMenu = new ManagerMenu(manager);
				managerMenu.setVisible(true);
				setVisible(false);
			}
		});
		
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(22, 20, 85, 21);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Name:");
		lblNewLabel_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1.setBounds(424, 160, 96, 13);
		contentPane.add(lblNewLabel_1);
		
		input_name = new JTextField();
		input_name.setColumns(10);
		input_name.setBounds(424, 183, 102, 19);
		contentPane.add(input_name);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setForeground(Color.DARK_GRAY);
		lblSurname.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSurname.setBounds(424, 212, 96, 13);
		contentPane.add(lblSurname);
		
		input_surname = new JTextField();
		input_surname.setColumns(10);
		input_surname.setBounds(424, 235, 102, 19);
		contentPane.add(input_surname);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblEmail.setBounds(424, 261, 96, 13);
		contentPane.add(lblEmail);
		
		input_email = new JTextField();
		input_email.setColumns(10);
		input_email.setBounds(424, 284, 102, 19);
		contentPane.add(input_email);
		
		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setForeground(Color.DARK_GRAY);
		lblSalary.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblSalary.setBounds(424, 313, 96, 19);
		contentPane.add(lblSalary);
		
		input_salary = new JTextField();
		input_salary.setColumns(10);
		input_salary.setBounds(424, 342, 102, 19);
		contentPane.add(input_salary);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(Color.DARK_GRAY);
		lblAge.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblAge.setBounds(424, 365, 96, 19);
		contentPane.add(lblAge);
		
		input_age = new JTextField();
		input_age.setColumns(10);
		input_age.setBounds(424, 394, 102, 19);
		contentPane.add(input_age);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblGender.setBounds(424, 430, 96, 13);
		contentPane.add(lblGender);
		
		input_gender = new JTextField();
		input_gender.setColumns(10);
		input_gender.setBounds(424, 453, 102, 19);
		contentPane.add(input_gender);
		
		JLabel lblField = new JLabel("Field");
		lblField.setForeground(Color.DARK_GRAY);
		lblField.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblField.setBounds(424, 474, 96, 19);
		contentPane.add(lblField);
		
		input_field = new JTextField();
		input_field.setColumns(10);
		input_field.setBounds(424, 503, 102, 19);
		contentPane.add(input_field);
		
		JButton add_button = new JButton("ADD");
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(manager.addEmployee(input_name.getText(),input_surname.getText(), input_email.getText(),
						Integer.parseInt(input_age.getText()), input_gender.getText().charAt(0), 
						Integer.parseInt(input_salary.getText()),
						input_field.getText(), input_tc.getText())) {
					
					DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
					clearModel.setRowCount(0);
					updateEmployeeModel(manager);
					
					JOptionPane.showMessageDialog(null, "Employee Added");
					
				}else {
					JOptionPane.showMessageDialog(null, "Employee Does Not Added");
				}
				
				
				
			}
		});
		add_button.setFont(new Font("Arial Black", Font.BOLD, 15));
		add_button.setBounds(424, 536, 102, 21);
		contentPane.add(add_button);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AirlineManagementSystem.save();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnLogOut.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnLogOut.setBounds(415, 20, 111, 21);
		contentPane.add(btnLogOut);
		
		JLabel lblNewLabel_1_2 = new JLabel("TC:");
		lblNewLabel_1_2.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(424, 108, 96, 13);
		contentPane.add(lblNewLabel_1_2);
		
		input_tc = new JTextField();
		input_tc.setColumns(10);
		input_tc.setBounds(424, 131, 102, 19);
		contentPane.add(input_tc);
		
		JLabel lblNewLabel_1_1 = new JLabel("ID:");
		lblNewLabel_1_1.setForeground(Color.DARK_GRAY);
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 416, 102, 19);
		contentPane.add(lblNewLabel_1_1);
		
		input_id = new JTextField();
		input_id.setColumns(10);
		input_id.setBounds(20, 445, 102, 19);
		contentPane.add(input_id);
		
		JButton delete_button = new JButton("DELETE");
		delete_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.deleteEmployee(Integer.parseInt(input_id.getText()))) {
					
					DefaultTableModel clearModel = (DefaultTableModel) table.getModel();
					clearModel.setRowCount(0);
					updateEmployeeModel(manager);
					
					JOptionPane.showMessageDialog(null, "Employee Deleted");
				}
				else {
					JOptionPane.showMessageDialog(null, "Employee Does Not Deleted");
				}
			}
		});
		delete_button.setFont(new Font("Arial Black", Font.BOLD, 15));
		delete_button.setBounds(20, 474, 102, 21);
		contentPane.add(delete_button);
	}

	public void updateEmployeeModel(AirlineManager manager) {

		for (int i = 0; i < manager.getEmployeeList().size(); i++) {

			employeeData[0] = manager.getEmployeeList().get(i).getEmployeeID();
			employeeData[1] = manager.getEmployeeList().get(i).getName();
			employeeData[2] = manager.getEmployeeList().get(i).getSurname();
			employeeData[3] = manager.getEmployeeList().get(i).getEmail();
			employeeData[4] = manager.getEmployeeList().get(i).getSalary();
			employeeData[5] = manager.getEmployeeList().get(i).getAge();
			employeeData[6] = manager.getEmployeeList().get(i).getGender();
			employeeData[7] = manager.getEmployeeList().get(i).getField();

			employeeModel.addRow(employeeData);
		}
	}
}
