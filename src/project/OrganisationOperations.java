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

public class OrganisationOperations {	//tamam
	JTable orgTypesTable;
	JTable ownEventTable;

	private OrganisationInformationsFrame parentFrame;

	public OrganisationOperations(OrganisationInformationsFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void createAddOrganisationGUI() {

		final JFrame frame = new JFrame("Add Organisation");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel organisationNameLabel = new JLabel("Organisation Name:");
		organisationNameLabel.setBounds(20, 20, 100, 20);
		panel.add(organisationNameLabel);

		final JTextField organisationNameField = new JTextField();
		organisationNameField.setBounds(125, 20, 100, 20);
		panel.add(organisationNameField);

		JLabel orgPhoneLabel = new JLabel("Organisation Phone:");
		orgPhoneLabel.setBounds(20, 70, 100, 20);
		panel.add(orgPhoneLabel);

		final JTextField orgPhoneField = new JTextField();
		orgPhoneField.setBounds(125, 70, 100, 20);
		panel.add(orgPhoneField);

		JLabel orgStreetLabel = new JLabel("Street:");
		orgStreetLabel.setBounds(20, 120, 100, 20);
		panel.add(orgStreetLabel);

		final JTextField orgStreetField = new JTextField();
		orgStreetField.setBounds(125, 120, 100, 20);
		panel.add(orgStreetField);

		JLabel orgLocalityLabel = new JLabel("Locality:");
		orgLocalityLabel.setBounds(20, 170, 100, 20);
		panel.add(orgLocalityLabel);

		final JTextField orgLocalityField = new JTextField();
		orgLocalityField.setBounds(125, 170, 100, 20);
		panel.add(orgLocalityField);

		JLabel orgStateLabel = new JLabel("State:");
		orgStateLabel.setBounds(20, 220, 100, 20);
		panel.add(orgStateLabel);

		final JTextField orgStateField = new JTextField();
		orgStateField.setBounds(125, 220, 100, 20);
		panel.add(orgStateField);

		JLabel orgCityLabel = new JLabel("City:");
		orgCityLabel.setBounds(20, 270, 100, 20);
		panel.add(orgCityLabel);

		final JTextField orgCityField = new JTextField();
		orgCityField.setBounds(125, 270, 100, 20);
		panel.add(orgCityField);

		JLabel orgCountryLabel = new JLabel("Country:");
		orgCountryLabel.setBounds(20, 320, 100, 20);
		panel.add(orgCountryLabel);

		final JTextField orgCountryField = new JTextField();
		orgCountryField.setBounds(125, 320, 100, 20);
		panel.add(orgCountryField);

		JLabel superOrgIDLabel = new JLabel("Super Org ID:");
		superOrgIDLabel.setBounds(265, 20, 100, 20);
		panel.add(superOrgIDLabel);

		final JTextField superOrgIDField = new JTextField();
		superOrgIDField.setBounds(355, 20, 100, 20);
		panel.add(superOrgIDField);

		JLabel orgTypeCodeLabel = new JLabel("Org Type Code:");
		orgTypeCodeLabel.setBounds(265, 70, 100, 20);
		panel.add(orgTypeCodeLabel);

		final JTextField orgTypeCodeField = new JTextField();
		orgTypeCodeField.setBounds(355, 70, 100, 20);
		panel.add(orgTypeCodeField);

		JLabel orgDescLabel = new JLabel("Organisation Description:");
		orgDescLabel.setBounds(265, 120, 150, 20);
		panel.add(orgDescLabel);

		final JTextArea orgDescTextArea = new JTextArea();
		JScrollPane orgDescScroll = new JScrollPane(orgDescTextArea);
		orgDescScroll.setBounds(265, 140, 160, 50);
		panel.add(orgDescScroll);

		JLabel orgOtherDetailsLabel = new JLabel("Other Details:");
		orgOtherDetailsLabel.setBounds(265, 220, 100, 20);
		panel.add(orgOtherDetailsLabel);

		final JTextArea orgOtherDetailsTextArea = new JTextArea();
		JScrollPane orgOtherDetailsScroll = new JScrollPane(
				orgOtherDetailsTextArea);
		orgOtherDetailsScroll.setBounds(265, 240, 160, 50);
		panel.add(orgOtherDetailsScroll);

		JButton addButton = new JButton("ADD");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(100, 380, 80, 25);
		panel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * try { java.sql.Statement stmt = ConnectionDB.connectDB()
				 * .createStatement(); String sql; sql = "INSERT INTO events " +
				 * "VALUES (3, 'crime at 312', '2011-03-11', '2011-03-12', 'not found', 'street 7', 'locality13', 'istanbul', 'turkiye', '0 death', 'other details33', '115', '120', '300')"
				 * ;
				 * 
				 * 
				 * sql = "INSERT INTO events VALUES(" + eventIDField.getText() +
				 * "," + "'" + eventNameField.getText() + "'";
				 * 
				 * stmt.executeUpdate(sql);
				 * parentFrame.updateOrganisationTable(); } catch (SQLException
				 * e1) { e1.printStackTrace(); }
				 */
			}
		});

		JButton clearButton = new JButton("CLEAR");
		clearButton.setBackground(Color.LIGHT_GRAY);
		clearButton.setBounds(200, 380, 80, 25);
		panel.add(clearButton);
		clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				organisationNameField.setText(null);
				orgPhoneField.setText(null);
				orgStreetField.setText(null);
				orgLocalityField.setText(null);
				orgStateField.setText(null);
				orgCityField.setText(null);
				orgCountryField.setText(null);
				superOrgIDField.setText(null);
				orgTypeCodeField.setText(null);
				orgDescTextArea.setText(null);
				orgOtherDetailsTextArea.setText(null);
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(300, 380, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(480, 450);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void createUpdateOrganisationGUI() {

		final JFrame frame = new JFrame("Update Organisation");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel organisationNameLabel = new JLabel("Organisation Name:");
		organisationNameLabel.setBounds(20, 20, 100, 20);
		panel.add(organisationNameLabel);

		final JTextField organisationNameField = new JTextField();
		organisationNameField.setBounds(125, 20, 100, 20);
		panel.add(organisationNameField);

		JLabel orgPhoneLabel = new JLabel("Organisation Phone:");
		orgPhoneLabel.setBounds(20, 70, 100, 20);
		panel.add(orgPhoneLabel);

		final JTextField orgPhoneField = new JTextField();
		orgPhoneField.setBounds(125, 70, 100, 20);
		panel.add(orgPhoneField);

		JLabel orgStreetLabel = new JLabel("Street:");
		orgStreetLabel.setBounds(20, 120, 100, 20);
		panel.add(orgStreetLabel);

		final JTextField orgStreetField = new JTextField();
		orgStreetField.setBounds(125, 120, 100, 20);
		panel.add(orgStreetField);

		JLabel orgLocalityLabel = new JLabel("Locality:");
		orgLocalityLabel.setBounds(20, 170, 100, 20);
		panel.add(orgLocalityLabel);

		final JTextField orgLocalityField = new JTextField();
		orgLocalityField.setBounds(125, 170, 100, 20);
		panel.add(orgLocalityField);

		JLabel orgStateLabel = new JLabel("State:");
		orgStateLabel.setBounds(20, 220, 100, 20);
		panel.add(orgStateLabel);

		final JTextField orgStateField = new JTextField();
		orgStateField.setBounds(125, 220, 100, 20);
		panel.add(orgStateField);

		JLabel orgCityLabel = new JLabel("City:");
		orgCityLabel.setBounds(20, 270, 100, 20);
		panel.add(orgCityLabel);

		final JTextField orgCityField = new JTextField();
		orgCityField.setBounds(125, 270, 100, 20);
		panel.add(orgCityField);

		JLabel orgCountryLabel = new JLabel("Country:");
		orgCountryLabel.setBounds(20, 320, 100, 20);
		panel.add(orgCountryLabel);

		final JTextField orgCountryField = new JTextField();
		orgCountryField.setBounds(125, 320, 100, 20);
		panel.add(orgCountryField);

		JLabel superOrgIDLabel = new JLabel("Super Org ID:");
		superOrgIDLabel.setBounds(265, 20, 100, 20);
		panel.add(superOrgIDLabel);

		final JTextField superOrgIDField = new JTextField();
		superOrgIDField.setBounds(355, 20, 100, 20);
		panel.add(superOrgIDField);

		JLabel orgTypeCodeLabel = new JLabel("Org Type Code:");
		orgTypeCodeLabel.setBounds(265, 70, 100, 20);
		panel.add(orgTypeCodeLabel);

		final JTextField orgTypeCodeField = new JTextField();
		orgTypeCodeField.setBounds(355, 70, 100, 20);
		panel.add(orgTypeCodeField);

		JLabel orgDescLabel = new JLabel("Organisation Description:");
		orgDescLabel.setBounds(265, 120, 150, 20);
		panel.add(orgDescLabel);

		final JTextArea orgDescTextArea = new JTextArea();
		JScrollPane orgDescScroll = new JScrollPane(orgDescTextArea);
		orgDescScroll.setBounds(265, 140, 160, 50);
		panel.add(orgDescScroll);

		JLabel orgOtherDetailsLabel = new JLabel("Other Details:");
		orgOtherDetailsLabel.setBounds(265, 220, 100, 20);
		panel.add(orgOtherDetailsLabel);

		final JTextArea orgOtherDetailsTextArea = new JTextArea();
		JScrollPane orgOtherDetailsScroll = new JScrollPane(
				orgOtherDetailsTextArea);
		orgOtherDetailsScroll.setBounds(265, 240, 160, 50);
		panel.add(orgOtherDetailsScroll);

		/*for (int i = 0; i < OrganisationInformationsFrame.organisationTable
				.getColumnCount(); i++) {
			if (i == 1)
				organisationNameField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 2)
				orgPhoneField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 3)
				orgStreetField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 4)
				orgLocalityField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 5)
				orgStateField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 6)
				orgCityField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 7)
				orgCountryField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));

			else if (i == 8)
				superOrgIDField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 9)
				orgTypeCodeField
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 10)
				orgDescTextArea
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));
			else if (i == 11)
				orgOtherDetailsTextArea
						.setText(""
								+ OrganisationInformationsFrame.organisationTable
										.getValueAt(
												OrganisationInformationsFrame.organisationTable
														.getSelectedRow(), i));

		}*/

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBackground(Color.LIGHT_GRAY);
		updateButton.setBounds(20, 380, 80, 25);
		panel.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(120, 380, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(480, 450);
		frame.setLocation(430, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
	public void createOrganisationTypesGUI() throws SQLException{
		JFrame frame = new JFrame("Organisations Types");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initOrgTypesTable();

		JScrollPane tableScroll = new JScrollPane(orgTypesTable);
		tableScroll.setBounds(10, 10, 400, 400);

		orgTypesTable.getColumnModel().getColumn(0).setMinWidth(100);
		orgTypesTable.getColumnModel().getColumn(0).setMaxWidth(100);
		orgTypesTable.getColumnModel().getColumn(1).setMinWidth(350);
		orgTypesTable.getColumnModel().getColumn(1).setMaxWidth(350);
		
		orgTypesTable.getTableHeader().setReorderingAllowed(false);
		orgTypesTable.getTableHeader().setResizingAllowed(false);

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
	
	public void initOrgTypesTable() throws SQLException {
		orgTypesTable = new JTable(getOrgTypesDataModel()) {
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

	public void updateOrgTypesTable() throws SQLException {
		orgTypesTable.setModel(getOrgTypesDataModel());
	}

	private DefaultTableModel getOrgTypesDataModel() throws SQLException {
		String selectQuery = "select * from organisation_types ;";

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
	
	public void createOwnEventGUI() throws SQLException {
		JFrame frame = new JFrame("Organisation Own Event");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initOwnEventTable();

		JScrollPane tableScroll = new JScrollPane(ownEventTable);
		tableScroll.setBounds(10, 10, 400, 400);
		
		ownEventTable.getTableHeader().setReorderingAllowed(false);
		ownEventTable.getTableHeader().setResizingAllowed(false);

		/*JButton addTypesButton = new JButton("ADD");
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
		panel.add(updateTypesButton);*/

		panel.add(tableScroll);

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(440, 510);
		frame.setLocation(470, 100);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
	}
	
	public void initOwnEventTable() throws SQLException {
		ownEventTable = new JTable(getOwnEventDataModel()) {
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

	public void updateOwnEventTable() throws SQLException {
		ownEventTable.setModel(getOwnEventDataModel());
	}

	private DefaultTableModel getOwnEventDataModel() throws SQLException {
		String selectQuery = "select * from event_own_organisation ;";

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
