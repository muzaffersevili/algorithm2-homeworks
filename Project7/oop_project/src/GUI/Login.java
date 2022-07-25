package GUI;

import CODE.*;

import javax.swing.*;
import java.awt.*;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField username_passenger;
	private Color background_color;
	private JPasswordField password_passenger;
	private JTextField username_worker;
	private JPasswordField password_worker;

	public Login(AirlineManager manager) {
		
		manager.addEmployee("rana", "gul", "rana@gmail.com", 15, 'F', 50, "FlightWorker","214fhdhs214");
		manager.addEmployee("ecem", "tunur", "rana@gmail.com", 20, 'F', 1000, "FlightWorker","2342fhd2s4");
		manager.addEmployee("elif", "gul", "rana@sfasaasf.com", 564565, 'F', 5540, "FlightWorker","2342fdhsd24");
		manager.addEmployee("muzo", "safasf", "rana@gmaisfasaffsal.com", 15, 'M', 50, "FlightWorker","234fdh224");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);

		background_color = new Color(72, 138, 199);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(background_color);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewJgoodiesTitle = DefaultComponentFactory.getInstance().createTitle("AIRLINE MANAGEMENT SYSTEM");
		lblNewJgoodiesTitle.setFont(new Font("Arial Black", Font.BOLD, 25));
		lblNewJgoodiesTitle.setBounds(35, 24, 475, 80);
		contentPane.add(lblNewJgoodiesTitle);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(22, 272, 179, 274);
		contentPane.add(tabbedPane);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Passenger", null, panel, null);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setBounds(10, 10, 112, 29);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));

		JCheckBox chckbxNewCheckBox = new JCheckBox("Show Password");
		chckbxNewCheckBox.setBounds(10, 135, 123, 19);
		panel.add(chckbxNewCheckBox);
		chckbxNewCheckBox.setFont(new Font("Arial Black", Font.BOLD, 10));
		chckbxNewCheckBox.setBackground(new Color(240, 240, 240));

		password_passenger = new JPasswordField();
		password_passenger.setBounds(10, 100, 149, 26);
		panel.add(password_passenger);
		password_passenger.setEchoChar('*');

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 74, 123, 29);
		panel.add(lblPassword);
		lblPassword.setFont(new Font("Arial Black", Font.PLAIN, 20));

		username_passenger = new JTextField();
		username_passenger.setBounds(10, 38, 149, 26);
		panel.add(username_passenger);
		username_passenger.setColumns(10);

		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setBounds(31, 164, 102, 29);
		btnNewButton.setBackground(new Color(188, 207, 236));
		panel.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(manager.controlLoginPassenger(username_passenger.getText(), password_passenger.getText())) {
					
					Passenger passenger = manager.getPassenger(username_passenger.getText(), password_passenger.getText());
					
					JOptionPane.showMessageDialog(null, "Login Successful");
					PassengerMenu passengerMenu = new PassengerMenu(manager, passenger);
					passengerMenu.setVisible(true);
					setVisible(false);

				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					username_passenger.setText(null);
					password_passenger.setText(null);
				}

			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));

		JButton btnNewButton_1 = new JButton("Sign up");
		btnNewButton_1.setBackground(new Color(188, 207, 236));
		btnNewButton_1.setBounds(10, 203, 149, 29);
		panel.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 15));

		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Worker", null, panel_1, null);
		panel_1.setLayout(null);

		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblPassword_1.setBounds(10, 74, 123, 29);
		panel_1.add(lblPassword_1);

		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(10, 10, 112, 29);
		panel_1.add(lblNewLabel_2);

		username_worker = new JTextField();
		username_worker.setColumns(10);
		username_worker.setBounds(10, 38, 149, 26);
		panel_1.add(username_worker);

		password_worker = new JPasswordField();
		password_worker.setEchoChar('*');
		password_worker.setBounds(10, 100, 149, 26);
		panel_1.add(password_worker);

		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Show Password");
		chckbxNewCheckBox_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		chckbxNewCheckBox_1.setBackground(SystemColor.menu);
		chckbxNewCheckBox_1.setBounds(10, 135, 123, 19);
		panel_1.add(chckbxNewCheckBox_1);

		JButton btnNewButton_2 = new JButton("LOGIN");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(manager.controlWorker(username_worker.getText()) == 0) { //admin
					
					JOptionPane.showMessageDialog(null, "Login Successful");
					ManagerMenu managerMenu = new ManagerMenu(manager);
					managerMenu.setVisible(true);
				}
				else if(manager.controlWorker(username_worker.getText()) == 1 || 
						manager.controlWorker(username_worker.getText()) == -1){
					JOptionPane.showMessageDialog(null, "Login Successful");
					
					Employee emp = manager.getEmployee(username_worker.getText(), password_worker.getText());
					EmployeeMenu employeeMenu = new EmployeeMenu(emp);
					employeeMenu.setVisible(true);
					setVisible(false);
					
				} else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password");
					username_worker.setText(null);
					password_worker.setText(null);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(188, 207, 236));
		btnNewButton_2.setBounds(32, 182, 102, 29);
		panel_1.add(btnNewButton_2);

		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/IMAGES/travel-icon.png")));

		lblNewLabel_1.setBounds(73, 116, 600, 613);
		contentPane.add(lblNewLabel_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JTextField TCField = new JTextField(5);
				JTextField nameField = new JTextField(5);
				JTextField surnameField = new JTextField(5);
				JTextField emailField = new JTextField(5);
				JTextField passwordField = new JTextField(5);
				JTextField ageField = new JTextField(5);
				JTextField genderField = new JTextField(5);
				JTextField pointField = new JTextField(5);
				
				JPanel myPanel = new JPanel();
				myPanel.setLayout(new GridLayout(10, 1));
				myPanel.add(new JLabel("Create a new account:"));
				myPanel.add(new JLabel("  "));
				myPanel.add(new JLabel("TC: "));
				myPanel.add(TCField);
				myPanel.add(new JLabel("Name:"));
				myPanel.add(nameField);
				myPanel.add(new JLabel("Surname: "));
				myPanel.add(surnameField);
				myPanel.add(new JLabel("Email: "));
				myPanel.add(emailField);
				myPanel.add(new JLabel("Password: "));
				myPanel.add(passwordField);
				myPanel.add(new JLabel("Age: "));
				myPanel.add(ageField);
				myPanel.add(new JLabel("Gender: "));
				myPanel.add(genderField);

				int result = JOptionPane.showConfirmDialog(null, myPanel, "Sign Up", JOptionPane.OK_CANCEL_OPTION);
				
				manager.addPassenger(nameField.getText(), surnameField.getText(),
						Integer.parseInt(ageField.getText()), genderField.getText().charAt(0),emailField.getText(),
						TCField.getText(),passwordField.getText());
			
				myPanel.removeAll();
				
				if(result == 0) 
					myPanel.add(new Label("The Account Created Successfully"));
					
				else 
					myPanel.add(new Label("The Account Does not Created"));
				
				result = JOptionPane.showConfirmDialog(null, myPanel, "Sign Up", JOptionPane.OK_CANCEL_OPTION);
			}
		});

		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox.isSelected())
					password_passenger.setEchoChar((char) 0);
				else
					password_passenger.setEchoChar('*');
			}
		});
		chckbxNewCheckBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (chckbxNewCheckBox_1.isSelected())
					password_worker.setEchoChar((char) 0);
				else
					password_worker.setEchoChar('*');
			}
		});

	}
}
