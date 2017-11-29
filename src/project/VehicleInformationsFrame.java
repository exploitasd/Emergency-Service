package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
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
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class VehicleInformationsFrame {	//tamam
	public static JTable vehicleTable;

	public void createVehicleGUI() throws SQLException {

		final JFrame vehicleFrame = new JFrame("Vehicles Details");

		JPanel panel = new JPanel(new BorderLayout(3, 3));
		panel.setBackground(Color.LIGHT_GRAY);

		JPanel upperPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 3, 3));
		upperPanel.setBackground(Color.LIGHT_GRAY);
		panel.add(upperPanel, BorderLayout.NORTH);

		JButton menuButton = new JButton("MAIN MENU");
		menuButton.setBackground(Color.LIGHT_GRAY);
		upperPanel.add(menuButton);
		menuButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				vehicleFrame.setVisible(false);
				new MainMenuFrame().createMainGUI();
			}
		});
		
		JLabel emptyLabel3 = new JLabel("     ");
		upperPanel.add(emptyLabel3);
		
		JLabel searchLabel = new JLabel("Search: ");
		upperPanel.add(searchLabel);
		
		JTextField searchField = new JTextField(20);
		upperPanel.add(searchField);
		
		JLabel infLabel = new JLabel("* Select a column for searching");
		upperPanel.add(infLabel);

		JPanel leftPanel = new JPanel(new GridLayout(15, 1, 3, 3));
		leftPanel.setBackground(Color.LIGHT_GRAY);
		panel.add(leftPanel, BorderLayout.WEST);

		JLabel emptyLabel1 = new JLabel();
		leftPanel.add(emptyLabel1);

		JButton addVehicleButton = new JButton("ADD VEHICLE");
		addVehicleButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(addVehicleButton);
		addVehicleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehicleOperations addVehicleWindow = new VehicleOperations(
						VehicleInformationsFrame.this);
				addVehicleWindow.createAddVehicleGUI();
			}
		});

		JButton removeVehicleButton = new JButton("REMOVE VEHICLE");
		removeVehicleButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(removeVehicleButton);
		/*removeVehicleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					java.sql.Statement stmt = ConnectionDB.connectDB()
							.createStatement();
					String deleteQuery = "DELETE FROM events "
							+ "WHERE event_id = 3";

					stmt.executeUpdate(deleteQuery);
					updateVehicleTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});*/

		JButton updateVehicleButton = new JButton("UPDATE VEHICLE");
		updateVehicleButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(updateVehicleButton);
		updateVehicleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehicleOperations updateVehicleWindow = new VehicleOperations(
						VehicleInformationsFrame.this);
				updateVehicleWindow.createUpdateVehicleGUI();
			}
		});

		JLabel emptyLabel2 = new JLabel();
		leftPanel.add(emptyLabel2);
		
		JButton vehicleTypesButton = new JButton("VEHICLE TYPES");
		vehicleTypesButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(vehicleTypesButton);
		vehicleTypesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehicleOperations vehicleTypesWindow = new VehicleOperations(
						VehicleInformationsFrame.this);
				try {
					vehicleTypesWindow.createVehicleTypesGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton goingEventButton = new JButton("GOING EVENT");
		goingEventButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(goingEventButton);
		goingEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				VehicleOperations goingEventWindow = new VehicleOperations(
						VehicleInformationsFrame.this);
				try {
					goingEventWindow.createGoingEventGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		initVehicleTable();

		JScrollPane tableScroll = new JScrollPane(vehicleTable);

		vehicleTable.getColumnModel().getColumn(0).setMinWidth(60);
		vehicleTable.getColumnModel().getColumn(0).setMaxWidth(60);
		vehicleTable.getColumnModel().getColumn(1).setMinWidth(230);
		vehicleTable.getColumnModel().getColumn(1).setMaxWidth(230);
		 
		vehicleTable.getTableHeader().setReorderingAllowed(false);
		vehicleTable.getTableHeader().setResizingAllowed(false);
		
		final JTableHeader header = vehicleTable.getTableHeader();
		header.setCursor(new Cursor(Cursor.HAND_CURSOR));
		header.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = header.columnAtPoint(e.getPoint());
				vehicleTable.setColumnSelectionAllowed(true);
				vehicleTable.setRowSelectionAllowed(false);
				vehicleTable.clearSelection();
				vehicleTable.setColumnSelectionInterval(column, column);

			}
		});
		
		vehicleTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				vehicleTable.setColumnSelectionAllowed(false);
				vehicleTable.setRowSelectionAllowed(true);			
			}
		});
	
		panel.add(tableScroll, BorderLayout.CENTER);

		vehicleFrame.setVisible(true);
		vehicleFrame.setSize(400, 500);
		vehicleFrame.setLocation(500, 100);
		vehicleFrame.setContentPane(panel);
		vehicleFrame.setResizable(false);
		vehicleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initVehicleTable() throws SQLException {
		vehicleTable = new JTable(getVehicleDataModel()) {
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

	public void updateVehicleTable() throws SQLException {
		vehicleTable.setModel(getVehicleDataModel());
	}

	private DefaultTableModel getVehicleDataModel() throws SQLException {
		String selectQuery = "select * from vehicles ;";

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
