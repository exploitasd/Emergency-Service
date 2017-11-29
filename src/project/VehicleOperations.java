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

public class VehicleOperations {
	JTable vehicleTypesTable;
	JTable goingEventTable;

	private VehicleInformationsFrame parentFrame;

	public VehicleOperations(VehicleInformationsFrame parentFrame) {
		this.parentFrame = parentFrame;
	}

	public void createAddVehicleGUI() {

		final JFrame frame = new JFrame("Add Vehicle");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel vehicleTypeCodeLabel = new JLabel("Vehicle Type Code:");
		vehicleTypeCodeLabel.setBounds(20, 20, 100, 20);
		panel.add(vehicleTypeCodeLabel);

		final JTextField vehicleTypeCodeField = new JTextField();
		vehicleTypeCodeField.setBounds(125, 20, 100, 20);
		panel.add(vehicleTypeCodeField);

		JButton addButton = new JButton("ADD");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(20, 70, 80, 25);
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
		 * stmt1.executeUpdate(sql); parentFrame.updateVehicleTable(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } } });
		 */

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(120, 70, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(300, 140);
		frame.setLocation(510, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	public void createUpdateVehicleGUI() {
		final JFrame frame = new JFrame("Update Vehicle");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		JLabel vehicleTypeCodeLabel = new JLabel("Vehicle Type Code:");
		vehicleTypeCodeLabel.setBounds(20, 20, 100, 20);
		panel.add(vehicleTypeCodeLabel);

		final JTextField vehicleTypeCodeField = new JTextField();
		vehicleTypeCodeField.setBounds(125, 20, 100, 20);
		panel.add(vehicleTypeCodeField);

		/*for (int i = 0; i < VehicleInformationsFrame.vehicleTable
				.getColumnCount(); i++) {

			if (i == 1)
				vehicleTypeCodeField.setText(""
						+ VehicleInformationsFrame.vehicleTable.getValueAt(
								VehicleInformationsFrame.vehicleTable
										.getSelectedRow(), i));

		}*/

		JButton addButton = new JButton("UPDATE");
		addButton.setBackground(Color.LIGHT_GRAY);
		addButton.setBounds(20, 70, 80, 25);
		panel.add(addButton);
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
		});

		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setBackground(Color.LIGHT_GRAY);
		cancelButton.setBounds(120, 70, 80, 25);
		panel.add(cancelButton);
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});

		frame.add(panel);
		frame.setVisible(true);
		frame.setSize(300, 140);
		frame.setLocation(510, 250);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}

	public void createVehicleTypesGUI() throws SQLException{
		JFrame frame = new JFrame("Vehicle Types");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initVehicleTypesTable();

		JScrollPane tableScroll = new JScrollPane(vehicleTypesTable);
		tableScroll.setBounds(10, 10, 400, 400);
		
		vehicleTypesTable.getColumnModel().getColumn(0).setMinWidth(110);
		vehicleTypesTable.getColumnModel().getColumn(0).setMaxWidth(110);
		vehicleTypesTable.getColumnModel().getColumn(1).setMinWidth(350);
		vehicleTypesTable.getColumnModel().getColumn(1).setMaxWidth(350);

		vehicleTypesTable.getTableHeader().setReorderingAllowed(false);
		vehicleTypesTable.getTableHeader().setResizingAllowed(false);

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
	
	public void initVehicleTypesTable() throws SQLException {
		vehicleTypesTable = new JTable(getVehicleTypesDataModel()) {
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

	public void updateVehicleTypesTable() throws SQLException {
		vehicleTypesTable.setModel(getVehicleTypesDataModel());
	}

	private DefaultTableModel getVehicleTypesDataModel() throws SQLException {
		String selectQuery = "select * from vehicle_types ;";

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
	
	public void createGoingEventGUI() throws SQLException {
		JFrame frame = new JFrame("Vehicle Going Event");

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setLayout(null);

		initGoingEventTable();

		JScrollPane tableScroll = new JScrollPane(goingEventTable);
		tableScroll.setBounds(10, 10, 400, 400);

		goingEventTable.getTableHeader().setReorderingAllowed(false);
		goingEventTable.getTableHeader().setResizingAllowed(false);

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
	
	public void initGoingEventTable() throws SQLException {
		goingEventTable = new JTable(getGoingEventDataModel()) {
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

	public void updateGoingEventTable() throws SQLException {
		goingEventTable.setModel(getGoingEventDataModel());
	}

	private DefaultTableModel getGoingEventDataModel() throws SQLException {
		String selectQuery = "select * from event_have_vehicles ;";

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
