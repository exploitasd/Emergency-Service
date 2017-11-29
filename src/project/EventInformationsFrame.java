package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class EventInformationsFrame { // tamam
	public static JTable eventTable;
	JTextField searchField;

	DefaultTableModel model;
	TableRowSorter<TableModel> sorter;
	int i = 0;
	int j;
	char keyChar;
	ArrayList<Character> charList = new ArrayList<Character>();
	String string = "";

	public void createEventGUI() throws SQLException {

		final JFrame eventFrame = new JFrame("Events Details");

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
				eventFrame.setVisible(false);
				new MainMenuFrame().createMainGUI();
			}
		});

		JLabel emptyLabel3 = new JLabel("     ");
		upperPanel.add(emptyLabel3);

		JLabel searchLabel = new JLabel("Search: ");
		upperPanel.add(searchLabel);

		searchField = new JTextField(30);
		upperPanel.add(searchField);

		JLabel infLabel = new JLabel("* Select a column for searching");
		upperPanel.add(infLabel);

		JPanel leftPanel = new JPanel(new GridLayout(15, 1, 3, 3));
		leftPanel.setBackground(Color.LIGHT_GRAY);
		panel.add(leftPanel, BorderLayout.WEST);

		JLabel emptyLabel1 = new JLabel();
		leftPanel.add(emptyLabel1);

		JButton addEventButton = new JButton("ADD EVENT");
		addEventButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(addEventButton);
		addEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventOperations addEventWindow = new EventOperations(
						EventInformationsFrame.this);
				try {
					addEventWindow.createAddEventGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton removeEventButton = new JButton("REMOVE EVENT");
		removeEventButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(removeEventButton);
		removeEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					java.sql.Statement stmt = ConnectionDB.connectDB()
							.createStatement();
					String deleteQuery = "";

					deleteQuery = "DELETE FROM events WHERE Event_ID ='"
							+ EventInformationsFrame.eventTable.getValueAt(
									EventInformationsFrame.eventTable
											.getSelectedRow(), 0) + "'";

					stmt.executeUpdate(deleteQuery);
					updateEventTable();
				} catch (SQLException e1) {
					e1.printStackTrace();
				} catch (ArrayIndexOutOfBoundsException e2) {
					JOptionPane.showMessageDialog(eventFrame,
							"Please select a row for delete.");
				}
			}
		});

		JButton updateEventButton = new JButton("UPDATE EVENT");
		updateEventButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(updateEventButton);
		updateEventButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventOperations updateEventWindow = new EventOperations(
						EventInformationsFrame.this);
				try {
					updateEventWindow.createUpdateEventGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JLabel emptyLabel2 = new JLabel();
		leftPanel.add(emptyLabel2);

		JButton outcomesButton = new JButton("OUTCOMES");
		outcomesButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(outcomesButton);
		outcomesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventOperations outcomesWindow = new EventOperations(
						EventInformationsFrame.this);
				try {
					outcomesWindow.createEventOutcomesGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton statusButton = new JButton("STATUS");
		statusButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(statusButton);
		statusButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventOperations statusWindow = new EventOperations(
						EventInformationsFrame.this);
				try {
					statusWindow.createEventStatusGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		JButton eventTypesButton = new JButton("TYPES");
		eventTypesButton.setBackground(Color.LIGHT_GRAY);
		leftPanel.add(eventTypesButton);
		eventTypesButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				EventOperations eventTypesWindow = new EventOperations(
						EventInformationsFrame.this);
				try {
					eventTypesWindow.createEventTypesGUI();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		initEventTable();

		JScrollPane tableScroll = new JScrollPane(eventTable);

		eventTable.getColumnModel().getColumn(0).setMinWidth(60);
		eventTable.getColumnModel().getColumn(0).setMaxWidth(60);
		eventTable.getColumnModel().getColumn(1).setMinWidth(90);
		eventTable.getColumnModel().getColumn(1).setMaxWidth(90);
		eventTable.getColumnModel().getColumn(2).setMinWidth(100);
		eventTable.getColumnModel().getColumn(2).setMaxWidth(100);
		eventTable.getColumnModel().getColumn(3).setMinWidth(90);
		eventTable.getColumnModel().getColumn(3).setMaxWidth(90);
		eventTable.getColumnModel().getColumn(4).setMinWidth(90);
		eventTable.getColumnModel().getColumn(4).setMaxWidth(90);
		eventTable.getColumnModel().getColumn(5).setMinWidth(80);
		eventTable.getColumnModel().getColumn(5).setMaxWidth(80);
		eventTable.getColumnModel().getColumn(6).setMinWidth(80);
		eventTable.getColumnModel().getColumn(6).setMaxWidth(80);
		eventTable.getColumnModel().getColumn(7).setMinWidth(80);
		eventTable.getColumnModel().getColumn(7).setMaxWidth(80);
		eventTable.getColumnModel().getColumn(8).setMinWidth(80);
		eventTable.getColumnModel().getColumn(8).setMaxWidth(80);
		eventTable.getColumnModel().getColumn(9).setMinWidth(80);
		eventTable.getColumnModel().getColumn(9).setMaxWidth(80);
		eventTable.getColumnModel().getColumn(10).setMinWidth(100);
		eventTable.getColumnModel().getColumn(10).setMaxWidth(100);
		eventTable.getColumnModel().getColumn(11).setMinWidth(100);
		eventTable.getColumnModel().getColumn(11).setMaxWidth(100);
		eventTable.getColumnModel().getColumn(12).setMinWidth(85);
		eventTable.getColumnModel().getColumn(12).setMaxWidth(85);
		eventTable.getColumnModel().getColumn(13).setMinWidth(80);
		eventTable.getColumnModel().getColumn(13).setMaxWidth(80);
		eventTable.getColumnModel().getColumn(14).setMinWidth(70);
		eventTable.getColumnModel().getColumn(14).setMaxWidth(70);

		eventTable.getTableHeader().setReorderingAllowed(false);
		eventTable.getTableHeader().setResizingAllowed(false);

		final JTableHeader header = eventTable.getTableHeader();
		header.setCursor(new Cursor(Cursor.HAND_CURSOR));
		header.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int column = header.columnAtPoint(e.getPoint());
				eventTable.setColumnSelectionAllowed(true);
				eventTable.setRowSelectionAllowed(false);
				eventTable.clearSelection();
				eventTable.setColumnSelectionInterval(column, column);

			}
		});

		eventTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				eventTable.setColumnSelectionAllowed(false);
				eventTable.setRowSelectionAllowed(true);
			}
		});

		panel.add(tableScroll, BorderLayout.CENTER);

		eventFrame.setVisible(true);
		eventFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		eventFrame.setContentPane(panel);
		eventFrame.setResizable(false);
		eventFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void initEventTable() throws SQLException {
		model = getEventDataModel();

		eventTable = new JTable(model) {
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

		sorter = new TableRowSorter<TableModel>(model);
		eventTable.setRowSorter(sorter);

		searchField.addKeyListener(new KeyAdapter() {
			public void keyTyped(KeyEvent ke) {
				keyChar = ke.getKeyChar();

				if (keyChar == KeyEvent.VK_BACK_SPACE) {
					System.out.println("BACKSPACE!");
					charList.remove(charList.size() - 1);
					string = "";
					i = 0;
					while (i < charList.size()) {
						string += "" + charList.get(i);
						i++;
					}

					if (string.length() == 0) {
						sorter.setRowFilter(null);
					} else {
						sorter.setRowFilter(RowFilter.regexFilter(string));
					}
				}

				if (((Character.isLetter(keyChar)) || (Character
						.isWhitespace(keyChar)))
						&& (keyChar != KeyEvent.VK_BACK_SPACE)) {
					charList.add(keyChar);
				}

				while (i < charList.size()) {
					string += "" + charList.get(i);
					i++;
				}

				sorter.setRowFilter(RowFilter.regexFilter(string));
			}
		});
	}

	public void updateEventTable() throws SQLException {
		eventTable.setModel(getEventDataModel());
	}

	private DefaultTableModel getEventDataModel() throws SQLException {
		String selectQuery = "select * from events ;";

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
