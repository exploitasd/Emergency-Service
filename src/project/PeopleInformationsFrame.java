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

public class PeopleInformationsFrame {	//tamam
	public static JTable peopleTable;

	public void createPeopleGUI() throws SQLException {

		final JFrame peopleFrame = new JFrame("People Details");

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
				peopleFrame.setVisible(false);
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

		JButton addPeopleButton = new JButton("ADD PEOPLE");
		addPeopleButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(addPeopleButton);
		addPeopleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleOperations addPeopleWindow = new PeopleOperations(
						PeopleInformationsFrame.this);
				addPeopleWindow.createAddPeopleGUI();
			}
		});

		JButton removePeopleButton = new JButton("REMOVE PEOPLE");
		removePeopleButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(removePeopleButton);
		removePeopleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				/*
				 * try { java.sql.Statement stmt = ConnectionDB.connectDB()
				 * .createStatement(); String deleteQuery =
				 * "DELETE FROM events " + "WHERE event_id = 3";
				 * 
				 * stmt.executeUpdate(deleteQuery); updatePeopleTable(); } catch
				 * (SQLException e1) { e1.printStackTrace(); }
				 */
			}
		});

		JButton updatePeopleButton = new JButton("UPDATE PEOPLE");
		updatePeopleButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(updatePeopleButton);
		updatePeopleButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleOperations updatePeopleWindow = new PeopleOperations(
						PeopleInformationsFrame.this);
				updatePeopleWindow.createUpdatePeopleGUI();
			}
		});

		JLabel emptyLabel2 = new JLabel();
		leftPanel.add(emptyLabel2);
		
		JButton rolesButton = new JButton("ROLES");
		rolesButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(rolesButton);
		rolesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleOperations rolesWindow = new PeopleOperations(
						PeopleInformationsFrame.this);
				try {
					rolesWindow.createRolesGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton worksButton = new JButton("WORKS FOR");
		worksButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(worksButton);
		worksButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleOperations worksWindow = new PeopleOperations(
						PeopleInformationsFrame.this);
				try {
					worksWindow.createWorksGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton inEventButton = new JButton("IN EVENT");
		inEventButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(inEventButton);
		inEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PeopleOperations inEventWindow = new PeopleOperations(
						PeopleInformationsFrame.this);
				try {
					inEventWindow.createInEventGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		initPeopleTable();

		JScrollPane tableScroll = new JScrollPane(peopleTable);

		peopleTable.getColumnModel().getColumn(0).setMinWidth(60);
		peopleTable.getColumnModel().getColumn(0).setMaxWidth(60);
		peopleTable.getColumnModel().getColumn(1).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(1).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(2).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(2).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(3).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(3).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(4).setMinWidth(50);
		peopleTable.getColumnModel().getColumn(4).setMaxWidth(50);
		peopleTable.getColumnModel().getColumn(5).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(5).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(6).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(6).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(7).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(7).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(8).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(8).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(9).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(9).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(10).setMinWidth(100);
		peopleTable.getColumnModel().getColumn(10).setMaxWidth(100);
		peopleTable.getColumnModel().getColumn(11).setMinWidth(250);
		peopleTable.getColumnModel().getColumn(11).setMaxWidth(250);

		peopleTable.getTableHeader().setReorderingAllowed(false);
		peopleTable.getTableHeader().setResizingAllowed(false);

		final JTableHeader header = peopleTable.getTableHeader();
		header.setCursor(new Cursor(Cursor.HAND_CURSOR));
		header.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = header.columnAtPoint(e.getPoint());
				peopleTable.setColumnSelectionAllowed(true);
				peopleTable.setRowSelectionAllowed(false);
				peopleTable.clearSelection();
				peopleTable.setColumnSelectionInterval(column, column);

			}
		});

		peopleTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				peopleTable.setColumnSelectionAllowed(false);
				peopleTable.setRowSelectionAllowed(true);
			}
		});

		panel.add(tableScroll, BorderLayout.CENTER);

		peopleFrame.setVisible(true);
		peopleFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		peopleFrame.setContentPane(panel);
		peopleFrame.setResizable(false);
		peopleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initPeopleTable() throws SQLException {
		peopleTable = new JTable(getPeopleDataModel()) {
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

	public void updatePeopleTable() throws SQLException {
		peopleTable.setModel(getPeopleDataModel());
	}

	private DefaultTableModel getPeopleDataModel() throws SQLException {
		String selectQuery = "select * from people ;";

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
