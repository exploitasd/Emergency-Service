package project;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class MainMenuFrame {	//tamam

	public void createMainGUI() {

		final JFrame mainFrame = new JFrame("Main Menu");

		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.LIGHT_GRAY);
		mainPanel.setLayout(null);

		JLabel imageLabel = new JLabel(new ImageIcon("image.gif"));
		imageLabel.setBounds(-50, -65, 300, 300);
		mainPanel.add(imageLabel);

		JLabel lineLabel = new JLabel() {
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				g.drawLine(30, 50, 30, 280);
			}
		};
		lineLabel.setBounds(170, -40, 100, 380);
		mainPanel.add(lineLabel);

		JLabel titleLabel = new JLabel("Emergency Service Database");
		titleLabel.setBounds(230, 0, 500, 50);
		titleLabel.setFont(new Font("e", Font.BOLD, 15));
		mainPanel.add(titleLabel);

		JLabel helpLabel = new JLabel("help");
		helpLabel.setBounds(430, 230, 45, 15);
		helpLabel.setFont(new Font("h", Font.BOLD, 13));
		helpLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpLabel.setForeground(Color.BLUE);
		mainPanel.add(helpLabel);

		helpLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().open(new File("C:/Final_Report.pdf"));
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

		final JButton eventButton = new JButton("Event Informations");
		eventButton.setBounds(250, 70, 160, 25);
		eventButton.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(eventButton);
		eventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainFrame.setVisible(false);
				EventInformationsFrame eventWindow = new EventInformationsFrame();
				try {
					eventWindow.createEventGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		final JButton organisationButton = new JButton("Organisation Informations");
		organisationButton.setBounds(250, 100, 160, 25);
		organisationButton.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(organisationButton);
		organisationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrganisationInformationsFrame organisationWindow = new OrganisationInformationsFrame();
				try {
					organisationWindow.createOrganisationGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		final JButton peopleButton = new JButton("People Informations");
		peopleButton.setBounds(250, 130, 160, 25);
		peopleButton.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(peopleButton);
		peopleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleInformationsFrame peopleWindow = new PeopleInformationsFrame();
				try {
					peopleWindow.createPeopleGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		final JButton vehicleButton = new JButton("Vehicle Informations");
		vehicleButton.setBounds(250, 160, 160, 25);
		vehicleButton.setBackground(Color.LIGHT_GRAY);
		mainPanel.add(vehicleButton);
		vehicleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehicleInformationsFrame vehicleWindow = new VehicleInformationsFrame();
				try {
					vehicleWindow.createVehicleGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		mainFrame.add(mainPanel);
		mainFrame.setVisible(true);
		mainFrame.setSize(470, 280);
		mainFrame.setLocation(430, 150);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
