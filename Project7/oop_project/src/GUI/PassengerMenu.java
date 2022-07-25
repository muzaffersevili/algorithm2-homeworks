package GUI;
import CODE.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;

public class PassengerMenu extends JFrame {

	private JPanel contentPane;
	private Color background_color;

	
	public PassengerMenu(AirlineManager manager,Passenger passenger) {
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 100, 550, 660);
		background_color = new Color(188, 207, 236);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(background_color);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(64, 89, 425, 373);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Passenger Operations", null, panel, null);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Ticket Operations");
		btnNewButton.setBackground(new Color(72,99,168));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TicketOperations ticketBuyExchange = new TicketOperations(manager,passenger);
				ticketBuyExchange.setVisible(true);
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnNewButton.setBounds(83, 46, 255, 59);
		panel.add(btnNewButton);
		
		JButton btnPremiumClub = new JButton("Premium Club");
		btnPremiumClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JPanel myPanel =  new JPanel();
			 	
				myPanel.add(new JLabel("If you get Premium Club, You will get 20% discount"));

				int result = JOptionPane.showConfirmDialog(null, myPanel, "Premium Club", JOptionPane.OK_CANCEL_OPTION);
				
				if (result == 0) {
					myPanel.removeAll();
					myPanel.add(new JLabel("Premium Club fee: 999 TL, "
							+ "Do you want to continue?"));
					result = JOptionPane.showConfirmDialog(null, myPanel, "Information",
							JOptionPane.YES_NO_OPTION);
					
						if(result == 0) {
							myPanel.removeAll();
							myPanel.add(new JLabel("Money withdrawn from your wallet"));
							JOptionPane.showInternalMessageDialog(null, myPanel, "Information",
									JOptionPane.INFORMATION_MESSAGE);
						}
				}
			}
		});
		btnPremiumClub.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnPremiumClub.setBackground(new Color(72, 99, 168));
		btnPremiumClub.setBounds(83, 139, 255, 59);
		panel.add(btnPremiumClub);
		
		JButton btnMyProfile = new JButton("My Profile");
		btnMyProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassengerProfile userprofile = new PassengerProfile(manager,passenger);
				userprofile.setVisible(true);
				setVisible(false);
			}
		});
		btnMyProfile.setFont(new Font("Arial Black", Font.BOLD, 15));
		btnMyProfile.setBackground(new Color(72, 99, 168));
		btnMyProfile.setBounds(83, 231, 255, 59);
		panel.add(btnMyProfile);

	}
}
