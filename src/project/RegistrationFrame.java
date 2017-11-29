package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RegistrationFrame {	//tamam
	public void createRegisterGui() {
		final JFrame registerFrame = new JFrame("Register");

		registerFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				registerFrame.setVisible(false);
				new LoginFrame().createLoginGui();
			}
		});

		JPanel registerPanel = new JPanel();
		registerPanel.setBackground(Color.LIGHT_GRAY);
		registerPanel.setLayout(null);

		JLabel titleLabel = new JLabel("Registration Form");
		titleLabel.setBounds(175, 0, 150, 50);
		titleLabel.setFont(new Font("e", Font.BOLD, 15));
		titleLabel.setForeground(Color.BLUE);
		registerPanel.add(titleLabel);

		JLabel userNameLabel = new JLabel("Username:");
		userNameLabel.setBounds(10, 50, 90, 20);
		registerPanel.add(userNameLabel);

		final JTextField userNameField = new JTextField();
		userNameField.setBounds(120, 50, 100, 20);
		registerPanel.add(userNameField);

		JLabel accountInformLabel = new JLabel(
				"* Username must not contain symbols");
		accountInformLabel.setBounds(230, 50, 250, 20);
		registerPanel.add(accountInformLabel);

		JLabel createPasswordLabel = new JLabel("Create Password:");
		createPasswordLabel.setBounds(10, 90, 100, 20);
		registerPanel.add(createPasswordLabel);

		final JPasswordField createPasswordField = new JPasswordField();
		createPasswordField.setBounds(120, 90, 100, 20);
		registerPanel.add(createPasswordField);

		JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
		confirmPasswordLabel.setBounds(10, 130, 100, 20);
		registerPanel.add(confirmPasswordLabel);

		final JPasswordField confirmPasswordField = new JPasswordField();
		confirmPasswordField.setBounds(120, 130, 100, 20);
		registerPanel.add(confirmPasswordField);

		JLabel passInformLabel = new JLabel(
				"* Password must contain at least 8 characters");
		passInformLabel.setBounds(230, 90, 250, 20);
		registerPanel.add(passInformLabel);

		JButton submitButton = new JButton("SUBMIT");
		submitButton.setBackground(Color.LIGHT_GRAY);
		submitButton.setBounds(10, 180, 80, 25);
		registerPanel.add(submitButton);

		submitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});

		JButton clearButton = new JButton("CLEAR");
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setBounds(150, 180, 80, 25);
		registerPanel.add(clearButton);

		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				userNameField.setText(null);
				createPasswordField.setText(null);
				confirmPasswordField.setText(null);
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(290, 180, 80, 25);
		registerPanel.add(cancelButton);

		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				registerFrame.setVisible(false);
				new LoginFrame().createLoginGui();
			}
		});

		registerFrame.add(registerPanel);
		registerFrame.setVisible(true);
		registerFrame.setSize(465, 250);
		registerFrame.setLocation(460, 200);
		registerFrame.setResizable(false);

	}
}
