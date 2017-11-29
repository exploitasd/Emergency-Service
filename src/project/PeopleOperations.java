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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class PeopleOperations {	//tamam
	JTable rolesTable;
	JTable worksForTable;
	JTable inEventTable;

	private PeopleInformationsFrame parentFrame;

	public PeopleOperations(PeopleInformationsFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void createAddPeopleGUI() {

		final JFrame frame = new JFrame("Add People");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(20, 20, 100, 20);
		panel.add(firstNameLabel);

		final JTextField firstNameField = new JTextField();
		firstNameField.setBounds(115, 20, 100, 20);
		panel.add(firstNameField);

		JLabel middleNameLabel = new JLabel("Middle Name:");
		middleNameLabel.setBounds(20, 70, 100, 20);
		panel.add(middleNameLabel);

		final JTextField middleNameField = new JTextField();
		middleNameField.setBounds(115, 70, 100, 20);
		panel.add(middleNameField);

		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(20, 120, 100, 20);
		panel.add(lastNameLabel);

		final JTextField lastNameField = new JTextField();
		lastNameField.setBounds(115, 120, 100, 20);
		panel.add(lastNameField);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setBounds(20, 170, 100, 20);
		panel.add(genderLabel);

		final JTextField genderField = new JTextField();
		genderField.setBounds(115, 170, 100, 20);
		panel.add(genderField);

		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthLabel.setBounds(20, 220, 100, 20);
		panel.add(dateOfBirthLabel);

		final JTextField dateOfBirthField = new JTextField();
		dateOfBirthField.setBounds(115, 220, 100, 20);
		panel.add(dateOfBirthField);

		JLabel peopleStreetLabel = new JLabel("Street:");
		peopleStreetLabel.setBounds(280, 20, 100, 20);
		panel.add(peopleStreetLabel);

		final JTextField peopleStreetField = new JTextField();
		peopleStreetField.setBounds(330, 20, 100, 20);
		panel.add(peopleStreetField);

		JLabel peopleLocalityLabel = new JLabel("Locality:");
		peopleLocalityLabel.setBounds(280, 70, 100, 20);
		panel.add(peopleLocalityLabel);

		final JTextField peopleLocalityField = new JTextField();
		peopleLocalityField.setBounds(330, 70, 100, 20);
		panel.add(peopleLocalityField);

		JLabel peopleStateLabel = new JLabel("State:");
		peopleStateLabel.setBounds(280, 120, 100, 20);
		panel.add(peopleStateLabel);

		final JTextField peopleStateField = new JTextField();
		peopleStateField.setBounds(330, 120, 100, 20);
		panel.add(peopleStateField);

		JLabel peopleCityLabel = new JLabel("City:");
		peopleCityLabel.setBounds(280, 170, 100, 20);
		panel.add(peopleCityLabel);

		final JTextField peopleCityField = new JTextField();
		peopleCityField.setBounds(330, 170, 100, 20);
		panel.add(peopleCityField);

		JLabel peopleCountryLabel = new JLabel("Country:");
		peopleCountryLabel.setBounds(280, 220, 100, 20);
		panel.add(peopleCountryLabel);

		final JTextField peopleCountryField = new JTextField();
		peopleCountryField.setBounds(330, 220, 100, 20);
		panel.add(peopleCountryField);

		JLabel peopleOtherDetailsLabel = new JLabel("Other Details:");
		peopleOtherDetailsLabel.setBounds(280, 260, 100, 20);
		panel.add(peopleOtherDetailsLabel);

		final JTextArea peopleOtherDetailsTextArea = new JTextArea();
		JScrollPane peopleOtherDetailsScroll = new JScrollPane(
				peopleOtherDetailsTextArea);
		peopleOtherDetailsScroll.setBounds(280, 280, 160, 50);
		panel.add(peopleOtherDetailsScroll);

		JButton addButton = new JButton("ADD");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(100, 370, 80, 25);
		panel.add(addButton);
		/*
		 * addButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { try {
		 * java.sql.Statement stmt1 = ConnectionDB.connectDB()
		 * .createStatement(); String sql; sql = "INSERT INTO events " +
		 * "VALUES (3, 'crime at 312', '2011-03-11', '2011-03-12', 'not found', 'street 7', 'locality13', 'istanbul', 'turkiye', '0 death', 'other details33', '115', '120', '300')"
		 * ;
		 * 
		 * 
		 * sql = "INSERT INTO events VALUES(" + eventIDField.getText() + "," +
		 * "'" + eventNameField.getText() + "'";
		 * 
		 * stmt1.executeUpdate(sql); parentFrame.updateEventTable(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } } });
		 */

		JButton clearButton = new JButton("CLEAR");
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setBounds(200, 370, 80, 25);
		panel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				firstNameField.setText(null);
				middleNameField.setText(null);
				lastNameField.setText(null);
				genderField.setText(null);
				dateOfBirthField.setText(null);
				peopleStreetField.setText(null);
				peopleLocalityField.setText(null);
				peopleStateField.setText(null);
				peopleCityField.setText(null);
				peopleCountryField.setText(null);
				peopleOtherDetailsTextArea.setText(null);
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(300, 370, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(480, 440);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void createUpdatePeopleGUI() {
		final JFrame frame = new JFrame("Update People");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel firstNameLabel = new JLabel("First Name:");
		firstNameLabel.setBounds(20, 20, 100, 20);
		panel.add(firstNameLabel);

		final JTextField firstNameField = new JTextField();
		firstNameField.setBounds(115, 20, 100, 20);
		panel.add(firstNameField);

		JLabel middleNameLabel = new JLabel("Middle Name:");
		middleNameLabel.setBounds(20, 70, 100, 20);
		panel.add(middleNameLabel);

		final JTextField middleNameField = new JTextField();
		middleNameField.setBounds(115, 70, 100, 20);
		panel.add(middleNameField);

		JLabel lastNameLabel = new JLabel("Last Name:");
		lastNameLabel.setBounds(20, 120, 100, 20);
		panel.add(lastNameLabel);

		final JTextField lastNameField = new JTextField();
		lastNameField.setBounds(115, 120, 100, 20);
		panel.add(lastNameField);

		JLabel genderLabel = new JLabel("Gender");
		genderLabel.setBounds(20, 170, 100, 20);
		panel.add(genderLabel);

		final JTextField genderField = new JTextField();
		genderField.setBounds(115, 170, 100, 20);
		panel.add(genderField);

		JLabel dateOfBirthLabel = new JLabel("Date of Birth:");
		dateOfBirthLabel.setBounds(20, 220, 100, 20);
		panel.add(dateOfBirthLabel);

		final JTextField dateOfBirthField = new JTextField();
		dateOfBirthField.setBounds(115, 220, 100, 20);
		panel.add(dateOfBirthField);

		JLabel peopleStreetLabel = new JLabel("Street:");
		peopleStreetLabel.setBounds(280, 20, 100, 20);
		panel.add(peopleStreetLabel);

		final JTextField peopleStreetField = new JTextField();
		peopleStreetField.setBounds(330, 20, 100, 20);
		panel.add(peopleStreetField);

		JLabel peopleLocalityLabel = new JLabel("Locality:");
		peopleLocalityLabel.setBounds(280, 70, 100, 20);
		panel.add(peopleLocalityLabel);

		final JTextField peopleLocalityField = new JTextField();
		peopleLocalityField.setBounds(330, 70, 100, 20);
		panel.add(peopleLocalityField);

		JLabel peopleStateLabel = new JLabel("State:");
		peopleStateLabel.setBounds(280, 120, 100, 20);
		panel.add(peopleStateLabel);

		final JTextField peopleStateField = new JTextField();
		peopleStateField.setBounds(330, 120, 100, 20);
		panel.add(peopleStateField);

		JLabel peopleCityLabel = new JLabel("City:");
		peopleCityLabel.setBounds(280, 170, 100, 20);
		panel.add(peopleCityLabel);

		final JTextField peopleCityField = new JTextField();
		peopleCityField.setBounds(330, 170, 100, 20);
		panel.add(peopleCityField);

		JLabel peopleCountryLabel = new JLabel("Country:");
		peopleCountryLabel.setBounds(280, 220, 100, 20);
		panel.add(peopleCountryLabel);

		final JTextField peopleCountryField = new JTextField();
		peopleCountryField.setBounds(330, 220, 100, 20);
		panel.add(peopleCountryField);

		JLabel peopleOtherDetailsLabel = new JLabel("Other Details:");
		peopleOtherDetailsLabel.setBounds(280, 260, 100, 20);
		panel.add(peopleOtherDetailsLabel);

		final JTextArea peopleOtherDetailsTextArea = new JTextArea();
		JScrollPane peopleOtherDetailsScroll = new JScrollPane(
				peopleOtherDetailsTextArea);
		peopleOtherDetailsScroll.setBounds(280, 280, 160, 50);
		panel.add(peopleOtherDetailsScroll);

		/*for (int i = 0; i < PeopleInformationsFrame.peopleTable
				.getColumnCount(); i++) {
			if (i == 1)
				firstNameField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 2)
				middleNameField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 3)
				lastNameField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 4)
				genderField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 5)
				dateOfBirthField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 6) {
				peopleStreetField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			}

			else if (i == 7)
				peopleLocalityField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));

			else if (i == 8)
				peopleStateField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 9)
				peopleCityField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 10)
				peopleCountryField.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
			else if (i == 11)
				peopleOtherDetailsTextArea.setText(""
						+ PeopleInformationsFrame.peopleTable.getValueAt(
								PeopleInformationsFrame.peopleTable
										.getSelectedRow(), i));
		}*/

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.setBounds(20, 370, 80, 25);
		panel.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(120, 370, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(480, 440);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
	
	public void createRolesGUI() throws SQLException {
		JFrame frame = new JFrame("People Roles");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initRolesTable();

		JScrollPane tableScroll = new JScrollPane(rolesTable);
		tableScroll.setBounds(10, 10, 400, 400);

		rolesTable.getColumnModel().getColumn(0).setMinWidth(70);
		rolesTable.getColumnModel().getColumn(0).setMaxWidth(70);
		rolesTable.getColumnModel().getColumn(1).setMinWidth(350);
		rolesTable.getColumnModel().getColumn(1).setMaxWidth(350);
		
		rolesTable.getTableHeader().setReorderingAllowed(false);
		rolesTable.getTableHeader().setResizingAllowed(false);

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
		frame.setSize(440, 500);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void initRolesTable() throws SQLException {
		rolesTable = new JTable(getRolesDataModel()) {
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

	public void updateRolesTable() throws SQLException {
		rolesTable.setModel(getRolesDataModel());
	}

	private DefaultTableModel getRolesDataModel() throws SQLException {
		String selectQuery = "select * from roles ;";

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
	
	public void createWorksGUI() throws SQLException {
		
		JFrame frame = new JFrame("People Works For Organisation");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initWorksForTable();

		JScrollPane tableScroll = new JScrollPane(worksForTable);
		tableScroll.setBounds(10, 10, 400, 400);

		worksForTable.getColumnModel().getColumn(0).setMinWidth(60);
		worksForTable.getColumnModel().getColumn(0).setMaxWidth(60);
		worksForTable.getColumnModel().getColumn(1).setMinWidth(60);
		worksForTable.getColumnModel().getColumn(1).setMaxWidth(60);
		worksForTable.getColumnModel().getColumn(2).setMinWidth(65);
		worksForTable.getColumnModel().getColumn(2).setMaxWidth(65);
		worksForTable.getColumnModel().getColumn(3).setMinWidth(107);
		worksForTable.getColumnModel().getColumn(3).setMaxWidth(107);
		worksForTable.getColumnModel().getColumn(4).setMinWidth(107);
		worksForTable.getColumnModel().getColumn(4).setMaxWidth(107);
		
		worksForTable.getTableHeader().setReorderingAllowed(false);
		worksForTable.getTableHeader().setResizingAllowed(false);

		/*JButton addOutcomesButton = new JButton("ADD");
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
		panel.add(updateOutcomesButton);*/

		panel.add(tableScroll);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(440, 500);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
	
	public void initWorksForTable() throws SQLException {
		worksForTable = new JTable(getWorksForDataModel()) {
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

	public void updateWorksTable() throws SQLException {
		worksForTable.setModel(getWorksForDataModel());
	}

	private DefaultTableModel getWorksForDataModel() throws SQLException {
		String selectQuery = "select * from people_works_for_organisation ;";

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
	
	public void createInEventGUI() throws SQLException {
		
		JFrame frame = new JFrame("People In Event");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initInEventTable();

		JScrollPane tableScroll = new JScrollPane(inEventTable);
		tableScroll.setBounds(10, 10, 400, 400);
		
		inEventTable.getTableHeader().setReorderingAllowed(false);
		inEventTable.getTableHeader().setResizingAllowed(false);

		/*JButton addOutcomesButton = new JButton("ADD");
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
		panel.add(updateOutcomesButton);*/

		panel.add(tableScroll);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(440, 500);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		
	}
	
	public void initInEventTable() throws SQLException {
		inEventTable = new JTable(getInEventDataModel()) {
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

	public void updateInEventTable() throws SQLException {
		inEventTable.setModel(getInEventDataModel());
	}

	private DefaultTableModel getInEventDataModel() throws SQLException {
		String selectQuery = "select * from event_inside_people ;";

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
	
	
}
