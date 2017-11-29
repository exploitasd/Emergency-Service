package project;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class EventOperations { // tamam
	JTable outcomesTable;
	JTable statusTable;
	JTable eventTypesTable;

	private EventInformationsFrame parentFrame;

	public EventOperations(EventInformationsFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void createAddEventGUI() throws SQLException {

		final JFrame frame = new JFrame("Add Event");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel eventNameLabel = new JLabel("Event Name:");
		eventNameLabel.setBounds(20, 20, 100, 20);
		panel.add(eventNameLabel);

		final JTextField eventNameField = new JTextField();
		eventNameField.setBounds(115, 20, 100, 20);
		panel.add(eventNameField);

		JLabel eventFromDateLabel = new JLabel("Event From Date:");
		eventFromDateLabel.setBounds(20, 70, 100, 20);
		panel.add(eventFromDateLabel);

		final JTextField eventFromDateField = new JTextField();
		eventFromDateField.setBounds(115, 70, 100, 20);
		panel.add(eventFromDateField);

		JLabel eventToDateLabel = new JLabel("Event To Date:");
		eventToDateLabel.setBounds(20, 120, 100, 20);
		panel.add(eventToDateLabel);

		final JTextField eventToDateField = new JTextField();
		eventToDateField.setBounds(115, 120, 100, 20);
		panel.add(eventToDateField);

		JLabel eventResultLabel = new JLabel("Event Result:");
		eventResultLabel.setBounds(20, 170, 100, 20);
		panel.add(eventResultLabel);

		final JTextField eventResultField = new JTextField();
		eventResultField.setBounds(115, 170, 100, 20);
		panel.add(eventResultField);

		JLabel eventStreetLabel = new JLabel("Street:");
		eventStreetLabel.setBounds(280, 20, 100, 20);
		panel.add(eventStreetLabel);

		final JTextField eventStreetField = new JTextField();
		eventStreetField.setBounds(330, 20, 100, 20);
		panel.add(eventStreetField);

		JLabel eventLocalityLabel = new JLabel("Locality:");
		eventLocalityLabel.setBounds(280, 70, 100, 20);
		panel.add(eventLocalityLabel);

		final JTextField eventLocalityField = new JTextField();
		eventLocalityField.setBounds(330, 70, 100, 20);
		panel.add(eventLocalityField);

		JLabel eventStateLabel = new JLabel("State:");
		eventStateLabel.setBounds(280, 120, 100, 20);
		panel.add(eventStateLabel);

		final JTextField eventStateField = new JTextField();
		eventStateField.setBounds(330, 120, 100, 20);
		panel.add(eventStateField);

		JLabel eventCityLabel = new JLabel("City:");
		eventCityLabel.setBounds(280, 170, 100, 20);
		panel.add(eventCityLabel);

		final JTextField eventCityField = new JTextField();
		eventCityField.setBounds(330, 170, 100, 20);
		panel.add(eventCityField);

		JLabel eventCountryLabel = new JLabel("Country:");
		eventCountryLabel.setBounds(280, 220, 100, 20);
		panel.add(eventCountryLabel);

		final JTextField eventCountryField = new JTextField();
		eventCountryField.setBounds(330, 220, 100, 20);
		panel.add(eventCountryField);

		JLabel eventDescLabel = new JLabel("Event Description:");
		eventDescLabel.setBounds(280, 260, 150, 20);
		panel.add(eventDescLabel);

		final JTextArea eventDescTextArea = new JTextArea();
		JScrollPane eventDescScroll = new JScrollPane(eventDescTextArea);
		eventDescScroll.setBounds(280, 280, 160, 50);
		panel.add(eventDescScroll);

		JLabel eventOtherDetailsLabel = new JLabel("Other Details:");
		eventOtherDetailsLabel.setBounds(280, 340, 100, 20);
		panel.add(eventOtherDetailsLabel);

		final JTextArea eventOtherDetailsTextArea = new JTextArea();
		JScrollPane eventOtherDetailsScroll = new JScrollPane(
				eventOtherDetailsTextArea);
		eventOtherDetailsScroll.setBounds(280, 360, 160, 50);
		panel.add(eventOtherDetailsScroll);

		JLabel eventOutcomeCodeLabel = new JLabel("Event Outcome:");
		eventOutcomeCodeLabel.setBounds(20, 260, 100, 20);
		panel.add(eventOutcomeCodeLabel);

		initOutcomesTable();
		final JComboBox eventOutcomeCombobox = new JComboBox();
		eventOutcomeCombobox.setBounds(115, 260, 150, 20);
		for (int i = 0; i < outcomesTable.getRowCount(); i++)
			eventOutcomeCombobox.addItem(outcomesTable.getValueAt(i, 1));
		eventOutcomeCombobox.setSelectedItem(null);
		panel.add(eventOutcomeCombobox);

		JLabel eventStatusCodeLabel = new JLabel("Event Status:");
		eventStatusCodeLabel.setBounds(20, 310, 100, 20);
		panel.add(eventStatusCodeLabel);

		initStatusTable();
		final JComboBox eventStatusCombobox = new JComboBox();
		eventStatusCombobox.setBounds(115, 310, 150, 20);
		for (int i = 0; i < statusTable.getRowCount(); i++)
			eventStatusCombobox.addItem(statusTable.getValueAt(i, 1));
		eventStatusCombobox.setSelectedItem(null);
		panel.add(eventStatusCombobox);

		JLabel eventTypeCodeLabel = new JLabel("Event Type:");
		eventTypeCodeLabel.setBounds(20, 360, 100, 20);
		panel.add(eventTypeCodeLabel);

		initEventTypesTable();
		final JComboBox eventTypesCombobox = new JComboBox();
		eventTypesCombobox.setBounds(115, 360, 150, 20);
		for (int i = 0; i < eventTypesTable.getRowCount(); i++)
			eventTypesCombobox.addItem(eventTypesTable.getValueAt(i, 1));
		eventTypesCombobox.setSelectedItem(null);
		panel.add(eventTypesCombobox);

		JButton addButton = new JButton("ADD");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(100, 450, 80, 25);
		panel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {

					boolean from_date_flag;
					boolean to_date_flag;

					from_date_flag = dateChecking(eventFromDateField.getText());
					to_date_flag = dateChecking(eventToDateField.getText());

					String sql = "";

					sql = "INSERT INTO events (Event_Name, Event_From_Date, Event_To_Date, Event_Result, Street,Locality, State, "
							+ "City, Country, Event_Description, Other_Details, Outcome_Code, Status_Code, Type_Code) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

					java.sql.PreparedStatement pstmt = ConnectionDB.connectDB()
							.prepareStatement((sql));

					pstmt.setString(1, eventNameField.getText());
					pstmt.setString(2, eventFromDateField.getText());
					pstmt.setString(3, eventToDateField.getText());
					pstmt.setString(4, eventResultField.getText());
					pstmt.setString(5, eventStreetField.getText());
					pstmt.setString(6, eventLocalityField.getText());
					pstmt.setString(7, eventStateField.getText());
					pstmt.setString(8, eventCityField.getText());
					pstmt.setString(9, eventCountryField.getText());
					pstmt.setString(10, eventDescTextArea.getText());
					pstmt.setString(11, eventOtherDetailsTextArea.getText());
					pstmt.setInt(
							12,
							(int) outcomesTable.getValueAt(
									eventOutcomeCombobox.getSelectedIndex(), 0));
					pstmt.setInt(
							13,
							(int) statusTable.getValueAt(
									eventStatusCombobox.getSelectedIndex(), 0));
					pstmt.setInt(
							14,
							(int) eventTypesTable.getValueAt(
									eventTypesCombobox.getSelectedIndex(), 0));

					if (from_date_flag && to_date_flag) {
						pstmt.executeUpdate();
						parentFrame.updateEventTable();
					}

					else {
						JOptionPane.showMessageDialog(frame,
								"Please check your dates again");
					}

					frame.setVisible(!(from_date_flag && to_date_flag));

				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(frame,
							"Please check your dates again");
				}
			}
		});

		JButton clearButton = new JButton("CLEAR");
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setBounds(200, 450, 80, 25);
		panel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eventNameField.setText(null);
				eventFromDateField.setText(null);
				eventToDateField.setText(null);
				eventResultField.setText(null);
				eventStreetField.setText(null);
				eventLocalityField.setText(null);
				eventStateField.setText(null);
				eventCityField.setText(null);
				eventCountryField.setText(null);
				eventDescTextArea.setText(null);
				eventOtherDetailsTextArea.setText(null);
				eventOutcomeCombobox.setSelectedItem(null);
				eventStatusCombobox.setSelectedItem(null);
				eventTypesCombobox.setSelectedItem(null);
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(300, 450, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(480, 520);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void createUpdateEventGUI() throws SQLException {

		final JFrame frame = new JFrame("Update Event");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel eventNameLabel = new JLabel("Event Name:");
		eventNameLabel.setBounds(20, 20, 100, 20);
		panel.add(eventNameLabel);

		final JTextField eventNameField = new JTextField();
		eventNameField.setBounds(115, 20, 100, 20);
		panel.add(eventNameField);

		JLabel eventFromDateLabel = new JLabel("Event From Date:");
		eventFromDateLabel.setBounds(20, 70, 100, 20);
		panel.add(eventFromDateLabel);

		final JTextField eventFromDateField = new JTextField();
		eventFromDateField.setBounds(115, 70, 100, 20);
		panel.add(eventFromDateField);

		JLabel eventToDateLabel = new JLabel("Event To Date:");
		eventToDateLabel.setBounds(20, 120, 100, 20);
		panel.add(eventToDateLabel);

		final JTextField eventToDateField = new JTextField();
		eventToDateField.setBounds(115, 120, 100, 20);
		panel.add(eventToDateField);

		JLabel eventResultLabel = new JLabel("Event Result:");
		eventResultLabel.setBounds(20, 170, 100, 20);
		panel.add(eventResultLabel);

		final JTextField eventResultField = new JTextField();
		eventResultField.setBounds(115, 170, 100, 20);
		panel.add(eventResultField);

		JLabel eventStreetLabel = new JLabel("Street:");
		eventStreetLabel.setBounds(280, 20, 100, 20);
		panel.add(eventStreetLabel);

		final JTextField eventStreetField = new JTextField();
		eventStreetField.setBounds(330, 20, 100, 20);
		panel.add(eventStreetField);

		JLabel eventLocalityLabel = new JLabel("Locality:");
		eventLocalityLabel.setBounds(280, 70, 100, 20);
		panel.add(eventLocalityLabel);

		final JTextField eventLocalityField = new JTextField();
		eventLocalityField.setBounds(330, 70, 100, 20);
		panel.add(eventLocalityField);

		JLabel eventStateLabel = new JLabel("State:");
		eventStateLabel.setBounds(280, 120, 100, 20);
		panel.add(eventStateLabel);

		final JTextField eventStateField = new JTextField();
		eventStateField.setBounds(330, 120, 100, 20);
		panel.add(eventStateField);

		JLabel eventCityLabel = new JLabel("City:");
		eventCityLabel.setBounds(280, 170, 100, 20);
		panel.add(eventCityLabel);

		final JTextField eventCityField = new JTextField();
		eventCityField.setBounds(330, 170, 100, 20);
		panel.add(eventCityField);

		JLabel eventCountryLabel = new JLabel("Country:");
		eventCountryLabel.setBounds(280, 220, 100, 20);
		panel.add(eventCountryLabel);

		final JTextField eventCountryField = new JTextField();
		eventCountryField.setBounds(330, 220, 100, 20);
		panel.add(eventCountryField);

		JLabel eventDescLabel = new JLabel("Event Description:");
		eventDescLabel.setBounds(280, 260, 150, 20);
		panel.add(eventDescLabel);

		final JTextArea eventDescTextArea = new JTextArea();
		JScrollPane eventDescScroll = new JScrollPane(eventDescTextArea);
		eventDescScroll.setBounds(280, 280, 160, 50);
		panel.add(eventDescScroll);

		JLabel eventOtherDetailsLabel = new JLabel("Other Details:");
		eventOtherDetailsLabel.setBounds(280, 340, 100, 20);
		panel.add(eventOtherDetailsLabel);

		final JTextArea eventOtherDetailsTextArea = new JTextArea();
		JScrollPane eventOtherDetailsScroll = new JScrollPane(
				eventOtherDetailsTextArea);
		eventOtherDetailsScroll.setBounds(280, 360, 160, 50);
		panel.add(eventOtherDetailsScroll);

		JLabel eventOutcomeLabel = new JLabel("Event Outcome:");
		eventOutcomeLabel.setBounds(20, 260, 100, 20);
		panel.add(eventOutcomeLabel);

		initOutcomesTable();
		final JComboBox eventOutcomeCombobox = new JComboBox();
		eventOutcomeCombobox.setBounds(115, 260, 150, 20);
		for (int i = 0; i < outcomesTable.getRowCount(); i++)
			eventOutcomeCombobox.addItem(outcomesTable.getValueAt(i, 1));
		panel.add(eventOutcomeCombobox);

		JLabel eventStatusLabel = new JLabel("Event Status:");
		eventStatusLabel.setBounds(20, 310, 100, 20);
		panel.add(eventStatusLabel);

		initStatusTable();
		final JComboBox eventStatusCombobox = new JComboBox();
		eventStatusCombobox.setBounds(115, 310, 150, 20);
		for (int i = 0; i < statusTable.getRowCount(); i++)
			eventStatusCombobox.addItem(statusTable.getValueAt(i, 1));
		panel.add(eventStatusCombobox);

		JLabel eventTypeLabel = new JLabel("Event Type:");
		eventTypeLabel.setBounds(20, 360, 100, 20);
		panel.add(eventTypeLabel);

		initEventTypesTable();
		final JComboBox eventTypesCombobox = new JComboBox();
		eventTypesCombobox.setBounds(115, 360, 150, 20);
		for (int i = 0; i < eventTypesTable.getRowCount(); i++)
			eventTypesCombobox.addItem(eventTypesTable.getValueAt(i, 1));
		panel.add(eventTypesCombobox);

		boolean flag = true;

		try {
			for (int i = 0; i < EventInformationsFrame.eventTable
					.getColumnCount(); i++) {
				if (i == 1)
					eventNameField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 2)
					eventFromDateField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 3)
					eventToDateField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 4)
					eventResultField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 5)
					eventStreetField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 6) {
					eventLocalityField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				}

				else if (i == 7)
					eventStateField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));

				else if (i == 8)
					eventCityField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 9)
					eventCountryField.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 10)
					eventDescTextArea.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 11)
					eventOtherDetailsTextArea.setText(""
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), i));
				else if (i == 12) {
					for (int j = 0; j < outcomesTable.getRowCount(); j++) {
						if ((outcomesTable.getValueAt(j, 0)) == (EventInformationsFrame.eventTable
								.getValueAt(EventInformationsFrame.eventTable
										.getSelectedRow(), i)))
							eventOutcomeCombobox.setSelectedIndex(j);
					}

				} else if (i == 13) {
					for (int j = 0; j < statusTable.getRowCount(); j++) {
						if ((statusTable.getValueAt(j, 0)) == (EventInformationsFrame.eventTable
								.getValueAt(EventInformationsFrame.eventTable
										.getSelectedRow(), i)))
							eventStatusCombobox.setSelectedIndex(j);
					}
				}

				else if (i == 14) {
					for (int j = 0; j < eventTypesTable.getRowCount(); j++) {
						if ((eventTypesTable.getValueAt(j, 0)) == (EventInformationsFrame.eventTable
								.getValueAt(EventInformationsFrame.eventTable
										.getSelectedRow(), i)))
							eventTypesCombobox.setSelectedIndex(j);
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(frame,
					"Please select a row for update.");
			flag = false;
		}

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.setBounds(20, 450, 80, 25);
		panel.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {

					String s1 = eventNameField.getText();
					String s2 = eventFromDateField.getText();
					String s3 = eventToDateField.getText();
					String s4 = eventResultField.getText();
					String s5 = eventStreetField.getText();
					String s6 = eventLocalityField.getText();
					String s7 = eventStateField.getText();
					String s8 = eventCityField.getText();
					String s9 = eventCountryField.getText();
					String s10 = eventDescTextArea.getText();
					String s11 = eventOtherDetailsTextArea.getText();
					int s12 = eventOutcomeCombobox.getSelectedIndex() + 10;
					int s13 = eventStatusCombobox.getSelectedIndex() + 10;
					int s14 = eventTypesCombobox.getSelectedIndex() + 10;

					if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							1) != eventNameField.getText()) {
						s1 = eventNameField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							2) != eventFromDateField.getText()) {
						s2 = eventFromDateField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							3) != eventToDateField.getText()) {
						s3 = eventToDateField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							4) != eventResultField.getText()) {
						s4 = eventResultField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							5) != eventStreetField.getText()) {
						s5 = eventStreetField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							6) != eventLocalityField.getText()) {
						s6 = eventLocalityField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							7) != eventStateField.getText()) {
						s7 = eventStateField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							8) != eventCityField.getText()) {
						s8 = eventCityField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							9) != eventCountryField.getText()) {
						s9 = eventCountryField.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							10) != eventDescTextArea.getText()) {
						s10 = eventDescTextArea.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							11) != eventOtherDetailsTextArea.getText()) {
						s11 = eventOtherDetailsTextArea.getText();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							12) != eventOutcomeCombobox.getSelectedItem()) {
						s12 = eventOutcomeCombobox.getSelectedIndex();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							13) != eventStatusCombobox.getSelectedItem()) {
						s13 = eventStatusCombobox.getSelectedIndex();
					} else if (EventInformationsFrame.eventTable.getValueAt(
							EventInformationsFrame.eventTable.getSelectedRow(),
							14) != eventTypesCombobox.getSelectedItem()) {
						s14 = eventTypesCombobox.getSelectedIndex();
					}

					String sql = "";

					sql = "UPDATE events SET Event_Name='"
							+ s1
							+ "', "
							+ "Event_From_Date='"
							+ s2
							+ "', "
							+ "Event_To_Date='"
							+ s3
							+ "', "
							+ "Event_Result='"
							+ s4
							+ "', "
							+ "Street='"
							+ s5
							+ "', "
							+ "Locality='"
							+ s6
							+ "', "
							+ "State='"
							+ s7
							+ "', "
							+ "City='"
							+ s8
							+ "', "
							+ "Country='"
							+ s9
							+ "', "
							+ "Event_Description='"
							+ s10
							+ "', "
							+ "Other_Details='"
							+ s11
							+ "', "
							+ "Outcome_Code='"
							+ s12
							+ "', "
							+ "Status_Code='"
							+ s13
							+ "', "
							+ "Type_Code='"
							+ s14
							+ "'"
							+ " WHERE "
							+ EventInformationsFrame.eventTable
									.getColumnName(0)
							+ "='"
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), 0) + "'";

					java.sql.Statement stmt = ConnectionDB.connectDB()
							.createStatement();

					stmt.executeUpdate(sql);
					parentFrame.updateEventTable();
					frame.setVisible(false);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(120, 450, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(flag);
		frame.setSize(480, 520);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void createEventOutcomesGUI() throws SQLException {
		JFrame frame = new JFrame("Event Outcomes");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initOutcomesTable();

		JScrollPane tableScroll = new JScrollPane(outcomesTable);
		tableScroll.setBounds(10, 10, 400, 400);

		outcomesTable.getTableHeader().setReorderingAllowed(false);
		outcomesTable.getTableHeader().setResizingAllowed(false);

		JButton addOutcomesButton = new JButton("ADD");
		addOutcomesButton.setBackground(Color.LIGHT_GRAY);
		addOutcomesButton.setBounds(10, 430, 80, 25);
		panel.add(addOutcomesButton);

		JButton removeOutcomesButton = new JButton("REMOVE");
		removeOutcomesButton.setBackground(Color.LIGHT_GRAY);
		removeOutcomesButton.setBounds(110, 430, 80, 25);
		panel.add(removeOutcomesButton);

		JButton updateOutcomesButton = new JButton("UPDATE");
		updateOutcomesButton.setBackground(Color.LIGHT_GRAY);
		updateOutcomesButton.setBounds(210, 430, 80, 25);
		panel.add(updateOutcomesButton);

		panel.add(tableScroll);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(440, 510);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void initOutcomesTable() throws SQLException {
		outcomesTable = new JTable(getOutcomesDataModel()) {
			private static final long serialVersionUID = 1L;

			public String getToolTipText(MouseEvent e) {

				int row = rowAtPoint(e.getPoint());
				int column = columnAtPoint(e.getPoint());

				Object value = getValueAt(row, column);
				if (value == null)
					return null;
				else
					return value.toString();
			}
		};
	}

	public void updateOutcomesTable() throws SQLException {
		outcomesTable.setModel(getOutcomesDataModel());
	}

	private DefaultTableModel getOutcomesDataModel() throws SQLException {
		String selectQuery = "select * from event_outcomes ;";

		Statement stmt = ConnectionDB.connectDB().createStatement();

		ResultSet rs = stmt.executeQuery(selectQuery);

		java.sql.ResultSetMetaData metaData = rs.getMetaData();

		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);
	}

	public void createEventStatusGUI() throws SQLException {
		JFrame frame = new JFrame("Event Status");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initStatusTable();

		JScrollPane tableScroll = new JScrollPane(statusTable);
		tableScroll.setBounds(10, 10, 400, 400);

		statusTable.getTableHeader().setReorderingAllowed(false);
		statusTable.getTableHeader().setResizingAllowed(false);

		JButton addStatusButton = new JButton("ADD");
		addStatusButton.setBackground(Color.LIGHT_GRAY);
		addStatusButton.setBounds(10, 430, 80, 25);
		panel.add(addStatusButton);

		JButton removeStatusButton = new JButton("REMOVE");
		removeStatusButton.setBackground(Color.LIGHT_GRAY);
		removeStatusButton.setBounds(110, 430, 80, 25);
		panel.add(removeStatusButton);

		JButton updateStatusButton = new JButton("UPDATE");
		updateStatusButton.setBackground(Color.LIGHT_GRAY);
		updateStatusButton.setBounds(210, 430, 80, 25);
		panel.add(updateStatusButton);

		panel.add(tableScroll);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(440, 510);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	public void initStatusTable() throws SQLException {
		statusTable = new JTable(getStatusDataModel()) {
			private static final long serialVersionUID = 1L;

			public String getToolTipText(MouseEvent e) {

				int row = rowAtPoint(e.getPoint());
				int column = columnAtPoint(e.getPoint());

				Object value = getValueAt(row, column);
				if (value == null)
					return null;
				else
					return value.toString();
			}
		};
	}

	public void updateStatusTable() throws SQLException {
		statusTable.setModel(getStatusDataModel());
	}

	private DefaultTableModel getStatusDataModel() throws SQLException {
		String selectQuery = "select * from event_status ;";

		Statement stmt = ConnectionDB.connectDB().createStatement();

		ResultSet rs = stmt.executeQuery(selectQuery);

		java.sql.ResultSetMetaData metaData = rs.getMetaData();

		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();
		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();
			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);
	}

	public void createEventTypesGUI() throws SQLException {
		JFrame frame = new JFrame("Event Types");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initEventTypesTable();

		JScrollPane tableScroll = new JScrollPane(eventTypesTable);
		tableScroll.setBounds(10, 10, 400, 400);

		eventTypesTable.getTableHeader().setReorderingAllowed(false);
		eventTypesTable.getTableHeader().setResizingAllowed(false);

		JButton addTypesButton = new JButton("ADD");
		addTypesButton.setBackground(Color.LIGHT_GRAY);
		addTypesButton.setBounds(10, 430, 80, 25);
		panel.add(addTypesButton);

		JButton removeTypesButton = new JButton("REMOVE");
		removeTypesButton.setBackground(Color.LIGHT_GRAY);
		removeTypesButton.setBounds(110, 430, 80, 25);
		panel.add(removeTypesButton);

		JButton updateTypesButton = new JButton("UPDATE");
		updateTypesButton.setBackground(Color.LIGHT_GRAY);
		updateTypesButton.setBounds(210, 430, 80, 25);
		panel.add(updateTypesButton);

		panel.add(tableScroll);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(440, 510);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void initEventTypesTable() throws SQLException {
		eventTypesTable = new JTable(getEventTypesDataModel()) {
			private static final long serialVersionUID = 1L;

			public String getToolTipText(MouseEvent e) {
				int row = rowAtPoint(e.getPoint());
				int column = columnAtPoint(e.getPoint());

				Object value = getValueAt(row, column);
				if (value == null)
					return null;
				else
					return value.toString();
			}
		};
	}

	public void updateEventTypesTable() throws SQLException {
		eventTypesTable.setModel(getEventTypesDataModel());
	}

	private DefaultTableModel getEventTypesDataModel() throws SQLException {
		String selectQuery = "select * from event_types ;";

		Statement stmt = ConnectionDB.connectDB().createStatement();

		ResultSet rs = stmt.executeQuery(selectQuery);

		java.sql.ResultSetMetaData metaData = rs.getMetaData();

		Vector<String> columnNames = new Vector<String>();
		int columnCount = metaData.getColumnCount();

		for (int column = 1; column <= columnCount; column++) {
			columnNames.add(metaData.getColumnName(column));
		}

		Vector<Vector<Object>> data = new Vector<Vector<Object>>();

		while (rs.next()) {
			Vector<Object> vector = new Vector<Object>();

			for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
				vector.add(rs.getObject(columnIndex));
			}
			data.add(vector);
		}

		return new DefaultTableModel(data, columnNames);
	}

	public boolean dateChecking(String d) {

		String date = d;

		if (date.equals(null))
			return false;

		String[] parts = date.split("-");

		String year = parts[0];
		String month = parts[1];
		String day = parts[2];

		if (year.length() != 4)
			return false;
		else if (month.length() != 2)
			return false;
		else if (day.length() != 2)
			return false;
		else if (!(0 < Integer.parseInt(month) && Integer.parseInt(month) < 13))
			return false;
		else if (!(0 < Integer.parseInt(day) && Integer.parseInt(day) < 31))
			return false;
		else
			return true;
	}

}
