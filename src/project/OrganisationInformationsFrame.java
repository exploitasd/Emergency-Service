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

public class OrganisationInformationsFrame {	//tamam
	public static JTable organisationTable;

	public void createOrganisationGUI() throws SQLException {

		final JFrame OrganisationFrame = new JFrame("Organisations Details");

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
				OrganisationFrame.setVisible(false);
				new MainMenuFrame().createMainGUI();
			}
		});

		JLabel emptyLabel3 = new JLabel("     ");
		upperPanel.add(emptyLabel3);

		JLabel searchLabel = new JLabel("Search: ");
		upperPanel.add(searchLabel);

		JTextField searchField = new JTextField(30);
		upperPanel.add(searchField);

		JLabel infLabel = new JLabel("* Select a column for searching");
		upperPanel.add(infLabel);

		JPanel leftPanel = new JPanel(new GridLayout(15, 1, 3, 3));
		leftPanel.setBackground(Color.LIGHT_GRAY);
		panel.add(leftPanel, BorderLayout.WEST);

		JLabel emptyLabel1 = new JLabel();
		leftPanel.add(emptyLabel1);

		JButton addOrganisationButton = new JButton("ADD ORGANISATION");
		addOrganisationButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(addOrganisationButton);
		addOrganisationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrganisationOperations addOrganisationWindow = new OrganisationOperations(
						OrganisationInformationsFrame.this);
				addOrganisationWindow.createAddOrganisationGUI();
			}
		});

		JButton removeOrganisationButton = new JButton("REMOVE ORGANISATION");
		removeOrganisationButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(removeOrganisationButton);
		/*
		 * removeEventButton.addActionListener(new ActionListener() {
		 * 
		 * @Override public void actionPerformed(ActionEvent e) { try {
		 * java.sql.Statement stmt = ConnectionDB.connectDB()
		 * .createStatement(); String deleteQuery = "DELETE FROM events " +
		 * "WHERE event_id = 3";
		 * 
		 * stmt.executeUpdate(deleteQuery); updateEventTable(); } catch
		 * (SQLException e1) { e1.printStackTrace(); } } });
		 */

		JButton updateOrganisationButton = new JButton("UPDATE ORGANISATION");
		updateOrganisationButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(updateOrganisationButton);
		updateOrganisationButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrganisationOperations updateOrganisationWindow = new OrganisationOperations(
						OrganisationInformationsFrame.this);
				updateOrganisationWindow.createUpdateOrganisationGUI();
			}
		});

		JLabel emptyLabel2 = new JLabel();
		leftPanel.add(emptyLabel2);
		
		JButton orgTypesButton = new JButton("TYPES");
		orgTypesButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(orgTypesButton);
		orgTypesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrganisationOperations typesWindow = new OrganisationOperations(
						OrganisationInformationsFrame.this);
				try {
					typesWindow.createOrganisationTypesGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton ownEventButton = new JButton("OWN EVENT");
		ownEventButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(ownEventButton);
		ownEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				OrganisationOperations ownEventWindow = new OrganisationOperations(
						OrganisationInformationsFrame.this);
				try {
					ownEventWindow.createOwnEventGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		initOrganisationTable();

		JScrollPane tableScroll = new JScrollPane(organisationTable);

		organisationTable.getColumnModel().getColumn(0).setMinWidth(50);
		organisationTable.getColumnModel().getColumn(0).setMaxWidth(50);
		organisationTable.getColumnModel().getColumn(1).setMinWidth(100);
		organisationTable.getColumnModel().getColumn(1).setMaxWidth(100);
		organisationTable.getColumnModel().getColumn(2).setMinWidth(100);
		organisationTable.getColumnModel().getColumn(2).setMaxWidth(100);
		organisationTable.getColumnModel().getColumn(3).setMinWidth(80);
		organisationTable.getColumnModel().getColumn(3).setMaxWidth(80);
		organisationTable.getColumnModel().getColumn(4).setMinWidth(80);
		organisationTable.getColumnModel().getColumn(4).setMaxWidth(80);
		organisationTable.getColumnModel().getColumn(5).setMinWidth(80);
		organisationTable.getColumnModel().getColumn(5).setMaxWidth(80);
		organisationTable.getColumnModel().getColumn(6).setMinWidth(80);
		organisationTable.getColumnModel().getColumn(6).setMaxWidth(80);
		organisationTable.getColumnModel().getColumn(7).setMinWidth(80);
		organisationTable.getColumnModel().getColumn(7).setMaxWidth(80);
		organisationTable.getColumnModel().getColumn(8).setMinWidth(193);
		organisationTable.getColumnModel().getColumn(8).setMaxWidth(193);
		organisationTable.getColumnModel().getColumn(9).setMinWidth(193);
		organisationTable.getColumnModel().getColumn(9).setMaxWidth(193);
		organisationTable.getColumnModel().getColumn(10).setMinWidth(80);
		organisationTable.getColumnModel().getColumn(10).setMaxWidth(80);
		organisationTable.getColumnModel().getColumn(11).setMinWidth(90);
		organisationTable.getColumnModel().getColumn(11).setMaxWidth(90);

		organisationTable.getTableHeader().setReorderingAllowed(false);
		organisationTable.getTableHeader().setResizingAllowed(false);

		final JTableHeader header = organisationTable.getTableHeader();
		header.setCursor(new Cursor(Cursor.HAND_CURSOR));
		header.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = header.columnAtPoint(e.getPoint());
				organisationTable.setColumnSelectionAllowed(true);
				organisationTable.setRowSelectionAllowed(false);
				organisationTable.clearSelection();
				organisationTable.setColumnSelectionInterval(column, column);

			}
		});

		organisationTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				organisationTable.setColumnSelectionAllowed(false);
				organisationTable.setRowSelectionAllowed(true);
			}
		});

		panel.add(tableScroll, BorderLayout.CENTER);

		OrganisationFrame.setVisible(true);
		OrganisationFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		OrganisationFrame.setContentPane(panel);
		OrganisationFrame.setResizable(false);
		OrganisationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initOrganisationTable() throws SQLException {
		organisationTable = new JTable(getOrganisationDataModel()) {
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

	public void updateOrganisationTable() throws SQLException {
		organisationTable.setModel(getOrganisationDataModel());
	}

	private DefaultTableModel getOrganisationDataModel() throws SQLException {
		String selectQuery = "select * from organisations ;";

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
