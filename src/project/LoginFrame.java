package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginFrame {	//tamam
	public void createLoginGui() {
		final JFrame loginFrame = new JFrame("Login");

		JPanel loginPanel = new JPanel();
		loginPanel.setBackground(Color.LIGHT_GRAY);
		loginPanel.setLayout(null);

		JLabel userNameLabel = new JLabel("Username:");
		userNameLabel.setBounds(10, 35, 90, 20);
		loginPanel.add(userNameLabel);

		JTextField userNameField = new JTextField();
		userNameField.setBounds(90, 35, 100, 20);
		loginPanel.add(userNameField);

		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(10, 75, 70, 20);
		loginPanel.add(passwordLabel);

		JPasswordField passwordField = new JPasswordField();
		passwordField.setBounds(90, 75, 100, 20);
		loginPanel.add(passwordField);

		JButton loginButton = new JButton("LOGIN");
		loginButton.setBackground(Color.LIGHT_GRAY);
		loginButton.setBounds(10, 115, 80, 25);
		loginPanel.add(loginButton);
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectionDB.connectDB();
				
				loginFrame.setVisible(false);

				MainMenuFrame menu = new MainMenuFrame();
				menu.createMainGUI();
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(110, 115, 80, 25);
		loginPanel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		JLabel registerLabel = new JLabel("Register");
		registerLabel.setBounds(153, 5, 50, 15);
		registerLabel.setFont(new Font("h", Font.BOLD, 12));
		registerLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		registerLabel.setForeground(Color.BLUE);
		loginPanel.add(registerLabel);

		registerLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				loginFrame.setVisible(false);

				new RegistrationFrame().createRegisterGui();
			}
		});

		loginFrame.add(loginPanel);
		loginFrame.setVisible(true);
		loginFrame.setSize(210, 195);
		loginFrame.setLocation(570, 220);
		loginFrame.setResizable(false);
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
